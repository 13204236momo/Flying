package com.example.zhou.player.Fragment;

import android.view.View;
import android.widget.TextView;

import com.example.zhou.player.Base.BaseFragment;
import com.example.zhou.player.R;

/**
 * Created by zhou on 2017/5/26.
 */

public class LocalAudioFragment extends BaseFragment {
    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("本地音频页面");
        textView.setTextSize(20);
        textView.setTextColor(context.getResources().getColor(R.color.black));
        return textView;
    }
}
