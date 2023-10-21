package com.example.youtubeclone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.List;

public class HomeVideoAdapter extends RecyclerView.Adapter<HomeVideoAdapter.HomeVideoViewHolder>{

    private List<HomeVideoData> list = Collections.emptyList();

    private Context context;

    public HomeVideoAdapter(List<HomeVideoData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public HomeVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.home_video_item, parent, false);

        HomeVideoViewHolder viewHolder = new HomeVideoViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeVideoViewHolder holder, int position) {
        final int index = holder.getAdapterPosition();
        holder.videoTitle.setText(list.get(position).videoTitle);
        holder.videoDescription.setText(list.get(position).videoDetail);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CLICKED ON POSITION "+index, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeVideoViewHolder extends RecyclerView.ViewHolder {

        private ImageView thumbnail;

        private ImageView channelIcon;

        private TextView videoTitle;

        private TextView videoDescription;

        public HomeVideoViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnail);

            channelIcon = itemView.findViewById(R.id.channel_logo);

            videoTitle = itemView.findViewById(R.id.video_title);

            videoDescription = itemView.findViewById(R.id.video_detail);
        }
    }

    public static class HomeVideoData {
        private String videoTitle;

        private String videoDetail;

        public HomeVideoData(String videoTitle, String videoDetail) {
            this.videoTitle = videoTitle;
            this.videoDetail = videoDetail;
        }
    }
}
