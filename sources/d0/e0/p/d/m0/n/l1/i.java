package d0.e0.p.d.m0.n.l1;

import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.i1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: NewCapturedType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends j0 implements d0.e0.p.d.m0.n.n1.c {
    public final d0.e0.p.d.m0.n.n1.b k;
    public final j l;
    public final i1 m;
    public final d0.e0.p.d.m0.c.g1.g n;
    public final boolean o;
    public final boolean p;

    public /* synthetic */ i(d0.e0.p.d.m0.n.n1.b bVar, j jVar, i1 i1Var, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, jVar, i1Var, (i & 8) != 0 ? d0.e0.p.d.m0.c.g1.g.f.getEMPTY() : gVar, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? false : z3);
    }

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public List<w0> getArguments() {
        return d0.t.n.emptyList();
    }

    public final d0.e0.p.d.m0.n.n1.b getCaptureStatus() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ u0 getConstructor() {
        return getConstructor();
    }

    public final i1 getLowerType() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public d0.e0.p.d.m0.k.a0.i getMemberScope() {
        d0.e0.p.d.m0.k.a0.i iVarCreateErrorScope = d0.e0.p.d.m0.n.t.createErrorScope("No member resolution should be done on captured type!", true);
        d0.z.d.m.checkNotNullExpressionValue(iVarCreateErrorScope, "createErrorScope(\"No member resolution should be done on captured type!\", true)");
        return iVarCreateErrorScope;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return this.o;
    }

    public final boolean isProjectionNotNull() {
        return this.p;
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ j0 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ c0 refine(g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ j0 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    @Override // d0.e0.p.d.m0.n.c0
    public j getConstructor() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 makeNullableAsSpecified(boolean z2) {
        return makeNullableAsSpecified(z2);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public /* bridge */ /* synthetic */ i1 refine(g gVar) {
        return refine(gVar);
    }

    @Override // d0.e0.p.d.m0.n.i1
    public /* bridge */ /* synthetic */ i1 replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        return replaceAnnotations(gVar);
    }

    public i(d0.e0.p.d.m0.n.n1.b bVar, j jVar, i1 i1Var, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, boolean z3) {
        d0.z.d.m.checkNotNullParameter(bVar, "captureStatus");
        d0.z.d.m.checkNotNullParameter(jVar, "constructor");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        this.k = bVar;
        this.l = jVar;
        this.m = i1Var;
        this.n = gVar;
        this.o = z2;
        this.p = z3;
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public i makeNullableAsSpecified(boolean z2) {
        return new i(this.k, getConstructor(), this.m, getAnnotations(), z2, false, 32, null);
    }

    @Override // d0.e0.p.d.m0.n.i1, d0.e0.p.d.m0.n.c0
    public i refine(g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        d0.e0.p.d.m0.n.n1.b bVar = this.k;
        j jVarRefine = getConstructor().refine(gVar);
        i1 i1Var = this.m;
        return new i(bVar, jVarRefine, i1Var == null ? null : gVar.refineType(i1Var).unwrap(), getAnnotations(), isMarkedNullable(), false, 32, null);
    }

    @Override // d0.e0.p.d.m0.n.j0, d0.e0.p.d.m0.n.i1
    public i replaceAnnotations(d0.e0.p.d.m0.c.g1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "newAnnotations");
        return new i(this.k, getConstructor(), this.m, gVar, isMarkedNullable(), false, 32, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public i(d0.e0.p.d.m0.n.n1.b bVar, i1 i1Var, w0 w0Var, z0 z0Var) {
        this(bVar, new j(w0Var, null, null, z0Var, 6, null), i1Var, null, false, false, 56, null);
        d0.z.d.m.checkNotNullParameter(bVar, "captureStatus");
        d0.z.d.m.checkNotNullParameter(w0Var, "projection");
        d0.z.d.m.checkNotNullParameter(z0Var, "typeParameter");
    }
}
