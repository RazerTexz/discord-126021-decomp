package b.g.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: JsonAutoDetect.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface e {
    e$a creatorVisibility() default e$a.DEFAULT;

    e$a fieldVisibility() default e$a.DEFAULT;

    e$a getterVisibility() default e$a.DEFAULT;

    e$a isGetterVisibility() default e$a.DEFAULT;

    e$a setterVisibility() default e$a.DEFAULT;
}
