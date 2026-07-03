package kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: Metadata.kt */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Metadata {
    /* JADX INFO: renamed from: bv */
    int[] m10882bv() default {1, 0, 3};

    /* JADX INFO: renamed from: d1 */
    String[] m10883d1() default {};

    /* JADX INFO: renamed from: d2 */
    String[] m10884d2() default {};

    /* JADX INFO: renamed from: k */
    int m10885k() default 1;

    /* JADX INFO: renamed from: mv */
    int[] m10886mv() default {};

    /* JADX INFO: renamed from: pn */
    String m10887pn() default "";

    /* JADX INFO: renamed from: xi */
    int m10888xi() default 0;

    /* JADX INFO: renamed from: xs */
    String m10889xs() default "";
}
