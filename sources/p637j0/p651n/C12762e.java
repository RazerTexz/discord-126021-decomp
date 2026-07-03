package p637j0.p651n;

import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.n.e */
/* JADX INFO: compiled from: Subscribers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12762e<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Subscriber f27373j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12762e(Subscriber subscriber, Subscriber subscriber2) {
        super(subscriber);
        this.f27373j = subscriber2;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27373j.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27373j.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f27373j.onNext(t);
    }
}
