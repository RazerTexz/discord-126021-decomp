package b.i.a.c;

import android.util.Log;

/* JADX INFO: compiled from: DefaultLoadControl.java */
/* JADX INFO: loaded from: classes3.dex */
public class z0 implements n1 {
    public final b.i.a.c.e3.o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1318b;
    public final long c;
    public final long d;
    public final long e;
    public final int f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public int j;
    public boolean k;

    public z0(b.i.a.c.e3.o oVar, int i, int i2, int i3, int i4, int i5, boolean z2, int i6, boolean z3) {
        j(i3, 0, "bufferForPlaybackMs", "0");
        j(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        j(i, i3, "minBufferMs", "bufferForPlaybackMs");
        j(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        j(i2, i, "maxBufferMs", "minBufferMs");
        j(i6, 0, "backBufferDurationMs", "0");
        this.a = oVar;
        this.f1318b = b.i.a.c.f3.e0.B(i);
        this.c = b.i.a.c.f3.e0.B(i2);
        this.d = b.i.a.c.f3.e0.B(i3);
        this.e = b.i.a.c.f3.e0.B(i4);
        this.f = i5;
        this.j = i5 == -1 ? 13107200 : i5;
        this.g = z2;
        this.h = b.i.a.c.f3.e0.B(i6);
        this.i = z3;
    }

    public static void j(int i, int i2, String str, String str2) {
        boolean z2 = i >= i2;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 21);
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        b.c.a.a0.d.m(z2, sb.toString());
    }

    @Override // b.i.a.c.n1
    public boolean a() {
        return this.i;
    }

    @Override // b.i.a.c.n1
    public long b() {
        return this.h;
    }

    @Override // b.i.a.c.n1
    public void c() {
        k(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // b.i.a.c.n1
    public void d(f2[] f2VarArr, b.i.a.c.a3.o0 o0Var, b.i.a.c.c3.j[] jVarArr) {
        int iMax = this.f;
        if (iMax == -1) {
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 13107200;
                if (i < f2VarArr.length) {
                    if (jVarArr[i] != null) {
                        switch (f2VarArr[i].x()) {
                            case -2:
                                i3 = 0;
                                i2 += i3;
                                break;
                            case -1:
                            default:
                                throw new IllegalArgumentException();
                            case 0:
                                i3 = 144310272;
                                i2 += i3;
                                break;
                            case 1:
                                i2 += i3;
                                break;
                            case 2:
                                i3 = 131072000;
                                i2 += i3;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                i3 = 131072;
                                i2 += i3;
                                break;
                        }
                    }
                    i++;
                } else {
                    iMax = Math.max(13107200, i2);
                }
            }
        }
        this.j = iMax;
        this.a.b(iMax);
    }

    @Override // b.i.a.c.n1
    public void e() {
        k(true);
    }

    @Override // b.i.a.c.n1
    public boolean f(long j, float f, boolean z2, long j2) {
        int i;
        int i2 = b.i.a.c.f3.e0.a;
        if (f != 1.0f) {
            j = Math.round(j / ((double) f));
        }
        long jMin = z2 ? this.e : this.d;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        if (jMin > 0 && j < jMin) {
            if (!this.g) {
                b.i.a.c.e3.o oVar = this.a;
                synchronized (oVar) {
                    i = oVar.e * oVar.f944b;
                }
                if (i >= this.j) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // b.i.a.c.n1
    public boolean g(long j, long j2, float f) {
        int i;
        b.i.a.c.e3.o oVar = this.a;
        synchronized (oVar) {
            i = oVar.e * oVar.f944b;
        }
        boolean z2 = true;
        boolean z3 = i >= this.j;
        long jMin = this.f1318b;
        if (f > 1.0f) {
            jMin = Math.min(b.i.a.c.f3.e0.q(jMin, f), this.c);
        }
        if (j2 < Math.max(jMin, 500000L)) {
            if (!this.g && z3) {
                z2 = false;
            }
            this.k = z2;
            if (!z2 && j2 < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.c || z3) {
            this.k = false;
        }
        return this.k;
    }

    @Override // b.i.a.c.n1
    public b.i.a.c.e3.o h() {
        return this.a;
    }

    @Override // b.i.a.c.n1
    public void i() {
        k(true);
    }

    public final void k(boolean z2) {
        int i = this.f;
        if (i == -1) {
            i = 13107200;
        }
        this.j = i;
        this.k = false;
        if (z2) {
            b.i.a.c.e3.o oVar = this.a;
            synchronized (oVar) {
                if (oVar.a) {
                    oVar.b(0);
                }
            }
        }
    }
}
