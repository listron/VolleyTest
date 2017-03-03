package com.example.zhangqiang.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhangqiang.myapplication.volleyUtils.MyVolleyRequest;
import com.example.zhangqiang.myapplication.volleyUtils.VolleyUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a();
        VolleyUtils.getInstance().volleyStringRequestDemo_GET();
        VolleyUtils.getInstance().volleyJsonObjectRequestDemo_GET();
        VolleyUtils.getInstance().volleyStringRequestDome_POST();
        VolleyUtils.getInstance().volleyJsonObjectRequestDome_POST();

        VolleyUtils.getInstance().myVolleyRequestDemo_GET();
        VolleyUtils.getInstance().myVolleyRequestDemo_POST();
    }
    public void a(){

    }

}
