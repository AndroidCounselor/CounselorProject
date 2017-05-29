package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by kimmoonsung on 2017. 5. 28..
 */

public class Member_Individual extends Activity{
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없애기
        setContentView(R.layout.activity_member_individual);
    }
}
