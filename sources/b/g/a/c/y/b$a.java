package b.g.a.c.y;

import b.g.a.a.p$a;

/* JADX INFO: compiled from: JsonAppend.java */
/* JADX INFO: loaded from: classes3.dex */
public @interface b$a {
    p$a include() default p$a.NON_NULL;

    String propName() default "";

    String propNamespace() default "";

    boolean required() default false;

    String value();
}
