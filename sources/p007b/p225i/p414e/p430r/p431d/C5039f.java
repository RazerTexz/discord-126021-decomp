package p007b.p225i.p414e.p430r.p431d;

import java.util.Formatter;
import p007b.p225i.p414e.C4956k;

/* JADX INFO: renamed from: b.i.e.r.d.f */
/* JADX INFO: compiled from: DetectionResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5039f {

    /* JADX INFO: renamed from: a */
    public final C5034a f13487a;

    /* JADX INFO: renamed from: b */
    public final C5040g[] f13488b;

    /* JADX INFO: renamed from: c */
    public C5036c f13489c;

    /* JADX INFO: renamed from: d */
    public final int f13490d;

    public C5039f(C5034a c5034a, C5036c c5036c) {
        this.f13487a = c5034a;
        int i = c5034a.f13464a;
        this.f13490d = i;
        this.f13489c = c5036c;
        this.f13488b = new C5040g[i + 2];
    }

    /* JADX INFO: renamed from: b */
    public static int m7055b(int i, int i2, C5037d c5037d) {
        if (c5037d.m7050a()) {
            return i2;
        }
        if (!(i != -1 && c5037d.f13481c == (i % 3) * 3)) {
            return i2 + 1;
        }
        c5037d.f13483e = i;
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m7056a(C5040g c5040g) {
        int i;
        if (c5040g != null) {
            C5041h c5041h = (C5041h) c5040g;
            C5034a c5034a = this.f13487a;
            C5037d[] c5037dArr = c5041h.f13492b;
            for (C5037d c5037d : c5037dArr) {
                if (c5037d != null) {
                    c5037d.m7051b();
                }
            }
            c5041h.m7060d(c5037dArr, c5034a);
            C5036c c5036c = c5041h.f13491a;
            boolean z2 = c5041h.f13493c;
            C4956k c4956k = z2 ? c5036c.f13471b : c5036c.f13473d;
            C4956k c4956k2 = z2 ? c5036c.f13472c : c5036c.f13474e;
            int iM7058b = c5041h.m7058b((int) c4956k.f13208b);
            int iM7058b2 = c5041h.m7058b((int) c4956k2.f13208b);
            int i2 = -1;
            int i3 = 0;
            int i4 = 1;
            while (iM7058b < iM7058b2) {
                if (c5037dArr[iM7058b] != null) {
                    C5037d c5037d2 = c5037dArr[iM7058b];
                    int i5 = c5037d2.f13483e;
                    int i6 = i5 - i2;
                    if (i6 == 0) {
                        i3++;
                    } else {
                        if (i6 == 1) {
                            int iMax = Math.max(i4, i3);
                            i = c5037d2.f13483e;
                            i4 = iMax;
                        } else if (i6 < 0 || i5 >= c5034a.f13468e || i6 > iM7058b) {
                            c5037dArr[iM7058b] = null;
                        } else {
                            if (i4 > 2) {
                                i6 *= i4 - 2;
                            }
                            boolean z3 = i6 >= iM7058b;
                            for (int i7 = 1; i7 <= i6 && !z3; i7++) {
                                z3 = c5037dArr[iM7058b - i7] != null;
                            }
                            if (z3) {
                                c5037dArr[iM7058b] = null;
                            } else {
                                i = c5037d2.f13483e;
                            }
                        }
                        i2 = i;
                        i3 = 1;
                    }
                }
                iM7058b++;
            }
        }
    }

    public String toString() {
        C5040g[] c5040gArr = this.f13488b;
        C5040g c5040g = c5040gArr[0];
        if (c5040g == null) {
            c5040g = c5040gArr[this.f13490d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < c5040g.f13492b.length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.f13490d + 2; i2++) {
                    C5040g[] c5040gArr2 = this.f13488b;
                    if (c5040gArr2[i2] == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        C5037d c5037d = c5040gArr2[i2].f13492b[i];
                        if (c5037d == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(c5037d.f13483e), Integer.valueOf(c5037d.f13482d));
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
