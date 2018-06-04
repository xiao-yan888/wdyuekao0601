package com.example.administrator.wdyuekao0601.buzhou;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.administrator.wdyuekao0601.R;
import com.example.administrator.wdyuekao0601.bean.RequestData;
import com.example.administrator.wdyuekao0601.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

public class DetaliActivity extends AppCompatActivity {

    private RequestData.ResultBean.DataBean dataBean;
    private Banner mBanner;
    private TextView mBuzhou;
    private TextView mTvTitle;
    private List<RequestData.ResultBean.DataBean.StepsBean> steps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detali);

        Intent intent = getIntent();
        dataBean = (RequestData.ResultBean.DataBean) intent.getSerializableExtra("bean");
        steps = dataBean.getSteps();
        initView();
    }

    private void initView() {
        mBanner = (Banner) findViewById(R.id.banner);
        mBuzhou = (TextView) findViewById(R.id.buzhou);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mBanner.setImageLoader(new GlideImageLoader());
        List<String> images = new ArrayList<>();
        for (int i = 0; i < steps.size(); i++) {
            String img = steps.get(i).getImg();
            images.add(img);
        }
        mBanner.setImages(images);
        mBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBuzhou.setText(steps.get(position).getStep());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBanner.start();

        mTvTitle.setText(dataBean.getTitle());



    }
}
