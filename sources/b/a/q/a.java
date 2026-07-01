package b.a.q;

/* JADX INFO: compiled from: MediaSinkWantsLadder.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f255b;
    public final Integer c;

    public a(int i, int i2, Integer num) {
        this.a = i;
        this.f255b = i2;
        this.c = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.f255b == aVar.f255b && d0.z.d.m.areEqual(this.c, aVar.c);
    }

    public int hashCode() {
        int i = ((this.a * 31) + this.f255b) * 31;
        Integer num = this.c;
        return i + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Bitrate(min=");
        sbU.append(this.a);
        sbU.append(", max=");
        sbU.append(this.f255b);
        sbU.append(", target=");
        return b.d.b.a.a.F(sbU, this.c, ")");
    }
}
