package p007b.p225i.p414e.p434s.p436c;

import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p414e.InterfaceC4957l;
import p007b.p225i.p414e.p418n.C4963b;

/* JADX INFO: renamed from: b.i.e.s.c.b */
/* JADX INFO: compiled from: AlignmentPatternFinder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5060b {

    /* JADX INFO: renamed from: a */
    public final C4963b f13559a;

    /* JADX INFO: renamed from: c */
    public final int f13561c;

    /* JADX INFO: renamed from: d */
    public final int f13562d;

    /* JADX INFO: renamed from: e */
    public final int f13563e;

    /* JADX INFO: renamed from: f */
    public final int f13564f;

    /* JADX INFO: renamed from: g */
    public final float f13565g;

    /* JADX INFO: renamed from: i */
    public final InterfaceC4957l f13567i;

    /* JADX INFO: renamed from: b */
    public final List<C5059a> f13560b = new ArrayList(5);

    /* JADX INFO: renamed from: h */
    public final int[] f13566h = new int[3];

    public C5060b(C4963b c4963b, int i, int i2, int i3, int i4, float f, InterfaceC4957l interfaceC4957l) {
        this.f13559a = c4963b;
        this.f13561c = i;
        this.f13562d = i2;
        this.f13563e = i3;
        this.f13564f = i4;
        this.f13565g = f;
        this.f13567i = interfaceC4957l;
    }

    /* JADX INFO: renamed from: a */
    public static float m7106a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m7107b(int[] iArr) {
        float f = this.f13565g;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:63:0x00fd  */
    /* JADX INFO: renamed from: c */
    public final C5059a m7108c(int[] iArr, int i, int i2) {
        boolean z2;
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fM7106a = m7106a(iArr, i2);
        int i4 = (int) fM7106a;
        int i5 = iArr[1] * 2;
        C4963b c4963b = this.f13559a;
        int i6 = c4963b.f13230k;
        int[] iArr2 = this.f13566h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        int i7 = i;
        while (i7 >= 0 && c4963b.m6942f(i4, i7) && iArr2[1] <= i5) {
            iArr2[1] = iArr2[1] + 1;
            i7--;
        }
        float fM7106a2 = Float.NaN;
        if (i7 >= 0 && iArr2[1] <= i5) {
            while (i7 >= 0 && !c4963b.m6942f(i4, i7) && iArr2[0] <= i5) {
                iArr2[0] = iArr2[0] + 1;
                i7--;
            }
            if (iArr2[0] <= i5) {
                int i8 = i + 1;
                while (i8 < i6 && c4963b.m6942f(i4, i8) && iArr2[1] <= i5) {
                    iArr2[1] = iArr2[1] + 1;
                    i8++;
                }
                if (i8 != i6 && iArr2[1] <= i5) {
                    while (i8 < i6 && !c4963b.m6942f(i4, i8) && iArr2[2] <= i5) {
                        iArr2[2] = iArr2[2] + 1;
                        i8++;
                    }
                    if (iArr2[2] <= i5 && Math.abs(((iArr2[0] + iArr2[1]) + iArr2[2]) - i3) * 5 < i3 * 2 && m7107b(iArr2)) {
                        fM7106a2 = m7106a(iArr2, i8);
                    }
                }
            }
        }
        if (Float.isNaN(fM7106a2)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (C5059a c5059a : this.f13560b) {
            if (Math.abs(fM7106a2 - c5059a.f13208b) > f || Math.abs(fM7106a - c5059a.f13207a) > f) {
                z2 = false;
            } else {
                float fAbs = Math.abs(f - c5059a.f13558c);
                if (fAbs <= 1.0f || fAbs <= c5059a.f13558c) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                return new C5059a((c5059a.f13207a + fM7106a) / 2.0f, (c5059a.f13208b + fM7106a2) / 2.0f, (c5059a.f13558c + f) / 2.0f);
            }
        }
        C5059a c5059a2 = new C5059a(fM7106a, fM7106a2, f);
        this.f13560b.add(c5059a2);
        InterfaceC4957l interfaceC4957l = this.f13567i;
        if (interfaceC4957l == null) {
            return null;
        }
        interfaceC4957l.m6924a(c5059a2);
        return null;
    }
}
