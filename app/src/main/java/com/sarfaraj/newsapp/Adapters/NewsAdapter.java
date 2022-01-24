package com.sarfaraj.newsapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sarfaraj.newsapp.DetailsActivity;
import com.sarfaraj.newsapp.MainActivity;
import com.sarfaraj.newsapp.Models.NewsItemModel;
import com.sarfaraj.newsapp.R;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    ArrayList<NewsItemModel> arrayList;
    Context context;

    public NewsAdapter(ArrayList<NewsItemModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.news_recview_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        NewsItemModel newsItemModel=arrayList.get(position);

        Glide.with(context).load(newsItemModel.getImgUrl()).into(holder.imageView);
        holder.title.setText(newsItemModel.getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, DetailsActivity.class);
                intent.putExtra("imageUrl",newsItemModel.getImgUrl());
                intent.putExtra("desc",newsItemModel.getDesc());
                intent.putExtra("title",newsItemModel.getTitle());
                intent.putExtra("article_link",newsItemModel.getArticleLink());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.id_news_ImageView);
            title=itemView.findViewById(R.id.id_news_titleTextView);
        }
    }
}
