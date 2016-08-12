package com.feicui.news.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.feicui.news.R;

/**
 * Created by Administrator on 2016/8/9.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {
    private Context mContext;
    private String[] mSort = {"头条","汽车","笑话","图片","NBA","军事","社会","济南"};
    private MyItemClickListener mItemClickListener;

    public MainAdapter(Context context) {
        mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_main_top,parent,false);

        return new MyViewHolder(view,mItemClickListener);
    }

    /**
     * 设置Item点击监听
     * @param listener
     */
    public void setOnItemClickListener(MyItemClickListener listener){
        this.mItemClickListener = listener;
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.mTextView.setText(mSort[position]);


    }

    @Override
    public int getItemCount() {
        if (mSort.length != 0) {
            return mSort.length;
        }
        return 0;
    }




    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView mTextView;
        private MyItemClickListener mListener;

        private static final String TAG = "MyViewHolder";
        public MyViewHolder(View itemView,MyItemClickListener listener) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.tv_main_top);
            this.mListener = listener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(mListener != null){
                mListener.onItemClick(view,getPosition());
            }

        }
    }

    public interface MyItemClickListener {
        void onItemClick(View view,int postion);
    }

}
