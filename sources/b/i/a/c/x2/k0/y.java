package b.i.a.c.x2.k0;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;

/* JADX INFO: compiled from: PesReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements i0 {
    public final o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.a.c.f3.w f1283b = new b.i.a.c.f3.w(new byte[10]);
    public int c = 0;
    public int d;
    public b.i.a.c.f3.d0 e;
    public boolean f;
    public boolean g;
    public boolean h;
    public int i;
    public int j;
    public boolean k;
    public long l;

    public y(o oVar) {
        this.a = oVar;
    }

    @Override // b.i.a.c.x2.k0.i0
    public void a(b.i.a.c.f3.d0 d0Var, b.i.a.c.x2.j jVar, i0$d i0_d) {
        this.e = d0Var;
        this.a.e(jVar, i0_d);
    }

    @Override // b.i.a.c.x2.k0.i0
    public final void b(b.i.a.c.f3.x xVar, int i) throws ParserException {
        boolean z2;
        b.c.a.a0.d.H(this.e);
        int i2 = -1;
        int i3 = 3;
        if ((i & 1) != 0) {
            int i4 = this.c;
            if (i4 != 0 && i4 != 1) {
                if (i4 == 2) {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i4 != 3) {
                        throw new IllegalStateException();
                    }
                    int i5 = this.j;
                    if (i5 != -1) {
                        StringBuilder sb = new StringBuilder(59);
                        sb.append("Unexpected start indicator: expected ");
                        sb.append(i5);
                        sb.append(" more bytes");
                        Log.w("PesReader", sb.toString());
                    }
                    this.a.d();
                }
            }
            e(1);
        }
        while (xVar.a() > 0) {
            int i6 = this.c;
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        if (d(xVar, this.f1283b.a, Math.min(10, this.i)) && d(xVar, null, this.i)) {
                            this.f1283b.k(0);
                            this.l = -9223372036854775807L;
                            if (this.f) {
                                this.f1283b.m(4);
                                long jG = ((long) this.f1283b.g(i3)) << 30;
                                this.f1283b.m(1);
                                long jG2 = jG | ((long) (this.f1283b.g(15) << 15));
                                this.f1283b.m(1);
                                long jG3 = jG2 | ((long) this.f1283b.g(15));
                                this.f1283b.m(1);
                                if (!this.h && this.g) {
                                    this.f1283b.m(4);
                                    long jG4 = ((long) this.f1283b.g(i3)) << 30;
                                    this.f1283b.m(1);
                                    long jG5 = jG4 | ((long) (this.f1283b.g(15) << 15));
                                    this.f1283b.m(1);
                                    long jG6 = jG5 | ((long) this.f1283b.g(15));
                                    this.f1283b.m(1);
                                    this.e.b(jG6);
                                    this.h = true;
                                }
                                this.l = this.e.b(jG3);
                            }
                            i |= this.k ? 4 : 0;
                            this.a.f(this.l, i);
                            e(3);
                        }
                    } else {
                        if (i6 != i3) {
                            throw new IllegalStateException();
                        }
                        int iA = xVar.a();
                        int i7 = this.j;
                        int i8 = i7 != i2 ? iA - i7 : 0;
                        if (i8 > 0) {
                            iA -= i8;
                            xVar.D(xVar.f984b + iA);
                        }
                        this.a.b(xVar);
                        int i9 = this.j;
                        if (i9 != i2) {
                            int i10 = i9 - iA;
                            this.j = i10;
                            if (i10 == 0) {
                                this.a.d();
                                e(1);
                            }
                        }
                    }
                } else if (d(xVar, this.f1283b.a, 9)) {
                    this.f1283b.k(0);
                    int iG = this.f1283b.g(24);
                    if (iG != 1) {
                        b.d.b.a.a.g0(41, "Unexpected start code prefix: ", iG, "PesReader");
                        this.j = -1;
                        z2 = false;
                    } else {
                        this.f1283b.m(8);
                        int iG2 = this.f1283b.g(16);
                        this.f1283b.m(5);
                        this.k = this.f1283b.f();
                        this.f1283b.m(2);
                        this.f = this.f1283b.f();
                        this.g = this.f1283b.f();
                        this.f1283b.m(6);
                        int iG3 = this.f1283b.g(8);
                        this.i = iG3;
                        if (iG2 == 0) {
                            this.j = -1;
                        } else {
                            int i11 = ((iG2 + 6) - 9) - iG3;
                            this.j = i11;
                            if (i11 < 0) {
                                b.d.b.a.a.g0(47, "Found negative packet payload size: ", i11, "PesReader");
                                this.j = -1;
                            }
                        }
                        z2 = true;
                    }
                    e(z2 ? 2 : 0);
                }
            } else {
                xVar.F(xVar.a());
            }
            i2 = -1;
            i3 = 3;
        }
    }

    @Override // b.i.a.c.x2.k0.i0
    public final void c() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.c();
    }

    public final boolean d(b.i.a.c.f3.x xVar, @Nullable byte[] bArr, int i) {
        int iMin = Math.min(xVar.a(), i - this.d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            xVar.F(iMin);
        } else {
            System.arraycopy(xVar.a, xVar.f984b, bArr, this.d, iMin);
            xVar.f984b += iMin;
        }
        int i2 = this.d + iMin;
        this.d = i2;
        return i2 == i;
    }

    public final void e(int i) {
        this.c = i;
        this.d = 0;
    }
}
