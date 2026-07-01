package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.i1.c0;
import d0.e0.p.d.m0.c.i1.d0;
import d0.e0.p.d.m0.c.n0;
import d0.e0.p.d.m0.c.p0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.v;
import d0.e0.p.d.m0.c.z;
import java.util.List;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends c0 implements b {
    public final d0.e0.p.d.m0.f.n J;
    public final d0.e0.p.d.m0.f.z.c K;
    public final d0.e0.p.d.m0.f.z.g L;
    public final d0.e0.p.d.m0.f.z.i M;
    public final f N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(d0.e0.p.d.m0.c.m mVar, n0 n0Var, d0.e0.p.d.m0.c.g1.g gVar, z zVar, u uVar, boolean z2, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.b$a b_a, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, d0.e0.p.d.m0.f.n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar2, d0.e0.p.d.m0.f.z.i iVar, f fVar) {
        super(mVar, n0Var, gVar, zVar, uVar, z2, eVar, b_a, u0.a, z3, z4, z7, false, z5, z6);
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(zVar, "modality");
        d0.z.d.m.checkNotNullParameter(uVar, "visibility");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(b_a, "kind");
        d0.z.d.m.checkNotNullParameter(nVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar2, "typeTable");
        d0.z.d.m.checkNotNullParameter(iVar, "versionRequirementTable");
        this.J = nVar;
        this.K = cVar;
        this.L = gVar2;
        this.M = iVar;
        this.N = fVar;
    }

    @Override // d0.e0.p.d.m0.c.i1.c0
    public c0 b(d0.e0.p.d.m0.c.m mVar, z zVar, u uVar, n0 n0Var, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.g.e eVar, u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(mVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(zVar, "newModality");
        d0.z.d.m.checkNotNullParameter(uVar, "newVisibility");
        d0.z.d.m.checkNotNullParameter(b_a, "kind");
        d0.z.d.m.checkNotNullParameter(eVar, "newName");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        return new j(mVar, n0Var, getAnnotations(), zVar, uVar, isVar(), eVar, b_a, isLateInit(), isConst(), isExternal(), isDelegated(), isExpect(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public f getContainerSource() {
        return this.N;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.c getNameResolver() {
        return this.K;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n getProto() {
        return getProto();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.g getTypeTable() {
        return this.L;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.i getVersionRequirementTable() {
        return this.M;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public List<d0.e0.p.d.m0.f.z.h> getVersionRequirements() {
        return b$a.getVersionRequirements(this);
    }

    public final void initialize(d0 d0Var, p0 p0Var, v vVar, v vVar2, g$a g_a) {
        d0.z.d.m.checkNotNullParameter(g_a, "isExperimentalCoroutineInReleaseEnvironment");
        super.initialize(d0Var, p0Var, vVar, vVar2);
    }

    @Override // d0.e0.p.d.m0.c.i1.c0, d0.e0.p.d.m0.c.y
    public boolean isExternal() {
        Boolean bool = d0.e0.p.d.m0.f.z.b.C.get(getProto().getFlags());
        d0.z.d.m.checkNotNullExpressionValue(bool, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return bool.booleanValue();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.n getProto() {
        return this.J;
    }
}
