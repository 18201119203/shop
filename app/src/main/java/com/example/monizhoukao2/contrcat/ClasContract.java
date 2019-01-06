package com.example.monizhoukao2.contrcat;

import com.example.monizhoukao2.bean.LeftBean;
import com.example.monizhoukao2.bean.RightBean;
import com.example.monizhoukao2.model.ClasModel;

import java.util.HashMap;

public interface ClasContract {


    abstract class ClasPresenter{

        public abstract void getLeftLinter(HashMap<String,String> params);
        public abstract void getRightLinter(HashMap<String,String> params);
    }

    interface  IclasModel{

        void getLeftLinter(HashMap<String,String> params, ClasModel.IModel callback);
        void getRightLinter(HashMap<String,String> params, ClasModel.IModel callback);

    }

    interface IclasView{
        void lfetSuccess(LeftBean leftBean);
        void rightSuccess(RightBean rightBean);
        void leftFailure(String msg);
        void rightFailure(String msg);
    }

}
