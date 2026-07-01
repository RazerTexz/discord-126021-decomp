package b.g.a.a;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: JsonIgnoreProperties.java */
/* JADX INFO: loaded from: classes3.dex */
public class n$a implements Serializable {
    public static final n$a j = new n$a(Collections.emptySet(), false, false, false, true);
    private static final long serialVersionUID = 1;
    public final boolean _allowGetters;
    public final boolean _allowSetters;
    public final boolean _ignoreUnknown;
    public final Set<String> _ignored;
    public final boolean _merge;

    public n$a(Set<String> set, boolean z2, boolean z3, boolean z4, boolean z5) {
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
        n$a n_a = j;
        if (z2 == n_a._ignoreUnknown && z3 == n_a._allowGetters && z4 == n_a._allowSetters && z5 == n_a._merge) {
            return set == null || set.size() == 0;
        }
        return false;
    }

    public static boolean b(n$a n_a, n$a n_a2) {
        return n_a._ignoreUnknown == n_a2._ignoreUnknown && n_a._merge == n_a2._merge && n_a._allowGetters == n_a2._allowGetters && n_a._allowSetters == n_a2._allowSetters && n_a._ignored.equals(n_a2._ignored);
    }

    public static n$a c(Set<String> set, boolean z2, boolean z3, boolean z4, boolean z5) {
        return a(set, z2, z3, z4, z5) ? j : new n$a(set, z2, z3, z4, z5);
    }

    public Set<String> d() {
        return this._allowGetters ? Collections.emptySet() : this._ignored;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj != null && obj.getClass() == n$a.class && b(this, (n$a) obj);
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
