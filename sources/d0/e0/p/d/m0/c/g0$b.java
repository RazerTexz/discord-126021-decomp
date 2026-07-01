package d0.e0.p.d.m0.c;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: PackageFragmentProviderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g0$b extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.b, Boolean> {
    public final /* synthetic */ d0.e0.p.d.m0.g.b $fqName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0$b(d0.e0.p.d.m0.g.b bVar) {
        super(1);
        this.$fqName = bVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.g.b bVar) {
        return Boolean.valueOf(invoke2(bVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "it");
        return !bVar.isRoot() && d0.z.d.m.areEqual(bVar.parent(), this.$fqName);
    }
}
