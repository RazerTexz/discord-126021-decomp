package b.i.e.r.d;

import b.i.e.k;
import java.util.Formatter;

/* JADX INFO: compiled from: DetectionResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g[] f1880b;
    public c c;
    public final int d;

    public f(a aVar, c cVar) {
        this.a = aVar;
        int i = aVar.a;
        this.d = i;
        this.c = cVar;
        this.f1880b = new g[i + 2];
    }

    public static int b(int i, int i2, d dVar) {
        if (dVar.a()) {
            return i2;
        }
        if (!(i != -1 && dVar.c == (i % 3) * 3)) {
            return i2 + 1;
        }
        dVar.e = i;
        return 0;
    }

    public final void a(g gVar) {
        int i;
        if (gVar != null) {
            h hVar = (h) gVar;
            a aVar = this.a;
            d[] dVarArr = hVar.f1881b;
            for (d dVar : dVarArr) {
                if (dVar != null) {
                    dVar.b();
                }
            }
            hVar.d(dVarArr, aVar);
            c cVar = hVar.a;
            boolean z2 = hVar.c;
            k kVar = z2 ? cVar.f1877b : cVar.d;
            k kVar2 = z2 ? cVar.c : cVar.e;
            int iB = hVar.b((int) kVar.f1826b);
            int iB2 = hVar.b((int) kVar2.f1826b);
            int i2 = -1;
            int i3 = 0;
            int i4 = 1;
            while (iB < iB2) {
                if (dVarArr[iB] != null) {
                    d dVar2 = dVarArr[iB];
                    int i5 = dVar2.e;
                    int i6 = i5 - i2;
                    if (i6 == 0) {
                        i3++;
                    } else {
                        if (i6 == 1) {
                            int iMax = Math.max(i4, i3);
                            i = dVar2.e;
                            i4 = iMax;
                        } else if (i6 < 0 || i5 >= aVar.e || i6 > iB) {
                            dVarArr[iB] = null;
                        } else {
                            if (i4 > 2) {
                                i6 *= i4 - 2;
                            }
                            boolean z3 = i6 >= iB;
                            for (int i7 = 1; i7 <= i6 && !z3; i7++) {
                                z3 = dVarArr[iB - i7] != null;
                            }
                            if (z3) {
                                dVarArr[iB] = null;
                            } else {
                                i = dVar2.e;
                            }
                        }
                        i2 = i;
                        i3 = 1;
                    }
                }
                iB++;
            }
        }
    }

    public String toString() {
        g[] gVarArr = this.f1880b;
        g gVar = gVarArr[0];
        if (gVar == null) {
            gVar = gVarArr[this.d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < gVar.f1881b.length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.d + 2; i2++) {
                    g[] gVarArr2 = this.f1880b;
                    if (gVarArr2[i2] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        d dVar = gVarArr2[i2].f1881b[i];
                        if (dVar == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(dVar.e), Integer.valueOf(dVar.d));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
