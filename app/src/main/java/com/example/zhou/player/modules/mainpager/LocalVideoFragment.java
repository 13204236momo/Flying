package com.example.zhou.player.modules.mainpager;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.example.zhou.player.modules.video.adapter.VideoAdapter;
import com.example.zhou.player.common.DoMain.MediaItemBean;
import com.example.zhou.player.R;
import com.example.zhou.player.common.Base.BaseFragment;
import com.example.zhou.player.common.Utils.Helper;
import com.example.zhou.player.common.Utils.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by zhou on 2017/5/26.
 */

public class LocalVideoFragment extends BaseFragment {

    @BindView(R.id.recycleView)
    RecyclerView recycleView;
    @BindView(R.id.ll_kong)
    LinearLayout llKong;
    @BindView(R.id.progressbar)
    ProgressBar progressbar;

    private ArrayList<MediaItemBean> mediaList;
    private VideoAdapter adapter;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (mediaList != null && mediaList.size()>0){
                //有数据
                llKong.setVisibility(View.GONE);
                adapter = new VideoAdapter(context,mediaList);
                recycleView.setAdapter(adapter);
                recycleView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
            }else {
                //没数据
                llKong.setVisibility(View.VISIBLE);
            }
            progressbar.setVisibility(View.GONE);
        }
    };
    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.pager_video, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        LogUtil.e("本地视频数据初始化。。。");
        getDataFromLocal();
    }

    /**
     * 从本地获取视频文件
     * 从内容提供者获取数据
     * 6.0系统要动态获取权限
     */
    private void getDataFromLocal() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                Helper.isGrantExternalRW(getActivity());
                ContentResolver resolver =  context.getContentResolver();
                Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                String[] objs = {MediaStore.Video.Media.DISPLAY_NAME,//视频在SdCard中的名称
                        MediaStore.Video.Media.DURATION,//视频总时长
                        MediaStore.Video.Media.SIZE,//视频总大小
                        MediaStore.Video.Media.DATA,//视频的绝对地址
                        MediaStore.Video.Media.ARTIST//作者信息
                };
                Cursor cursor = resolver.query(uri,objs,null,null,null);
                mediaList = new ArrayList<>();
                if (cursor != null){
                    while (cursor.moveToNext()){
                        MediaItemBean media = new MediaItemBean();

                        String name = cursor.getString(0);
                        media.setName(name);

                        long duration = cursor.getLong(1);
                        media.setDuration(duration);

                        long size = cursor.getLong(2);
                        media.setSize(size);

                        String data = cursor.getString(3);
                        media.setData(data);

                        String artist = cursor.getString(4);
                        media.setArtist(artist);

                        mediaList.add(media);

                    }
                    cursor.close();
                }
                //发消息
                handler.sendEmptyMessage(1);
            }
        }.start();

    }
}
