package com.example.a900.widgettest_421lff;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private EditText et;
    private Button cboxGetHobby, btnGetSex, btngetContent;
    private ImageView imageview;
    private ImageButton imagebutton;
    private RadioButton rbtnMale, rbtnFamale;
    private CheckBox cboxlanqiu, cboxzuqiu, cboxyouyong;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void init() {
        //获取控件
        tv = (TextView) findViewById(R.id.textview);
        et = (EditText) findViewById(R.id.edittext);
        cboxGetHobby = (Button) findViewById(R.id.cboxGetHobby);
        btnGetSex = (Button) findViewById(R.id.btnGetSex);
        btngetContent = (Button) findViewById(R.id.btngetContent);
        imageview = (ImageView) findViewById(R.id.imageview);
        imagebutton = (ImageButton) findViewById(R.id.imagebutton);
        rbtnMale = (RadioButton) findViewById(R.id.rbtnMale);
        rbtnFamale = (RadioButton) findViewById(R.id.rbtnFamale);
        cboxlanqiu = (CheckBox) findViewById(R.id.cboxlanqiu);
        cboxzuqiu = (CheckBox) findViewById(R.id.cboxzuqiu);
        cboxyouyong = (CheckBox) findViewById(R.id.cboxyouyong);
        //设置监听器
        btngetContent.setOnClickListener(this);
        btnGetSex.setOnClickListener(this);
        imageview.setOnClickListener(this);
        cboxGetHobby.setOnClickListener(this);
        imagebutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btngetContent:
                String str = et.getText().toString();
                tv.setText(str);
                break;
            case R.id.btnGetSex:
                String choose = getSex();
                Toast.makeText(getApplicationContext(), choose, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cboxGetHobby:
                String hobby = getHobby();
                Toast.makeText(getApplicationContext(), hobby, Toast.LENGTH_SHORT).show();
                break;
            case R.id.imagebutton:
                setImage();
                Intent intent = new Intent(MainActivity.this,NewActivity.class);
                intent.putExtra("param1","hello");
                intent.putExtra("param2",3);
                //中间传参数
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    private void setImage() {
        imageview.setImageResource(R.drawable.touxiang);

    }

    public String getSex() {
        String sex = "";
        if (rbtnMale.isChecked()) {
            sex = rbtnMale.getText().toString();
        } else {
            sex = rbtnFamale.getText().toString();
        }
        sex += " 被选中";
        return sex;
    }

    public String getHobby() {
        String hobby = "";
        if (cboxlanqiu.isChecked()) {
            hobby += cboxlanqiu.getText().toString();
            hobby += " ";
        }
        if (cboxzuqiu.isChecked()) {
            hobby += cboxzuqiu.getText().toString();
            hobby += " ";
        }
        if (cboxyouyong.isChecked()) {
            hobby += cboxyouyong.getText().toString();
            hobby += " ";
        }
        hobby += "被选中";
        return hobby;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
