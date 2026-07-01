package d0.e0.p.d.m0.b.q;

import d0.e0.p.d.m0.c.c0;
import d0.e0.p.d.m0.c.d0;
import d0.e0.p.d.m0.l.b.q$a;
import d0.e0.p.d.m0.l.b.t$a;

/* JADX INFO: compiled from: JvmBuiltInsPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends d0.e0.p.d.m0.l.b.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(d0.e0.p.d.m0.m.o oVar, d0.e0.p.d.m0.e.b.n nVar, c0 c0Var, d0 d0Var, d0.e0.p.d.m0.c.h1.a aVar, d0.e0.p.d.m0.c.h1.c cVar, d0.e0.p.d.m0.l.b.k kVar, d0.e0.p.d.m0.n.l1.l lVar, d0.e0.p.d.m0.k.z.a aVar2) {
        super(oVar, nVar, c0Var);
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(nVar, "finder");
        d0.z.d.m.checkNotNullParameter(c0Var, "moduleDescriptor");
        d0.z.d.m.checkNotNullParameter(d0Var, "notFoundClasses");
        d0.z.d.m.checkNotNullParameter(aVar, "additionalClassPartsProvider");
        d0.z.d.m.checkNotNullParameter(cVar, "platformDependentDeclarationFilter");
        d0.z.d.m.checkNotNullParameter(kVar, "deserializationConfiguration");
        d0.z.d.m.checkNotNullParameter(lVar, "kotlinTypeChecker");
        d0.z.d.m.checkNotNullParameter(aVar2, "samConversionResolver");
        d0.e0.p.d.m0.l.b.m mVar = new d0.e0.p.d.m0.l.b.m(this);
        d0.e0.p.d.m0.l.b.d0.a aVar3 = d0.e0.p.d.m0.l.b.d0.a.m;
        d0.e0.p.d.m0.l.b.d dVar = new d0.e0.p.d.m0.l.b.d(c0Var, d0Var, aVar3);
        t$a t_a = t$a.a;
        d0.e0.p.d.m0.l.b.p pVar = d0.e0.p.d.m0.l.b.p.a;
        d0.z.d.m.checkNotNullExpressionValue(pVar, "DO_NOTHING");
        d0.e0.p.d.m0.l.b.j jVar = new d0.e0.p.d.m0.l.b.j(oVar, c0Var, kVar, mVar, dVar, this, t_a, pVar, d0.e0.p.d.m0.d.b.c$a.a, q$a.a, d0.t.n.listOf((Object[]) new d0.e0.p.d.m0.c.h1.b[]{new d0.e0.p.d.m0.b.p.a(oVar, c0Var), new e(oVar, c0Var, null, 4, null)}), d0Var, d0.e0.p.d.m0.l.b.i.a.getDEFAULT(), aVar, cVar, aVar3.getExtensionRegistry(), lVar, aVar2, null, 262144, null);
        d0.z.d.m.checkNotNullParameter(jVar, "<set-?>");
        this.d = jVar;
    }
}
