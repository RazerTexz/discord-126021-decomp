package p637j0.p642l.p643a;

import java.util.concurrent.TimeUnit;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.k0 */
/* JADX INFO: compiled from: OnSubscribeTimerPeriodically.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12639k0 implements Observable.InterfaceC13005a<Long> {

    /* JADX INFO: renamed from: j */
    public final long f26886j;

    /* JADX INFO: renamed from: k */
    public final long f26887k;

    /* JADX INFO: renamed from: l */
    public final TimeUnit f26888l;

    /* JADX INFO: renamed from: m */
    public final Scheduler f26889m;

    public C12639k0(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        this.f26886j = j;
        this.f26887k = j2;
        this.f26888l = timeUnit;
        this.f26889m = scheduler;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerMo10739a = this.f26889m.mo10739a();
        subscriber.add(workerMo10739a);
        workerMo10739a.m11120c(new C12635j0(this, subscriber, workerMo10739a), this.f26886j, this.f26887k, this.f26888l);
    }
}
