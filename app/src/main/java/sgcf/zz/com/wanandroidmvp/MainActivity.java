package sgcf.zz.com.wanandroidmvp;

import android.os.Bundle;
import android.widget.TextView;
import butterknife.BindView;
import sgcf.zz.com.wanandroidmvp.mvp.BaseMvpActivity;
import sgcf.zz.com.wanandroidmvp.mvp.BasePresenter;

public class MainActivity extends BaseMvpActivity {


    @BindView(R.id.tv_main_test)
    TextView tvMainTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }
}
