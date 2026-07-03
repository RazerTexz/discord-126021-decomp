package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.f */
/* JADX INFO: compiled from: numbers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12038f {

    /* JADX INFO: renamed from: a */
    public final String f24991a;

    /* JADX INFO: renamed from: b */
    public final int f24992b;

    public C12038f(String str, int i) {
        C12238m.checkNotNullParameter(str, "number");
        this.f24991a = str;
        this.f24992b = i;
    }

    public final String component1() {
        return this.f24991a;
    }

    public final int component2() {
        return this.f24992b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C12038f)) {
            return false;
        }
        C12038f c12038f = (C12038f) obj;
        return C12238m.areEqual(this.f24991a, c12038f.f24991a) && this.f24992b == c12038f.f24992b;
    }

    public int hashCode() {
        return (this.f24991a.hashCode() * 31) + this.f24992b;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("NumberWithRadix(number=");
        sbM833U.append(this.f24991a);
        sbM833U.append(", radix=");
        return C1643a.m813A(sbM833U, this.f24992b, ')');
    }
}
