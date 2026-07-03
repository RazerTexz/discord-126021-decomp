package p637j0.p642l.p643a;

import java.util.concurrent.TimeUnit;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.i0 */
/* JADX INFO: compiled from: OnSubscribeTimerOnce.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12631i0 implements Observable.InterfaceC13005a<Long> {

    /* JADX INFO: renamed from: j */
    public final long f26847j;

    /* JADX INFO: renamed from: k */
    public final TimeUnit f26848k;

    /* JADX INFO: renamed from: l */
    public final Scheduler f26849l;

    public C12631i0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f26847j = j;
        this.f26848k = timeUnit;
        this.f26849l = scheduler;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler.Worker workerMo10739a = this.f26849l.mo10739a();
        subscriber.add(workerMo10739a);
        workerMo10739a.mo10741b(new C12627h0(this, subscriber), this.f26847j, this.f26848k);
    }
}
