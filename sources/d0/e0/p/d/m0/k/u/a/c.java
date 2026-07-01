package d0.e0.p.d.m0.k.u.a;

import d0.e0.p.d.m0.b.h;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j1;
import d0.e0.p.d.m0.n.l1.g;
import d0.e0.p.d.m0.n.l1.j;
import d0.e0.p.d.m0.n.u0;
import d0.e0.p.d.m0.n.w0;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements b {
    public final w0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f3470b;

    public c(w0 w0Var) {
        m.checkNotNullParameter(w0Var, "projection");
        this.a = w0Var;
        getProjection().getProjectionKind();
        j1 j1Var = j1.INVARIANT;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public h getBuiltIns() {
        h builtIns = getProjection().getType().getConstructor().getBuiltIns();
        m.checkNotNullExpressionValue(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.h getDeclarationDescriptor() {
        return (d0.e0.p.d.m0.c.h) m93getDeclarationDescriptor();
    }

    /* JADX INFO: renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public Void m93getDeclarationDescriptor() {
        return null;
    }

    public final j getNewTypeConstructor() {
        return this.f3470b;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public List<z0> getParameters() {
        return n.emptyList();
    }

    @Override // d0.e0.p.d.m0.k.u.a.b
    public w0 getProjection() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public Collection<c0> getSupertypes() {
        c0 type = getProjection().getProjectionKind() == j1.OUT_VARIANCE ? getProjection().getType() : getBuiltIns().getNullableAnyType();
        m.checkNotNullExpressionValue(type, "if (projection.projectionKind == Variance.OUT_VARIANCE)\n            projection.type\n        else\n            builtIns.nullableAnyType");
        return d0.t.m.listOf(type);
    }

    @Override // d0.e0.p.d.m0.n.u0
    public boolean isDenotable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.u0
    public /* bridge */ /* synthetic */ u0 refine(g gVar) {
        return refine(gVar);
    }

    public final void setNewTypeConstructor(j jVar) {
        this.f3470b = jVar;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CapturedTypeConstructor(");
        sbU.append(getProjection());
        sbU.append(')');
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.n.u0
    public c refine(g gVar) {
        m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        w0 w0VarRefine = getProjection().refine(gVar);
        m.checkNotNullExpressionValue(w0VarRefine, "projection.refine(kotlinTypeRefiner)");
        return new c(w0VarRefine);
    }
}
