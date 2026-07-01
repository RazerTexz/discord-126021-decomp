package b.f.j.d;

/* JADX INFO: compiled from: ResizeOptions.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f566b;
    public final float c;
    public final float d;

    public e(int i, int i2) {
        b.c.a.a0.d.i(Boolean.valueOf(i > 0));
        b.c.a.a0.d.i(Boolean.valueOf(i2 > 0));
        this.a = i;
        this.f566b = i2;
        this.c = 2048.0f;
        this.d = 0.6666667f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.a == eVar.a && this.f566b == eVar.f566b;
    }

    public int hashCode() {
        return b.c.a.a0.d.J0(this.a, this.f566b);
    }

    public String toString() {
        return String.format(null, "%dx%d", Integer.valueOf(this.a), Integer.valueOf(this.f566b));
    }
}
