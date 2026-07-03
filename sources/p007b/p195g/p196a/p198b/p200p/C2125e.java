package p007b.p195g.p196a.p198b.p200p;

import java.util.ArrayList;
import java.util.Arrays;
import p007b.p195g.p196a.p198b.p204t.C2149k;

/* JADX INFO: renamed from: b.g.a.b.p.e */
/* JADX INFO: compiled from: JsonStringEncoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2125e {

    /* JADX INFO: renamed from: a */
    public static final char[] f4550a = (char[]) C2121a.f4536a.clone();

    /* JADX INFO: renamed from: b */
    public static final C2125e f4551b;

    static {
        C2121a.f4537b.clone();
        f4551b = new C2125e();
    }

    /* JADX INFO: renamed from: a */
    public char[] m1696a(String str) {
        int length;
        int i;
        char[] cArrM1743e = new char[120];
        int[] iArr = C2121a.f4541f;
        int length2 = iArr.length;
        int length3 = str.length();
        C2149k c2149k = null;
        char[] cArr = null;
        int i2 = 0;
        int i3 = 0;
        loop0: while (i2 < length3) {
            while (true) {
                char cCharAt = str.charAt(i2);
                if (cCharAt >= length2 || iArr[cCharAt] == 0) {
                    if (i3 >= cArrM1743e.length) {
                        if (c2149k == null) {
                            c2149k = new C2149k(null, cArrM1743e);
                        }
                        cArrM1743e = c2149k.m1743e();
                        i3 = 0;
                    }
                    cArrM1743e[i3] = cCharAt;
                    i2++;
                    i3++;
                    if (i2 >= length3) {
                        break loop0;
                    }
                }
            }
            int i4 = 2;
            if (cArr == null) {
                cArr = new char[]{'\\', 0, '0', '0', 0, 0};
            }
            int i5 = i2 + 1;
            char cCharAt2 = str.charAt(i2);
            int i6 = iArr[cCharAt2];
            if (i6 < 0) {
                cArr[1] = 'u';
                char[] cArr2 = f4550a;
                cArr[4] = cArr2[cCharAt2 >> 4];
                cArr[5] = cArr2[cCharAt2 & 15];
                i4 = 6;
            } else {
                cArr[1] = (char) i6;
            }
            int i7 = i3 + i4;
            if (i7 > cArrM1743e.length) {
                int length4 = cArrM1743e.length - i3;
                if (length4 > 0) {
                    System.arraycopy(cArr, 0, cArrM1743e, i3, length4);
                }
                if (c2149k == null) {
                    c2149k = new C2149k(null, cArrM1743e);
                }
                cArrM1743e = c2149k.m1743e();
                int i8 = i4 - length4;
                System.arraycopy(cArr, length4, cArrM1743e, 0, i8);
                i3 = i8;
            } else {
                System.arraycopy(cArr, 0, cArrM1743e, i3, i4);
                i3 = i7;
            }
            i2 = i5;
        }
        if (c2149k == null) {
            return Arrays.copyOfRange(cArrM1743e, 0, i3);
        }
        c2149k.f4611h = i3;
        char[] charArray = c2149k.f4613j;
        if (charArray == null) {
            String str2 = c2149k.f4612i;
            if (str2 != null) {
                charArray = str2.toCharArray();
            } else {
                int i9 = c2149k.f4606c;
                if (i9 >= 0) {
                    charArray = C2149k.f4604a;
                } else {
                    if (i9 >= 0) {
                        length = 0;
                    } else if (charArray != null) {
                        length = charArray.length;
                    } else {
                        length = str2 != null ? str2.length() : c2149k.f4609f + i3;
                    }
                    if (length < 1) {
                        charArray = C2149k.f4604a;
                    } else {
                        charArray = new char[length];
                        ArrayList<char[]> arrayList = c2149k.f4607d;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            i = 0;
                            for (int i10 = 0; i10 < size; i10++) {
                                char[] cArr3 = c2149k.f4607d.get(i10);
                                int length5 = cArr3.length;
                                System.arraycopy(cArr3, 0, charArray, i, length5);
                                i += length5;
                            }
                        } else {
                            i = 0;
                        }
                        System.arraycopy(c2149k.f4610g, 0, charArray, i, c2149k.f4611h);
                    }
                }
            }
            c2149k.f4613j = charArray;
        }
        return charArray;
    }
}
