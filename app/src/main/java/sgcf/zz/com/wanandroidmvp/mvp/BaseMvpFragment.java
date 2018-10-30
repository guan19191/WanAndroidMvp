package sgcf.zz.com.wanandroidmvp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.Unbinder;

/**
 * @Author admin
 * Created on 2018/10/30 15:48.
 * Desc:WanAndroidMvp
 */
public abstract class BaseMvpFragment<V extends BaseMvpView, P extends BasePresenter<V>> extends BaseLazyFragment {
    private P mPresenter;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    public abstract P createPresenter();


}
