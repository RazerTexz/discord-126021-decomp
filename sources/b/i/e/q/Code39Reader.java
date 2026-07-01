package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.DecodeHintType;
import b.i.e.ResultPoint;
import b.i.e.n.BitArray;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.q.c, reason: use source file name */
/* JADX INFO: compiled from: Code39Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Code39Reader extends OneDReader {
    public static final int[] a = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, Opcodes.INSTANCEOF, 448, Opcodes.I2B, 400, 208, Opcodes.I2L, 388, 196, Opcodes.JSR, Opcodes.IF_ICMPGE, Opcodes.L2D, 42};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1854b;
    public final StringBuilder c = new StringBuilder(20);
    public final int[] d = new int[9];

    public Code39Reader(boolean z2) {
        this.f1854b = z2;
    }

    public static int g(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            }
            if (i4 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    @Override // b.i.e.q.OneDReader
    public Result b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        char cCharAt;
        int[] iArr = this.d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.c;
        sb.setLength(0);
        int i2 = bitArray.k;
        int iF = bitArray.f(0);
        int length = iArr.length;
        int i3 = iF;
        boolean z2 = false;
        int i4 = 0;
        while (iF < i2) {
            if (bitArray.b(iF) != z2) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (g(iArr) == 148 && bitArray.h(Math.max(0, i3 - ((iF - i3) / 2)), i3, false)) {
                    int[] iArr2 = {i3, iF};
                    int iF2 = bitArray.f(iArr2[1]);
                    int i5 = bitArray.k;
                    while (true) {
                        OneDReader.e(bitArray, iF2, iArr);
                        int iG = g(iArr);
                        if (iG < 0) {
                            throw NotFoundException.l;
                        }
                        int i6 = 0;
                        while (true) {
                            int[] iArr3 = a;
                            if (i6 >= iArr3.length) {
                                if (iG != 148) {
                                    throw NotFoundException.l;
                                }
                                cCharAt = '*';
                                break;
                            }
                            if (iArr3[i6] == iG) {
                                cCharAt = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i6);
                                break;
                            }
                            i6++;
                        }
                        sb.append(cCharAt);
                        int i7 = iF2;
                        for (int i8 : iArr) {
                            i7 += i8;
                        }
                        int iF3 = bitArray.f(i7);
                        if (cCharAt == '*') {
                            sb.setLength(sb.length() - 1);
                            int i9 = 0;
                            for (int i10 : iArr) {
                                i9 += i10;
                            }
                            int i11 = (iF3 - iF2) - i9;
                            if (iF3 != i5 && (i11 << 1) < i9) {
                                throw NotFoundException.l;
                            }
                            if (this.f1854b) {
                                int length2 = sb.length() - 1;
                                int iIndexOf = 0;
                                for (int i12 = 0; i12 < length2; i12++) {
                                    iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.c.charAt(i12));
                                }
                                if (sb.charAt(length2) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                                    throw ChecksumException.a();
                                }
                                sb.setLength(length2);
                            }
                            if (sb.length() == 0) {
                                throw NotFoundException.l;
                            }
                            float f = i;
                            return new Result(sb.toString(), null, new ResultPoint[]{new ResultPoint((iArr2[1] + iArr2[0]) / 2.0f, f), new ResultPoint((i9 / 2.0f) + iF2, f)}, BarcodeFormat.CODE_39);
                        }
                        iF2 = iF3;
                    }
                } else {
                    i3 += iArr[0] + iArr[1];
                    int i13 = i4 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i13);
                    iArr[i13] = 0;
                    iArr[i4] = 0;
                    i4 = i13;
                }
                iArr[i4] = 1;
                z2 = !z2;
            }
            iF++;
        }
        throw NotFoundException.l;
    }
}
