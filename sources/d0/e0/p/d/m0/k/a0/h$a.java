package d0.e0.p.d.m0.k.a0;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyScopeAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a extends d0.z.d.o implements Function0<i> {
    public final /* synthetic */ Function0<i> $getScope;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public h$a(Function0<? extends i> function0) {
        super(0);
        this.$getScope = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ i invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final i invoke() {
        i iVarInvoke = this.$getScope.invoke();
        return iVarInvoke instanceof a ? ((a) iVarInvoke).getActualScope() : iVarInvoke;
    }
}
