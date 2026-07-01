package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.a$a;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.i1.g0;
import d0.e0.p.d.m0.c.i1.q;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.c.z;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends g0 implements b {
    public final d0.e0.p.d.m0.f.i M;
    public final d0.e0.p.d.m0.f.z.c N;
    public final d0.e0.p.d.m0.f.z.g O;
    public final d0.e0.p.d.m0.f.z.i P;
    public final f Q;
    public g$a R;

    public /* synthetic */ k(d0.e0.p.d.m0.c.m mVar, t0 t0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.f.i iVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar2, d0.e0.p.d.m0.f.z.i iVar2, f fVar, u0 u0Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(mVar, t0Var, gVar, eVar, b_a, iVar, cVar, gVar2, iVar2, fVar, (i & 1024) != 0 ? null : u0Var);
    }

    @Override // d0.e0.p.d.m0.c.i1.g0, d0.e0.p.d.m0.c.i1.q
    public q b(d0.e0.p.d.m0.c.m mVar, x xVar, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.g1.g gVar, u0 u0Var) {
        d0.e0.p.d.m0.g.e eVar2;
        d0.z.d.m.checkNotNullParameter(mVar, "newOwner");
        d0.z.d.m.checkNotNullParameter(b_a, "kind");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        t0 t0Var = (t0) xVar;
        if (eVar == null) {
            d0.e0.p.d.m0.g.e name = getName();
            d0.z.d.m.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            eVar2 = name;
        } else {
            eVar2 = eVar;
        }
        k kVar = new k(mVar, t0Var, gVar, eVar2, b_a, getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource(), u0Var);
        kVar.setHasStableParameterNames(hasStableParameterNames());
        kVar.R = getCoroutinesExperimentalCompatibilityMode();
        return kVar;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public f getContainerSource() {
        return this.Q;
    }

    public g$a getCoroutinesExperimentalCompatibilityMode() {
        return this.R;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.c getNameResolver() {
        return this.N;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n getProto() {
        return getProto();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.g getTypeTable() {
        return this.O;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.i getVersionRequirementTable() {
        return this.P;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public List<d0.e0.p.d.m0.f.z.h> getVersionRequirements() {
        return b$a.getVersionRequirements(this);
    }

    public final g0 initialize(q0 q0Var, q0 q0Var2, List<? extends z0> list, List<? extends c1> list2, c0 c0Var, z zVar, u uVar, Map<? extends a$a<?>, ?> map, g$a g_a) {
        d0.z.d.m.checkNotNullParameter(list, "typeParameters");
        d0.z.d.m.checkNotNullParameter(list2, "unsubstitutedValueParameters");
        d0.z.d.m.checkNotNullParameter(uVar, "visibility");
        d0.z.d.m.checkNotNullParameter(map, "userDataMap");
        d0.z.d.m.checkNotNullParameter(g_a, "isExperimentalCoroutineInReleaseEnvironment");
        g0 g0VarInitialize = super.initialize(q0Var, q0Var2, list, list2, c0Var, zVar, uVar, map);
        d0.z.d.m.checkNotNullExpressionValue(g0VarInitialize, "super.initialize(\n            extensionReceiverParameter,\n            dispatchReceiverParameter,\n            typeParameters,\n            unsubstitutedValueParameters,\n            unsubstitutedReturnType,\n            modality,\n            visibility,\n            userDataMap\n        )");
        this.R = g_a;
        return g0VarInitialize;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(d0.e0.p.d.m0.c.m mVar, t0 t0Var, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, d0.e0.p.d.m0.c.b$a b_a, d0.e0.p.d.m0.f.i iVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar2, d0.e0.p.d.m0.f.z.i iVar2, f fVar, u0 u0Var) {
        super(mVar, t0Var, gVar, eVar, b_a, u0Var == null ? u0.a : u0Var);
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(b_a, "kind");
        d0.z.d.m.checkNotNullParameter(iVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar2, "typeTable");
        d0.z.d.m.checkNotNullParameter(iVar2, "versionRequirementTable");
        this.M = iVar;
        this.N = cVar;
        this.O = gVar2;
        this.P = iVar2;
        this.Q = fVar;
        this.R = g$a.COMPATIBLE;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.i getProto() {
        return this.M;
    }
}
