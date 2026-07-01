package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends d0.z.d.o implements Function0<c0> {
    public final /* synthetic */ g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(g gVar) {
        super(0);
        this.this$0 = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ c0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final c0 invoke() {
        j0 anyType = g.access$getModuleDescriptor$p(this.this$0).getBuiltIns().getAnyType();
        d0.z.d.m.checkNotNullExpressionValue(anyType, "moduleDescriptor.builtIns.anyType");
        return anyType;
    }
}
