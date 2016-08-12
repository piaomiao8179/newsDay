package com.feicui.news.ui.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.feicui.news.R;
import com.feicui.news.ui.activity.MainActivity;
import com.feicui.news.ui.activity.PersonActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    private EditText mUserNameRegister;
    private EditText mUserPwdRegister;
    private EditText mUserRePwdRegister;
    private Button mUserCommit;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        mUserNameRegister = (EditText) view.findViewById(R.id.et_username_register);
        mUserPwdRegister = (EditText) view.findViewById(R.id.et_password_register);
        mUserRePwdRegister = (EditText) view.findViewById(R.id.et_repassword_register);
        mUserCommit = (Button) view.findViewById(R.id.register_fragment);

        mUserCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断注册信息
                judgeRegister();
                //跳转进入个人信息
                startActivity(new Intent(getContext(), PersonActivity.class));
            }
        });
        return view;
    }


    private void judgeRegister() {
        String userName = mUserNameRegister.getText().toString().trim();
        String userPwd = mUserPwdRegister.getText().toString().trim();
        String reUserPwd = mUserRePwdRegister.getText().toString().trim();
        if (userName.length() != 0) {
            if (userPwd.equals(reUserPwd)) {
                //注册成功   存入sp文件中
                SharedPreferences userInfo = getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = userInfo.edit();
                edit.putString("USER_NAME",userName);
                edit.putString("PASSWORD",userPwd);
                edit.putBoolean("ISCHECK",true);
                edit.commit();
                //弹出toast提示
                Toast.makeText(getContext(), "注册成功，祝您使用愉快~~~", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "注册失败，请重新注册", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
