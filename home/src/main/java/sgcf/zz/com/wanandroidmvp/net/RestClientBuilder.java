package sgcf.zz.com.wanandroidmvp.net;

import android.content.Context;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import sgcf.zz.com.wanandroidmvp.net.callback.IError;
import sgcf.zz.com.wanandroidmvp.net.callback.IFailure;
import sgcf.zz.com.wanandroidmvp.net.callback.IRequest;
import sgcf.zz.com.wanandroidmvp.net.callback.ISuccess;

import java.io.File;
import java.util.Map;

/**
 * @Author admin
 * Created on 2018/10/18 10:43.
 * Desc:MyPractice
 */
public class RestClientBuilder {

    private String mUrl = null;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();

    private IRequest mIRequest = null;
    private IFailure mIFailure = null;
    private ISuccess mISuccess = null;
    private IError mIError = null;
    private RequestBody mBody = null;
    private Context mContext = null;
//    private LoadingStyle mLoadingStyle = null;

    private File mfile = null;

    public RestClientBuilder() {

    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    //Map 参数
    public final RestClientBuilder params(Map<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    //json 字符串 参数
    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    //键值对参数
    public final RestClientBuilder params(String key, Object value) {
//        if (mParams == null) {
//            mParams = new WeakHashMap<>();
//        }
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder request(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

//    public final RestClientBuilder loader(LoadingStyle loadingStyle, Context context) {
//        this.mLoadingStyle = loadingStyle;
//        this.mContext = context;
//        return this;
//    }
//
//    public final RestClientBuilder loader(Context context) {
//        this.mLoadingStyle = LoadingStyle.BallClipRotatePulseIndicator;
//        this.mContext = context;
//        return this;
//    }

    public final RestClientBuilder file(File file) {
        this.mfile = file;
        return this;
    }
    public final RestClientBuilder file(String  filePath) {
        this.mfile = new File(filePath);
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl,
                PARAMS,
                mIRequest,
                mIFailure,
                mISuccess,
                mIError,
                mBody,
                mContext,
                mfile
        );
    }
}
