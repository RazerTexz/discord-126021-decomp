package p637j0.p651n;

import p637j0.InterfaceC12581g;
import p658rx.Subscriber;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.n.d */
/* JADX INFO: compiled from: Subscribers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12761d<T> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC12581g f27372j;

    public C12761d(InterfaceC12581g interfaceC12581g) {
        this.f27372j = interfaceC12581g;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27372j.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27372j.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f27372j.onNext(t);
    }
}
