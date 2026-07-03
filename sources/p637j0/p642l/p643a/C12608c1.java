package p637j0.p642l.p643a;

import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: j0.l.a.c1 */
/* JADX INFO: compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12608c1<T> implements InterfaceC12589b<Throwable, Observable<? extends T>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC12589b f26757j;

    public C12608c1(InterfaceC12589b interfaceC12589b) {
        this.f26757j = interfaceC12589b;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Throwable th) {
        return new C12721k(this.f26757j.call(th));
    }
}
