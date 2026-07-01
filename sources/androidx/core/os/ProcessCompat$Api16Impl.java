package androidx.core.os;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(16)
public class ProcessCompat$Api16Impl {
    private static Method sMethodUserIdIsAppMethod;
    private static boolean sResolved;
    private static final Object sResolvedLock = new Object();

    private ProcessCompat$Api16Impl() {
    }

    @SuppressLint({"PrivateApi"})
    public static boolean isApplicationUid(int i) {
        try {
            synchronized (sResolvedLock) {
                if (!sResolved) {
                    sResolved = true;
                    sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                }
            }
            Method method = sMethodUserIdIsAppMethod;
            if (method != null) {
                Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i));
                if (bool != null) {
                    return bool.booleanValue();
                }
                throw new NullPointerException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
