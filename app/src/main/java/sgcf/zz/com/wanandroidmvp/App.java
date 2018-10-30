package sgcf.zz.com.wanandroidmvp;

import android.app.Application;
import android.content.Context;

/**
 * @Author admin
 * Created on 2018/10/30 14:41.
 * Desc:WanAndroidMvp
 */
public class App extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getAppContext() {
        return context;
    }
}
