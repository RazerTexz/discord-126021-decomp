package b.a.q;

/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f256b;
    public final int c;
    public final Integer d;

    public b(int i, int i2, int i3, Integer num) {
        this.a = i;
        this.f256b = i2;
        this.c = i3;
        this.d = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.f256b == bVar.f256b && this.c == bVar.c && d0.z.d.m.areEqual(this.d, bVar.d);
    }

    public int hashCode() {
        int i = ((((this.a * 31) + this.f256b) * 31) + this.c) * 31;
        Integer num = this.d;
        return i + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("IVideoQuality(width=");
        sbU.append(this.a);
        sbU.append(", height=");
        sbU.append(this.f256b);
        sbU.append(", framerate=");
        sbU.append(this.c);
        sbU.append(", pixelCount=");
        return b.d.b.a.a.F(sbU, this.d, ")");
    }
}
