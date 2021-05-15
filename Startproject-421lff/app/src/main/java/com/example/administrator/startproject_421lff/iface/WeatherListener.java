package com.example.administrator.startproject_421lff.iface;

import com.example.administrator.startproject_421lff.bean.WeatherInfo;

/**
 * Created by Administrator on 2017/3/14.
 */

public interface WeatherListener {
    void onResponse(WeatherInfo weatherInfo);
    void onFail(String msg);
}
