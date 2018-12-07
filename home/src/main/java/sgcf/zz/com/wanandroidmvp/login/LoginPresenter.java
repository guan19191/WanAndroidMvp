package sgcf.zz.com.wanandroidmvp.login;

import android.widget.Toast;
import sgcf.zz.com.wanandroidmvp.mvp.BasePresenter;
import sgcf.zz.com.wanandroidmvp.net.RestClientBuilder;
import sgcf.zz.com.wanandroidmvp.net.callback.IError;
import sgcf.zz.com.wanandroidmvp.net.callback.IFailure;
import sgcf.zz.com.wanandroidmvp.net.callback.IRequest;
import sgcf.zz.com.wanandroidmvp.net.callback.ISuccess;
import sgcf.zz.com.wanandroidmvp.util.URL;
import timber.log.Timber;

import java.util.WeakHashMap;

/**
 * @Author admin
 * Created on 2018/11/5 16:25.
 * Desc:WanAndroidMvp
 */
public class LoginPresenter extends BasePresenter<LoginView> {


    public void login(String username, String password) {
        WeakHashMap<String, Object> params = new WeakHashMap<>();
        params.put("username", username);
        params.put("password", password);

        new RestClientBuilder().url(URL.LOGIN_URL).params(params).request(new IRequest() {
            @Override
            public void onRequestStart() {
                getView().showLoading();
            }

            @Override
            public void onRequestEnd() {
                getView().hideLoading();
            }
        }).error(new IError() {
            @Override
            public void onError(int code, String msg) {
                getView().showLoginError(msg);
            }
        }).failure(new IFailure() {
            @Override
            public void onFailure() {
                getView().showLoginError("");
            }
        }).success(new ISuccess() {
            @Override
            public void onSuccess(String response) {
                getView().showLoginSuccess();
                Timber.e(response);
            }
        }).build().post();
    }
}
