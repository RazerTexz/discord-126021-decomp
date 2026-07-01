package d0.e0.p.d.m0.k;

/* JADX INFO: compiled from: OverridingStrategy.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class i extends j {
    public abstract void conflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2);

    @Override // d0.e0.p.d.m0.k.j
    public void inheritanceConflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2) {
        d0.z.d.m.checkNotNullParameter(bVar, "first");
        d0.z.d.m.checkNotNullParameter(bVar2, "second");
        conflict(bVar, bVar2);
    }

    @Override // d0.e0.p.d.m0.k.j
    public void overrideConflict(d0.e0.p.d.m0.c.b bVar, d0.e0.p.d.m0.c.b bVar2) {
        d0.z.d.m.checkNotNullParameter(bVar, "fromSuper");
        d0.z.d.m.checkNotNullParameter(bVar2, "fromCurrent");
        conflict(bVar, bVar2);
    }
}
