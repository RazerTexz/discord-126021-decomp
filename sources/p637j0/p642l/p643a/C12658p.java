package p637j0.p642l.p643a;

import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p644b.C12694b;
import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.p */
/* JADX INFO: compiled from: OnSubscribeFromCallable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12658p<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Callable<? extends T> f26972j;

    public C12658p(Callable<? extends T> callable) {
        this.f26972j = callable;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        C12694b c12694b = new C12694b(subscriber);
        subscriber.setProducer(c12694b);
        try {
            c12694b.m10799b(this.f26972j.call());
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            subscriber.onError(th);
        }
    }
}
