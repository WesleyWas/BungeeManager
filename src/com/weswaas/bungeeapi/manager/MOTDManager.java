package com.weswaas.bungeeapi.manager;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

/**
 * Created by Weswas on 08/01/2017.
 */
public class MOTDManager implements Listener{

    private String description;

    @EventHandler
    public void on(ProxyPingEvent e){
        ServerPing ping = e.getResponse();
        ping.setDescription(this.description);
        e.setResponse(ping);
    }

    public void setDescription(String description){
        this.description = description;
    }

}
