package b.i.a.c.b3.v;

/* JADX INFO: compiled from: WebvttCueParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h$d implements Comparable<h$d> {
    public final int j;
    public final f k;

    public h$d(int i, f fVar) {
        this.j = i;
        this.k = fVar;
    }

    @Override // java.lang.Comparable
    public int compareTo(h$d h_d) {
        return Integer.compare(this.j, h_d.j);
    }
}
