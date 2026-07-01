package b.i.c.m.d.k;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class i {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Task<Void> f1688b = b.i.a.f.e.o.f.Z(null);
    public final Object c = new Object();
    public ThreadLocal<Boolean> d = new ThreadLocal<>();

    public i(Executor executor) {
        this.a = executor;
        executor.execute(new i$a(this));
    }

    public void a() {
        if (!Boolean.TRUE.equals(this.d.get())) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public <T> Task<T> b(Callable<T> callable) {
        Task<T> task;
        synchronized (this.c) {
            task = (Task<T>) this.f1688b.i(this.a, new k(this, callable));
            this.f1688b = task.i(this.a, new l(this));
        }
        return task;
    }

    public <T> Task<T> c(Callable<Task<T>> callable) {
        Task<T> task;
        synchronized (this.c) {
            task = (Task<T>) this.f1688b.j(this.a, new k(this, callable));
            this.f1688b = task.i(this.a, new l(this));
        }
        return task;
    }
}
