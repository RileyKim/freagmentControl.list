package com.taeksukim.android.fragmentcontrol;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements BlankFragment.Listener{
    //datas 변수를 MainActivity에 정의
    String datas[] = {"월", "화", "수", "목", "금", "토", "일"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        // 1. fragment 생성
//        BlankFragment fragment  = new BlankFragment();
//
//        // 2. fragment manager 가져오기
//        // getFragmentManager(); // 앱 호환성이 없는 매니저함수
//        FragmentManager manager = getSupportFragmentManager(); // 앱 호환성이 있는 매니저함수
//
//        //3. fragment를 실행하기위한 transaction 시작
//        FragmentTransaction transaction = manager.beginTransaction();
//        //4. fragment를 레이아웃에 add한다
//        transaction.add(R.id.fragment, fragment);
//        //5. git의 commit과 같은 기능
//        transaction.commit();

    }

    //2. 인터페이스 구현
    @Override
    public String[] getdata() {
        return datas;

    }
}
