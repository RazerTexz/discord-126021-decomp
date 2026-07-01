package d0.e0.p.d.m0.k;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [H] */
/* JADX INFO: compiled from: overridingUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p$a<H> extends d0.z.d.o implements Function1<H, Unit> {
    public final /* synthetic */ d0.e0.p.d.m0.p.j<H> $conflictedHandles;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p$a(d0.e0.p.d.m0.p.j<H> jVar) {
        super(1);
        this.$conflictedHandles = jVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(H h) {
        d0.e0.p.d.m0.p.j<H> jVar = this.$conflictedHandles;
        d0.z.d.m.checkNotNullExpressionValue(h, "it");
        jVar.add(h);
    }
}
