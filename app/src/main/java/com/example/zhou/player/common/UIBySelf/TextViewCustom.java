package com.example.zhou.player.common.UIBySelf;


import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zhou on 2017/8/12.
 */

public class TextViewCustom extends TextView {


    public TextViewCustom(Context context) {
        this(context, null);
    }

    public TextViewCustom(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextViewCustom(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
       super(context,attrs,defStyleAttr);
        init();
    }


    private void init() {
    }
}
