package d0.e0.p.d.m0.e.a.i0.m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.i0.m.b, reason: use source file name */
/* JADX INFO: compiled from: JavaTypeResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum JavaTypeResolver2 {
    INFLEXIBLE,
    FLEXIBLE_UPPER_BOUND,
    FLEXIBLE_LOWER_BOUND;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static JavaTypeResolver2[] valuesCustom() {
        JavaTypeResolver2[] javaTypeResolver2ArrValuesCustom = values();
        JavaTypeResolver2[] javaTypeResolver2Arr = new JavaTypeResolver2[javaTypeResolver2ArrValuesCustom.length];
        System.arraycopy(javaTypeResolver2ArrValuesCustom, 0, javaTypeResolver2Arr, 0, javaTypeResolver2ArrValuesCustom.length);
        return javaTypeResolver2Arr;
    }
}
