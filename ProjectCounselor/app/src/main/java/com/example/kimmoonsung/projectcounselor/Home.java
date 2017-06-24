package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;
import android.content.Intent;
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
 * Created by kimmoonsung on 2017. 5. 28..
 */

public class Home extends Activity implements OnClickListener{
    /* slide menu */
    private DisplayMetrics metrics;
    private LinearLayout ll_mainLayout;
    private LinearLayout ll_menuLayout;
    private FrameLayout.LayoutParams leftMenuLayoutPrams;
    private int leftMenuWidth;
    private static boolean isLeftExpanded;
    //  private Button bt_left;


    private ImageView menu1; // 메뉴 이미지 슬라이드 열리는 메뉴 이미지

    ImageView s1; // slide ㅇㅣ미지

    String Individual_Id="null";
    String Individual_Nickname="null"; // 개인회원가입에서 받아옴

    //
    String Counselor_Id;
    String Counselor_Nickname; // 상담회원가입에서 받아옴

    //
    String Login_Id; // 로그인에서 받아옴
    //
    //
    String Home_Id; // 홈버튼에서 받아옴
    //

    String TotalId; // 최종

    ///////

    TextView SlideId;

    MODEL model = MODEL.getInstance();


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, // 상태바없애기
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        initSildeMenu();


        ImageView findcounselor;
        findcounselor = (ImageView)findViewById(R.id.counselorfind);

        findcounselor.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) { // 상담사 찾기로

                Intent intent = new Intent(getApplicationContext(), Counselorfind1.class);

                startActivity(intent);
            }
        });


        //슬라이드 -> 나의상담내역으로 가는것
        s1 = (ImageView) findViewById(R.id.s1);
        s1.setOnClickListener(this);

        //////////////////////

        //개인회원가입에서
        Individual_Id= getIntent().getStringExtra("individual_id"); // 받아온 아이디
        Individual_Nickname= getIntent().getStringExtra("individual_nickname"); //받아온 닉네임

        //상담원회원가입에서
        Counselor_Id= getIntent().getStringExtra("counselor_id"); // 받아온 상담원 아이디
        Counselor_Nickname = getIntent().getStringExtra("counselor_nickname"); //받아온 닉네임

        //로그인에서
        Login_Id = getIntent().getStringExtra("loginid");
        //

        //home 버튼에서
        Home_Id = getIntent().getStringExtra("homeid");
        //



        if(Individual_Id!=null){
            TotalId = Individual_Id;
        }
        else if(Counselor_Id!=null){
            TotalId = Counselor_Id;
        }
        else if(Login_Id!=null){
            TotalId = Login_Id;
        }
        else{
            TotalId = Home_Id;
        }


        SlideId = (TextView) findViewById(R.id.slide_id);
        SlideId.setText(TotalId +" 님");

        model.setSlide_Id(TotalId);

        Toast.makeText(getApplication(), model.getSlide_Id() +" 님 안녕하세요 ", Toast.LENGTH_SHORT).show();


        //////////////////////


        ImageView go; // find1_2로넘어감 ( 상담예약 )
        go = (ImageView) findViewById(R.id.gofind1_2);
        go.setOnClickListener(new View.OnClickListener() { // 로그인페이지로 이동
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Counselorfind1_2.class);

                startActivity(intent);
            }
        });

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
                    new OnTouchListener() {

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
            case R.id.menu:         // 메뉴 이미지를 눌렀을때
                menuLeftSlideAnimationToggle(); //이 메소드 호출

                break;

            case R.id.s1: // 나의 상담내역으로
                if(isLeftExpanded==true) { // 메뉴열려있을시에만
                    Intent intent = new Intent(getApplicationContext(), MyCounselor_Schedual.class);
                    startActivity(intent);
                }
                break;
        }

    }

    @Override
    public void onDestroy() { // 뒤로가기 눌렀을시 앱종료
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid() );

    }
}
