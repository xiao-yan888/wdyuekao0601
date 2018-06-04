package com.example.administrator.wdyuekao0601.list;

import com.example.administrator.wdyuekao0601.base.BaseContract;
import com.example.administrator.wdyuekao0601.bean.RequestData;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public interface CaiListContract {
    interface View extends BaseContract.BaseView{
        void getCookSuccess(RequestData requestData);
    }
    interface presenter extends BaseContract.BasePresenter<View>{
        void getCook(String menu);
    }
}
