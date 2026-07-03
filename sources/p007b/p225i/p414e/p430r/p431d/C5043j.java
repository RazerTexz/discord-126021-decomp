package p007b.p225i.p414e.p430r.p431d;

import com.google.zxing.NotFoundException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p430r.C5031a;
import p007b.p225i.p414e.p430r.p431d.p432k.C5044a;

/* JADX INFO: renamed from: b.i.e.r.d.j */
/* JADX INFO: compiled from: PDF417ScanningDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5043j {

    /* JADX INFO: renamed from: a */
    public static final C5044a f13495a = new C5044a();

    /* JADX INFO: renamed from: a */
    public static C5036c m7061a(C5041h c5041h) throws NotFoundException {
        int[] iArr;
        int i;
        C4956k c4956k;
        C4956k c4956k2;
        C4956k c4956k3;
        C4956k c4956k4;
        if (c5041h == null) {
            return null;
        }
        C5034a c5034aM7059c = c5041h.m7059c();
        if (c5034aM7059c == null) {
            iArr = null;
        } else {
            C5036c c5036c = c5041h.f13491a;
            boolean z2 = c5041h.f13493c;
            C4956k c4956k5 = z2 ? c5036c.f13471b : c5036c.f13473d;
            C4956k c4956k6 = z2 ? c5036c.f13472c : c5036c.f13474e;
            int iM7058b = c5041h.m7058b((int) c4956k6.f13208b);
            C5037d[] c5037dArr = c5041h.f13492b;
            int i2 = -1;
            int i3 = 0;
            int iMax = 1;
            for (int iM7058b2 = c5041h.m7058b((int) c4956k5.f13208b); iM7058b2 < iM7058b; iM7058b2++) {
                if (c5037dArr[iM7058b2] != null) {
                    C5037d c5037d = c5037dArr[iM7058b2];
                    c5037d.m7051b();
                    int i4 = c5037d.f13483e;
                    int i5 = i4 - i2;
                    if (i5 == 0) {
                        i3++;
                    } else {
                        if (i5 == 1) {
                            iMax = Math.max(iMax, i3);
                            i2 = c5037d.f13483e;
                        } else if (i4 >= c5034aM7059c.f13468e) {
                            c5037dArr[iM7058b2] = null;
                        } else {
                            i2 = i4;
                        }
                        i3 = 1;
                    }
                }
            }
            int i6 = c5034aM7059c.f13468e;
            iArr = new int[i6];
            for (C5037d c5037d2 : c5041h.f13492b) {
                if (c5037d2 != null && (i = c5037d2.f13483e) < i6) {
                    iArr[i] = iArr[i] + 1;
                }
            }
        }
        if (iArr == null) {
            return null;
        }
        int iMax2 = -1;
        for (int i7 : iArr) {
            iMax2 = Math.max(iMax2, i7);
        }
        int i8 = 0;
        for (int i9 : iArr) {
            i8 += iMax2 - i9;
            if (i9 > 0) {
                break;
            }
        }
        C5037d[] c5037dArr2 = c5041h.f13492b;
        for (int i10 = 0; i8 > 0 && c5037dArr2[i10] == null; i10++) {
            i8--;
        }
        int i11 = 0;
        for (int length = iArr.length - 1; length >= 0; length--) {
            i11 += iMax2 - iArr[length];
            if (iArr[length] > 0) {
                break;
            }
        }
        for (int length2 = c5037dArr2.length - 1; i11 > 0 && c5037dArr2[length2] == null; length2--) {
            i11--;
        }
        C5036c c5036c2 = c5041h.f13491a;
        boolean z3 = c5041h.f13493c;
        C4956k c4956k7 = c5036c2.f13471b;
        C4956k c4956k8 = c5036c2.f13472c;
        C4956k c4956k9 = c5036c2.f13473d;
        C4956k c4956k10 = c5036c2.f13474e;
        if (i8 <= 0) {
            c4956k = c4956k7;
            c4956k2 = c4956k9;
        } else {
            C4956k c4956k11 = z3 ? c4956k7 : c4956k9;
            int i12 = ((int) c4956k11.f13208b) - i8;
            C4956k c4956k12 = new C4956k(c4956k11.f13207a, i12 >= 0 ? i12 : 0);
            if (z3) {
                c4956k7 = c4956k12;
                c4956k = c4956k7;
                c4956k2 = c4956k9;
            } else {
                c4956k = c4956k7;
                c4956k2 = c4956k12;
            }
        }
        if (i11 <= 0) {
            c4956k3 = c4956k8;
            c4956k4 = c4956k10;
        } else {
            C4956k c4956k13 = z3 ? c4956k8 : c4956k10;
            int i13 = ((int) c4956k13.f13208b) + i11;
            int i14 = c5036c2.f13470a.f13230k;
            if (i13 >= i14) {
                i13 = i14 - 1;
            }
            C4956k c4956k14 = new C4956k(c4956k13.f13207a, i13);
            if (z3) {
                c4956k8 = c4956k14;
                c4956k3 = c4956k8;
                c4956k4 = c4956k10;
            } else {
                c4956k4 = c4956k14;
                c4956k3 = c4956k8;
            }
        }
        return new C5036c(c5036c2.f13470a, c4956k, c4956k3, c4956k2, c4956k4);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:100:0x024e  */
    /* JADX WARN: Code duplicated, block: B:145:0x037c  */
    /* JADX WARN: Code duplicated, block: B:148:0x0381  */
    /* JADX WARN: Code duplicated, block: B:163:0x03ad A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:256:0x03c4 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Failed to find 'out' block for switch in B:177:0x03f2. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:178:0x03f5. Please report as an issue. */
    /* JADX WARN: Switch 'out' block B:172:0x03d9 for B:177:0x03f2 already processed. Defaulting to fallback option. */
    /* JADX WARN: Switch 'out' block B:172:0x03d9 for B:178:0x03f5 already processed. Defaulting to fallback option. */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x0294 -> B:113:0x0295). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:151:0x0389
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:590)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:82)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:127)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:75)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:115)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX INFO: renamed from: b */
    public static p007b.p225i.p414e.p418n.C4966e m7062b(int[] r25, int r26, int[] r27) throws com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instruction units count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p007b.p225i.p414e.p430r.p431d.C5043j.m7062b(int[], int, int[]):b.i.e.n.e");
    }

    /* JADX WARN: Code duplicated, block: B:113:0x002d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:117:0x0032 A[EDGE_INSN: B:117:0x0032->B:19:0x0032 BREAK  A[LOOP:1: B:9:0x0018->B:18:0x0030], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:120:0x0060 A[EDGE_INSN: B:120:0x0060->B:34:0x0060 BREAK  A[LOOP:2: B:25:0x0045->B:123:0x0045], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:121:0x005b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:122:0x0054 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:13:0x001f  */
    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:18:0x0030 A[LOOP:1: B:9:0x0018->B:18:0x0030, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x004c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x004e  */
    /* JADX INFO: renamed from: c */
    public static C5037d m7063c(C4963b c4963b, int i, int i2, boolean z2, int i3, int i4, int i5, int i6) {
        int i7;
        int i8 = i;
        int i9 = z2 ? -1 : 1;
        boolean z3 = z2;
        int i10 = i3;
        loop0: for (int i11 = 0; i11 < 2; i11++) {
            while (true) {
                if (!z3) {
                    if (i10 >= i2) {
                        break;
                    }
                    if (z3 == c4963b.m6942f(i10, i4)) {
                        break;
                        break;
                    }
                    if (Math.abs(i3 - i10) > 2) {
                        i10 = i3;
                        break loop0;
                    }
                    i10 += i9;
                } else {
                    if (i10 < i8) {
                        break;
                    }
                    if (z3 == c4963b.m6942f(i10, i4)) {
                        break;
                    }
                    if (Math.abs(i3 - i10) > 2) {
                        i10 = i3;
                        break loop0;
                    }
                    i10 += i9;
                }
            }
            i9 = -i9;
            z3 = !z3;
        }
        int[] iArr = new int[8];
        int i12 = z2 ? 1 : -1;
        boolean z4 = z2;
        int i13 = i10;
        int i14 = 0;
        while (true) {
            if (!z2) {
                if (i13 < i8) {
                    break;
                }
                if (i14 < 8) {
                    break;
                    break;
                }
                if (c4963b.m6942f(i13, i4) == z4) {
                    iArr[i14] = iArr[i14] + 1;
                    i13 += i12;
                } else {
                    i14++;
                    z4 = !z4;
                }
            } else {
                if (i13 >= i2) {
                    break;
                }
                if (i14 < 8) {
                    break;
                }
                if (c4963b.m6942f(i13, i4) == z4) {
                    iArr[i14] = iArr[i14] + 1;
                    i13 += i12;
                } else {
                    i14++;
                    z4 = !z4;
                }
            }
        }
        if (i14 != 8) {
            if (z2) {
                i8 = i2;
            }
            if (i13 != i8 || i14 != 7) {
                iArr = null;
            }
        }
        if (iArr == null) {
            return null;
        }
        int iM4297h1 = C3404f.m4297h1(iArr);
        if (z2) {
            i7 = i10 + iM4297h1;
        } else {
            for (int i15 = 0; i15 < iArr.length / 2; i15++) {
                int i16 = iArr[i15];
                iArr[i15] = iArr[(iArr.length - 1) - i15];
                iArr[(iArr.length - 1) - i15] = i16;
            }
            int i17 = i10;
            i10 -= iM4297h1;
            i7 = i17;
        }
        if (!(i5 + (-2) <= iM4297h1 && iM4297h1 <= i6 + 2)) {
            return null;
        }
        float[][] fArr = C5042i.f13494a;
        float fM4297h1 = C3404f.m4297h1(iArr);
        int[] iArr2 = new int[8];
        int i18 = 0;
        int i19 = 0;
        for (int i20 = 0; i20 < 17; i20++) {
            if (iArr[i18] + i19 <= ((i20 * fM4297h1) / 17.0f) + (fM4297h1 / 34.0f)) {
                i19 += iArr[i18];
                i18++;
            }
            iArr2[i18] = iArr2[i18] + 1;
        }
        long j = 0;
        for (int i21 = 0; i21 < 8; i21++) {
            for (int i22 = 0; i22 < iArr2[i21]; i22++) {
                j = (j << 1) | ((long) (i21 % 2 == 0 ? 1 : 0));
            }
        }
        int i23 = (int) j;
        if (C5031a.m7044a(i23) == -1) {
            i23 = -1;
        }
        if (i23 == -1) {
            int iM4297h2 = C3404f.m4297h1(iArr);
            float[] fArr2 = new float[8];
            if (iM4297h2 > 1) {
                for (int i24 = 0; i24 < 8; i24++) {
                    fArr2[i24] = iArr[i24] / iM4297h2;
                }
            }
            float f = Float.MAX_VALUE;
            int i25 = -1;
            int i26 = 0;
            while (true) {
                float[][] fArr3 = C5042i.f13494a;
                if (i26 >= fArr3.length) {
                    break;
                }
                float f2 = 0.0f;
                float[] fArr4 = fArr3[i26];
                for (int i27 = 0; i27 < 8; i27++) {
                    float f3 = fArr4[i27] - fArr2[i27];
                    f2 += f3 * f3;
                    if (f2 >= f) {
                        break;
                    }
                }
                if (f2 < f) {
                    i25 = C5031a.f13461b[i26];
                    f = f2;
                }
                i26++;
            }
            i23 = i25;
        }
        int iM7044a = C5031a.m7044a(i23);
        if (iM7044a == -1) {
            return null;
        }
        int[] iArr3 = new int[8];
        int i28 = i23;
        int i29 = 7;
        int i30 = 0;
        while (true) {
            int i31 = i28 & 1;
            if (i31 != i30) {
                i29--;
                if (i29 < 0) {
                    return new C5037d(i10, i7, ((((iArr3[0] - iArr3[2]) + iArr3[4]) - iArr3[6]) + 9) % 9, iM7044a);
                }
                i30 = i31;
            }
            iArr3[i29] = iArr3[i29] + 1;
            i28 >>= 1;
        }
    }

    /* JADX INFO: renamed from: d */
    public static C5041h m7064d(C4963b c4963b, C5036c c5036c, C4956k c4956k, boolean z2, int i, int i2) {
        C5041h c5041h = new C5041h(c5036c, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int i5 = (int) c4956k.f13207a;
            for (int i6 = (int) c4956k.f13208b; i6 <= c5036c.f13478i && i6 >= c5036c.f13477h; i6 += i4) {
                C5037d c5037dM7063c = m7063c(c4963b, 0, c4963b.f13229j, z2, i5, i6, i, i2);
                if (c5037dM7063c != null) {
                    c5041h.f13492b[i6 - c5041h.f13491a.f13477h] = c5037dM7063c;
                    i5 = z2 ? c5037dM7063c.f13479a : c5037dM7063c.f13480b;
                }
            }
            i3++;
        }
        return c5041h;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m7065e(C5039f c5039f, int i) {
        return i >= 0 && i <= c5039f.f13490d + 1;
    }
}
