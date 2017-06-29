package com.example.zhou.player.Activity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.zhou.player.R;
import com.example.zhou.player.Utils.Helper;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by zhou on 2017/5/28.
 */

public class SystemVideoPlayerActivity extends Activity {

    @BindView(R.id.videoView)
    VideoView videoView;

    private Uri uri;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        //得到播放地址
        uri = getIntent().getData();
        if (uri != null){
            videoView.setVideoURI(uri);

        }
        videoView.setMediaController(new MediaController(this));
        //播放准备好监听
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.start();
            }
        });
        //播放出错监听
        videoView.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Helper.showToast("播放出错了呦.. ( ＞ω＜)");
                return false;
            }
        });
        //播放完成监听
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {

            }
        });
    }
}
