package com.papkou.fisrtapp;

import androidx.annotation.NonNull;
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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class Level1 extends AppCompatActivity implements View.OnClickListener {

    private int numGlobal = 0;
    public int countText = 0;
    private String textUser;

    private DatabaseReference mDataBase;
    private String USER_KEY = "User";

    ArrayImg array = new ArrayImg();
    Button btn_otv1;
    Button btn_otv2;
    Button btn_otv3;
    Button btn_otv4;
    ImageView imgGlobal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level1);

        getIntentMain();

        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level);

        imgGlobal = (ImageView)findViewById(R.id.img_q);
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

        btn_otv1 = (Button)findViewById(R.id.btn_otv1);
        btn_otv2 = (Button)findViewById(R.id.btn_otv2);
        btn_otv3 = (Button)findViewById(R.id.btn_otv3);
        btn_otv4 = (Button)findViewById(R.id.btn_otv4);

        btn_otv1.setText(array.texts2[countText][0]);
        btn_otv2.setText(array.texts2[countText][1]);
        btn_otv3.setText(array.texts2[countText][2]);
        btn_otv4.setText(array.texts2[countText][3]);
        imgGlobal.setImageResource(array.images1[countText]);

        btn_otv1.setOnClickListener(this);
        btn_otv2.setOnClickListener(this);
        btn_otv3.setOnClickListener(this);
        btn_otv4.setOnClickListener(this);

//        btn_otv1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//
//                    if (R.id.btn_otv1 == array.texts2[countText][4]) {
//                        countText += 1;
//                        numGlobal += 1;
//                        imgGlobal.setImageResource(array.images1[countText]);
//                        btn_otv1.setText(array.texts2[countText][0]);
//                        btn_otv2.setText(array.texts2[countText][1]);
//                        btn_otv3.setText(array.texts2[countText][2]);
//                        btn_otv4.setText(array.texts2[countText][3]);
//
//                        btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//
//
//                        System.out.println("UP XP User");
//                        getDataFromDB();
//                    } else {
//                      btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.red_btn));
//                    }
//
//                }catch (Exception e) {
//
//                }
//
//
//            }
//        });
//
//        btn_otv2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                    if (R.id.btn_otv2 == array.texts2[countText][4]) {
//                        countText += 1;
//                        numGlobal += 1;
//                        imgGlobal.setImageResource(array.images1[countText]);
//                        btn_otv1.setText(array.texts2[countText][0]);
//                        btn_otv2.setText(array.texts2[countText][1]);
//                        btn_otv3.setText(array.texts2[countText][2]);
//                        btn_otv4.setText(array.texts2[countText][3]);
//
//                        btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//
//                        System.out.println("UP XP User");
//                        getDataFromDB();
//
//                    } else {
//                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.red_btn));
//                    }
//
//                }catch (Exception e) {
//
//                }
//
//
//            }
//        });
//
//        btn_otv3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                    if (R.id.btn_otv3 == array.texts2[countText][4]) {
//                        countText += 1;
//                        numGlobal += 1;
//                        imgGlobal.setImageResource(array.images1[countText]);
//                        btn_otv1.setText(array.texts2[countText][0]);
//                        btn_otv2.setText(array.texts2[countText][1]);
//                        btn_otv3.setText(array.texts2[countText][2]);
//                        btn_otv4.setText(array.texts2[countText][3]);
//
//                        btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//
//
//                        System.out.println("UP XP User");
//                        getDataFromDB();
//                    } else {
//                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.red_btn));
//                    }
//
//
//                }catch (Exception e) {
//
//                }
//
//
//            }
//        });
//
//        btn_otv4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try{
//                    if (R.id.btn_otv4 == array.texts2[countText][4]) {
//                        countText += 1;
//                        numGlobal += 1;
//                        imgGlobal.setImageResource(array.images1[countText]);
//                        btn_otv1.setText(array.texts2[countText][0]);
//                        btn_otv2.setText(array.texts2[countText][1]);
//                        btn_otv3.setText(array.texts2[countText][2]);
//                        btn_otv4.setText(array.texts2[countText][3]);
//
//                        btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
//
//                        System.out.println("UP XP User");
//                        getDataFromDB();
//                    } else {
//                        btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.red_btn));
//                    }
//
//                }catch (Exception e) {
//
//                }
//            }
//        });



    }

    private void btnMethod(Button btn) {
        try{
            if (btn.getId() == array.texts2[countText][4]) {
                countText += 1;
                numGlobal += 1;
                imgGlobal.setImageResource(array.images1[countText]);
                btn_otv1.setText(array.texts2[countText][0]);
                btn_otv2.setText(array.texts2[countText][1]);
                btn_otv3.setText(array.texts2[countText][2]);
                btn_otv4.setText(array.texts2[countText][3]);

                btn_otv1.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                btn_otv2.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                btn_otv3.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));
                btn_otv4.setBackgroundTintList(getResources().getColorStateList(R.color.withe_btn));

                System.out.println("UP XP User");
                if (countText > 8) {
                    System.out.println("10");
                    ValueEventListener vListener = new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            System.out.println("User BD1");
                            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                NewUser user = ds.getValue(NewUser.class);
                                assert user != null;

                                if (user.name.equals(textUser)) {
                                    System.out.println("User BD2");
                                    String uid = ds.getKey();
                                    DatabaseReference reference = FirebaseDatabase.getInstance()
                                            .getReference("User")
                                            .child(uid);

                                    Map<String, Object> data = new HashMap<>();
                                    data.put("xpUser", numGlobal);
                                    reference.updateChildren(data, (databaseError, databaseReference) -> {
                                        if (databaseError == null) {
                                            //всё ОК
                                            System.out.println("true 100");

                                        } else {
                                            //произошла ошибка. Она тут: databaseError.toException()
                                            System.out.println("false 100");
                                        }
                                    });

                                }
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    };

                    mDataBase.addValueEventListener(vListener);
                }
            } else {
                btn.setBackgroundTintList(getResources().getColorStateList(R.color.red_btn));
            }

        }catch (Exception e) {

        }

    }

    private void getIntentMain(){
        Intent i = getIntent();
        if (i != null) {
            textUser = i.getStringExtra(Constant.USER_NAME);
            System.out.println(textUser);
        }
    }

    private void getDataFromDB() {


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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_otv1:
                btnMethod(btn_otv1);
                break;
            case R.id.btn_otv2:
                btnMethod(btn_otv2);
                break;
            case R.id.btn_otv3:
                btnMethod(btn_otv3);
                break;
            case R.id.btn_otv4:
                btnMethod(btn_otv4);
                break;
        }
    }
}