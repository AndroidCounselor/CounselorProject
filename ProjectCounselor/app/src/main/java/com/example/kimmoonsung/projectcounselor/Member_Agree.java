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

public class Member_Agree extends Activity {
    ImageView MemberAgree_btn , back;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_member_agree);

        MemberAgree_btn = (ImageView) findViewById(R.id.agree_btn);
        back = (ImageView) findViewById(R.id.back);

        MemberAgree_btn.setOnClickListener(new View.OnClickListener() { // 시작페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Member_Division.class);
                Toast.makeText(getApplication(), "division", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
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

    public void onBackPressed() { //뒤로가는버튼막음
        //  super.onBackPressed();
        Toast.makeText(getApplication(),"뒤로 가시려면 상단에 뒤로가기 버튼을 클릭하십시오." , Toast.LENGTH_SHORT).show();     //스위치가 꺼졌을때
    }

}
