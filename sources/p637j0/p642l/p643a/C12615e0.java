package p637j0.p642l.p643a;

import p637j0.AbstractC12583i;
import p637j0.C12582h;
import p658rx.Observable;

/* JADX INFO: renamed from: j0.l.a.e0 */
/* JADX INFO: compiled from: OnSubscribeSingle.java */
/* JADX INFO: loaded from: classes3.dex */
public class C12615e0<T> implements C12582h.a<T> {

    /* JADX INFO: renamed from: j */
    public final Observable<T> f26771j;

    public C12615e0(Observable<T> observable) {
        this.f26771j = observable;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        AbstractC12583i abstractC12583i = (AbstractC12583i) obj;
        C12611d0 c12611d0 = new C12611d0(this, abstractC12583i);
        abstractC12583i.f26697j.m11128a(c12611d0);
        this.f26771j.m11107i0(c12611d0);
    }
}
