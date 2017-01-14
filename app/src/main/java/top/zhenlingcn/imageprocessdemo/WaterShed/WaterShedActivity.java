package top.zhenlingcn.imageprocessdemo.WaterShed;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

import top.zhenlingcn.imageprocessdemo.R;

/**
 * Created by zhenling on 2017/1/14.
 */
public class WaterShedActivity extends Activity {
    private static final String TAG = "TAG";
    ImageView imageView;
    ImageView originImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watershed_layout);

        imageView= (ImageView) findViewById(R.id.image_view);
        originImage= (ImageView) findViewById(R.id.origin_image);

        //设置初始图片
        Bitmap bitmap= BitmapFactory.decodeFile("/storage/emulated/0/data/fish.jpg");
        Matrix matrix=new Matrix();
        matrix.postScale(2.0f,2.0f);
        Bitmap bigMap=Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        originImage.setImageBitmap(bigMap);

        //分水岭算法
        WaterShed waterShed=new WaterShed();
        waterShed.startWatering(new File("/storage/emulated/0/data/fish.jpg"),imageView);

        try {
            waterShed.showWatershededImage(new File("/storage/emulated/0/data/new_fish.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
