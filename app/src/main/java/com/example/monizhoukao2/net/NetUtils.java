package com.example.monizhoukao2.net;

import android.os.Binder;
import android.os.Handler;

import com.example.monizhoukao2.model.ClasModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class NetUtils {

    private static NetUtils netUtils;
    private Handler handler = new Handler();
    private final OkHttpClient okHttpClient;


    private NetUtils() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .build();
    }
    public static NetUtils initNetUils(){

        if (netUtils==null){
            synchronized (NetUtils.class){
                if (netUtils==null){
                    netUtils = new NetUtils();
                }
            }
        }
        return netUtils;
    }

    public void doPost(HashMap<String,String> params, String url, final OkCallbackNetUtils callback){

        FormBody.Builder formbody = new FormBody.Builder();
        for (Map.Entry<String, String> p : params.entrySet()) {
            formbody.add(p.getKey(),p.getValue());
        }

        final Request request = new Request.Builder()
                .url(url)
                .post(formbody.build())
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (callback!=null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.failure("网络异常");
                        }
                    });
                }

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {

                if (callback!=null){
                    final String string = response.body().string();
                    if (response.code()==200){
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.success(string);
                            }
                        });
                    }
                }
            }
        });


    }



    public void nuBind(){
        if (okHttpClient!=null){
            okHttpClient.dispatcher().cancelAll();
        }

    }


}
