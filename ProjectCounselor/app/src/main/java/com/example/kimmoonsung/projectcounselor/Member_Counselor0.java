package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 28..
 */

public class Member_Counselor0 extends Activity{
    ImageView back , sign, cancel;
    EditText counselorid,Nickname,Pw,Pw2,Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_member_counselor0);

        back = (ImageView) findViewById(R.id.back); // 뒤로가기
        sign = (ImageView) findViewById(R.id.sign); //  가입
        cancel = (ImageView) findViewById(R.id.cancel); // 취소

        //아이디 닉네임 비번 비번확인 이메일 //

        counselorid = (EditText) findViewById(R.id.member_counselor_id);
        counselorid.setPrivateImeOptions("defaultInputmode=english;");
        Nickname = (EditText) findViewById(R.id.member_counselor_nickname);
        Pw = (EditText) findViewById(R.id.member_counselor_pw);
        Pw.setPrivateImeOptions("defaultInputmode=english;");
        Pw2 = (EditText) findViewById(R.id.member_counselor_pw2);
        Pw2.setPrivateImeOptions("defaultInputmode=english;");

        Email = (EditText) findViewById(R.id.member_counselor_email);

        back.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) { // back button

                Intent intent = new Intent(getApplicationContext(), Member_Division.class);

                startActivity(intent);

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {// cancel button

                Intent intent = new Intent(getApplicationContext(), Member_Division.class);

                startActivity(intent);

            }
        });
        sign.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                String id = counselorid.getText().toString(); //
                String nickname = Nickname.getText().toString();
                String pw = Pw.getText().toString();
                String pw2 = Pw2.getText().toString();


                if(id.length()<6|| id.length()>14)
                {
                    Toast.makeText(getApplication(), "아이디는 6-10자리로 입력해주세요 ", Toast.LENGTH_SHORT).show();
                }
                else if (nickname.length()>14) {
                    Toast.makeText(getApplication(), "닉네임은 14자리 이내로 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else if( pw.length()<6||pw.length()>10)
                {
                    Toast.makeText(getApplication(), "비밀번호는 6-10자리로 입력해주세요 ", Toast.LENGTH_SHORT).show();
                }
                else if(!pw.equals(pw2))
                {
                    Toast.makeText(getApplication(), "비밀번호가 다릅니다  ", Toast.LENGTH_SHORT).show();
                }


                else {

                    Intent intent = new Intent(getApplicationContext(), Member_Counselor.class);

                    intent.putExtra("counselor_id", id);
                    intent.putExtra("counselor_nickname", nickname);


                    startActivity(intent);
                    finish();
                }
            }
        });



    }

    public void onBackPressed() { //뒤로가는버튼막음
        //  super.onBackPressed();
        Toast.makeText(getApplication(),"뒤로 가시려면 상단에 뒤로가기 버튼을 클릭하십시오." , Toast.LENGTH_SHORT).show();     //스위치가 꺼졌을때
    }

}

