package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Objects;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.e */
/* JADX INFO: compiled from: AnnotationUseSiteTarget.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC11342e {
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

    EnumC11342e(String str) {
        if (str == null) {
            String strName = name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            str = strName.toLowerCase();
            C12238m.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
        }
        this.renderName = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static EnumC11342e[] valuesCustom() {
        EnumC11342e[] enumC11342eArrValuesCustom = values();
        EnumC11342e[] enumC11342eArr = new EnumC11342e[enumC11342eArrValuesCustom.length];
        System.arraycopy(enumC11342eArrValuesCustom, 0, enumC11342eArr, 0, enumC11342eArrValuesCustom.length);
        return enumC11342eArr;
    }

    public final String getRenderName() {
        return this.renderName;
    }
}
