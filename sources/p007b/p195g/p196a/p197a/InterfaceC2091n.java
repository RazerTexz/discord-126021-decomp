package p007b.p195g.p196a.p197a;

import java.io.Serializable;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: renamed from: b.g.a.a.n */
/* JADX INFO: compiled from: JsonIgnoreProperties.java */
/* JADX INFO: loaded from: classes3.dex */
@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC2091n {

    /* JADX INFO: renamed from: b.g.a.a.n$a */
    /* JADX INFO: compiled from: JsonIgnoreProperties.java */
    public static class a implements Serializable {

        /* JADX INFO: renamed from: j */
        public static final a f4427j = new a(Collections.emptySet(), false, false, false, true);
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

        /* JADX INFO: renamed from: a */
        public static boolean m1614a(Set<String> set, boolean z2, boolean z3, boolean z4, boolean z5) {
            a aVar = f4427j;
            if (z2 == aVar._ignoreUnknown && z3 == aVar._allowGetters && z4 == aVar._allowSetters && z5 == aVar._merge) {
                return set == null || set.size() == 0;
            }
            return false;
        }

        /* JADX INFO: renamed from: b */
        public static boolean m1615b(a aVar, a aVar2) {
            return aVar._ignoreUnknown == aVar2._ignoreUnknown && aVar._merge == aVar2._merge && aVar._allowGetters == aVar2._allowGetters && aVar._allowSetters == aVar2._allowSetters && aVar._ignored.equals(aVar2._ignored);
        }

        /* JADX INFO: renamed from: c */
        public static a m1616c(Set<String> set, boolean z2, boolean z3, boolean z4, boolean z5) {
            return m1614a(set, z2, z3, z4, z5) ? f4427j : new a(set, z2, z3, z4, z5);
        }

        /* JADX INFO: renamed from: d */
        public Set<String> m1617d() {
            return this._allowGetters ? Collections.emptySet() : this._ignored;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            return obj != null && obj.getClass() == a.class && m1615b(this, (a) obj);
        }

        public int hashCode() {
            return this._ignored.size() + (this._ignoreUnknown ? 1 : -3) + (this._allowGetters ? 3 : -7) + (this._allowSetters ? 7 : -11) + (this._merge ? 11 : -13);
        }

        public Object readResolve() {
            return m1614a(this._ignored, this._ignoreUnknown, this._allowGetters, this._allowSetters, this._merge) ? f4427j : this;
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
