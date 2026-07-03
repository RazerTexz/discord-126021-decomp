package p007b.p225i.p414e.p430r.p431d;

import com.google.zxing.FormatException;
import java.math.BigInteger;
import p007b.p085c.p086a.p095y.C1563b;

/* JADX INFO: renamed from: b.i.e.r.d.e */
/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5038e {

    /* JADX INFO: renamed from: a */
    public static final char[] f13484a = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();

    /* JADX INFO: renamed from: b */
    public static final char[] f13485b = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* JADX INFO: renamed from: c */
    public static final BigInteger[] f13486c;

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        f13486c = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = f13486c;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m7052a(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(f13486c[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.m9260a();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x002e  */
    /* JADX INFO: renamed from: b */
    public static int m7053b(int[] iArr, int i, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z2 = false;
        int i2 = 0;
        while (i < iArr[0] && !z2) {
            int i3 = i + 1;
            int i4 = iArr[i];
            if (i3 == iArr[0]) {
                z2 = true;
            }
            if (i4 >= 900) {
                if (i4 != 900 && i4 != 901 && i4 != 928) {
                    switch (i4) {
                        case 922:
                        case 923:
                        case 924:
                            i3--;
                            z2 = true;
                            break;
                    }
                } else {
                    i3--;
                    z2 = true;
                }
            } else {
                iArr2[i2] = i4;
                i2++;
            }
            if ((i2 % 15 == 0 || i4 == 902 || z2) && i2 > 0) {
                sb.append(m7052a(iArr2, i2));
                i2 = 0;
            }
            i = i3;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:74:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:77:0x00f2 A[PHI: r11
      0x00f2: PHI (r11v11 int) = (r11v1 int), (r11v1 int), (r11v14 int) binds: [B:72:0x00e3, B:61:0x00c6, B:46:0x009d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:95:0x0124  */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x0039. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x003c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:61:0x00c6. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:72:0x00e3. Please report as an issue. */
    /* JADX INFO: renamed from: c */
    public static int m7054c(int[] iArr, int i, StringBuilder sb) {
        int i2;
        char c;
        int[] iArr2 = new int[(iArr[0] - i) << 1];
        int[] iArr3 = new int[(iArr[0] - i) << 1];
        int i3 = i;
        boolean z2 = false;
        int i4 = 0;
        while (i3 < iArr[0] && !z2) {
            int i5 = i3 + 1;
            int i6 = iArr[i3];
            if (i6 < 900) {
                iArr2[i4] = i6 / 30;
                iArr2[i4 + 1] = i6 % 30;
                i4 += 2;
            } else if (i6 != 913) {
                if (i6 != 928) {
                    switch (i6) {
                        case 900:
                            iArr2[i4] = 900;
                            i4++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i6) {
                                case 922:
                                case 923:
                                case 924:
                                    break;
                                default:
                                    break;
                            }
                            break;
                    }
                }
                i3 = i5 - 1;
                z2 = true;
            } else {
                iArr2[i4] = 913;
                i3 = i5 + 1;
                iArr3[i4] = iArr[i5];
                i4++;
            }
            i3 = i5;
        }
        int i7 = 1;
        int i8 = 1;
        for (int i9 = 0; i9 < i4; i9++) {
            int i10 = iArr2[i9];
            int iM758h = C1563b.m758h(i7);
            if (iM758h != 0) {
                if (iM758h != 1) {
                    if (iM758h != 2) {
                        if (iM758h != 3) {
                            if (iM758h != 4) {
                                if (iM758h == 5) {
                                    if (i10 < 29) {
                                        c = f13484a[i10];
                                        i7 = i8;
                                    } else if (i10 == 29 || i10 == 900) {
                                        i7 = 1;
                                    } else {
                                        if (i10 == 913) {
                                            sb.append((char) iArr3[i9]);
                                        }
                                        i7 = i8;
                                    }
                                }
                                c = 0;
                            } else if (i10 < 26) {
                                c = (char) (i10 + 65);
                                i7 = i8;
                            } else if (i10 != 26) {
                                if (i10 != 900) {
                                    i7 = i8;
                                } else {
                                    i7 = 1;
                                }
                                c = 0;
                            } else {
                                i7 = i8;
                                c = ' ';
                            }
                        } else if (i10 < 29) {
                            c = f13484a[i10];
                        } else {
                            if (i10 == 29 || i10 == 900) {
                                i7 = 1;
                            } else if (i10 == 913) {
                                sb.append((char) iArr3[i9]);
                            }
                            c = 0;
                        }
                    } else if (i10 < 25) {
                        c = f13485b[i10];
                    } else {
                        if (i10 != 900) {
                            if (i10 != 913) {
                                switch (i10) {
                                    case 25:
                                        i7 = 4;
                                        break;
                                    case 26:
                                        c = ' ';
                                        break;
                                    case 27:
                                        i7 = 2;
                                        c = 0;
                                        break;
                                    case 29:
                                        i8 = i7;
                                        c = 0;
                                        i7 = 6;
                                        break;
                                }
                            } else {
                                sb.append((char) iArr3[i9]);
                            }
                            c = 0;
                        }
                        i7 = 1;
                        c = 0;
                    }
                } else if (i10 < 26) {
                    i2 = i10 + 97;
                    c = (char) i2;
                } else {
                    if (i10 == 900) {
                        i7 = 1;
                    } else if (i10 != 913) {
                        switch (i10) {
                            case 26:
                                c = ' ';
                                break;
                            case 27:
                                i8 = i7;
                                i7 = 5;
                                break;
                            case 28:
                                i7 = 3;
                                break;
                            case 29:
                                i8 = i7;
                                c = 0;
                                i7 = 6;
                                break;
                        }
                    } else {
                        sb.append((char) iArr3[i9]);
                    }
                    c = 0;
                }
            } else if (i10 < 26) {
                i2 = i10 + 65;
                c = (char) i2;
            } else {
                if (i10 == 900) {
                    i7 = 1;
                } else if (i10 != 913) {
                    switch (i10) {
                        case 26:
                            c = ' ';
                            break;
                        case 27:
                            i7 = 2;
                            break;
                        case 28:
                            i7 = 3;
                            break;
                        case 29:
                            i8 = i7;
                            c = 0;
                            i7 = 6;
                            break;
                    }
                } else {
                    sb.append((char) iArr3[i9]);
                }
                c = 0;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
        return i3;
    }
}
