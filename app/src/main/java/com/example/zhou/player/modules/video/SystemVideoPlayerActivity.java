package com.example.zhou.player.modules.video;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.zhou.player.R;
import com.example.zhou.player.common.UIBySelf.TextViewCustom;
import com.example.zhou.player.common.Utils.AnimUtils;
import com.example.zhou.player.common.Utils.Helper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zhou on 2017/5/28.
 */

public class SystemVideoPlayerActivity extends Activity {

    @BindView(R.id.videoView)
    VideoView videoView;
    @BindView(R.id.player)
    RelativeLayout rlPlayer;
    @BindView(R.id.ll_top)
    LinearLayout llTop;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.tv_file)
    TextViewCustom tvFile;
    @BindView(R.id.tv_duration)
    TextViewCustom tvDuration;

    private Uri uri;
    private String fileName;
    private Long duration;
    private int mVisible = View.GONE;

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
        fileName = getIntent().getStringExtra("name");
        duration = getIntent().getLongExtra("duration", 0);
        if (uri != null) {
            videoView.setVideoURI(uri);
        }
        initView();
        initEvent();
    }

    private void initView() {
        videoView = (VideoView) findViewById(R.id.videoView);
         tvFile.setText(fileName);
        tvDuration.setText(duration.toString());
    }

    private void initEvent() {
       // videoView.setMediaController(new MediaController(this));
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

    @OnClick({R.id.iv_quit, R.id.iv_share, R.id.iv_start, R.id.iv_setting, R.id.fl_camera, R.id.fl_gif,R.id.player})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_quit:
                finish();
                break;
            case R.id.iv_share:
                break;
            case R.id.iv_start:
                break;
            case R.id.iv_setting:
                break;
            case R.id.fl_camera:
                break;
            case R.id.fl_gif:
                break;
            case R.id.player:
                onClickMySelf();
                break;
        }


    }

    private void onClickMySelf() {
        setVisible();
        setContainerVisible();
        if (mVisible == View.GONE) {
            setOutAnim();
        } else {
            setInAnim();
        }

    }
    private void setVisible() {
        mVisible = mVisible == View.GONE ? View.VISIBLE : View.GONE;
    }

    private void setContainerVisible() {
        llTop.setVisibility(mVisible);
        llBottom.setVisibility(mVisible);
        llRight.setVisibility(mVisible);
    }

    private void setOutAnim() {
        llTop.setAnimation(AnimUtils.getTopOutAnim());
        llBottom.setAnimation(AnimUtils.getBottomOutAnim());
        llRight.setAnimation(AnimUtils.getRightOutAnim());
    }

    private void setInAnim() {
        llTop.setAnimation(AnimUtils.getTopInAnim());
        llBottom.setAnimation(AnimUtils.getBottomInAnim());
        llRight.setAnimation(AnimUtils.getRightInAnim());
    }



}
