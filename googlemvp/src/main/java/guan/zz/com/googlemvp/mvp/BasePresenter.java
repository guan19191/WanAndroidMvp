package guan.zz.com.googlemvp.mvp;

/**
 * @Author admin
 * Created on 2018/12/5 15:49.
 * Desc:WanAndroidMvp
 */
public interface BasePresenter {
    //绑定数据
    void subscribe();
    //解除绑定
    void unSubscribe();
}
