package b.i.a.c.b3.n;

import b.i.a.c.b3.j;

/* JADX INFO: compiled from: CeaDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$b extends j implements Comparable<e$b> {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f861s;

    public e$b() {
    }

    @Override // java.lang.Comparable
    public int compareTo(e$b e_b) {
        e$b e_b2 = e_b;
        if (n() == e_b2.n()) {
            long j = this.n - e_b2.n;
            if (j == 0) {
                j = this.f861s - e_b2.f861s;
                if (j == 0) {
                    return 0;
                }
            }
            if (j > 0) {
                return 1;
            }
        } else if (n()) {
            return 1;
        }
        return -1;
    }

    public e$b(e$a e_a) {
    }
}
