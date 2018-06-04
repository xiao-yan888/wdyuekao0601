package com.example.administrator.wdyuekao0601.list;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.wdyuekao0601.R;
import com.example.administrator.wdyuekao0601.adapter.RvAdapter;
import com.example.administrator.wdyuekao0601.base.BaseActivity;
import com.example.administrator.wdyuekao0601.bean.RequestData;
import com.example.administrator.wdyuekao0601.buzhou.DetaliActivity;
import com.example.administrator.wdyuekao0601.component.DaggerHTTPComponent;

import java.util.List;

import javax.inject.Inject;

public class CaiListActivity extends BaseActivity<CaiListPresenter> implements CaiListContract.View {

    private RecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        mPresenter.getCook(name);
        initView();
    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_cai_list;
    }

    @Override
    public void inject() {
        DaggerHTTPComponent.builder().build().inject(this);
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.addItemDecoration(new DividerItemDecoration(this,RecyclerView.VERTICAL));

    }

    @Override
    public void getCookSuccess(RequestData requestData) {
        List<RequestData.ResultBean.DataBean> data = requestData.getResult().getData();
        RvAdapter adapter = new RvAdapter(CaiListActivity.this,data);
        mRv.setAdapter(adapter);
        adapter.setOnItemClickListener(new RvAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(RequestData.ResultBean.DataBean dataBean) {
                Intent intent = new Intent(CaiListActivity.this, DetaliActivity.class);
                intent.putExtra("bean",dataBean);
                startActivity(intent);
            }
        });
    }
}
