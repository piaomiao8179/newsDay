package com.feicui.news.ui.fragment;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feicui.news.R;
import com.feicui.news.adapter.JokeAdapter;
import com.feicui.news.bean.JokeBean;
import com.feicui.news.dao.DividerItemDecoration;
import com.feicui.news.jsonhelper.JokeGson;
import com.feicui.news.jsonhelper.JsonUtils;
import com.feicui.news.ui.activity.WebActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class JokeFragment extends Fragment {
    private RecyclerView        mRecyclerView;
    private ArrayList<JokeBean> mList;

    public JokeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_content);
        //设置布局管理者
        mRecyclerView.hasFixedSize();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);

        //开启异步，获取数据
        //异步
        MyAsync myAsync = new MyAsync();
        myAsync.execute("http://c.m.163.com/nc/article/list/T1350383429665/0-20.html");

        return view;
    }

    public class MyAsync extends AsyncTask<String,Void,ArrayList<JokeBean>> {

        @Override
        protected ArrayList<JokeBean> doInBackground(String... strings) {
            mList = new ArrayList<>();
            String url = strings[0];
            String json = JsonUtils.getJSON(url);
            Gson gson = new Gson();
            JokeGson jokeGson = gson.fromJson(json, JokeGson.class);
            List<JokeGson.T1350383429665Bean> jokeList = jokeGson.getT1350383429665();
            for (int i = 0; i < jokeList.size(); i++) {
                String imgsrc = jokeList.get(i).getImgsrc();
                String title = jokeList.get(i).getTitle();
                String digest = jokeList.get(i).getDigest();
                String url_3w = jokeList.get(i).getUrl_3w();
                JokeBean jokeBean = new JokeBean();
                jokeBean.setUrlImage(imgsrc);
                jokeBean.setTitle(title);
                jokeBean.setSubtitle(digest);
                jokeBean.setUrlDetail(url_3w);
                mList.add(jokeBean);
            }
            return mList;
        }

        @Override
        protected void onPostExecute(ArrayList<JokeBean> list) {
            super.onPostExecute(list);

            //设置适配器
            JokeAdapter jokeAdapter = new JokeAdapter(getContext(), list);
            jokeAdapter.setOnItemClickListener(new JokeAdapter.MyItemClickListener() {
                @Override
                public void onItemClick(View view, int postion) {
                    String urlDetail = mList.get(postion).getUrlDetail();
                    Intent intent = new Intent(getContext(), WebActivity.class);
                    intent.putExtra("url",urlDetail);
                    startActivity(intent);
                }
            });
            mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL_LIST));
            mRecyclerView.setAdapter(jokeAdapter);
        }
    }
}
