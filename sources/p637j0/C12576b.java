package p637j0;

import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.b */
/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12576b extends Subscriber<Object> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC12579e f26685j;

    public C12576b(C12577c c12577c, InterfaceC12579e interfaceC12579e) {
        this.f26685j = interfaceC12579e;
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f26685j.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f26685j.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(Object obj) {
    }
}
