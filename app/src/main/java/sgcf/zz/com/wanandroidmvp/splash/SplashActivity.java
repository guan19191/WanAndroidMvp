package sgcf.zz.com.wanandroidmvp.splash;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import butterknife.BindView;
import sgcf.zz.com.wanandroidmvp.R;
import sgcf.zz.com.wanandroidmvp.mvp.BaseMvpActivity;

public class SplashActivity extends BaseMvpActivity<SplashView, SplashPresenter> implements SplashView, View.OnClickListener {


    @BindView(R.id.tv_main_test)
    TextView tvMainTest;
//    @BindView(R.id.banner_splash)
//    ConvenientBanner bannerSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initListener() {
        tvMainTest.setText("跳过");
        tvMainTest.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public SplashPresenter createPresenter() {
        return new SplashPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showBanner() {
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_main_test:

                break;
        }
    }

}
