package d0.e0.p.d.m0.n;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: IntersectionTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0$a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.n.l1.g, j0> {
    public final /* synthetic */ a0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0$a(a0 a0Var) {
        super(1);
        this.this$0 = a0Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ j0 invoke(d0.e0.p.d.m0.n.l1.g gVar) {
        return invoke2(gVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final j0 invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this.this$0.refine(gVar).createType();
    }
}
