package com.example.administrator.wdyuekao0601.module;



import com.example.administrator.wdyuekao0601.net.API;
import com.example.administrator.wdyuekao0601.net.ProjectApi;
import com.example.administrator.wdyuekao0601.net.ProjectApiService;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/6/1 0001.
 */
@Module
public class HTTPModule {
    @Provides
    OkHttpClient.Builder ProvideOkHttpClientBuilder(){
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS);
    }

    @Provides
    ProjectApi ProvideProjectApi(OkHttpClient.Builder builder){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
        ProjectApiService projectApiService = retrofit.create(ProjectApiService.class);
        return ProjectApi.getProjectApi(projectApiService);
    }

}
