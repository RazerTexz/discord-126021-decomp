package b.i.d.p;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.i.d.p.c, reason: use source file name */
/* JADX INFO: compiled from: Since.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.FIELD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Since2 {
    double value();
}
