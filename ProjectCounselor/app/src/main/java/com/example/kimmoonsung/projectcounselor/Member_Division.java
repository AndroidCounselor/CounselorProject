package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 28..
 */

public class Member_Division extends Activity{
    ImageView Individual,Counselor , back;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_member_division);

        Individual = (ImageView) findViewById(R.id.individual);
        Counselor = (ImageView) findViewById(R.id.counselor);


        Individual.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Member_Individual.class);
                Toast.makeText(getApplication(), "개인Login", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Counselor.setOnClickListener(new View.OnClickListener() { // 회원가입약관 페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Member_Counselor.class);
                Toast.makeText(getApplication(), "상담사Login", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });




    }
}
