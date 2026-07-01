package d0.e0.p.d.m0.c.g1;

import java.util.Objects;

/* JADX INFO: compiled from: AnnotationUseSiteTarget.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum e {
    FIELD(null),
    FILE(null),
    PROPERTY(null),
    PROPERTY_GETTER("get"),
    PROPERTY_SETTER("set"),
    RECEIVER(null),
    CONSTRUCTOR_PARAMETER("param"),
    SETTER_PARAMETER("setparam"),
    PROPERTY_DELEGATE_FIELD("delegate");

    private final String renderName;

    e(String str) {
        if (str == null) {
            String strName = name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            str = strName.toLowerCase();
            d0.z.d.m.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
        }
        this.renderName = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static e[] valuesCustom() {
        e[] eVarArrValuesCustom = values();
        e[] eVarArr = new e[eVarArrValuesCustom.length];
        System.arraycopy(eVarArrValuesCustom, 0, eVarArr, 0, eVarArrValuesCustom.length);
        return eVarArr;
    }

    public final String getRenderName() {
        return this.renderName;
    }
}
