package p007b.p225i.p414e.p434s.p435b;

import com.google.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.p418n.C4964c;
import p007b.p225i.p414e.p418n.C4971j;
import p007b.p225i.p414e.p418n.EnumC4965d;

/* JADX INFO: renamed from: b.i.e.s.b.d */
/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5052d {

    /* JADX INFO: renamed from: a */
    public static final char[] f13525a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX INFO: renamed from: a */
    public static void m7091a(C4964c c4964c, StringBuilder sb, int i, boolean z2) throws FormatException {
        while (i > 1) {
            if (c4964c.m6948a() < 11) {
                throw FormatException.m9260a();
            }
            int iM6949b = c4964c.m6949b(11);
            sb.append(m7096f(iM6949b / 45));
            sb.append(m7096f(iM6949b % 45));
            i -= 2;
        }
        if (i == 1) {
            if (c4964c.m6948a() < 6) {
                throw FormatException.m9260a();
            }
            sb.append(m7096f(c4964c.m6949b(6)));
        }
        if (z2) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i2 = length + 1;
                        if (sb.charAt(i2) == '%') {
                            sb.deleteCharAt(i2);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    } else {
                        sb.setCharAt(length, (char) 29);
                    }
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0125  */
    /* JADX WARN: Code duplicated, block: B:112:0x0130 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:113:0x0132  */
    /* JADX WARN: Code duplicated, block: B:119:0x013c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:120:0x013e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x014a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:128:0x014c  */
    /* JADX WARN: Code duplicated, block: B:129:0x014f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:130:0x0151  */
    /* JADX WARN: Code duplicated, block: B:131:0x0154 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:132:0x0156  */
    /* JADX WARN: Code duplicated, block: B:133:0x0159  */
    /* JADX WARN: Code duplicated, block: B:13:0x003a  */
    /* JADX WARN: Code duplicated, block: B:148:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0053  */
    /* JADX WARN: Code duplicated, block: B:30:0x0072 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:31:0x0074  */
    /* JADX WARN: Code duplicated, block: B:33:0x007a  */
    /* JADX WARN: Code duplicated, block: B:34:0x007d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0083  */
    /* JADX WARN: Code duplicated, block: B:38:0x0087  */
    /* JADX WARN: Code duplicated, block: B:40:0x008d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0090  */
    /* JADX WARN: Code duplicated, block: B:43:0x0096  */
    /* JADX WARN: Code duplicated, block: B:44:0x0099  */
    /* JADX WARN: Code duplicated, block: B:46:0x009f  */
    /* JADX WARN: Code duplicated, block: B:47:0x00a2 A[PHI: r10 r20
      0x00a2: PHI (r10v6 int) = (r10v1 int), (r10v5 int), (r10v1 int) binds: [B:37:0x0085, B:45:0x009d, B:32:0x0078] A[DONT_GENERATE, DONT_INLINE]
      0x00a2: PHI (r20v6 byte[]) = (r20v5 byte[]), (r20v5 byte[]), (r20v7 byte[]) binds: [B:37:0x0085, B:45:0x009d, B:32:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:48:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:55:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:66:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:97:0x010f  */
    /* JADX INFO: renamed from: b */
    public static void m7092b(C4964c c4964c, StringBuilder sb, int i, EnumC4965d enumC4965d, Collection<byte[]> collection, Map<EnumC4949d, ?> map) throws FormatException {
        byte[] bArr;
        String strName;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        boolean z6;
        int i9;
        byte[] bArr2;
        if ((i << 3) > c4964c.m6948a()) {
            throw FormatException.m9260a();
        }
        byte[] bArr3 = new byte[i];
        int i10 = 0;
        for (int i11 = 0; i11 < i; i11++) {
            bArr3[i11] = (byte) c4964c.m6949b(8);
        }
        if (enumC4965d == null) {
            String str = C4971j.f13290a;
            if (map != null) {
                EnumC4949d enumC4949d = EnumC4949d.CHARACTER_SET;
                if (map.containsKey(enumC4949d)) {
                    strName = map.get(enumC4949d).toString();
                    bArr = bArr3;
                } else {
                    z2 = true;
                    if (i <= 3 && bArr3[0] == -17 && bArr3[1] == -69 && bArr3[2] == -65) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    int i12 = 0;
                    z4 = true;
                    z5 = true;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    int i13 = 0;
                    i8 = 0;
                    int i14 = 0;
                    int i15 = 0;
                    while (i2 < i && (z2 || z4 || z5)) {
                        i9 = bArr3[i2] & 255;
                        if (z5) {
                            bArr2 = bArr3;
                        } else if (i3 > 0) {
                            bArr2 = bArr3;
                            if ((i9 & 128) != 0) {
                                i3--;
                            } else {
                                z5 = false;
                            }
                        } else {
                            bArr2 = bArr3;
                            if ((i9 & 128) != 0) {
                                if ((i9 & 64) != 0) {
                                    i3++;
                                    if ((i9 & 32) == 0) {
                                        i5++;
                                    } else {
                                        i3++;
                                        if ((i9 & 16) == 0) {
                                            i6++;
                                        } else {
                                            i3++;
                                            if ((i9 & 8) == 0) {
                                                i7++;
                                            } else {
                                                z5 = false;
                                            }
                                        }
                                    }
                                } else {
                                    z5 = false;
                                }
                            }
                        }
                        if (z2) {
                            if (i9 <= 127 && i9 < 160) {
                                z2 = false;
                            } else if (i9 > 159 && (i9 < 192 || i9 == 215 || i9 == 247)) {
                                i8++;
                            }
                        }
                        if (!z4) {
                            if (i4 > 0) {
                                if (i9 >= 64 || i9 == 127 || i9 > 252) {
                                    z4 = false;
                                } else {
                                    i4--;
                                }
                            } else if (i9 != 128 || i9 == 160 || i9 > 239) {
                                z4 = false;
                            } else if (i9 <= 160 || i9 >= 224) {
                                if (i9 > 127) {
                                    i4++;
                                    int i16 = i14 + 1;
                                    if (i16 > i10) {
                                        i10 = i16;
                                        i14 = i10;
                                    } else {
                                        i14 = i16;
                                    }
                                } else {
                                    i14 = 0;
                                }
                                i15 = 0;
                            } else {
                                i12++;
                                int i17 = i15 + 1;
                                if (i17 > i13) {
                                    i13 = i17;
                                }
                                i15 = i17;
                                i14 = 0;
                            }
                        }
                        i2++;
                        bArr3 = bArr2;
                    }
                    bArr = bArr3;
                    if (z5 && i3 > 0) {
                        z5 = false;
                    }
                    if (z4 || i4 <= 0) {
                        z6 = z4;
                    } else {
                        z6 = false;
                    }
                    if (!z5 && (z3 || i5 + i6 + i7 > 0)) {
                        strName = "UTF8";
                    } else if (!z6 && (C4971j.f13291b || i13 >= 3 || i10 >= 3)) {
                        strName = "SJIS";
                    } else if (z2 || !z6) {
                        if (z2) {
                            strName = "ISO8859_1";
                        } else if (z6) {
                            strName = "SJIS";
                        } else if (z5) {
                            strName = "UTF8";
                        } else {
                            strName = C4971j.f13290a;
                        }
                    } else if (!(i13 == 2 && i12 == 2) && i8 * 10 < i) {
                        strName = "ISO8859_1";
                    } else {
                        strName = "SJIS";
                    }
                }
            } else {
                z2 = true;
                if (i <= 3) {
                    z3 = false;
                } else {
                    z3 = false;
                }
                int i18 = 0;
                z4 = true;
                z5 = true;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                int i19 = 0;
                i8 = 0;
                int i110 = 0;
                int i111 = 0;
                while (i2 < i) {
                    i9 = bArr3[i2] & 255;
                    if (z5) {
                        bArr2 = bArr3;
                    } else if (i3 > 0) {
                        bArr2 = bArr3;
                        if ((i9 & 128) != 0) {
                            i3--;
                        } else {
                            z5 = false;
                        }
                    } else {
                        bArr2 = bArr3;
                        if ((i9 & 128) != 0) {
                            if ((i9 & 64) != 0) {
                                i3++;
                                if ((i9 & 32) == 0) {
                                    i5++;
                                } else {
                                    i3++;
                                    if ((i9 & 16) == 0) {
                                        i6++;
                                    } else {
                                        i3++;
                                        if ((i9 & 8) == 0) {
                                            i7++;
                                        } else {
                                            z5 = false;
                                        }
                                    }
                                }
                            } else {
                                z5 = false;
                            }
                        }
                    }
                    if (z2) {
                        if (i9 <= 127) {
                            if (i9 > 159) {
                                i8++;
                            }
                        } else if (i9 > 159) {
                            i8++;
                        }
                    }
                    if (!z4) {
                        if (i4 > 0) {
                            if (i9 >= 64) {
                                z4 = false;
                            } else {
                                z4 = false;
                            }
                        } else if (i9 != 128) {
                            z4 = false;
                        } else {
                            z4 = false;
                        }
                    }
                    i2++;
                    bArr3 = bArr2;
                }
                bArr = bArr3;
                if (z5) {
                    z5 = false;
                }
                if (z4) {
                    z6 = z4;
                } else {
                    z6 = z4;
                }
                if (!z5) {
                    if (!z6) {
                        if (z2) {
                            if (z2) {
                                strName = "ISO8859_1";
                            } else if (z6) {
                                strName = "SJIS";
                            } else if (z5) {
                                strName = "UTF8";
                            } else {
                                strName = C4971j.f13290a;
                            }
                        } else if (z2) {
                            strName = "ISO8859_1";
                        } else if (z6) {
                            strName = "SJIS";
                        } else if (z5) {
                            strName = "UTF8";
                        } else {
                            strName = C4971j.f13290a;
                        }
                    } else if (z2) {
                        if (z2) {
                            strName = "ISO8859_1";
                        } else if (z6) {
                            strName = "SJIS";
                        } else if (z5) {
                            strName = "UTF8";
                        } else {
                            strName = C4971j.f13290a;
                        }
                    } else if (z2) {
                        strName = "ISO8859_1";
                    } else if (z6) {
                        strName = "SJIS";
                    } else if (z5) {
                        strName = "UTF8";
                    } else {
                        strName = C4971j.f13290a;
                    }
                } else if (!z6) {
                    if (z2) {
                        if (z2) {
                            strName = "ISO8859_1";
                        } else if (z6) {
                            strName = "SJIS";
                        } else if (z5) {
                            strName = "UTF8";
                        } else {
                            strName = C4971j.f13290a;
                        }
                    } else if (z2) {
                        strName = "ISO8859_1";
                    } else if (z6) {
                        strName = "SJIS";
                    } else if (z5) {
                        strName = "UTF8";
                    } else {
                        strName = C4971j.f13290a;
                    }
                } else if (z2) {
                    if (z2) {
                        strName = "ISO8859_1";
                    } else if (z6) {
                        strName = "SJIS";
                    } else if (z5) {
                        strName = "UTF8";
                    } else {
                        strName = C4971j.f13290a;
                    }
                } else if (z2) {
                    strName = "ISO8859_1";
                } else if (z6) {
                    strName = "SJIS";
                } else if (z5) {
                    strName = "UTF8";
                } else {
                    strName = C4971j.f13290a;
                }
            }
        } else {
            bArr = bArr3;
            strName = enumC4965d.name();
        }
        try {
            byte[] bArr4 = bArr;
            sb.append(new String(bArr4, strName));
            collection.add(bArr4);
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.m9260a();
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m7093c(C4964c c4964c, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > c4964c.m6948a()) {
            throw FormatException.m9260a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iM6949b = c4964c.m6949b(13);
            int i3 = (iM6949b % 96) | ((iM6949b / 96) << 8);
            int i4 = i3 + (i3 < 959 ? 41377 : 42657);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "GB2312"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.m9260a();
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m7094d(C4964c c4964c, StringBuilder sb, int i) throws FormatException {
        if (i * 13 > c4964c.m6948a()) {
            throw FormatException.m9260a();
        }
        byte[] bArr = new byte[i * 2];
        int i2 = 0;
        while (i > 0) {
            int iM6949b = c4964c.m6949b(13);
            int i3 = (iM6949b % Opcodes.CHECKCAST) | ((iM6949b / Opcodes.CHECKCAST) << 8);
            int i4 = i3 + (i3 < 7936 ? 33088 : 49472);
            bArr[i2] = (byte) (i4 >> 8);
            bArr[i2 + 1] = (byte) i4;
            i2 += 2;
            i--;
        }
        try {
            sb.append(new String(bArr, "SJIS"));
        } catch (UnsupportedEncodingException unused) {
            throw FormatException.m9260a();
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m7095e(C4964c c4964c, StringBuilder sb, int i) throws FormatException {
        while (i >= 3) {
            if (c4964c.m6948a() < 10) {
                throw FormatException.m9260a();
            }
            int iM6949b = c4964c.m6949b(10);
            if (iM6949b >= 1000) {
                throw FormatException.m9260a();
            }
            sb.append(m7096f(iM6949b / 100));
            sb.append(m7096f((iM6949b / 10) % 10));
            sb.append(m7096f(iM6949b % 10));
            i -= 3;
        }
        if (i == 2) {
            if (c4964c.m6948a() < 7) {
                throw FormatException.m9260a();
            }
            int iM6949b2 = c4964c.m6949b(7);
            if (iM6949b2 >= 100) {
                throw FormatException.m9260a();
            }
            sb.append(m7096f(iM6949b2 / 10));
            sb.append(m7096f(iM6949b2 % 10));
            return;
        }
        if (i == 1) {
            if (c4964c.m6948a() < 4) {
                throw FormatException.m9260a();
            }
            int iM6949b3 = c4964c.m6949b(4);
            if (iM6949b3 >= 10) {
                throw FormatException.m9260a();
            }
            sb.append(m7096f(iM6949b3));
        }
    }

    /* JADX INFO: renamed from: f */
    public static char m7096f(int i) throws FormatException {
        char[] cArr = f13525a;
        if (i < cArr.length) {
            return cArr[i];
        }
        throw FormatException.m9260a();
    }
}
