package p659s.p660a.p661a;

import java.lang.reflect.Method;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: renamed from: s.a.a.e */
/* JADX INFO: compiled from: Concurrent.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13022e {

    /* JADX INFO: renamed from: a */
    public static final Method f27673a;

    static {
        Method method;
        try {
            method = ScheduledThreadPoolExecutor.class.getMethod("setRemoveOnCancelPolicy", Boolean.TYPE);
        } catch (Throwable unused) {
            method = null;
        }
        f27673a = method;
    }
}
