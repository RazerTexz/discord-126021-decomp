package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.a */
/* JADX INFO: compiled from: CodaBarReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4987a extends AbstractC4997k {

    /* JADX INFO: renamed from: a */
    public static final char[] f13352a = "0123456789-$:/.+ABCD".toCharArray();

    /* JADX INFO: renamed from: b */
    public static final int[] f13353b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* JADX INFO: renamed from: c */
    public static final char[] f13354c = {'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: d */
    public final StringBuilder f13355d = new StringBuilder(20);

    /* JADX INFO: renamed from: e */
    public int[] f13356e = new int[80];

    /* JADX INFO: renamed from: f */
    public int f13357f = 0;

    /* JADX INFO: renamed from: g */
    public static boolean m6982g(char[] cArr, char c) {
        if (cArr != null) {
            for (char c2 : cArr) {
                if (c2 == c) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException {
        Arrays.fill(this.f13356e, 0);
        this.f13357f = 0;
        int iM6937g = c4962a.m6937g(0);
        int i2 = c4962a.f13228k;
        if (iM6937g >= i2) {
            throw NotFoundException.f21665l;
        }
        int i3 = 0;
        boolean z2 = true;
        while (iM6937g < i2) {
            if (c4962a.m6935b(iM6937g) != z2) {
                i3++;
            } else {
                m6984h(i3);
                z2 = !z2;
                i3 = 1;
            }
            iM6937g++;
        }
        m6984h(i3);
        int i4 = 1;
        while (i4 < this.f13357f) {
            int iM6985i = m6985i(i4);
            if (iM6985i != -1 && m6982g(f13354c, f13352a[iM6985i])) {
                int i5 = 0;
                for (int i6 = i4; i6 < i4 + 7; i6++) {
                    i5 += this.f13356e[i6];
                }
                if (i4 == 1 || this.f13356e[i4 - 1] >= i5 / 2) {
                    this.f13355d.setLength(0);
                    int i7 = i4;
                    do {
                        int iM6985i2 = m6985i(i7);
                        if (iM6985i2 == -1) {
                            throw NotFoundException.f21665l;
                        }
                        this.f13355d.append((char) iM6985i2);
                        i7 += 8;
                        if (this.f13355d.length() > 1 && m6982g(f13354c, f13352a[iM6985i2])) {
                            break;
                        }
                    } while (i7 < this.f13357f);
                    int i8 = i7 - 1;
                    int i9 = this.f13356e[i8];
                    int i10 = 0;
                    for (int i11 = -8; i11 < -1; i11++) {
                        i10 += this.f13356e[i7 + i11];
                    }
                    if (i7 < this.f13357f && i9 < i10 / 2) {
                        throw NotFoundException.f21665l;
                    }
                    int[] iArr = {0, 0, 0, 0};
                    int[] iArr2 = {0, 0, 0, 0};
                    int length = this.f13355d.length() - 1;
                    int i12 = i4;
                    int i13 = 0;
                    while (true) {
                        int i14 = f13353b[this.f13355d.charAt(i13)];
                        for (int i15 = 6; i15 >= 0; i15--) {
                            int i16 = (i15 & 1) + ((i14 & 1) << 1);
                            iArr[i16] = iArr[i16] + this.f13356e[i12 + i15];
                            iArr2[i16] = iArr2[i16] + 1;
                            i14 >>= 1;
                        }
                        if (i13 >= length) {
                            break;
                        }
                        i12 += 8;
                        i13++;
                    }
                    float[] fArr = new float[4];
                    float[] fArr2 = new float[4];
                    int i17 = 0;
                    for (int i18 = 2; i17 < i18; i18 = 2) {
                        fArr2[i17] = 0.0f;
                        int i19 = i17 + 2;
                        fArr2[i19] = ((iArr[i19] / iArr2[i19]) + (iArr[i17] / iArr2[i17])) / 2.0f;
                        fArr[i17] = fArr2[i19];
                        fArr[i19] = ((iArr[i19] * 2.0f) + 1.5f) / iArr2[i19];
                        i17++;
                    }
                    int i20 = i4;
                    int i21 = 0;
                    loop8: while (true) {
                        int i22 = f13353b[this.f13355d.charAt(i21)];
                        for (int i23 = 6; i23 >= 0; i23--) {
                            int i24 = (i23 & 1) + ((i22 & 1) << 1);
                            float f = this.f13356e[i20 + i23];
                            if (f < fArr2[i24] || f > fArr[i24]) {
                                break loop8;
                            }
                            i22 >>= 1;
                        }
                        if (i21 >= length) {
                            for (int i25 = 0; i25 < this.f13355d.length(); i25++) {
                                StringBuilder sb = this.f13355d;
                                sb.setCharAt(i25, f13352a[sb.charAt(i25)]);
                            }
                            char cCharAt = this.f13355d.charAt(0);
                            char[] cArr = f13354c;
                            if (!m6982g(cArr, cCharAt)) {
                                throw NotFoundException.f21665l;
                            }
                            StringBuilder sb2 = this.f13355d;
                            if (!m6982g(cArr, sb2.charAt(sb2.length() - 1))) {
                                throw NotFoundException.f21665l;
                            }
                            if (this.f13355d.length() <= 3) {
                                throw NotFoundException.f21665l;
                            }
                            if (map == null || !map.containsKey(EnumC4949d.RETURN_CODABAR_START_END)) {
                                StringBuilder sb3 = this.f13355d;
                                sb3.deleteCharAt(sb3.length() - 1);
                                this.f13355d.deleteCharAt(0);
                            }
                            int i26 = 0;
                            for (int i27 = 0; i27 < i4; i27++) {
                                i26 += this.f13356e[i27];
                            }
                            float f2 = i26;
                            while (i4 < i8) {
                                i26 += this.f13356e[i4];
                                i4++;
                            }
                            float f3 = i;
                            return new Result(this.f13355d.toString(), null, new C4956k[]{new C4956k(f2, f3), new C4956k(i26, f3)}, EnumC4946a.CODABAR);
                        }
                        i20 += 8;
                        i21++;
                    }
                    throw NotFoundException.f21665l;
                }
            }
            i4 += 2;
        }
        throw NotFoundException.f21665l;
    }

    /* JADX INFO: renamed from: h */
    public final void m6984h(int i) {
        int[] iArr = this.f13356e;
        int i2 = this.f13357f;
        iArr[i2] = i;
        int i3 = i2 + 1;
        this.f13357f = i3;
        if (i3 >= iArr.length) {
            int[] iArr2 = new int[i3 << 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f13356e = iArr2;
        }
    }

    /* JADX INFO: renamed from: i */
    public final int m6985i(int i) {
        int i2 = i + 7;
        if (i2 >= this.f13357f) {
            return -1;
        }
        int[] iArr = this.f13356e;
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
            int[] iArr2 = f13353b;
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
