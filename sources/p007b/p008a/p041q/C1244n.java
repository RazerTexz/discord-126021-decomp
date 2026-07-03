package p007b.p008a.p041q;

import p001a0.p002a.p003a.C0001a;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.a.q.n */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1244n {

    /* JADX INFO: renamed from: a */
    public final int f1758a;

    /* JADX INFO: renamed from: b */
    public final int f1759b;

    /* JADX INFO: renamed from: c */
    public final double f1760c;

    /* JADX INFO: renamed from: d */
    public final int f1761d;

    /* JADX INFO: renamed from: e */
    public final int f1762e;

    public C1244n(int i, int i2, double d, int i3, int i4) {
        this.f1758a = i;
        this.f1759b = i2;
        this.f1760c = d;
        this.f1761d = i3;
        this.f1762e = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1244n)) {
            return false;
        }
        C1244n c1244n = (C1244n) obj;
        return this.f1758a == c1244n.f1758a && this.f1759b == c1244n.f1759b && Double.compare(this.f1760c, c1244n.f1760c) == 0 && this.f1761d == c1244n.f1761d && this.f1762e == c1244n.f1762e;
    }

    public int hashCode() {
        return ((((C0001a.m2a(this.f1760c) + (((this.f1758a * 31) + this.f1759b) * 31)) * 31) + this.f1761d) * 31) + this.f1762e;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ResolutionBudget(width=");
        sbM833U.append(this.f1758a);
        sbM833U.append(", height=");
        sbM833U.append(this.f1759b);
        sbM833U.append(", budgetPortion=");
        sbM833U.append(this.f1760c);
        sbM833U.append(", mutedFramerate=");
        sbM833U.append(this.f1761d);
        sbM833U.append(", framerate=");
        return C1643a.m814B(sbM833U, this.f1762e, ")");
    }
}
