package sgcf.zz.com.wanandroidmvp.login;

import sgcf.zz.com.wanandroidmvp.mvp.BaseMvpView;

/**
 * @Author admin
 * Created on 2018/11/5 16:26.
 * Desc:WanAndroidMvp
 */
public interface LoginView extends BaseMvpView {

    void showLoginError(String msg);
    void showLoginSuccess();
}
