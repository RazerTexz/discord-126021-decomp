package d0.e0.p.d.m0.k;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: DescriptorEquivalenceForOverrides.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b$a extends d0.z.d.o implements Function2<d0.e0.p.d.m0.c.m, d0.e0.p.d.m0.c.m, Boolean> {
    public final /* synthetic */ d0.e0.p.d.m0.c.a $a;
    public final /* synthetic */ d0.e0.p.d.m0.c.a $b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$b$a(d0.e0.p.d.m0.c.a aVar, d0.e0.p.d.m0.c.a aVar2) {
        super(2);
        this.$a = aVar;
        this.$b = aVar2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
        return Boolean.valueOf(invoke2(mVar, mVar2));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.m mVar2) {
        return d0.z.d.m.areEqual(mVar, this.$a) && d0.z.d.m.areEqual(mVar2, this.$b);
    }
}
