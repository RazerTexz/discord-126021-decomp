package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.l0, reason: use source file name */
/* JADX INFO: compiled from: TypeWithEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeWithEnhancement3 extends SpecialTypes4 implements TypeWithEnhancement {
    public final KotlinType4 k;
    public final KotlinType l;

    public TypeWithEnhancement3(KotlinType4 kotlinType4, KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        Intrinsics3.checkNotNullParameter(kotlinType, "enhancement");
        this.k = kotlinType4;
        this.l = kotlinType;
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.TypeWithEnhancement
    public KotlinType getEnhancement() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.TypeWithEnhancement
    public KotlinType3 getOrigin() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return (KotlinType4) TypeWithEnhancement2.wrapEnhancement(getOrigin().makeNullableAsSpecified(z2), getEnhancement().unwrap().makeNullableAsSpecified(z2));
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return (KotlinType4) TypeWithEnhancement2.wrapEnhancement(getOrigin().replaceAnnotations(annotations4), getEnhancement());
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public TypeWithEnhancement3 replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new TypeWithEnhancement3(kotlinType4, getEnhancement());
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4, d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public TypeWithEnhancement3 refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new TypeWithEnhancement3((KotlinType4) kotlinTypeRefiner.refineType(this.k), kotlinTypeRefiner.refineType(getEnhancement()));
    }
}
