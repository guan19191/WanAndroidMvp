package sgcf.zz.com.wanandroidmvp.net;

import android.support.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author admin
 * Created on 2018/12/7 17:50.
 * Desc:WanAndroidMvp
 */
public class RetrofitCallback implements Callback<String> {


    @Override
    public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {

    }

    @Override
    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {

    }
}
