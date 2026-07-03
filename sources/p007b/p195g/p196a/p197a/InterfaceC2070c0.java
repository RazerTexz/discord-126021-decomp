package p007b.p195g.p196a.p197a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.a.c0 */
/* JADX INFO: compiled from: JsonTypeInfo.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2070c0 {

    /* JADX INFO: renamed from: b.g.a.a.c0$a */
    /* JADX INFO: compiled from: JsonTypeInfo.java */
    public enum a {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY,
        EXTERNAL_PROPERTY,
        EXISTING_PROPERTY
    }

    /* JADX INFO: renamed from: b.g.a.a.c0$b */
    /* JADX INFO: compiled from: JsonTypeInfo.java */
    public enum b {
        NONE(null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        DEDUCTION(null),
        CUSTOM(null);

        private final String _defaultPropertyName;

        b(String str) {
            this._defaultPropertyName = str;
        }

        /* JADX INFO: renamed from: f */
        public String m1594f() {
            return this._defaultPropertyName;
        }
    }

    /* JADX INFO: renamed from: b.g.a.a.c0$c */
    /* JADX INFO: compiled from: JsonTypeInfo.java */
    @Deprecated
    public static abstract class c {
    }

    Class<?> defaultImpl() default InterfaceC2070c0.class;

    a include() default a.PROPERTY;

    String property() default "";

    b use();

    boolean visible() default false;
}
