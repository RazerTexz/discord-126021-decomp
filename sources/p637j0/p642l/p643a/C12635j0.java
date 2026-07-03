package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.j0 */
/* JADX INFO: compiled from: OnSubscribeTimerPeriodically.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12635j0 implements Action0 {

    /* JADX INFO: renamed from: j */
    public long f26854j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Subscriber f26855k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Scheduler.Worker f26856l;

    public C12635j0(C12639k0 c12639k0, Subscriber subscriber, Scheduler.Worker worker) {
        this.f26855k = subscriber;
        this.f26856l = worker;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        try {
            Subscriber subscriber = this.f26855k;
            long j = this.f26854j;
            this.f26854j = 1 + j;
            subscriber.onNext(Long.valueOf(j));
        } catch (Throwable th) {
            try {
                this.f26856l.unsubscribe();
            } finally {
                Subscriber subscriber2 = this.f26855k;
                C3404f.m4325o1(th);
                subscriber2.onError(th);
            }
        }
    }
}
