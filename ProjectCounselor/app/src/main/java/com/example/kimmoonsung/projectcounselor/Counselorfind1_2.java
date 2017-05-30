package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.Window;


import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 29..
 */

public class Counselorfind1_2 extends Activity implements OnClickListener {
    /* slide menu */
    private DisplayMetrics metrics;
    private LinearLayout ll_mainLayout;
    private LinearLayout ll_menuLayout;
    private FrameLayout.LayoutParams leftMenuLayoutPrams;
    private int leftMenuWidth;
    private static boolean isLeftExpanded;
    //  private Button bt_left;


    private ImageView menu1; // 메뉴 이미지 슬라이드 열리는 메뉴 이미지

    ImageView findbtn , s1;

    @Override



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_counselorfind1_2);

        initSildeMenu();

        //스피너
        Spinner spinner,spinner2;

                spinner = (Spinner)findViewById(R.id.spinner); //상담분야선택
                spinner2 = (Spinner)findViewById(R.id.spinner2);//상담시간선택


        //어댑터 생성
        //이 예제 같은 경우 string,xml에 리스트를 추가해 놓고 그 리스트를 불러온다.
        ArrayAdapter adapter, adapter2;

                adapter = ArrayAdapter.createFromResource(this, R.array.consel_select, android.R.layout.simple_spinner_dropdown_item);
        adapter2 = ArrayAdapter.createFromResource(this, R.array.conseltime_select, android.R.layout.simple_spinner_dropdown_item);

        //스피너와 어댑터 연결
        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);

        //////////



        findbtn = (ImageView) findViewById(R.id.findbtn); // 검색
        s1 = (ImageView)findViewById(R.id.s1);
        s1.setOnClickListener(this);

        findbtn.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Counselorfind2.class);
                Toast.makeText(getApplication(), "counselor2", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


    }


    private void initSildeMenu() {

        // init left menu width
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        leftMenuWidth = (int) ((metrics.widthPixels) * 0.80);

        // init main view
        ll_mainLayout = (LinearLayout) findViewById(R.id.ll_mainlayout);

        // init left menu
        ll_menuLayout = (LinearLayout) findViewById(R.id.ll_menuLayout);
        leftMenuLayoutPrams = (FrameLayout.LayoutParams) ll_menuLayout
                .getLayoutParams();
        leftMenuLayoutPrams.width = leftMenuWidth;
        ll_menuLayout.setLayoutParams(leftMenuLayoutPrams);

        // init ui
        menu1 = (ImageView) findViewById(R.id.menu);

        menu1.setOnClickListener(this); // 메뉴 눌렀을때  밑에 switch문 보셈





    }

    /**
     * left menu toggle
     */
    private void menuLeftSlideAnimationToggle() {

        if (!isLeftExpanded) { //슬라이딩이 열려있지 않다면

            isLeftExpanded = true; //true


            // OPEN

            new OpenAnimation(ll_mainLayout, leftMenuWidth,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.80f, 0, 0.0f, 0, 0.0f);

            // disable all of main view
            FrameLayout viewGroup = (FrameLayout) findViewById(R.id.ll_fragment)
                    .getParent();
            enableDisableViewGroup(viewGroup, false);

            // enable empty view
            ((LinearLayout) findViewById(R.id.ll_empty))
                    .setVisibility(View.VISIBLE);

            findViewById(R.id.ll_empty).setEnabled(true);
            findViewById(R.id.ll_empty).setOnTouchListener(
                    new View.OnTouchListener() {

                        @Override
                        public boolean onTouch(View arg0, MotionEvent arg1) {
                            menuLeftSlideAnimationToggle();
                            return true;
                        }
                    });

        } else {
            isLeftExpanded = false;

            // close
            new CloseAnimation(ll_mainLayout, leftMenuWidth,
                    TranslateAnimation.RELATIVE_TO_SELF, 0.80f,
                    TranslateAnimation.RELATIVE_TO_SELF, 0.0f, 0, 0.0f, 0, 0.0f);

            // enable all of main view
            FrameLayout viewGroup = (FrameLayout) findViewById(R.id.ll_fragment)
                    .getParent();
            enableDisableViewGroup(viewGroup, true);

            // disable empty view
            ((LinearLayout) findViewById(R.id.ll_empty))
                    .setVisibility(View.GONE);
            findViewById(R.id.ll_empty).setEnabled(false);

        }
    }

    /**
     * 뷰의 동작을 제어한다. 하위 모든 뷰들이 enable 값으로 설정된다.
     *
     * @param viewGroup
     * @param enabled
     */
    public static void enableDisableViewGroup(ViewGroup viewGroup,
                                              boolean enabled) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View view = viewGroup.getChildAt(i);
            if (view.getId() != R.id.menu) {
                view.setEnabled(enabled);
                if (view instanceof ViewGroup) {
                    enableDisableViewGroup((ViewGroup) view, enabled);
                }
            }
        }
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.menu:         // 메뉴 이미지를 눌렀을때
                menuLeftSlideAnimationToggle(); //이 메소드 호출
                break;

            case R.id.s1: // 나의 상담내역
                if(isLeftExpanded==true) {// 메뉴열려있을시에만
                    Intent intent = new Intent(getApplicationContext(), MyCounselor_Schedual.class);
                    Toast.makeText(getApplicationContext(), "나의상담내역으로", Toast.LENGTH_SHORT)
                            .show();
                    startActivity(intent);
                }
                break;
        }
    }
}
