package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Registration extends AppCompatActivity {

    private Button registration;
    private EditText phone;
    private EditText user;
    private EditText pass;
    private EditText repass;
    private EditText verification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //点击跳转页面
        registration = findViewById(R.id.rgbtn);
        phone = findViewById(R.id.phone);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        repass = findViewById(R.id.repass);
        verification = findViewById(R.id.verification);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取账号和密码
                String phonenumber = Registration.this.phone.getText().toString();
                String username = Registration.this.user.getText().toString();
                String password = Registration.this.pass.getText().toString();
                String repassword = Registration.this.repass.getText().toString();
                String verification = Registration.this.verification.getText().toString();
                Log.e("TAG", "输入的手机号是: "+phonenumber );
                Log.e("TAG", "输入的用户名是: "+username );
                Log.e("TAG", "输入的密码是: "+password );
                Log.e("TAG", "确认的密码是: "+repassword );
                Log.e("TAG", "验证码是: "+verification );
                // 跳转到另一个名为Recommend的界面
                if (password.equals(repassword)){
                    Intent intent=new Intent(Registration.this,Recommend.class);
                    startActivity(intent);
                }

            }
        });
    }
}