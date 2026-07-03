package p007b.p109f.p161j.p184s;

import java.util.Collections;
import p007b.p109f.p115d.p119d.C1682e;
import p007b.p109f.p161j.p169d.C1884e;
import p007b.p109f.p161j.p169d.C1885f;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.s.d */
/* JADX INFO: compiled from: JpegTranscoderUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2034d {

    /* JADX INFO: renamed from: a */
    public static final C1682e<Integer> f4268a;

    static {
        C1682e<Integer> c1682e = new C1682e<>(4);
        Collections.addAll(c1682e, 2, 7, 4, 5);
        f4268a = c1682e;
    }

    /* JADX INFO: renamed from: a */
    public static int m1532a(C1885f c1885f, C1919e c1919e) {
        c1919e.m1347x();
        int i = c1919e.f3895n;
        C1682e<Integer> c1682e = f4268a;
        int iIndexOf = c1682e.indexOf(Integer.valueOf(i));
        if (iIndexOf >= 0) {
            return c1682e.get((((c1885f.m1251c() ? 0 : c1885f.m1249a()) / 90) + iIndexOf) % c1682e.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    /* JADX INFO: renamed from: b */
    public static int m1533b(C1885f c1885f, C1919e c1919e) {
        int i = 0;
        if (!c1885f.m1250b()) {
            return 0;
        }
        c1919e.m1347x();
        int i2 = c1919e.f3894m;
        if (i2 == 90 || i2 == 180 || i2 == 270) {
            c1919e.m1347x();
            i = c1919e.f3894m;
        }
        return c1885f.m1251c() ? i : (c1885f.m1249a() + i) % 360;
    }

    /* JADX INFO: renamed from: c */
    public static int m1534c(C1885f c1885f, C1884e c1884e, C1919e c1919e, boolean z2) {
        int i;
        int i2;
        if (!z2 || c1884e == null) {
            return 8;
        }
        int iM1533b = m1533b(c1885f, c1919e);
        C1682e<Integer> c1682e = f4268a;
        c1919e.m1347x();
        int iM1532a = c1682e.contains(Integer.valueOf(c1919e.f3895n)) ? m1532a(c1885f, c1919e) : 0;
        boolean z3 = iM1533b == 90 || iM1533b == 270 || iM1532a == 5 || iM1532a == 7;
        if (z3) {
            c1919e.m1347x();
            i = c1919e.f3897p;
        } else {
            c1919e.m1347x();
            i = c1919e.f3896o;
        }
        if (z3) {
            c1919e.m1347x();
            i2 = c1919e.f3896o;
        } else {
            c1919e.m1347x();
            i2 = c1919e.f3897p;
        }
        float f = i;
        float f2 = i2;
        float fMax = Math.max(c1884e.f3717a / f, c1884e.f3718b / f2);
        float f3 = f * fMax;
        float f4 = c1884e.f3719c;
        if (f3 > f4) {
            fMax = f4 / f;
        }
        if (f2 * fMax > f4) {
            fMax = f4 / f2;
        }
        int i3 = (int) ((fMax * 8.0f) + c1884e.f3720d);
        if (i3 > 8) {
            return 8;
        }
        if (i3 < 1) {
            return 1;
        }
        return i3;
    }
}
