package com.daxton.fancymarket.task;

import com.daxton.fancymarket.config.FileConfig;

public class Reload {
    //重新讀取的一些任務
    public static void execute(){
        //設定檔
        FileConfig.reload();

    }

}
