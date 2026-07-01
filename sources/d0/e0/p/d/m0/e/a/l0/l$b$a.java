package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.i1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$b$a extends d0.z.d.o implements Function1<i1, Boolean> {
    public static final l$b$a j = new l$b$a();

    public l$b$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(i1 i1Var) {
        return invoke2(i1Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(i1 i1Var) {
        d0.e0.p.d.m0.c.h declarationDescriptor = i1Var.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return Boolean.FALSE;
        }
        d0.e0.p.d.m0.g.e name = declarationDescriptor.getName();
        d0.e0.p.d.m0.b.q.c cVar = d0.e0.p.d.m0.b.q.c.a;
        return Boolean.valueOf(d0.z.d.m.areEqual(name, cVar.getFUNCTION_N_FQ_NAME().shortName()) && d0.z.d.m.areEqual(d0.e0.p.d.m0.k.x.a.fqNameOrNull(declarationDescriptor), cVar.getFUNCTION_N_FQ_NAME()));
    }
}
