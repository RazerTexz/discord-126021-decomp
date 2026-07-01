package d0.e0.p.d.m0.j;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.w0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b extends d0.z.d.o implements Function1<w0, CharSequence> {
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$b(d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(w0 w0Var) {
        return invoke2(w0Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(w0 w0Var) {
        d0.z.d.m.checkNotNullParameter(w0Var, "it");
        if (w0Var.isStarProjection()) {
            return "*";
        }
        d dVar = this.this$0;
        c0 type = w0Var.getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "it.type");
        String strRenderType = dVar.renderType(type);
        if (w0Var.getProjectionKind() == j1.INVARIANT) {
            return strRenderType;
        }
        return w0Var.getProjectionKind() + ' ' + strRenderType;
    }
}
