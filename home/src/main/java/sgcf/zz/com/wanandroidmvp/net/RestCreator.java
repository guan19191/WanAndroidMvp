package sgcf.zz.com.wanandroidmvp.net;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @Author admin
 * Created on 2018/10/30 17:17.
 * Desc:WanAndroidMvp
 */
public class RestCreator {
    private static final String BASE_URL = Constants.BASE_URL;

    public static final class ParamsHolder {
        public static final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    }

    public static WeakHashMap<String, Object> getParams() {
        return ParamsHolder.PARAMS;
    }

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
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .build();
    }

    private static final class RestServiceHolder {
        private static final RestService REST_REST_SERVICE = RetrofitHolder
                .RETROFIT_CLIENT.create(RestService.class);
    }
    
    public static RestService getRestService() {
        return RestServiceHolder.REST_REST_SERVICE;
    }
}
