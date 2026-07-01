package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.p.b$c;

/* JADX INFO: compiled from: JvmBuiltInsCustomizer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements b$c<d0.e0.p.d.m0.c.b> {
    public static final m a = new m();

    @Override // d0.e0.p.d.m0.p.b$c
    public /* bridge */ /* synthetic */ Iterable<? extends d0.e0.p.d.m0.c.b> getNeighbors(d0.e0.p.d.m0.c.b bVar) {
        return getNeighbors2(bVar);
    }

    /* JADX INFO: renamed from: getNeighbors, reason: avoid collision after fix types in other method */
    public final Iterable<d0.e0.p.d.m0.c.b> getNeighbors2(d0.e0.p.d.m0.c.b bVar) {
        return bVar.getOriginal().getOverriddenDescriptors();
    }
}
