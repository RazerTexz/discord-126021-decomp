package b.i.e.o;

import b.i.e.BarcodeFormat;
import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.Reader;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.n.BitMatrix;
import b.i.e.n.DecoderResult;
import b.i.e.o.b.Decoder3;
import b.i.e.o.c.Detector2;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.o.a, reason: use source file name */
/* JADX INFO: compiled from: DataMatrixReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DataMatrixReader implements Reader {
    public static final ResultPoint[] a = new ResultPoint[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Decoder3 f1843b = new Decoder3();

    @Override // b.i.e.Reader
    public Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        BitMatrix bitMatrixD;
        ResultPoint[] resultPointArr;
        DecoderResult decoderResultA;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            Detector2 detector2 = new Detector2(binaryBitmap.a());
            ResultPoint[] resultPointArrB = detector2.f1850b.b();
            ResultPoint resultPoint = resultPointArrB[0];
            ResultPoint resultPoint2 = resultPointArrB[1];
            ResultPoint resultPoint3 = resultPointArrB[2];
            ResultPoint resultPoint4 = resultPointArrB[3];
            ArrayList arrayList = new ArrayList(4);
            arrayList.add(detector2.e(resultPoint, resultPoint2));
            arrayList.add(detector2.e(resultPoint, resultPoint3));
            arrayList.add(detector2.e(resultPoint2, resultPoint4));
            arrayList.add(detector2.e(resultPoint3, resultPoint4));
            Collections.sort(arrayList, new Detector2.c(null));
            Detector2.b bVar = (Detector2.b) arrayList.get(0);
            Detector2.b bVar2 = (Detector2.b) arrayList.get(1);
            HashMap map2 = new HashMap();
            Detector2.b(map2, bVar.a);
            Detector2.b(map2, bVar.f1851b);
            Detector2.b(map2, bVar2.a);
            Detector2.b(map2, bVar2.f1851b);
            ResultPoint resultPoint5 = null;
            ResultPoint resultPoint6 = null;
            ResultPoint resultPoint7 = null;
            for (Map.Entry entry : map2.entrySet()) {
                ResultPoint resultPoint8 = (ResultPoint) entry.getKey();
                if (((Integer) entry.getValue()).intValue() == 2) {
                    resultPoint6 = resultPoint8;
                } else if (resultPoint5 == null) {
                    resultPoint5 = resultPoint8;
                } else {
                    resultPoint7 = resultPoint8;
                }
            }
            if (resultPoint5 == null || resultPoint6 == null || resultPoint7 == null) {
                throw NotFoundException.l;
            }
            ResultPoint[] resultPointArr2 = {resultPoint5, resultPoint6, resultPoint7};
            ResultPoint.b(resultPointArr2);
            ResultPoint resultPoint9 = resultPointArr2[0];
            ResultPoint resultPoint10 = resultPointArr2[1];
            ResultPoint resultPoint11 = resultPointArr2[2];
            if (map2.containsKey(resultPoint)) {
                resultPoint = map2.containsKey(resultPoint2) ? !map2.containsKey(resultPoint3) ? resultPoint3 : resultPoint4 : resultPoint2;
            }
            int i = detector2.e(resultPoint11, resultPoint).c;
            int i2 = detector2.e(resultPoint9, resultPoint).c;
            if ((i & 1) == 1) {
                i++;
            }
            int i3 = i + 2;
            if ((i2 & 1) == 1) {
                i2++;
            }
            int i4 = i2 + 2;
            if (i3 * 4 >= i4 * 7 || i4 * 4 >= i3 * 7) {
                float fA = Detector2.a(resultPoint10, resultPoint9) / i3;
                int iA = Detector2.a(resultPoint11, resultPoint);
                float f = resultPoint.a;
                float f2 = iA;
                float f3 = (f - resultPoint11.a) / f2;
                float f4 = resultPoint.f1826b;
                ResultPoint resultPoint12 = new ResultPoint((f3 * fA) + f, (fA * ((f4 - resultPoint11.f1826b) / f2)) + f4);
                float fA2 = Detector2.a(resultPoint10, resultPoint11) / i4;
                int iA2 = Detector2.a(resultPoint9, resultPoint);
                float f5 = resultPoint.a;
                float f6 = iA2;
                float f7 = (f5 - resultPoint9.a) / f6;
                float f8 = resultPoint.f1826b;
                ResultPoint resultPoint13 = new ResultPoint((f7 * fA2) + f5, (fA2 * ((f8 - resultPoint9.f1826b) / f6)) + f8);
                if (detector2.c(resultPoint12)) {
                    if (!detector2.c(resultPoint13) || Math.abs(i4 - detector2.e(resultPoint9, resultPoint12).c) + Math.abs(i3 - detector2.e(resultPoint11, resultPoint12).c) <= Math.abs(i4 - detector2.e(resultPoint9, resultPoint13).c) + Math.abs(i3 - detector2.e(resultPoint11, resultPoint13).c)) {
                        resultPoint13 = resultPoint12;
                    }
                } else if (!detector2.c(resultPoint13)) {
                    resultPoint13 = null;
                }
                if (resultPoint13 != null) {
                    resultPoint = resultPoint13;
                }
                int i5 = detector2.e(resultPoint11, resultPoint).c;
                int i6 = detector2.e(resultPoint9, resultPoint).c;
                if ((i5 & 1) == 1) {
                    i5++;
                }
                int i7 = i5;
                if ((i6 & 1) == 1) {
                    i6++;
                }
                bitMatrixD = Detector2.d(detector2.a, resultPoint11, resultPoint10, resultPoint9, resultPoint, i7, i6);
            } else {
                float fMin = Math.min(i4, i3);
                float fA3 = Detector2.a(resultPoint10, resultPoint9) / fMin;
                int iA3 = Detector2.a(resultPoint11, resultPoint);
                float f9 = resultPoint.a;
                float f10 = iA3;
                float f11 = (f9 - resultPoint11.a) / f10;
                float f12 = resultPoint.f1826b;
                ResultPoint resultPoint14 = new ResultPoint((f11 * fA3) + f9, (fA3 * ((f12 - resultPoint11.f1826b) / f10)) + f12);
                float fA4 = Detector2.a(resultPoint10, resultPoint11) / fMin;
                int iA4 = Detector2.a(resultPoint9, resultPoint);
                float f13 = resultPoint.a;
                float f14 = iA4;
                float f15 = (f13 - resultPoint9.a) / f14;
                float f16 = resultPoint.f1826b;
                ResultPoint resultPoint15 = new ResultPoint((f15 * fA4) + f13, (fA4 * ((f16 - resultPoint9.f1826b) / f14)) + f16);
                if (detector2.c(resultPoint14)) {
                    if (!detector2.c(resultPoint15) || Math.abs(detector2.e(resultPoint11, resultPoint14).c - detector2.e(resultPoint9, resultPoint14).c) <= Math.abs(detector2.e(resultPoint11, resultPoint15).c - detector2.e(resultPoint9, resultPoint15).c)) {
                        resultPoint15 = resultPoint14;
                    }
                } else if (!detector2.c(resultPoint15)) {
                    resultPoint15 = null;
                }
                if (resultPoint15 != null) {
                    resultPoint = resultPoint15;
                }
                int iMax = Math.max(detector2.e(resultPoint11, resultPoint).c, detector2.e(resultPoint9, resultPoint).c) + 1;
                if ((iMax & 1) == 1) {
                    iMax++;
                }
                int i8 = iMax;
                bitMatrixD = Detector2.d(detector2.a, resultPoint11, resultPoint10, resultPoint9, resultPoint, i8, i8);
            }
            resultPointArr = new ResultPoint[]{resultPoint11, resultPoint10, resultPoint9, resultPoint};
            decoderResultA = this.f1843b.a(bitMatrixD);
        } else {
            BitMatrix bitMatrixA = binaryBitmap.a();
            int[] iArrI = bitMatrixA.i();
            int[] iArrG = bitMatrixA.g();
            if (iArrI == null || iArrG == null) {
                throw NotFoundException.l;
            }
            int i9 = bitMatrixA.j;
            int i10 = iArrI[0];
            int i11 = iArrI[1];
            while (i10 < i9 && bitMatrixA.f(i10, i11)) {
                i10++;
            }
            if (i10 == i9) {
                throw NotFoundException.l;
            }
            int i12 = i10 - iArrI[0];
            if (i12 == 0) {
                throw NotFoundException.l;
            }
            int i13 = iArrI[1];
            int i14 = iArrG[1];
            int i15 = iArrI[0];
            int i16 = ((iArrG[0] - i15) + 1) / i12;
            int i17 = ((i14 - i13) + 1) / i12;
            if (i16 <= 0 || i17 <= 0) {
                throw NotFoundException.l;
            }
            int i18 = i12 / 2;
            int i19 = i13 + i18;
            int i20 = i15 + i18;
            BitMatrix bitMatrix = new BitMatrix(i16, i17);
            for (int i21 = 0; i21 < i17; i21++) {
                int i22 = (i21 * i12) + i19;
                for (int i23 = 0; i23 < i16; i23++) {
                    if (bitMatrixA.f((i23 * i12) + i20, i22)) {
                        bitMatrix.j(i23, i21);
                    }
                }
            }
            decoderResultA = this.f1843b.a(bitMatrix);
            resultPointArr = a;
        }
        Result result = new Result(decoderResultA.c, decoderResultA.a, resultPointArr, BarcodeFormat.DATA_MATRIX);
        List<byte[]> list = decoderResultA.d;
        if (list != null) {
            result.b(ResultMetadataType.BYTE_SEGMENTS, list);
        }
        String str = decoderResultA.e;
        if (str != null) {
            result.b(ResultMetadataType.ERROR_CORRECTION_LEVEL, str);
        }
        return result;
    }

    @Override // b.i.e.Reader
    public void reset() {
    }
}
