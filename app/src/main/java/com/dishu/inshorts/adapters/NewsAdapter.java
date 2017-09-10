package com.dishu.inshorts.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dishu.inshorts.R;
import com.dishu.inshorts.models.News;

import java.util.List;

/**
 * Created by Dishu on 9/11/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private List<News> news;
    private int rowLayout;
    private Context context;

    public NewsAdapter(){}
    public NewsAdapter(List<News> news, int rowlayout, Context context){
        this.news = news;
        this.rowLayout = rowlayout;
        this.context = context;
    }



    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.txt_title.setText(news.get(position).getTITLE());
        holder.txt_publisher.setText(news.get(position).getPUBLISHER());
        holder.txt_category.setText(news.get(position).getCATEGORY());
        holder.txt_host.setText(news.get(position).getHOSTNAME());
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public static class NewsHolder extends RecyclerView.ViewHolder{
        TextView txt_title;
        TextView txt_publisher;
        TextView txt_category;
        TextView txt_host;

        public NewsHolder(View itemView) {
            super(itemView);
            txt_title = (TextView) itemView.findViewById(R.id.txt_title);
            txt_publisher = (TextView) itemView.findViewById(R.id.txt_publisher);
            txt_category = (TextView) itemView.findViewById(R.id.txt_category);
            txt_host = (TextView) itemView.findViewById(R.id.txt_host);
//            txt_title = (TextView) itemView.findViewById(R.id.txt_title);

        }
//        TextView txt_title;
//        TextView txt_title;

    }
}
