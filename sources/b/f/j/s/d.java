package b.f.j.s;

import java.util.Collections;

/* JADX INFO: compiled from: JpegTranscoderUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class d {
    public static final b.f.d.d.e<Integer> a;

    static {
        b.f.d.d.e<Integer> eVar = new b.f.d.d.e<>(4);
        Collections.addAll(eVar, 2, 7, 4, 5);
        a = eVar;
    }

    public static int a(b.f.j.d.f fVar, b.f.j.j.e eVar) {
        eVar.x();
        int i = eVar.n;
        b.f.d.d.e<Integer> eVar2 = a;
        int iIndexOf = eVar2.indexOf(Integer.valueOf(i));
        if (iIndexOf >= 0) {
            return eVar2.get((((fVar.c() ? 0 : fVar.a()) / 90) + iIndexOf) % eVar2.size()).intValue();
        }
        throw new IllegalArgumentException("Only accepts inverted exif orientations");
    }

    public static int b(b.f.j.d.f fVar, b.f.j.j.e eVar) {
        int i = 0;
        if (!fVar.b()) {
            return 0;
        }
        eVar.x();
        int i2 = eVar.m;
        if (i2 == 90 || i2 == 180 || i2 == 270) {
            eVar.x();
            i = eVar.m;
        }
        return fVar.c() ? i : (fVar.a() + i) % 360;
    }

    public static int c(b.f.j.d.f fVar, b.f.j.d.e eVar, b.f.j.j.e eVar2, boolean z2) {
        int i;
        int i2;
        if (!z2 || eVar == null) {
            return 8;
        }
        int iB = b(fVar, eVar2);
        b.f.d.d.e<Integer> eVar3 = a;
        eVar2.x();
        int iA = eVar3.contains(Integer.valueOf(eVar2.n)) ? a(fVar, eVar2) : 0;
        boolean z3 = iB == 90 || iB == 270 || iA == 5 || iA == 7;
        if (z3) {
            eVar2.x();
            i = eVar2.p;
        } else {
            eVar2.x();
            i = eVar2.o;
        }
        if (z3) {
            eVar2.x();
            i2 = eVar2.o;
        } else {
            eVar2.x();
            i2 = eVar2.p;
        }
        float f = i;
        float f2 = i2;
        float fMax = Math.max(eVar.a / f, eVar.f566b / f2);
        float f3 = f * fMax;
        float f4 = eVar.c;
        if (f3 > f4) {
            fMax = f4 / f;
        }
        if (f2 * fMax > f4) {
            fMax = f4 / f2;
        }
        int i3 = (int) ((fMax * 8.0f) + eVar.d);
        if (i3 > 8) {
            return 8;
        }
        if (i3 < 1) {
            return 1;
        }
        return i3;
    }
}
