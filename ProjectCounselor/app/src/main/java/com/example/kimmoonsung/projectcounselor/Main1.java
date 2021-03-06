package com.example.kimmoonsung.projectcounselor;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector;



/**
 * Created by kimmoonsung on 2017. 5. 25..
 */

// moonsung branch start
// check
public class Main1 extends Activity implements OnGestureListener  {
    ImageView Right,Login_btn,Member_btn;


    ///////// swipe ////////////////

    private LinearLayout main;
    private TextView viewA;

    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;

    private GestureDetector gestureScanner;


    ////////////////////////////////////////


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ////////////////////// swipe  ////////////////////

        gestureScanner = new GestureDetector(this);
        main = new LinearLayout(this);
        main.setBackgroundColor(Color.GRAY);
        main.setLayoutParams(new LinearLayout.LayoutParams(320, 480));

        viewA = new TextView(this);
        viewA.setBackgroundColor(Color.WHITE);
        viewA.setTextColor(Color.BLACK);
        viewA.setTextSize(30);
        viewA.setGravity(Gravity.CENTER);
        viewA.setLayoutParams(new LinearLayout.LayoutParams(320, 80));
        main.addView(viewA);

        ////////////////////////////////////////////////


        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main_1);

        Right = (ImageView)findViewById(R.id.oneright);
        Login_btn =(ImageView)findViewById(R.id.login_btn1);
        Member_btn =(ImageView)findViewById(R.id.member_btn1);


        Right.setOnClickListener(new View.OnClickListener() { // 우측 이동
            @Override
            public void onClick(View v) { // 우측이동

                Intent intent = new Intent(getApplicationContext(), Main2.class);
                startActivity(intent);
                finish();

            }
        });

        Login_btn.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) { //로그인이동

                Intent intent = new Intent(getApplicationContext(), Login.class);
                startActivity(intent);
                finish();
            }
        });

        Member_btn.setOnClickListener(new View.OnClickListener() { // 회원가입약관 페이지로 이동
            @Override
            public void onClick(View v) { //이용약관으로 이동

                Intent intent = new Intent(getApplicationContext(), Member_Agree.class);
                startActivity(intent);
                finish();
            }
        });

    }



    ////////////////////// swipe ////////////////////////////////////////

    @Override
    public boolean onTouchEvent(MotionEvent me) {
        return gestureScanner.onTouchEvent(me);
    }

    public boolean onDown(MotionEvent e) {
        viewA.setText("-" + "DOWN" + "-");
        return true;
    }

    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        try {
            if (Math.abs(e1.getY() - e2.getY()) > SWIPE_MAX_OFF_PATH)
                return false;


// right to left swipe
            if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Intent intent = new Intent(getApplicationContext(), Main2.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Left Swipe", Toast.LENGTH_SHORT).show();
                finish();
            }

// left to right swipe
            else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                Toast.makeText(getApplicationContext(), "Right Swipe", Toast.LENGTH_SHORT).show();
            }

        } catch (Exception e) {

        }
        return true;
    }

    public void onLongPress(MotionEvent e) {
        Toast mToast = Toast.makeText(getApplicationContext(), "Long Press", Toast.LENGTH_SHORT);
        mToast.show();
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        viewA.setText("-" + "SCROLL" + "-");
        return true;
    }

    public void onShowPress(MotionEvent e) {
        viewA.setText("-" + "SHOW PRESS" + "-");
    }

    public boolean onSingleTapUp(MotionEvent e) {
        Toast mToast = Toast.makeText(getApplicationContext(), "Single Tap", Toast.LENGTH_SHORT);
        mToast.show();
        return true;
    }



    //////////////////////////////////////////////////////////////



}