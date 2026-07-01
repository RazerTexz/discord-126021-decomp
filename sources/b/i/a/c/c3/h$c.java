package b.i.a.c.c3;

import b.i.a.c.j1;

/* JADX INFO: compiled from: DefaultTrackSelector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$c implements Comparable<h$c> {
    public final boolean j;
    public final boolean k;

    public h$c(j1 j1Var, int i) {
        this.j = (j1Var.o & 1) != 0;
        this.k = h.e(i, false);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(h$c h_c) {
        return f(h_c);
    }

    public int f(h$c h_c) {
        return b.i.b.b.j.a.c(this.k, h_c.k).c(this.j, h_c.j).e();
    }
}
