package com.example.zhangqiang.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.zhangqiang.myapplication.volleyUtils.MyVolleyRequest;
import com.example.zhangqiang.myapplication.volleyUtils.VolleyUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getString(R.string.test);

        //VolleyUtils.getInstance().volleyStringRequestDemo_GET();
        //VolleyUtils.getInstance().volleyJsonObjectRequestDemo_GET();
        //VolleyUtils.getInstance().volleyStringRequestDome_POST();
        //VolleyUtils.getInstance().volleyJsonObjectRequestDome_POST();

        //VolleyUtils.getInstance().myVolleyRequestDemo_GET();
        //VolleyUtils.getInstance().myVolleyRequestDemo_POST();
        VolleyUtils.getInstance().myRequest_GET();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        VolleyApplication.getRequestQueue().cancelAll(VolleyUtils.VOLLEY_TAG);
        Log.i("### onStop", "cancel all:tag=" + VolleyUtils.VOLLEY_TAG);
    }
}
