package d0.e0.p.d.m0.c.i1;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends d0.z.d.o implements Function1<d0.e0.p.d.m0.n.l1.g, d0.e0.p.d.m0.n.j0> {
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(e eVar) {
        super(1);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.j0 invoke(d0.e0.p.d.m0.n.l1.g gVar) {
        return invoke2(gVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.n.j0 invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.e0.p.d.m0.c.h hVarRefineDescriptor = gVar.refineDescriptor(this.this$0);
        if (hVarRefineDescriptor == null) {
            return null;
        }
        return hVarRefineDescriptor.getDefaultType();
    }
}
