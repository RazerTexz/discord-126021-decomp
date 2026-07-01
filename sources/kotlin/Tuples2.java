package kotlin;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.io.Serializable;

/* JADX INFO: renamed from: kotlin.Pair, reason: use source file name */
/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes3.dex */
public final /* data */ class Tuples2<A, B> implements Serializable {
    private final A first;
    private final B second;

    public Tuples2(A a, B b2) {
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
        if (!(other instanceof Tuples2)) {
            return false;
        }
        Tuples2 tuples2 = (Tuples2) other;
        return Intrinsics3.areEqual(this.first, tuples2.first) && Intrinsics3.areEqual(this.second, tuples2.second);
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
        StringBuilder sbQ = outline.Q('(');
        sbQ.append(this.first);
        sbQ.append(", ");
        sbQ.append(this.second);
        sbQ.append(')');
        return sbQ.toString();
    }
}
