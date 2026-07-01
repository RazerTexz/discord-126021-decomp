package b.a.q;

import b.d.b.a.outline;

/* JADX INFO: renamed from: b.a.q.n, reason: use source file name */
/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaSinkWantsLadder6 {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f274b;
    public final double c;
    public final int d;
    public final int e;

    public MediaSinkWantsLadder6(int i, int i2, double d, int i3, int i4) {
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
        if (!(obj instanceof MediaSinkWantsLadder6)) {
            return false;
        }
        MediaSinkWantsLadder6 mediaSinkWantsLadder6 = (MediaSinkWantsLadder6) obj;
        return this.a == mediaSinkWantsLadder6.a && this.f274b == mediaSinkWantsLadder6.f274b && Double.compare(this.c, mediaSinkWantsLadder6.c) == 0 && this.d == mediaSinkWantsLadder6.d && this.e == mediaSinkWantsLadder6.e;
    }

    public int hashCode() {
        return ((((a0.a.a.a.a(this.c) + (((this.a * 31) + this.f274b) * 31)) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ResolutionBudget(width=");
        sbU.append(this.a);
        sbU.append(", height=");
        sbU.append(this.f274b);
        sbU.append(", budgetPortion=");
        sbU.append(this.c);
        sbU.append(", mutedFramerate=");
        sbU.append(this.d);
        sbU.append(", framerate=");
        return outline.B(sbU, this.e, ")");
    }
}
