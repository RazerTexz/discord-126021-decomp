package p007b.p225i.p408d.p409p;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.i.d.p.a */
/* JADX INFO: compiled from: JsonAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC4912a {
    boolean nullSafe() default true;

    Class<?> value();
}
