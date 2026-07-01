package d0.e0.p.d.m0.e.a.i0.l;

import d0.t.o0;
import java.util.Set;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJavaClassMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$i$a extends d0.z.d.o implements Function0<Set<? extends d0.e0.p.d.m0.g.e>> {
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$i$a(h hVar) {
        super(0);
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Set<? extends d0.e0.p.d.m0.g.e> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Set<? extends d0.e0.p.d.m0.g.e> invoke2() {
        return o0.plus((Set) this.this$0.getFunctionNames(), (Iterable) this.this$0.getVariableNames());
    }
}
