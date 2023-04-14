package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private Button lbtn;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btn = findViewById(R.id.btn);
        //点击切换图标
        btn.setOnTouchListener(new View.OnTouchListener() {
            int times = 0;
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                    if (times %2 == 0) btn.setImageResource(R.drawable.circle);
                    else btn.setImageResource(R.drawable.checkmark);
                }else if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if (times %2 == 0) btn.setImageResource(R.drawable.checkmark);
                    else btn.setImageResource(R.drawable.circle);
                    times += 1;
                }
                return false;
            }
        });

        //点击跳转页面
        Button lbtn = findViewById(R.id.lbtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取账号和密码
                String username = MainActivity.this.username.getText().toString();
                String password = MainActivity.this.password.getText().toString();
                Log.e("TAG", "输入的用户名是: "+username );
                Log.e("TAG", "输入的密码是: "+password );
                // 跳转到另一个名为Recommend的界面
                Intent intent=new Intent(MainActivity.this,Recommend.class);
                startActivity(intent);
            }
        });

        //点击跳转页面
        Button signin = findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到另一个名为Registration的界面
                Intent intent=new Intent(MainActivity.this,Registration.class);
                startActivity(intent);
            }
        });

    }
}