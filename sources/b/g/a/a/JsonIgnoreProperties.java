package b.g.a.a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: renamed from: b.g.a.a.n, reason: use source file name */
/* JADX INFO: compiled from: JsonIgnoreProperties.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonIgnoreProperties {

    /* JADX INFO: renamed from: b.g.a.a.n$a */
    /* JADX INFO: compiled from: JsonIgnoreProperties.java */
    public static class a implements Serializable {
        public static final a j = new a(Collections.emptySet(), false, false, false, true);
        private static final long serialVersionUID = 1;
        public final boolean _allowGetters;
        public final boolean _allowSetters;
        public final boolean _ignoreUnknown;
        public final Set<String> _ignored;
        public final boolean _merge;

        public a(Set<String> set, boolean z2, boolean z3, boolean z4, boolean z5) {
            if (set == null) {
                this._ignored = Collections.emptySet();
            } else {
                this._ignored = set;
            }
            this._ignoreUnknown = z2;
            this._allowGetters = z3;
            this._allowSetters = z4;
            this._merge = z5;
        }

        public static boolean a(Set<String> set, boolean z2, boolean z3, boolean z4, boolean z5) {
            a aVar = j;
            if (z2 == aVar._ignoreUnknown && z3 == aVar._allowGetters && z4 == aVar._allowSetters && z5 == aVar._merge) {
                return set == null || set.size() == 0;
            }
            return false;
        }

        public static boolean b(a aVar, a aVar2) {
            return aVar._ignoreUnknown == aVar2._ignoreUnknown && aVar._merge == aVar2._merge && aVar._allowGetters == aVar2._allowGetters && aVar._allowSetters == aVar2._allowSetters && aVar._ignored.equals(aVar2._ignored);
        }

        public static a c(Set<String> set, boolean z2, boolean z3, boolean z4, boolean z5) {
            return a(set, z2, z3, z4, z5) ? j : new a(set, z2, z3, z4, z5);
        }

        public Set<String> d() {
            return this._allowGetters ? Collections.emptySet() : this._ignored;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return obj != null && obj.getClass() == a.class && b(this, (a) obj);
        }

        public int hashCode() {
            return this._ignored.size() + (this._ignoreUnknown ? 1 : -3) + (this._allowGetters ? 3 : -7) + (this._allowSetters ? 7 : -11) + (this._merge ? 11 : -13);
        }

        public Object readResolve() {
            return a(this._ignored, this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge) ? j : this;
        }

        public String toString() {
            return String.format("JsonIgnoreProperties.Value(ignored=%s,ignoreUnknown=%s,allowGetters=%s,allowSetters=%s,merge=%s)", this._ignored, Boolean.valueOf(this._ignoreUnknown), Boolean.valueOf(this._allowGetters), Boolean.valueOf(this._allowSetters), Boolean.valueOf(this._merge));
        }
    }

    boolean allowGetters() default false;

    boolean allowSetters() default false;

    boolean ignoreUnknown() default false;

    String[] value() default {};
}
