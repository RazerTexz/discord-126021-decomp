package d0.e0.p.d.m0.n;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g$e$b extends d0.z.d.o implements Function1<c0, Unit> {
    public final /* synthetic */ g this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g$e$b(g gVar) {
        super(1);
        this.this$0 = gVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(c0 c0Var) {
        invoke2(c0Var);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "it");
        this.this$0.f(c0Var);
    }
}
