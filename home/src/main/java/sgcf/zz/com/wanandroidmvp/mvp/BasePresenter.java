package sgcf.zz.com.wanandroidmvp.mvp;

import java.lang.ref.WeakReference;

/**
 * @Author admin
 * Created on 2018/10/26 15:30.
 * Desc:WanAndroidMvp
 */
public abstract class BasePresenter<V extends BaseMvpView> implements IPresenter {
    private WeakReference<V> viewReference;

    public BasePresenter() {
        onStart();
    }
    public BasePresenter(V view) {
        this.viewReference = new WeakReference<>(view);
        onStart();
    }

    void attachView(V view) {
        viewReference = new WeakReference<>(view);
    }


    public boolean isAttached() {
        if (viewReference != null && viewReference.get() != null) {
            return true;
        } else {
            return false;
        }
    }

    public void detachView() {
        if (viewReference != null) {
            onDestroy();
        }
    }

    public V getView() {
        return viewReference.get();
    }


    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        viewReference.clear();
        viewReference = null;
    }
}
