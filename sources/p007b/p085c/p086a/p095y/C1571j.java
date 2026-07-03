package p007b.p085c.p086a.p095y;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Pair;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.j */
/* JADX INFO: compiled from: MutablePair.java */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class C1571j<T> {

    /* JADX INFO: renamed from: a */
    @Nullable
    public T f2720a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public T f2721b;

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        F f = pair.first;
        Object obj2 = this.f2720a;
        if (!(f == obj2 || (f != 0 && f.equals(obj2)))) {
            return false;
        }
        S s2 = pair.second;
        Object obj3 = this.f2721b;
        return s2 == obj3 || (s2 != 0 && s2.equals(obj3));
    }

    public int hashCode() {
        T t = this.f2720a;
        int iHashCode = t == null ? 0 : t.hashCode();
        T t2 = this.f2721b;
        return iHashCode ^ (t2 != null ? t2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Pair{");
        sbM833U.append(String.valueOf(this.f2720a));
        sbM833U.append(" ");
        sbM833U.append(String.valueOf(this.f2721b));
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
