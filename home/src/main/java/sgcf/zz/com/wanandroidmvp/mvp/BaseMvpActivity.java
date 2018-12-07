package sgcf.zz.com.wanandroidmvp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author admin
 * Created on 2018/10/26 15:41.
 * Desc:WanAndroidMvp
 */
public abstract class BaseMvpActivity<V extends BaseMvpView, P extends BasePresenter<V>> extends BaseActivity {

    public P mPresenter;
    public Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        setContentView(getLayoutId());
        bindView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initData();


    public abstract int getLayoutId();

    public abstract P createPresenter();

    public void bindView() {
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }

        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

}
