package com.yey.library_restartapp;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;

import androidx.annotation.Nullable;

public class YeyKillAppService extends IntentService {
    /**
     * 关闭应用后多久重新启动
     */
    private static long stopDelayed = 50;
    private Handler handler;
    private String PackageName;


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param YeyKillAppService Used to name the worker thread, important only for debugging.
     */
    public YeyKillAppService() {
        super("YeyKillAppService");
        handler = new Handler();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        stopDelayed = intent.getLongExtra("Delayed", 50);
        PackageName = intent.getStringExtra("PackageName");
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent LaunchIntent = getPackageManager().getLaunchIntentForPackage(PackageName);
                startActivity(LaunchIntent);
//                YeyKillAppService.this.stopSelf();
                //杀死自己当前进程, 当前进程专门用来启动APP的,启动完就主动杀掉.
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        }, stopDelayed);
    }
}
