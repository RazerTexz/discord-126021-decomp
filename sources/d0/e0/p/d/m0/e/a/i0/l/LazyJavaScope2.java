package d0.e0.p.d.m0.e.a.i0.l;

import d0.e0.p.d.m0.c.i1.PropertyDescriptorImpl;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.l.l, reason: use source file name */
/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class LazyJavaScope2 extends Lambda implements Function0<d0.e0.p.d.m0.k.v.g<?>> {
    public final /* synthetic */ d0.e0.p.d.m0.e.a.k0.n $field;
    public final /* synthetic */ PropertyDescriptorImpl $propertyDescriptor;
    public final /* synthetic */ LazyJavaScope this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyJavaScope2(LazyJavaScope lazyJavaScope, d0.e0.p.d.m0.e.a.k0.n nVar, PropertyDescriptorImpl propertyDescriptorImpl) {
        super(0);
        this.this$0 = lazyJavaScope;
        this.$field = nVar;
        this.$propertyDescriptor = propertyDescriptorImpl;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.k.v.g<?> invoke() {
        return this.this$0.c.getComponents().getJavaPropertyInitializerEvaluator().getInitializerConstant(this.$field, this.$propertyDescriptor);
    }
}
