package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.c1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ErasedOverridabilityCondition.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p$b extends d0.z.d.o implements Function1<c1, d0.e0.p.d.m0.n.c0> {
    public static final p$b j = new p$b();

    public p$b() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.c0 invoke(c1 c1Var) {
        return invoke2(c1Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.n.c0 invoke2(c1 c1Var) {
        return c1Var.getType();
    }
}
