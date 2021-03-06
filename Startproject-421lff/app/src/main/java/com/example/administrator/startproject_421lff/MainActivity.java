package com.example.administrator.startproject_421lff;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.administrator.startproject_421lff.bean.WeatherInfo;
import com.example.administrator.startproject_421lff.iface.WeatherListener;
import com.example.administrator.startproject_421lff.model.WeatherModel;

public class MainActivity extends AppCompatActivity implements WeatherListener,View.OnClickListener{
 private EditText  etcityno;
    private Button btnfind1,btnfind2;
    private TextView tvcityname;
    private TextView cityNO;
    private TextView temp;
    private TextView wd;
    private TextView ws;
    private TextView sd;
    private ProgressDialog loadingWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init(){
        etcityno=(EditText)findViewById(R.id.editText);
        btnfind1=(Button)findViewById(R.id.button);
        btnfind2=(Button)findViewById(R.id.button2);
        tvcityname=(TextView)findViewById(R.id.textView2);
        btnfind1.setOnClickListener(this);
        btnfind2.setOnClickListener(this);
        cityNO = (TextView) findViewById(R.id.tv_city_no);
        temp = (TextView) findViewById(R.id.tv_temp);
        wd = (TextView) findViewById(R.id.tv_WD);
        ws = (TextView) findViewById(R.id.tv_WS);
        sd = (TextView) findViewById(R.id.tv_SD);
        //实例化进度条
        loadingWeather = new ProgressDialog(this);
        loadingWeather.setTitle("查询中...");
    }

    @Override
    public void onResponse(WeatherInfo weatherInfo) {
        //取消数据加载进度条
        loadingWeather.dismiss();
        if(weatherInfo!=null){
            tvcityname.setText(weatherInfo.getCity());
            cityNO.setText(weatherInfo.getCityid());
            temp.setText(weatherInfo.getTemp());
            wd.setText(weatherInfo.getWD());
            ws.setText(weatherInfo.getWS());
            sd.setText(weatherInfo.getSD());
        }
        else
        {
            tvcityname.setText("未知");
        }
    }

    @Override
    public void onFail(String msg) {
       tvcityname.setText(msg);
    }

    @Override
    public void onClick(View v) {
        loadingWeather.show();
        switch(v.getId())
        {
            case R.id.button:
                WeatherModel weatherModel=new WeatherModel();
                weatherModel.getWeather(etcityno.getText().toString(),this);
                break;
            case R.id.button2:
                WeatherModel weather51Model=new WeatherModel();
                weather51Model.getWeather(etcityno.getText().toString(),this);
                break;
            default:
                break;
        }
    }
}
