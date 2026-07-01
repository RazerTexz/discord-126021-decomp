package d0.g0;

import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntRange f3581b;

    public e(String str, IntRange intRange) {
        d0.z.d.m.checkNotNullParameter(str, "value");
        d0.z.d.m.checkNotNullParameter(intRange, "range");
        this.a = str;
        this.f3581b = intRange;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return d0.z.d.m.areEqual(this.a, eVar.a) && d0.z.d.m.areEqual(this.f3581b, eVar.f3581b);
    }

    public final IntRange getRange() {
        return this.f3581b;
    }

    public final String getValue() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        IntRange intRange = this.f3581b;
        return iHashCode + (intRange != null ? intRange.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("MatchGroup(value=");
        sbU.append(this.a);
        sbU.append(", range=");
        sbU.append(this.f3581b);
        sbU.append(")");
        return sbU.toString();
    }
}
