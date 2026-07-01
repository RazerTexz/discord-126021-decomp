package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.UserHandle;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(17)
public class ProcessCompat$Api17Impl {
    private static Method sMethodUserHandleIsAppMethod;
    private static boolean sResolved;
    private static final Object sResolvedLock = new Object();

    private ProcessCompat$Api17Impl() {
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    public static boolean isApplicationUid(int i) {
        try {
            synchronized (sResolvedLock) {
                if (!sResolved) {
                    sResolved = true;
                    sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                }
            }
            Method method = sMethodUserHandleIsAppMethod;
            if (method != null && ((Boolean) method.invoke(null, Integer.valueOf(i))) == null) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
