package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 28..
 */

public class Login extends Activity {
    ImageView Loginbutton , back;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Loginbutton = (ImageView) findViewById(R.id.login);
        back = (ImageView) findViewById(R.id.back);


        Loginbutton.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Home.class);
                Toast.makeText(getApplication(), "homego", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() { // back 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Main1.class);
                Toast.makeText(getApplication(), "back", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}
