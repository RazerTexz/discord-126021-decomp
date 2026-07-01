package g0.z;

import d0.g0.c;
import d0.z.d.m;
import g0.e;
import g0.o;
import g0.s;
import java.io.EOFException;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final byte[] a;

    static {
        m.checkParameterIsNotNull("0123456789abcdef", "$this$asUtf8ToByteArray");
        byte[] bytes = "0123456789abcdef".getBytes(c.a);
        m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        a = bytes;
    }

    public static final String a(e eVar, long j) throws EOFException {
        m.checkParameterIsNotNull(eVar, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (eVar.q(j2) == ((byte) 13)) {
                String strH = eVar.H(j2);
                eVar.skip(2L);
                return strH;
            }
        }
        String strH2 = eVar.H(j);
        eVar.skip(1L);
        return strH2;
    }

    public static final int b(e eVar, o oVar, boolean z2) {
        int i;
        int i2;
        int i3;
        int i4;
        s sVar;
        m.checkParameterIsNotNull(eVar, "$this$selectPrefix");
        m.checkParameterIsNotNull(oVar, "options");
        s sVar2 = eVar.j;
        if (sVar2 == null) {
            return z2 ? -2 : -1;
        }
        byte[] bArr = sVar2.a;
        int i5 = sVar2.f3693b;
        int i6 = sVar2.c;
        int[] iArr = oVar.m;
        s sVar3 = sVar2;
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
            if (sVar3 == null) {
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
                            sVar3 = sVar3.f;
                            if (sVar3 == null) {
                                m.throwNpe();
                            }
                            i = sVar3.f3693b;
                            bArr = sVar3.a;
                            i6 = sVar3.c;
                            if (sVar3 == sVar2) {
                                sVar3 = null;
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
                    if (sVar3 == null) {
                        m.throwNpe();
                    }
                    s sVar4 = sVar3.f;
                    if (sVar4 == null) {
                        m.throwNpe();
                    }
                    i4 = sVar4.f3693b;
                    byte[] bArr2 = sVar4.a;
                    i3 = sVar4.c;
                    if (sVar4 != sVar2) {
                        sVar = sVar4;
                        bArr = bArr2;
                    } else {
                        if (!z3) {
                            break loop0;
                        }
                        bArr = bArr2;
                        sVar = null;
                    }
                } else {
                    s sVar5 = sVar3;
                    i3 = i6;
                    i4 = i16;
                    sVar = sVar5;
                }
                if (z3) {
                    i2 = iArr[i17];
                    i = i4;
                    i6 = i3;
                    sVar3 = sVar;
                    break;
                }
                i5 = i4;
                i6 = i3;
                i11 = i17;
                sVar3 = sVar;
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
