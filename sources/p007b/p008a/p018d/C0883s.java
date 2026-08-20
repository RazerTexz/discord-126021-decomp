package p007b.p008a.p018d;

import java.util.Map;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;

/* JADX INFO: Add missing generic type declarations: [V, K, V1] */
/* JADX INFO: renamed from: b.a.d.s */
/* JADX INFO: compiled from: AppTransformers.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C0883s<T, R, K, V, V1> implements InterfaceC12589b<Map<K, ? extends V>, Observable<? extends Map<K, V1>>> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C0879o.c f579j;

    public C0883s(C0879o.c cVar) {
        this.f579j = cVar;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public Object call(Object obj) {
        Map map = (Map) obj;
        return Observable.m11058B(this.f579j.f569j).m11118y(new C0880p(map)).m11106g0(C0881q.f576j, new C0882r(this, map));
    }
}
