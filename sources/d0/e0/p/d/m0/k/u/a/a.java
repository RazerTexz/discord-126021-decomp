package d0.e0.p.d.m0.k.u.a;

import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.k.a0.i;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.t;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends j0 implements d0.e0.p.d.m0.n.n1.c {
    public final w0 k;
    public final b l;
    public final boolean m;
    public final g n;

    public /* synthetic */ a(w0 w0Var, b bVar, boolean z2, g gVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(w0Var, (i & 2) != 0 ? new c(w0Var) : bVar, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? g.f.getEMPTY() : gVar);
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public g getAnnotations() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public List<w0> getArguments() {
        return n.emptyList();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ u0 getConstructor() {
        return getConstructor();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public i getMemberScope() {
        i iVarCreateErrorScope = t.createErrorScope("No member resolution should be done on captured type, it used only during constraint system resolution", true);
        m.checkNotNullExpressionValue(iVarCreateErrorScope, "createErrorScope(\n            \"No member resolution should be done on captured type, it used only during constraint system resolution\", true\n        )");
        return iVarCreateErrorScope;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ j0 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ j0 replaceAnnotations(g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Captured(");
        sbU.append(this.k);
        sbU.append(')');
        sbU.append(isMarkedNullable() ? "?" : "");
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public b getConstructor() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public a makeNullableAsSpecified(boolean z2) {
        return z2 == isMarkedNullable() ? this : new a(this.k, getConstructor(), z2, getAnnotations());
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public a refine(d0.e0.p.d.m0.n.l1.g gVar) {
        m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        w0 w0VarRefine = this.k.refine(gVar);
        m.checkNotNullExpressionValue(w0VarRefine, "typeProjection.refine(kotlinTypeRefiner)");
        return new a(w0VarRefine, getConstructor(), isMarkedNullable(), getAnnotations());
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public a replaceAnnotations(g gVar) {
        m.checkNotNullParameter(gVar, "newAnnotations");
        return new a(this.k, getConstructor(), isMarkedNullable(), gVar);
    }

    public a(w0 w0Var, b bVar, boolean z2, g gVar) {
        m.checkNotNullParameter(w0Var, "typeProjection");
        m.checkNotNullParameter(bVar, "constructor");
        m.checkNotNullParameter(gVar, "annotations");
        this.k = w0Var;
        this.l = bVar;
        this.m = z2;
        this.n = gVar;
    }
}
