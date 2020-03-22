package com.yey.library_restartapp;

import android.content.Context;
import android.content.Intent;

public class YRestartAPP {

    /**
     * 重启整个APP
     * @param context
     * @param Delayed 延迟多少毫秒
     */
    public static void restartAPP(Context context, long Delayed){

        /**开启一个新的服务，用来重启本APP*/
        Intent intent=new Intent(context, YeyKillAppService.class);
        intent.putExtra("PackageName",context.getPackageName());
        intent.putExtra("Delayed",Delayed);
        context.startService(intent);

        /**杀死整个进程**/
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
