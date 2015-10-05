package com.bogerweather.app.util;

/**
 * Created by Administrator on 2015/10/5.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
