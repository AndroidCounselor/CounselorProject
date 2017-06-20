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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kimmoonsung on 2017. 5. 29..
 */

public class Counselorfind2 extends Activity implements OnClickListener {
    /* slide menu */
    private DisplayMetrics metrics;
    private LinearLayout ll_mainLayout;
    private LinearLayout ll_menuLayout;
    private FrameLayout.LayoutParams leftMenuLayoutPrams;
    private int leftMenuWidth;
    private static boolean isLeftExpanded;
    //  private Button bt_left;


    private ImageView menu1; // 메뉴 이미지 슬라이드 열리는 메뉴 이미지
    ImageView moon1, moon2, s1 , find2_home;
    ImageView Counselor1,Counselor_reserve1;
     int i =0;

    //
    TextView Slide_Id , TV2;
    MODEL model = MODEL.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_counselorfind2);

        initSildeMenu();

        //// 달 -> 즐겨찾기 ////
        moon1 = (ImageView) findViewById(R.id.moon1);
        moon2 = (ImageView) findViewById(R.id.moon2);

        s1 = (ImageView) findViewById(R.id.s1);
        s1.setOnClickListener(this);

        // 상담원 프로필
        Counselor1 = (ImageView) findViewById(R.id.counselor1);

        // 상담원 예약하기
        Counselor_reserve1 = (ImageView) findViewById(R.id.counselor_reserve1);

        moon1.setOnClickListener(new View.OnClickListener() { // 시작페이지로 이동
            @Override
            public void onClick(View v) {


                if( i == 0 ){
                    moon1.setImageResource(R.drawable.moon2);
                    Toast.makeText(getApplication(), "즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    i=1;
                }

                else{
                    moon1.setImageResource(R.drawable.moon1);
                    Toast.makeText(getApplication(), "즐겨찾기가 해제되었습니다.", Toast.LENGTH_SHORT).show();
                    i=0;
                }

            }
        });

        moon2.setOnClickListener(new View.OnClickListener() { // 시작페이지로 이동
            @Override
            public void onClick(View v) {

                if( i == 0 ){
                    moon2.setImageResource(R.drawable.moon1);
                    Toast.makeText(getApplication(), "즐겨찾기가 해제되었습니다.", Toast.LENGTH_SHORT).show();
                    i=1;
                }

                else{
                    moon2.setImageResource(R.drawable.moon2);
                    Toast.makeText(getApplication(), "즐겨찾기에 추가되었습니다.", Toast.LENGTH_SHORT).show();
                    i=0;
                }

            }
        });

        Counselor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // > button

                Intent intent = new Intent(getApplicationContext(), Counselor_profile.class);

                startActivity(intent);
                finish();
            }
        });

        Counselor_reserve1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // counselor Reservation button

                Intent intent = new Intent(getApplicationContext(), Counselor_Reservation.class);

                startActivity(intent);

            }
        });
        ////////

        Slide_Id = (TextView) findViewById(R.id.slide_id);
        String id = model.getSlide_Id();
        Slide_Id.setText(id+" 님");


        find2_home = (ImageView) findViewById(R.id.find2_home);
        find2_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Home.class);
                intent.putExtra("homeid", model.getSlide_Id());
                startActivity(intent);

            }
        });


        //

        TV2 = (TextView) findViewById(R.id.tv2);
        String str2 = model.getSpinner_item();
        TV2.setText(str2);





        ImageView goschedual0; // 임시 캘린더로 넘어감
        //임시 캘린더로 넘어감
        goschedual0 = (ImageView) findViewById(R.id.go0);
        goschedual0.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MyCounselor_Schedual0.class);

                startActivity(intent);

            }
        });

    }

    private void initSildeMenu() {

        // init left menu width
        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        leftMenuWidth = (int) ((metrics.widthPixels) * 0.70);

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
                    Animation.RELATIVE_TO_SELF, 0.70f, 0, 0.0f, 0, 0.0f);

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

        }
        else {
            isLeftExpanded = false;

            // close
            new CloseAnimation(ll_mainLayout, leftMenuWidth,
                    TranslateAnimation.RELATIVE_TO_SELF, 0.70f,
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

                    startActivity(intent);
                    finish();
                }
                break;
        }
    }
}
