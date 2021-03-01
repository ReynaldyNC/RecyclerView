/*
 * Copyright (c) 2021. Reynaldy Nurcahyo
 */

package com.reynaldynurcahyo.projectrecyclerview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ListViewHolder> {
    private final ArrayList<Item> listItem;

    public ItemAdapter(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_data, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Item item = listItem.get(position);
        Glide.with(holder.itemView.getContext())
                .asBitmap()
                .load(item.getImage())
                .into(holder.ivImage);
        holder.tvName.setText(item.getName());
        holder.tvDesc.setText(item.getDesc());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail = new Intent(holder.itemView.getContext(), DetailActivity.class);
                detail.putExtra("item_image", item.getImage());
                detail.putExtra("item_name", item.getName());
                detail.putExtra("item_desc", item.getDesc());
                detail.putExtra("item_release", item.getRelease());
                detail.putExtra("item_creator", item.getCreator());
                holder.itemView.getContext().startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView ivImage;
        TextView tvName, tvDesc, tvCreator, tvRelease;
        LinearLayout linearLayout;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            ivImage = itemView.findViewById(R.id.item_image);
            tvName = itemView.findViewById(R.id.item_name);
            tvDesc = itemView.findViewById(R.id.item_desc);
            tvCreator = itemView.findViewById(R.id.item_creator);
            tvRelease = itemView.findViewById(R.id.item_release);
            linearLayout = itemView.findViewById(R.id.item_layout);
        }
    }
}
