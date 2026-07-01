package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.DecodeHintType;
import b.i.e.ResultPoint;
import b.i.e.n.BitArray;
import com.discord.widgets.chat.input.MentionUtils;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.q.d, reason: use source file name */
/* JADX INFO: compiled from: Code93Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Code93Reader extends OneDReader {
    public static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1855b;
    public static final int c;
    public final StringBuilder d = new StringBuilder(20);
    public final int[] e = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f1855b = iArr;
        c = iArr[47];
    }

    public static void g(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != a[iIndexOf % 47]) {
            throw ChecksumException.a();
        }
    }

    public static int h(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = Math.round((iArr[i4] * 9.0f) / i);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < iRound; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    @Override // b.i.e.q.OneDReader
    public Result b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i2;
        char c2;
        int i3 = bitArray.k;
        int iF = bitArray.f(0);
        Arrays.fill(this.e, 0);
        int[] iArr = this.e;
        int length = iArr.length;
        int i4 = iF;
        boolean z2 = false;
        int i5 = 0;
        while (iF < i3) {
            if (bitArray.b(iF) != z2) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (h(iArr) == c) {
                    int[] iArr2 = {i4, iF};
                    int iF2 = bitArray.f(iArr2[1]);
                    int i6 = bitArray.k;
                    int[] iArr3 = this.e;
                    Arrays.fill(iArr3, 0);
                    StringBuilder sb = this.d;
                    sb.setLength(0);
                    while (true) {
                        OneDReader.e(bitArray, iF2, iArr3);
                        int iH = h(iArr3);
                        if (iH < 0) {
                            throw NotFoundException.l;
                        }
                        int i7 = 0;
                        while (true) {
                            int[] iArr4 = f1855b;
                            if (i7 >= iArr4.length) {
                                throw NotFoundException.l;
                            }
                            if (iArr4[i7] == iH) {
                                break;
                            }
                            i7++;
                        }
                        char c3 = a[i7];
                        sb.append(c3);
                        int i8 = iF2;
                        for (int i9 : iArr3) {
                            i8 += i9;
                        }
                        int iF3 = bitArray.f(i8);
                        if (c3 == '*') {
                            sb.deleteCharAt(sb.length() - 1);
                            int i10 = 0;
                            for (int i11 : iArr3) {
                                i10 += i11;
                            }
                            if (iF3 == i6 || !bitArray.b(iF3)) {
                                throw NotFoundException.l;
                            }
                            if (sb.length() < 2) {
                                throw NotFoundException.l;
                            }
                            int length2 = sb.length();
                            g(sb, length2 - 2, 20);
                            g(sb, length2 - 1, 15);
                            sb.setLength(sb.length() - 2);
                            int length3 = sb.length();
                            StringBuilder sb2 = new StringBuilder(length3);
                            int i12 = 0;
                            while (i12 < length3) {
                                char cCharAt = sb.charAt(i12);
                                if (cCharAt >= 'a' && cCharAt <= 'd') {
                                    if (i12 >= length3 - 1) {
                                        throw FormatException.a();
                                    }
                                    i12++;
                                    char cCharAt2 = sb.charAt(i12);
                                    switch (cCharAt) {
                                        case 'a':
                                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                                throw FormatException.a();
                                            }
                                            i2 = cCharAt2 - '@';
                                            c2 = (char) i2;
                                            sb2.append(c2);
                                            break;
                                            break;
                                        case 'b':
                                            if (cCharAt2 >= 'A' && cCharAt2 <= 'E') {
                                                i2 = cCharAt2 - '&';
                                            } else if (cCharAt2 >= 'F' && cCharAt2 <= 'J') {
                                                i2 = cCharAt2 - 11;
                                            } else if (cCharAt2 < 'K' || cCharAt2 > 'O') {
                                                if (cCharAt2 >= 'P' && cCharAt2 <= 'S') {
                                                    i2 = cCharAt2 + '+';
                                                } else {
                                                    if (cCharAt2 < 'T' || cCharAt2 > 'Z') {
                                                        throw FormatException.a();
                                                    }
                                                    c2 = 127;
                                                }
                                                sb2.append(c2);
                                            } else {
                                                i2 = cCharAt2 + 16;
                                            }
                                            c2 = (char) i2;
                                            sb2.append(c2);
                                            break;
                                        case 'c':
                                            if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                                i2 = cCharAt2 - ' ';
                                                c2 = (char) i2;
                                            } else {
                                                if (cCharAt2 != 'Z') {
                                                    throw FormatException.a();
                                                }
                                                c2 = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
                                            }
                                            sb2.append(c2);
                                            break;
                                        case 'd':
                                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                                throw FormatException.a();
                                            }
                                            i2 = cCharAt2 + ' ';
                                            c2 = (char) i2;
                                            sb2.append(c2);
                                            break;
                                            break;
                                        default:
                                            c2 = 0;
                                            sb2.append(c2);
                                            break;
                                    }
                                } else {
                                    sb2.append(cCharAt);
                                }
                                i12++;
                            }
                            float f = i;
                            return new Result(sb2.toString(), null, new ResultPoint[]{new ResultPoint((iArr2[1] + iArr2[0]) / 2.0f, f), new ResultPoint((i10 / 2.0f) + iF2, f)}, BarcodeFormat.CODE_93);
                        }
                        iF2 = iF3;
                    }
                } else {
                    i4 += iArr[0] + iArr[1];
                    int i13 = i5 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i5] = 0;
                    i5 = i13;
                }
                iArr[i5] = 1;
                z2 = !z2;
            }
            iF++;
        }
        throw NotFoundException.l;
    }
}
