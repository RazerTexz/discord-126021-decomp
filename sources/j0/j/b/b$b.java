package j0.j.b;

import android.os.Handler;
import j0.o.o;
import java.util.Objects;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;

/* JADX INFO: compiled from: LooperScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b implements Runnable, Subscription {
    public final Action0 j;
    public final Handler k;
    public volatile boolean l;

    public b$b(Action0 action0, Handler handler) {
        this.j = action0;
        this.k = handler;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.l;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.j.call();
        } catch (Throwable th) {
            IllegalStateException illegalStateException = th instanceof OnErrorNotImplementedException ? new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th) : new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
            Objects.requireNonNull(o.a.b());
            Thread threadCurrentThread = Thread.currentThread();
            threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.l = true;
        this.k.removeCallbacks(this);
    }
}
