package com.feicui.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.feicui.news.R;
import com.feicui.news.bean.PictureBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/9.
 */
public class PictureAdapter extends RecyclerView.Adapter <PictureAdapter.MyViewHolder> {
    private Context            mContext;
    private ArrayList<PictureBean> mList;
    private MyViewHolder       mMyViewHolder;

    public PictureAdapter(Context context, ArrayList<PictureBean> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycler_picture, parent,false);
        mMyViewHolder = new MyViewHolder(view);

        return mMyViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //设置要显示的内容
        Picasso.with(mContext).load(mList.get(position).getSrc()).into(holder.mImageView);
        holder.mTextView.setText(mList.get(position).getText());
    }


    @Override
    public int getItemCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView  mTextView;

        public MyViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView) itemView.findViewById(R.id.card_image);
            mTextView = (TextView) itemView.findViewById(R.id.card_tv);
        }
    }

}
