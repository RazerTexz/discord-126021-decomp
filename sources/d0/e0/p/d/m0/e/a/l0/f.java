package d0.e0.p.d.m0.e.a.l0;

/* JADX INFO: compiled from: typeQualifiers.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum f {
    READ_ONLY,
    MUTABLE;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static f[] valuesCustom() {
        f[] fVarArrValuesCustom = values();
        f[] fVarArr = new f[fVarArrValuesCustom.length];
        System.arraycopy(fVarArrValuesCustom, 0, fVarArr, 0, fVarArrValuesCustom.length);
        return fVarArr;
    }
}
