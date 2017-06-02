package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 28..
 */

public class Member_Agree extends Activity {
    ImageView MemberAgree_btn , back;
    CheckBox check1, check2 , check3;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_member_agree);

        MemberAgree_btn = (ImageView) findViewById(R.id.agree_btn);
        back = (ImageView) findViewById(R.id.back);

        check1 = (CheckBox) findViewById(R.id.check1);
        check2 = (CheckBox) findViewById(R.id.check2);
        check3 = (CheckBox) findViewById(R.id.check3);

        MemberAgree_btn.setOnClickListener(new View.OnClickListener() { // 시작페이지로 이동
            @Override
            public void onClick(View v) { // agree button -> Division으로

                if(check1.isChecked()==true && check2.isChecked()==true) { // check해야 넘어갈수 있도록
                    Intent intent = new Intent(getApplicationContext(), Member_Division.class);
                    startActivity(intent);
                    finish();
                }

                else {
                    Toast.makeText(getApplication()," 이용약관에 동의해주세요" , Toast.LENGTH_SHORT).show();     //스위치가 꺼졌을때
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() { // back 이동
            @Override
            public void onClick(View v) { // 뒤로 가기

                    Intent intent = new Intent(getApplicationContext(), Main1.class);
                    startActivity(intent);

            }
        });

    }

    public void onBackPressed() { //뒤로가는버튼막음

        //  super.onBackPressed();
        Toast.makeText(getApplication(),"뒤로 가시려면 상단에 뒤로가기 버튼을 클릭하십시오." , Toast.LENGTH_SHORT).show();     //스위치가 꺼졌을때
    }

}
