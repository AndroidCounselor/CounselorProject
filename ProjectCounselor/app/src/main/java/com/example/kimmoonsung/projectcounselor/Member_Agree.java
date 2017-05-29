package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 28..
 */

public class Member_Agree extends Activity {
    ImageView MemberAgree_btn ,a;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        setContentView(R.layout.activity_member_agree);

        MemberAgree_btn =(ImageView)findViewById(R.id.memberAgree_btn);


        MemberAgree_btn.setOnClickListener(new View.OnClickListener() { // 회원가입약관 페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Member_Division.class);
                Toast.makeText(getApplication(), "MemeberDivision(회원가입구분 )", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        a =(ImageView)findViewById(R.id.homego);


        a.setOnClickListener(new View.OnClickListener() { // 회원가입약관 페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Home.class);
                Toast.makeText(getApplication(), "home", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

}
