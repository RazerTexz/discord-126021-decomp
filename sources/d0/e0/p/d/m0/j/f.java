package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.n.c0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends d0.z.d.o implements Function1<c0, CharSequence> {
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(c0 c0Var) {
        d dVar = this.this$0;
        d0.z.d.m.checkNotNullExpressionValue(c0Var, "it");
        return dVar.renderType(c0Var);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(c0 c0Var) {
        return invoke2(c0Var);
    }
}
