package com.example.kimmoonsung.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 27..
 */

public class Main_2 extends Activity{
    ImageView Left,Right;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        setContentView(R.layout.activity_main_2);

        Left = (ImageView)findViewById(R.id.twoleft);
        Right = (ImageView)findViewById(R.id.tworight);

        Left.setOnClickListener(new View.OnClickListener() { // 시작페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Main.class);
                Toast.makeText(getApplication(), "one", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        Right.setOnClickListener(new View.OnClickListener() { // 시작페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Main_3.class);
                Toast.makeText(getApplication(), "three", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

}
