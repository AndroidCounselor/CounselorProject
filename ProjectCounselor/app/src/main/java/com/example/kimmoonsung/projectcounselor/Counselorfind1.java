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


public class Counselorfind1 extends Activity implements OnClickListener {
    /* slide menu */
    private DisplayMetrics metrics;
    private LinearLayout ll_mainLayout;
    private LinearLayout ll_menuLayout;
    private FrameLayout.LayoutParams leftMenuLayoutPrams;
    private int leftMenuWidth;
    private static boolean isLeftExpanded;
    //  private Button bt_left;
    ImageView keyword1,keyword2,keyword3,keyword4,keyword5,keyword6,keyword7,
              keyword8,keyword9,keyword10,keyword11,keyword12,keyword13,keyword14,keyword15,keyword16,keyword17,keyword18,
              s1,find1_home , find1btn;

    private ImageView menu1; // 메뉴 이미지 슬라이드 열리는 메뉴 이미지

    int i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18;

    TextView Slide_Id;

    MODEL model = MODEL.getInstance();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_counselorfind1);

        initSildeMenu();

        //스피너
        Spinner spinner;

        spinner = (Spinner)findViewById(R.id.spinner); //고민검색

        //어댑터 생성
        //이 예제 같은 경우 string,xml에 리스트를 추가해 놓고 그 리스트를 불러온다.
        ArrayAdapter adapter;

        adapter = ArrayAdapter.createFromResource(this, R.array.consel_select, android.R.layout.simple_spinner_dropdown_item);

        //스피너와 어댑터 연결
        spinner.setAdapter(adapter);

        //////////

        keyword1 = (ImageView) findViewById(R.id.keyword1);
        s1 = (ImageView)findViewById(R.id.s1);
        s1.setOnClickListener(this);

        keyword1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // keyword event

                if( i1 == 0 ){
                    keyword1.setImageResource(R.drawable.keyword_);
                    i1=1;
                }
                else{
                    keyword1.setImageResource(R.drawable.keyword);
                    i1=0;
                }

            }
        });


        find1btn = (ImageView) findViewById(R.id.find1btn);
        find1btn.setOnClickListener(this); // 밑에 switch문

        keyword2 = (ImageView) findViewById(R.id.keyword2);
        keyword2.setOnClickListener(this); // 밑에 switch문
        keyword3 = (ImageView) findViewById(R.id.keyword3);
        keyword3.setOnClickListener(this); // 밑에 switch문
        keyword4 = (ImageView) findViewById(R.id.keyword4);
        keyword4.setOnClickListener(this); // 밑에 switch문
        keyword5 = (ImageView) findViewById(R.id.keyword5);
        keyword5.setOnClickListener(this); // 밑에 switch문
        keyword6 = (ImageView) findViewById(R.id.keyword6);
        keyword6.setOnClickListener(this); // 밑에 switch문
        keyword7 = (ImageView) findViewById(R.id.keyword7);
        keyword7.setOnClickListener(this); // 밑에 switch문
        keyword8 = (ImageView) findViewById(R.id.keyword8);
        keyword8.setOnClickListener(this); // 밑에 switch문
        keyword9 = (ImageView) findViewById(R.id.keyword9);
        keyword9.setOnClickListener(this); // 밑에 switch문
        keyword10 = (ImageView) findViewById(R.id.keyword10);
        keyword10.setOnClickListener(this); // 밑에 switch문
        keyword11 = (ImageView) findViewById(R.id.keyword11);
        keyword11.setOnClickListener(this); // 밑에 switch문
        keyword12 = (ImageView) findViewById(R.id.keyword12);
        keyword12.setOnClickListener(this); // 밑에 switch문
        keyword13 = (ImageView) findViewById(R.id.keyword13);
        keyword13.setOnClickListener(this); // 밑에 switch문
        keyword14 = (ImageView) findViewById(R.id.keyword14);
        keyword14.setOnClickListener(this); // 밑에 switch문
        keyword15 = (ImageView) findViewById(R.id.keyword15);
        keyword15.setOnClickListener(this); // 밑에 switch문
        keyword16 = (ImageView) findViewById(R.id.keyword16);
        keyword16.setOnClickListener(this); // 밑에 switch문
        keyword17 = (ImageView) findViewById(R.id.keyword17);
        keyword17.setOnClickListener(this); // 밑에 switch문
        keyword18 = (ImageView) findViewById(R.id.keyword18);
        keyword18.setOnClickListener(this); // 밑에 switch문



        //
        Slide_Id = (TextView) findViewById(R.id.slide_id);
        String id = model.getSlide_Id();
        Slide_Id.setText(id+" 님");


        find1_home = (ImageView) findViewById(R.id.find1_home);
        find1_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Home.class);
                intent.putExtra("homeid", model.getSlide_Id());

                startActivity(intent);
            }
        });



        ImageView go; // find1_2로넘어감 ( 상담예약 )
        go = (ImageView) findViewById(R.id.gofind1_2);
        go.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Counselorfind1_2.class);

                startActivity(intent);
            }
        });
        //

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

    private void initSildeMenu(){

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

        } else {
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
            case R.id.keyword2:
                if( i2 == 0 ){
                    keyword2.setImageResource(R.drawable.keyword_2);
                    i2=1;
                }
                else{
                    keyword2.setImageResource(R.drawable.keyword2);
                    i2=0;
                }
                break;
            case R.id.keyword3:
                if( i3 == 0 ){
                    keyword3.setImageResource(R.drawable.keyword_3);
                    i3=1;
                }
                else{
                    keyword3.setImageResource(R.drawable.keyword3);
                    i3=0;
                }
                break;
            case R.id.keyword4:
                if( i4 == 0 ){
                    keyword4.setImageResource(R.drawable.keyword_4);
                    i4=1;
                }
                else{
                    keyword4.setImageResource(R.drawable.keyword4);
                    i4=0;
                }
                break;
            case R.id.keyword5:
                if( i5 == 0 ){
                    keyword5.setImageResource(R.drawable.keyword_5);
                    i5=1;
                }
                else{
                    keyword5.setImageResource(R.drawable.keyword5);
                    i5=0;
                }
                break;
            case R.id.keyword6:
                if( i6 == 0 ){
                    keyword6.setImageResource(R.drawable.keyword_6);
                    i6=1;
                }
                else{
                    keyword6.setImageResource(R.drawable.keyword6);
                    i6=0;
                }
                break;
            case R.id.keyword7:
                if( i7 == 0 ){
                    keyword7.setImageResource(R.drawable.keyword_7);
                    i7=1;
                }
                else{
                    keyword7.setImageResource(R.drawable.keyword7);
                    i7=0;
                }
                break;
            case R.id.keyword8:
                if( i8 == 0 ){
                    keyword8.setImageResource(R.drawable.keyword_8);
                    i8=1;
                }
                else{
                    keyword8.setImageResource(R.drawable.keyword8);
                    i8=0;
                }
                break;
            case R.id.keyword9:
                if( i9 == 0 ){
                    keyword9.setImageResource(R.drawable.keyword_9);
                    i9=1;
                }
                else{
                    keyword9.setImageResource(R.drawable.keyword9);
                    i9=0;
                }
                break;
            case R.id.keyword10:
                if( i10 == 0 ){
                    keyword10.setImageResource(R.drawable.keyword_10);
                    i10=1;
                }
                else{
                    keyword10.setImageResource(R.drawable.keyword10);
                    i10=0;
                }
                break;
            case R.id.keyword11:
                if( i11 == 0 ){
                    keyword11.setImageResource(R.drawable.keyword_11);
                    i11=1;
                }
                else{
                    keyword11.setImageResource(R.drawable.keyword11);
                    i11=0;
                }
                break;
            case R.id.keyword12:
                if( i12 == 0 ){
                    keyword12.setImageResource(R.drawable.keyword_12);
                    i12=1;
                }
                else{
                    keyword12.setImageResource(R.drawable.keyword12);
                    i12=0;
                }
                break;
            case R.id.keyword13:
                if( i13 == 0 ){
                    keyword13.setImageResource(R.drawable.keyword_13);
                    i13=1;
                }
                else{
                    keyword13.setImageResource(R.drawable.keyword13);
                    i13=0;
                }
                break;
            case R.id.keyword14:
                if( i14 == 0 ){
                    keyword14.setImageResource(R.drawable.keyword_14);
                    i14=1;
                }
                else{
                    keyword14.setImageResource(R.drawable.keyword14);
                    i14=0;
                }
                break;
            case R.id.keyword15:
                if( i15 == 0 ){
                    keyword15.setImageResource(R.drawable.keyword_15);
                    i15=1;
                }
                else{
                    keyword15.setImageResource(R.drawable.keyword15);
                    i15=0;
                }
                break;
            case R.id.keyword16:
                if( i16 == 0 ){
                    keyword16.setImageResource(R.drawable.keyword_16);
                    i16=1;
                }
                else{
                    keyword16.setImageResource(R.drawable.keyword16);
                    i16=0;
                }
                break;
            case R.id.keyword17:
                if( i17 == 0 ){
                    keyword17.setImageResource(R.drawable.keyword_17);
                    i17=1;
                }
                else{
                    keyword17.setImageResource(R.drawable.keyword17);
                    i17=0;
                }
                break;
            case R.id.keyword18:
                if( i18 == 0 ){
                    keyword18.setImageResource(R.drawable.keyword_18);
                    i18=1;
                }
                else{
                    keyword18.setImageResource(R.drawable.keyword18);
                    i18=0;
                }
                break;


            case R.id.menu:         // 메뉴 이미지를 눌렀을때
                menuLeftSlideAnimationToggle(); //이 메소드 호출
                break;

            case R.id.s1: // 나의 상담내역으로
                if(isLeftExpanded==true) {// 메뉴열려있을시에만
                    Intent intent0 = new Intent(getApplicationContext(), MyCounselor_Schedual.class);

                    startActivity(intent0);
                    finish();
                }
                break;

            case R.id.find1btn:
                Intent intent0 = new Intent(getApplicationContext(), Counselorfind2.class);

                startActivity(intent0);
                finish();
                break;
        }
    }
}
