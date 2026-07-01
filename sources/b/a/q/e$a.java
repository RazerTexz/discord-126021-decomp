package b.a.q;

/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f258b;
    public final double c;
    public final int d;

    public e$a(int i, int i2, double d, int i3) {
        this.a = i;
        this.f258b = i2;
        this.c = d;
        this.d = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e$a)) {
            return false;
        }
        e$a e_a = (e$a) obj;
        return this.a == e_a.a && this.f258b == e_a.f258b && Double.compare(this.c, e_a.c) == 0 && this.d == e_a.d;
    }

    public int hashCode() {
        return ((a0.a.a.a.a(this.c) + (((this.a * 31) + this.f258b) * 31)) * 31) + this.d;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CandidateResolution(width=");
        sbU.append(this.a);
        sbU.append(", height=");
        sbU.append(this.f258b);
        sbU.append(", budgetPortion=");
        sbU.append(this.c);
        sbU.append(", pixelCount=");
        return b.d.b.a.a.B(sbU, this.d, ")");
    }
}
