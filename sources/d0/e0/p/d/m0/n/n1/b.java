package d0.e0.p.d.m0.n.n1;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum b {
    FOR_SUBTYPING,
    FOR_INCORPORATION,
    FROM_EXPRESSION;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static b[] valuesCustom() {
        b[] bVarArrValuesCustom = values();
        b[] bVarArr = new b[bVarArrValuesCustom.length];
        System.arraycopy(bVarArrValuesCustom, 0, bVarArr, 0, bVarArrValuesCustom.length);
        return bVarArr;
    }
}
