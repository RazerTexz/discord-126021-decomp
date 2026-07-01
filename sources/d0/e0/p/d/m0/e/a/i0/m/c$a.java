package d0.e0.p.d.m0.e.a.i0.m;

import d0.e0.p.d.m0.c.h;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.u0;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a extends o implements Function0<c0> {
    public final /* synthetic */ u0 $constructor;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c$a(u0 u0Var) {
        super(0);
        this.$constructor = u0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ c0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final c0 invoke() {
        h declarationDescriptor = this.$constructor.getDeclarationDescriptor();
        m.checkNotNull(declarationDescriptor);
        j0 defaultType = declarationDescriptor.getDefaultType();
        m.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
        return d0.e0.p.d.m0.n.o1.a.replaceArgumentsWithStarProjections(defaultType);
    }
}
