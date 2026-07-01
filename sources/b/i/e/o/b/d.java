package b.i.e.o.b;

import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final b.i.e.n.l.c a = new b.i.e.n.l.c(b.i.e.n.l.a.f);

    /* JADX WARN: Code duplicated, block: B:440:0x065a  */
    /* JADX WARN: Code duplicated, block: B:446:0x066c  */
    /* JADX WARN: Code duplicated, block: B:449:0x067c  */
    /* JADX WARN: Code duplicated, block: B:494:0x0666 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:503:0x04fe A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:504:? A[LOOP:15: B:201:0x0348->B:504:?, LOOP_END, SYNTHETIC] */
    public b.i.e.n.e a(b.i.e.n.b bVar) throws ChecksumException, FormatException {
        int iB;
        boolean z2;
        int iB2;
        int iB3;
        int i;
        a aVar = new a(bVar);
        e eVar = aVar.c;
        int i2 = eVar.h;
        byte[] bArr = new byte[i2];
        b.i.e.n.b bVar2 = aVar.a;
        int i3 = bVar2.k;
        int i4 = bVar2.j;
        int i5 = 0;
        int i6 = 4;
        int i7 = 0;
        boolean z3 = false;
        int i8 = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (i6 == i3 && i7 == 0 && !z3) {
                int i9 = i8 + 1;
                int i10 = i3 - 1;
                int i11 = (aVar.a(i10, i5, i3, i4) ? 1 : 0) << 1;
                if (aVar.a(i10, 1, i3, i4)) {
                    i11 |= 1;
                }
                int i12 = i11 << 1;
                if (aVar.a(i10, 2, i3, i4)) {
                    i12 |= 1;
                }
                int i13 = i12 << 1;
                if (aVar.a(0, i4 - 2, i3, i4)) {
                    i13 |= 1;
                }
                int i14 = i13 << 1;
                int i15 = i4 - 1;
                if (aVar.a(0, i15, i3, i4)) {
                    i14 |= 1;
                }
                int i16 = i14 << 1;
                if (aVar.a(1, i15, i3, i4)) {
                    i16 |= 1;
                }
                int i17 = i16 << 1;
                if (aVar.a(2, i15, i3, i4)) {
                    i17 |= 1;
                }
                int i18 = i17 << 1;
                if (aVar.a(3, i15, i3, i4)) {
                    i18 |= 1;
                }
                bArr[i8] = (byte) i18;
                i6 -= 2;
                i7 += 2;
                i8 = i9;
                z3 = true;
            } else {
                int i19 = i3 - 2;
                if (i6 == i19 && i7 == 0 && (i4 & 3) != 0 && !z4) {
                    int i20 = i8 + 1;
                    int i21 = (aVar.a(i3 + (-3), 0, i3, i4) ? 1 : 0) << 1;
                    if (aVar.a(i19, 0, i3, i4)) {
                        i21 |= 1;
                    }
                    int i22 = i21 << 1;
                    if (aVar.a(i3 - 1, 0, i3, i4)) {
                        i22 |= 1;
                    }
                    int i23 = i22 << 1;
                    if (aVar.a(0, i4 - 4, i3, i4)) {
                        i23 |= 1;
                    }
                    int i24 = i23 << 1;
                    if (aVar.a(0, i4 - 3, i3, i4)) {
                        i24 |= 1;
                    }
                    int i25 = i24 << 1;
                    if (aVar.a(0, i4 - 2, i3, i4)) {
                        i25 |= 1;
                    }
                    int i26 = i25 << 1;
                    int i27 = i4 - 1;
                    if (aVar.a(0, i27, i3, i4)) {
                        i26 |= 1;
                    }
                    int i28 = i26 << 1;
                    if (aVar.a(1, i27, i3, i4)) {
                        i28 |= 1;
                    }
                    bArr[i8] = (byte) i28;
                    i6 -= 2;
                    i7 += 2;
                    i8 = i20;
                    z4 = true;
                } else if (i6 == i3 + 4 && i7 == 2 && (i4 & 7) == 0 && !z5) {
                    int i29 = i8 + 1;
                    int i30 = i3 - 1;
                    int i31 = (aVar.a(i30, 0, i3, i4) ? 1 : 0) << 1;
                    int i32 = i4 - 1;
                    if (aVar.a(i30, i32, i3, i4)) {
                        i31 |= 1;
                    }
                    int i33 = i31 << 1;
                    int i34 = i4 - 3;
                    if (aVar.a(0, i34, i3, i4)) {
                        i33 |= 1;
                    }
                    int i35 = i33 << 1;
                    int i36 = i4 - 2;
                    boolean z7 = z3;
                    if (aVar.a(0, i36, i3, i4)) {
                        i35 |= 1;
                    }
                    boolean z8 = z4;
                    int i37 = i35 << 1;
                    if (aVar.a(0, i32, i3, i4)) {
                        i37 |= 1;
                    }
                    int i38 = i37 << 1;
                    if (aVar.a(1, i34, i3, i4)) {
                        i38 |= 1;
                    }
                    int i39 = i38 << 1;
                    if (aVar.a(1, i36, i3, i4)) {
                        i39 |= 1;
                    }
                    int i40 = i39 << 1;
                    if (aVar.a(1, i32, i3, i4)) {
                        i40 |= 1;
                    }
                    bArr[i8] = (byte) i40;
                    i6 -= 2;
                    i7 += 2;
                    i8 = i29;
                    z3 = z7;
                    z4 = z8;
                    z5 = true;
                } else {
                    boolean z9 = z3;
                    boolean z10 = z4;
                    if (i6 == i19 && i7 == 0 && (i4 & 7) == 4 && !z6) {
                        int i41 = i8 + 1;
                        int i42 = (aVar.a(i3 + (-3), 0, i3, i4) ? 1 : 0) << 1;
                        if (aVar.a(i19, 0, i3, i4)) {
                            i42 |= 1;
                        }
                        int i43 = i42 << 1;
                        if (aVar.a(i3 - 1, 0, i3, i4)) {
                            i43 |= 1;
                        }
                        int i44 = i43 << 1;
                        if (aVar.a(0, i4 - 2, i3, i4)) {
                            i44 |= 1;
                        }
                        int i45 = i44 << 1;
                        int i46 = i4 - 1;
                        if (aVar.a(0, i46, i3, i4)) {
                            i45 |= 1;
                        }
                        int i47 = i45 << 1;
                        if (aVar.a(1, i46, i3, i4)) {
                            i47 |= 1;
                        }
                        int i48 = i47 << 1;
                        if (aVar.a(2, i46, i3, i4)) {
                            i48 |= 1;
                        }
                        int i49 = i48 << 1;
                        if (aVar.a(3, i46, i3, i4)) {
                            i49 |= 1;
                        }
                        bArr[i8] = (byte) i49;
                        i6 -= 2;
                        i7 += 2;
                        i8 = i41;
                        z3 = z9;
                        z4 = z10;
                        z6 = true;
                    } else {
                        do {
                            if (i6 < i3 && i7 >= 0 && !aVar.f1844b.f(i7, i6)) {
                                bArr[i8] = (byte) aVar.b(i6, i7, i3, i4);
                                i8++;
                            }
                            i6 -= 2;
                            i7 += 2;
                            if (i6 < 0) {
                                break;
                            }
                        } while (i7 < i4);
                        int i50 = i6 + 1;
                        int i51 = i7 + 3;
                        do {
                            if (i50 >= 0 && i51 < i4 && !aVar.f1844b.f(i51, i50)) {
                                bArr[i8] = (byte) aVar.b(i50, i51, i3, i4);
                                i8++;
                            }
                            i50 += 2;
                            i51 -= 2;
                            if (i50 >= i3) {
                                break;
                            }
                        } while (i51 >= 0);
                        i6 = i50 + 3;
                        i7 = i51 + 1;
                        z3 = z9;
                        z4 = z10;
                    }
                }
            }
            if (i6 >= i3 && i7 >= i4) {
                break;
            }
            i5 = 0;
        }
        if (i8 != aVar.c.h) {
            throw FormatException.a();
        }
        e$c e_c = eVar.g;
        e$b[] e_bArr = e_c.f1849b;
        int i52 = 0;
        for (e$b e_b : e_bArr) {
            i52 += e_b.a;
        }
        b[] bVarArr = new b[i52];
        int i53 = 0;
        for (e$b e_b2 : e_bArr) {
            int i54 = 0;
            while (i54 < e_b2.a) {
                int i55 = e_b2.f1848b;
                bVarArr[i53] = new b(i55, new byte[e_c.a + i55]);
                i54++;
                i53++;
            }
        }
        int length = bVarArr[0].f1845b.length - e_c.a;
        int i56 = length - 1;
        int i57 = 0;
        for (int i58 = 0; i58 < i56; i58++) {
            int i59 = 0;
            while (i59 < i53) {
                bVarArr[i59].f1845b[i58] = bArr[i57];
                i59++;
                i57++;
            }
        }
        boolean z11 = eVar.f1847b == 24;
        int i60 = 8;
        int i61 = z11 ? 8 : i53;
        int i62 = 0;
        while (i62 < i61) {
            bVarArr[i62].f1845b[i56] = bArr[i57];
            i62++;
            i57++;
        }
        int length2 = bVarArr[0].f1845b.length;
        while (length < length2) {
            int i63 = 0;
            while (i63 < i53) {
                int i64 = z11 ? (i63 + 8) % i53 : i63;
                bVarArr[i64].f1845b[(!z11 || i64 <= 7) ? length : length - 1] = bArr[i57];
                i63++;
                i57++;
            }
            length++;
        }
        if (i57 != i2) {
            throw new IllegalArgumentException();
        }
        int i65 = 0;
        for (int i66 = 0; i66 < i52; i66++) {
            i65 += bVarArr[i66].a;
        }
        byte[] bArr2 = new byte[i65];
        for (int i67 = 0; i67 < i52; i67++) {
            b bVar3 = bVarArr[i67];
            byte[] bArr3 = bVar3.f1845b;
            int i68 = bVar3.a;
            int length3 = bArr3.length;
            int[] iArr = new int[length3];
            for (int i69 = 0; i69 < length3; i69++) {
                iArr[i69] = bArr3[i69] & 255;
            }
            try {
                this.a.a(iArr, bArr3.length - i68);
                for (int i70 = 0; i70 < i68; i70++) {
                    bArr3[i70] = (byte) iArr[i70];
                }
                for (int i71 = 0; i71 < i68; i71++) {
                    bArr2[(i71 * i52) + i67] = bArr3[i71];
                }
            } catch (ReedSolomonException unused) {
                throw ChecksumException.a();
            }
        }
        b.i.e.n.c cVar = new b.i.e.n.c(bArr2);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        int i72 = 2;
        while (true) {
            int i73 = 6;
            char c = 29;
            if (i72 != 2) {
                int iH = b.c.a.y.b.h(i72);
                if (iH == 2) {
                    int[] iArr2 = new int[3];
                    boolean z12 = false;
                    int i74 = 0;
                    while (true) {
                        if (cVar.a() != 8 && (iB = cVar.b(8)) != 254) {
                            c.a(iB, cVar.b(8), iArr2);
                            int i75 = 0;
                            int i76 = 3;
                            while (i75 < i76) {
                                int i77 = iArr2[i75];
                                if (i74 != 0) {
                                    if (i74 != 1) {
                                        if (i74 == 2) {
                                            char[] cArr = c.f1846b;
                                            if (i77 < cArr.length) {
                                                char c2 = cArr[i77];
                                                if (z12) {
                                                    sb.append((char) (c2 + 128));
                                                    z12 = false;
                                                } else {
                                                    sb.append(c2);
                                                    z2 = z12;
                                                    z12 = z2;
                                                }
                                            } else if (i77 == 27) {
                                                sb.append(c);
                                            } else {
                                                if (i77 != 30) {
                                                    throw FormatException.a();
                                                }
                                                z2 = true;
                                                z12 = z2;
                                            }
                                        } else {
                                            if (i74 != i76) {
                                                throw FormatException.a();
                                            }
                                            if (z12) {
                                                sb.append((char) (i77 + 224));
                                                z12 = false;
                                            } else {
                                                sb.append((char) (i77 + 96));
                                                z2 = z12;
                                                z12 = z2;
                                            }
                                        }
                                    } else if (z12) {
                                        sb.append((char) (i77 + 128));
                                        z12 = false;
                                    } else {
                                        sb.append((char) i77);
                                    }
                                    i74 = 0;
                                    i76 = 3;
                                } else if (i77 < i76) {
                                    i74 = i77 + 1;
                                } else {
                                    char[] cArr2 = c.a;
                                    if (i77 >= cArr2.length) {
                                        throw FormatException.a();
                                    }
                                    char c3 = cArr2[i77];
                                    if (z12) {
                                        sb.append((char) (c3 + 128));
                                        z12 = false;
                                    } else {
                                        sb.append(c3);
                                    }
                                }
                                i75++;
                                c = 29;
                            }
                            if (cVar.a() > 0) {
                                c = 29;
                            }
                        }
                    }
                } else if (iH == 3) {
                    int i78 = 3;
                    int[] iArr3 = new int[3];
                    int i79 = 0;
                    boolean z13 = false;
                    for (int i80 = 254; cVar.a() != i60 && (iB2 = cVar.b(i60)) != i80; i80 = 254) {
                        c.a(iB2, cVar.b(i60), iArr3);
                        boolean z14 = z13;
                        int i81 = 0;
                        while (i81 < i78) {
                            int i82 = iArr3[i81];
                            if (i79 != 0) {
                                if (i79 != 1) {
                                    if (i79 == 2) {
                                        char[] cArr3 = c.d;
                                        if (i82 < cArr3.length) {
                                            char c4 = cArr3[i82];
                                            if (z14) {
                                                sb.append((char) (c4 + 128));
                                                z14 = false;
                                            } else {
                                                sb.append(c4);
                                            }
                                        } else if (i82 == 27) {
                                            sb.append((char) 29);
                                        } else {
                                            if (i82 != 30) {
                                                throw FormatException.a();
                                            }
                                            z14 = true;
                                        }
                                    } else {
                                        if (i79 != i78) {
                                            throw FormatException.a();
                                        }
                                        char[] cArr4 = c.e;
                                        if (i82 >= cArr4.length) {
                                            throw FormatException.a();
                                        }
                                        char c5 = cArr4[i82];
                                        if (z14) {
                                            sb.append((char) (c5 + 128));
                                            z14 = false;
                                        } else {
                                            sb.append(c5);
                                        }
                                    }
                                } else if (z14) {
                                    sb.append((char) (i82 + 128));
                                    z14 = false;
                                } else {
                                    sb.append((char) i82);
                                }
                                i79 = 0;
                            } else if (i82 < i78) {
                                i79 = i82 + 1;
                            } else {
                                char[] cArr5 = c.c;
                                if (i82 >= cArr5.length) {
                                    throw FormatException.a();
                                }
                                char c6 = cArr5[i82];
                                if (z14) {
                                    sb.append((char) (c6 + 128));
                                    z14 = false;
                                } else {
                                    sb.append(c6);
                                }
                            }
                            i81++;
                            i78 = 3;
                        }
                        if (cVar.a() > 0) {
                            z13 = z14;
                            i78 = 3;
                            i60 = 8;
                        }
                    }
                } else if (iH == 4) {
                    int i83 = 3;
                    int[] iArr4 = new int[3];
                    while (cVar.a() != i60 && (iB3 = cVar.b(i60)) != 254) {
                        c.a(iB3, cVar.b(i60), iArr4);
                        int i84 = 0;
                        while (i84 < i83) {
                            int i85 = iArr4[i84];
                            if (i85 == 0) {
                                sb.append('\r');
                            } else if (i85 == 1) {
                                sb.append('*');
                            } else if (i85 == 2) {
                                sb.append('>');
                            } else if (i85 == i83) {
                                sb.append(' ');
                            } else if (i85 < 14) {
                                sb.append((char) (i85 + 44));
                            } else {
                                if (i85 >= 40) {
                                    throw FormatException.a();
                                }
                                sb.append((char) (i85 + 51));
                            }
                            i84++;
                            i83 = 3;
                        }
                        if (cVar.a() > 0) {
                            i83 = 3;
                        }
                    }
                } else if (iH == 5) {
                    while (cVar.a() > 16) {
                        int i86 = 0;
                        while (true) {
                            if (i86 < 4) {
                                int iB4 = cVar.b(6);
                                if (iB4 == 31) {
                                    int i87 = 8 - cVar.c;
                                    if (i87 != i60) {
                                        cVar.b(i87);
                                    }
                                } else {
                                    if ((iB4 & 32) == 0) {
                                        iB4 |= 64;
                                    }
                                    sb.append((char) iB4);
                                    i86++;
                                }
                            } else if (cVar.a() <= 0) {
                            }
                        }
                    }
                } else {
                    if (iH != 6) {
                        throw FormatException.a();
                    }
                    int i88 = cVar.f1830b + 1;
                    int i89 = i88 + 1;
                    int iB5 = c.b(cVar.b(i60), i88);
                    if (iB5 == 0) {
                        iB5 = cVar.a() / i60;
                    } else if (iB5 >= 250) {
                        iB5 = ((iB5 - 249) * 250) + c.b(cVar.b(i60), i89);
                        i89++;
                    }
                    if (iB5 < 0) {
                        throw FormatException.a();
                    }
                    byte[] bArr4 = new byte[iB5];
                    int i90 = 0;
                    while (i90 < iB5) {
                        if (cVar.a() < i60) {
                            throw FormatException.a();
                        }
                        bArr4[i90] = (byte) c.b(cVar.b(i60), i89);
                        i90++;
                        i89++;
                    }
                    arrayList.add(bArr4);
                    try {
                        sb.append(new String(bArr4, "ISO8859_1"));
                    } catch (UnsupportedEncodingException e) {
                        throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e)));
                    }
                }
                i72 = 2;
                i = 1;
                if (i72 != i) {
                }
                if (sb2.length() > 0) {
                    sb.append((CharSequence) sb2);
                }
                String string = sb.toString();
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                return new b.i.e.n.e(bArr2, string, arrayList, null);
            }
            boolean z15 = false;
            while (true) {
                int iB6 = cVar.b(i60);
                if (iB6 == 0) {
                    throw FormatException.a();
                }
                if (iB6 > 128) {
                    if (iB6 == 129) {
                        i73 = 1;
                    } else {
                        if (iB6 > 229) {
                            switch (iB6) {
                                case 230:
                                    i73 = 3;
                                    i72 = i73;
                                    i = 1;
                                    if (i72 != i || cVar.a() <= 0) {
                                        if (sb2.length() > 0) {
                                            sb.append((CharSequence) sb2);
                                        }
                                        String string2 = sb.toString();
                                        if (arrayList.isEmpty()) {
                                            arrayList = null;
                                        }
                                        return new b.i.e.n.e(bArr2, string2, arrayList, null);
                                    }
                                    i60 = 8;
                                    break;
                                    break;
                                case 231:
                                    i73 = 7;
                                    i72 = i73;
                                    i = 1;
                                    if (i72 != i) {
                                    }
                                    if (sb2.length() > 0) {
                                        sb.append((CharSequence) sb2);
                                    }
                                    String string3 = sb.toString();
                                    if (arrayList.isEmpty()) {
                                        arrayList = null;
                                    }
                                    return new b.i.e.n.e(bArr2, string3, arrayList, null);
                                case 232:
                                    sb.append((char) 29);
                                    if (cVar.a() <= 0) {
                                    }
                                    break;
                                case 233:
                                case 234:
                                case 241:
                                    break;
                                case 235:
                                    z15 = true;
                                    if (cVar.a() <= 0) {
                                    }
                                    break;
                                case 236:
                                    sb.append("[)>\u001e05\u001d");
                                    sb2.insert(0, "\u001e\u0004");
                                    if (cVar.a() <= 0) {
                                    }
                                    break;
                                case 237:
                                    sb.append("[)>\u001e06\u001d");
                                    sb2.insert(0, "\u001e\u0004");
                                    if (cVar.a() <= 0) {
                                    }
                                    break;
                                case 238:
                                    i73 = 5;
                                    break;
                                case 239:
                                    i73 = 4;
                                    break;
                                case 240:
                                    break;
                                default:
                                    if (iB6 != 254 || cVar.a() != 0) {
                                        throw FormatException.a();
                                    }
                                    if (cVar.a() <= 0) {
                                    }
                                    break;
                            }
                        } else {
                            int i91 = iB6 - 130;
                            if (i91 < 10) {
                                sb.append('0');
                            }
                            sb.append(i91);
                        }
                        if (cVar.a() <= 0) {
                        }
                    }
                    i72 = i73;
                    i = 1;
                    if (i72 != i) {
                    }
                    if (sb2.length() > 0) {
                        sb.append((CharSequence) sb2);
                    }
                    String string4 = sb.toString();
                    if (arrayList.isEmpty()) {
                        arrayList = null;
                    }
                    return new b.i.e.n.e(bArr2, string4, arrayList, null);
                }
                if (z15) {
                    iB6 += 128;
                }
                sb.append((char) (iB6 - 1));
            }
            i72 = 2;
            i = 1;
            if (i72 != i) {
            }
            if (sb2.length() > 0) {
                sb.append((CharSequence) sb2);
            }
            String string5 = sb.toString();
            if (arrayList.isEmpty()) {
                arrayList = null;
            }
            return new b.i.e.n.e(bArr2, string5, arrayList, null);
        }
    }
}
