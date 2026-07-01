package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.n.BitArray;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.q.q, reason: use source file name */
/* JADX INFO: compiled from: UPCEReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class UPCEReader extends UPCEANReader {
    public static final int[] h = {1, 1, 1, 1, 1, 1};
    public static final int[][] i = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};
    public final int[] j = new int[4];

    @Override // b.i.e.q.UPCEANReader
    public boolean g(String str) throws FormatException {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return super.g(sb.toString());
    }

    @Override // b.i.e.q.UPCEANReader
    public int[] i(BitArray bitArray, int i2) throws NotFoundException {
        int[] iArr = h;
        return UPCEANReader.l(bitArray, i2, true, iArr, new int[iArr.length]);
    }

    @Override // b.i.e.q.UPCEANReader
    public int j(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = bitArray.k;
        int i3 = iArr[1];
        int i4 = 0;
        for (int i5 = 0; i5 < 6 && i3 < i2; i5++) {
            int iH = UPCEANReader.h(bitArray, iArr2, i3, UPCEANReader.d);
            sb.append((char) ((iH % 10) + 48));
            for (int i6 : iArr2) {
                i3 += i6;
            }
            if (iH >= 10) {
                i4 |= 1 << (5 - i5);
            }
        }
        for (int i7 = 0; i7 <= 1; i7++) {
            for (int i8 = 0; i8 < 10; i8++) {
                if (i4 == i[i7][i8]) {
                    sb.insert(0, (char) (i7 + 48));
                    sb.append((char) (i8 + 48));
                    return i3;
                }
            }
        }
        throw NotFoundException.l;
    }

    @Override // b.i.e.q.UPCEANReader
    public BarcodeFormat n() {
        return BarcodeFormat.UPC_E;
    }
}
