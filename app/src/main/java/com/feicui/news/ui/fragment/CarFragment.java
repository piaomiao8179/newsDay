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

import com.feicui.news.R;
import com.feicui.news.adapter.CarAdapter;
import com.feicui.news.bean.CarBean;
import com.feicui.news.dao.DividerItemDecoration;
import com.feicui.news.jsonhelper.CarGson;
import com.feicui.news.jsonhelper.JsonUtils;
import com.feicui.news.ui.activity.WebActivity;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarFragment extends Fragment {
    private RecyclerView       mRecyclerView;
    private ArrayList<CarBean> mList;
    private static final String TAG = "CarFragment";

    public CarFragment() {
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
        myAsync.execute("http://c.m.163.com/nc/article/list/T1348654060988/0-20.html");


        return view;
    }

    public class MyAsync extends AsyncTask<String,Void,ArrayList<CarBean>> {

        @Override
        protected ArrayList<CarBean> doInBackground(String... strings) {
            mList = new ArrayList<>();
            String url = strings[0];
            String json = JsonUtils.getJSON(url);
            Gson gson = new Gson();
            CarGson carGson = gson.fromJson(json, CarGson.class);
            List<CarGson.T1348654060988Bean> carList = carGson.getT1348654060988();
            for (int i = 0; i < carList.size(); i++) {
                String imgsrc = carList.get(i).getImgsrc();
                String title = carList.get(i).getTitle();
                String digest = carList.get(i).getDigest();
                String url_3w = carList.get(i).getUrl_3w();
                CarBean carBean = new CarBean();
                carBean.setUrlImage(imgsrc);
                carBean.setTitle(title);
                carBean.setSubtitle(digest);
                carBean.setUrlDetail(url_3w);
                mList.add(carBean);
            }
            return mList;
        }

        @Override
        protected void onPostExecute(ArrayList<CarBean> list) {
            super.onPostExecute(list);

            //设置适配器
            // TODO: 2016/8/8
            CarAdapter carAdapter = new CarAdapter(getContext(), list);
            carAdapter.setOnItemClickListener(new CarAdapter.MyItemClickListener() {
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
            mRecyclerView.setAdapter(carAdapter);
        }
    }
}
