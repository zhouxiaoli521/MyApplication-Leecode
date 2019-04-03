package com.example.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewTestActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<String> mDatas;
    HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_test);

        initData();
        mRecyclerView = findViewById(R.id.id_recyclerview);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mAdapter = new HomeAdapter());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.id_action_add:
                mAdapter.addData(1);
                break;
            case R.id.id_action_delete:
                mAdapter.removeData(1);
                break;
        }
        return true;
    }

    class HomeAdapter extends Adapter<HomeAdapter.MyViewHloder> {
        @Override
        public HomeAdapter.MyViewHloder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHloder hloder = new MyViewHloder(LayoutInflater.from(RecyclerViewTestActivity.this).inflate(R.layout.item_home, parent, false));
            return hloder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHloder holder, int position) {
            holder.tv.setText(mDatas.get(position));
            if (position % 3 == 0) {
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams
                        (ViewGroup.LayoutParams.WRAP_CONTENT, 240);
                holder.tv.setLayoutParams(lp);
            } else {
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams
                        (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                holder.tv.setLayoutParams(lp);
            }
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        public void addData(int position) {
            mDatas.add(position, "Insert One");
            notifyItemInserted(position);
        }

        public void removeData(int position) {
            mDatas.remove(position);
            notifyItemRemoved(position);
        }

        class MyViewHloder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHloder(View view) {
                super(view);
                tv = view.findViewById(R.id.id_num);
            }
        }
    }



}
