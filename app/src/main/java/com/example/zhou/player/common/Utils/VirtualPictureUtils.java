package com.example.zhou.player.common.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by zhou on 2017/3/19.
 * 图片虚化（毛玻璃效果）
 */

public class VirtualPictureUtils {
    /**
     * 上下文
     */
    private Context context;
    /**
     *图片资源
     */
    private int resource;
    /**
     * 要操作的资源图片
     */
    private Bitmap src;
    /**
     * 图片缩放比例
     */
    private int scaledRatio = 10;
    /**
     * 虚化值（一般为8）
     */
    private ImageView imageView;
    private int blurRadius = 8;

    /**
     * 传入Bitmap对象
     * @param src
     * @param imageView
     */
    public VirtualPictureUtils(Bitmap src,ImageView imageView) {
        this.imageView = imageView;
        this.src = src;
    }

    public VirtualPictureUtils(Bitmap src, int scaledRatio,ImageView imageView) {
        this(src,imageView);
        this.scaledRatio = scaledRatio;
    }

    public VirtualPictureUtils(Bitmap src, int scaledRatio, int blurRadius,ImageView imageView) {
        this(src,scaledRatio,imageView);
        this.blurRadius = blurRadius;
    }

    /**
     * 传入资源id
     * @param context
     * @param resource
     * @param imageView
     */
    public VirtualPictureUtils(Context context,int resource,ImageView imageView){
        this.context = context;
        this.resource = resource;
        this.imageView =imageView;
        src = BitmapFactory.decodeResource(context.getResources(), resource);
    }
    public VirtualPictureUtils(Context context,int resource,ImageView imageView,int scaledRatio){
        this(context,resource,imageView);
        this.scaledRatio = scaledRatio;
        src = BitmapFactory.decodeResource(context.getResources(), resource);
    }
    public VirtualPictureUtils(Context context,int resource,ImageView imageView,int scaledRatio,int blurRadius){
        this(context,resource,imageView,scaledRatio);
        this.blurRadius = blurRadius;
        src = BitmapFactory.decodeResource(context.getResources(), resource);
    }

    /**
     * 具体操作
     */
    public void doMain() {
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(src,src.getWidth()/scaledRatio,src.getHeight()/scaledRatio,false); //边缘平滑or锯齿
        Bitmap blurBitmap = FastBlur.doBlur(scaledBitmap,blurRadius,true);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setImageBitmap(blurBitmap);

    }

}
