package com.donkingliang.consecutivescrollerdemo;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.donkingliang.consecutivescrollerdemo.adapter.RecyclerViewAdapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/**
 * @Author donkingliang
 * @Description
 * @Date 2020/4/18
 */
public class MyFragment extends Fragment {

    private LinearLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my,container,false);

        RecyclerView recyclerView1 = view.findViewById(R.id.recyclerView1);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView1.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter1 = new RecyclerViewAdapter(getActivity(),"RecyclerView1-");
        recyclerView1.setAdapter(adapter1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.i("traceBug", "run: ");
                        recyclerView1.scrollBy(0, 500);
                    }
                });
            }
        }, 1000L);

//        RecyclerView recyclerView2 = view.findViewById(R.id.recyclerView2);
//        recyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
//        RecyclerViewAdapter adapter2 = new RecyclerViewAdapter(getActivity(),"RecyclerView2-");
//        recyclerView2.setAdapter(adapter2);
        return view;
    }

    public void onLoadMore(final SmartRefreshLayout layout){
        // 模拟加载5秒钟
        layout.finishLoadMore(5000);
    }
}
