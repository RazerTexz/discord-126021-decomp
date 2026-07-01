package d0.e0.p.d;

import d0.e0.p.d.m0.c.c1;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KCallableImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b$d extends d0.z.d.o implements Function0<d0.e0.p.d.m0.c.k0> {
    public final /* synthetic */ d0.e0.p.d.m0.c.b $descriptor;
    public final /* synthetic */ int $i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f$b$d(d0.e0.p.d.m0.c.b bVar, int i) {
        super(0);
        this.$descriptor = bVar;
        this.$i = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.k0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.c.k0 invoke() {
        c1 c1Var = this.$descriptor.getValueParameters().get(this.$i);
        d0.z.d.m.checkNotNullExpressionValue(c1Var, "descriptor.valueParameters[i]");
        return c1Var;
    }
}
