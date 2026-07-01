package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.c.c0;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends g<List<? extends g<?>>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<c0, d0.e0.p.d.m0.n.c0> f3471b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public b(List<? extends g<?>> list, Function1<? super c0, ? extends d0.e0.p.d.m0.n.c0> function1) {
        super(list);
        d0.z.d.m.checkNotNullParameter(list, "value");
        d0.z.d.m.checkNotNullParameter(function1, "computeType");
        this.f3471b = function1;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public d0.e0.p.d.m0.n.c0 getType(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        d0.e0.p.d.m0.n.c0 c0VarInvoke = this.f3471b.invoke(c0Var);
        if (!d0.e0.p.d.m0.b.h.isArray(c0VarInvoke) && !d0.e0.p.d.m0.b.h.isPrimitiveArray(c0VarInvoke)) {
            d0.e0.p.d.m0.b.h.isUnsignedArrayType(c0VarInvoke);
        }
        return c0VarInvoke;
    }
}
