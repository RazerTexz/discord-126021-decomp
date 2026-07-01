package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.n.c0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaStaticClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p$a extends d0.z.d.o implements Function1<c0, d0.e0.p.d.m0.c.e> {
    public static final p$a j = new p$a();

    public p$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke(c0 c0Var) {
        return invoke2(c0Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.c.e invoke2(c0 c0Var) {
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) {
            return (d0.e0.p.d.m0.c.e) declarationDescriptor;
        }
        return null;
    }
}
