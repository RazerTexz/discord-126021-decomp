package p007b.p225i.p414e.p418n.p419k;

import com.google.zxing.NotFoundException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.p418n.C4963b;

/* JADX INFO: renamed from: b.i.e.n.k.a */
/* JADX INFO: compiled from: WhiteRectangleDetector.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4972a {

    /* JADX INFO: renamed from: a */
    public final C4963b f13292a;

    /* JADX INFO: renamed from: b */
    public final int f13293b;

    /* JADX INFO: renamed from: c */
    public final int f13294c;

    /* JADX INFO: renamed from: d */
    public final int f13295d;

    /* JADX INFO: renamed from: e */
    public final int f13296e;

    /* JADX INFO: renamed from: f */
    public final int f13297f;

    /* JADX INFO: renamed from: g */
    public final int f13298g;

    public C4972a(C4963b c4963b, int i, int i2, int i3) throws NotFoundException {
        this.f13292a = c4963b;
        int i4 = c4963b.f13230k;
        this.f13293b = i4;
        int i5 = c4963b.f13229j;
        this.f13294c = i5;
        int i6 = i / 2;
        int i7 = i2 - i6;
        this.f13295d = i7;
        int i8 = i2 + i6;
        this.f13296e = i8;
        int i9 = i3 - i6;
        this.f13298g = i9;
        int i10 = i3 + i6;
        this.f13297f = i10;
        if (i9 < 0 || i7 < 0 || i10 >= i4 || i8 >= i5) {
            throw NotFoundException.f21665l;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m6956a(int i, int i2, int i3, boolean z2) {
        if (z2) {
            while (i <= i2) {
                if (this.f13292a.m6942f(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f13292a.m6942f(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public C4956k[] m6957b() throws NotFoundException {
        boolean z2;
        int i = this.f13295d;
        int i2 = this.f13296e;
        int i3 = this.f13298g;
        int i4 = this.f13297f;
        boolean z3 = true;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        while (true) {
            if (!z3) {
                z2 = false;
                break;
            }
            boolean zM6956a = true;
            boolean z9 = false;
            while (true) {
                if ((!zM6956a && z4) || i2 >= this.f13294c) {
                    break;
                }
                zM6956a = m6956a(i3, i4, i2, false);
                if (zM6956a) {
                    i2++;
                    z4 = true;
                    z9 = true;
                } else if (!z4) {
                    i2++;
                }
            }
            if (i2 < this.f13294c) {
                boolean zM6956a2 = true;
                while (true) {
                    if ((!zM6956a2 && z5) || i4 >= this.f13293b) {
                        break;
                    }
                    zM6956a2 = m6956a(i, i2, i4, true);
                    if (zM6956a2) {
                        i4++;
                        z5 = true;
                        z9 = true;
                    } else if (!z5) {
                        i4++;
                    }
                }
                if (i4 < this.f13293b) {
                    boolean zM6956a3 = true;
                    while (true) {
                        if ((!zM6956a3 && z6) || i < 0) {
                            break;
                        }
                        zM6956a3 = m6956a(i3, i4, i, false);
                        if (zM6956a3) {
                            i--;
                            z6 = true;
                            z9 = true;
                        } else if (!z6) {
                            i--;
                        }
                    }
                    if (i >= 0) {
                        z3 = z9;
                        boolean zM6956a4 = true;
                        while (true) {
                            if ((!zM6956a4 && z8) || i3 < 0) {
                                break;
                            }
                            zM6956a4 = m6956a(i, i2, i3, true);
                            if (zM6956a4) {
                                i3--;
                                z3 = true;
                                z8 = true;
                            } else if (!z8) {
                                i3--;
                            }
                        }
                        if (i3 >= 0) {
                            if (z3) {
                                z7 = true;
                            }
                        }
                    }
                }
            }
            z2 = true;
            break;
        }
        if (z2 || !z7) {
            throw NotFoundException.f21665l;
        }
        int i5 = i2 - i;
        C4956k c4956kM6958c = null;
        C4956k c4956kM6958c2 = null;
        for (int i6 = 1; c4956kM6958c2 == null && i6 < i5; i6++) {
            c4956kM6958c2 = m6958c(i, i4 - i6, i + i6, i4);
        }
        if (c4956kM6958c2 == null) {
            throw NotFoundException.f21665l;
        }
        C4956k c4956kM6958c3 = null;
        for (int i7 = 1; c4956kM6958c3 == null && i7 < i5; i7++) {
            c4956kM6958c3 = m6958c(i, i3 + i7, i + i7, i3);
        }
        if (c4956kM6958c3 == null) {
            throw NotFoundException.f21665l;
        }
        C4956k c4956kM6958c4 = null;
        for (int i8 = 1; c4956kM6958c4 == null && i8 < i5; i8++) {
            c4956kM6958c4 = m6958c(i2, i3 + i8, i2 - i8, i3);
        }
        if (c4956kM6958c4 == null) {
            throw NotFoundException.f21665l;
        }
        for (int i9 = 1; c4956kM6958c == null && i9 < i5; i9++) {
            c4956kM6958c = m6958c(i2, i4 - i9, i2 - i9, i4);
        }
        if (c4956kM6958c == null) {
            throw NotFoundException.f21665l;
        }
        float f = c4956kM6958c.f13207a;
        float f2 = c4956kM6958c.f13208b;
        float f3 = c4956kM6958c2.f13207a;
        float f4 = c4956kM6958c2.f13208b;
        float f5 = c4956kM6958c4.f13207a;
        float f6 = c4956kM6958c4.f13208b;
        float f7 = c4956kM6958c3.f13207a;
        float f8 = c4956kM6958c3.f13208b;
        return f < ((float) this.f13294c) / 2.0f ? new C4956k[]{new C4956k(f7 - 1.0f, f8 + 1.0f), new C4956k(f3 + 1.0f, f4 + 1.0f), new C4956k(f5 - 1.0f, f6 - 1.0f), new C4956k(f + 1.0f, f2 - 1.0f)} : new C4956k[]{new C4956k(f7 + 1.0f, f8 + 1.0f), new C4956k(f3 + 1.0f, f4 - 1.0f), new C4956k(f5 - 1.0f, f6 + 1.0f), new C4956k(f - 1.0f, f2 - 1.0f)};
    }

    /* JADX INFO: renamed from: c */
    public final C4956k m6958c(float f, float f2, float f3, float f4) {
        int iM4265Z0 = C3404f.m4265Z0(C3404f.m4237Q(f, f2, f3, f4));
        float f5 = iM4265Z0;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iM4265Z0; i++) {
            float f8 = i;
            int iM4265Z1 = C3404f.m4265Z0((f8 * f6) + f);
            int iM4265Z2 = C3404f.m4265Z0((f8 * f7) + f2);
            if (this.f13292a.m6942f(iM4265Z1, iM4265Z2)) {
                return new C4956k(iM4265Z1, iM4265Z2);
            }
        }
        return null;
    }
}
