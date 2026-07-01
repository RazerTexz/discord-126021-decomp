package b.i.a.c.f3;

import b.i.a.c.x1;

/* JADX INFO: compiled from: StandaloneMediaClock.java */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements s {
    public final g j;
    public boolean k;
    public long l;
    public long m;
    public x1 n = x1.j;

    public z(g gVar) {
        this.j = gVar;
    }

    public void a(long j) {
        this.l = j;
        if (this.k) {
            this.m = this.j.d();
        }
    }

    public void b() {
        if (this.k) {
            return;
        }
        this.m = this.j.d();
        this.k = true;
    }

    @Override // b.i.a.c.f3.s
    public x1 c() {
        return this.n;
    }

    @Override // b.i.a.c.f3.s
    public long e() {
        long j = this.l;
        if (!this.k) {
            return j;
        }
        long jD = this.j.d() - this.m;
        x1 x1Var = this.n;
        return x1Var.k == 1.0f ? j + e0.B(jD) : j + (jD * ((long) x1Var.m));
    }

    @Override // b.i.a.c.f3.s
    public void i(x1 x1Var) {
        if (this.k) {
            a(e());
        }
        this.n = x1Var;
    }
}
