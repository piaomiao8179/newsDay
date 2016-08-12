package com.feicui.news.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.feicui.news.R;
import com.feicui.news.ui.fragment.RegisterFragment;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText    mEtUserName;
    private EditText    mEtUserPwd;
    private RadioButton mRBRem;
    private Button      mLogin, mRegister, mExit;
    private Intent      mIntent;
    private SharedPreferences mUserInfo;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        mEtUserName = (EditText) findViewById(R.id.et_username);
        mEtUserPwd = (EditText) findViewById(R.id.et_password);
        mRBRem = (RadioButton) findViewById(R.id.rb_rem_info);
        mLogin = (Button) findViewById(R.id.login);
        mRegister = (Button) findViewById(R.id.register);
        mExit = (Button) findViewById(R.id.exit);

        //获取sharedpreferences的对象
        mUserInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
        //判断记住密码多选框的状态
        Log.d(TAG, "init: " + mUserInfo.getBoolean("ISCHECK", false));
        if(mUserInfo.getBoolean("ISCHECK", true)) {
            //设置默认是记录密码状态
            mRBRem.setChecked(true);
            mEtUserName.setText(mUserInfo.getString("USER_NAME", ""));
            mEtUserPwd.setText(mUserInfo.getString("PASSWORD", ""));

            //跳转另一个页面   个人信息
            mIntent = new Intent(LoginActivity.this, PersonActivity.class);
            startActivity(mIntent);
            finish();
        }

        //给登陆控件设置监听
        mLogin.setOnClickListener(this);
        //给注册控件设置监听
        mRegister.setOnClickListener(this);
        //退出监听
        mExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login :
                String userName = mEtUserName.getText().toString().trim();
                String passWord = mEtUserPwd.getText().toString().trim();
                Log.d(TAG, "onClick: " + mUserInfo.getString("USER_NAME",""));
                if (userName.equals(mUserInfo.getString("USER_NAME",""))&&
                        passWord.equals(mUserInfo.getString("PASSWORD",""))) {
                    Intent intent = new Intent(LoginActivity.this, PersonActivity.class);
                    startActivity(intent);
                }

                break;
            case R.id.register :
                //加入一个fragment
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.ll_fragment,new RegisterFragment()).
                        setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
                break;
            case R.id.exit :
                finish();
                break;
        }
    }

}
