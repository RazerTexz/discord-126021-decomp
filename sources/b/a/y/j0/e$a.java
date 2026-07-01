package b.a.y.j0;

/* JADX INFO: compiled from: RxRendererEvents.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e$a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f312b;
    public final int c;

    public e$a(int i, int i2, int i3) {
        this.a = i;
        this.f312b = i2;
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e$a)) {
            return false;
        }
        e$a e_a = (e$a) obj;
        return this.a == e_a.a && this.f312b == e_a.f312b && this.c == e_a.c;
    }

    public int hashCode() {
        return (((this.a * 31) + this.f312b) * 31) + this.c;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Resolution(width=");
        sbU.append(this.a);
        sbU.append(", height=");
        sbU.append(this.f312b);
        sbU.append(", rotation=");
        return b.d.b.a.a.B(sbU, this.c, ")");
    }
}
