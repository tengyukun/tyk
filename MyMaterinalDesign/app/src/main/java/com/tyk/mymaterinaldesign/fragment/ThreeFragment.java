package com.tyk.mymaterinaldesign.fragment;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.tyk.mymaterinaldesign.R;
import com.tyk.mymaterinaldesign.adapter.CustomAdapter;
import com.zly.www.easyrecyclerview.EasyDefRecyclerView;
import com.zly.www.easyrecyclerview.listener.OnLoadListener;
import com.zly.www.easyrecyclerview.listener.OnRefreshListener;
import com.zly.www.easyrecyclerview.ptrlib.header.MaterialHeader;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by Administrator on 2017/3/24 0024.
 */

public class ThreeFragment extends BaseFragment {

    @ViewInject(R.id.erv_fragmentthree_content)
    private EasyDefRecyclerView erv_fragmentthree_content;


    private Handler handler = new Handler();
    private boolean isFail = false;
    private CustomAdapter mAdapter;

    @Override
    public View initView() {
        View view=View.inflate(activity, R.layout.fragment_three,null);
        x.view().inject(this,view);
        initContent();
        return view;
    }

    @Override
    public void initData() {
        super.initData();

    }

    private void initContent() {

        MaterialHeader materialHeader = new MaterialHeader(activity);
        materialHeader.setPadding(0, 40,0,40);
        erv_fragmentthree_content.setHeaderView(materialHeader);
        erv_fragmentthree_content.setPinContent(true);
        erv_fragmentthree_content.setLayoutManager(new LinearLayoutManager(activity));

        mAdapter = new CustomAdapter(activity);

        for (int i = 0; i < 10; i++) {
            mAdapter.add("数据");
        }
        erv_fragmentthree_content.setAdapter(mAdapter);
        erv_fragmentthree_content.hideEmptyView();


        erv_fragmentthree_content.setLastUpdateTimeRelateObject(activity);

        erv_fragmentthree_content.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefreshListener() {
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new CustomAdapter(activity);
                        for (int i = 0; i < 10; i++) {
                            mAdapter.add("最新数据");
                        }
                        erv_fragmentthree_content.setAdapter(mAdapter);
                        erv_fragmentthree_content.refreshComplete();
                        erv_fragmentthree_content.loadComplete();
                        erv_fragmentthree_content.loading();
                        Log.e("onRefreshListener",mAdapter.getItemCount()+"");
                    }
                },2000 );
            }
        });



        erv_fragmentthree_content.setOnLoadListener(new OnLoadListener() {
            @Override
            public void onLoadListener() {
                Log.e("onLoadListener",mAdapter.getItemCount()+"");
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (mAdapter.getItemCount() > 20 && !isFail) {
                            isFail = true;
                            erv_fragmentthree_content.loadFail();
                        } else if (mAdapter.getItemCount() > 30) {
                            erv_fragmentthree_content.noMore();
                        } else {
                            for (int i = 0; i < 10; i++) {
                                mAdapter.add("更多数据");
                            }
                        }
                    }
                }, 1000);
            }
        });

    }
}
