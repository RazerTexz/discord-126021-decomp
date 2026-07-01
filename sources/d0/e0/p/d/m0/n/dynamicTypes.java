package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.b.KotlinBuiltIns;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.j.DescriptorRenderer4;
import d0.e0.p.d.m0.n.l1.KotlinTypeRefiner;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.q, reason: use source file name */
/* JADX INFO: compiled from: dynamicTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class dynamicTypes extends KotlinType6 implements d0.e0.p.d.m0.n.n1.e {
    public final Annotations4 m;

    /* JADX WARN: Illegal instructions before constructor call */
    public dynamicTypes(KotlinBuiltIns kotlinBuiltIns, Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics3.checkNotNullParameter(annotations4, "annotations");
        KotlinType4 nothingType = kotlinBuiltIns.getNothingType();
        Intrinsics3.checkNotNullExpressionValue(nothingType, "builtIns.nothingType");
        KotlinType4 nullableAnyType = kotlinBuiltIns.getNullableAnyType();
        Intrinsics3.checkNotNullExpressionValue(nullableAnyType, "builtIns.nullableAnyType");
        super(nothingType, nullableAnyType);
        this.m = annotations4;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6, d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return this.m;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6
    public KotlinType4 getDelegate() {
        return getUpperBound();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6, d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public dynamicTypes makeNullableAsSpecified(boolean z2) {
        return this;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3, d0.e0.p.d.m0.n.KotlinType
    public dynamicTypes refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics3.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType6
    public String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4) {
        Intrinsics3.checkNotNullParameter(descriptorRenderer2, "renderer");
        Intrinsics3.checkNotNullParameter(descriptorRenderer4, "options");
        return "dynamic";
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public dynamicTypes replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new dynamicTypes(TypeUtils2.getBuiltIns(getDelegate()), annotations4);
    }
}
