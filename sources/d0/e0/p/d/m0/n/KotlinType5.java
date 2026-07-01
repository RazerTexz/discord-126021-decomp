package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.k.a0.MemberScope3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.k1, reason: use source file name */
/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class KotlinType5 extends KotlinType {
    public KotlinType5() {
        super(null);
    }

    public abstract KotlinType a();

    @Override // d0.e0.p.d.m0.c.g1.Annotations3
    public Annotations4 getAnnotations() {
        return a().getAnnotations();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public List<TypeProjection> getArguments() {
        return a().getArguments();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public TypeConstructor getConstructor() {
        return a().getConstructor();
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public MemberScope3 getMemberScope() {
        return a().getMemberScope();
    }

    public boolean isComputed() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return a().isMarkedNullable();
    }

    public String toString() {
        return isComputed() ? a().toString() : "<Not computed yet>";
    }

    @Override // d0.e0.p.d.m0.n.KotlinType
    public final KotlinType3 unwrap() {
        KotlinType kotlinTypeA = a();
        while (kotlinTypeA instanceof KotlinType5) {
            kotlinTypeA = ((KotlinType5) kotlinTypeA).a();
        }
        return (KotlinType3) kotlinTypeA;
    }
}
