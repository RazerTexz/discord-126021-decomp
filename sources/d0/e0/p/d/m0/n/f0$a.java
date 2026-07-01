package d0.e0.p.d.m0.n;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f0$a extends d0.z.d.o implements Function0<c0> {
    public final /* synthetic */ d0.e0.p.d.m0.n.l1.g $kotlinTypeRefiner;
    public final /* synthetic */ f0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0$a(d0.e0.p.d.m0.n.l1.g gVar, f0 f0Var) {
        super(0);
        this.$kotlinTypeRefiner = gVar;
        this.this$0 = f0Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ c0 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final c0 invoke() {
        return this.$kotlinTypeRefiner.refineType((c0) f0.access$getComputation$p(this.this$0).invoke());
    }
}
