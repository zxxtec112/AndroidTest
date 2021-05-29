package com.example.administrator.zyfypt_421lff;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String msg;
        msg="注册的用户名，密码";
        if (msg.equals("aa"))
            Toast.makeText(this, msg, Toast.LENGTH_LONG);
        else
            Toast.makeText(this, msg, Toast.LENGTH_LONG);
    }
}
