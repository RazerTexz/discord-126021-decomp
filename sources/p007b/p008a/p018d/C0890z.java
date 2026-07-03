package p007b.p008a.p018d;

import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: renamed from: b.a.d.z */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0890z<T, R> implements InterfaceC12589b<T, Observable<? extends R>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C0853a0 f594j;

    public C0890z(C0853a0 c0853a0) {
        this.f594j = c0853a0;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        return ((Boolean) this.f594j.f499j.invoke(obj)).booleanValue() ? (Observable) this.f594j.f500k.invoke(obj) : (Observable) this.f594j.f501l.invoke(obj);
    }
}
