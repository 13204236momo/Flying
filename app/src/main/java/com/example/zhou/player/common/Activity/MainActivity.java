package com.example.zhou.player.common.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;



import com.example.zhou.player.modules.mainpager.LocalAudioFragment;
import com.example.zhou.player.modules.mainpager.LocalVideoFragment;
import com.example.zhou.player.modules.mainpager.OnlineFragment;

import com.example.zhou.player.R;
import com.example.zhou.player.modules.mainpager.SettingFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @BindView(R.id.ll_search)
    LinearLayout llSearch;
    @BindView(R.id.iv_clock)
    ImageView ivClock;

    private List<Fragment> fragments;
    private String[] titles = {"视频","音频","在线","我的"};


//    //第一次滑动状态
//    private boolean FirstScoll = true;
//    private boolean InitFirstData = true;
//    //屏幕的宽
//    private int width = 0;
//    //屏幕的高
//    private int height = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        //Fragment集合
        fragments = new ArrayList<>();
        fragments.add(new LocalVideoFragment());
        fragments.add(new LocalAudioFragment());
        fragments.add(new OnlineFragment());
        fragments.add(new SettingFragment());

        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tabLayout.setupWithViewPager(viewPager);
    }

    @OnClick({R.id.ll_search,R.id.iv_clock,R.id.fab})
    void onClick(View view){
        switch (view.getId()){
            //搜索栏
            case R.id.ll_search:
                break;
            //时间表
            case R.id.iv_clock:
                break;
            //悬浮按钮
            case R.id.fab:
                break;
        }
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if(InitFirstData){
//            width= ScreenUtils.getScreenWidth(this);
//            height=ScreenUtils.getViewHeight(this);
//            itemDetailScrollView.initScrollViewPlace();
//            itemDetailScrollView.initViewSize();
//            InitFirstData=false;
//        }
//    }
}
