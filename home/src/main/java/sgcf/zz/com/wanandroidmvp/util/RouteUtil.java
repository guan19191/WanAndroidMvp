package sgcf.zz.com.wanandroidmvp.util;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * @Author admin
 * Created on 2018/11/2 15:48.
 * Desc:WanAndroidMvp
 */
public class RouteUtil {

    public static void jumpActivity(@NonNull Context context, @Nullable Bundle bundle,@NonNull Class clazz) {
        Intent intent = new Intent(context, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);

    }
}
