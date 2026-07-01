package b.i.e.r.d;

import b.i.e.ResultPoint;
import b.i.e.n.BitMatrix;
import b.i.e.r.PDF417Common;
import b.i.e.r.d.k.ErrorCorrection;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.r.d.j, reason: use source file name */
/* JADX INFO: compiled from: PDF417ScanningDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PDF417ScanningDecoder {
    public static final ErrorCorrection a = new ErrorCorrection();

    public static BoundingBox a(DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn) throws NotFoundException {
        int[] iArr;
        int i;
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        ResultPoint resultPoint4;
        if (detectionResultRowIndicatorColumn == null) {
            return null;
        }
        BarcodeMetadata barcodeMetadataC = detectionResultRowIndicatorColumn.c();
        if (barcodeMetadataC == null) {
            iArr = null;
        } else {
            BoundingBox boundingBox = detectionResultRowIndicatorColumn.a;
            boolean z2 = detectionResultRowIndicatorColumn.c;
            ResultPoint resultPoint5 = z2 ? boundingBox.f1877b : boundingBox.d;
            ResultPoint resultPoint6 = z2 ? boundingBox.c : boundingBox.e;
            int iB = detectionResultRowIndicatorColumn.b((int) resultPoint6.f1826b);
            Codeword[] codewordArr = detectionResultRowIndicatorColumn.f1881b;
            int i2 = -1;
            int i3 = 0;
            int iMax = 1;
            for (int iB2 = detectionResultRowIndicatorColumn.b((int) resultPoint5.f1826b); iB2 < iB; iB2++) {
                if (codewordArr[iB2] != null) {
                    Codeword codeword = codewordArr[iB2];
                    codeword.b();
                    int i4 = codeword.e;
                    int i5 = i4 - i2;
                    if (i5 == 0) {
                        i3++;
                    } else {
                        if (i5 == 1) {
                            iMax = Math.max(iMax, i3);
                            i2 = codeword.e;
                        } else if (i4 >= barcodeMetadataC.e) {
                            codewordArr[iB2] = null;
                        } else {
                            i2 = i4;
                        }
                        i3 = 1;
                    }
                }
            }
            int i6 = barcodeMetadataC.e;
            iArr = new int[i6];
            for (Codeword codeword2 : detectionResultRowIndicatorColumn.f1881b) {
                if (codeword2 != null && (i = codeword2.e) < i6) {
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
        Codeword[] codewordArr2 = detectionResultRowIndicatorColumn.f1881b;
        for (int i10 = 0; i8 > 0 && codewordArr2[i10] == null; i10++) {
            i8--;
        }
        int i11 = 0;
        for (int length = iArr.length - 1; length >= 0; length--) {
            i11 += iMax2 - iArr[length];
            if (iArr[length] > 0) {
                break;
            }
        }
        for (int length2 = codewordArr2.length - 1; i11 > 0 && codewordArr2[length2] == null; length2--) {
            i11--;
        }
        BoundingBox boundingBox2 = detectionResultRowIndicatorColumn.a;
        boolean z3 = detectionResultRowIndicatorColumn.c;
        ResultPoint resultPoint7 = boundingBox2.f1877b;
        ResultPoint resultPoint8 = boundingBox2.c;
        ResultPoint resultPoint9 = boundingBox2.d;
        ResultPoint resultPoint10 = boundingBox2.e;
        if (i8 <= 0) {
            resultPoint = resultPoint7;
            resultPoint2 = resultPoint9;
        } else {
            ResultPoint resultPoint11 = z3 ? resultPoint7 : resultPoint9;
            int i12 = ((int) resultPoint11.f1826b) - i8;
            ResultPoint resultPoint12 = new ResultPoint(resultPoint11.a, i12 >= 0 ? i12 : 0);
            if (z3) {
                resultPoint7 = resultPoint12;
                resultPoint = resultPoint7;
                resultPoint2 = resultPoint9;
            } else {
                resultPoint = resultPoint7;
                resultPoint2 = resultPoint12;
            }
        }
        if (i11 <= 0) {
            resultPoint3 = resultPoint8;
            resultPoint4 = resultPoint10;
        } else {
            ResultPoint resultPoint13 = z3 ? resultPoint8 : resultPoint10;
            int i13 = ((int) resultPoint13.f1826b) + i11;
            int i14 = boundingBox2.a.k;
            if (i13 >= i14) {
                i13 = i14 - 1;
            }
            ResultPoint resultPoint14 = new ResultPoint(resultPoint13.a, i13);
            if (z3) {
                resultPoint8 = resultPoint14;
                resultPoint3 = resultPoint8;
                resultPoint4 = resultPoint10;
            } else {
                resultPoint4 = resultPoint14;
                resultPoint3 = resultPoint8;
            }
        }
        return new BoundingBox(boundingBox2.a, resultPoint, resultPoint3, resultPoint2, resultPoint4);
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
    public static b.i.e.n.DecoderResult b(int[] r25, int r26, int[] r27) throws com.google.zxing.FormatException, com.google.zxing.ChecksumException {
        /*
            Method dump skipped, instruction units count: 1272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.e.r.d.PDF417ScanningDecoder.b(int[], int, int[]):b.i.e.n.e");
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
    public static Codeword c(BitMatrix bitMatrix, int i, int i2, boolean z2, int i3, int i4, int i5, int i6) {
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
                    if (z3 == bitMatrix.f(i10, i4)) {
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
                    if (z3 == bitMatrix.f(i10, i4)) {
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
                if (bitMatrix.f(i13, i4) == z4) {
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
                if (bitMatrix.f(i13, i4) == z4) {
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
        int iH1 = b.i.a.f.e.o.f.h1(iArr);
        if (z2) {
            i7 = i10 + iH1;
        } else {
            for (int i15 = 0; i15 < iArr.length / 2; i15++) {
                int i16 = iArr[i15];
                iArr[i15] = iArr[(iArr.length - 1) - i15];
                iArr[(iArr.length - 1) - i15] = i16;
            }
            int i17 = i10;
            i10 -= iH1;
            i7 = i17;
        }
        if (!(i5 + (-2) <= iH1 && iH1 <= i6 + 2)) {
            return null;
        }
        float[][] fArr = PDF417CodewordDecoder.a;
        float fH1 = b.i.a.f.e.o.f.h1(iArr);
        int[] iArr2 = new int[8];
        int i18 = 0;
        int i19 = 0;
        for (int i20 = 0; i20 < 17; i20++) {
            if (iArr[i18] + i19 <= ((i20 * fH1) / 17.0f) + (fH1 / 34.0f)) {
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
        if (PDF417Common.a(i23) == -1) {
            i23 = -1;
        }
        if (i23 == -1) {
            int iH2 = b.i.a.f.e.o.f.h1(iArr);
            float[] fArr2 = new float[8];
            if (iH2 > 1) {
                for (int i24 = 0; i24 < 8; i24++) {
                    fArr2[i24] = iArr[i24] / iH2;
                }
            }
            float f = Float.MAX_VALUE;
            int i25 = -1;
            int i26 = 0;
            while (true) {
                float[][] fArr3 = PDF417CodewordDecoder.a;
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
                    i25 = PDF417Common.f1875b[i26];
                    f = f2;
                }
                i26++;
            }
            i23 = i25;
        }
        int iA = PDF417Common.a(i23);
        if (iA == -1) {
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
                    return new Codeword(i10, i7, ((((iArr3[0] - iArr3[2]) + iArr3[4]) - iArr3[6]) + 9) % 9, iA);
                }
                i30 = i31;
            }
            iArr3[i29] = iArr3[i29] + 1;
            i28 >>= 1;
        }
    }

    public static DetectionResultRowIndicatorColumn d(BitMatrix bitMatrix, BoundingBox boundingBox, ResultPoint resultPoint, boolean z2, int i, int i2) {
        DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = new DetectionResultRowIndicatorColumn(boundingBox, z2);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int i5 = (int) resultPoint.a;
            for (int i6 = (int) resultPoint.f1826b; i6 <= boundingBox.i && i6 >= boundingBox.h; i6 += i4) {
                Codeword codewordC = c(bitMatrix, 0, bitMatrix.j, z2, i5, i6, i, i2);
                if (codewordC != null) {
                    detectionResultRowIndicatorColumn.f1881b[i6 - detectionResultRowIndicatorColumn.a.h] = codewordC;
                    i5 = z2 ? codewordC.a : codewordC.f1878b;
                }
            }
            i3++;
        }
        return detectionResultRowIndicatorColumn;
    }

    public static boolean e(DetectionResult detectionResult, int i) {
        return i >= 0 && i <= detectionResult.d + 1;
    }
}
