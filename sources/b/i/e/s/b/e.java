package b.i.e.s.b;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.ArrayList;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public final b.i.e.n.l.c a = new b.i.e.n.l.c(b.i.e.n.l.a.e);

    public b.i.e.n.e a(b.i.e.n.b bVar, Map<b.i.e.d, ?> map) throws ChecksumException, FormatException {
        ChecksumException checksumException;
        a aVar = new a(bVar);
        try {
            return b(aVar, map);
        } catch (ChecksumException e) {
            checksumException = e;
            e = null;
            try {
                aVar.e();
                aVar.f1886b = null;
                aVar.c = null;
                aVar.d = true;
                aVar.d();
                aVar.c();
                aVar.b();
                b.i.e.n.e eVarB = b(aVar, map);
                eVarB.f = new i(true);
                return eVarB;
            } catch (ChecksumException | FormatException unused) {
                if (e != null) {
                    throw e;
                }
                throw checksumException;
            }
        } catch (FormatException e2) {
            e = e2;
            checksumException = null;
            aVar.e();
            aVar.f1886b = null;
            aVar.c = null;
            aVar.d = true;
            aVar.d();
            aVar.c();
            aVar.b();
            b.i.e.n.e eVarB2 = b(aVar, map);
            eVarB2.f = new i(true);
            return eVarB2;
        }
    }

    public final b.i.e.n.e b(a aVar, Map<b.i.e.d, ?> map) throws ChecksumException, FormatException {
        int iB;
        h hVar;
        int i;
        int i2;
        int iB2;
        b.i.e.n.b bVar;
        j jVarD = aVar.d();
        f fVar = aVar.c().f1888b;
        g gVarC = aVar.c();
        j jVarD2 = aVar.d();
        c cVar = c.values()[gVarC.c];
        b.i.e.n.b bVar2 = aVar.a;
        int i3 = bVar2.k;
        cVar.g(bVar2, i3);
        int iC = jVarD2.c();
        b.i.e.n.b bVar3 = new b.i.e.n.b(iC, iC);
        int i4 = 0;
        bVar3.k(0, 0, 9, 9);
        int i5 = iC - 8;
        bVar3.k(i5, 0, 8, 9);
        bVar3.k(0, i5, 9, 8);
        int length = jVarD2.d.length;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = jVarD2.d[i6] - 2;
            for (int i8 = 0; i8 < length; i8++) {
                if ((i6 != 0 || (i8 != 0 && i8 != length - 1)) && (i6 != length - 1 || i8 != 0)) {
                    bVar3.k(jVarD2.d[i8] - 2, i7, 5, 5);
                }
            }
        }
        int i9 = iC - 17;
        int i10 = 6;
        bVar3.k(6, 9, 1, i9);
        bVar3.k(9, 6, i9, 1);
        if (jVarD2.c > 6) {
            int i11 = iC - 11;
            bVar3.k(i11, 0, 3, 6);
            bVar3.k(0, i11, 6, 3);
        }
        int i12 = jVarD2.f;
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
                    if (bVar3.f(i21, i20)) {
                        bVar = bVar3;
                    } else {
                        int i22 = i16 + 1;
                        int i23 = i17 << 1;
                        bVar = bVar3;
                        int i24 = aVar.a.f(i21, i20) ? i23 | 1 : i23;
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
                    bVar3 = bVar;
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
        if (i15 != jVarD2.f) {
            throw FormatException.a();
        }
        if (i12 != jVarD.f) {
            throw new IllegalArgumentException();
        }
        j$b j_b = jVarD.e[fVar.ordinal()];
        j$a[] j_aArr = j_b.f1892b;
        int i25 = 0;
        for (j$a j_a : j_aArr) {
            i25 += j_a.a;
        }
        b[] bVarArr = new b[i25];
        int i26 = 0;
        for (j$a j_a2 : j_aArr) {
            int i27 = 0;
            while (i27 < j_a2.a) {
                int i28 = j_a2.f1891b;
                bVarArr[i26] = new b(i28, new byte[j_b.a + i28]);
                i27++;
                i26++;
            }
        }
        int length2 = bVarArr[0].f1887b.length;
        int i29 = i25 - 1;
        while (i29 >= 0 && bVarArr[i29].f1887b.length != length2) {
            i29--;
        }
        int i30 = i29 + 1;
        int i31 = length2 - j_b.a;
        int i32 = 0;
        for (int i33 = 0; i33 < i31; i33++) {
            int i34 = 0;
            while (i34 < i26) {
                bVarArr[i34].f1887b[i33] = bArr[i32];
                i34++;
                i32++;
            }
        }
        int i35 = i30;
        while (i35 < i26) {
            bVarArr[i35].f1887b[i31] = bArr[i32];
            i35++;
            i32++;
        }
        boolean z3 = false;
        int length3 = bVarArr[0].f1887b.length;
        while (i31 < length3) {
            int i36 = 0;
            while (i36 < i26) {
                bVarArr[i36].f1887b[i36 < i30 ? i31 : i31 + 1] = bArr[i32];
                i36++;
                i32++;
            }
            i31++;
        }
        int i37 = 0;
        for (int i38 = 0; i38 < i25; i38++) {
            i37 += bVarArr[i38].a;
        }
        byte[] bArr2 = new byte[i37];
        int i39 = 0;
        for (int i40 = 0; i40 < i25; i40++) {
            b bVar4 = bVarArr[i40];
            byte[] bArr3 = bVar4.f1887b;
            int i41 = bVar4.a;
            int length4 = bArr3.length;
            int[] iArr = new int[length4];
            for (int i42 = 0; i42 < length4; i42++) {
                iArr[i42] = bArr3[i42] & 255;
            }
            try {
                this.a.a(iArr, bArr3.length - i41);
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
                throw ChecksumException.a();
            }
        }
        char[] cArr = d.a;
        h hVar2 = h.TERMINATOR;
        b.i.e.n.c cVar2 = new b.i.e.n.c(bArr2);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int iB3 = -1;
        int iB4 = -1;
        b.i.e.n.d dVarF = null;
        while (true) {
            try {
                if (cVar2.a() < 4 || (iB = cVar2.b(4)) == 0) {
                    hVar = hVar2;
                } else if (iB == 1) {
                    hVar = h.NUMERIC;
                } else if (iB == 2) {
                    hVar = h.ALPHANUMERIC;
                } else if (iB == 3) {
                    hVar = h.STRUCTURED_APPEND;
                } else if (iB == 4) {
                    hVar = h.BYTE;
                } else if (iB == 5) {
                    hVar = h.FNC1_FIRST_POSITION;
                } else if (iB == 7) {
                    hVar = h.ECI;
                } else if (iB == 8) {
                    hVar = h.KANJI;
                } else if (iB == 9) {
                    hVar = h.FNC1_SECOND_POSITION;
                } else {
                    if (iB != 13) {
                        throw new IllegalArgumentException();
                    }
                    hVar = h.HANZI;
                }
                int iOrdinal = hVar.ordinal();
                if (iOrdinal == 0) {
                    i2 = iB3;
                    i = iB4;
                } else {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 5) {
                            int iB5 = cVar2.b(8);
                            if ((iB5 & 128) == 0) {
                                iB2 = iB5 & Opcodes.LAND;
                            } else if ((iB5 & Opcodes.CHECKCAST) == 128) {
                                iB2 = ((iB5 & 63) << 8) | cVar2.b(8);
                            } else {
                                if ((iB5 & 224) != 192) {
                                    throw FormatException.a();
                                }
                                iB2 = ((iB5 & 31) << 16) | cVar2.b(16);
                            }
                            dVarF = b.i.e.n.d.f(iB2);
                            if (dVarF == null) {
                                throw FormatException.a();
                            }
                        } else if (iOrdinal == 7 || iOrdinal == 8) {
                            z3 = true;
                        } else if (iOrdinal != 9) {
                            int iB6 = cVar2.b(hVar.f(jVarD));
                            int iOrdinal2 = hVar.ordinal();
                            if (iOrdinal2 == 1) {
                                d.e(cVar2, sb, iB6);
                            } else if (iOrdinal2 == 2) {
                                d.a(cVar2, sb, iB6, z3);
                            } else if (iOrdinal2 == 4) {
                                d.b(cVar2, sb, iB6, dVarF, arrayList, map);
                            } else {
                                if (iOrdinal2 != 6) {
                                    throw FormatException.a();
                                }
                                d.d(cVar2, sb, iB6);
                            }
                        } else {
                            int iB7 = cVar2.b(4);
                            int iB8 = cVar2.b(hVar.f(jVarD));
                            if (iB7 == 1) {
                                d.c(cVar2, sb, iB8);
                            }
                        }
                        i2 = iB3;
                        i = iB4;
                    } else {
                        if (cVar2.a() < 16) {
                            throw FormatException.a();
                        }
                        iB3 = cVar2.b(8);
                        iB4 = cVar2.b(8);
                    }
                    i2 = iB3;
                    i = iB4;
                }
                if (hVar == hVar2) {
                    return new b.i.e.n.e(bArr2, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar.toString(), i2, i);
                }
                iB3 = i2;
                iB4 = i;
            } catch (IllegalArgumentException unused2) {
                throw FormatException.a();
            }
        }
    }
}
