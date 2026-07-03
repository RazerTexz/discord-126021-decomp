package p637j0.p642l.p647e;

import p637j0.InterfaceC12581g;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.e.f */
/* JADX INFO: compiled from: ObserverSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12716f<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final InterfaceC12581g<? super T> f27276j;

    public C12716f(InterfaceC12581g<? super T> interfaceC12581g) {
        this.f27276j = interfaceC12581g;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27276j.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27276j.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f27276j.onNext(t);
    }
}
