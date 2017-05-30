package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 28..
 */

public class Member_Counselor extends Activity{
    ImageView Sign,Cancel,back;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_member_counselor);

        //스피너
        Spinner spinner = (Spinner)findViewById(R.id.spinner);

        //어댑터 생성
        //이 예제 같은 경우 string,xml에 리스트를 추가해 놓고 그 리스트를 불러온다.
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.work, android.R.layout.simple_spinner_dropdown_item);

        //스피너와 어댑터 연결
        spinner.setAdapter(adapter);

        //////////


        Sign = (ImageView) findViewById(R.id.sign);
        Cancel = (ImageView) findViewById(R.id.cancel);
        back = (ImageView) findViewById(R.id.back);



        Sign.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Home.class);
                Toast.makeText(getApplication(), "가입완료", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Member_Division.class);
                Toast.makeText(getApplication(), "cancel", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Member_Division.class);
                Toast.makeText(getApplication(), "cancel", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }
}
