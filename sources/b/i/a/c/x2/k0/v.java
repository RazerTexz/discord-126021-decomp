package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import b.i.a.c.j1$b;
import b.i.a.c.t2.a0$a;

/* JADX INFO: compiled from: MpegAudioReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v implements o {
    public final b.i.a.c.f3.x a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0$a f1280b;

    @Nullable
    public final String c;
    public b.i.a.c.x2.w d;
    public String e;
    public int f = 0;
    public int g;
    public boolean h;
    public boolean i;
    public long j;
    public int k;
    public long l;

    public v(@Nullable String str) {
        b.i.a.c.f3.x xVar = new b.i.a.c.f3.x(4);
        this.a = xVar;
        xVar.a[0] = -1;
        this.f1280b = new a0$a();
        this.l = -9223372036854775807L;
        this.c = str;
    }

    @Override // b.i.a.c.x2.k0.o
    public void b(b.i.a.c.f3.x xVar) {
        b.c.a.a0.d.H(this.d);
        while (xVar.a() > 0) {
            int i = this.f;
            if (i == 0) {
                byte[] bArr = xVar.a;
                int i2 = xVar.f984b;
                int i3 = xVar.c;
                while (true) {
                    if (i2 >= i3) {
                        xVar.E(i3);
                        break;
                    }
                    boolean z2 = (bArr[i2] & 255) == 255;
                    boolean z3 = this.i && (bArr[i2] & 224) == 224;
                    this.i = z2;
                    if (z3) {
                        xVar.E(i2 + 1);
                        this.i = false;
                        this.a.a[1] = bArr[i2];
                        this.g = 2;
                        this.f = 1;
                        break;
                    }
                    i2++;
                }
            } else if (i == 1) {
                int iMin = Math.min(xVar.a(), 4 - this.g);
                xVar.e(this.a.a, this.g, iMin);
                int i4 = this.g + iMin;
                this.g = i4;
                if (i4 >= 4) {
                    this.a.E(0);
                    if (this.f1280b.a(this.a.f())) {
                        a0$a a0_a = this.f1280b;
                        this.k = a0_a.c;
                        if (!this.h) {
                            long j = ((long) a0_a.g) * 1000000;
                            int i5 = a0_a.d;
                            this.j = j / ((long) i5);
                            j1$b j1_b = new j1$b();
                            j1_b.a = this.e;
                            j1_b.k = a0_a.f1116b;
                            j1_b.l = 4096;
                            j1_b.f1023x = a0_a.e;
                            j1_b.f1024y = i5;
                            j1_b.c = this.c;
                            this.d.e(j1_b.a());
                            this.h = true;
                        }
                        this.a.E(0);
                        this.d.c(this.a, 4);
                        this.f = 2;
                    } else {
                        this.g = 0;
                        this.f = 1;
                    }
                }
            } else {
                if (i != 2) {
                    throw new IllegalStateException();
                }
                int iMin2 = Math.min(xVar.a(), this.k - this.g);
                this.d.c(xVar, iMin2);
                int i6 = this.g + iMin2;
                this.g = i6;
                int i7 = this.k;
                if (i6 >= i7) {
                    long j2 = this.l;
                    if (j2 != -9223372036854775807L) {
                        this.d.d(j2, 1, i7, 0, null);
                        this.l += this.j;
                    }
                    this.g = 0;
                    this.f = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.l = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0$d i0_d) {
        i0_d.a();
        this.e = i0_d.b();
        this.d = jVar.p(i0_d.c(), 1);
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }
}
