package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.u0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DeserializedPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o$a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.a, u0> {
    public final /* synthetic */ o this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o$a(o oVar) {
        super(1);
        this.this$0 = oVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ u0 invoke(d0.e0.p.d.m0.g.a aVar) {
        return invoke2(aVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final u0 invoke2(d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "it");
        d0.e0.p.d.m0.l.b.e0.f fVarAccess$getContainerSource$p = o.access$getContainerSource$p(this.this$0);
        if (fVarAccess$getContainerSource$p != null) {
            return fVarAccess$getContainerSource$p;
        }
        u0 u0Var = u0.a;
        d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
        return u0Var;
    }
}
