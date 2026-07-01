package b.i.a.c.x2.j0;

import b.i.a.c.f3.e0;
import b.i.a.c.x2.t;
import b.i.a.c.x2.t$a;
import b.i.a.c.x2.u;

/* JADX INFO: compiled from: DefaultOggSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b implements t {
    public final /* synthetic */ b a;

    public b$b(b bVar, b$a b_a) {
        this.a = bVar;
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        b bVar = this.a;
        long j2 = (((long) bVar.d.i) * j) / 1000000;
        long j3 = bVar.f1234b;
        long j4 = bVar.c;
        return new t$a(new u(j, e0.i(((((j4 - j3) * j2) / bVar.f) + j3) - 30000, j3, j4 - 1)));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        b bVar = this.a;
        return (bVar.f * 1000000) / ((long) bVar.d.i);
    }
}
