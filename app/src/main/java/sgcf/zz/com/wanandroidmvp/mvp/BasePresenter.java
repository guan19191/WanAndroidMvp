package sgcf.zz.com.wanandroidmvp.mvp;

import java.lang.ref.WeakReference;

/**
 * @Author admin
 * Created on 2018/10/26 15:30.
 * Desc:WanAndroidMvp
 */
public abstract class BasePresenter<M extends IModel, V extends BaseMvpView> implements IPresenter {
    WeakReference<V> viewReference;
    WeakReference<M> mModelReference;

    public BasePresenter(WeakReference<V> viewReference, M mModel) {
        this.viewReference = viewReference;
        this.mModelReference = new WeakReference<>(mModel);
        onStart();
    }

    public BasePresenter() {
        onStart();
    }

    public BasePresenter(WeakReference<V> viewReference) {
        this.viewReference = viewReference;
        onStart();
    }

    public void attachView(V view) {
        viewReference = new WeakReference<V>(view);
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

    public M getModel() {
        return mModelReference.get();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {
        viewReference.clear();
        viewReference = null;
        mModelReference.clear();
        mModelReference = null;
    }
}
