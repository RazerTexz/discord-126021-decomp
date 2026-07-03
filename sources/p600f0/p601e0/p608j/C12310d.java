package p600f0.p601e0.p608j;

import okio.ByteString;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.e0.j.d */
/* JADX INFO: compiled from: Http2.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12310d {

    /* JADX INFO: renamed from: d */
    public static final String[] f25613d;

    /* JADX INFO: renamed from: e */
    public static final C12310d f25614e = new C12310d();

    /* JADX INFO: renamed from: a */
    public static final ByteString f25610a = ByteString.INSTANCE.m11012c("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: b */
    public static final String[] f25611b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: c */
    public static final String[] f25612c = new String[64];

    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            C12238m.checkExpressionValueIsNotNull(binaryString, "Integer.toBinaryString(it)");
            strArr[i] = C12103t.replace$default(C12272c.m10129j("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        f25613d = strArr;
        String[] strArr2 = f25612c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        for (int i2 = 0; i2 < 1; i2++) {
            int i3 = iArr[i2];
            String[] strArr3 = f25612c;
            strArr3[i3 | 8] = C12238m.stringPlus(strArr3[i3], "|PADDED");
        }
        String[] strArr4 = f25612c;
        strArr4[4] = "END_HEADERS";
        strArr4[32] = "PRIORITY";
        strArr4[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = iArr2[i4];
            for (int i6 = 0; i6 < 1; i6++) {
                int i7 = iArr[i6];
                String[] strArr5 = f25612c;
                int i8 = i7 | i5;
                strArr5[i8] = strArr5[i7] + "|" + strArr5[i5];
                StringBuilder sb = new StringBuilder();
                sb.append(strArr5[i7]);
                sb.append("|");
                strArr5[i8 | 8] = C1643a.m822J(sb, strArr5[i5], "|PADDED");
            }
        }
        int length = f25612c.length;
        for (int i9 = 0; i9 < length; i9++) {
            String[] strArr6 = f25612c;
            if (strArr6[i9] == null) {
                strArr6[i9] = f25613d[i9];
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m10256a(int i) {
        String[] strArr = f25611b;
        return i < strArr.length ? strArr[i] : C12272c.m10129j("0x%02x", Integer.valueOf(i));
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0066  */
    /* JADX INFO: renamed from: b */
    public final String m10257b(boolean z2, int i, int i2, int i3, int i4) {
        String strReplace$default;
        String str;
        String strM10256a = m10256a(i3);
        if (i4 == 0) {
            strReplace$default = "";
        } else if (i3 == 2 || i3 == 3) {
            strReplace$default = f25613d[i4];
        } else if (i3 == 4 || i3 == 6) {
            strReplace$default = i4 == 1 ? "ACK" : f25613d[i4];
        } else if (i3 == 7 || i3 == 8) {
            strReplace$default = f25613d[i4];
        } else {
            String[] strArr = f25612c;
            if (i4 < strArr.length) {
                str = strArr[i4];
                if (str == null) {
                    C12238m.throwNpe();
                }
            } else {
                str = f25613d[i4];
            }
            String str2 = str;
            if (i3 != 5 || (i4 & 4) == 0) {
                strReplace$default = (i3 != 0 || (i4 & 32) == 0) ? str2 : C12103t.replace$default(str2, "PRIORITY", "COMPRESSED", false, 4, (Object) null);
            } else {
                strReplace$default = C12103t.replace$default(str2, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
            }
        }
        return C12272c.m10129j("%s 0x%08x %5d %-13s %s", z2 ? "<<" : ">>", Integer.valueOf(i), Integer.valueOf(i2), strM10256a, strReplace$default);
    }
}
