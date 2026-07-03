package p007b.p085c.p086a;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/* JADX INFO: renamed from: b.c.a.r */
/* JADX INFO: compiled from: LottieTask.java */
/* JADX INFO: loaded from: classes.dex */
public class C1519r<T> {

    /* JADX INFO: renamed from: a */
    public static Executor f2452a = Executors.newCachedThreadPool();

    /* JADX INFO: renamed from: b */
    public final Set<InterfaceC1513l<T>> f2453b = new LinkedHashSet(1);

    /* JADX INFO: renamed from: c */
    public final Set<InterfaceC1513l<Throwable>> f2454c = new LinkedHashSet(1);

    /* JADX INFO: renamed from: d */
    public final Handler f2455d = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: e */
    @Nullable
    public volatile C1517p<T> f2456e = null;

    /* JADX INFO: renamed from: b.c.a.r$a */
    /* JADX INFO: compiled from: LottieTask.java */
    public class a extends FutureTask<C1517p<T>> {
        public a(Callable<C1517p<T>> callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        public void done() {
            if (isCancelled()) {
                return;
            }
            try {
                C1519r.this.m707c(get());
            } catch (InterruptedException | ExecutionException e) {
                C1519r.this.m707c(new C1517p<>(e));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public C1519r(Callable<C1517p<T>> callable) {
        f2452a.execute(new a(callable));
    }

    /* JADX INFO: renamed from: a */
    public synchronized C1519r<T> m705a(InterfaceC1513l<Throwable> interfaceC1513l) {
        if (this.f2456e != null && this.f2456e.f2450b != null) {
            interfaceC1513l.mo680a(this.f2456e.f2450b);
        }
        this.f2454c.add(interfaceC1513l);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public synchronized C1519r<T> m706b(InterfaceC1513l<T> interfaceC1513l) {
        if (this.f2456e != null && this.f2456e.f2449a != null) {
            interfaceC1513l.mo680a(this.f2456e.f2449a);
        }
        this.f2453b.add(interfaceC1513l);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public final void m707c(@Nullable C1517p<T> c1517p) {
        if (this.f2456e != null) {
            throw new IllegalStateException("A task may only be set once.");
        }
        this.f2456e = c1517p;
        this.f2455d.post(new RunnableC1518q(this));
    }
}
