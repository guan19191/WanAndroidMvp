package sgcf.zz.com.wanandroidmvp.net;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface RestService {
    //通用的封装
    @GET
    Call<String> get(@Url String url, @QueryMap Map<String, Object> params);

    @GET
    @Streaming
        //避免内存过大
    Call<ResponseBody> dowload(@Url String url, @QueryMap Map<String, Object> params);


    @DELETE
    Call<String> delete(@Url String url, @QueryMap Map<String, Object> params);

    @POST
    @FormUrlEncoded
    Call<String> post(@Url String url, @FieldMap Map<String, Object> params);

    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body);

    @POST
    @Multipart
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);

    @PUT
    @FormUrlEncoded
    Call<String> put(@Url String url, @FieldMap Map<String, Object> params);

    @PUT
    Call<String> putRaw(@Url String url, @Body RequestBody body);
}