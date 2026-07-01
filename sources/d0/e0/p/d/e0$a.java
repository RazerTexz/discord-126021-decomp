package d0.e0.p.d;

import d0.e0.p.d.m0.c.c1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ReflectionObjectRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e0$a extends d0.z.d.o implements Function1<c1, CharSequence> {
    public static final e0$a j = new e0$a();

    public e0$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(c1 c1Var) {
        return invoke2(c1Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(c1 c1Var) {
        e0 e0Var = e0.f3197b;
        d0.z.d.m.checkNotNullExpressionValue(c1Var, "it");
        d0.e0.p.d.m0.n.c0 type = c1Var.getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "it.type");
        return e0Var.renderType(type);
    }
}
