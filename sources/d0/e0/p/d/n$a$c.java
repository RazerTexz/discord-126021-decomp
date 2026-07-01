package d0.e0.p.d;

import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KPackageImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a$c extends d0.z.d.o implements Function0<Triple<? extends d0.e0.p.d.m0.f.a0.b.g, ? extends d0.e0.p.d.m0.f.l, ? extends d0.e0.p.d.m0.f.a0.b.f>> {
    public final /* synthetic */ n$a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$a$c(n$a n_a) {
        super(0);
        this.this$0 = n_a;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Triple<? extends d0.e0.p.d.m0.f.a0.b.g, ? extends d0.e0.p.d.m0.f.l, ? extends d0.e0.p.d.m0.f.a0.b.f> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Triple<? extends d0.e0.p.d.m0.f.a0.b.g, ? extends d0.e0.p.d.m0.f.l, ? extends d0.e0.p.d.m0.f.a0.b.f> invoke2() {
        d0.e0.p.d.m0.e.b.b0.a classHeader;
        d0.e0.p.d.m0.c.k1.a.f fVarAccess$getKotlinClass$p = n$a.access$getKotlinClass$p(this.this$0);
        if (fVarAccess$getKotlinClass$p == null || (classHeader = fVarAccess$getKotlinClass$p.getClassHeader()) == null) {
            return null;
        }
        String[] data = classHeader.getData();
        String[] strings = classHeader.getStrings();
        if (data == null || strings == null) {
            return null;
        }
        Pair<d0.e0.p.d.m0.f.a0.b.g, d0.e0.p.d.m0.f.l> packageDataFrom = d0.e0.p.d.m0.f.a0.b.h.readPackageDataFrom(data, strings);
        return new Triple<>(packageDataFrom.component1(), packageDataFrom.component2(), classHeader.getMetadataVersion());
    }
}
