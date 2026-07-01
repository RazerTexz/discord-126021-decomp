package b.i.a.c.x2.j0;

import b.i.a.c.f3.e0;
import b.i.a.c.x2.n;
import b.i.a.c.x2.o;
import b.i.a.c.x2.o$a;
import b.i.a.c.x2.t;

/* JADX INFO: compiled from: FlacReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a implements g {
    public o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public o$a f1235b;
    public long c = -1;
    public long d = -1;

    public c$a(o oVar, o$a o_a) {
        this.a = oVar;
        this.f1235b = o_a;
    }

    @Override // b.i.a.c.x2.j0.g
    public t a() {
        b.c.a.a0.d.D(this.c != -1);
        return new n(this.a, this.c);
    }

    @Override // b.i.a.c.x2.j0.g
    public long b(b.i.a.c.x2.i iVar) {
        long j = this.d;
        if (j < 0) {
            return -1L;
        }
        long j2 = -(j + 2);
        this.d = -1L;
        return j2;
    }

    @Override // b.i.a.c.x2.j0.g
    public void c(long j) {
        long[] jArr = this.f1235b.a;
        this.d = jArr[e0.e(jArr, j, true, true)];
    }
}
