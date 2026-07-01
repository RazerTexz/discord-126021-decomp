package b.c.a.y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import b.d.b.a.outline;

/* JADX INFO: renamed from: b.c.a.y.j, reason: use source file name */
/* JADX INFO: compiled from: MutablePair.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MutablePair<T> {

    @Nullable
    public T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public T f411b;

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f = pair.first;
        Object obj2 = this.a;
        if (!(f == obj2 || (f != 0 && f.equals(obj2)))) {
            return false;
        }
        S s2 = pair.second;
        Object obj3 = this.f411b;
        return s2 == obj3 || (s2 != 0 && s2.equals(obj3));
    }

    public int hashCode() {
        T t = this.a;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f411b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Pair{");
        sbU.append(String.valueOf(this.a));
        sbU.append(" ");
        sbU.append(String.valueOf(this.f411b));
        sbU.append("}");
        return sbU.toString();
    }
}
