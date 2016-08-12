package com.feicui.news.ui.fragment;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.feicui.news.R;
import com.feicui.news.adapter.MyAdapter;
import com.feicui.news.bean.TopBean;
import com.feicui.news.dao.DividerItemDecoration;
import com.feicui.news.jsonhelper.JsonUtils;
import com.feicui.news.ui.activity.WebActivity;

import java.util.ArrayList;

import lumenghz.com.pullrefresh.PullToRefreshView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private ArrayList<TopBean> mList;
    private static final String TAG = "NewsFragment";
    private PullToRefreshView mPullToRefresh;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        //设置下拉
        mPullToRefresh = (PullToRefreshView) view.findViewById(R.id.pull_to_refresh);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_content);
        //设置布局管理者
        mRecyclerView.hasFixedSize();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(manager);

        //初始化下拉刷新
        initRefreshView();

        //开启异步，获取数据
        //异步
        MyAsync myAsync = new MyAsync();
        myAsync.execute("http://v.juhe.cn/toutiao/index?type=top&key=6205f054fd4c6699569981dc59ef0f67");

        return view;
    }

    private void initRefreshView() {
        mPullToRefresh.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "正在刷新。。。", Toast.LENGTH_SHORT).show();
                mPullToRefresh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mPullToRefresh.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }
    public class MyAsync extends AsyncTask<String,Void,ArrayList<TopBean>> {

        @Override
        protected ArrayList<TopBean> doInBackground(String... strings) {
            String url = strings[0];
            String json = JsonUtils.getJSON(url);
            mList = JsonUtils.parseJson(json);
            return mList;
        }

        @Override
        protected void onPostExecute(ArrayList<TopBean> list) {
            super.onPostExecute(list);

            //设置适配器
            // TODO: 2016/8/8
            MyAdapter myAdapter = new MyAdapter(getContext(), list);
            myAdapter.setOnItemClickListener(new MyAdapter.MyItemClickListener() {
                @Override
                public void onItemClick(View view, int postion) {
                    String urlDetail = mList.get(postion).getUrlDetail();
                    Log.d(TAG, "onItemClick: "+urlDetail);
                    Intent intent = new Intent(getContext(), WebActivity.class);
                    intent.putExtra("url",urlDetail);
                    startActivity(intent);

                }
            });
            mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL_LIST));
            mRecyclerView.setAdapter(myAdapter);
        }
    }
}
