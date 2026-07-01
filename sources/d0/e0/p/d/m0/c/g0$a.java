package d0.e0.p.d.m0.c;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g0$a extends d0.z.d.o implements Function1<e0, d0.e0.p.d.m0.g.b> {
    public static final g0$a j = new g0$a();

    public g0$a() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.g.b invoke(e0 e0Var) {
        return invoke2(e0Var);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.g.b invoke2(e0 e0Var) {
        d0.z.d.m.checkNotNullParameter(e0Var, "it");
        return e0Var.getFqName();
    }
}
