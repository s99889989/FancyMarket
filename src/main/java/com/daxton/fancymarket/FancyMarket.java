package com.daxton.fancymarket;

import com.daxton.fancymarket.command.MainCommand;
import com.daxton.fancymarket.command.TabCommand;
import com.daxton.fancymarket.listener.PlayerListener;
import com.daxton.fancymarket.task.Start;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class FancyMarket extends JavaPlugin {

	public static FancyMarket fancyMarket;

	@Override
	public void onEnable() {
		fancyMarket = this;
		//前置插件
		if(!DependPlugins.depend()){
			fancyMarket.setEnabled(false);
			return;
		}
		//指令
		Objects.requireNonNull(Bukkit.getPluginCommand("fancymarket")).setExecutor(new MainCommand());
		Objects.requireNonNull(Bukkit.getPluginCommand("fancymarket")).setTabCompleter(new TabCommand());
		//玩家監聽
		Bukkit.getPluginManager().registerEvents(new PlayerListener(), fancyMarket);
		//執行任務
		Start.execute();
	}

	@Override
	public void onDisable() {
		FancyMarket.fancyMarket.getLogger().info("§4FancyMarket uninstall.");
	}
}
