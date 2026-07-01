package b.g.a.a;

/* JADX INFO: compiled from: JsonFormat.java */
/* JADX INFO: loaded from: classes3.dex */
public class i$b {
    public static final i$b a = new i$b(0, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f654b;
    public final int c;

    public i$b(int i, int i2) {
        this.f654b = i;
        this.c = i2;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != i$b.class) {
            return false;
        }
        i$b i_b = (i$b) obj;
        return i_b.f654b == this.f654b && i_b.c == this.c;
    }

    public int hashCode() {
        return this.c + this.f654b;
    }

    public String toString() {
        return this == a ? "EMPTY" : String.format("(enabled=0x%x,disabled=0x%x)", Integer.valueOf(this.f654b), Integer.valueOf(this.c));
    }
}
