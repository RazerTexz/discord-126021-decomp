package b.q.a.i;

/* JADX INFO: compiled from: ExifInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1979b;
    public int c;

    public b(int i, int i2, int i3) {
        this.a = i;
        this.f1979b = i2;
        this.c = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.a == bVar.a && this.f1979b == bVar.f1979b && this.c == bVar.c;
    }

    public int hashCode() {
        return (((this.a * 31) + this.f1979b) * 31) + this.c;
    }
}
