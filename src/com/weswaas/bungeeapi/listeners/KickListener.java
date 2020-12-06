package com.weswaas.bungeeapi.listeners;

import com.weswaas.bungeeapi.API;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.util.concurrent.TimeUnit;

/**
 * Created by Weswas on 20/04/2020.
 */
public class KickListener implements Listener{

    @EventHandler
    public void onKick(final ServerKickEvent event) {
        final ProxiedPlayer p = event.getPlayer();
        if (event.getPlayer().getServer() != null) {
            if (!event.getPlayer().getServer().getInfo().getName().equalsIgnoreCase("hub")) {
                event.setCancelled(true);
                final API instance = API.getInstance();
                instance.getProxy().getScheduler().schedule(instance, new Runnable() {
                    @Override
                    public void run() {
                        p.connect(instance.getProxy().getServerInfo("hub"));
                        p.sendMessage(new TextComponent(ChatColor.RED + "Disconnected: " + ChatColor.RESET + event.getKickReason()));
                    }
                }, 1l, TimeUnit.MICROSECONDS);
            }
        }
    }

}
