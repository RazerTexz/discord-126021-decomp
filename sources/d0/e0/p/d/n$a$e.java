package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KPackageImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a$e extends d0.z.d.o implements Function0<d0.e0.p.d.m0.k.a0.i> {
    public final /* synthetic */ n$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$a$e(n$a n_a) {
        super(0);
        this.this$0 = n_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.k.a0.i invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.k.a0.i invoke() {
        d0.e0.p.d.m0.c.k1.a.f fVarAccess$getKotlinClass$p = n$a.access$getKotlinClass$p(this.this$0);
        return fVarAccess$getKotlinClass$p != null ? this.this$0.getModuleData().getPackagePartScopeCache().getPackagePartScope(fVarAccess$getKotlinClass$p) : d0.e0.p.d.m0.k.a0.i$b.f3461b;
    }
}
