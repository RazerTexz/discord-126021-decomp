package p007b.p225i.p414e.p426q;

import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.d */
/* JADX INFO: compiled from: Code93Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4990d extends AbstractC4997k {

    /* JADX INFO: renamed from: a */
    public static final char[] f13363a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    /* JADX INFO: renamed from: b */
    public static final int[] f13364b;

    /* JADX INFO: renamed from: c */
    public static final int f13365c;

    /* JADX INFO: renamed from: d */
    public final StringBuilder f13366d = new StringBuilder(20);

    /* JADX INFO: renamed from: e */
    public final int[] f13367e = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f13364b = iArr;
        f13365c = iArr[47];
    }

    /* JADX INFO: renamed from: g */
    public static void m6987g(CharSequence charSequence, int i, int i2) throws ChecksumException {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != f13363a[iIndexOf % 47]) {
            throw ChecksumException.m9259a();
        }
    }

    /* JADX INFO: renamed from: h */
    public static int m6988h(int[] iArr) {
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

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i2;
        char c;
        int i3 = c4962a.f13228k;
        int iM6936f = c4962a.m6936f(0);
        Arrays.fill(this.f13367e, 0);
        int[] iArr = this.f13367e;
        int length = iArr.length;
        int i4 = iM6936f;
        boolean z2 = false;
        int i5 = 0;
        while (iM6936f < i3) {
            if (c4962a.m6935b(iM6936f) != z2) {
                iArr[i5] = iArr[i5] + 1;
            } else {
                if (i5 != length - 1) {
                    i5++;
                } else if (m6988h(iArr) == f13365c) {
                    int[] iArr2 = {i4, iM6936f};
                    int iM6936f2 = c4962a.m6936f(iArr2[1]);
                    int i6 = c4962a.f13228k;
                    int[] iArr3 = this.f13367e;
                    Arrays.fill(iArr3, 0);
                    StringBuilder sb = this.f13366d;
                    sb.setLength(0);
                    while (true) {
                        AbstractC4997k.m6997e(c4962a, iM6936f2, iArr3);
                        int iM6988h = m6988h(iArr3);
                        if (iM6988h < 0) {
                            throw NotFoundException.f21665l;
                        }
                        int i7 = 0;
                        while (true) {
                            int[] iArr4 = f13364b;
                            if (i7 >= iArr4.length) {
                                throw NotFoundException.f21665l;
                            }
                            if (iArr4[i7] == iM6988h) {
                                break;
                            }
                            i7++;
                        }
                        char c2 = f13363a[i7];
                        sb.append(c2);
                        int i8 = iM6936f2;
                        for (int i9 : iArr3) {
                            i8 += i9;
                        }
                        int iM6936f3 = c4962a.m6936f(i8);
                        if (c2 == '*') {
                            sb.deleteCharAt(sb.length() - 1);
                            int i10 = 0;
                            for (int i11 : iArr3) {
                                i10 += i11;
                            }
                            if (iM6936f3 == i6 || !c4962a.m6935b(iM6936f3)) {
                                throw NotFoundException.f21665l;
                            }
                            if (sb.length() < 2) {
                                throw NotFoundException.f21665l;
                            }
                            int length2 = sb.length();
                            m6987g(sb, length2 - 2, 20);
                            m6987g(sb, length2 - 1, 15);
                            sb.setLength(sb.length() - 2);
                            int length3 = sb.length();
                            StringBuilder sb2 = new StringBuilder(length3);
                            int i12 = 0;
                            while (i12 < length3) {
                                char cCharAt = sb.charAt(i12);
                                if (cCharAt >= 'a' && cCharAt <= 'd') {
                                    if (i12 >= length3 - 1) {
                                        throw FormatException.m9260a();
                                    }
                                    i12++;
                                    char cCharAt2 = sb.charAt(i12);
                                    switch (cCharAt) {
                                        case 'a':
                                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                                throw FormatException.m9260a();
                                            }
                                            i2 = cCharAt2 - '@';
                                            c = (char) i2;
                                            sb2.append(c);
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
                                                        throw FormatException.m9260a();
                                                    }
                                                    c = 127;
                                                }
                                                sb2.append(c);
                                            } else {
                                                i2 = cCharAt2 + 16;
                                            }
                                            c = (char) i2;
                                            sb2.append(c);
                                            break;
                                        case 'c':
                                            if (cCharAt2 >= 'A' && cCharAt2 <= 'O') {
                                                i2 = cCharAt2 - ' ';
                                                c = (char) i2;
                                            } else {
                                                if (cCharAt2 != 'Z') {
                                                    throw FormatException.m9260a();
                                                }
                                                c = MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
                                            }
                                            sb2.append(c);
                                            break;
                                        case 'd':
                                            if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                                                throw FormatException.m9260a();
                                            }
                                            i2 = cCharAt2 + ' ';
                                            c = (char) i2;
                                            sb2.append(c);
                                            break;
                                            break;
                                        default:
                                            c = 0;
                                            sb2.append(c);
                                            break;
                                    }
                                } else {
                                    sb2.append(cCharAt);
                                }
                                i12++;
                            }
                            float f = i;
                            return new Result(sb2.toString(), null, new C4956k[]{new C4956k((iArr2[1] + iArr2[0]) / 2.0f, f), new C4956k((i10 / 2.0f) + iM6936f2, f)}, EnumC4946a.CODE_93);
                        }
                        iM6936f2 = iM6936f3;
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
            iM6936f++;
        }
        throw NotFoundException.f21665l;
    }
}
