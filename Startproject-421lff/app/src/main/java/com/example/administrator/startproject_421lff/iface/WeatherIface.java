package com.example.administrator.startproject_421lff.iface;

/**
 * Created by Administrator on 2017/3/14.
 */
//统一不同的方式获取天气
public interface WeatherIface {
    void getWeather(String cityno,WeatherListener Listener);

}
