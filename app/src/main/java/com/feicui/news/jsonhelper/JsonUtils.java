package com.feicui.news.jsonhelper;

import android.util.Log;

import com.feicui.news.bean.TopBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/8/5.
 */
public class JsonUtils {
    private static ArrayList<TopBean> mList;
    private static final String TAG = "JsonUtils";
    //获取json字符串


    //进行联网操作
    private  static OkHttpClient mClient = new OkHttpClient();
    private  static String  sJson;
    private static  TopBean sTopBean;

    public static String getJSON (String url) {
        //请求阶段
        Request request = new Request.Builder().url(url).build();
        //响应阶段
        try {
            Response response = mClient.newCall(request).execute();
            if (response.isSuccessful()) {
                sJson = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sJson;
    }


    //解析json字符串   利用Gson
    public static ArrayList<TopBean> parseJson (String json) {
        mList = new ArrayList<>();
        Gson gson = new Gson();
        NewsBean1 newsBean = gson.fromJson(json, NewsBean1.class);
        //解析数据
        List<NewsBean1.ResultBean.DataBean> data = newsBean.getResult().getData();
        Log.d(TAG, "parseJson: " + data.size());
        for (int i = 1; i < data.size(); i++) {
            String url = data.get(i).getUrl();
            String title = data.get(i).getTitle();
            String digest = data.get(i).getDate();
            String pic_s = data.get(i).getThumbnail_pic_s();
            sTopBean = new TopBean();
            sTopBean.setUrlImage(pic_s);
            sTopBean.setTitle(title);
            sTopBean.setSubtitle(digest);
            sTopBean.setUrlDetail(url);
            mList.add(sTopBean);
        }

        return mList;
    }
}
