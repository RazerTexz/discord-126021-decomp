package b.i.a.c.x2.i0;

import b.i.a.c.f3.x;

/* JADX INFO: compiled from: AtomParsers.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e$d implements e$a {
    public final x a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1213b;
    public final int c;
    public int d;
    public int e;

    public e$d(d$b d_b) {
        x xVar = d_b.f1210b;
        this.a = xVar;
        xVar.E(12);
        this.c = xVar.w() & 255;
        this.f1213b = xVar.w();
    }

    @Override // b.i.a.c.x2.i0.e$a
    public int a() {
        return -1;
    }

    @Override // b.i.a.c.x2.i0.e$a
    public int b() {
        return this.f1213b;
    }

    @Override // b.i.a.c.x2.i0.e$a
    public int c() {
        int i = this.c;
        if (i == 8) {
            return this.a.t();
        }
        if (i == 16) {
            return this.a.y();
        }
        int i2 = this.d;
        this.d = i2 + 1;
        if (i2 % 2 != 0) {
            return this.e & 15;
        }
        int iT = this.a.t();
        this.e = iT;
        return (iT & 240) >> 4;
    }
}
