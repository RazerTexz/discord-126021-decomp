package androidx.core.util;

import androidx.annotation.NonNull;
import b.d.b.a.a;

/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s2) {
        this.first = f;
        this.second = s2;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a, B b2) {
        return new Pair<>(a, b2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    public int hashCode() {
        F f = this.first;
        int iHashCode = f == null ? 0 : f.hashCode();
        S s2 = this.second;
        return iHashCode ^ (s2 != null ? s2.hashCode() : 0);
    }

    @NonNull
    public String toString() {
        StringBuilder sbU = a.U("Pair{");
        sbU.append(this.first);
        sbU.append(" ");
        sbU.append(this.second);
        sbU.append("}");
        return sbU.toString();
    }
}
