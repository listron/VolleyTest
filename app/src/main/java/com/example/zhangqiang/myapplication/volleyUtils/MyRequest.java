package com.example.zhangqiang.myapplication.volleyUtils;

import com.alibaba.fastjson.JSON;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.example.zhangqiang.myapplication.mode.HttpResponse;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by zhangqiang on 17/3/9.
 * 响应将HttpResponse 替换为实际的
 */

public class MyRequest<T extends JSONObject> extends Request<JSONObject> {
    private Response.Listener<JSONObject> mListener;

    public MyRequest(int method, String url, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.mListener = listener;
    }

    public MyRequest(String url, Response.Listener<JSONObject> listener, Response.ErrorListener errorListener) {
        this(0, url, listener, errorListener);
    }

    @Override
    protected void onFinish() {
        super.onFinish();
        this.mListener = null;
    }

    @Override
    protected void deliverResponse(JSONObject response) {
        if(this.mListener != null) {
            this.mListener.onResponse(response);
        }
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse networkResponse) {

        JSONObject jSONObject = null;
        String rst = null;
        try {
            rst = new String(networkResponse.data, HttpHeaderParser.parseCharset(networkResponse.headers));


            jSONObject = JSON.parseObject(rst, JSONObject.class);


        } catch (UnsupportedEncodingException var4) {
            //LogUtil.d("UnsupportedEncodingException", var4);
            return Response.error(new VolleyError("UnsupportedEncodingException",var4));
        } catch (Exception e1) {
            //LogUtil.d("Request.URL:"+this.getUrl(),e1);
            return Response.error(new VolleyError("Exception",e1));
        }

        return  Response.success(jSONObject, HttpHeaderParser.parseCacheHeaders(networkResponse));
    }
}
