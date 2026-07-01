package d0.e0.p.d.m0.c;

/* JADX INFO: compiled from: Modality.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum z {
    FINAL,
    SEALED,
    OPEN,
    ABSTRACT;

    public static final z$a j = new z$a(null);

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static z[] valuesCustom() {
        z[] zVarArrValuesCustom = values();
        z[] zVarArr = new z[zVarArrValuesCustom.length];
        System.arraycopy(zVarArrValuesCustom, 0, zVarArr, 0, zVarArrValuesCustom.length);
        return zVarArr;
    }
}
