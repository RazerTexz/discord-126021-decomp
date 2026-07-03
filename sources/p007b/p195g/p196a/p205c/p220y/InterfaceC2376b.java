package p007b.p195g.p196a.p205c.p220y;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p007b.p195g.p196a.p197a.InterfaceC2094p;
import p007b.p195g.p196a.p205c.p215g0.AbstractC2250s;

/* JADX INFO: renamed from: b.g.a.c.y.b */
/* JADX INFO: compiled from: JsonAppend.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2376b {

    /* JADX INFO: renamed from: b.g.a.c.y.b$a */
    /* JADX INFO: compiled from: JsonAppend.java */
    public @interface a {
        InterfaceC2094p.a include() default InterfaceC2094p.a.NON_NULL;

        String propName() default "";

        String propNamespace() default "";

        boolean required() default false;

        String value();
    }

    /* JADX INFO: renamed from: b.g.a.c.y.b$b */
    /* JADX INFO: compiled from: JsonAppend.java */
    public @interface b {
        InterfaceC2094p.a include() default InterfaceC2094p.a.NON_NULL;

        String name() default "";

        String namespace() default "";

        boolean required() default false;

        Class<?> type() default Object.class;

        Class<? extends AbstractC2250s> value();
    }

    a[] attrs() default {};

    boolean prepend() default false;

    b[] props() default {};
}
