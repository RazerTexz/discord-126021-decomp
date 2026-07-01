package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.DeclarationDescriptor;
import d0.e0.p.d.m0.c.DescriptorVisibility2;
import d0.e0.p.d.m0.c.SourceElement;
import d0.e0.p.d.m0.c.TypeAliasDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.c.i1.AbstractTypeAliasDescriptor;
import d0.e0.p.d.m0.c.i1.AbstractTypeAliasDescriptor2;
import d0.e0.p.d.m0.c.i1.TypeAliasConstructorDescriptor;
import d0.e0.p.d.m0.c.typeParameterUtils;
import d0.e0.p.d.m0.f.r;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.VersionRequirement;
import d0.e0.p.d.m0.f.z.VersionRequirement2;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3;
import d0.e0.p.d.m0.m.StorageManager;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType2;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.TypeSubstitution;
import d0.e0.p.d.m0.n.TypeSubstitutor2;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.Variance;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.l, reason: use source file name */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DeserializedMemberDescriptor6 extends AbstractTypeAliasDescriptor2 implements DeserializedMemberDescriptor3 {
    public KotlinType4 A;
    public DeserializedMemberDescriptor3.a B;
    public final StorageManager q;
    public final r r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final NameResolver f3495s;
    public final TypeTable t;
    public final VersionRequirement2 u;
    public final DeserializedContainerSource2 v;
    public Collection<? extends TypeAliasConstructorDescriptor> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public KotlinType4 f3496x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public KotlinType4 f3497y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public List<? extends TypeParameterDescriptor> f3498z;

    /* JADX WARN: Illegal instructions before constructor call */
    public DeserializedMemberDescriptor6(StorageManager storageManager, DeclarationDescriptor declarationDescriptor, Annotations4 annotations4, Name name, DescriptorVisibility2 descriptorVisibility2, r rVar, NameResolver nameResolver, TypeTable typeTable, VersionRequirement2 versionRequirement2, DeserializedContainerSource2 deserializedContainerSource2) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(declarationDescriptor, "containingDeclaration");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(descriptorVisibility2, "visibility");
        Intrinsics3.checkNotNullParameter(rVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        Intrinsics3.checkNotNullParameter(versionRequirement2, "versionRequirementTable");
        SourceElement sourceElement = SourceElement.a;
        Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        super(declarationDescriptor, annotations4, name, sourceElement, descriptorVisibility2);
        this.q = storageManager;
        this.r = rVar;
        this.f3495s = nameResolver;
        this.t = typeTable;
        this.u = versionRequirement2;
        this.v = deserializedContainerSource2;
        this.B = DeserializedMemberDescriptor3.a.COMPATIBLE;
    }

    @Override // d0.e0.p.d.m0.c.TypeAliasDescriptor
    public ClassDescriptor getClassDescriptor() {
        if (KotlinType2.isError(getExpandedType())) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = getExpandedType().getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor instanceof ClassDescriptor) {
            return (ClassDescriptor) declarationDescriptor;
        }
        return null;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public DeserializedContainerSource2 getContainerSource() {
        return this.v;
    }

    public DeserializedMemberDescriptor3.a getCoroutinesExperimentalCompatibilityMode() {
        return this.B;
    }

    @Override // d0.e0.p.d.m0.c.ClassifierDescriptor
    public KotlinType4 getDefaultType() {
        KotlinType4 kotlinType4 = this.A;
        if (kotlinType4 != null) {
            return kotlinType4;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("defaultTypeImpl");
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.TypeAliasDescriptor
    public KotlinType4 getExpandedType() {
        KotlinType4 kotlinType4 = this.f3497y;
        if (kotlinType4 != null) {
            return kotlinType4;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("expandedType");
        throw null;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public NameResolver getNameResolver() {
        return this.f3495s;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public TypeTable getTypeTable() {
        return this.t;
    }

    @Override // d0.e0.p.d.m0.c.TypeAliasDescriptor
    public KotlinType4 getUnderlyingType() {
        KotlinType4 kotlinType4 = this.f3496x;
        if (kotlinType4 != null) {
            return kotlinType4;
        }
        Intrinsics3.throwUninitializedPropertyAccessException("underlyingType");
        throw null;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public VersionRequirement2 getVersionRequirementTable() {
        return this.u;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public List<VersionRequirement> getVersionRequirements() {
        return DeserializedMemberDescriptor3.b.getVersionRequirements(this);
    }

    public final void initialize(List<? extends TypeParameterDescriptor> list, KotlinType4 kotlinType4, KotlinType4 kotlinType5, DeserializedMemberDescriptor3.a aVar) {
        Intrinsics3.checkNotNullParameter(list, "declaredTypeParameters");
        Intrinsics3.checkNotNullParameter(kotlinType4, "underlyingType");
        Intrinsics3.checkNotNullParameter(kotlinType5, "expandedType");
        Intrinsics3.checkNotNullParameter(aVar, "isExperimentalCoroutineInReleaseEnvironment");
        initialize(list);
        this.f3496x = kotlinType4;
        this.f3497y = kotlinType5;
        this.f3498z = typeParameterUtils.computeConstructorTypeParameters(this);
        ClassDescriptor classDescriptor = getClassDescriptor();
        MemberScope3 unsubstitutedMemberScope = classDescriptor == null ? null : classDescriptor.getUnsubstitutedMemberScope();
        if (unsubstitutedMemberScope == null) {
            unsubstitutedMemberScope = MemberScope3.b.f3461b;
        }
        KotlinType4 kotlinType4MakeUnsubstitutedType = TypeUtils.makeUnsubstitutedType(this, unsubstitutedMemberScope, new AbstractTypeAliasDescriptor(this));
        Intrinsics3.checkNotNullExpressionValue(kotlinType4MakeUnsubstitutedType, "@OptIn(TypeRefinement::class)\n    protected fun computeDefaultType(): SimpleType =\n        TypeUtils.makeUnsubstitutedType(this, classDescriptor?.unsubstitutedMemberScope ?: MemberScope.Empty) { kotlinTypeRefiner ->\n            kotlinTypeRefiner.refineDescriptor(this)?.defaultType\n        }");
        this.A = kotlinType4MakeUnsubstitutedType;
        this.w = getTypeAliasConstructors();
        this.B = aVar;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedMemberDescriptor3
    public r getProto() {
        return this.r;
    }

    @Override // d0.e0.p.d.m0.c.Substitutable
    public TypeAliasDescriptor substitute(TypeSubstitutor2 typeSubstitutor2) {
        Intrinsics3.checkNotNullParameter(typeSubstitutor2, "substitutor");
        if (typeSubstitutor2.isEmpty()) {
            return this;
        }
        StorageManager storageManager = this.q;
        DeclarationDescriptor containingDeclaration = getContainingDeclaration();
        Intrinsics3.checkNotNullExpressionValue(containingDeclaration, "containingDeclaration");
        Annotations4 annotations = getAnnotations();
        Intrinsics3.checkNotNullExpressionValue(annotations, "annotations");
        Name name = getName();
        Intrinsics3.checkNotNullExpressionValue(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        DeserializedMemberDescriptor6 deserializedMemberDescriptor6 = new DeserializedMemberDescriptor6(storageManager, containingDeclaration, annotations, name, getVisibility(), getProto(), getNameResolver(), getTypeTable(), getVersionRequirementTable(), getContainerSource());
        List<TypeParameterDescriptor> declaredTypeParameters = getDeclaredTypeParameters();
        KotlinType4 underlyingType = getUnderlyingType();
        Variance variance = Variance.INVARIANT;
        KotlinType kotlinTypeSafeSubstitute = typeSubstitutor2.safeSubstitute(underlyingType, variance);
        Intrinsics3.checkNotNullExpressionValue(kotlinTypeSafeSubstitute, "substitutor.safeSubstitute(underlyingType, Variance.INVARIANT)");
        KotlinType4 kotlinType4AsSimpleType = TypeSubstitution.asSimpleType(kotlinTypeSafeSubstitute);
        KotlinType kotlinTypeSafeSubstitute2 = typeSubstitutor2.safeSubstitute(getExpandedType(), variance);
        Intrinsics3.checkNotNullExpressionValue(kotlinTypeSafeSubstitute2, "substitutor.safeSubstitute(expandedType, Variance.INVARIANT)");
        deserializedMemberDescriptor6.initialize(declaredTypeParameters, kotlinType4AsSimpleType, TypeSubstitution.asSimpleType(kotlinTypeSafeSubstitute2), getCoroutinesExperimentalCompatibilityMode());
        return deserializedMemberDescriptor6;
    }
}
