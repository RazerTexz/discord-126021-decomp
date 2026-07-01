package j0.l.c;

import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: compiled from: ExecutorScheduler.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a$b implements Action0 {
    public final /* synthetic */ j0.r.b j;
    public final /* synthetic */ Action0 k;
    public final /* synthetic */ Subscription l;
    public final /* synthetic */ c$a m;

    public c$a$b(c$a c_a, j0.r.b bVar, Action0 action0, Subscription subscription) {
        this.m = c_a;
        this.j = bVar;
        this.k = action0;
        this.l = subscription;
    }

    @Override // rx.functions.Action0
    public void call() {
        if (this.j.isUnsubscribed()) {
            return;
        }
        Subscription subscriptionA = this.m.a(this.k);
        this.j.a(subscriptionA);
        if (subscriptionA.getClass() == j.class) {
            ((j) subscriptionA).cancel.a(this.l);
        }
    }
}
