package d0.e0.p.d.m0.c.i1;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.i1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractTypeAliasDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends d0.z.d.o implements Function1<i1, Boolean> {
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$a(e eVar) {
        super(1);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(i1 i1Var) {
        return invoke2(i1Var);
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002d  */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(i1 i1Var) {
        boolean z2;
        d0.z.d.m.checkNotNullExpressionValue(i1Var, "type");
        if (!d0.e0.p.d.m0.n.e0.isError(i1Var)) {
            e eVar = this.this$0;
            d0.e0.p.d.m0.c.h declarationDescriptor = i1Var.getConstructor().getDeclarationDescriptor();
            z2 = (declarationDescriptor instanceof z0) && !d0.z.d.m.areEqual(((z0) declarationDescriptor).getContainingDeclaration(), eVar);
        }
        return Boolean.valueOf(z2);
    }
}
