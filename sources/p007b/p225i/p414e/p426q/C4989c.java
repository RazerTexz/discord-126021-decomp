package p007b.p225i.p414e.p426q;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.Arrays;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.c */
/* JADX INFO: compiled from: Code39Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4989c extends AbstractC4997k {

    /* JADX INFO: renamed from: a */
    public static final int[] f13359a = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, Opcodes.INSTANCEOF, 448, Opcodes.I2B, 400, 208, Opcodes.I2L, 388, 196, Opcodes.JSR, Opcodes.IF_ICMPGE, Opcodes.L2D, 42};

    /* JADX INFO: renamed from: b */
    public final boolean f13360b;

    /* JADX INFO: renamed from: c */
    public final StringBuilder f13361c = new StringBuilder(20);

    /* JADX INFO: renamed from: d */
    public final int[] f13362d = new int[9];

    public C4989c(boolean z2) {
        this.f13360b = z2;
    }

    /* JADX INFO: renamed from: g */
    public static int m6986g(int[] iArr) {
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

    @Override // p007b.p225i.p414e.p426q.AbstractC4997k
    /* JADX INFO: renamed from: b */
    public Result mo6983b(int i, C4962a c4962a, Map<EnumC4949d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        char cCharAt;
        int[] iArr = this.f13362d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f13361c;
        sb.setLength(0);
        int i2 = c4962a.f13228k;
        int iM6936f = c4962a.m6936f(0);
        int length = iArr.length;
        int i3 = iM6936f;
        boolean z2 = false;
        int i4 = 0;
        while (iM6936f < i2) {
            if (c4962a.m6935b(iM6936f) != z2) {
                iArr[i4] = iArr[i4] + 1;
            } else {
                if (i4 != length - 1) {
                    i4++;
                } else if (m6986g(iArr) == 148 && c4962a.m6938h(Math.max(0, i3 - ((iM6936f - i3) / 2)), i3, false)) {
                    int[] iArr2 = {i3, iM6936f};
                    int iM6936f2 = c4962a.m6936f(iArr2[1]);
                    int i5 = c4962a.f13228k;
                    while (true) {
                        AbstractC4997k.m6997e(c4962a, iM6936f2, iArr);
                        int iM6986g = m6986g(iArr);
                        if (iM6986g < 0) {
                            throw NotFoundException.f21665l;
                        }
                        int i6 = 0;
                        while (true) {
                            int[] iArr3 = f13359a;
                            if (i6 >= iArr3.length) {
                                if (iM6986g != 148) {
                                    throw NotFoundException.f21665l;
                                }
                                cCharAt = '*';
                                break;
                            }
                            if (iArr3[i6] == iM6986g) {
                                cCharAt = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i6);
                                break;
                            }
                            i6++;
                        }
                        sb.append(cCharAt);
                        int i7 = iM6936f2;
                        for (int i8 : iArr) {
                            i7 += i8;
                        }
                        int iM6936f3 = c4962a.m6936f(i7);
                        if (cCharAt == '*') {
                            sb.setLength(sb.length() - 1);
                            int i9 = 0;
                            for (int i10 : iArr) {
                                i9 += i10;
                            }
                            int i11 = (iM6936f3 - iM6936f2) - i9;
                            if (iM6936f3 != i5 && (i11 << 1) < i9) {
                                throw NotFoundException.f21665l;
                            }
                            if (this.f13360b) {
                                int length2 = sb.length() - 1;
                                int iIndexOf = 0;
                                for (int i12 = 0; i12 < length2; i12++) {
                                    iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f13361c.charAt(i12));
                                }
                                if (sb.charAt(length2) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                                    throw ChecksumException.m9259a();
                                }
                                sb.setLength(length2);
                            }
                            if (sb.length() == 0) {
                                throw NotFoundException.f21665l;
                            }
                            float f = i;
                            return new Result(sb.toString(), null, new C4956k[]{new C4956k((iArr2[1] + iArr2[0]) / 2.0f, f), new C4956k((i9 / 2.0f) + iM6936f2, f)}, EnumC4946a.CODE_39);
                        }
                        iM6936f2 = iM6936f3;
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
            iM6936f++;
        }
        throw NotFoundException.f21665l;
    }
}
