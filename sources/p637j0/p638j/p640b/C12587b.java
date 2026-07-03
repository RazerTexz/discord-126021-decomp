package p637j0.p638j.p640b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p637j0.p638j.p639a.C12584a;
import p637j0.p638j.p639a.C12585b;
import p637j0.p652o.C12777o;
import p637j0.p655r.C12787c;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.exceptions.OnErrorNotImplementedException;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.j.b.b */
/* JADX INFO: compiled from: LooperScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12587b extends Scheduler {

    /* JADX INFO: renamed from: a */
    public final Handler f26703a;

    /* JADX INFO: renamed from: j0.j.b.b$a */
    /* JADX INFO: compiled from: LooperScheduler.java */
    public static class a extends Scheduler.Worker {

        /* JADX INFO: renamed from: j */
        public final Handler f26704j;

        /* JADX INFO: renamed from: k */
        public final C12585b f26705k = C12584a.f26698a.m10737a();

        /* JADX INFO: renamed from: l */
        public volatile boolean f26706l;

        public a(Handler handler) {
            this.f26704j = handler;
        }

        @Override // rx.Scheduler.Worker
        /* JADX INFO: renamed from: a */
        public Subscription mo10740a(Action0 action0) {
            return mo10741b(action0, 0L, TimeUnit.MILLISECONDS);
        }

        @Override // rx.Scheduler.Worker
        /* JADX INFO: renamed from: b */
        public Subscription mo10741b(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f26706l) {
                return C12787c.f27422a;
            }
            Objects.requireNonNull(this.f26705k);
            Handler handler = this.f26704j;
            b bVar = new b(action0, handler);
            Message messageObtain = Message.obtain(handler, bVar);
            messageObtain.obj = this;
            this.f26704j.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
            if (!this.f26706l) {
                return bVar;
            }
            this.f26704j.removeCallbacks(bVar);
            return C12787c.f27422a;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f26706l;
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.f26706l = true;
            this.f26704j.removeCallbacksAndMessages(this);
        }
    }

    /* JADX INFO: renamed from: j0.j.b.b$b */
    /* JADX INFO: compiled from: LooperScheduler.java */
    public static final class b implements Runnable, Subscription {

        /* JADX INFO: renamed from: j */
        public final Action0 f26707j;

        /* JADX INFO: renamed from: k */
        public final Handler f26708k;

        /* JADX INFO: renamed from: l */
        public volatile boolean f26709l;

        public b(Action0 action0, Handler handler) {
            this.f26707j = action0;
            this.f26708k = handler;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.f26709l;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f26707j.call();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = th instanceof OnErrorNotImplementedException ? new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", th) : new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th);
                Objects.requireNonNull(C12777o.f27384a.m10869b());
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            }
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.f26709l = true;
            this.f26708k.removeCallbacks(this);
        }
    }

    public C12587b(Looper looper) {
        this.f26703a = new Handler(looper);
    }

    @Override // p658rx.Scheduler
    /* JADX INFO: renamed from: a */
    public Scheduler.Worker mo10739a() {
        return new a(this.f26703a);
    }
}
