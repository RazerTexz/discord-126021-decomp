package b.f.j.d;

/* JADX INFO: compiled from: BytesRange.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f563b;

    public a(int i, int i2) {
        this.a = i;
        this.f563b = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.a == aVar.a && this.f563b == aVar.f563b;
    }

    public int hashCode() {
        return b.c.a.a0.d.J0(this.a, this.f563b);
    }

    public String toString() {
        Object[] objArr = new Object[2];
        int i = this.a;
        objArr[0] = i == Integer.MAX_VALUE ? "" : Integer.toString(i);
        int i2 = this.f563b;
        objArr[1] = i2 != Integer.MAX_VALUE ? Integer.toString(i2) : "";
        return String.format(null, "%s-%s", objArr);
    }
}
