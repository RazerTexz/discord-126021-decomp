package b.i.a.c.v2;

/* JADX INFO: compiled from: Buffer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {
    public int j;

    public final void j(int i) {
        this.j = i | this.j;
    }

    public final boolean k(int i) {
        return (this.j & i) == i;
    }

    public final boolean l() {
        return k(268435456);
    }

    public final boolean m() {
        return k(Integer.MIN_VALUE);
    }

    public final boolean n() {
        return k(4);
    }

    public final boolean o() {
        return k(1);
    }
}
