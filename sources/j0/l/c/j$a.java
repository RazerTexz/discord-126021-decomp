package j0.l.c;

import java.util.concurrent.Future;
import rx.Subscription;

/* JADX INFO: compiled from: ScheduledAction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a implements Subscription {
    public final Future<?> j;
    public final /* synthetic */ j k;

    public j$a(j jVar, Future<?> future) {
        this.k = jVar;
        this.j = future;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.j.isCancelled();
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        if (this.k.get() != Thread.currentThread()) {
            this.j.cancel(true);
        } else {
            this.j.cancel(false);
        }
    }
}
