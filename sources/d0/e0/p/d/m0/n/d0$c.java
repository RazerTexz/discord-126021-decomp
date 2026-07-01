package d0.e0.p.d.m0.n;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d0$c extends d0.z.d.o implements Function1<d0.e0.p.d.m0.n.l1.g, j0> {
    public final /* synthetic */ d0.e0.p.d.m0.c.g1.g $annotations;
    public final /* synthetic */ List<w0> $arguments;
    public final /* synthetic */ u0 $constructor;
    public final /* synthetic */ boolean $nullable;
    public final /* synthetic */ d0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d0$c(d0 d0Var, u0 u0Var, List<? extends w0> list, d0.e0.p.d.m0.c.g1.g gVar, boolean z2) {
        super(1);
        this.this$0 = d0Var;
        this.$constructor = u0Var;
        this.$arguments = list;
        this.$annotations = gVar;
        this.$nullable = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ j0 invoke(d0.e0.p.d.m0.n.l1.g gVar) {
        return invoke2(gVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final j0 invoke2(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "refiner");
        d0$b d0_bAccess$refineConstructor = d0.access$refineConstructor(this.this$0, this.$constructor, gVar, this.$arguments);
        if (d0_bAccess$refineConstructor == null) {
            return null;
        }
        j0 expandedType = d0_bAccess$refineConstructor.getExpandedType();
        if (expandedType != null) {
            return expandedType;
        }
        d0.e0.p.d.m0.c.g1.g gVar2 = this.$annotations;
        u0 refinedConstructor = d0_bAccess$refineConstructor.getRefinedConstructor();
        d0.z.d.m.checkNotNull(refinedConstructor);
        return d0.simpleType(gVar2, refinedConstructor, this.$arguments, this.$nullable, gVar);
    }
}
