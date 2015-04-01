
package com.common.view.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.common.view.EnhanceListView;
import com.common.view.EnhanceListView.OnLoadMoreListener;
import com.common.view.EnhanceListView.OnRefreshListener;
import com.common.view.R;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Test7Activity extends Activity {

    private static final String LOG_TAG = "EnhanceListView";
    private EnhanceListView mListView;
    private ArrayAdapter<String> mAdapter;
    private List<String> mData;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test7);
        mListView = (EnhanceListView) findViewById(R.id.list_view);
        mHandler = new Handler();
        initData();
        setListener();
    }

    private void setListener() {
        mListView.setOnRefreshListener(new OnRefreshListener() {

            @Override
            public void onRefresh(int itemCount) {
                refresh(itemCount);
            }

        });

        mListView.setOnLoadMoreListener(new OnLoadMoreListener() {

            @Override
            public void onLoadMore(int pageNum, int pageSize) {
                loadMore(pageNum, pageSize);
            }

        });
        mListView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "selected: " + position, Toast.LENGTH_LONG)
                        .show();
            }

        });
    }

    private void initData() {
        Log.e(LOG_TAG, "init data...");
        loadData(1, mListView.getPageSize(), false);
    }

    private void refresh(int itemCount) {
        Log.e(LOG_TAG, "refresh...");
        loadData(1, itemCount, true);
    }

    private void loadMore(int pageNum, int pageSize) {
        Log.e(LOG_TAG, "loadMore...");
        loadData(pageNum, pageSize, false);
    }

    private void loadData(int pageNum, final int pageSize, final boolean isClear) {
        Log.e(LOG_TAG, "load data begin..." + pageNum + ":" + pageSize);
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
                // 更新数据初始状态
                boolean isInitData = mData == null;
                if (isInitData) {
                    mData = new LinkedList<String>();
                    mAdapter = new ArrayAdapter<String>(Test7Activity.this,
                            android.R.layout.simple_list_item_1, mData);
                } else if (isClear) {
                    mData.clear();
                }
                // 改变数据
                String timeStr = getTimeStr();
                int index = mData.size();
                for (int i = 0; i < pageSize; i++) {
                    if (index < 65) {
                        mData.add(index + timeStr);
                        index += 1;
                    } else {
                        break;
                    }
                }
                Log.e(LOG_TAG, "load data end.");
                // 通知刷新界面
                if (isInitData) {
                    mListView.setAdapter(mAdapter);
                } else {
                    mAdapter.notifyDataSetChanged();
                }
            }
        }, 3000);
    }

    private String getTimeStr() {
        String timeStr = DateFormat.format("yyyy-MM-dd kk:mm:ss", new Date()).toString();
        return "  " + timeStr;
    }
}
