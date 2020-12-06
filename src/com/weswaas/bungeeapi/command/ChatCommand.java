package com.weswaas.bungeeapi.command;

import com.weswaas.bungeeapi.API;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class ChatCommand extends Command{

	public ChatCommand() {
		super("mc", "mc.use");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if(sender instanceof ProxiedPlayer){
			ProxiedPlayer p = (ProxiedPlayer) sender;
			if(p.hasPermission("mc.use")){
				if(args.length >= 1){
					
					StringBuilder list = new StringBuilder("");
					for(String s : args){
						list.append(s+" ");
					}

					ChatColor grey = ChatColor.DARK_GRAY;
					ChatColor light = ChatColor.GRAY;
					ChatColor gold = ChatColor.YELLOW;
					ChatColor green = ChatColor.GREEN;
					ChatColor purple = ChatColor.DARK_PURPLE;
					
					for(ProxiedPlayer pls : BungeeCord.getInstance().getPlayers()){
						pls.sendMessage(new TextComponent(grey + "[" + green + "MC" + grey + "]" + "[" + gold + API.getInstance().getProxy().getPlayer(p.getName()).getServer().getInfo().getName().toUpperCase() + grey + "]" + "[" + purple + p.getName() + grey + "]" + light + " » " + ChatColor.WHITE + list.toString().trim()));
					}
					
				}else{
					p.sendMessage(new TextComponent("�cInvalid synthax. Please try with /mc <message>"));
				}
			}
		}
	}

}
