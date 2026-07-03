package p007b.p225i.p414e.p415m.p416c;

import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.zxing.FormatException;
import com.google.zxing.ReaderException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Arrays;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p414e.p415m.C4958a;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p418n.C4966e;
import p007b.p225i.p414e.p418n.p420l.C4973a;
import p007b.p225i.p414e.p418n.p420l.C4975c;

/* JADX INFO: renamed from: b.i.e.m.c.a */
/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4960a {

    /* JADX INFO: renamed from: a */
    public static final String[] f13212a = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: b */
    public static final String[] f13213b = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: c */
    public static final String[] f13214c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* JADX INFO: renamed from: d */
    public static final String[] f13215d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, ",", "-", ".", AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* JADX INFO: renamed from: e */
    public static final String[] f13216e = {"CTRL_PS", " ", "0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* JADX INFO: renamed from: f */
    public C4958a f13217f;

    /* JADX INFO: renamed from: b */
    public static int m6925b(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    /* JADX INFO: renamed from: a */
    public C4966e m6926a(C4958a c4958a) throws FormatException {
        int i;
        C4973a c4973a;
        String str;
        this.f13217f = c4958a;
        C4963b c4963b = c4958a.f13275a;
        boolean z2 = c4958a.f13209c;
        int i2 = c4958a.f13211e;
        int i3 = (z2 ? 11 : 14) + (i2 << 2);
        int[] iArr = new int[i3];
        int i4 = ((z2 ? 88 : 112) + (i2 << 4)) * i2;
        boolean[] zArr = new boolean[i4];
        int i5 = 2;
        if (z2) {
            for (int i6 = 0; i6 < i3; i6++) {
                iArr[i6] = i6;
            }
        } else {
            int i7 = i3 / 2;
            int i8 = ((((i7 - 1) / 15) * 2) + (i3 + 1)) / 2;
            for (int i9 = 0; i9 < i7; i9++) {
                int i10 = (i9 / 15) + i9;
                iArr[(i7 - i9) - 1] = (i8 - i10) - 1;
                iArr[i7 + i9] = i10 + i8 + 1;
            }
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i = 12;
            if (i11 >= i2) {
                break;
            }
            int i13 = ((i2 - i11) << i5) + (z2 ? 9 : 12);
            int i14 = i11 << 1;
            int i15 = (i3 - 1) - i14;
            int i16 = 0;
            while (i16 < i13) {
                int i17 = i16 << 1;
                int i18 = 0;
                while (i18 < i5) {
                    int i19 = i14 + i18;
                    int i20 = i14 + i16;
                    zArr[i12 + i17 + i18] = c4963b.m6942f(iArr[i19], iArr[i20]);
                    int i21 = i15 - i18;
                    zArr[(i13 * 2) + i12 + i17 + i18] = c4963b.m6942f(iArr[i20], iArr[i21]);
                    int i22 = i15 - i16;
                    zArr[(i13 * 4) + i12 + i17 + i18] = c4963b.m6942f(iArr[i21], iArr[i22]);
                    zArr[(i13 * 6) + i12 + i17 + i18] = c4963b.m6942f(iArr[i22], iArr[i19]);
                    i18++;
                    z2 = z2;
                    i2 = i2;
                    i5 = 2;
                }
                i16++;
                i5 = 2;
            }
            i12 += i13 << 3;
            i11++;
            i2 = i2;
            i5 = 2;
        }
        C4958a c4958a2 = this.f13217f;
        int i23 = c4958a2.f13211e;
        int i24 = 8;
        if (i23 <= 2) {
            c4973a = C4973a.f13301c;
            i = 6;
        } else if (i23 <= 8) {
            c4973a = C4973a.f13305g;
            i = 8;
        } else if (i23 <= 22) {
            i = 10;
            c4973a = C4973a.f13300b;
        } else {
            c4973a = C4973a.f13299a;
        }
        int i25 = c4958a2.f13210d;
        int i26 = i4 / i;
        if (i26 < i25) {
            throw FormatException.m9260a();
        }
        int i27 = i4 % i;
        int[] iArr2 = new int[i26];
        int i28 = 0;
        while (i28 < i26) {
            iArr2[i28] = m6925b(zArr, i27, i);
            i28++;
            i27 += i;
        }
        try {
            new C4975c(c4973a).m6968a(iArr2, i26 - i25);
            int i29 = 1;
            int i30 = (1 << i) - 1;
            int i31 = 0;
            int i32 = 0;
            while (i31 < i25) {
                int i33 = iArr2[i31];
                if (i33 == 0 || i33 == i30) {
                    throw FormatException.m9260a();
                }
                if (i33 == i29 || i33 == i30 - 1) {
                    i32++;
                }
                i31++;
                i29 = 1;
            }
            int i34 = (i25 * i) - i32;
            boolean[] zArr2 = new boolean[i34];
            int i35 = 0;
            for (int i36 = 0; i36 < i25; i36++) {
                int i37 = iArr2[i36];
                int i38 = 1;
                if (i37 == 1 || i37 == i30 - 1) {
                    Arrays.fill(zArr2, i35, (i35 + i) - 1, i37 > 1);
                    i35 = (i - 1) + i35;
                } else {
                    int i39 = i - 1;
                    while (i39 >= 0) {
                        int i40 = i35 + 1;
                        zArr2[i35] = ((i38 << i39) & i37) != 0;
                        i39--;
                        i35 = i40;
                        i38 = 1;
                    }
                }
            }
            int i41 = (i34 + 7) / 8;
            byte[] bArr = new byte[i41];
            for (int i42 = 0; i42 < i41; i42++) {
                int i43 = i42 << 3;
                int i44 = i34 - i43;
                bArr[i42] = (byte) (i44 >= 8 ? m6925b(zArr2, i43, 8) : m6925b(zArr2, i43, i44) << (8 - i44));
            }
            StringBuilder sb = new StringBuilder(20);
            int i45 = 1;
            int i46 = 1;
            int i47 = 0;
            while (i47 < i34) {
                if (i45 != 6) {
                    int i48 = i45 == 4 ? 4 : 5;
                    if (i34 - i47 < i48) {
                        break;
                    }
                    int iM6925b = m6925b(zArr2, i47, i48);
                    i47 += i48;
                    int iM758h = C1563b.m758h(i45);
                    int i49 = 3;
                    if (iM758h == 0) {
                        str = f13212a[iM6925b];
                    } else if (iM758h == 1) {
                        str = f13213b[iM6925b];
                    } else if (iM758h == 2) {
                        str = f13214c[iM6925b];
                    } else if (iM758h == 3) {
                        str = f13216e[iM6925b];
                    } else {
                        if (iM758h != 4) {
                            throw new IllegalStateException("Bad table");
                        }
                        str = f13215d[iM6925b];
                    }
                    if (str.startsWith("CTRL_")) {
                        char cCharAt = str.charAt(5);
                        if (cCharAt == 'B') {
                            i49 = 6;
                        } else if (cCharAt == 'D') {
                            i49 = 4;
                        } else if (cCharAt == 'P') {
                            i49 = 5;
                        } else if (cCharAt == 'L') {
                            i49 = 2;
                        } else if (cCharAt != 'M') {
                            i49 = 1;
                        }
                        if (str.charAt(6) == 'L') {
                            i46 = i49;
                        } else {
                            i46 = i45;
                            i45 = i49;
                        }
                    } else {
                        sb.append(str);
                    }
                    i45 = i46;
                } else {
                    if (i34 - i47 < 5) {
                        break;
                    }
                    int iM6925b2 = m6925b(zArr2, i47, 5);
                    i47 += 5;
                    if (iM6925b2 == 0) {
                        if (i34 - i47 < 11) {
                            break;
                        }
                        iM6925b2 = m6925b(zArr2, i47, 11) + 31;
                        i47 += 11;
                    }
                    for (int i50 = 0; i50 < iM6925b2; i50++) {
                        if (i34 - i47 < i24) {
                            i47 = i34;
                            break;
                        }
                        sb.append((char) m6925b(zArr2, i47, i24));
                        i47 += 8;
                    }
                    i45 = i46;
                }
                i24 = 8;
            }
            C4966e c4966e = new C4966e(bArr, sb.toString(), null, null);
            c4966e.f13267b = i34;
            return c4966e;
        } catch (ReedSolomonException e) {
            if (ReaderException.f21666j) {
                throw new FormatException(e);
            }
            throw FormatException.f21664l;
        }
    }
}
