package com.example.youtubeclone.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.youtubeclone.R;
import com.example.youtubeclone.data.repository.HomeVideoData;
import com.example.youtubeclone.model.YoutubeVideos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class HomeVideoAdapter extends RecyclerView.Adapter<HomeVideoAdapter.HomeVideoViewHolder> {

    private Context context;

    DiffUtil.ItemCallback<YoutubeVideos> diffCallback = new DiffUtil.ItemCallback<YoutubeVideos>() {
        @Override
        public boolean areItemsTheSame(@NonNull YoutubeVideos oldItem, @NonNull YoutubeVideos newItem) {
            return Objects.equals(oldItem.getId(), newItem.getId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull YoutubeVideos oldItem, @NonNull YoutubeVideos newItem) {
            return Objects.equals(oldItem.getId(), newItem.getId());
        }
    };

    private AsyncListDiffer<YoutubeVideos> differ = new AsyncListDiffer<>(this, diffCallback);

    public void setList(List<YoutubeVideos> list) {
        differ.submitList(list);
    }

    public HomeVideoAdapter(Context context) {
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
//        holder.videoTitle.setText(list.get(position).getVideoTitle());
//        holder.videoDescription.setText(list.get(position).getVideoDetail());
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "CLICKED ON POSITION "+index, Toast.LENGTH_SHORT).show();
//            }
//        });
        YoutubeVideos video = differ.getCurrentList().get(index);
        String thumbnailUrl = video.getSnippet().getThumbnails().getMedium().getUrl();
        String channelLogo = video.getSnippet().getThumbnails().getMedium().getUrl();
        String title = video.getSnippet().getTitle();
        String channel = video.getSnippet().getChannelTitle();
        String views = viewsCount(Integer.parseInt(video.getStatistics().getViewCount()));
        String publishedAt = convert(video.getSnippet().getPublishedAt());

        Glide.with(context).load(thumbnailUrl).into(holder.thumbnail);
        Glide.with(context).load(channelLogo).into(holder.channelIcon);
        holder.videoTitle.setText(title);
        holder.videoDescription.setText(channel + " • " + views + " views • " + publishedAt);
    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }

    public class HomeVideoViewHolder extends RecyclerView.ViewHolder {

        private CardView thumbnailContainer;

        private ImageView thumbnail;

        private ImageView channelIcon;

        private TextView videoTitle;

        private TextView videoDescription;

        public HomeVideoViewHolder(@NonNull View itemView) {
            super(itemView);

            thumbnail = itemView.findViewById(R.id.thumbnailImage);

            channelIcon = itemView.findViewById(R.id.channel_logo);

            videoTitle = itemView.findViewById(R.id.video_title);

            videoDescription = itemView.findViewById(R.id.video_detail);
        }
    }

    private String viewsCount(Integer views) {
        if (views >= 1000000000) {
            return String.format("%.1fB", views / 1000000000.0);
        } else if (views >= 1000000) {
            return String.format("%.1fM", views / 1000000.0);
        } else if (views >= 1000) {
            return String.format("%.1fK", views / 1000.0);
        } else {
            return String.format("%d", views);
        }
    }

    private String convert(String publishedDay) {
        DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        LocalDateTime publishedAt = LocalDateTime.parse(publishedDay, formatPattern);

        LocalDateTime currentDate = LocalDateTime.now().withNano(0);

        Long differenceInSeconds = ChronoUnit.SECONDS.between(publishedAt, currentDate);
        Long differenceInDays = ChronoUnit.DAYS.between(publishedAt, currentDate);
        Long differenceInMonths = ChronoUnit.MONTHS.between(publishedAt, currentDate);

        return findDifference(differenceInSeconds, differenceInDays, differenceInMonths);
    }

    private String findDifference(Long differenceInSeconds, Long differenceInDays, Long differenceInMonths) {
        Long hours = differenceInSeconds / 3600;

        if (21 <= differenceInDays && differenceInDays <= 31) {
            return "3 weeks ago";
        } else if (14 <= differenceInDays && differenceInDays <= 20) {
            return "2 weeks ago";
        } else if (2 <= differenceInDays && differenceInDays <= 13) {
            return differenceInDays + " days ago";
        } else if (0 <= differenceInDays && differenceInDays <= 1) {
            return hours + " hours ago";
        }

        if (0 <= differenceInMonths && differenceInMonths <= 1) {
            return differenceInMonths + " month ago";
        } else {
            return differenceInMonths + " months ago";
        }
    }
}
