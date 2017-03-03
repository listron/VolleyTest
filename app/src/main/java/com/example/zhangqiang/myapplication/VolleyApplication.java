package com.example.zhangqiang.myapplication;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by zhangqiang on 17/3/2.
 */

public class VolleyApplication extends Application {
    //Volley的全局请求队列
    public static RequestQueue sRequestQueue;

    /**
     * @return Volley全局请求队列
     */
    public static RequestQueue getRequestQueue() {
        return sRequestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //实例化Volley全局请求队列
        sRequestQueue = Volley.newRequestQueue(getApplicationContext());
    }
}
