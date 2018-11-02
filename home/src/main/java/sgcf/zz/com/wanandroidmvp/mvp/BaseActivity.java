package sgcf.zz.com.wanandroidmvp.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import sgcf.zz.com.wanandroidmvp.util.AppManager;

/**
 * @Author admin
 * Created on 2018/10/26 15:42.
 * Desc:WanAndroidMvp
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getInstance().addActivity(this);//添加到栈中
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().finishActivity(this);//从栈中移除
    }
}
