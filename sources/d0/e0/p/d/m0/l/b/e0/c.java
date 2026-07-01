package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.i1.q;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends d0.e0.p.d.m0.c.i1.g implements b {
    public final d0.e0.p.d.m0.f.d O;
    public final d0.e0.p.d.m0.f.z.c P;
    public final d0.e0.p.d.m0.f.z.g Q;
    public final d0.e0.p.d.m0.f.z.i R;
    public final f S;
    public g$a T;

    public /* synthetic */ c(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.c.l lVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.f.d dVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar2, d0.e0.p.d.m0.f.z.i iVar, f fVar, u0 u0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(eVar, lVar, gVar, z2, b_a, dVar, cVar, gVar2, iVar, fVar, (i & 1024) != 0 ? null : u0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.g, d0.e0.p.d.m0.c.i1.q
    public /* bridge */ /* synthetic */ q b(d0.e0.p.d.m0.c.m mVar, x xVar, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        return f(mVar, xVar, b_a, gVar, u0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.g
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.i1.g e(d0.e0.p.d.m0.c.m mVar, x xVar, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        return f(mVar, xVar, b_a, gVar, u0Var);
    }

    public c f(d0.e0.p.d.m0.c.m mVar, x xVar, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(mVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(b_a, "kind");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        c cVar = new c((d0.e0.p.d.m0.c.e) mVar, (d0.e0.p.d.m0.c.l) xVar, gVar, this.N, b_a, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), u0Var);
        cVar.setHasStableParameterNames(hasStableParameterNames());
        cVar.setCoroutinesExperimentalCompatibilityMode$deserialization(getCoroutinesExperimentalCompatibilityMode());
        return cVar;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public f getContainerSource() {
        return this.S;
    }

    public g$a getCoroutinesExperimentalCompatibilityMode() {
        return this.T;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.c getNameResolver() {
        return this.P;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n getProto() {
        return getProto();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.g getTypeTable() {
        return this.Q;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.i getVersionRequirementTable() {
        return this.R;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public List<d0.e0.p.d.m0.f.z.h> getVersionRequirements() {
        return b$a.getVersionRequirements(this);
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x
    public boolean isInline() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x
    public boolean isSuspend() {
        return false;
    }

    @Override // d0.e0.p.d.m0.c.i1.q, d0.e0.p.d.m0.c.x
    public boolean isTailrec() {
        return false;
    }

    public void setCoroutinesExperimentalCompatibilityMode$deserialization(g$a g_a) {
        d0.z.d.m.checkNotNullParameter(g_a, "<set-?>");
        this.T = g_a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(d0.e0.p.d.m0.c.e eVar, d0.e0.p.d.m0.c.l lVar, d0.e0.p.d.m0.c.g1.g gVar, boolean z2, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.f.d dVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar2, d0.e0.p.d.m0.f.z.i iVar, f fVar, u0 u0Var) {
        super(eVar, lVar, gVar, z2, b_a, u0Var == null ? u0.a : u0Var);
        d0.z.d.m.checkNotNullParameter(eVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(b_a, "kind");
        d0.z.d.m.checkNotNullParameter(dVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar2, "typeTable");
        d0.z.d.m.checkNotNullParameter(iVar, "versionRequirementTable");
        this.O = dVar;
        this.P = cVar;
        this.Q = gVar2;
        this.R = iVar;
        this.S = fVar;
        this.T = g$a.COMPATIBLE;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.d getProto() {
        return this.O;
    }
}
