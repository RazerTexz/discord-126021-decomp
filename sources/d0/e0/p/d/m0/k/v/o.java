package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: IntegerLiteralTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends d0.z.d.o implements Function1<c0, CharSequence> {
    public static final o j = new o();

    public o() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "it");
        return c0Var.toString();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(c0 c0Var) {
        return invoke2(c0Var);
    }
}
