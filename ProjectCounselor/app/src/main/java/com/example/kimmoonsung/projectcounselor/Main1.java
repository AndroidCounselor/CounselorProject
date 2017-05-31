package com.example.kimmoonsung.projectcounselor;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 25..
 */

// moonsung branch start
// check
public class Main1 extends Activity {
    ImageView Right,Login_btn,Member_btn;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main_1);

        Right = (ImageView)findViewById(R.id.oneright);
        Login_btn =(ImageView)findViewById(R.id.login_btn1);
        Member_btn =(ImageView)findViewById(R.id.member_btn1);


        Right.setOnClickListener(new View.OnClickListener() { // 우측 이동
            @Override
            public void onClick(View v) { // 우측이동

                Intent intent = new Intent(getApplicationContext(), Main2.class);
                Toast.makeText(getApplication(), "two", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Login_btn.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Login.class);
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

    public void onBackPressed() { //뒤로가는버튼막음

    }

}