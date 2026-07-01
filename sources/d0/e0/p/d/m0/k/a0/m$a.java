package d0.e0.p.d.m0.k.a0;

import d0.e0.p.d.m0.c.t0;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StaticScopeForKotlinEnum.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a extends d0.z.d.o implements Function0<List<? extends t0>> {
    public final /* synthetic */ m this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m$a(m mVar) {
        super(0);
        this.this$0 = mVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends t0> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends t0> invoke2() {
        return d0.t.n.listOf((Object[]) new t0[]{d0.e0.p.d.m0.k.d.createEnumValueOfMethod(m.access$getContainingClass$p(this.this$0)), d0.e0.p.d.m0.k.d.createEnumValuesMethod(m.access$getContainingClass$p(this.this$0))});
    }
}
