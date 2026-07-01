package b.g.a.c.y;

import b.g.a.c.n;
import b.g.a.c.n$a;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: compiled from: JsonSerialize.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface e {
    Class<?> as() default Void.class;

    Class<?> contentAs() default Void.class;

    Class<? extends b.g.a.c.i0.e> contentConverter() default b.g.a.c.i0.e$a.class;

    Class<? extends n> contentUsing() default n$a.class;

    Class<? extends b.g.a.c.i0.e> converter() default b.g.a.c.i0.e$a.class;

    @Deprecated
    e$a include() default e$a.DEFAULT_INCLUSION;

    Class<?> keyAs() default Void.class;

    Class<? extends n> keyUsing() default n$a.class;

    Class<? extends n> nullsUsing() default n$a.class;

    e$b typing() default e$b.DEFAULT_TYPING;

    Class<? extends n> using() default n$a.class;
}
