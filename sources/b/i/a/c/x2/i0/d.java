package b.i.a.c.x2.i0;

/* JADX INFO: compiled from: Atom.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public final int a;

    public d(int i) {
        this.a = i;
    }

    public static String a(int i) {
        StringBuilder sb = new StringBuilder(4);
        sb.append((char) ((i >> 24) & 255));
        sb.append((char) ((i >> 16) & 255));
        sb.append((char) ((i >> 8) & 255));
        sb.append((char) (i & 255));
        return sb.toString();
    }

    public String toString() {
        return a(this.a);
    }
}
