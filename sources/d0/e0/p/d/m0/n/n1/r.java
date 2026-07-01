package d0.e0.p.d.m0.n.n1;

/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum r {
    IN("in"),
    OUT("out"),
    INV("");

    private final String presentation;

    r(String str) {
        this.presentation = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static r[] valuesCustom() {
        r[] rVarArrValuesCustom = values();
        r[] rVarArr = new r[rVarArrValuesCustom.length];
        System.arraycopy(rVarArrValuesCustom, 0, rVarArr, 0, rVarArrValuesCustom.length);
        return rVarArr;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}
