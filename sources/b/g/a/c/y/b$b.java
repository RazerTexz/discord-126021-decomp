package b.g.a.c.y;

import b.g.a.a.p$a;
import b.g.a.c.g0.s;

/* JADX INFO: compiled from: JsonAppend.java */
/* JADX INFO: loaded from: classes3.dex */
public @interface b$b {
    p$a include() default p$a.NON_NULL;

    String name() default "";

    String namespace() default "";

    boolean required() default false;

    Class<?> type() default Object.class;

    Class<? extends s> value();
}
