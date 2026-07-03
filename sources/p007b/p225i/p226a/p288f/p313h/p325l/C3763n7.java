package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzij;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.a.f.h.l.n7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3763n7 extends AbstractC3750m7 {
    /* JADX INFO: renamed from: d */
    public static int m5140d(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            AbstractC3750m7 abstractC3750m7 = C3724k7.f10058a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                return C3724k7.m5023c(i, C3711j7.m4976a(bArr, j), C3711j7.m4976a(bArr, j + 1));
            }
            throw new AssertionError();
        }
        byte bM4976a = C3711j7.m4976a(bArr, j);
        AbstractC3750m7 abstractC3750m8 = C3724k7.f10058a;
        if (i > -12 || bM4976a > -65) {
            return -1;
        }
        return i ^ (bM4976a << 8);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3750m7
    /* JADX INFO: renamed from: a */
    public final int mo5055a(int i, byte[] bArr, int i2, int i3) {
        int i4;
        long j;
        if ((i2 | i3 | (bArr.length - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        long j2 = i2;
        int i5 = (int) (((long) i3) - j2);
        if (i5 >= 16) {
            long j3 = j2;
            i4 = 0;
            while (true) {
                if (i4 >= i5) {
                    i4 = i5;
                    break;
                }
                long j4 = j3 + 1;
                if (C3711j7.m4976a(bArr, j3) < 0) {
                    break;
                }
                i4++;
                j3 = j4;
            }
        } else {
            i4 = 0;
        }
        int i6 = i5 - i4;
        long j5 = j2 + ((long) i4);
        while (true) {
            byte bM4976a = 0;
            while (i6 > 0) {
                long j6 = j5 + 1;
                bM4976a = C3711j7.m4976a(bArr, j5);
                if (bM4976a < 0) {
                    j5 = j6;
                    break;
                }
                i6--;
                j5 = j6;
            }
            if (i6 == 0) {
                return 0;
            }
            int i7 = i6 - 1;
            if (bM4976a < -32) {
                if (i7 == 0) {
                    return bM4976a;
                }
                i6 = i7 - 1;
                if (bM4976a >= -62) {
                    j = j5 + 1;
                    if (C3711j7.m4976a(bArr, j5) > -65) {
                    }
                }
                return -1;
            }
            if (bM4976a >= -16) {
                if (i7 < 3) {
                    return m5140d(bArr, bM4976a, j5, i7);
                }
                i6 = i7 - 3;
                long j7 = j5 + 1;
                byte bM4976a2 = C3711j7.m4976a(bArr, j5);
                if (bM4976a2 <= -65 && (((bM4976a2 + 112) + (bM4976a << 28)) >> 30) == 0) {
                    long j8 = j7 + 1;
                    if (C3711j7.m4976a(bArr, j7) <= -65) {
                        j = j8 + 1;
                        if (C3711j7.m4976a(bArr, j8) > -65) {
                        }
                    }
                }
                return -1;
            }
            if (i7 < 2) {
                return m5140d(bArr, bM4976a, j5, i7);
            }
            i6 = i7 - 2;
            long j9 = j5 + 1;
            byte bM4976a3 = C3711j7.m4976a(bArr, j5);
            if (bM4976a3 <= -65 && ((bM4976a != -32 || bM4976a3 >= -96) && (bM4976a != -19 || bM4976a3 < -96))) {
                j5 = j9 + 1;
                if (C3711j7.m4976a(bArr, j9) > -65) {
                }
            }
            return -1;
            j5 = j;
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3750m7
    /* JADX INFO: renamed from: b */
    public final int mo5056b(CharSequence charSequence, byte[] bArr, int i, int i2) {
        char c;
        long j;
        long j2;
        long j3;
        int i3;
        char cCharAt;
        long j4 = i;
        long j5 = ((long) i2) + j4;
        int length = charSequence.length();
        if (length > i2 || bArr.length - i2 < i) {
            char cCharAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(cCharAt2);
            sb.append(" at index ");
            sb.append(i + i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i4 = 0;
        while (true) {
            c = 128;
            j = 1;
            if (i4 >= length || (cCharAt = charSequence.charAt(i4)) >= 128) {
                break;
            }
            C3711j7.m4982g(bArr, j4, (byte) cCharAt);
            i4++;
            j4 = 1 + j4;
        }
        if (i4 == length) {
            return (int) j4;
        }
        while (i4 < length) {
            char cCharAt3 = charSequence.charAt(i4);
            if (cCharAt3 >= c || j4 >= j5) {
                if (cCharAt3 < 2048 && j4 <= j5 - 2) {
                    long j6 = j4 + j;
                    C3711j7.m4982g(bArr, j4, (byte) ((cCharAt3 >>> 6) | 960));
                    C3711j7.m4982g(bArr, j6, (byte) ((cCharAt3 & '?') | 128));
                    j2 = j6 + j;
                    j3 = j;
                } else {
                    if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j4 > j5 - 3) {
                        if (j4 > j5 - 4) {
                            if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                                throw new C3776o7(i4, length);
                            }
                            StringBuilder sb2 = new StringBuilder(46);
                            sb2.append("Failed writing ");
                            sb2.append(cCharAt3);
                            sb2.append(" at index ");
                            sb2.append(j4);
                            throw new ArrayIndexOutOfBoundsException(sb2.toString());
                        }
                        int i5 = i4 + 1;
                        if (i5 != length) {
                            char cCharAt4 = charSequence.charAt(i5);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt4)) {
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt4);
                                long j7 = j4 + 1;
                                C3711j7.m4982g(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                long j8 = j7 + 1;
                                C3711j7.m4982g(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j9 = j8 + 1;
                                C3711j7.m4982g(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 = 1;
                                j2 = j9 + 1;
                                C3711j7.m4982g(bArr, j9, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new C3776o7(i4 - 1, length);
                    }
                    long j10 = j4 + j;
                    C3711j7.m4982g(bArr, j4, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    C3711j7.m4982g(bArr, j10, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    C3711j7.m4982g(bArr, j11, (byte) ((cCharAt3 & '?') | 128));
                    j2 = j11 + 1;
                    j3 = 1;
                }
                i4++;
                c = 128;
                long j12 = j3;
                j4 = j2;
                j = j12;
            } else {
                long j13 = j4 + j;
                C3711j7.m4982g(bArr, j4, (byte) cCharAt3);
                j3 = j;
                j2 = j13;
            }
            i4++;
            c = 128;
            long j14 = j3;
            j4 = j2;
            j = j14;
        }
        return (int) j4;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3750m7
    /* JADX INFO: renamed from: c */
    public final String mo5057c(byte[] bArr, int i, int i2) throws zzij {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bM4976a = C3711j7.m4976a(bArr, i);
            if (!C3404f.m4302i2(bM4976a)) {
                break;
            }
            i++;
            cArr[i4] = (char) bM4976a;
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bM4976a2 = C3711j7.m4976a(bArr, i);
            if (C3404f.m4302i2(bM4976a2)) {
                int i7 = i5 + 1;
                cArr[i5] = (char) bM4976a2;
                i = i6;
                while (true) {
                    i5 = i7;
                    if (i >= i3) {
                        break;
                    }
                    byte bM4976a3 = C3711j7.m4976a(bArr, i);
                    if (!C3404f.m4302i2(bM4976a3)) {
                        break;
                    }
                    i++;
                    i7 = i5 + 1;
                    cArr[i5] = (char) bM4976a3;
                }
            } else {
                if (!(bM4976a2 < -32)) {
                    if (bM4976a2 < -16) {
                        if (i6 >= i3 - 1) {
                            throw zzij.m9107e();
                        }
                        int i8 = i6 + 1;
                        C3404f.m4274b2(bM4976a2, C3711j7.m4976a(bArr, i6), C3711j7.m4976a(bArr, i8), cArr, i5);
                        i = i8 + 1;
                        i5++;
                    } else {
                        if (i6 >= i3 - 2) {
                            throw zzij.m9107e();
                        }
                        int i9 = i6 + 1;
                        byte bM4976a4 = C3711j7.m4976a(bArr, i6);
                        int i10 = i9 + 1;
                        C3404f.m4270a2(bM4976a2, bM4976a4, C3711j7.m4976a(bArr, i9), C3711j7.m4976a(bArr, i10), cArr, i5);
                        i5 = i5 + 1 + 1;
                        i = i10 + 1;
                    }
                } else {
                    if (i6 >= i3) {
                        throw zzij.m9107e();
                    }
                    C3404f.m4278c2(bM4976a2, C3711j7.m4976a(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                }
            }
        }
        return new String(cArr, 0, i5);
    }
}
