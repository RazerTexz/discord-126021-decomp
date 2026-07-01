package d0.e0.p.d.m0.k;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements Function1<d0.e0.p.d.m0.c.b, Unit> {
    public final /* synthetic */ j j;
    public final /* synthetic */ d0.e0.p.d.m0.c.b k;

    public o(j jVar, d0.e0.p.d.m0.c.b bVar) {
        this.j = jVar;
        this.k = bVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(d0.e0.p.d.m0.c.b bVar) {
        return invoke2(bVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public Unit invoke2(d0.e0.p.d.m0.c.b bVar) {
        this.j.inheritanceConflict(this.k, bVar);
        return Unit.a;
    }
}
