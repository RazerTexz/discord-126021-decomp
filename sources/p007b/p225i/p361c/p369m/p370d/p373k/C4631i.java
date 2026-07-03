package p007b.p225i.p361c.p369m.p370d.p373k;

import com.google.android.gms.tasks.Task;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.c.m.d.k.i */
/* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4631i {

    /* JADX INFO: renamed from: a */
    public final Executor f12315a;

    /* JADX INFO: renamed from: b */
    public Task<Void> f12316b = C3404f.m4264Z(null);

    /* JADX INFO: renamed from: c */
    public final Object f12317c = new Object();

    /* JADX INFO: renamed from: d */
    public ThreadLocal<Boolean> f12318d = new ThreadLocal<>();

    /* JADX INFO: renamed from: b.i.c.m.d.k.i$a */
    /* JADX INFO: compiled from: CrashlyticsBackgroundWorker.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C4631i.this.f12318d.set(Boolean.TRUE);
        }
    }

    public C4631i(Executor executor) {
        this.f12315a = executor;
        executor.execute(new a());
    }

    /* JADX INFO: renamed from: a */
    public void m6436a() {
        if (!Boolean.TRUE.equals(this.f12318d.get())) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    /* JADX INFO: renamed from: b */
    public <T> Task<T> m6437b(Callable<T> callable) {
        Task<T> task;
        synchronized (this.f12317c) {
            task = (Task<T>) this.f12316b.mo6014i(this.f12315a, new C4637k(this, callable));
            this.f12316b = task.mo6014i(this.f12315a, new C4639l(this));
        }
        return task;
    }

    /* JADX INFO: renamed from: c */
    public <T> Task<T> m6438c(Callable<Task<T>> callable) {
        Task<T> task;
        synchronized (this.f12317c) {
            task = (Task<T>) this.f12316b.mo6015j(this.f12315a, new C4637k(this, callable));
            this.f12316b = task.mo6014i(this.f12315a, new C4639l(this));
        }
        return task;
    }
}
