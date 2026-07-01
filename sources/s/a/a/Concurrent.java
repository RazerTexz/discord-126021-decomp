package s.a.a;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: renamed from: s.a.a.e, reason: use source file name */
/* JADX INFO: compiled from: Concurrent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Concurrent {
    public static final Method a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        a = method;
    }
}
