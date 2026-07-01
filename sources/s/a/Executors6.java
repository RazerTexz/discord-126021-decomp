package s.a;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import s.a.a.Concurrent;

/* JADX INFO: renamed from: s.a.w0, reason: use source file name */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Executors6 extends Executors5 {
    public final Executor k;

    public Executors6(Executor executor) {
        Method method;
        this.k = executor;
        Method method2 = Concurrent.a;
        boolean z2 = false;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) (executor instanceof ScheduledThreadPoolExecutor ? executor : null);
            if (scheduledThreadPoolExecutor != null && (method = Concurrent.a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
                z2 = true;
            }
        } catch (Throwable unused) {
        }
        this.j = z2;
    }

    @Override // kotlinx.coroutines.Executors
    public Executor H() {
        return this.k;
    }
}
