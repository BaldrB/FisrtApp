package com.papkou.fisrtapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private TextView tvName, tvSecond, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_loyaot);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        init();
        getIntentMain();
    }

    private void init() {
        tvName = (TextView)findViewById(R.id.tvName);
        tvSecond = (TextView)findViewById(R.id.tvSecond);
        tvEmail = (TextView)findViewById(R.id.tvEmail);
    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null) {
            tvName.setText(i.getStringExtra(Constant.USER_NAME));
            tvSecond.setText(i.getStringExtra(Constant.USER_SECOND));
            tvEmail.setText(i.getStringExtra(Constant.USER_EMAIL));
        }
    }

    //Системная кнопка Назад начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(ShowActivity.this, ReadActivity.class);
            startActivity(intent);
            finish();

        }catch (Exception e) {

        }

    }
    //Системная кнопка Назад конец
}