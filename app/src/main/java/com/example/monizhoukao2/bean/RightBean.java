package com.example.monizhoukao2.bean;

import java.util.List;

public class RightBean {

    public String code;
    public String msg;
    public List<RightBean.getData> data;

    public class getData{

        public String pcid;
        public String name;
        public List<Pcls> list;

        public class Pcls{

            public String name;
            public String icon;


        }

    }
}
