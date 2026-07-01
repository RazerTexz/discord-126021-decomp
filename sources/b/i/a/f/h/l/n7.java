package b.i.a.f.h.l;

import com.google.android.gms.internal.measurement.zzij;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class n7 extends m7 {
    public static int d(byte[] bArr, int i, long j, int i2) {
        if (i2 == 0) {
            m7 m7Var = k7.a;
            if (i > -12) {
                return -1;
            }
            return i;
        }
        if (i2 != 1) {
            if (i2 == 2) {
                return k7.c(i, j7.a(bArr, j), j7.a(bArr, j + 1));
            }
            throw new AssertionError();
        }
        byte bA = j7.a(bArr, j);
        m7 m7Var2 = k7.a;
        if (i > -12 || bA > -65) {
            return -1;
        }
        return i ^ (bA << 8);
    }

    @Override // b.i.a.f.h.l.m7
    public final int a(int i, byte[] bArr, int i2, int i3) {
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
                if (j7.a(bArr, j3) < 0) {
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
            byte bA = 0;
            while (i6 > 0) {
                long j6 = j5 + 1;
                bA = j7.a(bArr, j5);
                if (bA < 0) {
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
            if (bA < -32) {
                if (i7 == 0) {
                    return bA;
                }
                i6 = i7 - 1;
                if (bA >= -62) {
                    j = j5 + 1;
                    if (j7.a(bArr, j5) > -65) {
                    }
                }
                return -1;
            }
            if (bA >= -16) {
                if (i7 < 3) {
                    return d(bArr, bA, j5, i7);
                }
                i6 = i7 - 3;
                long j7 = j5 + 1;
                byte bA2 = j7.a(bArr, j5);
                if (bA2 <= -65 && (((bA2 + 112) + (bA << 28)) >> 30) == 0) {
                    long j8 = j7 + 1;
                    if (j7.a(bArr, j7) <= -65) {
                        j = j8 + 1;
                        if (j7.a(bArr, j8) > -65) {
                        }
                    }
                }
                return -1;
            }
            if (i7 < 2) {
                return d(bArr, bA, j5, i7);
            }
            i6 = i7 - 2;
            long j9 = j5 + 1;
            byte bA3 = j7.a(bArr, j5);
            if (bA3 <= -65 && ((bA != -32 || bA3 >= -96) && (bA != -19 || bA3 < -96))) {
                j5 = j9 + 1;
                if (j7.a(bArr, j9) > -65) {
                }
            }
            return -1;
            j5 = j;
        }
    }

    @Override // b.i.a.f.h.l.m7
    public final int b(CharSequence charSequence, byte[] bArr, int i, int i2) {
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
            j7.g(bArr, j4, (byte) cCharAt);
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
                    j7.g(bArr, j4, (byte) ((cCharAt3 >>> 6) | 960));
                    j7.g(bArr, j6, (byte) ((cCharAt3 & '?') | 128));
                    j2 = j6 + j;
                    j3 = j;
                } else {
                    if ((cCharAt3 >= 55296 && 57343 >= cCharAt3) || j4 > j5 - 3) {
                        if (j4 > j5 - 4) {
                            if (55296 <= cCharAt3 && cCharAt3 <= 57343 && ((i3 = i4 + 1) == length || !Character.isSurrogatePair(cCharAt3, charSequence.charAt(i3)))) {
                                throw new o7(i4, length);
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
                                j7.g(bArr, j4, (byte) ((codePoint >>> 18) | 240));
                                long j8 = j7 + 1;
                                j7.g(bArr, j7, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j9 = j8 + 1;
                                j7.g(bArr, j8, (byte) (((codePoint >>> 6) & 63) | 128));
                                j3 = 1;
                                j2 = j9 + 1;
                                j7.g(bArr, j9, (byte) ((codePoint & 63) | 128));
                                i4 = i5;
                            } else {
                                i4 = i5;
                            }
                        }
                        throw new o7(i4 - 1, length);
                    }
                    long j10 = j4 + j;
                    j7.g(bArr, j4, (byte) ((cCharAt3 >>> '\f') | 480));
                    long j11 = j10 + j;
                    j7.g(bArr, j10, (byte) (((cCharAt3 >>> 6) & 63) | 128));
                    j7.g(bArr, j11, (byte) ((cCharAt3 & '?') | 128));
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
                j7.g(bArr, j4, (byte) cCharAt3);
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

    @Override // b.i.a.f.h.l.m7
    public final String c(byte[] bArr, int i, int i2) throws zzij {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (i < i3) {
            byte bA = j7.a(bArr, i);
            if (!b.i.a.f.e.o.f.i2(bA)) {
                break;
            }
            i++;
            cArr[i4] = (char) bA;
            i4++;
        }
        int i5 = i4;
        while (i < i3) {
            int i6 = i + 1;
            byte bA2 = j7.a(bArr, i);
            if (b.i.a.f.e.o.f.i2(bA2)) {
                int i7 = i5 + 1;
                cArr[i5] = (char) bA2;
                i = i6;
                while (true) {
                    i5 = i7;
                    if (i >= i3) {
                        break;
                    }
                    byte bA3 = j7.a(bArr, i);
                    if (!b.i.a.f.e.o.f.i2(bA3)) {
                        break;
                    }
                    i++;
                    i7 = i5 + 1;
                    cArr[i5] = (char) bA3;
                }
            } else {
                if (!(bA2 < -32)) {
                    if (bA2 < -16) {
                        if (i6 >= i3 - 1) {
                            throw zzij.e();
                        }
                        int i8 = i6 + 1;
                        b.i.a.f.e.o.f.b2(bA2, j7.a(bArr, i6), j7.a(bArr, i8), cArr, i5);
                        i = i8 + 1;
                        i5++;
                    } else {
                        if (i6 >= i3 - 2) {
                            throw zzij.e();
                        }
                        int i9 = i6 + 1;
                        byte bA4 = j7.a(bArr, i6);
                        int i10 = i9 + 1;
                        b.i.a.f.e.o.f.a2(bA2, bA4, j7.a(bArr, i9), j7.a(bArr, i10), cArr, i5);
                        i5 = i5 + 1 + 1;
                        i = i10 + 1;
                    }
                } else {
                    if (i6 >= i3) {
                        throw zzij.e();
                    }
                    b.i.a.f.e.o.f.c2(bA2, j7.a(bArr, i6), cArr, i5);
                    i = i6 + 1;
                    i5++;
                }
            }
        }
        return new String(cArr, 0, i5);
    }
}
