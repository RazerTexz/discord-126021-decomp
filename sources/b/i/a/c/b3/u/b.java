package b.i.a.c.b3.u;

import b.c.a.a0.d;
import b.i.a.c.b3.g;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: Tx3gSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements g {
    public static final b j = new b();
    public final List<b.i.a.c.b3.b> k;

    public b(b.i.a.c.b3.b bVar) {
        this.k = Collections.singletonList(bVar);
    }

    @Override // b.i.a.c.b3.g
    public int f(long j2) {
        return j2 < 0 ? 0 : -1;
    }

    @Override // b.i.a.c.b3.g
    public long g(int i) {
        d.j(i == 0);
        return 0L;
    }

    @Override // b.i.a.c.b3.g
    public List<b.i.a.c.b3.b> h(long j2) {
        return j2 >= 0 ? this.k : Collections.emptyList();
    }

    @Override // b.i.a.c.b3.g
    public int i() {
        return 1;
    }

    public b() {
        this.k = Collections.emptyList();
    }
}
