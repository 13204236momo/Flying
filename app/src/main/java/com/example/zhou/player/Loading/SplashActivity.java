package com.example.zhou.player.Loading;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.zhou.player.MainActivity;
import com.example.zhou.player.R;
import com.example.zhou.player.Utils.VirtualPictureUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    @BindView(R.id.iv_splash)
    ImageView ivSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.splash);
        VirtualPictureUtils virtualPicture = new VirtualPictureUtils(bitmap,ivSplash);
        virtualPicture.doMain();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                                          startActivity(new Intent(SplashActivity.this, MainActivity.class));
            }
        },1000);

    }
}
