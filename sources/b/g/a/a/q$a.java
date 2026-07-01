package b.g.a.a;

import java.io.Serializable;
import java.util.Set;

/* JADX INFO: compiled from: JsonIncludeProperties.java */
/* JADX INFO: loaded from: classes3.dex */
public class q$a implements Serializable {
    public static final q$a j = new q$a(null);
    private static final long serialVersionUID = 1;
    public final Set<String> _included;

    public q$a(Set<String> set) {
        this._included = set;
    }

    public boolean equals(Object obj) {
        boolean zEquals;
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == q$a.class) {
            Set<String> set = this._included;
            Set<String> set2 = ((q$a) obj)._included;
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
