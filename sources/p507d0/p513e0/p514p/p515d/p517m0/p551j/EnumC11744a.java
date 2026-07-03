package p507d0.p513e0.p514p.p515d.p517m0.p551j;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.a */
/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11744a {
    NO_ARGUMENTS(false, false, 3),
    UNLESS_EMPTY(true, false, 2),
    ALWAYS_PARENTHESIZED(true, true);

    private final boolean includeAnnotationArguments;
    private final boolean includeEmptyAnnotationArguments;

    EnumC11744a(boolean z2, boolean z3) {
        this.includeAnnotationArguments = z2;
        this.includeEmptyAnnotationArguments = z3;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11744a[] valuesCustom() {
        EnumC11744a[] enumC11744aArrValuesCustom = values();
        EnumC11744a[] enumC11744aArr = new EnumC11744a[enumC11744aArrValuesCustom.length];
        System.arraycopy(enumC11744aArrValuesCustom, 0, enumC11744aArr, 0, enumC11744aArrValuesCustom.length);
        return enumC11744aArr;
    }

    public final boolean getIncludeAnnotationArguments() {
        return this.includeAnnotationArguments;
    }

    public final boolean getIncludeEmptyAnnotationArguments() {
        return this.includeEmptyAnnotationArguments;
    }

    EnumC11744a(boolean z2, boolean z3, int i) {
        z2 = (i & 1) != 0 ? false : z2;
        z3 = (i & 2) != 0 ? false : z3;
        this.includeAnnotationArguments = z2;
        this.includeEmptyAnnotationArguments = z3;
    }
}
