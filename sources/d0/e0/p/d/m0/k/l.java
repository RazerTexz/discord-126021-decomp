package d0.e0.p.d.m0.k;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements Function1<d0.e0.p.d.m0.c.b, Boolean> {
    public final /* synthetic */ d0.e0.p.d.m0.c.m j;

    public l(d0.e0.p.d.m0.c.m mVar) {
        this.j = mVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.b bVar) {
        return invoke2(bVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Boolean invoke2(d0.e0.p.d.m0.c.b bVar) {
        return Boolean.valueOf(bVar.getContainingDeclaration() == this.j);
    }
}
