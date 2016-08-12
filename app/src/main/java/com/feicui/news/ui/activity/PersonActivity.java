package com.feicui.news.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.feicui.news.R;

/**
 * Created by Administrator on 2016/8/12.
 */
public class PersonActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnSeeNews;
    private Button mBtnIntentLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        mBtnSeeNews = (Button) findViewById(R.id.btn_see_news);
        mBtnIntentLogin = (Button) findViewById(R.id.btn_intent_login);
        mBtnIntentLogin.setOnClickListener(this);
        mBtnSeeNews.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_intent_login :
                SharedPreferences userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
                SharedPreferences.Editor edit = userInfo.edit();
                edit.putBoolean("ISCHECK",false);
                edit.commit();
                this.startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
            case R.id.btn_see_news :
                this.startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
        }
    }
}
