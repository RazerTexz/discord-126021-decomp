package d0.e0.p.d.m0.n;

import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a$a extends d0.z.d.o implements Function0<List<? extends c0>> {
    public final /* synthetic */ g$a this$0;
    public final /* synthetic */ g this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g$a$a(g$a g_a, g gVar) {
        super(0);
        this.this$0 = g_a;
        this.this$1 = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends c0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends c0> invoke2() {
        return d0.e0.p.d.m0.n.l1.h.refineTypes(g$a.access$getKotlinTypeRefiner$p(this.this$0), this.this$1.getSupertypes());
    }
}
