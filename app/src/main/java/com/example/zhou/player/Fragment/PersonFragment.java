package com.example.zhou.player.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.zhou.player.Base.BaseFragment;
import com.example.zhou.player.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by zhou on 2017/5/26.
 */

public class PersonFragment extends BaseFragment {
    @BindView(R.id.edit_login)
    EditText editLogin;
    Unbinder unbinder;

    @Override
    public View initView() {
        View rootView = View.inflate(getActivity(), R.layout.fragment_setting, null);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
