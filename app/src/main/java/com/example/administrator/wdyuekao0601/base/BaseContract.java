package com.example.administrator.wdyuekao0601.base;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public interface BaseContract {
    interface BaseView{

    }
    interface BasePresenter<T extends BaseView>{
        void attach(T view);
        void detach();
    }
}
