package com.example.a900.widgettest_421lff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NewActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        //收参
        Intent intent = getIntent();
        String str = intent.getStringExtra("param1");
        int n = intent.getIntExtra("param2", 10);
        //显示方法：logcat显示
        System.out.println("----" + str + "----" + String.valueOf(n));
        //Toast显示
        Toast.makeText(this, str + "----" + String.valueOf(n), Toast.LENGTH_SHORT).show();
        //在界面上的TextView中显示
        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText(str + "----" + String.valueOf(n));
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                finish();
                break;
        }
    }
}


