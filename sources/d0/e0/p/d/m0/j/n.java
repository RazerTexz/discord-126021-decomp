package d0.e0.p.d.m0.j;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum n {
    ALL,
    ONLY_NON_SYNTHESIZED,
    NONE;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static n[] valuesCustom() {
        n[] nVarArrValuesCustom = values();
        n[] nVarArr = new n[nVarArrValuesCustom.length];
        System.arraycopy(nVarArrValuesCustom, 0, nVarArr, 0, nVarArrValuesCustom.length);
        return nVarArr;
    }
}
