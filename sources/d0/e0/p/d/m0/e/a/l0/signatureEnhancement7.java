package d0.e0.p.d.m0.e.a.l0;

import b.d.b.a.outline;
import d0.e0.p.d.m0.c.TypeParameterDescriptor;
import d0.e0.p.d.m0.e.a.AnnotationQualifiersFqNames2;
import d0.e0.p.d.m0.n.KotlinType;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.s, reason: use source file name */
/* JADX INFO: compiled from: signatureEnhancement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class signatureEnhancement7 {
    public final KotlinType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnnotationQualifiersFqNames2 f3353b;
    public final TypeParameterDescriptor c;
    public final boolean d;

    public signatureEnhancement7(KotlinType kotlinType, AnnotationQualifiersFqNames2 annotationQualifiersFqNames2, TypeParameterDescriptor typeParameterDescriptor, boolean z2) {
        Intrinsics3.checkNotNullParameter(kotlinType, "type");
        this.a = kotlinType;
        this.f3353b = annotationQualifiersFqNames2;
        this.c = typeParameterDescriptor;
        this.d = z2;
    }

    public final KotlinType component1() {
        return this.a;
    }

    public final AnnotationQualifiersFqNames2 component2() {
        return this.f3353b;
    }

    public final TypeParameterDescriptor component3() {
        return this.c;
    }

    public final boolean component4() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof signatureEnhancement7)) {
            return false;
        }
        signatureEnhancement7 signatureenhancement7 = (signatureEnhancement7) obj;
        return Intrinsics3.areEqual(this.a, signatureenhancement7.a) && Intrinsics3.areEqual(this.f3353b, signatureenhancement7.f3353b) && Intrinsics3.areEqual(this.c, signatureenhancement7.c) && this.d == signatureenhancement7.d;
    }

    public final KotlinType getType() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        AnnotationQualifiersFqNames2 annotationQualifiersFqNames2 = this.f3353b;
        int iHashCode2 = (iHashCode + (annotationQualifiersFqNames2 == null ? 0 : annotationQualifiersFqNames2.hashCode())) * 31;
        TypeParameterDescriptor typeParameterDescriptor = this.c;
        int iHashCode3 = (iHashCode2 + (typeParameterDescriptor != null ? typeParameterDescriptor.hashCode() : 0)) * 31;
        boolean z2 = this.d;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode3 + r1;
    }

    public String toString() {
        StringBuilder sbU = outline.U("TypeAndDefaultQualifiers(type=");
        sbU.append(this.a);
        sbU.append(", defaultQualifiers=");
        sbU.append(this.f3353b);
        sbU.append(", typeParameterForArgument=");
        sbU.append(this.c);
        sbU.append(", isFromStarProjection=");
        sbU.append(this.d);
        sbU.append(')');
        return sbU.toString();
    }
}
