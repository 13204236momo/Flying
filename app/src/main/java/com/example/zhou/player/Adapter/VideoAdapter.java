package com.example.zhou.player.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zhou.player.Activity.SystemVideoPlayerActivity;
import com.example.zhou.player.DoMain.MediaItemBean;
import com.example.zhou.player.R;
import com.example.zhou.player.Utils.Helper;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.provider.MediaStore.Video.Thumbnails.MICRO_KIND;

/**
 * Created by zhou on 2017/5/27.
 */

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {


    private Context context;
    private ArrayList<MediaItemBean> mediaList;

    public VideoAdapter(Context context, ArrayList<MediaItemBean> mediaList) {
        this.context = context;
        this.mediaList = mediaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = View.inflate(context, R.layout.video_item, null);
        return new ViewHolder(itemView);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MediaItemBean mediaItem = mediaList.get(position);

        Bitmap bitmap = Helper.getVideoThumbnail(mediaItem.getData(),85,85,MICRO_KIND);
        holder.ivPic.setImageBitmap(bitmap);
        holder.tvName.setText(mediaItem.getName());
        holder.tvSize.setText(Formatter.formatFileSize(context,mediaItem.getSize()));
        if (mediaItem.getArtist()!= null && !mediaItem.getArtist().equals("")){
            holder.tvArtist.setText(mediaItem.getArtist());
        }else {
            holder.tvArtist.setText("未知");
        }
        holder.llItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(context,mediaItem.toString(),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, SystemVideoPlayerActivity.class);
                intent.setDataAndType(Uri.parse(mediaItem.getData()),"vedio/*");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_pic)
        ImageView ivPic;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_artist)
        TextView tvArtist;
        @BindView(R.id.tv_size)
        TextView tvSize;
        @BindView(R.id.ll_item)
        LinearLayout llItem;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
