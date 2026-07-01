package d0.e0.p.d.m0.c.g1;

import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.g1.e, reason: use source file name */
/* JADX INFO: compiled from: AnnotationUseSiteTarget.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum AnnotationUseSiteTarget {
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

    AnnotationUseSiteTarget(String str) {
        if (str == null) {
            String strName = name();
            Objects.requireNonNull(strName, "null cannot be cast to non-null type java.lang.String");
            str = strName.toLowerCase();
            Intrinsics3.checkNotNullExpressionValue(str, "(this as java.lang.String).toLowerCase()");
        }
        this.renderName = str;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static AnnotationUseSiteTarget[] valuesCustom() {
        AnnotationUseSiteTarget[] annotationUseSiteTargetArrValuesCustom = values();
        AnnotationUseSiteTarget[] annotationUseSiteTargetArr = new AnnotationUseSiteTarget[annotationUseSiteTargetArrValuesCustom.length];
        System.arraycopy(annotationUseSiteTargetArrValuesCustom, 0, annotationUseSiteTargetArr, 0, annotationUseSiteTargetArrValuesCustom.length);
        return annotationUseSiteTargetArr;
    }

    public final String getRenderName() {
        return this.renderName;
    }
}
