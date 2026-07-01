package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.j.DescriptorRenderer2;
import d0.e0.p.d.m0.j.DescriptorRenderer4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.v, reason: use source file name */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinType6 extends KotlinType3 implements d0.e0.p.d.m0.n.n1.f {
    public final KotlinType4 k;
    public final KotlinType4 l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KotlinType6(KotlinType4 kotlinType4, KotlinType4 kotlinType5) {
        super(null);
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType5, "upperBound");
        this.k = kotlinType4;
        this.l = kotlinType5;
    }

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return getDelegate().getAnnotations();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    public abstract KotlinType4 getDelegate();

    public final KotlinType4 getLowerBound() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public MemberScope3 getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public final KotlinType4 getUpperBound() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public abstract String render(DescriptorRenderer2 descriptorRenderer2, DescriptorRenderer4 descriptorRenderer4);

    public String toString() {
        return DescriptorRenderer2.c.renderType(this);
    }
}
