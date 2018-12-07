package sgcf.zz.com.wanandroidmvp.net.callback;

import android.os.Handler;
import android.support.annotation.NonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @Author admin
 * Created on 2018/10/18 11:41.
 * Desc:MyPractice
 */
public class RequestCallBacks implements Callback<String> {
    private final IRequest REQUEST;
    private final IFailure FAILURE;
    private final ISuccess SUCCESS;
    private final IError ERROR;
//    private final LoadingStyle LOADING_STYLE;

    private static final Handler handler = new Handler();

    public RequestCallBacks(IRequest request, IFailure failure, ISuccess success, IError error) {
        this.REQUEST = request;
        this.FAILURE = failure;
        this.SUCCESS = success;
        this.ERROR = error;
//        this.LOADING_STYLE = loadingStyle;
    }

    @Override
    public void onResponse(Call<String> call, Response<String> response) {
        if (response.isSuccessful()) {
            if (call.isExecuted()) {
                if (SUCCESS != null) {
                    SUCCESS.onSuccess(response.body());
                }
            }
        } else {
            if (ERROR != null) {
                ERROR.onError(response.code(), response.message());
            }
        }
        stopLoading();
    }

    @Override
    public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
        if (FAILURE != null) {
            FAILURE.onFailure();
        }
        if (REQUEST != null) {
            REQUEST.onRequestEnd();
        }

        stopLoading();
    }

    private void stopLoading() {

    }
}
