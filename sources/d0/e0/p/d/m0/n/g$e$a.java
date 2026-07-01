package d0.e0.p.d.m0.n;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$e$a extends d0.z.d.o implements Function1<u0, Iterable<? extends c0>> {
    public final /* synthetic */ g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g$e$a(g gVar) {
        super(1);
        this.this$0 = gVar;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Iterable<c0> invoke2(u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(u0Var, "it");
        return g.access$computeNeighbours(this.this$0, u0Var, false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Iterable<? extends c0> invoke(u0 u0Var) {
        return invoke2(u0Var);
    }
}
