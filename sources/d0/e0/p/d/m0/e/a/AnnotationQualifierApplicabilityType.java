package d0.e0.p.d.m0.e.a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.a, reason: use source file name */
/* JADX INFO: compiled from: AnnotationQualifierApplicabilityType.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum AnnotationQualifierApplicabilityType {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");

    private final String javaTarget;

    AnnotationQualifierApplicabilityType(String str) {
        this.javaTarget = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static AnnotationQualifierApplicabilityType[] valuesCustom() {
        AnnotationQualifierApplicabilityType[] annotationQualifierApplicabilityTypeArrValuesCustom = values();
        AnnotationQualifierApplicabilityType[] annotationQualifierApplicabilityTypeArr = new AnnotationQualifierApplicabilityType[annotationQualifierApplicabilityTypeArrValuesCustom.length];
        System.arraycopy(annotationQualifierApplicabilityTypeArrValuesCustom, 0, annotationQualifierApplicabilityTypeArr, 0, annotationQualifierApplicabilityTypeArrValuesCustom.length);
        return annotationQualifierApplicabilityTypeArr;
    }

    public final String getJavaTarget() {
        return this.javaTarget;
    }
}
