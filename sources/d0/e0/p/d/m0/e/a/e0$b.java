package d0.e0.p.d.m0.e.a;

/* JADX INFO: compiled from: SpecialGenericSignatures.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum e0$b {
    ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
    OBJECT_PARAMETER_NON_GENERIC(null, true),
    OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);

    private final boolean isObjectReplacedWithTypeParameter;
    private final String valueParametersSignature;

    e0$b(String str, boolean z2) {
        this.valueParametersSignature = str;
        this.isObjectReplacedWithTypeParameter = z2;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static e0$b[] valuesCustom() {
        e0$b[] e0_bArrValuesCustom = values();
        e0$b[] e0_bArr = new e0$b[e0_bArrValuesCustom.length];
        System.arraycopy(e0_bArrValuesCustom, 0, e0_bArr, 0, e0_bArrValuesCustom.length);
        return e0_bArr;
    }
}
