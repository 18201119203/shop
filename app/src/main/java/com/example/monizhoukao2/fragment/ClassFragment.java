package com.example.monizhoukao2.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.monizhoukao2.R;
import com.example.monizhoukao2.adapter.LeftAdapter;
import com.example.monizhoukao2.adapter.RightAdapter;
import com.example.monizhoukao2.bean.LeftBean;
import com.example.monizhoukao2.bean.RightBean;
import com.example.monizhoukao2.contrcat.ClasContract;
import com.example.monizhoukao2.presenter.ClasPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClassFragment extends Fragment implements ClasContract.IclasView {


    @BindView(R.id.lv_left)
    XRecyclerView lv_left;
    @BindView(R.id.lv_right)
    XRecyclerView lv_right;
    private LeftAdapter leftAdapter;
    private String cid = "1";
    private ClasPresenter clasPresenter;
    private RightAdapter rightAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentclass, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();

    }


    private void initView() {

        lv_left.setLayoutManager(new LinearLayoutManager(getActivity()));
        lv_right.setLayoutManager(new LinearLayoutManager(getActivity()));
        leftAdapter = new LeftAdapter(getActivity());
        rightAdapter = new RightAdapter(getActivity());
        lv_left.setAdapter(leftAdapter);
        lv_right.setAdapter(rightAdapter);
        leftAdapter.initOnItemclick(new LeftAdapter.onItemClick() {
            @Override
            public void click(String cid) {
                getRight(cid);
            }
        });


    }

    private void initData() {

        clasPresenter = new ClasPresenter(this);
        getRight(cid);
        clasPresenter.getLeftLinter(new HashMap<String, String>());

    }

    private void getRight(String cid) {


        HashMap<String,String> params = new HashMap<>();
        params.put("cid",cid);
        clasPresenter.getRightLinter(params);

    }

    @Override
    public void lfetSuccess(LeftBean leftBean) {
        if (leftBean!=null){
            leftAdapter.setList(leftBean.data);
        }

    }

    @Override
    public void rightSuccess(RightBean rightBean) {
        if (rightBean!=null){
            rightAdapter.setList(rightBean.data);
        }
    }

    @Override
    public void leftFailure(String msg) {

    }

    @Override
    public void rightFailure(String msg) {

    }
}
