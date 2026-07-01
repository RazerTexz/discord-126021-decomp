package d0.e0.p.d.m0.n;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.j1, reason: use source file name */
/* JADX INFO: compiled from: Variance.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum Variance {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);

    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;

    Variance(String str, boolean z2, boolean z3, int i) {
        this.label = str;
        this.allowsInPosition = z2;
        this.allowsOutPosition = z3;
        this.superpositionFactor = i;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static Variance[] valuesCustom() {
        Variance[] varianceArrValuesCustom = values();
        Variance[] varianceArr = new Variance[varianceArrValuesCustom.length];
        System.arraycopy(varianceArrValuesCustom, 0, varianceArr, 0, varianceArrValuesCustom.length);
        return varianceArr;
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
