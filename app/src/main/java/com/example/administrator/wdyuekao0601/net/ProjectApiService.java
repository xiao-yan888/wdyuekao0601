package com.example.administrator.wdyuekao0601.net;

import com.example.administrator.wdyuekao0601.bean.RequestData;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public interface ProjectApiService {
    @FormUrlEncoded
    @POST("cook/query.php?key=94749a131e2cc44b8845411a6856e502")
    Observable<RequestData> getCook(@Field("menu") String menu);
}
