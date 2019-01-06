package com.example.monizhoukao2.presenter;

import com.example.monizhoukao2.bean.LeftBean;
import com.example.monizhoukao2.bean.RightBean;
import com.example.monizhoukao2.contrcat.ClasContract;
import com.example.monizhoukao2.fragment.ClassFragment;
import com.example.monizhoukao2.model.ClasModel;
import com.google.gson.Gson;

import java.util.HashMap;

public class ClasPresenter extends ClasContract.ClasPresenter {

    private ClasModel clasModel;
    private ClassFragment view;

    public ClasPresenter(ClassFragment view) {
        this.view = view;
        clasModel = new ClasModel();
    }

    @Override
    public void getLeftLinter(HashMap<String, String> params) {
        if (clasModel!=null){
            clasModel.getLeftLinter(params, new ClasModel.IModel() {
                @Override
                public void lfetSuccess(String requset) {
                    LeftBean leftBean = new Gson().fromJson(requset, LeftBean.class);
                    view.lfetSuccess(leftBean);
                }

                @Override
                public void rightSuccess(String requset) {

                }

                @Override
                public void leftFailure(String msg) {

                }

                @Override
                public void rightFailure(String msg) {

                }
            });
        }


    }

    @Override
    public void getRightLinter(HashMap<String, String> params) {

        if (clasModel!=null){

            clasModel.getRightLinter(params, new ClasModel.IModel() {
                @Override
                public void lfetSuccess(String requset) {

                }

                @Override
                public void rightSuccess(String requset) {
                    RightBean rightBean = new Gson().fromJson(requset, RightBean.class);
                    view.rightSuccess(rightBean);
                }

                @Override
                public void leftFailure(String msg) {

                }

                @Override
                public void rightFailure(String msg) {

                }
            });

        }



    }


}
