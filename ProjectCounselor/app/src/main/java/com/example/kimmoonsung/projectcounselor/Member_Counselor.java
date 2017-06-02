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

    String counselorid,counselornickname;

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

        //Counselor0dㅔ서 받아옴

        counselorid= getIntent().getStringExtra("counselor_id"); // 받아온 아이디
        counselornickname= getIntent().getStringExtra("counselor_nickname"); //받아온 닉네임



        Sign.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) { //rㅏ입 완료

                Intent intent = new Intent(getApplicationContext(), Home.class);
                intent.putExtra("counselor_id", counselorid);
                intent.putExtra("counselor_nickname", counselornickname);


                startActivity(intent);
                finish();
            }
        });

        Cancel.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) { //cancel button

                Intent intent = new Intent(getApplicationContext(), Member_Division.class);

                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) { // back button

                Intent intent = new Intent(getApplicationContext(), Member_Division.class);
                startActivity(intent);
            }
        });

    }

    public void onBackPressed() { //뒤로가는버튼막음
        //  super.onBackPressed();
        Toast.makeText(getApplication(),"뒤로 가시려면 상단에 뒤로가기 버튼을 클릭하십시오." , Toast.LENGTH_SHORT).show();     //스위치가 꺼졌을때
    }
}
