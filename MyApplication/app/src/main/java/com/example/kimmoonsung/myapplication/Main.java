package com.example.kimmoonsung.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 25..
 */

// moonsung branch start
    // check
public class Main extends Activity {
    ImageView Left,Right,Login_btn,Member_btn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        setContentView(R.layout.activity_firstmain);

        Left = (ImageView)findViewById(R.id.oneleft);
        Right = (ImageView)findViewById(R.id.oneright);
        Login_btn =(ImageView)findViewById(R.id.login_btn);
        Member_btn =(ImageView)findViewById(R.id.member_btn);

        Left.setOnClickListener(new View.OnClickListener() { //좌측이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Main_5.class);
                Toast.makeText(getApplication(), "five", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Right.setOnClickListener(new View.OnClickListener() { // 우측 이동
            @Override
            public void onClick(View v) { // 우측이동

                Intent intent = new Intent(getApplicationContext(), Main_2.class);
                Toast.makeText(getApplication(), "two", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Login_btn.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), login.class);
                Toast.makeText(getApplication(), "Login", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Member_btn.setOnClickListener(new View.OnClickListener() { // 회원가입약관 페이지로 이동
            @Override
            public void onClick(View v) { //이용약관으로 이동

                Intent intent = new Intent(getApplicationContext(), Member_Agree.class);
                Toast.makeText(getApplication(), "Memeber_Agree(이용약관 동의하기)", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }

}
