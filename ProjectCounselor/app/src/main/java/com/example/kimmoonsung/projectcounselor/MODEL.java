package com.example.kimmoonsung.projectcounselor;

import android.app.Activity;

/**
 * Created by kimmoonsung on 2017. 5. 31..
 */

public class MODEL extends Activity{

    private static MODEL instance;
    private String Slide_Id; // 슬라이드메뉴 위한 변수
    private String Spinner_item; // 스피너선택 변수


    public static MODEL getInstance(){
        if(instance==null){
            instance = new MODEL();
        }
        return instance;
    }
    public String getSlide_Id() {
        return Slide_Id;
    }

    public void setSlide_Id(String Slide_Id) {
        this.Slide_Id = Slide_Id;
    }

    public String getSpinner_item() {
        return Spinner_item;
    }

    public void setSpinner_item(String Spinner_item) {
        this.Spinner_item = Spinner_item;
    }



}
