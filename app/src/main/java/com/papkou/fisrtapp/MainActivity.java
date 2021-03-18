package com.papkou.fisrtapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    private EditText edName;
    private DatabaseReference mDataBase;
    private String USER_KEY = "User";


    private ListView listView;
    private ArrayAdapter<String> adapter;
    private List<String> listData;
    private List<NewUser> listTemp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonLevel = (Button)findViewById(R.id.levelgame);

        buttonLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    getDataFromDB();

                }catch (Exception e) {


                }

            }
        });

        Button btn_regis = (Button)findViewById(R.id.btn_reg);

        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(MainActivity.this, Register.class);
                    startActivity(intent);
                    finish();

                }catch (Exception e) {


                }

            }
        });

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
    }

    private void init() {
        edName = findViewById(R.id.edName);

        mDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
    }

    private void getDataFromDB() {

        ValueEventListener vListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    NewUser user = ds.getValue(NewUser.class);
                    assert  user != null;
                    System.out.println("l"+user.name+"l l" + edName.getText().toString() + "l");
                    if (user.name.equals(edName.getText().toString())) {
                        Intent intent = new Intent(MainActivity.this, GamesLevels.class);
                        startActivity(intent);
                        finish();
                        System.out.println("data base true");
                        break;

                    }
                    else {
                        System.out.println("data base false");
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };

        mDataBase.addValueEventListener(vListener);
    }

//    public void onClickSave(View view) {
//        String id = mDataBase.getKey();
//        String name = edName.getText().toString();
//
//        NewUser user = new NewUser(id, name, sec_name, email);
//
//        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(sec_name) && !TextUtils.isEmpty(email)) {
//            mDataBase.push().setValue(user);
//            Toast.makeText(this, "Запись добавлена", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
//        }
//
//    }

    public void onClickRead(View view) {
        try{
            Intent intent = new Intent(MainActivity.this, ReadActivity.class);
            startActivity(intent);
            finish();

        }catch (Exception e) {

        }

    }

    //Системна кнопка Назад начало
    @Override
    public void onBackPressed() {


        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel();
            super.onBackPressed();
            return;
        }else{
            backToast = Toast.makeText(getBaseContext(), "Нажмите еще разб чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }
    //Системная кнопка Назад конец

}