package b.g.a.a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

/* JADX INFO: renamed from: b.g.a.a.q, reason: use source file name */
/* JADX INFO: compiled from: JsonIncludeProperties.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonIncludeProperties {

    /* JADX INFO: renamed from: b.g.a.a.q$a */
    /* JADX INFO: compiled from: JsonIncludeProperties.java */
    public static class a implements Serializable {
        public static final a j = new a(null);
        private static final long serialVersionUID = 1;
        public final Set<String> _included;

        public a(Set<String> set) {
            this._included = set;
        }

        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                Set<String> set = this._included;
                Set<String> set2 = ((a) obj)._included;
                if (set == null) {
                    zEquals = set2 == null;
                } else {
                    zEquals = set.equals(set2);
                }
                if (zEquals) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            Set<String> set = this._included;
            if (set == null) {
                return 0;
            }
            return set.size();
        }

        public String toString() {
            return String.format("JsonIncludeProperties.Value(included=%s)", this._included);
        }
    }

    String[] value() default {};
}
