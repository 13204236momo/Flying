package com.example.zhou.player.modules.Loading;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.zhou.player.common.Activity.MainActivity;
import com.example.zhou.player.R;
import com.example.zhou.player.common.Utils.VirtualPictureUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends Activity {
    @BindView(R.id.iv_splash)
    ImageView ivSplash;

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.splash);
        VirtualPictureUtils virtualPicture = new VirtualPictureUtils(bitmap,ivSplash);
        virtualPicture.doMain();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        },1000);

    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(null); //在销毁时移除
        super.onDestroy();
    }
}
