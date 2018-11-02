package sgcf.zz.com.wanandroidmvp.bean;

/**
 * @Author admin
 * Created on 2018/10/29 14:41.
 * Desc:WanAndroidMvp
 */
public class BaseResponseBean<T> {
    private int errorCode;
    private String msg;
    private T data;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResponseBean{" +
                "errorCode=" + errorCode +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }


}
