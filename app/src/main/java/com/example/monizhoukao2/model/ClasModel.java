package com.example.monizhoukao2.model;

import com.example.monizhoukao2.api.ClaApi;
import com.example.monizhoukao2.contrcat.ClasContract;
import com.example.monizhoukao2.net.NetUtils;
import com.example.monizhoukao2.net.OkCallbackNetUtils;

import java.util.HashMap;

public class ClasModel implements ClasContract.IclasModel {


    @Override
    public void getLeftLinter(HashMap<String, String> params, final IModel callback) {

        NetUtils.initNetUils().doPost(params, ClaApi.LEFT_URL, new OkCallbackNetUtils() {
            @Override
            public void success(String requset) {
                callback.lfetSuccess(requset);
            }

            @Override
            public void failure(String msg) {
                callback.leftFailure(msg);
            }
        });

    }

    @Override
    public void getRightLinter(HashMap<String, String> params, final IModel callback) {
        NetUtils.initNetUils().doPost(params, ClaApi.RIGHT_URL, new OkCallbackNetUtils() {
            @Override
            public void success(String requset) {
                callback.rightSuccess(requset);
            }

            @Override
            public void failure(String msg) {
                callback.rightFailure(msg);
            }
        });
    }

    public interface IModel{
        void lfetSuccess(String requset);
        void rightSuccess(String requset);
        void leftFailure(String msg);
        void rightFailure(String msg);
    }

}
