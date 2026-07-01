package d0.e0.p.d.m0.k.a0;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: LazyScopeAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.m.j<i> f3459b;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ h(d0.e0.p.d.m0.m.o oVar, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i & 1) != 0) {
            oVar = d0.e0.p.d.m0.m.f.f3514b;
            d0.z.d.m.checkNotNullExpressionValue(oVar, "NO_LOCKS");
        }
        this(oVar, function0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public h(Function0<? extends i> function0) {
        this(null, function0, 1, null);
        d0.z.d.m.checkNotNullParameter(function0, "getScope");
    }

    @Override // d0.e0.p.d.m0.k.a0.a
    public i a() {
        return this.f3459b.invoke();
    }

    public h(d0.e0.p.d.m0.m.o oVar, Function0<? extends i> function0) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(function0, "getScope");
        this.f3459b = oVar.createLazyValue(new h$a(function0));
    }
}
