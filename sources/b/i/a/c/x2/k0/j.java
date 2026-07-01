package b.i.a.c.x2.k0;

import b.i.a.c.x2.t$b;
import com.google.android.exoplayer2.ParserException;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: AdtsExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements b.i.a.c.x2.h {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f1260b;
    public final b.i.a.c.f3.x c;
    public final b.i.a.c.f3.x d;
    public final b.i.a.c.f3.w e;
    public b.i.a.c.x2.j f;
    public long g;
    public long h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;

    static {
        c cVar = c.a;
    }

    public j(int i) {
        this.a = (i & 2) != 0 ? i | 1 : i;
        this.f1260b = new k(true, null);
        this.c = new b.i.a.c.f3.x(2048);
        this.i = -1;
        this.h = -1L;
        b.i.a.c.f3.x xVar = new b.i.a.c.f3.x(10);
        this.d = xVar;
        this.e = new b.i.a.c.f3.w(xVar.a);
    }

    public final int a(b.i.a.c.x2.i iVar) throws IOException {
        int i = 0;
        while (true) {
            iVar.o(this.d.a, 0, 10);
            this.d.E(0);
            if (this.d.v() != 4801587) {
                break;
            }
            this.d.F(3);
            int iS = this.d.s();
            i += iS + 10;
            iVar.g(iS);
        }
        iVar.k();
        iVar.g(i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        int iA = a(iVar);
        int i = iA;
        int i2 = 0;
        int i3 = 0;
        do {
            iVar.o(this.d.a, 0, 2);
            this.d.E(0);
            if (k.g(this.d.y())) {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                iVar.o(this.d.a, 0, 4);
                this.e.k(14);
                int iG = this.e.g(13);
                if (iG <= 6) {
                    i++;
                    iVar.k();
                    iVar.g(i);
                } else {
                    iVar.g(iG - 6);
                    i3 += iG;
                }
            } else {
                i++;
                iVar.k();
                iVar.g(i);
            }
            i2 = 0;
            i3 = 0;
        } while (i - iA < 8192);
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:72:0x0108  */
    @Override // b.i.a.c.x2.h
    public int e(b.i.a.c.x2.i iVar, b.i.a.c.x2.s sVar) throws IOException {
        int iG;
        b.c.a.a0.d.H(this.f);
        long jB = iVar.b();
        int i = this.a;
        if ((((i & 2) == 0 && ((i & 1) == 0 || jB == -1)) ? false : true) && !this.j) {
            this.i = -1;
            iVar.k();
            if (iVar.getPosition() == 0) {
                a(iVar);
            }
            long j = 0;
            int i2 = 0;
            do {
                try {
                    if (!iVar.e(this.d.a, 0, 2, true)) {
                        break;
                    }
                    this.d.E(0);
                    if (!k.g(this.d.y())) {
                        i2 = 0;
                        break;
                    }
                    if (!iVar.e(this.d.a, 0, 4, true)) {
                        break;
                    }
                    this.e.k(14);
                    iG = this.e.g(13);
                    if (iG <= 6) {
                        this.j = true;
                        throw ParserException.a("Malformed ADTS stream", null);
                    }
                    j += (long) iG;
                    i2++;
                    if (i2 == 1000) {
                        break;
                    }
                } catch (EOFException unused) {
                }
            } while (iVar.m(iG - 6, true));
            iVar.k();
            if (i2 > 0) {
                this.i = (int) (j / ((long) i2));
            } else {
                this.i = -1;
            }
            this.j = true;
        }
        int i3 = iVar.read(this.c.a, 0, 2048);
        boolean z2 = i3 == -1;
        if (!this.l) {
            int i4 = this.a;
            boolean z3 = (i4 & 1) != 0 && this.i > 0;
            if (!z3 || this.f1260b.r != -9223372036854775807L || z2) {
                if (z3) {
                    long j2 = this.f1260b.r;
                    if (j2 != -9223372036854775807L) {
                        b.i.a.c.x2.j jVar = this.f;
                        boolean z4 = (2 & i4) != 0;
                        int i5 = this.i;
                        jVar.a(new b.i.a.c.x2.d(jB, this.h, (int) ((((long) (i5 * 8)) * 1000000) / j2), i5, z4));
                    } else {
                        this.f.a(new t$b(-9223372036854775807L, 0L));
                    }
                } else {
                    this.f.a(new t$b(-9223372036854775807L, 0L));
                }
                this.l = true;
            }
        }
        if (z2) {
            return -1;
        }
        this.c.E(0);
        this.c.D(i3);
        if (!this.k) {
            this.f1260b.f(this.g, 4);
            this.k = true;
        }
        this.f1260b.b(this.c);
        return 0;
    }

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        this.f = jVar;
        this.f1260b.e(jVar, new i0$d(Integer.MIN_VALUE, 0, 1));
        jVar.j();
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.k = false;
        this.f1260b.c();
        this.g = j2;
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
