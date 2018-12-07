package sgcf.zz.com.wanandroidmvp.net;

/**
 * @Author admin
 * Created on 2018/12/7 17:35.
 * Desc:WanAndroidMvp
 */
public interface HttpCallBack {
    void onSuccess(Object object);

    void onSuccess(String string);

    void onError(int code, String msg);

    void onFailed();
}
