package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.n.i0;
import d0.e0.p.d.m0.n.i1;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$d extends d0.z.d.o implements Function1<i1, Boolean> {
    public static final l$d j = new l$d();

    public l$d() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(i1 i1Var) {
        return Boolean.valueOf(invoke2(i1Var));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(i1 i1Var) {
        d0.z.d.m.checkNotNullParameter(i1Var, "it");
        return i1Var instanceof i0;
    }
}
