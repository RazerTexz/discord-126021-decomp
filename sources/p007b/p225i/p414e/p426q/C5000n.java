package p007b.p225i.p414e.p426q;

import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.util.EnumMap;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4955j;
import p007b.p225i.p414e.p418n.C4962a;

/* JADX INFO: renamed from: b.i.e.q.n */
/* JADX INFO: compiled from: UPCEANExtension5Support.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5000n {

    /* JADX INFO: renamed from: a */
    public static final int[] f13383a = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    /* JADX INFO: renamed from: b */
    public final int[] f13384b = new int[4];

    /* JADX INFO: renamed from: c */
    public final StringBuilder f13385c = new StringBuilder();

    /* JADX WARN: Code duplicated, block: B:67:0x0120  */
    /* JADX WARN: Code duplicated, block: B:68:0x0122  */
    /* JADX INFO: renamed from: a */
    public Result m7002a(int i, C4962a c4962a, int[] iArr) throws NotFoundException {
        EnumMap enumMap;
        String str;
        String str2;
        StringBuilder sb = this.f13385c;
        sb.setLength(0);
        int[] iArr2 = this.f13384b;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int i2 = c4962a.f13228k;
        int iM6937g = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 5 && iM6937g < i2; i4++) {
            int iM7004h = AbstractC5002p.m7004h(c4962a, iArr2, iM6937g, AbstractC5002p.f13392d);
            sb.append((char) ((iM7004h % 10) + 48));
            for (int i5 : iArr2) {
                iM6937g += i5;
            }
            if (iM7004h >= 10) {
                i3 |= 1 << (4 - i4);
            }
            if (i4 != 4) {
                iM6937g = c4962a.m6937g(c4962a.m6936f(iM6937g));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.f21665l;
        }
        for (int i6 = 0; i6 < 10; i6++) {
            if (i3 == f13383a[i6]) {
                String string = sb.toString();
                int length = string.length();
                int iCharAt = 0;
                for (int i7 = length - 2; i7 >= 0; i7 -= 2) {
                    iCharAt += string.charAt(i7) - '0';
                }
                int iCharAt2 = iCharAt * 3;
                for (int i8 = length - 1; i8 >= 0; i8 -= 2) {
                    iCharAt2 += string.charAt(i8) - '0';
                }
                if ((iCharAt2 * 3) % 10 != i6) {
                    throw NotFoundException.f21665l;
                }
                String string2 = sb.toString();
                if (string2.length() == 5) {
                    char cCharAt = string2.charAt(0);
                    if (cCharAt == '0') {
                        str = "£";
                    } else if (cCharAt != '5') {
                        if (cCharAt == '9') {
                            switch (string2) {
                                case "90000":
                                    str2 = null;
                                    break;
                                case "99990":
                                    str2 = "Used";
                                    break;
                                case "99991":
                                    str2 = "0.00";
                                    break;
                            }
                            if (str2 == null) {
                                enumMap = null;
                            } else {
                                enumMap = new EnumMap(EnumC4955j.class);
                                enumMap.put(EnumC4955j.SUGGESTED_PRICE, str2);
                            }
                        }
                        str = "";
                    } else {
                        str = "$";
                    }
                    int i9 = Integer.parseInt(string2.substring(1));
                    String strValueOf = String.valueOf(i9 / 100);
                    int i10 = i9 % 100;
                    str2 = str + strValueOf + '.' + (i10 < 10 ? "0".concat(String.valueOf(i10)) : String.valueOf(i10));
                    if (str2 == null) {
                        enumMap = null;
                    } else {
                        enumMap = new EnumMap(EnumC4955j.class);
                        enumMap.put(EnumC4955j.SUGGESTED_PRICE, str2);
                    }
                } else {
                    enumMap = null;
                }
                float f = i;
                Result result = new Result(string2, null, new C4956k[]{new C4956k((iArr[0] + iArr[1]) / 2.0f, f), new C4956k(iM6937g, f)}, EnumC4946a.UPC_EAN_EXTENSION);
                if (enumMap != null) {
                    result.m9261a(enumMap);
                }
                return result;
            }
        }
        throw NotFoundException.f21665l;
    }
}
