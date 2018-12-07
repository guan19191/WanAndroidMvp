package sgcf.zz.com.wanandroidmvp.activity;

import android.os.Bundle;
import sgcf.zz.com.wanandroidmvp.R;
import sgcf.zz.com.wanandroidmvp.RetrofitFactory;
import sgcf.zz.com.wanandroidmvp.mvp.BaseMvpActivity;
import sgcf.zz.com.wanandroidmvp.mvp.BasePresenter;
import sgcf.zz.com.wanandroidmvp.net.RestService;

public class HomeActivity extends BaseMvpActivity implements HomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
