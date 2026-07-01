package d0.e0.p.d.m0.n.p1;

import d0.e0.p.d.m0.n.i1;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a extends o implements Function1<i1, Boolean> {
    public static final b$a j = new b$a();

    public b$a() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Boolean invoke2(i1 i1Var) {
        m.checkNotNullExpressionValue(i1Var, "it");
        return Boolean.valueOf(d0.e0.p.d.m0.k.u.a.d.isCaptured(i1Var));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(i1 i1Var) {
        return invoke2(i1Var);
    }
}
