package com.feicui.news.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.feicui.news.R;

public class WebActivity extends AppCompatActivity {

    private String mUrl;
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        mUrl = getIntent().getStringExtra("url");

    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView = new WebView(this);
        // 设置可以支持缩放
        mWebView.getSettings().setSupportZoom(true);
        // 设置出现缩放工具
        mWebView.getSettings().setBuiltInZoomControls(true);
        //加载需要显示的网页  
        mWebView.loadUrl(mUrl);
        //设置web视图
        setContentView(mWebView);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }

    }
}
