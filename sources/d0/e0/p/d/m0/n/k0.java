package d0.e0.p.d.m0.n;

import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: KotlinTypeFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 extends j0 {
    public final u0 k;
    public final List<w0> l;
    public final boolean m;
    public final d0.e0.p.d.m0.k.a0.i n;
    public final Function1<d0.e0.p.d.m0.n.l1.g, j0> o;

    /* JADX WARN: Multi-variable type inference failed */
    public k0(u0 u0Var, List<? extends w0> list, boolean z2, d0.e0.p.d.m0.k.a0.i iVar, Function1<? super d0.e0.p.d.m0.n.l1.g, ? extends j0> function1) {
        d0.z.d.m.checkNotNullParameter(u0Var, "constructor");
        d0.z.d.m.checkNotNullParameter(list, "arguments");
        d0.z.d.m.checkNotNullParameter(iVar, "memberScope");
        d0.z.d.m.checkNotNullParameter(function1, "refinedTypeFactory");
        this.k = u0Var;
        this.l = list;
        this.m = z2;
        this.n = iVar;
        this.o = function1;
        if (getMemberScope() instanceof t$d) {
            StringBuilder sbU = b.d.b.a.a.U("SimpleTypeImpl should not be created for error type: ");
            sbU.append(getMemberScope());
            sbU.append('\n');
            sbU.append(getConstructor());
            throw new IllegalStateException(sbU.toString());
        }
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return d0.e0.p.d.m0.c.g1.g.f.getEMPTY();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public List<w0> getArguments() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public u0 getConstructor() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public d0.e0.p.d.m0.k.a0.i getMemberScope() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 makeNullableAsSpecified(boolean z2) {
        if (z2 == isMarkedNullable()) {
            return this;
        }
        return z2 ? new h0(this) : new g0(this);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return gVar.isEmpty() ? this : new h(this, gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public j0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        j0 j0VarInvoke = this.o.invoke(gVar);
        return j0VarInvoke == null ? this : j0VarInvoke;
    }
}
