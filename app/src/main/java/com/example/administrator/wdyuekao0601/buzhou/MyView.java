package com.example.administrator.wdyuekao0601.buzhou;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.wdyuekao0601.R;
import com.youth.banner.Banner;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public class MyView extends LinearLayout {

    private Banner banner;
    private TextView buzhou;

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.lunbo_item, this);
        banner = view.findViewById(R.id.banner);
        buzhou = view.findViewById(R.id.buzhou);

    }
}
