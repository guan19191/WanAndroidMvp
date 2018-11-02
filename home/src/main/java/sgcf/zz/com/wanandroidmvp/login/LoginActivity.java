package sgcf.zz.com.wanandroidmvp.login;

import sgcf.zz.com.wanandroidmvp.R;
import sgcf.zz.com.wanandroidmvp.mvp.BaseMvpActivity;
import sgcf.zz.com.wanandroidmvp.mvp.BasePresenter;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseMvpActivity {


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}

