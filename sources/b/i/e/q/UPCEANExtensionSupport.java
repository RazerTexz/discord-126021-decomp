package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.n.BitArray;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import java.util.EnumMap;

/* JADX INFO: renamed from: b.i.e.q.o, reason: use source file name */
/* JADX INFO: compiled from: UPCEANExtensionSupport.java */
/* JADX INFO: loaded from: classes3.dex */
public final class UPCEANExtensionSupport {
    public static final int[] a = {1, 1, 2};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final UPCEANExtension2Support f1860b = new UPCEANExtension2Support();
    public final UPCEANExtension5Support c = new UPCEANExtension5Support();

    public Result a(int i, BitArray bitArray, int i2) throws NotFoundException {
        EnumMap enumMap;
        int[] iArr = a;
        int[] iArrL = UPCEANReader.l(bitArray, i2, false, iArr, new int[iArr.length]);
        try {
            return this.c.a(i, bitArray, iArrL);
        } catch (ReaderException unused) {
            UPCEANExtension2Support uPCEANExtension2Support = this.f1860b;
            StringBuilder sb = uPCEANExtension2Support.f1858b;
            sb.setLength(0);
            int[] iArr2 = uPCEANExtension2Support.a;
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[2] = 0;
            iArr2[3] = 0;
            int i3 = bitArray.k;
            int iG = iArrL[1];
            int i4 = 0;
            for (int i5 = 0; i5 < 2 && iG < i3; i5++) {
                int iH = UPCEANReader.h(bitArray, iArr2, iG, UPCEANReader.d);
                sb.append((char) ((iH % 10) + 48));
                for (int i6 : iArr2) {
                    iG += i6;
                }
                if (iH >= 10) {
                    i4 |= 1 << (1 - i5);
                }
                if (i5 != 1) {
                    iG = bitArray.g(bitArray.f(iG));
                }
            }
            if (sb.length() != 2) {
                throw NotFoundException.l;
            }
            if (Integer.parseInt(sb.toString()) % 4 != i4) {
                throw NotFoundException.l;
            }
            String string = sb.toString();
            if (string.length() != 2) {
                enumMap = null;
            } else {
                enumMap = new EnumMap(ResultMetadataType.class);
                enumMap.put(ResultMetadataType.ISSUE_NUMBER, Integer.valueOf(string));
            }
            float f = i;
            Result result = new Result(string, null, new ResultPoint[]{new ResultPoint((iArrL[0] + iArrL[1]) / 2.0f, f), new ResultPoint(iG, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
            if (enumMap != null) {
                result.a(enumMap);
            }
            return result;
        }
    }
}
