package com.example.administrator.startproject_421lff.service;

import com.example.administrator.startproject_421lff.bean.WeatherResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/3/14.
 */
//Retrfit访问网路-2，定义接口
public interface WeatherService {
@GET("data/sk/{cityNumber}.html")
    Call<WeatherResult> getResult(@Path("cityNumber")String cityNumber);
}
