package p007b.p225i.p414e.p434s.p435b;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.ArrayList;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p418n.C4964c;
import p007b.p225i.p414e.p418n.C4966e;
import p007b.p225i.p414e.p418n.EnumC4965d;
import p007b.p225i.p414e.p418n.p420l.C4973a;
import p007b.p225i.p414e.p418n.p420l.C4975c;

/* JADX INFO: renamed from: b.i.e.s.b.e */
/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5053e {

    /* JADX INFO: renamed from: a */
    public final C4975c f13526a = new C4975c(C4973a.f13303e);

    /* JADX INFO: renamed from: a */
    public C4966e m7097a(C4963b c4963b, Map<EnumC4949d, ?> map) throws ChecksumException, FormatException {
        ChecksumException checksumException;
        C5049a c5049a = new C5049a(c4963b);
        try {
            return m7098b(c5049a, map);
        } catch (ChecksumException e) {
            checksumException = e;
            e = null;
            try {
                c5049a.m7088e();
                c5049a.f13511b = null;
                c5049a.f13512c = null;
                c5049a.f13513d = true;
                c5049a.m7087d();
                c5049a.m7086c();
                c5049a.m7085b();
                C4966e c4966eM7098b = m7098b(c5049a, map);
                c4966eM7098b.f13271f = new C5057i(true);
                return c4966eM7098b;
            } catch (ChecksumException | FormatException unused) {
                if (e != null) {
                    throw e;
                }
                throw checksumException;
            }
        } catch (FormatException e2) {
            e = e2;
            checksumException = null;
            c5049a.m7088e();
            c5049a.f13511b = null;
            c5049a.f13512c = null;
            c5049a.f13513d = true;
            c5049a.m7087d();
            c5049a.m7086c();
            c5049a.m7085b();
            C4966e c4966eM7098b2 = m7098b(c5049a, map);
            c4966eM7098b2.f13271f = new C5057i(true);
            return c4966eM7098b2;
        }
    }

    /* JADX INFO: renamed from: b */
    public final C4966e m7098b(C5049a c5049a, Map<EnumC4949d, ?> map) throws ChecksumException, FormatException {
        int iM6949b;
        EnumC5056h enumC5056h;
        int i;
        int i2;
        int iM6949b2;
        C4963b c4963b;
        C5058j c5058jM7087d = c5049a.m7087d();
        EnumC5054f enumC5054f = c5049a.m7086c().f13534b;
        C5055g c5055gM7086c = c5049a.m7086c();
        C5058j c5058jM7087d2 = c5049a.m7087d();
        EnumC5051c enumC5051c = EnumC5051c.values()[c5055gM7086c.f13535c];
        C4963b c4963b2 = c5049a.f13510a;
        int i3 = c4963b2.f13230k;
        enumC5051c.m7090g(c4963b2, i3);
        int iM7105c = c5058jM7087d2.m7105c();
        C4963b c4963b3 = new C4963b(iM7105c, iM7105c);
        int i4 = 0;
        c4963b3.m6947k(0, 0, 9, 9);
        int i5 = iM7105c - 8;
        c4963b3.m6947k(i5, 0, 8, 9);
        c4963b3.m6947k(0, i5, 9, 8);
        int length = c5058jM7087d2.f13551d.length;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = c5058jM7087d2.f13551d[i6] - 2;
            for (int i8 = 0; i8 < length; i8++) {
                if ((i6 != 0 || (i8 != 0 && i8 != length - 1)) && (i6 != length - 1 || i8 != 0)) {
                    c4963b3.m6947k(c5058jM7087d2.f13551d[i8] - 2, i7, 5, 5);
                }
            }
        }
        int i9 = iM7105c - 17;
        int i10 = 6;
        c4963b3.m6947k(6, 9, 1, i9);
        c4963b3.m6947k(9, 6, i9, 1);
        if (c5058jM7087d2.f13550c > 6) {
            int i11 = iM7105c - 11;
            c4963b3.m6947k(i11, 0, 3, 6);
            c4963b3.m6947k(0, i11, 6, 3);
        }
        int i12 = c5058jM7087d2.f13553f;
        byte[] bArr = new byte[i12];
        int i13 = i3 - 1;
        int i14 = i13;
        int i15 = 0;
        boolean z2 = true;
        int i16 = 0;
        int i17 = 0;
        while (true) {
            int i18 = 2;
            if (i14 <= 0) {
                break;
            }
            if (i14 == i10) {
                i14--;
            }
            int i19 = 0;
            while (i19 < i3) {
                int i20 = z2 ? i13 - i19 : i19;
                while (i4 < i18) {
                    int i21 = i14 - i4;
                    if (c4963b3.m6942f(i21, i20)) {
                        c4963b = c4963b3;
                    } else {
                        int i22 = i16 + 1;
                        int i23 = i17 << 1;
                        c4963b = c4963b3;
                        int i24 = c5049a.f13510a.m6942f(i21, i20) ? i23 | 1 : i23;
                        if (i22 == 8) {
                            bArr[i15] = (byte) i24;
                            i15++;
                            i16 = 0;
                            i17 = 0;
                        } else {
                            i17 = i24;
                            i16 = i22;
                        }
                    }
                    i4++;
                    c4963b3 = c4963b;
                    i18 = 2;
                }
                i19++;
                i4 = 0;
                i18 = 2;
            }
            z2 = !z2;
            i14 -= 2;
            i4 = 0;
            i10 = 6;
        }
        if (i15 != c5058jM7087d2.f13553f) {
            throw FormatException.m9260a();
        }
        if (i12 != c5058jM7087d.f13553f) {
            throw new IllegalArgumentException();
        }
        C5058j.b bVar = c5058jM7087d.f13552e[enumC5054f.ordinal()];
        C5058j.a[] aVarArr = bVar.f13557b;
        int i25 = 0;
        for (C5058j.a aVar : aVarArr) {
            i25 += aVar.f13554a;
        }
        C5050b[] c5050bArr = new C5050b[i25];
        int i26 = 0;
        for (C5058j.a aVar2 : aVarArr) {
            int i27 = 0;
            while (i27 < aVar2.f13554a) {
                int i28 = aVar2.f13555b;
                c5050bArr[i26] = new C5050b(i28, new byte[bVar.f13556a + i28]);
                i27++;
                i26++;
            }
        }
        int length2 = c5050bArr[0].f13515b.length;
        int i29 = i25 - 1;
        while (i29 >= 0 && c5050bArr[i29].f13515b.length != length2) {
            i29--;
        }
        int i30 = i29 + 1;
        int i31 = length2 - bVar.f13556a;
        int i32 = 0;
        for (int i33 = 0; i33 < i31; i33++) {
            int i34 = 0;
            while (i34 < i26) {
                c5050bArr[i34].f13515b[i33] = bArr[i32];
                i34++;
                i32++;
            }
        }
        int i35 = i30;
        while (i35 < i26) {
            c5050bArr[i35].f13515b[i31] = bArr[i32];
            i35++;
            i32++;
        }
        boolean z3 = false;
        int length3 = c5050bArr[0].f13515b.length;
        while (i31 < length3) {
            int i36 = 0;
            while (i36 < i26) {
                c5050bArr[i36].f13515b[i36 < i30 ? i31 : i31 + 1] = bArr[i32];
                i36++;
                i32++;
            }
            i31++;
        }
        int i37 = 0;
        for (int i38 = 0; i38 < i25; i38++) {
            i37 += c5050bArr[i38].f13514a;
        }
        byte[] bArr2 = new byte[i37];
        int i39 = 0;
        for (int i40 = 0; i40 < i25; i40++) {
            C5050b c5050b = c5050bArr[i40];
            byte[] bArr3 = c5050b.f13515b;
            int i41 = c5050b.f13514a;
            int length4 = bArr3.length;
            int[] iArr = new int[length4];
            for (int i42 = 0; i42 < length4; i42++) {
                iArr[i42] = bArr3[i42] & 255;
            }
            try {
                this.f13526a.m6968a(iArr, bArr3.length - i41);
                for (int i43 = 0; i43 < i41; i43++) {
                    bArr3[i43] = (byte) iArr[i43];
                }
                int i44 = 0;
                while (i44 < i41) {
                    bArr2[i39] = bArr3[i44];
                    i44++;
                    i39++;
                }
            } catch (ReedSolomonException unused) {
                throw ChecksumException.m9259a();
            }
        }
        char[] cArr = C5052d.f13525a;
        EnumC5056h enumC5056h2 = EnumC5056h.TERMINATOR;
        C4964c c4964c = new C4964c(bArr2);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int iM6949b3 = -1;
        int iM6949b4 = -1;
        EnumC4965d enumC4965dM6950f = null;
        while (true) {
            try {
                if (c4964c.m6948a() < 4 || (iM6949b = c4964c.m6949b(4)) == 0) {
                    enumC5056h = enumC5056h2;
                } else if (iM6949b == 1) {
                    enumC5056h = EnumC5056h.NUMERIC;
                } else if (iM6949b == 2) {
                    enumC5056h = EnumC5056h.ALPHANUMERIC;
                } else if (iM6949b == 3) {
                    enumC5056h = EnumC5056h.STRUCTURED_APPEND;
                } else if (iM6949b == 4) {
                    enumC5056h = EnumC5056h.BYTE;
                } else if (iM6949b == 5) {
                    enumC5056h = EnumC5056h.FNC1_FIRST_POSITION;
                } else if (iM6949b == 7) {
                    enumC5056h = EnumC5056h.ECI;
                } else if (iM6949b == 8) {
                    enumC5056h = EnumC5056h.KANJI;
                } else if (iM6949b == 9) {
                    enumC5056h = EnumC5056h.FNC1_SECOND_POSITION;
                } else {
                    if (iM6949b != 13) {
                        throw new IllegalArgumentException();
                    }
                    enumC5056h = EnumC5056h.HANZI;
                }
                int iOrdinal = enumC5056h.ordinal();
                if (iOrdinal == 0) {
                    i2 = iM6949b3;
                    i = iM6949b4;
                } else {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 5) {
                            int iM6949b5 = c4964c.m6949b(8);
                            if ((iM6949b5 & 128) == 0) {
                                iM6949b2 = iM6949b5 & Opcodes.LAND;
                            } else if ((iM6949b5 & Opcodes.CHECKCAST) == 128) {
                                iM6949b2 = ((iM6949b5 & 63) << 8) | c4964c.m6949b(8);
                            } else {
                                if ((iM6949b5 & 224) != 192) {
                                    throw FormatException.m9260a();
                                }
                                iM6949b2 = ((iM6949b5 & 31) << 16) | c4964c.m6949b(16);
                            }
                            enumC4965dM6950f = EnumC4965d.m6950f(iM6949b2);
                            if (enumC4965dM6950f == null) {
                                throw FormatException.m9260a();
                            }
                        } else if (iOrdinal == 7 || iOrdinal == 8) {
                            z3 = true;
                        } else if (iOrdinal != 9) {
                            int iM6949b6 = c4964c.m6949b(enumC5056h.m7101f(c5058jM7087d));
                            int iOrdinal2 = enumC5056h.ordinal();
                            if (iOrdinal2 == 1) {
                                C5052d.m7095e(c4964c, sb, iM6949b6);
                            } else if (iOrdinal2 == 2) {
                                C5052d.m7091a(c4964c, sb, iM6949b6, z3);
                            } else if (iOrdinal2 == 4) {
                                C5052d.m7092b(c4964c, sb, iM6949b6, enumC4965dM6950f, arrayList, map);
                            } else {
                                if (iOrdinal2 != 6) {
                                    throw FormatException.m9260a();
                                }
                                C5052d.m7094d(c4964c, sb, iM6949b6);
                            }
                        } else {
                            int iM6949b7 = c4964c.m6949b(4);
                            int iM6949b8 = c4964c.m6949b(enumC5056h.m7101f(c5058jM7087d));
                            if (iM6949b7 == 1) {
                                C5052d.m7093c(c4964c, sb, iM6949b8);
                            }
                        }
                        i2 = iM6949b3;
                        i = iM6949b4;
                    } else {
                        if (c4964c.m6948a() < 16) {
                            throw FormatException.m9260a();
                        }
                        iM6949b3 = c4964c.m6949b(8);
                        iM6949b4 = c4964c.m6949b(8);
                    }
                    i2 = iM6949b3;
                    i = iM6949b4;
                }
                if (enumC5056h == enumC5056h2) {
                    return new C4966e(bArr2, sb.toString(), arrayList.isEmpty() ? null : arrayList, enumC5054f.toString(), i2, i);
                }
                iM6949b3 = i2;
                iM6949b4 = i;
            } catch (IllegalArgumentException unused2) {
                throw FormatException.m9260a();
            }
        }
    }
}
