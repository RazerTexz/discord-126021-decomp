package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.i1.c0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends d0.z.d.o implements Function0<d0.e0.p.d.m0.k.v.g<?>> {
    public final /* synthetic */ d0.e0.p.d.m0.e.a.k0.n $field;
    public final /* synthetic */ c0 $propertyDescriptor;
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(k kVar, d0.e0.p.d.m0.e.a.k0.n nVar, c0 c0Var) {
        super(0);
        this.this$0 = kVar;
        this.$field = nVar;
        this.$propertyDescriptor = c0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.v.g<?> invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.k.v.g<?> invoke() {
        return this.this$0.c.getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(this.$field, this.$propertyDescriptor);
    }
}
