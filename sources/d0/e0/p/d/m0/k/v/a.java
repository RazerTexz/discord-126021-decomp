package d0.e0.p.d.m0.k.v;

import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends g<d0.e0.p.d.m0.c.g1.c> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d0.e0.p.d.m0.c.g1.c cVar) {
        super(cVar);
        d0.z.d.m.checkNotNullParameter(cVar, "value");
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public c0 getType(d0.e0.p.d.m0.c.c0 c0Var) {
        d0.z.d.m.checkNotNullParameter(c0Var, "module");
        return getValue().getType();
    }
}
