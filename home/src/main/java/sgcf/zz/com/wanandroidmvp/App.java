package sgcf.zz.com.wanandroidmvp;

import android.app.Application;
import android.content.Context;
import timber.log.Timber;

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
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static Context getAppContext() {
        return context;
    }
}
