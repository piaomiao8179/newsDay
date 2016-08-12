package com.feicui.news.ui.fragment;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feicui.news.R;
import com.feicui.news.adapter.PictureAdapter;
import com.feicui.news.bean.PictureBean;
import com.feicui.news.dao.DividerItemDecoration;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {
    private RecyclerView       mRecyclerView;
    private ArrayList<PictureBean> mList;
    private OkHttpClient mClient = new OkHttpClient();
    private static final String TAG = "PictureFragment";
    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_picture);
        //设置布局管理者
        mRecyclerView.hasFixedSize();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);


        //获取图片  给控件设置
        //开启异步，获取数据
        //异步
        MyAsync myAsync = new MyAsync();
        myAsync.execute("http://api.laifudao.com/open/tupian.json");

        return view;
    }

    public class MyAsync extends AsyncTask<String, Void, ArrayList<PictureBean>> {

        private String mJson;

        @Override
        protected ArrayList<PictureBean> doInBackground(String... strings) {
            String url = strings[0];
            //请求阶段
            Request request = new Request.Builder().url(url).build();
            //响应阶段
            try {
                Response response = mClient.newCall(request).execute();
                if (response.isSuccessful()) {
                    mJson = response.body().string();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            //解析获取的json
            try {
                mList = new ArrayList<>();
                JSONArray object = new JSONArray(mJson);
                for (int i = 0; i < object.length(); i++) {
                    JSONObject obj = (JSONObject) object.get(i);
                    String src = obj.getString("thumburl");
                    String title = obj.getString("title");
                    Log.d(TAG, "doInBackground: " + title);
                    PictureBean pictureBean = new PictureBean();
                    pictureBean.setSrc(src);
                    pictureBean.setText(title);
                    mList.add(pictureBean);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mList;
        }

        @Override
        protected void onPostExecute(ArrayList<PictureBean> list) {
            super.onPostExecute(list);
            //设置适配器
            // TODO: 2016/8/8
            mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL_LIST));
            mRecyclerView.setAdapter(new PictureAdapter(getContext(),list));
        }
    }
}
