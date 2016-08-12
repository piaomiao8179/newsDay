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
import com.feicui.news.adapter.NBAAdapter;
import com.feicui.news.bean.NBABean;
import com.feicui.news.dao.DividerItemDecoration;
import com.feicui.news.jsonhelper.JsonUtils;
import com.feicui.news.jsonhelper.NBAGson;
import com.feicui.news.ui.activity.WebActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class NBAFragment extends Fragment {
    private RecyclerView       mRecyclerView;
    private ArrayList<NBABean> mList;

    public NBAFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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
        myAsync.execute("http://c.m.163.com/nc/article/list/T1348649145984/0-20.html");


        return view;
    }

    public class MyAsync extends AsyncTask<String,Void,ArrayList<NBABean>> {

        @Override
        protected ArrayList<NBABean> doInBackground(String... strings) {
            mList = new ArrayList<>();
            String url = strings[0];
            String json = JsonUtils.getJSON(url);
            Gson gson = new Gson();
            NBAGson nbaGson = gson.fromJson(json, NBAGson.class);
            List<NBAGson.T1348649145984Bean> nbaList = nbaGson.getT1348649145984();
            for (int i = 0; i < nbaList.size(); i++) {
                String imgsrc = nbaList.get(i).getImgsrc();
                String title = nbaList.get(i).getTitle();
                String digest = nbaList.get(i).getDigest();
                String url_3w = nbaList.get(i).getUrl_3w();
                NBABean nbaBean = new NBABean();
                nbaBean.setUrlImage(imgsrc);
                nbaBean.setTitle(title);
                nbaBean.setSubtitle(digest);
                nbaBean.setUrlDetail(url_3w);
                mList.add(nbaBean);
            }
            return mList;
        }

        @Override
        protected void onPostExecute(ArrayList<NBABean> list) {
            super.onPostExecute(list);

            //设置适配器
            NBAAdapter nbaAdapter = new NBAAdapter(getContext(), list);
            nbaAdapter.setOnItemClickListener(new NBAAdapter.MyItemClickListener() {
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
            mRecyclerView.setAdapter(nbaAdapter);
        }
    }

}
