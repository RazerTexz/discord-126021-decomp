package b.i.a.c.x2.k0;

import android.util.Log;
import b.i.a.c.j1$b;

/* JADX INFO: compiled from: Id3Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class t implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b.i.a.c.x2.w f1277b;
    public boolean c;
    public int e;
    public int f;
    public final b.i.a.c.f3.x a = new b.i.a.c.f3.x(10);
    public long d = -9223372036854775807L;

    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) {
        b.c.a.a0.d.H(this.f1277b);
        if (this.c) {
            int iA = xVar.a();
            int i = this.f;
            if (i < 10) {
                int iMin = Math.min(iA, 10 - i);
                System.arraycopy(xVar.a, xVar.f984b, this.a.a, this.f, iMin);
                if (this.f + iMin == 10) {
                    this.a.E(0);
                    if (73 != this.a.t() || 68 != this.a.t() || 51 != this.a.t()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.a.F(3);
                        this.e = this.a.s() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.e - this.f);
            this.f1277b.c(xVar, iMin2);
            this.f += iMin2;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.c = false;
        this.d = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
        int i;
        b.c.a.a0.d.H(this.f1277b);
        if (this.c && (i = this.e) != 0 && this.f == i) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                this.f1277b.d(j, 1, i, 0, null);
            }
            this.c = false;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        i0_d.a();
        b.i.a.c.x2.w wVarP = jVar.p(i0_d.c(), 5);
        this.f1277b = wVarP;
        j1$b j1_b = new j1$b();
        j1_b.a = i0_d.b();
        j1_b.k = "application/id3";
        wVarP.e(j1_b.a());
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.d = j;
        }
        this.e = 0;
        this.f = 0;
    }
}
