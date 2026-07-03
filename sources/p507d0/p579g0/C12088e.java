package p507d0.p579g0;

import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g0.e */
/* JADX INFO: compiled from: Regex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12088e {

    /* JADX INFO: renamed from: a */
    public final String f25150a;

    /* JADX INFO: renamed from: b */
    public final IntRange f25151b;

    public C12088e(String str, IntRange intRange) {
        C12238m.checkNotNullParameter(str, "value");
        C12238m.checkNotNullParameter(intRange, "range");
        this.f25150a = str;
        this.f25151b = intRange;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12088e)) {
            return false;
        }
        C12088e c12088e = (C12088e) obj;
        return C12238m.areEqual(this.f25150a, c12088e.f25150a) && C12238m.areEqual(this.f25151b, c12088e.f25151b);
    }

    public final IntRange getRange() {
        return this.f25151b;
    }

    public final String getValue() {
        return this.f25150a;
    }

    public int hashCode() {
        String str = this.f25150a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        IntRange intRange = this.f25151b;
        return iHashCode + (intRange != null ? intRange.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("MatchGroup(value=");
        sbM833U.append(this.f25150a);
        sbM833U.append(", range=");
        sbM833U.append(this.f25151b);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
