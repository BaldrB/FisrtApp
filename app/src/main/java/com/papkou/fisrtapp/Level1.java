package com.papkou.fisrtapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Level1 extends AppCompatActivity {

    public int numGlobal;
    public int countText = 0;

    ArrayImg array = new ArrayImg();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);


        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level);

        final ImageView imgGlobal = (ImageView)findViewById(R.id.img_q);
        imgGlobal.setClipToOutline(true);


        //Развернуть игру на весь экрна
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button btn_back = (Button)findViewById(R.id.btn_back);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Level1.this, GamesLevels.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e) {

                }
            }
        });

        Button btn_otv1 = (Button)findViewById(R.id.btn_otv1);
        Button btn_otv2 = (Button)findViewById(R.id.btn_otv2);
        Button btn_otv3 = (Button)findViewById(R.id.btn_otv3);
        Button btn_otv4 = (Button)findViewById(R.id.btn_otv4);

        imgGlobal.setImageResource(array.images1[countText]);

        btn_otv1.setText(array.texts2[countText][0]);
        btn_otv2.setText(array.texts2[countText][1]);
        btn_otv3.setText(array.texts2[countText][2]);
        btn_otv4.setText(array.texts2[countText][3]);

//        btn_otv1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction()==MotionEvent.ACTION_DOWN) {
//
//
//                } else if(event.getAction()==MotionEvent.ACTION_UP) {
//                    countText += 1;
//                    imgGlobal.setImageResource(array.images1[countText]);
//                    btn_otv1.setText(array.texts2[countText][0]);
//                    btn_otv2.setText(array.texts2[countText][1]);
//                    btn_otv3.setText(array.texts2[countText][2]);
//                    btn_otv4.setText(array.texts2[countText][3]);
//
//                }
//                return  true;
//            }
//        });

        btn_otv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    if (R.id.btn_otv1 == array.texts2[countText][4]) {
                        countText += 1;
                        imgGlobal.setImageResource(array.images1[countText]);
                        btn_otv1.setText(array.texts2[countText][0]);
                        btn_otv2.setText(array.texts2[countText][1]);
                        btn_otv3.setText(array.texts2[countText][2]);
                        btn_otv4.setText(array.texts2[countText][3]);

                        btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                    } else {
                      btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.red_btn));
                    }

                }catch (Exception e) {

                }


            }
        });

        btn_otv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (R.id.btn_otv2 == array.texts2[countText][4]) {
                        countText += 1;
                        imgGlobal.setImageResource(array.images1[countText]);
                        btn_otv1.setText(array.texts2[countText][0]);
                        btn_otv2.setText(array.texts2[countText][1]);
                        btn_otv3.setText(array.texts2[countText][2]);
                        btn_otv4.setText(array.texts2[countText][3]);

                        btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                    } else {
                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.red_btn));
                    }

                }catch (Exception e) {

                }


            }
        });

        btn_otv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (R.id.btn_otv3 == array.texts2[countText][4]) {
                        countText += 1;
                        imgGlobal.setImageResource(array.images1[countText]);
                        btn_otv1.setText(array.texts2[countText][0]);
                        btn_otv2.setText(array.texts2[countText][1]);
                        btn_otv3.setText(array.texts2[countText][2]);
                        btn_otv4.setText(array.texts2[countText][3]);

                        btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                    } else {
                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.red_btn));
                    }

                }catch (Exception e) {

                }


            }
        });

        btn_otv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if (R.id.btn_otv4 == array.texts2[countText][4]) {
                        countText += 1;
                        imgGlobal.setImageResource(array.images1[countText]);
                        btn_otv1.setText(array.texts2[countText][0]);
                        btn_otv2.setText(array.texts2[countText][1]);
                        btn_otv3.setText(array.texts2[countText][2]);
                        btn_otv4.setText(array.texts2[countText][3]);

                        btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                    } else {
                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.red_btn));
                    }

                }catch (Exception e) {

                }
            }
        });



    }

    //Системная кнопка Назад начало
    @Override
    public void onBackPressed(){
        try{
            Intent intent = new Intent(Level1.this, GamesLevels.class);
            startActivity(intent);
            finish();

        }catch (Exception e) {

        }

    }
    //Системная кнопка Назад конец
}