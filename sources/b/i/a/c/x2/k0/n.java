package b.i.a.c.x2.k0;

import b.i.a.c.j1$b;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: DvbSubtitleReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements o {
    public final List<i0$a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.x2.w[] f1266b;
    public boolean c;
    public int d;
    public int e;
    public long f = -9223372036854775807L;

    public n(List<i0$a> list) {
        this.a = list;
        this.f1266b = new b.i.a.c.x2.w[list.size()];
    }

    public final boolean a(b.i.a.c.f3.x xVar, int i) {
        if (xVar.a() == 0) {
            return false;
        }
        if (xVar.t() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) {
        if (this.c) {
            if (this.d != 2 || a(xVar, 32)) {
                if (this.d != 1 || a(xVar, 0)) {
                    int i = xVar.f984b;
                    int iA = xVar.a();
                    for (b.i.a.c.x2.w wVar : this.f1266b) {
                        xVar.E(i);
                        wVar.c(xVar, iA);
                    }
                    this.e += iA;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.c = false;
        this.f = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
        if (this.c) {
            if (this.f != -9223372036854775807L) {
                for (b.i.a.c.x2.w wVar : this.f1266b) {
                    wVar.d(this.f, 1, this.e, 0, null);
                }
            }
            this.c = false;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        for (int i = 0; i < this.f1266b.length; i++) {
            i0$a i0_a = this.a.get(i);
            i0_d.a();
            b.i.a.c.x2.w wVarP = jVar.p(i0_d.c(), 3);
            j1$b j1_b = new j1$b();
            j1_b.a = i0_d.b();
            j1_b.k = "application/dvbsubs";
            j1_b.m = Collections.singletonList(i0_a.f1257b);
            j1_b.c = i0_a.a;
            wVarP.e(j1_b.a());
            this.f1266b[i] = wVarP;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.f = j;
        }
        this.e = 0;
        this.d = 2;
    }
}
