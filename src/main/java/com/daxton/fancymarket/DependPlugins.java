package com.daxton.fancymarket;


import com.daxton.fancymarket.config.FileConfig;
import org.bukkit.Bukkit;

import static com.daxton.fancymarket.config.FileConfig.languageConfig;

public class DependPlugins {

    public static boolean depend(){

        FancyMarket fancyMarket = FancyMarket.fancyMarket;

        if (Bukkit.getServer().getPluginManager().getPlugin("FancyCore") != null && Bukkit.getPluginManager().isPluginEnabled("FancyCore")){
            //設定檔
            FileConfig.execute();
            fancyMarket.getLogger().info(languageConfig.getString("LogMessage.LoadFancyCore"));
        }else {
            fancyMarket.getLogger().severe("*** FancyCore is not installed or not enabled. ***");
            fancyMarket.getLogger().severe("*** FancyMarket will be disabled. ***");
            return false;
        }

        return true;
    }

}
