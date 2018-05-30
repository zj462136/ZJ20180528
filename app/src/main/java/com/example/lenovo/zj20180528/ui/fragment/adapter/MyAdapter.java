package com.example.lenovo.zj20180528.ui.fragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.zj20180528.R;
import com.example.lenovo.zj20180528.bean.BaseBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater inflater;
    Context context;
    List<BaseBean.NewslistBean> newslist;

    public MyAdapter(Context context, List<BaseBean.NewslistBean> newslist) {
        this.context=context;
        this.newslist=newslist;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.search_item,parent,false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SearchHolder searchHolder= (SearchHolder) holder;
        BaseBean.NewslistBean newslistBean = newslist.get(position);
        searchHolder.draweeView.setImageURI(newslistBean.getPicUrl());
        searchHolder.text_time.setText(newslistBean.getCtime());
        searchHolder.text_title.setText(newslistBean.getTitle());
    }

    @Override
    public int getItemCount() {
        if (newslist!=null) {
            return newslist.size();
        }
        return 0;
    }
    class SearchHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView draweeView;
        private final TextView text_title;
        private final TextView text_time;

        public SearchHolder(View itemView) {
            super(itemView);
            draweeView = itemView.findViewById(R.id.drawee_view);
            text_title = itemView.findViewById(R.id.text_title);
            text_time = itemView.findViewById(R.id.text_time);
        }
    }
}
