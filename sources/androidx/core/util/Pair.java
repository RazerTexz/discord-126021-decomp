package androidx.core.util;

import androidx.annotation.NonNull;
import p007b.p100d.p104b.p105a.C1643a;

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
        StringBuilder sbM833U = C1643a.m833U("Pair{");
        sbM833U.append(this.first);
        sbM833U.append(" ");
        sbM833U.append(this.second);
        sbM833U.append("}");
        return sbM833U.toString();
    }
}
