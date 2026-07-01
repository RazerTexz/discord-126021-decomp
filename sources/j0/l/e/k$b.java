package j0.l.e;

import rx.Scheduler;
import rx.Scheduler$Worker;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public class k$b implements j0.k.b<Action0, Subscription> {
    public final /* synthetic */ Scheduler j;

    public k$b(k kVar, Scheduler scheduler) {
        this.j = scheduler;
    }

    @Override // j0.k.b
    public Subscription call(Action0 action0) {
        Scheduler$Worker scheduler$WorkerA = this.j.a();
        scheduler$WorkerA.a(new l(this, action0, scheduler$WorkerA));
        return scheduler$WorkerA;
    }
}
