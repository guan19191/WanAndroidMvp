package sgcf.zz.com.wanandroidmvp.net;

import android.content.Context;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import sgcf.zz.com.wanandroidmvp.net.callback.*;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @Author admin
 * Created on 2018/10/18 10:06.
 * Desc:MyPractice
 */
public class RestClient {

    /**
     * 建造者模式
     * 标准的建造者模式和Android 简化的建造者模式
     */
    private final String URL;
    private final IRequest REQUEST;
    private final IFailure FAILURE;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final RequestBody BODY;

    public static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();

//    private final LoadingStyle LOADING_STYLE;
    private final Context CONTEXT;

    private final File FILE;
    public RestClient(String url,
                      Map<String, Object> params,
                      IRequest request,
                      IFailure failure,
                      ISuccess success,
                      IError error,
                      RequestBody body,
                      Context context,
                      File file
    ) {
        this.URL = url;
        PARAMS.putAll(params);
        this.REQUEST = request;
        this.FAILURE = failure;
        this.SUCCESS = success;
        this.ERROR = error;
        this.BODY = body;
        this.CONTEXT = context;
        this.FILE = file;
    }

//    public static RestClientBuilder builder() {
//        return new RestClientBuilder();
//    }

    private void request(HttpMethod method) {
        final RestService service = RestCreator.getRestService();
        Call<String> call = null;

        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
//        if (LOADING_STYLE != null) {
//            LatteLoading.showLoading(CONTEXT, LOADING_STYLE);
//        }
        switch (method) {
            case GET:
                call = service.get(URL, PARAMS);
                break;
            case POST:
                call = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                call = service.postRaw(URL, BODY);
                break;
            case PUT:
                call = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                call = service.putRaw(URL, BODY);
                break;
            case DELETE:
                call = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody = RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()), FILE);
                final MultipartBody.Part body = MultipartBody.Part.createFormData("file", FILE.getName(),requestBody);
                call = RestCreator.getRestService().upload(URL, body);
                break;
            default:
                break;
        }

        if (call != null) {
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });
        }
    }

    private Callback<String> getRequestCallBack() {
        return new RequestCallBacks(REQUEST, FAILURE, SUCCESS, ERROR);
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        if (BODY == null) {
            request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.POST_RAW);
        }
    }

    public final void put() {
        if (BODY == null) {
            request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null!");
            }
            request(HttpMethod.PUT_RAW);
        }
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }
}
