package d0.e0.p.d.m0.k.u.a;

import b.d.b.a.outline;
import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.ClassifierDescriptor;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.TypeProjection;
import d0.e0.p.d.m0.n.Variance;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.n.l1.NewCapturedType2;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.u.a.c, reason: use source file name */
/* JADX INFO: compiled from: CapturedTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CapturedTypeConstructor3 implements CapturedTypeConstructor2 {
    public final TypeProjection a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public NewCapturedType2 f3470b;

    public CapturedTypeConstructor3(TypeProjection typeProjection) {
        Intrinsics3.checkNotNullParameter(typeProjection, "projection");
        this.a = typeProjection;
        getProjection().getProjectionKind();
        Variance variance = Variance.INVARIANT;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = getProjection().getType().getConstructor().getBuiltIns();
        Intrinsics3.checkNotNullExpressionValue(builtIns, "projection.type.constructor.builtIns");
        return builtIns;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public /* bridge */ /* synthetic */ ClassifierDescriptor getDeclarationDescriptor() {
        return (ClassifierDescriptor) m93getDeclarationDescriptor();
    }

    /* JADX INFO: renamed from: getDeclarationDescriptor, reason: collision with other method in class */
    public Void m93getDeclarationDescriptor() {
        return null;
    }

    public final NewCapturedType2 getNewTypeConstructor() {
        return this.f3470b;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public List<TypeParameterDescriptor> getParameters() {
        return Collections2.emptyList();
    }

    @Override // d0.e0.p.d.m0.k.u.a.CapturedTypeConstructor2
    public TypeProjection getProjection() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public Collection<KotlinType> getSupertypes() {
        KotlinType type = getProjection().getProjectionKind() == Variance.OUT_VARIANCE ? getProjection().getType() : getBuiltIns().getNullableAnyType();
        Intrinsics3.checkNotNullExpressionValue(type, "if (projection.projectionKind == Variance.OUT_VARIANCE)\n            projection.type\n        else\n            builtIns.nullableAnyType");
        return CollectionsJVM.listOf(type);
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public boolean isDenotable() {
        return false;
    }

    public final void setNewTypeConstructor(NewCapturedType2 newCapturedType2) {
        this.f3470b = newCapturedType2;
    }

    public String toString() {
        StringBuilder sbU = outline.U("CapturedTypeConstructor(");
        sbU.append(getProjection());
        sbU.append(')');
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.n.TypeConstructor
    public CapturedTypeConstructor3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        TypeProjection typeProjectionRefine = getProjection().refine(kotlinTypeRefiner);
        Intrinsics3.checkNotNullExpressionValue(typeProjectionRefine, "projection.refine(kotlinTypeRefiner)");
        return new CapturedTypeConstructor3(typeProjectionRefine);
    }
}
