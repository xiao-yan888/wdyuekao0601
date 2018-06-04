package com.example.administrator.wdyuekao0601.list;

import com.example.administrator.wdyuekao0601.base.BasePresenter;
import com.example.administrator.wdyuekao0601.bean.RequestData;
import com.example.administrator.wdyuekao0601.net.ProjectApi;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public class CaiListPresenter extends BasePresenter<CaiListContract.View> implements CaiListContract.presenter {
   private ProjectApi projectApi;
@Inject
    public CaiListPresenter(ProjectApi projectApi) {
        this.projectApi = projectApi;
    }

    @Override
    public void getCook(String menu) {
        projectApi.getCook(menu)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RequestData>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RequestData requestData) {
                        if (mView!=null){
                            mView.getCookSuccess(requestData);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
