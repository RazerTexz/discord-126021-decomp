package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.j.DescriptorRenderer4;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.x, reason: use source file name */
/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeWithEnhancement4 extends KotlinType6 implements TypeWithEnhancement {
    public final KotlinType6 m;
    public final KotlinType n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TypeWithEnhancement4(KotlinType6 kotlinType6, KotlinType kotlinType) {
        super(kotlinType6.getLowerBound(), kotlinType6.getUpperBound());
        Intrinsics3.checkNotNullParameter(kotlinType6, "origin");
        Intrinsics3.checkNotNullParameter(kotlinType, "enhancement");
        this.m = kotlinType6;
        this.n = kotlinType;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6
    public KotlinType4 getDelegate() {
        return getOrigin().getDelegate();
    }

    @Override // d0.e0.p.d.m0.n.TypeWithEnhancement
    public KotlinType getEnhancement() {
        return this.n;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType3 makeNullableAsSpecified(boolean z2) {
        return TypeWithEnhancement2.wrapEnhancement(getOrigin().makeNullableAsSpecified(z2), getEnhancement().unwrap().makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6
    public String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
        Intrinsics3.checkNotNullParameter(descriptorRenderer4, "options");
        return descriptorRenderer4.getEnhancedTypes() ? descriptorRenderer2.renderType(getEnhancement()) : getOrigin().render(descriptorRenderer2, descriptorRenderer4);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType3 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return TypeWithEnhancement2.wrapEnhancement(getOrigin().replaceAnnotations(annotations4), getEnhancement());
    }

    @Override // d0.e0.p.d.m0.n.TypeWithEnhancement
    public KotlinType6 getOrigin() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public TypeWithEnhancement4 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new TypeWithEnhancement4((KotlinType6) kotlinTypeRefiner.refineType(getOrigin()), kotlinTypeRefiner.refineType(getEnhancement()));
    }
}
