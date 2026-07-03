package p007b.p195g.p196a.p197a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: renamed from: b.g.a.a.k */
/* JADX INFO: compiled from: JsonIdentityInfo.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2085k {
    Class<? extends AbstractC2082i0<?>> generator();

    String property() default "@id";

    Class<?> resolver() default C2092n0.class;

    Class<?> scope() default Object.class;
}
