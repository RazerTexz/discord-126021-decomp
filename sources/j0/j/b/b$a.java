package j0.j.b;

import android.os.Handler;
import android.os.Message;
import j0.r.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import rx.Scheduler$Worker;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: compiled from: LooperScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$a extends Scheduler$Worker {
    public final Handler j;
    public final j0.j.a.b k = j0.j.a.a.a.a();
    public volatile boolean l;

    public b$a(Handler handler) {
        this.j = handler;
    }

    @Override // rx.Scheduler$Worker
    public Subscription a(Action0 action0) {
        return b(action0, 0L, TimeUnit.MILLISECONDS);
    }

    @Override // rx.Scheduler$Worker
    public Subscription b(Action0 action0, long j, TimeUnit timeUnit) {
        if (this.l) {
            return c.a;
        }
        Objects.requireNonNull(this.k);
        Handler handler = this.j;
        b$b b_b = new b$b(action0, handler);
        Message messageObtain = Message.obtain(handler, b_b);
        messageObtain.obj = this;
        this.j.sendMessageDelayed(messageObtain, timeUnit.toMillis(j));
        if (!this.l) {
            return b_b;
        }
        this.j.removeCallbacks(b_b);
        return c.a;
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
