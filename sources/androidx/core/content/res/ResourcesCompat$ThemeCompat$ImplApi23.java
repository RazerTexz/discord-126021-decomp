package androidx.core.content.res;

import android.content.res.Resources$Theme;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
public class ResourcesCompat$ThemeCompat$ImplApi23 {
    private static Method sRebaseMethod;
    private static boolean sRebaseMethodFetched;
    private static final Object sRebaseMethodLock = new Object();

    private ResourcesCompat$ThemeCompat$ImplApi23() {
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0028 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void rebase(@NonNull Resources$Theme resources$Theme) {
        Method method;
        synchronized (sRebaseMethodLock) {
            if (sRebaseMethodFetched) {
                method = sRebaseMethod;
                if (method != null) {
                    method.invoke(resources$Theme, new Object[0]);
                }
            } else {
                try {
                    Method declaredMethod = Resources$Theme.class.getDeclaredMethod("rebase", new Class[0]);
                    sRebaseMethod = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                }
                sRebaseMethodFetched = true;
                method = sRebaseMethod;
                if (method != null) {
                    try {
                        method.invoke(resources$Theme, new Object[0]);
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                        sRebaseMethod = null;
                    }
                }
            }
            throw th;
        }
    }
}
