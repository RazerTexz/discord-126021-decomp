package p007b.p195g.p196a.p197a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.a.g */
/* JADX INFO: compiled from: JsonCreator.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2077g {

    /* JADX INFO: renamed from: b.g.a.a.g$a */
    /* JADX INFO: compiled from: JsonCreator.java */
    public enum a {
        DEFAULT,
        DELEGATING,
        PROPERTIES,
        DISABLED
    }

    a mode() default a.DEFAULT;
}
