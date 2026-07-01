package d0.e0.p.d.m0.e.a.l0;

import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType3;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.e0.p.d.m0.n.KotlinType6;
import d0.e0.p.d.m0.n.KotlinTypeFactory;
import d0.e0.p.d.m0.n.SpecialTypes4;
import d0.e0.p.d.m0.n.TypeCapabilities;
import d0.e0.p.d.m0.n.TypeUtils;
import d0.e0.p.d.m0.n.TypeWithEnhancement2;
import d0.e0.p.d.m0.n.o1.TypeUtils2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.g, reason: use source file name */
/* JADX INFO: compiled from: typeEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class typeEnhancement5 extends SpecialTypes4 implements TypeCapabilities {
    public final KotlinType4 k;

    public typeEnhancement5(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        this.k = kotlinType4;
    }

    public final KotlinType4 a(KotlinType4 kotlinType4) {
        KotlinType4 kotlinType4MakeNullableAsSpecified = kotlinType4.makeNullableAsSpecified(false);
        return !TypeUtils2.isTypeParameter(kotlinType4) ? kotlinType4MakeNullableAsSpecified : new typeEnhancement5(kotlinType4MakeNullableAsSpecified);
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.k;
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4, d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.TypeCapabilities
    public boolean isTypeVariable() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return z2 ? this.k.makeNullableAsSpecified(true) : this;
    }

    @Override // d0.e0.p.d.m0.n.TypeCapabilities
    public KotlinType substitutionResult(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "replacement");
        KotlinType3 kotlinType3Unwrap = kotlinType.unwrap();
        if (!TypeUtils2.isTypeParameter(kotlinType3Unwrap) && !TypeUtils.isNullableType(kotlinType3Unwrap)) {
            return kotlinType3Unwrap;
        }
        if (kotlinType3Unwrap instanceof KotlinType4) {
            return a((KotlinType4) kotlinType3Unwrap);
        }
        if (!(kotlinType3Unwrap instanceof KotlinType6)) {
            throw new IllegalStateException(Intrinsics3.stringPlus("Incorrect type: ", kotlinType3Unwrap).toString());
        }
        KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
        KotlinType6 kotlinType6 = (KotlinType6) kotlinType3Unwrap;
        return TypeWithEnhancement2.wrapEnhancement(KotlinTypeFactory.flexibleType(a(kotlinType6.getLowerBound()), a(kotlinType6.getUpperBound())), TypeWithEnhancement2.getEnhancement(kotlinType3Unwrap));
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public typeEnhancement5 replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new typeEnhancement5(kotlinType4);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public typeEnhancement5 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new typeEnhancement5(this.k.replaceAnnotations(annotations4));
    }
}
