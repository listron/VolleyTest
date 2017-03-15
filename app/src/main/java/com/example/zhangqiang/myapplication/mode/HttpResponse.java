package com.example.zhangqiang.myapplication.mode;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by zhangqiang on 17/3/9.
 */

public interface HttpResponse extends Serializable {

    String rawData();

    void putRawData(String data);

    Map<String,String> headers();

    void setHeaders(Map<String, String> headers);
}
