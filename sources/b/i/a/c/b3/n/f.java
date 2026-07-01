package b.i.a.c.b3.n;

import b.i.a.c.b3.g;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: CeaSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements g {
    public final List<b.i.a.c.b3.b> j;

    public f(List<b.i.a.c.b3.b> list) {
        this.j = list;
    }

    @Override // b.i.a.c.b3.g
    public int f(long j) {
        return j < 0 ? 0 : -1;
    }

    @Override // b.i.a.c.b3.g
    public long g(int i) {
        b.c.a.a0.d.j(i == 0);
        return 0L;
    }

    @Override // b.i.a.c.b3.g
    public List<b.i.a.c.b3.b> h(long j) {
        return j >= 0 ? this.j : Collections.emptyList();
    }

    @Override // b.i.a.c.b3.g
    public int i() {
        return 1;
    }
}
