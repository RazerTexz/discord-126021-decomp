package p630i0.p636f0;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: i0.f0.q */
/* JADX INFO: compiled from: Part.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC12544q {
    String encoding() default "binary";

    String value() default "";
}
