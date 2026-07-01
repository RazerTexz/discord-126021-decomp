package b.g.a.a;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

/* JADX INFO: renamed from: b.g.a.a.e, reason: use source file name */
/* JADX INFO: compiled from: JsonAutoDetect.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonAutoDetect {

    /* JADX INFO: renamed from: b.g.a.a.e$a */
    /* JADX INFO: compiled from: JsonAutoDetect.java */
    public enum a {
        ANY,
        NON_PRIVATE,
        PROTECTED_AND_PUBLIC,
        PUBLIC_ONLY,
        NONE,
        DEFAULT;

        public boolean f(Member member) {
            int iOrdinal = ordinal();
            if (iOrdinal == 0) {
                return true;
            }
            if (iOrdinal == 1) {
                return !Modifier.isPrivate(member.getModifiers());
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    return false;
                }
            } else if (Modifier.isProtected(member.getModifiers())) {
                return true;
            }
            return Modifier.isPublic(member.getModifiers());
        }
    }

    a creatorVisibility() default a.DEFAULT;

    a fieldVisibility() default a.DEFAULT;

    a getterVisibility() default a.DEFAULT;

    a isGetterVisibility() default a.DEFAULT;

    a setterVisibility() default a.DEFAULT;
}
