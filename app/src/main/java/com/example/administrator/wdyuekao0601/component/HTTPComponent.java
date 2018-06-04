package com.example.administrator.wdyuekao0601.component;

import com.example.administrator.wdyuekao0601.list.CaiListActivity;
import com.example.administrator.wdyuekao0601.module.HTTPModule;

import dagger.Component;

/**
 * Created by Administrator on 2018/6/1 0001.
 */
@Component(modules = HTTPModule.class)
public interface HTTPComponent {
    void inject(CaiListActivity caiListActivity);
}
