package androidx.core.app;

import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class ActivityRecreator$3 implements Runnable {
    public final /* synthetic */ Object val$activityThread;
    public final /* synthetic */ Object val$token;

    public ActivityRecreator$3(Object obj, Object obj2) {
        this.val$activityThread = obj;
        this.val$token = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Method method = ActivityRecreator.performStopActivity3ParamsMethod;
            if (method != null) {
                method.invoke(this.val$activityThread, this.val$token, Boolean.FALSE, "AppCompat recreation");
            } else {
                ActivityRecreator.performStopActivity2ParamsMethod.invoke(this.val$activityThread, this.val$token, Boolean.FALSE);
            }
        } catch (RuntimeException e) {
            if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                throw e;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }
}
