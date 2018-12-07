package sgcf.zz.com.wanandroidmvp;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

/**
 * @Author admin
 * Created on 2018/12/5 14:56.
 * Desc:WanAndroidMvp
 */
public class RetrofitFactory {
    private static String BASE_URL = "";

    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .build();
    }


    //静态内部类  实现线程安全的单例模式
    private static final class RetrofitHolder {

        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .client(RetrofitFactory.OkHttpHolder.OK_HTTP_CLIENT)
                .build();
    }

//    private static final class RestServiceHolder {
//        private static final RestService REST_REST_SERVICE = RetrofitFactory.RetrofitHolder
//                .RETROFIT_CLIENT.create(RestService.class);
//    }

//    public static RestService getRestService() {
//        return RetrofitFactory.RestServiceHolder.REST_REST_SERVICE;
//    }

    /**
     * 创建API
     */
    public static <T> T getApiService(Class<T> clazz) {
        return RetrofitFactory.RetrofitHolder.RETROFIT_CLIENT.create(clazz);
    }
}
