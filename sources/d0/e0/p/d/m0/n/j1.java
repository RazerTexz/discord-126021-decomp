package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: Variance.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum j1 {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);

    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;

    j1(String str, boolean z2, boolean z3, int i) {
        this.label = str;
        this.allowsInPosition = z2;
        this.allowsOutPosition = z3;
        this.superpositionFactor = i;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static j1[] valuesCustom() {
        j1[] j1VarArrValuesCustom = values();
        j1[] j1VarArr = new j1[j1VarArrValuesCustom.length];
        System.arraycopy(j1VarArrValuesCustom, 0, j1VarArr, 0, j1VarArrValuesCustom.length);
        return j1VarArr;
    }

    public final boolean getAllowsOutPosition() {
        return this.allowsOutPosition;
    }

    public final String getLabel() {
        return this.label;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.label;
    }
}
