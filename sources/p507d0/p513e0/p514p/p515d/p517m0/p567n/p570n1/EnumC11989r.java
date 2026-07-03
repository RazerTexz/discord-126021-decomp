package p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.n1.r */
/* JADX INFO: compiled from: TypeSystemContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11989r {
    IN("in"),
    OUT("out"),
    INV("");

    private final String presentation;

    EnumC11989r(String str) {
        this.presentation = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11989r[] valuesCustom() {
        EnumC11989r[] enumC11989rArrValuesCustom = values();
        EnumC11989r[] enumC11989rArr = new EnumC11989r[enumC11989rArrValuesCustom.length];
        System.arraycopy(enumC11989rArrValuesCustom, 0, enumC11989rArr, 0, enumC11989rArrValuesCustom.length);
        return enumC11989rArr;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }
}
