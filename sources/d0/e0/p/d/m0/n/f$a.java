package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum f$a {
    CHECK_ONLY_LOWER,
    CHECK_SUBTYPE_AND_LOWER,
    SKIP_LOWER;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static f$a[] valuesCustom() {
        f$a[] f_aArrValuesCustom = values();
        f$a[] f_aArr = new f$a[f_aArrValuesCustom.length];
        System.arraycopy(f_aArrValuesCustom, 0, f_aArr, 0, f_aArrValuesCustom.length);
        return f_aArr;
    }
}
