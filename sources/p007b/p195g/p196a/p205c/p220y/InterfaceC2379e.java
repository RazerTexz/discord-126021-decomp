package p007b.p195g.p196a.p205c.p220y;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p007b.p195g.p196a.p205c.AbstractC2364n;
import p007b.p195g.p196a.p205c.p219i0.InterfaceC2343e;

/* JADX INFO: renamed from: b.g.a.c.y.e */
/* JADX INFO: compiled from: JsonSerialize.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2379e {

    /* JADX INFO: renamed from: b.g.a.c.y.e$a */
    /* JADX INFO: compiled from: JsonSerialize.java */
    @Deprecated
    public enum a {
        ALWAYS,
        NON_NULL,
        NON_DEFAULT,
        NON_EMPTY,
        DEFAULT_INCLUSION
    }

    /* JADX INFO: renamed from: b.g.a.c.y.e$b */
    /* JADX INFO: compiled from: JsonSerialize.java */
    public enum b {
        DYNAMIC,
        STATIC,
        DEFAULT_TYPING
    }

    /* JADX INFO: renamed from: as */
    Class<?> m2262as() default Void.class;

    Class<?> contentAs() default Void.class;

    Class<? extends InterfaceC2343e> contentConverter() default InterfaceC2343e.a.class;

    Class<? extends AbstractC2364n> contentUsing() default AbstractC2364n.a.class;

    Class<? extends InterfaceC2343e> converter() default InterfaceC2343e.a.class;

    @Deprecated
    a include() default a.DEFAULT_INCLUSION;

    Class<?> keyAs() default Void.class;

    Class<? extends AbstractC2364n> keyUsing() default AbstractC2364n.a.class;

    Class<? extends AbstractC2364n> nullsUsing() default AbstractC2364n.a.class;

    b typing() default b.DEFAULT_TYPING;

    Class<? extends AbstractC2364n> using() default AbstractC2364n.a.class;
}
