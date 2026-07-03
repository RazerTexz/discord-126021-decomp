package p637j0;

import p637j0.C12578d;
import p658rx.Observable;

/* JADX INFO: renamed from: j0.c */
/* JADX INFO: compiled from: Completable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12577c implements C12578d.a {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Observable f26686j;

    public C12577c(Observable observable) {
        this.f26686j = observable;
    }

    @Override // p658rx.functions.Action1
    public void call(InterfaceC12579e interfaceC12579e) {
        InterfaceC12579e interfaceC12579e2 = interfaceC12579e;
        C12576b c12576b = new C12576b(this, interfaceC12579e2);
        interfaceC12579e2.m10732a(c12576b);
        this.f26686j.m11107i0(c12576b);
    }
}
