package com.sarfaraj.newsapp.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sarfaraj.newsapp.MainActivity;
import com.sarfaraj.newsapp.Models.CategoryItemModel;
import com.sarfaraj.newsapp.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    ArrayList<CategoryItemModel> arrayList;
    Context context;
    OnCategoryClick onCategoryClick;

    public CategoryAdapter(ArrayList<CategoryItemModel> arrayList, Context context, OnCategoryClick onCategoryClick) {
        this.arrayList = arrayList;
        this.context = context;
        this.onCategoryClick = onCategoryClick;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_rec_view_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        CategoryItemModel model = arrayList.get(position);

        Glide.with(context).load(model.getImgUrl()).into(holder.imageView);
        holder.textView.setText(model.getCategory_text());

        if(position == MainActivity.selectedTypePos) {
            holder.textView.setTextColor(Color.parseColor("#FF000000"));
            holder.layoutHover.setVisibility(View.VISIBLE);
        } else {
            holder.textView.setTextColor(Color.parseColor("#4E4A55"));
            holder.layoutHover.setVisibility(View.GONE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(position != MainActivity.selectedTypePos) {
                    onCategoryClick.categoryClicked(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;
        private LinearLayout layoutHover;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.id_category_ImageView);
            textView = itemView.findViewById(R.id.id_category_TextView);
            layoutHover=itemView.findViewById(R.id.layout_hover);
        }
    }

    public interface OnCategoryClick {
        void categoryClicked(int position);
    }
}
