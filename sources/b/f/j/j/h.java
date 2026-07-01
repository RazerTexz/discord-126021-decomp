package b.f.j.j;

/* JADX INFO: compiled from: ImmutableQualityInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements i {
    public static final i a = new h(Integer.MAX_VALUE, true, true);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f591b;
    public boolean c;
    public boolean d;

    public h(int i, boolean z2, boolean z3) {
        this.f591b = i;
        this.c = z2;
        this.d = z3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f591b == hVar.f591b && this.c == hVar.c && this.d == hVar.d;
    }

    public int hashCode() {
        return (this.f591b ^ (this.c ? 4194304 : 0)) ^ (this.d ? 8388608 : 0);
    }
}
