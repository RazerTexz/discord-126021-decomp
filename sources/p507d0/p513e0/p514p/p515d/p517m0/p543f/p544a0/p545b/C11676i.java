package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.i */
/* JADX INFO: compiled from: utfEncoding.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11676i {
    public static final byte[] stringsToBytes(String[] strArr) {
        int i;
        C12238m.checkNotNullParameter(strArr, "strings");
        int length = 0;
        for (String str : strArr) {
            length += str.length();
        }
        byte[] bArr = new byte[length];
        int length2 = strArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length2) {
            String str2 = strArr[i2];
            i2++;
            int length3 = str2.length() - 1;
            if (length3 >= 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    i = i3 + 1;
                    bArr[i3] = (byte) str2.charAt(i4);
                    if (i4 == length3) {
                        break;
                    }
                    i4 = i5;
                    i3 = i;
                }
                i3 = i;
            }
        }
        return bArr;
    }
}
