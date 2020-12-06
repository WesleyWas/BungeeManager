package com.weswaas.bungeeapi.manager;

import com.weswaas.bungeeapi.API;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Weswas on 05/11/2016.
 */
public class AlertManager {

    private List<String> alerts;

    public AlertManager(){
        this.alerts = new ArrayList<>();
    }

    public void run(){
        API.getInstance().getProxy().getScheduler().schedule(API.getInstance(), new Runnable() {
            @Override
            public void run() {
                Random r = new Random();
                int rand = r.nextInt(alerts.size());
                String say = alerts.get(rand);
                API.getInstance().getProxy().broadcast(new TextComponent("  "));
                API.getInstance().getProxy().broadcast(new TextComponent(ChatColor.DARK_GRAY + "[" + ChatColor.RED + "Alert" + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " " + ChatColor.WHITE + say));
                API.getInstance().getProxy().broadcast(new TextComponent("  "));
            }
        }, 0, 10, TimeUnit.MINUTES);
    }

    public void registerAlerts(){
        this.alerts.add("Follow us on Twitter : https://twitter.com/oniziac");
        this.alerts.add("As we mostly finished our Training Server, we're looking for Beta Testers to find out all the bugs ! You can ask us In-Game or on Discord to get the BetaTester Rank and get an exclusive access to our future Practice.");
    }

}
