package j0.l.a;

import rx.Scheduler$Worker;
import rx.Subscriber;
import rx.functions.Action0;

/* JADX INFO: compiled from: OnSubscribeTimerPeriodically.java */
/* JADX INFO: loaded from: classes3.dex */
public class j0 implements Action0 {
    public long j;
    public final /* synthetic */ Subscriber k;
    public final /* synthetic */ Scheduler$Worker l;

    public j0(k0 k0Var, Subscriber subscriber, Scheduler$Worker scheduler$Worker) {
        this.k = subscriber;
        this.l = scheduler$Worker;
    }

    @Override // rx.functions.Action0
    public void call() {
        try {
            Subscriber subscriber = this.k;
            long j = this.j;
            this.j = 1 + j;
            subscriber.onNext(Long.valueOf(j));
        } catch (Throwable th) {
            try {
                this.l.unsubscribe();
            } finally {
                Subscriber subscriber2 = this.k;
                b.i.a.f.e.o.f.o1(th);
                subscriber2.onError(th);
            }
        }
    }
}
