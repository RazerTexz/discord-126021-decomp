package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Collection;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11466u;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11320a1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11369e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11367d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.InterfaceC11378i0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11693r;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11709h;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11710i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11908a1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11919e0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11920e1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.l */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11867l extends AbstractC11369e implements InterfaceC11862g {

    /* JADX INFO: renamed from: A */
    public AbstractC11934j0 f24610A;

    /* JADX INFO: renamed from: B */
    public InterfaceC11862g.a f24611B;

    /* JADX INFO: renamed from: q */
    public final InterfaceC11905o f24612q;

    /* JADX INFO: renamed from: r */
    public final C11693r f24613r;

    /* JADX INFO: renamed from: s */
    public final InterfaceC11704c f24614s;

    /* JADX INFO: renamed from: t */
    public final C11708g f24615t;

    /* JADX INFO: renamed from: u */
    public final C11710i f24616u;

    /* JADX INFO: renamed from: v */
    public final InterfaceC11861f f24617v;

    /* JADX INFO: renamed from: w */
    public Collection<? extends InterfaceC11378i0> f24618w;

    /* JADX INFO: renamed from: x */
    public AbstractC11934j0 f24619x;

    /* JADX INFO: renamed from: y */
    public AbstractC11934j0 f24620y;

    /* JADX INFO: renamed from: z */
    public List<? extends InterfaceC11477z0> f24621z;

    /* JADX WARN: Illegal instructions before constructor call */
    public C11867l(InterfaceC11905o interfaceC11905o, InterfaceC11450m interfaceC11450m, InterfaceC11344g interfaceC11344g, C11716e c11716e, AbstractC11466u abstractC11466u, C11693r c11693r, InterfaceC11704c interfaceC11704c, C11708g c11708g, C11710i c11710i, InterfaceC11861f interfaceC11861f) {
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11450m, "containingDeclaration");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(abstractC11466u, "visibility");
        C12238m.checkNotNullParameter(c11693r, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        C12238m.checkNotNullParameter(c11710i, "versionRequirementTable");
        InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
        C12238m.checkNotNullExpressionValue(interfaceC11467u0, "NO_SOURCE");
        super(interfaceC11450m, interfaceC11344g, c11716e, interfaceC11467u0, abstractC11466u);
        this.f24612q = interfaceC11905o;
        this.f24613r = c11693r;
        this.f24614s = interfaceC11704c;
        this.f24615t = c11708g;
        this.f24616u = c11710i;
        this.f24617v = interfaceC11861f;
        this.f24611B = InterfaceC11862g.a.COMPATIBLE;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0
    public InterfaceC11330e getClassDescriptor() {
        if (C11919e0.isError(getExpandedType())) {
            return null;
        }
        InterfaceC11352h declarationDescriptor = getExpandedType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof InterfaceC11330e) {
            return (InterfaceC11330e) declarationDescriptor;
        }
        return null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public InterfaceC11861f getContainerSource() {
        return this.f24617v;
    }

    public InterfaceC11862g.a getCoroutinesExperimentalCompatibilityMode() {
        return this.f24611B;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h
    public AbstractC11934j0 getDefaultType() {
        AbstractC11934j0 abstractC11934j0 = this.f24610A;
        if (abstractC11934j0 != null) {
            return abstractC11934j0;
        }
        C12238m.throwUninitializedPropertyAccessException("defaultTypeImpl");
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0
    public AbstractC11934j0 getExpandedType() {
        AbstractC11934j0 abstractC11934j0 = this.f24620y;
        if (abstractC11934j0 != null) {
            return abstractC11934j0;
        }
        C12238m.throwUninitializedPropertyAccessException("expandedType");
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public InterfaceC11704c getNameResolver() {
        return this.f24614s;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11708g getTypeTable() {
        return this.f24615t;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11475y0
    public AbstractC11934j0 getUnderlyingType() {
        AbstractC11934j0 abstractC11934j0 = this.f24619x;
        if (abstractC11934j0 != null) {
            return abstractC11934j0;
        }
        C12238m.throwUninitializedPropertyAccessException("underlyingType");
        throw null;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11710i getVersionRequirementTable() {
        return this.f24616u;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public List<C11709h> getVersionRequirements() {
        return InterfaceC11862g.b.getVersionRequirements(this);
    }

    public final void initialize(List<? extends InterfaceC11477z0> list, AbstractC11934j0 abstractC11934j0, AbstractC11934j0 abstractC11934j1, InterfaceC11862g.a aVar) {
        C12238m.checkNotNullParameter(list, "declaredTypeParameters");
        C12238m.checkNotNullParameter(abstractC11934j0, "underlyingType");
        C12238m.checkNotNullParameter(abstractC11934j1, "expandedType");
        C12238m.checkNotNullParameter(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        initialize(list);
        this.f24619x = abstractC11934j0;
        this.f24620y = abstractC11934j1;
        this.f24621z = C11320a1.computeConstructorTypeParameters(this);
        InterfaceC11330e classDescriptor = getClassDescriptor();
        InterfaceC11770i unsubstitutedMemberScope = classDescriptor == null ? null : classDescriptor.getUnsubstitutedMemberScope();
        if (unsubstitutedMemberScope == null) {
            unsubstitutedMemberScope = InterfaceC11770i.b.f24373b;
        }
        AbstractC11934j0 abstractC11934j0MakeUnsubstitutedType = C11920e1.makeUnsubstitutedType(this, unsubstitutedMemberScope, new C11367d(this));
        C12238m.checkNotNullExpressionValue(abstractC11934j0MakeUnsubstitutedType, "@OptIn(TypeRefinement::class)\n    protected fun computeDefaultType(): SimpleType =\n        TypeUtils.makeUnsubstitutedType(this, classDescriptor?.unsubstitutedMemberScope ?: MemberScope.Empty) { kotlinTypeRefiner ->\n            kotlinTypeRefiner.refineDescriptor(this)?.defaultType\n        }");
        this.f24610A = abstractC11934j0MakeUnsubstitutedType;
        this.f24618w = getTypeAliasConstructors();
        this.f24611B = aVar;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.InterfaceC11862g
    public C11693r getProto() {
        return this.f24613r;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11471w0
    public InterfaceC11475y0 substitute(C11914c1 c11914c1) {
        C12238m.checkNotNullParameter(c11914c1, "substitutor");
        if (c11914c1.isEmpty()) {
            return this;
        }
        InterfaceC11905o interfaceC11905o = this.f24612q;
        InterfaceC11450m containingDeclaration = getContainingDeclaration();
        C12238m.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        InterfaceC11344g annotations = getAnnotations();
        C12238m.checkNotNullExpressionValue(annotations, "annotations");
        C11716e name = getName();
        C12238m.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C11867l c11867l = new C11867l(interfaceC11905o, containingDeclaration, annotations, name, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        List<InterfaceC11477z0> declaredTypeParameters = getDeclaredTypeParameters();
        AbstractC11934j0 underlyingType = getUnderlyingType();
        EnumC11935j1 enumC11935j1 = EnumC11935j1.INVARIANT;
        AbstractC11913c0 abstractC11913c0SafeSubstitute = c11914c1.safeSubstitute(underlyingType, enumC11935j1);
        C12238m.checkNotNullExpressionValue(abstractC11913c0SafeSubstitute, "substitutor.safeSubstitute(underlyingType, Variance.INVARIANT)");
        AbstractC11934j0 abstractC11934j0AsSimpleType = C11908a1.asSimpleType(abstractC11913c0SafeSubstitute);
        AbstractC11913c0 abstractC11913c0SafeSubstitute2 = c11914c1.safeSubstitute(getExpandedType(), enumC11935j1);
        C12238m.checkNotNullExpressionValue(abstractC11913c0SafeSubstitute2, "substitutor.safeSubstitute(expandedType, Variance.INVARIANT)");
        c11867l.initialize(declaredTypeParameters, abstractC11934j0AsSimpleType, C11908a1.asSimpleType(abstractC11913c0SafeSubstitute2), getCoroutinesExperimentalCompatibilityMode());
        return c11867l;
    }
}
