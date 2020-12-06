package com.weswaas.bungeeapi.command;

import com.weswaas.bungeeapi.API;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Created by Weswas on 08/01/2017.
 */
public class MOTDCommand extends Command{

    public MOTDCommand() {
        super("motd", "motd.edit");
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof ProxiedPlayer){
            ProxiedPlayer p = (ProxiedPlayer)sender;
            if(p.hasPermission("motd.edit")){
                if(args.length > 0){
                    StringBuilder list = new StringBuilder("");

                    for(String s : args){
                        if(s == args[args.length - 1]){
                            list.append(s);
                        }else{
                            list.append(s + " ");
                        }
                    }

                    String end = list.toString().trim();
                    API.getInstance().getMOTDManager().setDescription(end);
                    p.sendMessage("§3Successfully changed MOTD to: " + end);

                }else{
                    p.sendMessage("§cUsage: /motd <motd>");
                }
            }
        }
    }
}
