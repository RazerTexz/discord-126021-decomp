package b.g.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: JsonFormat.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface i {
    m0 lenient() default m0.DEFAULT;

    String locale() default "##default";

    String pattern() default "";

    i$c shape() default i$c.ANY;

    String timezone() default "##default";

    i$a[] with() default {};

    i$a[] without() default {};
}
