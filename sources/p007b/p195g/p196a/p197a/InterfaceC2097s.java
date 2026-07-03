package p007b.p195g.p196a.p197a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.a.s */
/* JADX INFO: compiled from: JsonManagedReference.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2097s {
    String value() default "defaultReference";
}
