package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.c.x;
import d0.t.u;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a extends d0.z.d.o implements Function0<List<? extends d0.e0.p.d.m0.c.m>> {
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$a(e eVar) {
        super(0);
        this.this$0 = eVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.m> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.c.m> invoke2() {
        List<x> listA = this.this$0.a();
        return u.plus((Collection) listA, (Iterable) e.access$createFakeOverrides(this.this$0, listA));
    }
}
