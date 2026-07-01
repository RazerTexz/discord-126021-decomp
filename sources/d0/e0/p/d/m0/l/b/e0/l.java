package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.a1;
import d0.e0.p.d.m0.c.i1.i0;
import d0.e0.p.d.m0.c.u;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.k.a0.i$b;
import d0.e0.p.d.m0.m.o;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.c1;
import d0.e0.p.d.m0.n.e0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends d0.e0.p.d.m0.c.i1.e implements g {
    public j0 A;
    public g$a B;
    public final o q;
    public final r r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.z.c f3495s;
    public final d0.e0.p.d.m0.f.z.g t;
    public final d0.e0.p.d.m0.f.z.i u;
    public final f v;
    public Collection<? extends i0> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public j0 f3496x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public j0 f3497y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<? extends z0> f3498z;

    /* JADX WARN: Illegal instructions before constructor call */
    public l(o oVar, d0.e0.p.d.m0.c.m mVar, d0.e0.p.d.m0.c.g1.g gVar, d0.e0.p.d.m0.g.e eVar, u uVar, r rVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar2, d0.e0.p.d.m0.f.z.i iVar, f fVar) {
        d0.z.d.m.checkNotNullParameter(oVar, "storageManager");
        d0.z.d.m.checkNotNullParameter(mVar, "containingDeclaration");
        d0.z.d.m.checkNotNullParameter(gVar, "annotations");
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(uVar, "visibility");
        d0.z.d.m.checkNotNullParameter(rVar, "proto");
        d0.z.d.m.checkNotNullParameter(cVar, "nameResolver");
        d0.z.d.m.checkNotNullParameter(gVar2, "typeTable");
        d0.z.d.m.checkNotNullParameter(iVar, "versionRequirementTable");
        u0 u0Var = u0.a;
        d0.z.d.m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
        super(mVar, gVar, eVar, u0Var, uVar);
        this.q = oVar;
        this.r = rVar;
        this.f3495s = cVar;
        this.t = gVar2;
        this.u = iVar;
        this.v = fVar;
        this.B = g$a.COMPATIBLE;
    }

    @Override // d0.e0.p.d.m0.c.y0
    public d0.e0.p.d.m0.c.e getClassDescriptor() {
        if (e0.isError(getExpandedType())) {
            return null;
        }
        d0.e0.p.d.m0.c.h declarationDescriptor = getExpandedType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof d0.e0.p.d.m0.c.e) {
            return (d0.e0.p.d.m0.c.e) declarationDescriptor;
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public f getContainerSource() {
        return this.v;
    }

    public g$a getCoroutinesExperimentalCompatibilityMode() {
        return this.B;
    }

    @Override // d0.e0.p.d.m0.c.h
    public j0 getDefaultType() {
        j0 j0Var = this.A;
        if (j0Var != null) {
            return j0Var;
        }
        d0.z.d.m.throwUninitializedPropertyAccessException("defaultTypeImpl");
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.y0
    public j0 getExpandedType() {
        j0 j0Var = this.f3497y;
        if (j0Var != null) {
            return j0Var;
        }
        d0.z.d.m.throwUninitializedPropertyAccessException("expandedType");
        throw null;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.c getNameResolver() {
        return this.f3495s;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.i.n getProto() {
        return getProto();
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.g getTypeTable() {
        return this.t;
    }

    @Override // d0.e0.p.d.m0.c.y0
    public j0 getUnderlyingType() {
        j0 j0Var = this.f3496x;
        if (j0Var != null) {
            return j0Var;
        }
        d0.z.d.m.throwUninitializedPropertyAccessException("underlyingType");
        throw null;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public d0.e0.p.d.m0.f.z.i getVersionRequirementTable() {
        return this.u;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public List<d0.e0.p.d.m0.f.z.h> getVersionRequirements() {
        return g$b.getVersionRequirements(this);
    }

    public final void initialize(List<? extends z0> list, j0 j0Var, j0 j0Var2, g$a g_a) {
        d0.z.d.m.checkNotNullParameter(list, "declaredTypeParameters");
        d0.z.d.m.checkNotNullParameter(j0Var, "underlyingType");
        d0.z.d.m.checkNotNullParameter(j0Var2, "expandedType");
        d0.z.d.m.checkNotNullParameter(g_a, "isExperimentalCoroutineInReleaseEnvironment");
        initialize(list);
        this.f3496x = j0Var;
        this.f3497y = j0Var2;
        this.f3498z = a1.computeConstructorTypeParameters(this);
        d0.e0.p.d.m0.c.e classDescriptor = getClassDescriptor();
        d0.e0.p.d.m0.k.a0.i unsubstitutedMemberScope = classDescriptor == null ? null : classDescriptor.getUnsubstitutedMemberScope();
        if (unsubstitutedMemberScope == null) {
            unsubstitutedMemberScope = i$b.f3461b;
        }
        j0 j0VarMakeUnsubstitutedType = e1.makeUnsubstitutedType(this, unsubstitutedMemberScope, new d0.e0.p.d.m0.c.i1.d(this));
        d0.z.d.m.checkNotNullExpressionValue(j0VarMakeUnsubstitutedType, "@OptIn(TypeRefinement::class)\n    protected fun computeDefaultType(): SimpleType =\n        TypeUtils.makeUnsubstitutedType(this, classDescriptor?.unsubstitutedMemberScope ?: MemberScope.Empty) { kotlinTypeRefiner ->\n            kotlinTypeRefiner.refineDescriptor(this)?.defaultType\n        }");
        this.A = j0VarMakeUnsubstitutedType;
        this.w = getTypeAliasConstructors();
        this.B = g_a;
    }

    @Override // d0.e0.p.d.m0.c.w0
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.n substitute(c1 c1Var) {
        return substitute(c1Var);
    }

    @Override // d0.e0.p.d.m0.l.b.e0.g
    public r getProto() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.w0
    public y0 substitute(c1 c1Var) {
        d0.z.d.m.checkNotNullParameter(c1Var, "substitutor");
        if (c1Var.isEmpty()) {
            return this;
        }
        o oVar = this.q;
        d0.e0.p.d.m0.c.m containingDeclaration = getContainingDeclaration();
        d0.z.d.m.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        d0.e0.p.d.m0.c.g1.g annotations = getAnnotations();
        d0.z.d.m.checkNotNullExpressionValue(annotations, "annotations");
        d0.e0.p.d.m0.g.e name = getName();
        d0.z.d.m.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        l lVar = new l(oVar, containingDeclaration, annotations, name, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        List<z0> declaredTypeParameters = getDeclaredTypeParameters();
        j0 underlyingType = getUnderlyingType();
        j1 j1Var = j1.INVARIANT;
        c0 c0VarSafeSubstitute = c1Var.safeSubstitute(underlyingType, j1Var);
        d0.z.d.m.checkNotNullExpressionValue(c0VarSafeSubstitute, "substitutor.safeSubstitute(underlyingType, Variance.INVARIANT)");
        j0 j0VarAsSimpleType = d0.e0.p.d.m0.n.a1.asSimpleType(c0VarSafeSubstitute);
        c0 c0VarSafeSubstitute2 = c1Var.safeSubstitute(getExpandedType(), j1Var);
        d0.z.d.m.checkNotNullExpressionValue(c0VarSafeSubstitute2, "substitutor.safeSubstitute(expandedType, Variance.INVARIANT)");
        lVar.initialize(declaredTypeParameters, j0VarAsSimpleType, d0.e0.p.d.m0.n.a1.asSimpleType(c0VarSafeSubstitute2), getCoroutinesExperimentalCompatibilityMode());
        return lVar;
    }
}
