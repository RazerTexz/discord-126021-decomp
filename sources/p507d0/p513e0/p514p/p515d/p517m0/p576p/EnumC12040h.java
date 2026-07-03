package p507d0.p513e0.p514p.p515d.p517m0.p576p;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.h */
/* JADX INFO: compiled from: JavaTypeEnhancementState.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC12040h {
    IGNORE("ignore"),
    WARN("warn"),
    STRICT("strict");

    private final String description;

    static {
        new Object(null) { // from class: d0.e0.p.d.m0.p.h.a
        };
    }

    EnumC12040h(String str) {
        this.description = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC12040h[] valuesCustom() {
        EnumC12040h[] enumC12040hArrValuesCustom = values();
        EnumC12040h[] enumC12040hArr = new EnumC12040h[enumC12040hArrValuesCustom.length];
        System.arraycopy(enumC12040hArrValuesCustom, 0, enumC12040hArr, 0, enumC12040hArrValuesCustom.length);
        return enumC12040hArr;
    }

    public final String getDescription() {
        return this.description;
    }

    public final boolean isIgnore() {
        return this == IGNORE;
    }

    public final boolean isWarning() {
        return this == WARN;
    }
}
