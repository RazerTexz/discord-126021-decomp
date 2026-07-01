package f0.e0.j;

import d0.g0.t;
import okio.ByteString;

/* JADX INFO: compiled from: Http2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final String[] d;
    public static final d e = new d();
    public static final ByteString a = ByteString.k.c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f3637b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    public static final String[] c = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            d0.z.d.m.checkExpressionValueIsNotNull(binaryString, "Integer.toBinaryString(it)");
            strArr[i] = t.replace$default(f0.e0.c.j("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        d = strArr;
        String[] strArr2 = c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i2 = 0; i2 < 1; i2++) {
            int i3 = iArr[i2];
            String[] strArr3 = c;
            strArr3[i3 | 8] = d0.z.d.m.stringPlus(strArr3[i3], "|PADDED");
        }
        String[] strArr4 = c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            for (int i6 = 0; i6 < 1; i6++) {
                int i7 = iArr[i6];
                String[] strArr5 = c;
                int i8 = i7 | i5;
                strArr5[i8] = strArr5[i7] + "|" + strArr5[i5];
                StringBuilder sb = new StringBuilder();
                sb.append(strArr5[i7]);
                sb.append("|");
                strArr5[i8 | 8] = b.d.b.a.a.J(sb, strArr5[i5], "|PADDED");
            }
        }
        int length = c.length;
        for (int i9 = 0; i9 < length; i9++) {
            String[] strArr6 = c;
            if (strArr6[i9] == null) {
                strArr6[i9] = d[i9];
            }
        }
    }

    public final String a(int i) {
        String[] strArr = f3637b;
        return i < strArr.length ? strArr[i] : f0.e0.c.j("0x%02x", Integer.valueOf(i));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0066  */
    public final String b(boolean z2, int i, int i2, int i3, int i4) {
        String strReplace$default;
        String str;
        String strA = a(i3);
        if (i4 == 0) {
            strReplace$default = "";
        } else if (i3 == 2 || i3 == 3) {
            strReplace$default = d[i4];
        } else if (i3 == 4 || i3 == 6) {
            strReplace$default = i4 == 1 ? "ACK" : d[i4];
        } else if (i3 == 7 || i3 == 8) {
            strReplace$default = d[i4];
        } else {
            String[] strArr = c;
            if (i4 < strArr.length) {
                str = strArr[i4];
                if (str == null) {
                    d0.z.d.m.throwNpe();
                }
            } else {
                str = d[i4];
            }
            String str2 = str;
            if (i3 != 5 || (i4 & 4) == 0) {
                strReplace$default = (i3 != 0 || (i4 & 32) == 0) ? str2 : t.replace$default(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
            } else {
                strReplace$default = t.replace$default(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
            }
        }
        return f0.e0.c.j("%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), strA, strReplace$default);
    }
}
