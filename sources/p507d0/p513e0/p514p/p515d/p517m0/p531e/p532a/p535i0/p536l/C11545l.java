package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p536l;

import kotlin.jvm.functions.Function0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11366c0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11581n;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.l */
/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11545l extends AbstractC12240o implements Function0<AbstractC11815g<?>> {
    public final /* synthetic */ InterfaceC11581n $field;
    public final /* synthetic */ C11366c0 $propertyDescriptor;
    public final /* synthetic */ AbstractC11544k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11545l(AbstractC11544k abstractC11544k, InterfaceC11581n interfaceC11581n, C11366c0 c11366c0) {
        super(0);
        this.this$0 = abstractC11544k;
        this.$field = interfaceC11581n;
        this.$propertyDescriptor = c11366c0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AbstractC11815g<?> invoke() {
        return this.this$0.f23389c.getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(this.$field, this.$propertyDescriptor);
    }
}
