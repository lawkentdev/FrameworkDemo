package cn.ken.net.interceptor;

import android.text.TextUtils;

import java.io.IOException;

import cn.ken.base.saver.UserInfoSaver;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        String url = request.url().toString();
        // 如果是其他 url 就设置 请求 token
        if (!TextUtils.isEmpty(url)) {
            String token = UserInfoSaver.getToken();
            if (!TextUtils.isEmpty(token)) builder.addHeader("token", token);
        }
        return chain.proceed(builder.build());
    }
}
