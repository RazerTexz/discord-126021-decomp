package d0.e0.p.d.m0.e.a.l0;

/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum h {
    NULLABLE,
    NOT_NULL,
    FORCE_FLEXIBILITY;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static h[] valuesCustom() {
        h[] hVarArrValuesCustom = values();
        h[] hVarArr = new h[hVarArrValuesCustom.length];
        System.arraycopy(hVarArrValuesCustom, 0, hVarArr, 0, hVarArrValuesCustom.length);
        return hVarArr;
    }
}
