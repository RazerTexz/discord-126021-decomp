package b.i.e.q;

import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.LuminanceSource;
import b.i.e.Reader;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.n.BitArray;
import b.i.e.n.HybridBinarizer;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.e.q.k, reason: use source file name */
/* JADX INFO: compiled from: OneDReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class OneDReader implements Reader {
    public static float d(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    public static void e(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int i3 = bitArray.k;
        if (i >= i3) {
            throw NotFoundException.l;
        }
        boolean z2 = !bitArray.b(i);
        while (i < i3) {
            if (bitArray.b(i) == z2) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z2 = !z2;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != i3) {
                throw NotFoundException.l;
            }
        }
    }

    public static void f(BitArray bitArray, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zB = bitArray.b(i);
        while (i > 0 && length >= 0) {
            i--;
            if (bitArray.b(i) != zB) {
                length--;
                zB = !zB;
            }
        }
        if (length >= 0) {
            throw NotFoundException.l;
        }
        e(bitArray, i + 1, iArr);
    }

    @Override // b.i.e.Reader
    public Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
        try {
            return c(binaryBitmap, map);
        } catch (NotFoundException e) {
            if (!(map != null && map.containsKey(DecodeHintType.TRY_HARDER)) || !binaryBitmap.a.a.c()) {
                throw e;
            }
            LuminanceSource luminanceSourceD = binaryBitmap.a.a.d();
            Objects.requireNonNull((HybridBinarizer) binaryBitmap.a);
            Result resultC = c(new BinaryBitmap(new HybridBinarizer(luminanceSourceD)), map);
            Map<ResultMetadataType, Object> map2 = resultC.e;
            int iIntValue = 270;
            if (map2 != null && map2.containsKey(resultMetadataType)) {
                iIntValue = (((Integer) map2.get(resultMetadataType)).intValue() + 270) % 360;
            }
            resultC.b(resultMetadataType, Integer.valueOf(iIntValue));
            ResultPoint[] resultPointArr = resultC.c;
            if (resultPointArr != null) {
                int i = luminanceSourceD.f1823b;
                for (int i2 = 0; i2 < resultPointArr.length; i2++) {
                    resultPointArr[i2] = new ResultPoint((i - resultPointArr[i2].f1826b) - 1.0f, resultPointArr[i2].a);
                }
            }
            return resultC;
        }
    }

    public abstract Result b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException;

    /* JADX WARN: Code duplicated, block: B:37:0x0075  */
    public final Result c(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        Map<DecodeHintType, ?> map2;
        int i;
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        Map<DecodeHintType, ?> map3 = map;
        LuminanceSource luminanceSource = binaryBitmap2.a.a;
        int i2 = luminanceSource.a;
        int i3 = luminanceSource.f1823b;
        BitArray bitArray = new BitArray(i2);
        int i4 = 1;
        boolean z2 = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, i3 >> (z2 ? 8 : 5));
        int i5 = z2 ? i3 : 15;
        int i6 = i3 / 2;
        int i7 = 0;
        while (i7 < i5) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if (!((i7 & 1) == 0)) {
                i9 = -i9;
            }
            int i10 = (i9 * iMax) + i6;
            if (i10 < 0 || i10 >= i3) {
                break;
            }
            try {
                bitArray = binaryBitmap2.b(i10, bitArray);
                int i11 = 0;
                while (i11 < 2) {
                    if (i11 == i4) {
                        bitArray.i();
                        if (map3 != null) {
                            DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(decodeHintType)) {
                                EnumMap enumMap = new EnumMap(DecodeHintType.class);
                                enumMap.putAll(map3);
                                enumMap.remove(decodeHintType);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        Result resultB = b(i10, bitArray, map3);
                        if (i11 == i4) {
                            resultB.b(ResultMetadataType.ORIENTATION, 180);
                            ResultPoint[] resultPointArr = resultB.c;
                            if (resultPointArr != null) {
                                float f = i2;
                                map2 = map3;
                                try {
                                    i = i3;
                                    try {
                                        resultPointArr[0] = new ResultPoint((f - resultPointArr[0].a) - 1.0f, resultPointArr[0].f1826b);
                                        try {
                                            resultPointArr[1] = new ResultPoint((f - resultPointArr[1].a) - 1.0f, resultPointArr[1].f1826b);
                                        } catch (ReaderException unused) {
                                            continue;
                                            i11++;
                                            map3 = map2;
                                            i3 = i;
                                            i4 = 1;
                                        }
                                    } catch (ReaderException unused2) {
                                        i11++;
                                        map3 = map2;
                                        i3 = i;
                                        i4 = 1;
                                    }
                                } catch (ReaderException unused3) {
                                    i = i3;
                                    i11++;
                                    map3 = map2;
                                    i3 = i;
                                    i4 = 1;
                                }
                            }
                        }
                        return resultB;
                    } catch (ReaderException unused4) {
                        map2 = map3;
                    }
                }
            } catch (NotFoundException unused5) {
            }
            binaryBitmap2 = binaryBitmap;
            i7 = i8;
            i3 = i3;
            i4 = 1;
        }
        throw NotFoundException.l;
    }

    @Override // b.i.e.Reader
    public void reset() {
    }
}
