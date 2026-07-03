package kotlin;

import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Triple<A, B, C> implements Serializable {
    private final A first;
    private final B second;
    private final C third;

    public Triple(A a, B b2, C c) {
        this.first = a;
        this.second = b2;
        this.third = c;
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) other;
        return C12238m.areEqual(this.first, triple.first) && C12238m.areEqual(this.second, triple.second) && C12238m.areEqual(this.third, triple.third);
    }

    public final C getThird() {
        return this.third;
    }

    public int hashCode() {
        A a = this.first;
        int iHashCode = (a != null ? a.hashCode() : 0) * 31;
        B b2 = this.second;
        int iHashCode2 = (iHashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c = this.third;
        return iHashCode2 + (c != null ? c.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM829Q = C1643a.m829Q('(');
        sbM829Q.append(this.first);
        sbM829Q.append(", ");
        sbM829Q.append(this.second);
        sbM829Q.append(", ");
        sbM829Q.append(this.third);
        sbM829Q.append(')');
        return sbM829Q.toString();
    }
}
