package cn.ken.net.core;

import java.util.concurrent.TimeUnit;

import cn.ken.net.Host;
import cn.ken.net.interceptor.LoggerInterceptor;
import cn.ken.net.interceptor.TokenInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

public class NetworkManager {
    private static NetworkManager mInstance;
    private static Retrofit retrofit;

    public static NetworkManager init() {
        if (mInstance == null) {
            synchronized (NetworkManager.class) {
                if (mInstance == null) {
                    mInstance = new NetworkManager();
                }
            }
        }
        return mInstance;
    }

    private NetworkManager() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .addInterceptor(new LoggerInterceptor(LoggerInterceptor.TAG))
                .addInterceptor(new TokenInterceptor())
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(Host.DEFAULT_HOST)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }

    public static <T> T getRequest(Class<T> c) {
        synchronized (c) {
            return retrofit.create(c);
        }
    }
}
