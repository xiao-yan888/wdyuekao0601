package com.example.administrator.wdyuekao0601.base;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {
   protected T mView;
    @Override
    public void attach(T view) {
        this.mView=view;
    }

    @Override
    public void detach() {
        if (mView!=null){
            mView=null;
        }
    }
}
