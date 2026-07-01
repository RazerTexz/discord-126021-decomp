package b.g.a.c.y;

import b.g.a.a.JsonInclude;
import b.g.a.c.g0.VirtualBeanPropertyWriter;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.c.y.b, reason: use source file name */
/* JADX INFO: compiled from: JsonAppend.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAppend {

    /* JADX INFO: renamed from: b.g.a.c.y.b$a */
    /* JADX INFO: compiled from: JsonAppend.java */
    public @interface a {
        JsonInclude.a include() default JsonInclude.a.NON_NULL;

        String propName() default "";

        String propNamespace() default "";

        boolean required() default false;

        String value();
    }

    /* JADX INFO: renamed from: b.g.a.c.y.b$b */
    /* JADX INFO: compiled from: JsonAppend.java */
    public @interface b {
        JsonInclude.a include() default JsonInclude.a.NON_NULL;

        String name() default "";

        String namespace() default "";

        boolean required() default false;

        Class<?> type() default Object.class;

        Class<? extends VirtualBeanPropertyWriter> value();
    }

    a[] attrs() default {};

    boolean prepend() default false;

    b[] props() default {};
}
