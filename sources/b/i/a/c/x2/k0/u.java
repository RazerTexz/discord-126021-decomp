package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.j1$b;
import b.i.a.c.t2.l$b;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: compiled from: LatmReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements o {

    @Nullable
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.f3.x f1278b;
    public final b.i.a.c.f3.w c;
    public b.i.a.c.x2.w d;
    public String e;
    public j1 f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f1279s;
    public int t;

    @Nullable
    public String u;

    public u(@Nullable String str) {
        this.a = str;
        b.i.a.c.f3.x xVar = new b.i.a.c.f3.x(1024);
        this.f1278b = xVar;
        this.c = new b.i.a.c.f3.w(xVar.a);
        this.k = -9223372036854775807L;
    }

    public static long a(b.i.a.c.f3.w wVar) {
        return wVar.g((wVar.g(2) + 1) * 8);
    }

    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) throws ParserException {
        int i;
        boolean zF;
        b.c.a.a0.d.H(this.d);
        while (xVar.a() > 0) {
            int i2 = this.g;
            if (i2 != 0) {
                if (i2 == 1) {
                    int iT = xVar.t();
                    if ((iT & 224) == 224) {
                        this.j = iT;
                        this.g = 2;
                    } else if (iT != 86) {
                        this.g = 0;
                    }
                } else if (i2 == 2) {
                    int iT2 = ((this.j & (-225)) << 8) | xVar.t();
                    this.i = iT2;
                    b.i.a.c.f3.x xVar2 = this.f1278b;
                    byte[] bArr = xVar2.a;
                    if (iT2 > bArr.length) {
                        if (bArr.length < iT2) {
                            bArr = new byte[iT2];
                        }
                        xVar2.C(bArr, iT2);
                        b.i.a.c.f3.w wVar = this.c;
                        byte[] bArr2 = this.f1278b.a;
                        Objects.requireNonNull(wVar);
                        int length = bArr2.length;
                        wVar.a = bArr2;
                        wVar.f983b = 0;
                        wVar.c = 0;
                        wVar.d = length;
                    }
                    this.h = 0;
                    this.g = 3;
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(xVar.a(), this.i - this.h);
                    xVar.e(this.c.a, this.h, iMin);
                    int i3 = this.h + iMin;
                    this.h = i3;
                    if (i3 == this.i) {
                        this.c.k(0);
                        b.i.a.c.f3.w wVar2 = this.c;
                        if (wVar2.f()) {
                            if (this.l) {
                            }
                            this.g = 0;
                        } else {
                            this.l = true;
                            int iG = wVar2.g(1);
                            int iG2 = iG == 1 ? wVar2.g(1) : 0;
                            this.m = iG2;
                            if (iG2 != 0) {
                                throw ParserException.a(null, null);
                            }
                            if (iG == 1) {
                                a(wVar2);
                            }
                            if (!wVar2.f()) {
                                throw ParserException.a(null, null);
                            }
                            this.n = wVar2.g(6);
                            int iG3 = wVar2.g(4);
                            int iG4 = wVar2.g(3);
                            if (iG3 != 0 || iG4 != 0) {
                                throw ParserException.a(null, null);
                            }
                            if (iG == 0) {
                                int iE = wVar2.e();
                                int iG5 = g(wVar2);
                                wVar2.k(iE);
                                byte[] bArr3 = new byte[(iG5 + 7) / 8];
                                wVar2.h(bArr3, 0, iG5);
                                j1$b j1_b = new j1$b();
                                j1_b.a = this.e;
                                j1_b.k = "audio/mp4a-latm";
                                j1_b.h = this.u;
                                j1_b.f1023x = this.t;
                                j1_b.f1024y = this.r;
                                j1_b.m = Collections.singletonList(bArr3);
                                j1_b.c = this.a;
                                j1 j1VarA = j1_b.a();
                                if (!j1VarA.equals(this.f)) {
                                    this.f = j1VarA;
                                    this.f1279s = 1024000000 / ((long) j1VarA.K);
                                    this.d.e(j1VarA);
                                }
                            } else {
                                wVar2.m(((int) a(wVar2)) - g(wVar2));
                            }
                            int iG6 = wVar2.g(3);
                            this.o = iG6;
                            if (iG6 == 0) {
                                wVar2.m(8);
                            } else if (iG6 == 1) {
                                wVar2.m(9);
                            } else if (iG6 == 3 || iG6 == 4 || iG6 == 5) {
                                wVar2.m(6);
                            } else {
                                if (iG6 != 6 && iG6 != 7) {
                                    throw new IllegalStateException();
                                }
                                wVar2.m(1);
                            }
                            boolean zF2 = wVar2.f();
                            this.p = zF2;
                            this.q = 0L;
                            if (zF2) {
                                if (iG == 1) {
                                    this.q = a(wVar2);
                                } else {
                                    do {
                                        zF = wVar2.f();
                                        this.q = (this.q << 8) + ((long) wVar2.g(8));
                                    } while (zF);
                                }
                            }
                            if (wVar2.f()) {
                                wVar2.m(8);
                            }
                        }
                        if (this.m != 0) {
                            throw ParserException.a(null, null);
                        }
                        if (this.n != 0) {
                            throw ParserException.a(null, null);
                        }
                        if (this.o != 0) {
                            throw ParserException.a(null, null);
                        }
                        int i4 = 0;
                        while (true) {
                            int iG7 = wVar2.g(8);
                            i = i4 + iG7;
                            if (iG7 != 255) {
                                break;
                            } else {
                                i4 = i;
                            }
                        }
                        int iE2 = wVar2.e();
                        if ((iE2 & 7) == 0) {
                            this.f1278b.E(iE2 >> 3);
                        } else {
                            wVar2.h(this.f1278b.a, 0, i * 8);
                            this.f1278b.E(0);
                        }
                        this.d.c(this.f1278b, i);
                        long j = this.k;
                        if (j != -9223372036854775807L) {
                            this.d.d(j, 1, i, 0, null);
                            this.k += this.f1279s;
                        }
                        if (this.p) {
                            wVar2.m((int) this.q);
                        }
                        this.g = 0;
                    } else {
                        continue;
                    }
                }
            } else if (xVar.t() == 86) {
                this.g = 1;
            }
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.g = 0;
        this.k = -9223372036854775807L;
        this.l = false;
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        i0_d.a();
        this.d = jVar.p(i0_d.c(), 1);
        this.e = i0_d.b();
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    public final int g(b.i.a.c.f3.w wVar) throws ParserException {
        int iB = wVar.b();
        l$b l_bB = b.i.a.c.t2.l.b(wVar, true);
        this.u = l_bB.c;
        this.r = l_bB.a;
        this.t = l_bB.f1122b;
        return iB - wVar.b();
    }
}
