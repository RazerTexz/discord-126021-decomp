package b.i.e.r;

import b.i.e.BarcodeFormat;
import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.Reader;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.n.BitArray;
import b.i.e.n.BitMatrix;
import b.i.e.n.DecoderResult;
import b.i.e.r.d.BarcodeMetadata;
import b.i.e.r.d.BarcodeValue;
import b.i.e.r.d.BoundingBox;
import b.i.e.r.d.Codeword;
import b.i.e.r.d.DetectionResult;
import b.i.e.r.d.DetectionResultColumn;
import b.i.e.r.d.DetectionResultRowIndicatorColumn;
import b.i.e.r.d.PDF417ScanningDecoder;
import b.i.e.r.d.k.ErrorCorrection;
import b.i.e.r.e.Detector3;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.r.b, reason: use source file name */
/* JADX INFO: compiled from: PDF417Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PDF417Reader implements Reader {
    public static int b(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return 0;
        }
        return (int) Math.abs(resultPoint.a - resultPoint2.a);
    }

    public static int c(ResultPoint resultPoint, ResultPoint resultPoint2) {
        if (resultPoint == null || resultPoint2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(resultPoint.a - resultPoint2.a);
    }

    /* JADX WARN: Code duplicated, block: B:134:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:136:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:139:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:140:0x030b  */
    /* JADX WARN: Code duplicated, block: B:141:0x0310  */
    /* JADX WARN: Code duplicated, block: B:39:0x0163  */
    /* JADX WARN: Code duplicated, block: B:42:0x016c  */
    @Override // b.i.e.Reader
    public Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        BoundingBox boundingBox;
        DetectionResult detectionResult;
        int i;
        boolean z2;
        DecoderResult decoderResultB;
        int i2;
        Iterator<ResultPoint[]> it;
        BoundingBox boundingBox2;
        int i3;
        Codeword codeword;
        int i4;
        int i5;
        int i6;
        DetectionResultColumn detectionResultColumn;
        int i7;
        int i8;
        int i9;
        BoundingBox boundingBox3;
        int i10;
        int i11;
        int i12;
        Codeword codewordC;
        BarcodeMetadata barcodeMetadataC;
        BarcodeMetadata barcodeMetadataC2;
        ArrayList arrayList = new ArrayList();
        BitMatrix bitMatrixA = binaryBitmap.a();
        char c = 0;
        List<ResultPoint[]> listA = Detector3.a(false, bitMatrixA);
        int i13 = 2;
        if (((ArrayList) listA).isEmpty()) {
            int i14 = bitMatrixA.j;
            int i15 = bitMatrixA.k;
            BitMatrix bitMatrix = new BitMatrix(i14, i15, bitMatrixA.l, (int[]) bitMatrixA.m.clone());
            BitArray bitArray = new BitArray(i14);
            BitArray bitArray2 = new BitArray(i14);
            for (int i16 = 0; i16 < (i15 + 1) / 2; i16++) {
                bitArray = bitMatrix.h(i16, bitArray);
                int i17 = (i15 - 1) - i16;
                bitArray2 = bitMatrix.h(i17, bitArray2);
                bitArray.i();
                bitArray2.i();
                int[] iArr = bitArray2.j;
                int[] iArr2 = bitMatrix.m;
                int i18 = bitMatrix.l;
                System.arraycopy(iArr, 0, iArr2, i16 * i18, i18);
                int[] iArr3 = bitArray.j;
                int[] iArr4 = bitMatrix.m;
                int i19 = bitMatrix.l;
                System.arraycopy(iArr3, 0, iArr4, i17 * i19, i19);
            }
            listA = Detector3.a(false, bitMatrix);
            bitMatrixA = bitMatrix;
        }
        Iterator<ResultPoint[]> it2 = listA.iterator();
        while (it2.hasNext()) {
            ResultPoint[] next = it2.next();
            ResultPoint resultPoint = next[4];
            ResultPoint resultPoint2 = next[5];
            ResultPoint resultPoint3 = next[6];
            ResultPoint resultPoint4 = next[7];
            int iMin = Math.min(Math.min(c(next[c], next[4]), (c(next[6], next[i13]) * 17) / 18), Math.min(c(next[1], next[5]), (c(next[7], next[3]) * 17) / 18));
            int iMax = Math.max(Math.max(b(next[c], next[4]), (b(next[6], next[i13]) * 17) / 18), Math.max(b(next[1], next[5]), (b(next[7], next[3]) * 17) / 18));
            ErrorCorrection errorCorrection = PDF417ScanningDecoder.a;
            BoundingBox boundingBox4 = new BoundingBox(bitMatrixA, resultPoint, resultPoint2, resultPoint3, resultPoint4);
            DetectionResult detectionResult2 = null;
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumnD = null;
            DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumnD2 = null;
            int i20 = 0;
            while (true) {
                if (i20 >= i13) {
                    boundingBox = boundingBox4;
                    detectionResult = detectionResult2;
                    break;
                }
                if (resultPoint != null) {
                    detectionResultRowIndicatorColumnD = PDF417ScanningDecoder.d(bitMatrixA, boundingBox4, resultPoint, true, iMin, iMax);
                }
                DetectionResultRowIndicatorColumn detectionResultRowIndicatorColumn = detectionResultRowIndicatorColumnD;
                if (resultPoint3 != null) {
                    detectionResultRowIndicatorColumnD2 = PDF417ScanningDecoder.d(bitMatrixA, boundingBox4, resultPoint3, false, iMin, iMax);
                }
                if (detectionResultRowIndicatorColumn == null && detectionResultRowIndicatorColumnD2 == null) {
                    detectionResult2 = null;
                } else {
                    if (detectionResultRowIndicatorColumn == null || (barcodeMetadataC = detectionResultRowIndicatorColumn.c()) == null) {
                        if (detectionResultRowIndicatorColumnD2 == null) {
                            barcodeMetadataC = null;
                        } else {
                            barcodeMetadataC = detectionResultRowIndicatorColumnD2.c();
                        }
                    } else if (detectionResultRowIndicatorColumnD2 != null && (barcodeMetadataC2 = detectionResultRowIndicatorColumnD2.c()) != null && barcodeMetadataC.a != barcodeMetadataC2.a && barcodeMetadataC.f1876b != barcodeMetadataC2.f1876b && barcodeMetadataC.e != barcodeMetadataC2.e) {
                        barcodeMetadataC = null;
                    }
                    if (barcodeMetadataC == null) {
                        detectionResult2 = null;
                    } else {
                        BoundingBox boundingBoxA = PDF417ScanningDecoder.a(detectionResultRowIndicatorColumn);
                        BoundingBox boundingBoxA2 = PDF417ScanningDecoder.a(detectionResultRowIndicatorColumnD2);
                        if (boundingBoxA == null) {
                            boundingBoxA = boundingBoxA2;
                        } else if (boundingBoxA2 != null) {
                            boundingBoxA = new BoundingBox(boundingBoxA.a, boundingBoxA.f1877b, boundingBoxA.c, boundingBoxA2.d, boundingBoxA2.e);
                        }
                        detectionResult2 = new DetectionResult(barcodeMetadataC, boundingBoxA);
                    }
                }
                if (detectionResult2 == null) {
                    throw NotFoundException.l;
                }
                if (i20 != 0 || (boundingBox4 = detectionResult2.c) == null) {
                    boundingBox = boundingBox4;
                } else {
                    boundingBox = boundingBox4;
                    if (boundingBox4.h < boundingBox.h || boundingBox4.i > boundingBox.i) {
                        i20++;
                        detectionResultRowIndicatorColumnD = detectionResultRowIndicatorColumn;
                        i13 = 2;
                    }
                }
                detectionResult2.c = boundingBox;
                detectionResult = detectionResult2;
                detectionResultRowIndicatorColumnD = detectionResultRowIndicatorColumn;
                break;
            }
            int i21 = detectionResult.d + 1;
            DetectionResultColumn[] detectionResultColumnArr = detectionResult.f1880b;
            detectionResultColumnArr[c] = detectionResultRowIndicatorColumnD;
            detectionResultColumnArr[i21] = detectionResultRowIndicatorColumnD2;
            boolean z3 = detectionResultRowIndicatorColumnD != null;
            int i22 = iMin;
            int i23 = 1;
            while (i23 <= i21) {
                int i24 = z3 ? i23 : i21 - i23;
                if (detectionResult.f1880b[i24] == null) {
                    DetectionResultColumn detectionResultRowIndicatorColumn2 = (i24 == 0 || i24 == i21) ? new DetectionResultRowIndicatorColumn(boundingBox, i24 == 0) : new DetectionResultColumn(boundingBox);
                    detectionResult.f1880b[i24] = detectionResultRowIndicatorColumn2;
                    int i25 = boundingBox.h;
                    int i26 = i22;
                    int iMax2 = iMax;
                    int i27 = -1;
                    while (i25 <= boundingBox.i) {
                        int i28 = z3 ? 1 : -1;
                        int i29 = i24 - i28;
                        if (PDF417ScanningDecoder.e(detectionResult, i29)) {
                            DetectionResultColumn detectionResultColumn2 = detectionResult.f1880b[i29];
                            codeword = detectionResultColumn2.f1881b[i25 - detectionResultColumn2.a.h];
                        } else {
                            codeword = null;
                        }
                        if (codeword != null) {
                            i5 = z3 ? codeword.f1878b : codeword.a;
                        } else {
                            Codeword codewordA = detectionResult.f1880b[i24].a(i25);
                            if (codewordA != null) {
                                i5 = z3 ? codewordA.a : codewordA.f1878b;
                            } else {
                                if (PDF417ScanningDecoder.e(detectionResult, i29)) {
                                    codewordA = detectionResult.f1880b[i29].a(i25);
                                }
                                if (codewordA == null) {
                                    int i30 = i24;
                                    int i31 = 0;
                                    while (true) {
                                        int i32 = i30 - i28;
                                        if (!PDF417ScanningDecoder.e(detectionResult, i32)) {
                                            i4 = i25;
                                            if (!z3) {
                                                i5 = detectionResult.c.g;
                                                break;
                                            }
                                            i5 = detectionResult.c.f;
                                            break;
                                        }
                                        Codeword[] codewordArr = detectionResult.f1880b[i32].f1881b;
                                        int length = codewordArr.length;
                                        i4 = i25;
                                        int i33 = 0;
                                        while (i33 < length) {
                                            int i34 = length;
                                            Codeword codeword2 = codewordArr[i33];
                                            if (codeword2 != null) {
                                                i5 = ((codeword2.f1878b - codeword2.a) * i28 * i31) + (z3 ? codeword2.f1878b : codeword2.a);
                                                break;
                                            }
                                            i33++;
                                            length = i34;
                                        }
                                        i31++;
                                        i30 = i32;
                                        i25 = i4;
                                    }
                                } else {
                                    i5 = z3 ? codewordA.f1878b : codewordA.a;
                                }
                                if (i5 >= 0 || i5 > boundingBox.g) {
                                    if (i27 != -1) {
                                        i10 = i27;
                                    } else {
                                        i6 = i26;
                                        detectionResultColumn = detectionResultRowIndicatorColumn2;
                                        i7 = i24;
                                        i8 = i21;
                                        iMax2 = iMax2;
                                        i9 = i4;
                                        boundingBox3 = boundingBox;
                                    }
                                    i26 = i6;
                                    i25 = i9 + 1;
                                    detectionResultRowIndicatorColumn2 = detectionResultColumn;
                                    it2 = it2;
                                    boundingBox = boundingBox3;
                                    i24 = i7;
                                    i21 = i8;
                                } else {
                                    i10 = i5;
                                }
                                i11 = iMax2;
                                i9 = i4;
                                i12 = i26;
                                boundingBox3 = boundingBox;
                                i7 = i24;
                                detectionResultColumn = detectionResultRowIndicatorColumn2;
                                i8 = i21;
                                codewordC = PDF417ScanningDecoder.c(bitMatrixA, boundingBox.f, boundingBox.g, z3, i10, i9, i12, i11);
                                if (codewordC != null) {
                                    detectionResultColumn.f1881b[i9 - detectionResultColumn.a.h] = codewordC;
                                    int iMin2 = Math.min(i12, codewordC.f1878b - codewordC.a);
                                    iMax2 = Math.max(i11, codewordC.f1878b - codewordC.a);
                                    i26 = iMin2;
                                    i27 = i10;
                                } else {
                                    iMax2 = i11;
                                    i6 = i12;
                                    i26 = i6;
                                }
                                i25 = i9 + 1;
                                detectionResultRowIndicatorColumn2 = detectionResultColumn;
                                it2 = it2;
                                boundingBox = boundingBox3;
                                i24 = i7;
                                i21 = i8;
                            }
                        }
                        i4 = i25;
                        if (i5 >= 0) {
                            if (i27 != -1) {
                                i10 = i27;
                                i11 = iMax2;
                                i9 = i4;
                                i12 = i26;
                                boundingBox3 = boundingBox;
                                i7 = i24;
                                detectionResultColumn = detectionResultRowIndicatorColumn2;
                                i8 = i21;
                                codewordC = PDF417ScanningDecoder.c(bitMatrixA, boundingBox.f, boundingBox.g, z3, i10, i9, i12, i11);
                                if (codewordC != null) {
                                    detectionResultColumn.f1881b[i9 - detectionResultColumn.a.h] = codewordC;
                                    int iMin3 = Math.min(i12, codewordC.f1878b - codewordC.a);
                                    iMax2 = Math.max(i11, codewordC.f1878b - codewordC.a);
                                    i26 = iMin3;
                                    i27 = i10;
                                } else {
                                    iMax2 = i11;
                                    i6 = i12;
                                }
                                i25 = i9 + 1;
                                detectionResultRowIndicatorColumn2 = detectionResultColumn;
                                it2 = it2;
                                boundingBox = boundingBox3;
                                i24 = i7;
                                i21 = i8;
                            } else {
                                i6 = i26;
                                detectionResultColumn = detectionResultRowIndicatorColumn2;
                                i7 = i24;
                                i8 = i21;
                                iMax2 = iMax2;
                                i9 = i4;
                                boundingBox3 = boundingBox;
                            }
                        } else if (i27 != -1) {
                            i10 = i27;
                            i11 = iMax2;
                            i9 = i4;
                            i12 = i26;
                            boundingBox3 = boundingBox;
                            i7 = i24;
                            detectionResultColumn = detectionResultRowIndicatorColumn2;
                            i8 = i21;
                            codewordC = PDF417ScanningDecoder.c(bitMatrixA, boundingBox.f, boundingBox.g, z3, i10, i9, i12, i11);
                            if (codewordC != null) {
                                detectionResultColumn.f1881b[i9 - detectionResultColumn.a.h] = codewordC;
                                int iMin4 = Math.min(i12, codewordC.f1878b - codewordC.a);
                                iMax2 = Math.max(i11, codewordC.f1878b - codewordC.a);
                                i26 = iMin4;
                                i27 = i10;
                            } else {
                                iMax2 = i11;
                                i6 = i12;
                            }
                            i25 = i9 + 1;
                            detectionResultRowIndicatorColumn2 = detectionResultColumn;
                            it2 = it2;
                            boundingBox = boundingBox3;
                            i24 = i7;
                            i21 = i8;
                        } else {
                            i6 = i26;
                            detectionResultColumn = detectionResultRowIndicatorColumn2;
                            i7 = i24;
                            i8 = i21;
                            iMax2 = iMax2;
                            i9 = i4;
                            boundingBox3 = boundingBox;
                        }
                        i26 = i6;
                        i25 = i9 + 1;
                        detectionResultRowIndicatorColumn2 = detectionResultColumn;
                        it2 = it2;
                        boundingBox = boundingBox3;
                        i24 = i7;
                        i21 = i8;
                    }
                    it = it2;
                    boundingBox2 = boundingBox;
                    i3 = i21;
                    iMax = iMax2;
                    i22 = i26;
                } else {
                    it = it2;
                    boundingBox2 = boundingBox;
                    i3 = i21;
                }
                i23++;
                it2 = it;
                boundingBox = boundingBox2;
                i21 = i3;
            }
            Iterator<ResultPoint[]> it3 = it2;
            BarcodeValue[][] barcodeValueArr = (BarcodeValue[][]) Array.newInstance((Class<?>) BarcodeValue.class, detectionResult.a.e, detectionResult.d + 2);
            for (int i35 = 0; i35 < barcodeValueArr.length; i35++) {
                for (int i36 = 0; i36 < barcodeValueArr[i35].length; i36++) {
                    barcodeValueArr[i35][i36] = new BarcodeValue();
                }
            }
            char c2 = 0;
            detectionResult.a(detectionResult.f1880b[0]);
            int i37 = 1;
            detectionResult.a(detectionResult.f1880b[detectionResult.d + 1]);
            int i38 = 928;
            while (true) {
                DetectionResultColumn[] detectionResultColumnArr2 = detectionResult.f1880b;
                if (detectionResultColumnArr2[c2] != null) {
                    int i39 = detectionResult.d + i37;
                    if (detectionResultColumnArr2[i39] != null) {
                        Codeword[] codewordArr2 = detectionResultColumnArr2[c2].f1881b;
                        Codeword[] codewordArr3 = detectionResultColumnArr2[i39].f1881b;
                        for (int i40 = 0; i40 < codewordArr2.length; i40++) {
                            if (codewordArr2[i40] != null && codewordArr3[i40] != null && codewordArr2[i40].e == codewordArr3[i40].e) {
                                for (int i41 = 1; i41 <= detectionResult.d; i41++) {
                                    Codeword codeword3 = detectionResult.f1880b[i41].f1881b[i40];
                                    if (codeword3 != null) {
                                        codeword3.e = codewordArr2[i40].e;
                                        if (!codeword3.a()) {
                                            detectionResult.f1880b[i41].f1881b[i40] = null;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                DetectionResultColumn[] detectionResultColumnArr3 = detectionResult.f1880b;
                int i42 = 0;
                if (detectionResultColumnArr3[0] != null) {
                    Codeword[] codewordArr4 = detectionResultColumnArr3[0].f1881b;
                    int i43 = 0;
                    for (int i44 = 0; i44 < codewordArr4.length; i44++) {
                        if (codewordArr4[i44] != null) {
                            int i45 = codewordArr4[i44].e;
                            int i46 = i43;
                            int iB = 0;
                            for (int i47 = 1; i47 < detectionResult.d + 1 && iB < 2; i47++) {
                                Codeword codeword4 = detectionResult.f1880b[i47].f1881b[i44];
                                if (codeword4 != null) {
                                    iB = DetectionResult.b(i45, iB, codeword4);
                                    if (!codeword4.a()) {
                                        i46++;
                                    }
                                }
                            }
                            i43 = i46;
                        }
                    }
                    i42 = i43;
                }
                DetectionResultColumn[] detectionResultColumnArr4 = detectionResult.f1880b;
                int i48 = detectionResult.d + 1;
                if (detectionResultColumnArr4[i48] == null) {
                    i = 0;
                } else {
                    Codeword[] codewordArr5 = detectionResultColumnArr4[i48].f1881b;
                    i = 0;
                    for (int i49 = 0; i49 < codewordArr5.length; i49++) {
                        if (codewordArr5[i49] != null) {
                            int i50 = codewordArr5[i49].e;
                            int i51 = i;
                            int iB2 = 0;
                            for (int i52 = detectionResult.d + 1; i52 > 0 && iB2 < 2; i52--) {
                                Codeword codeword5 = detectionResult.f1880b[i52].f1881b[i49];
                                if (codeword5 != null) {
                                    iB2 = DetectionResult.b(i50, iB2, codeword5);
                                    if (!codeword5.a()) {
                                        i51++;
                                    }
                                }
                            }
                            i = i51;
                        }
                    }
                }
                int i53 = i42 + i;
                if (i53 == 0) {
                    i53 = 0;
                } else {
                    for (int i54 = 1; i54 < detectionResult.d + 1; i54++) {
                        Codeword[] codewordArr6 = detectionResult.f1880b[i54].f1881b;
                        for (int i55 = 0; i55 < codewordArr6.length; i55++) {
                            if (codewordArr6[i55] != null && !codewordArr6[i55].a()) {
                                Codeword codeword6 = codewordArr6[i55];
                                DetectionResultColumn[] detectionResultColumnArr5 = detectionResult.f1880b;
                                Codeword[] codewordArr7 = detectionResultColumnArr5[i54 - 1].f1881b;
                                int i56 = i54 + 1;
                                Codeword[] codewordArr8 = detectionResultColumnArr5[i56] != null ? detectionResultColumnArr5[i56].f1881b : codewordArr7;
                                Codeword[] codewordArr9 = new Codeword[14];
                                codewordArr9[2] = codewordArr7[i55];
                                codewordArr9[3] = codewordArr8[i55];
                                if (i55 > 0) {
                                    int i57 = i55 - 1;
                                    codewordArr9[0] = codewordArr6[i57];
                                    codewordArr9[4] = codewordArr7[i57];
                                    codewordArr9[5] = codewordArr8[i57];
                                }
                                if (i55 > 1) {
                                    int i58 = i55 - 2;
                                    codewordArr9[8] = codewordArr6[i58];
                                    codewordArr9[10] = codewordArr7[i58];
                                    codewordArr9[11] = codewordArr8[i58];
                                }
                                if (i55 < codewordArr6.length - 1) {
                                    int i59 = i55 + 1;
                                    codewordArr9[1] = codewordArr6[i59];
                                    codewordArr9[6] = codewordArr7[i59];
                                    codewordArr9[7] = codewordArr8[i59];
                                }
                                if (i55 < codewordArr6.length - 2) {
                                    int i60 = i55 + 2;
                                    codewordArr9[9] = codewordArr6[i60];
                                    codewordArr9[12] = codewordArr7[i60];
                                    codewordArr9[13] = codewordArr8[i60];
                                }
                                int i61 = 0;
                                for (int i62 = 14; i61 < i62; i62 = 14) {
                                    Codeword codeword7 = codewordArr9[i61];
                                    if (codeword7 != null && codeword7.a() && codeword7.c == codeword6.c) {
                                        codeword6.e = codeword7.e;
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    if (z2) {
                                        break;
                                    }
                                    i61++;
                                }
                            }
                        }
                    }
                }
                if (i53 <= 0 || i53 >= i38) {
                    break;
                }
                i38 = i53;
                c2 = 0;
                i37 = 1;
            }
            int i63 = 0;
            for (DetectionResultColumn detectionResultColumn3 : detectionResult.f1880b) {
                if (detectionResultColumn3 != null) {
                    for (Codeword codeword8 : detectionResultColumn3.f1881b) {
                        if (codeword8 != null && (i2 = codeword8.e) >= 0 && i2 < barcodeValueArr.length) {
                            barcodeValueArr[i2][i63].b(codeword8.d);
                        }
                    }
                }
                i63++;
            }
            BarcodeValue barcodeValue = barcodeValueArr[0][1];
            int[] iArrA = barcodeValue.a();
            int i64 = detectionResult.d;
            BarcodeMetadata barcodeMetadata = detectionResult.a;
            int i65 = (i64 * barcodeMetadata.e) - (2 << barcodeMetadata.f1876b);
            if (iArrA.length == 0) {
                if (i65 <= 0 || i65 > 928) {
                    throw NotFoundException.l;
                }
                barcodeValue.b(i65);
            } else if (iArrA[0] != i65) {
                barcodeValue.b(i65);
            }
            ArrayList arrayList2 = new ArrayList();
            int[] iArr5 = new int[detectionResult.a.e * detectionResult.d];
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            for (int i66 = 0; i66 < detectionResult.a.e; i66++) {
                int i67 = 0;
                while (i67 < detectionResult.d) {
                    int i68 = i67 + 1;
                    int[] iArrA2 = barcodeValueArr[i66][i68].a();
                    int i69 = (detectionResult.d * i66) + i67;
                    if (iArrA2.length == 0) {
                        arrayList2.add(Integer.valueOf(i69));
                    } else if (iArrA2.length == 1) {
                        iArr5[i69] = iArrA2[0];
                    } else {
                        arrayList4.add(Integer.valueOf(i69));
                        arrayList3.add(iArrA2);
                    }
                    i67 = i68;
                }
            }
            int size = arrayList3.size();
            int[][] iArr6 = new int[size][];
            for (int i70 = 0; i70 < size; i70++) {
                iArr6[i70] = (int[]) arrayList3.get(i70);
            }
            int i71 = detectionResult.a.f1876b;
            int[] iArrB = PDF417Common.b(arrayList2);
            int[] iArrB2 = PDF417Common.b(arrayList4);
            int length2 = iArrB2.length;
            int[] iArr7 = new int[length2];
            int i72 = 100;
            while (true) {
                int i73 = i72 - 1;
                if (i72 <= 0) {
                    throw ChecksumException.a();
                }
                for (int i74 = 0; i74 < length2; i74++) {
                    iArr5[iArrB2[i74]] = iArr6[i74][iArr7[i74]];
                }
                try {
                    decoderResultB = PDF417ScanningDecoder.b(iArr5, i71, iArrB);
                } catch (ChecksumException unused) {
                    if (length2 == 0) {
                        throw ChecksumException.a();
                    }
                    for (int i75 = 0; i75 < length2; i75++) {
                        if (iArr7[i75] < iArr6[i75].length - 1) {
                            iArr7[i75] = iArr7[i75] + 1;
                            break;
                        }
                        iArr7[i75] = 0;
                        if (i75 == length2 - 1) {
                            throw ChecksumException.a();
                        }
                    }
                    i72 = i73;
                }
            }
            Result result = new Result(decoderResultB.c, decoderResultB.a, next, BarcodeFormat.PDF_417);
            result.b(ResultMetadataType.ERROR_CORRECTION_LEVEL, decoderResultB.e);
            PDF417ResultMetadata pDF417ResultMetadata = (PDF417ResultMetadata) decoderResultB.f;
            if (pDF417ResultMetadata != null) {
                result.b(ResultMetadataType.PDF417_EXTRA_METADATA, pDF417ResultMetadata);
            }
            arrayList.add(result);
            it2 = it3;
            c = 0;
            i13 = 2;
        }
        Result[] resultArr = (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        if (resultArr == null || resultArr.length == 0 || resultArr[0] == null) {
            throw NotFoundException.l;
        }
        return resultArr[0];
    }

    @Override // b.i.e.Reader
    public void reset() {
    }
}
