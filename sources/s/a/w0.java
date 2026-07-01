package s.a;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w0 extends v0 {
    public final Executor k;

    public w0(Executor executor) {
        Method method;
        this.k = executor;
        Method method2 = s.a.a.e.a;
        boolean z2 = false;
        try {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = (ScheduledThreadPoolExecutor) (executor instanceof ScheduledThreadPoolExecutor ? executor : null);
            if (scheduledThreadPoolExecutor != null && (method = s.a.a.e.a) != null) {
                method.invoke(scheduledThreadPoolExecutor, Boolean.TRUE);
                z2 = true;
            }
        } catch (Throwable unused) {
        }
        this.j = z2;
    }

    @Override // kotlinx.coroutines.ExecutorCoroutineDispatcher
    public Executor H() {
        return this.k;
    }
}
