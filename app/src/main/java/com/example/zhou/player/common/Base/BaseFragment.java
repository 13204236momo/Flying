package com.example.zhou.player.common.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zhou on 2017/5/25.
 */

public abstract class BaseFragment extends Fragment {
    public Context context;

    /**
     * 当Fragment被创建时回调
     * @param savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity();
    }

    /**
     * 当视图被创建时调用
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return initView();
    }

    /**
     * 让子类实现视图
     * @return
     */
    public abstract View initView();

    /**
     * 当activity创建了回调
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 1.如果没有数据,联网请求数据,并绑定到initview初始化的视图上
     * 2.如有数据,直接bangding
     * 123456
     */
    protected  void initData(){}
}
