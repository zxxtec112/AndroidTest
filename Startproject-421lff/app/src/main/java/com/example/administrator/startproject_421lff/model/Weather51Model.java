package com.example.administrator.startproject_421lff.model;

import com.example.administrator.startproject_421lff.iface.WeatherIface;
import com.example.administrator.startproject_421lff.iface.WeatherListener;

/**
 * Created by Administrator on 2017/3/14.
 */

public class Weather51Model implements WeatherIface{
    private String  BASEURL="http://weather.51wnl.com/weatherinfo/";
    public Weather51Model() {
    }

    @Override
    public void getWeather(String cityno, WeatherListener Listener) {

    }
}
