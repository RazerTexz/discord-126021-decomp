package p637j0.p642l.p643a;

import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.d1 */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12612d1<T> implements InterfaceC12589b<Throwable, Observable<? extends T>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Observable f26766j;

    public C12612d1(Observable observable) {
        this.f26766j = observable;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Throwable th) {
        return this.f26766j;
    }
}
