package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.n.j0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ConstantValueFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$b extends d0.z.d.o implements Function1<c0, d0.e0.p.d.m0.n.c0> {
    public final /* synthetic */ d0.e0.p.d.m0.b.i $componentType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$b(d0.e0.p.d.m0.b.i iVar) {
        super(1);
        this.$componentType = iVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.n.c0 invoke(c0 c0Var) {
        return invoke2(c0Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.n.c0 invoke2(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        j0 primitiveArrayKotlinType = c0Var.getBuiltIns().getPrimitiveArrayKotlinType(this.$componentType);
        d0.z.d.m.checkNotNullExpressionValue(primitiveArrayKotlinType, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
        return primitiveArrayKotlinType;
    }
}
