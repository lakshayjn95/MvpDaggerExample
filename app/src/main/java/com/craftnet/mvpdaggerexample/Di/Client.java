package com.craftnet.mvpdaggerexample.Di;

import android.content.Context;


import com.craftnet.mvpdaggerexample.Network.OkRetro;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shaan on 7/7/2017.
 */

public class Client {


    Context context;
    boolean rx = false;
    String url = "http://click2cakeapis.click2cake.com/Service1.svc/";
    public SessionManager sessionManager;


    public static Client with(Context c, SessionManager sessionManager) {
        Client client = new Client();
        client.context = c;
        client.sessionManager = sessionManager;
        return client;
    }

    public Client url(String url) {
        this.url = url;
        return this;
    }


    public OkRetro build() {
        OkHttpClient okhttp;

        Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Response originalResponse = chain.proceed(chain.request());
                if (Common.build(context).isNetworkAvailable()) {
                    int maxAge = 10; // read from cache for 1 minute
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "public, max-age=" + maxAge)
                            .build();
                } else {
                    int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                    return originalResponse.newBuilder()
                            .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                            .build();
                }
            }

        };

        File httpCacheDirectory = new File(context.getCacheDir(), "responses");
        int cacheSize = 40 * 1024 * 1024;
        Cache cache = new Cache(httpCacheDirectory, cacheSize);
        okhttp = new OkHttpClient.Builder()
                .addNetworkInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okhttp)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(OkRetro.class);
    }


}
