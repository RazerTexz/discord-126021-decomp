package j0.j.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import j0.j.a.RxAndroidPlugins;
import j0.j.a.RxAndroidSchedulersHook;
import j0.o.RxJavaPlugins;
import j0.r.Subscriptions;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.j.b.b, reason: use source file name */
/* JADX INFO: compiled from: LooperScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class LooperScheduler extends Scheduler {
    public final Handler a;

    /* JADX INFO: renamed from: j0.j.b.b$a */
    /* JADX INFO: compiled from: LooperScheduler.java */
    public static class a extends Scheduler.Worker {
        public final Handler j;
        public final RxAndroidSchedulersHook k = RxAndroidPlugins.a.a();
        public volatile boolean l;

        public a(Handler handler) {
            this.j = handler;
        }

        @Override // rx.Scheduler.Worker
        public Subscription a(Action0 action0) {
            return b(action0, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // rx.Scheduler.Worker
        public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.l) {
                return Subscriptions.a;
            }
            Objects.requireNonNull(this.k);
            Handler handler = this.j;
            b bVar = new b(action0, handler);
            Message messageObtain = Message.obtain(handler, bVar);
            messageObtain.obj = this;
            this.j.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.l) {
                return bVar;
            }
            this.j.removeCallbacks(bVar);
            return Subscriptions.a;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.l;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.l = true;
            this.j.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: renamed from: j0.j.b.b$b */
    /* JADX INFO: compiled from: LooperScheduler.java */
    public static final class b implements Runnable, Subscription {
        public final Action0 j;
        public final Handler k;
        public volatile boolean l;

        public b(Action0 action0, Handler handler) {
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
                Objects.requireNonNull(RxJavaPlugins.a.b());
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

    public LooperScheduler(Looper looper) {
        this.a = new Handler(looper);
    }

    @Override // rx.Scheduler
    public Scheduler.Worker a() {
        return new a(this.a);
    }
}
