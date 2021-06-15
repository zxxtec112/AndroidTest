package com.example.administrator.spinnertest421lff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView tvinfo;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        //定义数据源
        String[] cities = {"北京", "上海", "天津", "大连" };
        //实例化ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, cities);
        //设置下拉按钮样式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将spinner与ArrayAdapter绑定
        spinner.setAdapter(adapter);
        spinner.setPrompt("请选择城市");
        //本句为Spinner是对话框形式而设的标题.OnItemSelectedListener() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tvinfo.setText("您选择的是：" + adapterView.getItemAtPosition(i).toString());
            }

            public void onNothingSelected(AdapterView<?> adapterView) {


            }
        });
    }
    private void init() {
        tvinfo=(TextView)findViewById(R.id.textView);
        spinner=(Spinner)findViewById(R.id.spinner);
    }
}
