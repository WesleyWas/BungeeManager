package com.weswaas.bungeeapi;

import com.weswaas.bungeeapi.command.ChatCommand;
import com.weswaas.bungeeapi.command.MOTDCommand;
import com.weswaas.bungeeapi.listeners.KickListener;
import com.weswaas.bungeeapi.manager.AlertManager;
import com.weswaas.bungeeapi.manager.MOTDManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;

public class API extends Plugin{
	
	private static API instance;

	private AlertManager alert;
    private MOTDManager motd;
	
	@Override
	public void onEnable() {
		instances();
		
		registerCmds();
		alert.registerAlerts();
		alert.run();
		ProxyServer.getInstance().getPluginManager().registerListener(this, motd);
		ProxyServer.getInstance().getPluginManager().registerListener(this, new KickListener());

		getMOTDManager().setDescription("§8» §b" + ChatColor.BOLD + "Oniziac Network " + ChatColor.RESET + "§8» §71.7 & 1.8 UHC Games\n" + ChatColor.RESET + "§8» §3Hiring §bBETA TESTERS §3for our §bPRACTICE");

	}
	
	public static API getInstance(){
		return instance;
	}

	private void instances(){
		instance = this;
		alert = new AlertManager();
        motd = new MOTDManager();
	}
	
	private void registerCmds(){
		PluginManager pm = ProxyServer.getInstance().getPluginManager();
		
		pm.registerCommand(this, new ChatCommand());
        pm.registerCommand(this, new MOTDCommand());
		
	}

	public MOTDManager getMOTDManager(){
        return this.motd;
    }

}
