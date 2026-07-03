package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.a */
/* JADX INFO: compiled from: AnnotationQualifierApplicabilityType.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11485a {
    METHOD_RETURN_TYPE("METHOD"),
    VALUE_PARAMETER("PARAMETER"),
    FIELD("FIELD"),
    TYPE_USE("TYPE_USE"),
    TYPE_PARAMETER_BOUNDS("TYPE_USE"),
    TYPE_PARAMETER("TYPE_PARAMETER");

    private final String javaTarget;

    EnumC11485a(String str) {
        this.javaTarget = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11485a[] valuesCustom() {
        EnumC11485a[] enumC11485aArrValuesCustom = values();
        EnumC11485a[] enumC11485aArr = new EnumC11485a[enumC11485aArrValuesCustom.length];
        System.arraycopy(enumC11485aArrValuesCustom, 0, enumC11485aArr, 0, enumC11485aArrValuesCustom.length);
        return enumC11485aArr;
    }

    public final String getJavaTarget() {
        return this.javaTarget;
    }
}
