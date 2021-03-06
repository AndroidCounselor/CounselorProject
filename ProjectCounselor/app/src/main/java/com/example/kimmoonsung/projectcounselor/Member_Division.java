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
         back = (ImageView) findViewById(R.id.back);

        Individual.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) { // 개인로그인

                Intent intent = new Intent(getApplicationContext(), Member_Individual.class);

                startActivity(intent);
                finish();
            }
        });

        Counselor.setOnClickListener(new View.OnClickListener() { // 회원가입약관 페이지로 이동
            @Override
            public void onClick(View v) { // 상담사 로그인

                Intent intent = new Intent(getApplicationContext(), Member_Counselor0.class);

                startActivity(intent);
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) { // back button

                Intent intent = new Intent(getApplicationContext(), Member_Agree.class);

                startActivity(intent);
            }
        });


    }

    public void onBackPressed() { //뒤로가는버튼막음
        //  super.onBackPressed();
        Toast.makeText(getApplication(),"뒤로 가시려면 상단에 뒤로가기 버튼을 클릭하십시오." , Toast.LENGTH_SHORT).show();     //스위치가 꺼졌을때
    }
}
