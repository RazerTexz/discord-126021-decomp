package kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Pair(A a, B b2) {
        this.first = a;
        this.second = b2;
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) other;
        return C12238m.areEqual(this.first, pair.first) && C12238m.areEqual(this.second, pair.second);
    }

    public final A getFirst() {
        return this.first;
    }

    public final B getSecond() {
        return this.second;
    }

    public int hashCode() {
        A a = this.first;
        int iHashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.second;
        return iHashCode + (b2 != null ? b2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM829Q = C1643a.m829Q('(');
        sbM829Q.append(this.first);
        sbM829Q.append(", ");
        sbM829Q.append(this.second);
        sbM829Q.append(')');
        return sbM829Q.toString();
    }
}
