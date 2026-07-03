package p637j0.p642l.p643a;

import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Subscriber;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.h0 */
/* JADX INFO: compiled from: OnSubscribeTimerOnce.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12627h0 implements Action0 {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f26829j;

    public C12627h0(C12631i0 c12631i0, Subscriber subscriber) {
        this.f26829j = subscriber;
    }

    @Override // p658rx.functions.Action0
    public void call() {
        try {
            this.f26829j.onNext(0L);
            this.f26829j.onCompleted();
        } catch (Throwable th) {
            Subscriber subscriber = this.f26829j;
            C3404f.m4325o1(th);
            subscriber.onError(th);
        }
    }
}
