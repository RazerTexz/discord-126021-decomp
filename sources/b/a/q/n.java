package b.a.q;

/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f274b;
    public final double c;
    public final int d;
    public final int e;

    public n(int i, int i2, double d, int i3, int i4) {
        this.a = i;
        this.f274b = i2;
        this.c = d;
        this.d = i3;
        this.e = i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.a == nVar.a && this.f274b == nVar.f274b && Double.compare(this.c, nVar.c) == 0 && this.d == nVar.d && this.e == nVar.e;
    }

    public int hashCode() {
        return ((((a0.a.a.a.a(this.c) + (((this.a * 31) + this.f274b) * 31)) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ResolutionBudget(width=");
        sbU.append(this.a);
        sbU.append(", height=");
        sbU.append(this.f274b);
        sbU.append(", budgetPortion=");
        sbU.append(this.c);
        sbU.append(", mutedFramerate=");
        sbU.append(this.d);
        sbU.append(", framerate=");
        return b.d.b.a.a.B(sbU, this.e, ")");
    }
}
