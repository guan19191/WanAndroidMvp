package sgcf.zz.com.wanandroidmvp;

import android.support.annotation.NonNull;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sgcf.zz.com.wanandroidmvp.bean.BaseResponseBean;
import sgcf.zz.com.wanandroidmvp.net.HttpCallBack;
import sgcf.zz.com.wanandroidmvp.net.RestService;
import sgcf.zz.com.wanandroidmvp.net.callback.IRequest;
import sgcf.zz.com.wanandroidmvp.net.callback.RequestCallBacks;

import java.util.Map;

/**
 * @Author admin
 * Created on 2018/12/7 16:23.
 * Desc:WanAndroidMvp
 */
public class HttpUtil {


    public static void PostMap(String url, Map<String, Object> params, final Class clazz, final HttpCallBack httpCallBack) {
        final Gson gson = new Gson();
        final Call<String> postCall = RetrofitFactory.getApiService(RestService.class).post(url, params);
        postCall.enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (response.isSuccessful()) {
                    //服务器响应成功
                    String body = response.body();
                    try {
                        Object object = gson.fromJson(body, clazz);
                        if (httpCallBack != null) {
                            httpCallBack.onSuccess(object);
                        }
                    } catch (Exception e) {
                        httpCallBack.onSuccess(body);
                        e.printStackTrace();
                    }
                } else {
                    //服务器响应失败
                    if (httpCallBack != null) {
                        httpCallBack.onError(response.code(), response.message());
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                if (httpCallBack != null) {
                    httpCallBack.onFailed();
                }
            }
        });
    }
}
