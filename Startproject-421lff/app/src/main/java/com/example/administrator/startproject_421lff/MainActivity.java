package com.example.administrator.startproject_421lff;

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
    }

    @Override
    public void onResponse(WeatherInfo weatherInfo) {
        if(weatherInfo!=null){
            tvcityname.setText(weatherInfo.getCity());
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
        switch(v.getId())
        {
            case R.id.button:
                WeatherModel weatherModel=new WeatherModel();
                weatherModel.getWeather(etcityno.getText().toString(),this);
                break;
            case R.id.button2:
                break;
            default:
                break;
        }
    }
}
