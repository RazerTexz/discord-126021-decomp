package d0.e0.p.d.m0.j;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum m {
    RENDER_OVERRIDE,
    RENDER_OPEN,
    RENDER_OPEN_OVERRIDE;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static m[] valuesCustom() {
        m[] mVarArrValuesCustom = values();
        m[] mVarArr = new m[mVarArrValuesCustom.length];
        System.arraycopy(mVarArrValuesCustom, 0, mVarArr, 0, mVarArrValuesCustom.length);
        return mVarArr;
    }
}
