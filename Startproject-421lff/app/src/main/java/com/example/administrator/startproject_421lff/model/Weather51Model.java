package com.example.administrator.startproject_421lff.model;

import com.example.administrator.startproject_421lff.bean.WeatherResult;
import com.example.administrator.startproject_421lff.iface.WeatherIface;
import com.example.administrator.startproject_421lff.iface.WeatherListener;
import com.example.administrator.startproject_421lff.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/3/14.
 */

public class Weather51Model implements WeatherIface{
    private Retrofit retrofit;
    private String  BASEURL="http://weather.51wnl.com/weatherinfo/";
    public Weather51Model() {
        retrofit=new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Override
    public void getWeather(String cityno, final WeatherListener Listener) {
        WeatherService weather51Service = retrofit.create(WeatherService.class);
        Call<WeatherResult> call = weather51Service.getResult(cityno);
        //Retrofit实例化，第3小步（3-3） Callback快速生成代码
        call.enqueue(new Callback<WeatherResult>() {
            @Override
            public void onResponse(Call<WeatherResult> call, Response<WeatherResult> response) {

                if (response.isSuccessful() && response.body() != null)
                    Listener.onResponse(response.body().getWeatherinfo());
                else
                    Listener.onFail("onResponse error");
            }

            @Override
            public void onFailure(Call<WeatherResult> call, Throwable t) {
                Listener.onFail(t.toString());
            }

        });
    }
}
