package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataRecycleView extends RecyclerView.Adapter<DataRecycleView.DataViewHolder> {

    public static final String TAG = "DATA_ADAPTER";
    private List<Data> dataList;

    private OnItemClickListener onItemClickListener;
    private OnImageViewClickListener onImageViewClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public void setOnImageViewClickListener(OnImageViewClickListener listener) {
        this.onImageViewClickListener = listener;
    }

    public DataRecycleView(List<Data> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item, parent, false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: " + position);

        Data data = dataList.get(position);
        holder.image.setImageResource(data.getImage());
        holder.Title.setText(data.getTitle());
        holder.subTitle.setText(data.getSubTitle());
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class DataViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView Title, subTitle;

        public DataViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            Title = itemView.findViewById(R.id.Title);
            subTitle = itemView.findViewById(R.id.subTitle);

            image.setOnClickListener(view -> {
                if (onImageViewClickListener != null) {
                    onImageViewClickListener.onImageClick(image, getAdapterPosition());
                }
            });

            itemView.setOnClickListener(view -> {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public interface OnImageViewClickListener {
        void onImageClick(ImageView iv, int position);
    }
}
