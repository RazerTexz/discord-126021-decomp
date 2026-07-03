package p507d0.p513e0.p514p.p515d.p517m0.p567n;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.j1 */
/* JADX INFO: compiled from: Variance.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11935j1 {
    INVARIANT("", true, true, 0),
    IN_VARIANCE("in", true, false, -1),
    OUT_VARIANCE("out", false, true, 1);

    private final boolean allowsInPosition;
    private final boolean allowsOutPosition;
    private final String label;
    private final int superpositionFactor;

    EnumC11935j1(String str, boolean z2, boolean z3, int i) {
        this.label = str;
        this.allowsInPosition = z2;
        this.allowsOutPosition = z3;
        this.superpositionFactor = i;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11935j1[] valuesCustom() {
        EnumC11935j1[] enumC11935j1ArrValuesCustom = values();
        EnumC11935j1[] enumC11935j1Arr = new EnumC11935j1[enumC11935j1ArrValuesCustom.length];
        System.arraycopy(enumC11935j1ArrValuesCustom, 0, enumC11935j1Arr, 0, enumC11935j1ArrValuesCustom.length);
        return enumC11935j1Arr;
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
