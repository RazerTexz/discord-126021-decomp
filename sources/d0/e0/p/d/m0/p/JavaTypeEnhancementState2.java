package d0.e0.p.d.m0.p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.h, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum JavaTypeEnhancementState2 {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");

    private final String description;

    static {
        new Object(null) { // from class: d0.e0.p.d.m0.p.h.a
        };
    }

    JavaTypeEnhancementState2(String str) {
        this.description = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static JavaTypeEnhancementState2[] valuesCustom() {
        JavaTypeEnhancementState2[] javaTypeEnhancementState2ArrValuesCustom = values();
        JavaTypeEnhancementState2[] javaTypeEnhancementState2Arr = new JavaTypeEnhancementState2[javaTypeEnhancementState2ArrValuesCustom.length];
        System.arraycopy(javaTypeEnhancementState2ArrValuesCustom, 0, javaTypeEnhancementState2Arr, 0, javaTypeEnhancementState2ArrValuesCustom.length);
        return javaTypeEnhancementState2Arr;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}
