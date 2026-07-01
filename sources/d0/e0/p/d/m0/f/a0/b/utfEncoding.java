package d0.e0.p.d.m0.f.a0.b;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.i, reason: use source file name */
/* JADX INFO: compiled from: utfEncoding.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class utfEncoding {
    public static final byte[] stringsToBytes(String[] strArr) {
        int i;
        Intrinsics3.checkNotNullParameter(strArr, "strings");
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
