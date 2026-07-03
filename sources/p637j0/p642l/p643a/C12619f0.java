package p637j0.p642l.p643a;

import p658rx.Observable;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.f0 */
/* JADX INFO: compiled from: OnSubscribeThrow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12619f0<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Throwable f26787j;

    public C12619f0(Throwable th) {
        this.f26787j = th;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        ((Subscriber) obj).onError(this.f26787j);
    }
}
