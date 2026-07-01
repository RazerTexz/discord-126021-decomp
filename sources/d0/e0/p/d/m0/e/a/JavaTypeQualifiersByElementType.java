package d0.e0.p.d.m0.e.a;

import d0.z.d.Intrinsics3;
import java.util.EnumMap;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.y, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeQualifiersByElementType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaTypeQualifiersByElementType {
    public final EnumMap<AnnotationQualifierApplicabilityType, AnnotationQualifiersFqNames2> a;

    public JavaTypeQualifiersByElementType(EnumMap<AnnotationQualifierApplicabilityType, AnnotationQualifiersFqNames2> enumMap) {
        Intrinsics3.checkNotNullParameter(enumMap, "defaultQualifiers");
        this.a = enumMap;
    }

    public final AnnotationQualifiersFqNames2 get(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return this.a.get(annotationQualifierApplicabilityType);
    }

    public final EnumMap<AnnotationQualifierApplicabilityType, AnnotationQualifiersFqNames2> getDefaultQualifiers() {
        return this.a;
    }
}
