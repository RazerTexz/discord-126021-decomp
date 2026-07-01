package b.i.e.q;

import b.i.e.BarcodeFormat;
import b.i.e.DecodeHintType;
import b.i.e.ResultPoint;
import b.i.e.n.BitArray;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: b.i.e.q.a, reason: use source file name */
/* JADX INFO: compiled from: CodaBarReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class CodaBarReader extends OneDReader {
    public static final char[] a = "0123456789-$:/.+ABCD".toCharArray();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1853b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};
    public static final char[] c = {'A', 'B', 'C', 'D'};
    public final StringBuilder d = new StringBuilder(20);
    public int[] e = new int[80];
    public int f = 0;

    public static boolean g(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // b.i.e.q.OneDReader
    public Result b(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException {
        Arrays.fill(this.e, 0);
        this.f = 0;
        int iG = bitArray.g(0);
        int i2 = bitArray.k;
        if (iG >= i2) {
            throw NotFoundException.l;
        }
        int i3 = 0;
        boolean z2 = true;
        while (iG < i2) {
            if (bitArray.b(iG) != z2) {
                i3++;
            } else {
                h(i3);
                z2 = !z2;
                i3 = 1;
            }
            iG++;
        }
        h(i3);
        int i4 = 1;
        while (i4 < this.f) {
            int i5 = i(i4);
            if (i5 != -1 && g(c, a[i5])) {
                int i6 = 0;
                for (int i7 = i4; i7 < i4 + 7; i7++) {
                    i6 += this.e[i7];
                }
                if (i4 == 1 || this.e[i4 - 1] >= i6 / 2) {
                    this.d.setLength(0);
                    int i8 = i4;
                    do {
                        int i9 = i(i8);
                        if (i9 == -1) {
                            throw NotFoundException.l;
                        }
                        this.d.append((char) i9);
                        i8 += 8;
                        if (this.d.length() > 1 && g(c, a[i9])) {
                            break;
                        }
                    } while (i8 < this.f);
                    int i10 = i8 - 1;
                    int i11 = this.e[i10];
                    int i12 = 0;
                    for (int i13 = -8; i13 < -1; i13++) {
                        i12 += this.e[i8 + i13];
                    }
                    if (i8 < this.f && i11 < i12 / 2) {
                        throw NotFoundException.l;
                    }
                    int[] iArr = {0, 0, 0, 0};
                    int[] iArr2 = {0, 0, 0, 0};
                    int length = this.d.length() - 1;
                    int i14 = i4;
                    int i15 = 0;
                    while (true) {
                        int i16 = f1853b[this.d.charAt(i15)];
                        for (int i17 = 6; i17 >= 0; i17--) {
                            int i18 = (i17 & 1) + ((i16 & 1) << 1);
                            iArr[i18] = iArr[i18] + this.e[i14 + i17];
                            iArr2[i18] = iArr2[i18] + 1;
                            i16 >>= 1;
                        }
                        if (i15 >= length) {
                            break;
                        }
                        i14 += 8;
                        i15++;
                    }
                    float[] fArr = new float[4];
                    float[] fArr2 = new float[4];
                    int i19 = 0;
                    for (int i20 = 2; i19 < i20; i20 = 2) {
                        fArr2[i19] = 0.0f;
                        int i21 = i19 + 2;
                        fArr2[i21] = ((iArr[i21] / iArr2[i21]) + (iArr[i19] / iArr2[i19])) / 2.0f;
                        fArr[i19] = fArr2[i21];
                        fArr[i21] = ((iArr[i21] * 2.0f) + 1.5f) / iArr2[i21];
                        i19++;
                    }
                    int i22 = i4;
                    int i23 = 0;
                    loop8: while (true) {
                        int i24 = f1853b[this.d.charAt(i23)];
                        for (int i25 = 6; i25 >= 0; i25--) {
                            int i26 = (i25 & 1) + ((i24 & 1) << 1);
                            float f = this.e[i22 + i25];
                            if (f < fArr2[i26] || f > fArr[i26]) {
                                break loop8;
                            }
                            i24 >>= 1;
                        }
                        if (i23 >= length) {
                            for (int i27 = 0; i27 < this.d.length(); i27++) {
                                StringBuilder sb = this.d;
                                sb.setCharAt(i27, a[sb.charAt(i27)]);
                            }
                            char cCharAt = this.d.charAt(0);
                            char[] cArr = c;
                            if (!g(cArr, cCharAt)) {
                                throw NotFoundException.l;
                            }
                            StringBuilder sb2 = this.d;
                            if (!g(cArr, sb2.charAt(sb2.length() - 1))) {
                                throw NotFoundException.l;
                            }
                            if (this.d.length() <= 3) {
                                throw NotFoundException.l;
                            }
                            if (map == null || !map.containsKey(DecodeHintType.RETURN_CODABAR_START_END)) {
                                StringBuilder sb3 = this.d;
                                sb3.deleteCharAt(sb3.length() - 1);
                                this.d.deleteCharAt(0);
                            }
                            int i28 = 0;
                            for (int i29 = 0; i29 < i4; i29++) {
                                i28 += this.e[i29];
                            }
                            float f2 = i28;
                            while (i4 < i10) {
                                i28 += this.e[i4];
                                i4++;
                            }
                            float f3 = i;
                            return new Result(this.d.toString(), null, new ResultPoint[]{new ResultPoint(f2, f3), new ResultPoint(i28, f3)}, BarcodeFormat.CODABAR);
                        }
                        i22 += 8;
                        i23++;
                    }
                    throw NotFoundException.l;
                }
            }
            i4 += 2;
        }
        throw NotFoundException.l;
    }

    public final void h(int i) {
        int[] iArr = this.e;
        int i2 = this.f;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.f = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[i3 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.e = iArr2;
        }
    }

    public final int i(int i) {
        int i2 = i + 7;
        if (i2 >= this.f) {
            return -1;
        }
        int[] iArr = this.e;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        int i5 = Integer.MAX_VALUE;
        int i6 = 0;
        for (int i7 = i; i7 < i2; i7 += 2) {
            int i8 = iArr[i7];
            if (i8 < i5) {
                i5 = i8;
            }
            if (i8 > i6) {
                i6 = i8;
            }
        }
        int i9 = (i5 + i6) / 2;
        int i10 = 0;
        for (int i11 = i + 1; i11 < i2; i11 += 2) {
            int i12 = iArr[i11];
            if (i12 < i3) {
                i3 = i12;
            }
            if (i12 > i10) {
                i10 = i12;
            }
        }
        int i13 = (i3 + i10) / 2;
        int i14 = 128;
        int i15 = 0;
        for (int i16 = 0; i16 < 7; i16++) {
            i14 >>= 1;
            if (iArr[i + i16] > ((i16 & 1) == 0 ? i9 : i13)) {
                i15 |= i14;
            }
        }
        while (true) {
            int[] iArr2 = f1853b;
            if (i4 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i4] == i15) {
                return i4;
            }
            i4++;
        }
    }
}
