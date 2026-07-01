package d0.e0.p.d.m0.n;

import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.c.g1.Annotations4;
import d0.e0.p.d.m0.n.l1.NewCapturedType;
import d0.e0.p.d.m0.n.l1.NewKotlinTypeChecker3;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.k, reason: use source file name */
/* JADX INFO: compiled from: SpecialTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SpecialTypes3 extends SpecialTypes4 implements TypeCapabilities, d0.e0.p.d.m0.n.n1.d {
    public static final a k = new a(null);
    public final KotlinType4 l;
    public final boolean m;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.n.k$a */
    /* JADX INFO: compiled from: SpecialTypes.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final SpecialTypes3 makeDefinitelyNotNull$descriptors(KotlinType3 kotlinType3, boolean z2) {
            Intrinsics3.checkNotNullParameter(kotlinType3, "type");
            if (kotlinType3 instanceof SpecialTypes3) {
                return (SpecialTypes3) kotlinType3;
            }
            kotlinType3.getConstructor();
            boolean zIsNullableType = false;
            if ((kotlinType3.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) || (kotlinType3 instanceof NewCapturedType)) {
                zIsNullableType = (z2 && (kotlinType3.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) ? TypeUtils.isNullableType(kotlinType3) : !NewKotlinTypeChecker3.a.isSubtypeOfAny(kotlinType3);
            }
            if (!zIsNullableType) {
                return null;
            }
            if (kotlinType3 instanceof KotlinType6) {
                KotlinType6 kotlinType6 = (KotlinType6) kotlinType3;
                Intrinsics3.areEqual(kotlinType6.getLowerBound().getConstructor(), kotlinType6.getUpperBound().getConstructor());
            }
            return new SpecialTypes3(flexibleTypes2.lowerIfFlexible(kotlinType3), z2, null);
        }
    }

    public SpecialTypes3(KotlinType4 kotlinType4, boolean z2) {
        this.l = kotlinType4;
        this.m = z2;
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public KotlinType4 getDelegate() {
        return this.l;
    }

    public final KotlinType4 getOriginal() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4, d0.e0.p.d.m0.n.KotlinType
    public boolean isMarkedNullable() {
        return false;
    }

    @Override // d0.e0.p.d.m0.n.TypeCapabilities
    public boolean isTypeVariable() {
        this.l.getConstructor();
        return this.l.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor;
    }

    @Override // d0.e0.p.d.m0.n.TypeCapabilities
    public KotlinType substitutionResult(KotlinType kotlinType) {
        Intrinsics3.checkNotNullParameter(kotlinType, "replacement");
        return SpecialTypes5.makeDefinitelyNotNullOrNotNull(kotlinType.unwrap(), this.m);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4
    public String toString() {
        return this.l + "!!";
    }

    @Override // d0.e0.p.d.m0.n.KotlinType3
    public KotlinType4 makeNullableAsSpecified(boolean z2) {
        return z2 ? this.l.makeNullableAsSpecified(z2) : this;
    }

    @Override // d0.e0.p.d.m0.n.SpecialTypes4
    public SpecialTypes3 replaceDelegate(KotlinType4 kotlinType4) {
        Intrinsics3.checkNotNullParameter(kotlinType4, "delegate");
        return new SpecialTypes3(kotlinType4, this.m);
    }

    @Override // d0.e0.p.d.m0.n.KotlinType4, d0.e0.p.d.m0.n.KotlinType3
    public SpecialTypes3 replaceAnnotations(Annotations4 annotations4) {
        Intrinsics3.checkNotNullParameter(annotations4, "newAnnotations");
        return new SpecialTypes3(this.l.replaceAnnotations(annotations4), this.m);
    }

    public SpecialTypes3(KotlinType4 kotlinType4, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this.l = kotlinType4;
        this.m = z2;
    }
}
