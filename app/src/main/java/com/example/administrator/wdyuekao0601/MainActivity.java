package com.example.administrator.wdyuekao0601;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.com.sky.downloader.greendao.DaoSession;
import com.com.sky.downloader.greendao.UserDao;
import com.example.administrator.wdyuekao0601.app.MyApp;
import com.example.administrator.wdyuekao0601.bean.User;
import com.example.administrator.wdyuekao0601.list.CaiListActivity;
import com.example.administrator.wdyuekao0601.utils.MyViewGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String names[]= {"红烧肉","鱼香肉丝","白菜","宫保鸡丁","水煮鱼","蚂蚁上树","猪肉顿白菜","鱼香茄子"};



    /**
     * 请输入搜索菜名
     */
    private EditText mEtName;
    /**
     * 搜索
     */
    private Button mBtnSou;
    private MyViewGroup mMvg;
    private ListView mLv;
    /**
     * 清空历史数据
     */
    private Button mDel;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initChildViews();
        DaoSession daoSession = MyApp.getDaoSession();
        userDao = daoSession.getUserDao();
        select();
    }

    private void initChildViews() {
        ViewGroup.MarginLayoutParams mlp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mlp.leftMargin=5;
        mlp.bottomMargin=5;
        mlp.rightMargin=5;
        mlp.topMargin=5;
        for (int i = 0; i < names.length; i++) {
            TextView view = new TextView(this);
            view.setText(names[i]);
            view.setTextSize(15);
            view.setPadding(15,3,15,4);
            mMvg.addView(view,mlp);

            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mEtName.setText(names[finalI]);
                  /*  User user1 = new User();
                    user1.setName(names[finalI]);
                    List<User> list1 = userDao.queryBuilder().build().list();
                    for (int j = 0; j <list1.size() ; j++) {
                        String name = list1.get(j).getName();
                        if (names[finalI].equals(name)){
                            Toast.makeText(MainActivity.this,"数据库中已有数据",Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    userDao.insert(user1);
                    select();
                    */
                }
            });

        }
    }

    private void initView() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mBtnSou = (Button) findViewById(R.id.btn_sou);
        mBtnSou.setOnClickListener(this);
        mMvg = (MyViewGroup) findViewById(R.id.mvg);
        mLv = (ListView) findViewById(R.id.lv);
        mDel = (Button) findViewById(R.id.del);
        mDel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.btn_sou:
                String name = mEtName.getText().toString().trim();
                List<User> users = userDao.queryBuilder().build().list();
                User user = new User();
                user.setName(name);
                for (int i = 0; i <users.size() ; i++) {
                    String name1 = users.get(i).getName();
                    if (name1.equals(name)){
                        Toast.makeText(MainActivity.this,"数据库中已有数据",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this, CaiListActivity.class);
                        intent.putExtra("name",name);
                        startActivity(intent);
                        return;
                    }
                }
                userDao.insert(user);
                select();

                Intent intent = new Intent(MainActivity.this, CaiListActivity.class);
                intent.putExtra("name",name);
                startActivity(intent);

                break;
            case R.id.del:
                userDao.deleteAll();
                select();
                break;
        }
    }

    private void select() {
        List<User> list = userDao.queryBuilder().build().list();
       // new ArrayAdapter(MainActivity.this)
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1, list);
        mLv.setAdapter(arrayAdapter);
    }
}
