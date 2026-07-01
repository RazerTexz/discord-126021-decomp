package d0.g0;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import kotlin.ranges.Ranges2;

/* JADX INFO: renamed from: d0.g0.e, reason: use source file name */
/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Regex2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Ranges2 f3581b;

    public Regex2(String str, Ranges2 ranges2) {
        Intrinsics3.checkNotNullParameter(str, "value");
        Intrinsics3.checkNotNullParameter(ranges2, "range");
        this.a = str;
        this.f3581b = ranges2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Regex2)) {
            return false;
        }
        Regex2 regex2 = (Regex2) obj;
        return Intrinsics3.areEqual(this.a, regex2.a) && Intrinsics3.areEqual(this.f3581b, regex2.f3581b);
    }

    public final Ranges2 getRange() {
        return this.f3581b;
    }

    public final String getValue() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Ranges2 ranges2 = this.f3581b;
        return iHashCode + (ranges2 != null ? ranges2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MatchGroup(value=");
        sbU.append(this.a);
        sbU.append(", range=");
        sbU.append(this.f3581b);
        sbU.append(")");
        return sbU.toString();
    }
}
