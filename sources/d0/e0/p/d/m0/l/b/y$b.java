package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.u0;

/* JADX INFO: compiled from: ProtoContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y$b extends y {
    public final d0.e0.p.d.m0.g.b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y$b(d0.e0.p.d.m0.g.b bVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, u0 u0Var) {
        super(cVar, gVar, u0Var, null);
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar, "typeTable");
        this.d = bVar;
    }

    @Override // d0.e0.p.d.m0.l.b.y
    public d0.e0.p.d.m0.g.b debugFqName() {
        return this.d;
    }
}
