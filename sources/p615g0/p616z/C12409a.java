package p615g0.p616z;

import java.io.EOFException;
import p507d0.p579g0.C12086c;
import p507d0.p592z.p594d.C12238m;
import p615g0.C12388e;
import p615g0.C12398o;
import p615g0.C12402s;

/* JADX INFO: renamed from: g0.z.a */
/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12409a {

    /* JADX INFO: renamed from: a */
    public static final byte[] f26137a;

    static {
        C12238m.checkParameterIsNotNull("0123456789abcdef", "$this$asUtf8ToByteArray");
        byte[] bytes = "0123456789abcdef".getBytes(C12086c.f25136a);
        C12238m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        f26137a = bytes;
    }

    /* JADX INFO: renamed from: a */
    public static final String m10513a(C12388e c12388e, long j) throws EOFException {
        C12238m.checkParameterIsNotNull(c12388e, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (c12388e.m10464q(j2) == ((byte) 13)) {
                String strM10433H = c12388e.m10433H(j2);
                c12388e.skip(2L);
                return strM10433H;
            }
        }
        String strM10433H2 = c12388e.m10433H(j);
        c12388e.skip(1L);
        return strM10433H2;
    }

    /* JADX INFO: renamed from: b */
    public static final int m10514b(C12388e c12388e, C12398o c12398o, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        C12402s c12402s;
        C12238m.checkParameterIsNotNull(c12388e, "$this$selectPrefix");
        C12238m.checkParameterIsNotNull(c12398o, "options");
        C12402s c12402s2 = c12388e.f26079j;
        if (c12402s2 == null) {
            return z2 ? -2 : -1;
        }
        byte[] bArr = c12402s2.f26118a;
        int i5 = c12402s2.f26119b;
        int i6 = c12402s2.f26120c;
        int[] iArr = c12398o.f26108m;
        C12402s c12402s3 = c12402s2;
        int i7 = 0;
        int i8 = -1;
        loop0: while (true) {
            int i9 = i7 + 1;
            int i10 = iArr[i7];
            int i11 = i9 + 1;
            int i12 = iArr[i9];
            if (i12 != -1) {
                i8 = i12;
            }
            if (c12402s3 == null) {
                break;
            }
            if (i10 >= 0) {
                i = i5 + 1;
                int i13 = bArr[i5] & 255;
                int i14 = i11 + i10;
                while (i11 != i14) {
                    if (i13 == iArr[i11]) {
                        i2 = iArr[i11 + i10];
                        if (i == i6) {
                            c12402s3 = c12402s3.f26123f;
                            if (c12402s3 == null) {
                                C12238m.throwNpe();
                            }
                            i = c12402s3.f26119b;
                            bArr = c12402s3.f26118a;
                            i6 = c12402s3.f26120c;
                            if (c12402s3 == c12402s2) {
                                c12402s3 = null;
                            }
                        }
                    } else {
                        i11++;
                    }
                }
                return i8;
            }
            int i15 = (i10 * (-1)) + i11;
            while (true) {
                int i16 = i5 + 1;
                int i17 = i11 + 1;
                if ((bArr[i5] & 255) != iArr[i11]) {
                    return i8;
                }
                boolean z3 = i17 == i15;
                if (i16 == i6) {
                    if (c12402s3 == null) {
                        C12238m.throwNpe();
                    }
                    C12402s c12402s4 = c12402s3.f26123f;
                    if (c12402s4 == null) {
                        C12238m.throwNpe();
                    }
                    i4 = c12402s4.f26119b;
                    byte[] bArr2 = c12402s4.f26118a;
                    i3 = c12402s4.f26120c;
                    if (c12402s4 != c12402s2) {
                        c12402s = c12402s4;
                        bArr = bArr2;
                    } else {
                        if (!z3) {
                            break loop0;
                        }
                        bArr = bArr2;
                        c12402s = null;
                    }
                } else {
                    C12402s c12402s5 = c12402s3;
                    i3 = i6;
                    i4 = i16;
                    c12402s = c12402s5;
                }
                if (z3) {
                    i2 = iArr[i17];
                    i = i4;
                    i6 = i3;
                    c12402s3 = c12402s;
                    break;
                }
                i5 = i4;
                i6 = i3;
                i11 = i17;
                c12402s3 = c12402s;
            }
            if (i2 >= 0) {
                return i2;
            }
            i7 = -i2;
            i5 = i;
        }
        if (z2) {
            return -2;
        }
        return i8;
    }
}
