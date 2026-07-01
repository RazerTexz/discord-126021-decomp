package d0.e0.p.d.m0.e.a.l0;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.t, reason: use source file name */
/* JADX INFO: compiled from: TypeComponentPosition.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum TypeComponentPosition {
    FLEXIBLE_LOWER,
    FLEXIBLE_UPPER,
    INFLEXIBLE;

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static TypeComponentPosition[] valuesCustom() {
        TypeComponentPosition[] typeComponentPositionArrValuesCustom = values();
        TypeComponentPosition[] typeComponentPositionArr = new TypeComponentPosition[typeComponentPositionArrValuesCustom.length];
        System.arraycopy(typeComponentPositionArrValuesCustom, 0, typeComponentPositionArr, 0, typeComponentPositionArrValuesCustom.length);
        return typeComponentPositionArr;
    }
}
