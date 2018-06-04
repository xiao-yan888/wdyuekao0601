package com.example.administrator.wdyuekao0601.net;

import com.example.administrator.wdyuekao0601.bean.RequestData;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2018/6/1 0001.
 */

public class ProjectApi {
    private static ProjectApi projectApi;
    private ProjectApiService projectApiService;

    public ProjectApi(ProjectApiService projectApiService) {
        this.projectApiService = projectApiService;
    }
    public static ProjectApi getProjectApi(ProjectApiService projectApiService){
        if (projectApi==null){
            projectApi=new ProjectApi(projectApiService);
        }
        return projectApi;
    }

    public Observable<RequestData> getCook(String menu){
        return projectApiService.getCook(menu);
    }

}
