package b.i.a.c.b3;

import b.i.b.b.h0;
import b.i.b.b.p;
import java.util.List;

/* JADX INFO: compiled from: ExoplayerCuesDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b implements g {
    public final long j;
    public final p<b> k;

    public d$b(long j, p<b> pVar) {
        this.j = j;
        this.k = pVar;
    }

    @Override // b.i.a.c.b3.g
    public int f(long j) {
        return this.j > j ? 0 : -1;
    }

    @Override // b.i.a.c.b3.g
    public long g(int i) {
        b.c.a.a0.d.j(i == 0);
        return this.j;
    }

    @Override // b.i.a.c.b3.g
    public List<b> h(long j) {
        if (j >= this.j) {
            return this.k;
        }
        b.i.b.b.a<Object> aVar = p.k;
        return h0.l;
    }

    @Override // b.i.a.c.b3.g
    public int i() {
        return 1;
    }
}
