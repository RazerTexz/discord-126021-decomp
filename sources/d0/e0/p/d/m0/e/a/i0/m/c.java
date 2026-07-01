package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.u0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends o implements Function0<c0> {
    public final /* synthetic */ a $attr;
    public final /* synthetic */ u0 $constructor;
    public final /* synthetic */ z0 $parameter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(z0 z0Var, a aVar, u0 u0Var) {
        super(0);
        this.$parameter = z0Var;
        this.$attr = aVar;
        this.$constructor = u0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ c0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final c0 invoke() {
        z0 z0Var = this.$parameter;
        m.checkNotNullExpressionValue(z0Var, "parameter");
        return e.getErasedUpperBound(z0Var, this.$attr.getUpperBoundOfTypeParameter(), new c$a(this.$constructor));
    }
}
