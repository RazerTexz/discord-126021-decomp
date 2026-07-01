package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: annotationUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$a extends o implements Function1<c0, d0.e0.p.d.m0.n.c0> {
    public final /* synthetic */ d0.e0.p.d.m0.b.h $this_createDeprecatedAnnotation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$a(d0.e0.p.d.m0.b.h hVar) {
        super(1);
        this.$this_createDeprecatedAnnotation = hVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.c0 invoke(c0 c0Var) {
        return invoke2(c0Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.n.c0 invoke2(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        j0 arrayType = c0Var.getBuiltIns().getArrayType(j1.INVARIANT, this.$this_createDeprecatedAnnotation.getStringType());
        d0.z.d.m.checkNotNullExpressionValue(arrayType, "module.builtIns.getArrayType(Variance.INVARIANT, stringType)");
        return arrayType;
    }
}
