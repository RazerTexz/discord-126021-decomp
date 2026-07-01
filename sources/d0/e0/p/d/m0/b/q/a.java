package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.i1.g0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.n.c0;
import java.util.List;

/* JADX INFO: compiled from: CloneableClassScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends d0.e0.p.d.m0.k.a0.e {
    public static final a$a e = new a$a(null);
    public static final d0.e0.p.d.m0.g.e f;

    static {
        d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier("clone");
        d0.z.d.m.checkNotNullExpressionValue(eVarIdentifier, "identifier(\"clone\")");
        f = eVarIdentifier;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.c.e eVar) {
        super(oVar, eVar);
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(eVar, "containingClass");
    }

    public static final /* synthetic */ d0.e0.p.d.m0.g.e access$getCLONE_NAME$cp() {
        return f;
    }

    @Override // d0.e0.p.d.m0.k.a0.e
    public List<x> a() {
        g0 g0VarCreate = g0.create(this.c, d0.e0.p.d.m0.c.g1.g.f.getEMPTY(), e.getCLONE_NAME(), d0.e0.p.d.m0.c.b$a.DECLARATION, u0.a);
        g0VarCreate.initialize((q0) null, this.c.getThisAsReceiverParameter(), d0.t.n.emptyList(), d0.t.n.emptyList(), (c0) d0.e0.p.d.m0.k.x.a.getBuiltIns(this.c).getAnyType(), z.OPEN, t.c);
        return d0.t.m.listOf(g0VarCreate);
    }
}
