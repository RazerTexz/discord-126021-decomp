package p007b.p008a.p041q;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.a */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1188a {

    /* JADX INFO: renamed from: a */
    public final int f1599a;

    /* JADX INFO: renamed from: b */
    public final int f1600b;

    /* JADX INFO: renamed from: c */
    public final Integer f1601c;

    public C1188a(int i, int i2, Integer num) {
        this.f1599a = i;
        this.f1600b = i2;
        this.f1601c = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1188a)) {
            return false;
        }
        C1188a c1188a = (C1188a) obj;
        return this.f1599a == c1188a.f1599a && this.f1600b == c1188a.f1600b && C12238m.areEqual(this.f1601c, c1188a.f1601c);
    }

    public int hashCode() {
        int i = ((this.f1599a * 31) + this.f1600b) * 31;
        Integer num = this.f1601c;
        return i + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Bitrate(min=");
        sbM833U.append(this.f1599a);
        sbM833U.append(", max=");
        sbM833U.append(this.f1600b);
        sbM833U.append(", target=");
        return C1643a.m818F(sbM833U, this.f1601c, ")");
    }
}
