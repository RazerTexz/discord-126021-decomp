package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.DecodeHintType;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.ResultPointCallback;
import b.i.e.n.BitArray;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.q.p, reason: use source file name */
/* JADX INFO: compiled from: UPCEANReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UPCEANReader extends OneDReader {
    public static final int[] a = {1, 1, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1861b = {1, 1, 1, 1, 1};
    public static final int[][] c;
    public static final int[][] d;
    public final StringBuilder e = new StringBuilder(20);
    public final UPCEANExtensionSupport f = new UPCEANExtensionSupport();
    public final EANManufacturerOrgSupport g = new EANManufacturerOrgSupport();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        c = iArr;
        int[][] iArr2 = new int[20][];
        d = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = c[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            d[i] = iArr4;
        }
    }

    public static int h(BitArray bitArray, int[] iArr, int i, int[][] iArr2) throws NotFoundException {
        OneDReader.e(bitArray, i, iArr);
        int length = iArr2.length;
        float f = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fD = OneDReader.d(iArr, iArr2[i3], 0.7f);
            if (fD < f) {
                i2 = i3;
                f = fD;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.l;
    }

    public static int[] l(BitArray bitArray, int i, boolean z2, int[] iArr, int[] iArr2) throws NotFoundException {
        int i2 = bitArray.k;
        int iG = z2 ? bitArray.g(i) : bitArray.f(i);
        int length = iArr.length;
        boolean z3 = z2;
        int i3 = 0;
        int i4 = iG;
        while (iG < i2) {
            if (bitArray.b(iG) != z3) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (OneDReader.d(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i4, iG};
                    }
                    i4 += iArr2[0] + iArr2[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i3] = 0;
                    i3 = i5;
                }
                iArr2[i3] = 1;
                z3 = !z3;
            }
            iG++;
        }
        throw NotFoundException.l;
    }

    public static int[] m(BitArray bitArray) throws NotFoundException {
        int[] iArr = new int[a.length];
        int[] iArrL = null;
        boolean zH = false;
        int i = 0;
        while (!zH) {
            int[] iArr2 = a;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrL = l(bitArray, i, false, iArr2, iArr);
            int i2 = iArrL[0];
            int i3 = iArrL[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zH = bitArray.h(i4, i2, false);
            }
            i = i3;
        }
        return iArrL;
    }

    @Override // b.i.e.q.OneDReader
    public Result b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return k(i, bitArray, m(bitArray), map);
    }

    public boolean g(String str) throws FormatException {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        int iDigit = Character.digit(str.charAt(i), 10);
        CharSequence charSequenceSubSequence = str.subSequence(0, i);
        int length2 = charSequenceSubSequence.length();
        int i2 = 0;
        for (int i3 = length2 - 1; i3 >= 0; i3 -= 2) {
            int iCharAt = charSequenceSubSequence.charAt(i3) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw FormatException.a();
            }
            i2 += iCharAt;
        }
        int i4 = i2 * 3;
        while (true) {
            length2 -= 2;
            if (length2 < 0) {
                return (1000 - i4) % 10 == iDigit;
            }
            int iCharAt2 = charSequenceSubSequence.charAt(length2) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw FormatException.a();
            }
            i4 += iCharAt2;
        }
    }

    public int[] i(BitArray bitArray, int i) throws NotFoundException {
        int[] iArr = a;
        return l(bitArray, i, false, iArr, new int[iArr.length]);
    }

    public abstract int j(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException;

    public Result k(int i, BitArray bitArray, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int length;
        boolean z2;
        String str = null;
        ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (resultPointCallback != null) {
            resultPointCallback.a(new ResultPoint((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.e;
        sb.setLength(0);
        int iJ = j(bitArray, iArr, sb);
        if (resultPointCallback != null) {
            resultPointCallback.a(new ResultPoint(iJ, i));
        }
        int[] iArrI = i(bitArray, iJ);
        if (resultPointCallback != null) {
            resultPointCallback.a(new ResultPoint((iArrI[0] + iArrI[1]) / 2.0f, i));
        }
        int i2 = iArrI[1];
        int i3 = (i2 - iArrI[0]) + i2;
        if (i3 >= bitArray.k || !bitArray.h(i2, i3, false)) {
            throw NotFoundException.l;
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw FormatException.a();
        }
        if (!g(string)) {
            throw ChecksumException.a();
        }
        float f = (iArr[1] + iArr[0]) / 2.0f;
        float f2 = (iArrI[1] + iArrI[0]) / 2.0f;
        BarcodeFormat barcodeFormatN = n();
        float f3 = i;
        Result result = new Result(string, null, new ResultPoint[]{new ResultPoint(f, f3), new ResultPoint(f2, f3)}, barcodeFormatN);
        try {
            Result resultA = this.f.a(i, bitArray, iArrI[1]);
            result.b(ResultMetadataType.UPC_EAN_EXTENSION, resultA.a);
            result.a(resultA.e);
            ResultPoint[] resultPointArr = resultA.c;
            ResultPoint[] resultPointArr2 = result.c;
            if (resultPointArr2 == null) {
                result.c = resultPointArr;
            } else if (resultPointArr != null && resultPointArr.length > 0) {
                ResultPoint[] resultPointArr3 = new ResultPoint[resultPointArr2.length + resultPointArr.length];
                System.arraycopy(resultPointArr2, 0, resultPointArr3, 0, resultPointArr2.length);
                System.arraycopy(resultPointArr, 0, resultPointArr3, resultPointArr2.length, resultPointArr.length);
                result.c = resultPointArr3;
            }
            length = resultA.a.length();
        } catch (ReaderException unused) {
            length = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            int length2 = iArr2.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    z2 = false;
                    break;
                }
                if (length == iArr2[i4]) {
                    z2 = true;
                    break;
                }
                i4++;
            }
            if (!z2) {
                throw NotFoundException.l;
            }
        }
        if (barcodeFormatN == BarcodeFormat.EAN_13 || barcodeFormatN == BarcodeFormat.UPC_A) {
            EANManufacturerOrgSupport eANManufacturerOrgSupport = this.g;
            eANManufacturerOrgSupport.b();
            int i5 = Integer.parseInt(string.substring(0, 3));
            int size = eANManufacturerOrgSupport.a.size();
            for (int i6 = 0; i6 < size; i6++) {
                int[] iArr3 = eANManufacturerOrgSupport.a.get(i6);
                int i7 = iArr3[0];
                if (i5 < i7) {
                    break;
                }
                if (iArr3.length != 1) {
                    i7 = iArr3[1];
                }
                if (i5 <= i7) {
                    str = eANManufacturerOrgSupport.f1856b.get(i6);
                    break;
                }
            }
            if (str != null) {
                result.b(ResultMetadataType.POSSIBLE_COUNTRY, str);
            }
        }
        return result;
    }

    public abstract BarcodeFormat n();
}
