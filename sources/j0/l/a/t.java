package j0.l.a;

import java.util.concurrent.atomic.AtomicLong;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: compiled from: OnSubscribeRedo.java */
/* JADX INFO: loaded from: classes3.dex */
public class t implements Action0 {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ Subject k;
    public final /* synthetic */ j0.l.b.a l;
    public final /* synthetic */ AtomicLong m;
    public final /* synthetic */ SerialSubscription n;
    public final /* synthetic */ y o;

    public t(y yVar, Subscriber subscriber, Subject subject, j0.l.b.a aVar, AtomicLong atomicLong, SerialSubscription serialSubscription) {
        this.o = yVar;
        this.j = subscriber;
        this.k = subject;
        this.l = aVar;
        this.m = atomicLong;
        this.n = serialSubscription;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // rx.functions.Action0
    public void call() {
        if (this.j.isUnsubscribed()) {
            return;
        }
        t$a t_a = new t$a(this);
        this.n.a(t_a);
        this.o.j.i0(t_a);
    }
}
