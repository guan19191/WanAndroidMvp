package sgcf.zz.com.httplibrary.callback;

/**
 * @Author admin
 * Created on 2018/11/21 16:41.
 * Desc:WanAndroidMvp
 */
public interface IRequestCallBack {
    void onSuccess(String response);

    void onStart();

    void onFail();

    void onError();
}
