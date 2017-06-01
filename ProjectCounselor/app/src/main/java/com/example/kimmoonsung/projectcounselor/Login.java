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

public class Login extends Activity {
    ImageView Loginbutton , back;
    EditText LoginId,LoginPw;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Loginbutton = (ImageView) findViewById(R.id.login);
        back = (ImageView) findViewById(R.id.back);

        // 로그인 Id, Password
        LoginId = (EditText) findViewById(R.id.login_id);
        LoginId.setPrivateImeOptions("defaultInputmode=english;");
        LoginPw = (EditText) findViewById(R.id.login_pw);
        LoginPw.setPrivateImeOptions("defaultInputmode=english;");



        Loginbutton.setOnClickListener(new View.OnClickListener() { // 로그인
            @Override
            public void onClick(View v) {

                String loginid = LoginId.getText().toString(); //
                String loginpw = LoginPw.getText().toString();//

                if(loginid.length()==0)
                {
                    Toast.makeText(getApplication(), "아이디 입력해주세요 ", Toast.LENGTH_SHORT).show();
                }

                else if(loginpw.length()==0){
                    Toast.makeText(getApplication(), "비밀번호 입력해주세요 ", Toast.LENGTH_SHORT).show();
                }

                else {
                    Intent intent = new Intent(getApplicationContext(), Home.class);


                    intent.putExtra("loginid", loginid);//id넘겨준다


                    startActivity(intent);
                    finish();
                }
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
        Toast.makeText(getApplication(),"뒤로 가시려면 상단에 뒤로가기 버튼을 클릭하십시오." , Toast.LENGTH_SHORT).show();
    }
}
