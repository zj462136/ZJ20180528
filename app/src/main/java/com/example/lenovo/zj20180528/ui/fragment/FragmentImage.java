package com.example.lenovo.zj20180528.ui.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lenovo.zj20180528.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FragmentImage extends Fragment implements View.OnClickListener {
    private View view;
    /**
     * 加载图片
     */
    private Button bt_onclick;
    private SimpleDraweeView drawee_view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void initView(View view) {
        bt_onclick = view.findViewById(R.id.bt_onclick);
        bt_onclick.setOnClickListener(this);
        drawee_view = view.findViewById(R.id.drawee_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_onclick:
                DownloadImgTask task = new DownloadImgTask(drawee_view);
                task.execute(" http://img.taopic.com/uploads/allimg/140729/240450-140HZP45790.jpg");
                break;
        }
    }
    class DownloadImgTask extends AsyncTask<String, Integer, Integer> {

        private ImageView imageView;
        private Bitmap bitmap;


        //为什么要加一个构造方法--有传值的需求
        public  DownloadImgTask(ImageView imageView){
            this.imageView=imageView;
        }

        @Override
        protected Integer doInBackground(String... strings) {
            //加载网络图片，最后获取到一个Bitmap对象，返回Bitmap
            Bitmap bm = null;

            try {
                //创建URl
                URL url = new URL(strings[0]);
                //openConnection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //创建输入流
                InputStream inputStream = connection.getInputStream();
                //把输入流转换成bitmap类型对象
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 1;

        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            switch (integer) {
                case 1:
                    drawee_view.setImageBitmap(bitmap);
                    break;
                default:
                    break;
            }

        }
    }
}
