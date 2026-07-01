package b.i.e.m.c;

import androidx.exifinterface.media.ExifInterface;
import b.c.a.y.b;
import b.i.e.m.AztecDetectorResult;
import b.i.e.n.BitMatrix;
import b.i.e.n.DecoderResult;
import b.i.e.n.l.GenericGF;
import b.i.e.n.l.ReedSolomonDecoder;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import com.google.android.material.badge.BadgeDrawable;
import com.google.zxing.FormatException;
import com.google.zxing.ReaderException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.e.m.c.a, reason: use source file name */
/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Decoder2 {
    public static final String[] a = {"CTRL_PS", " ", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f1827b = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    public static final String[] c = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    public static final String[] d = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX, ",", "-", ".", AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    public static final String[] e = {"CTRL_PS", " ", "0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};
    public AztecDetectorResult f;

    public static int b(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    public DecoderResult a(AztecDetectorResult aztecDetectorResult) throws FormatException {
        int i;
        GenericGF genericGF;
        String str;
        this.f = aztecDetectorResult;
        BitMatrix bitMatrix = aztecDetectorResult.a;
        boolean z2 = aztecDetectorResult.c;
        int i2 = aztecDetectorResult.e;
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
                    zArr[i12 + i17 + i18] = bitMatrix.f(iArr[i19], iArr[i20]);
                    int i21 = i15 - i18;
                    zArr[(i13 * 2) + i12 + i17 + i18] = bitMatrix.f(iArr[i20], iArr[i21]);
                    int i22 = i15 - i16;
                    zArr[(i13 * 4) + i12 + i17 + i18] = bitMatrix.f(iArr[i21], iArr[i22]);
                    zArr[(i13 * 6) + i12 + i17 + i18] = bitMatrix.f(iArr[i22], iArr[i19]);
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
        AztecDetectorResult aztecDetectorResult2 = this.f;
        int i23 = aztecDetectorResult2.e;
        int i24 = 8;
        if (i23 <= 2) {
            genericGF = GenericGF.c;
            i = 6;
        } else if (i23 <= 8) {
            genericGF = GenericGF.g;
            i = 8;
        } else if (i23 <= 22) {
            i = 10;
            genericGF = GenericGF.f1841b;
        } else {
            genericGF = GenericGF.a;
        }
        int i25 = aztecDetectorResult2.d;
        int i26 = i4 / i;
        if (i26 < i25) {
            throw FormatException.a();
        }
        int i27 = i4 % i;
        int[] iArr2 = new int[i26];
        int i28 = 0;
        while (i28 < i26) {
            iArr2[i28] = b(zArr, i27, i);
            i28++;
            i27 += i;
        }
        try {
            new ReedSolomonDecoder(genericGF).a(iArr2, i26 - i25);
            int i29 = 1;
            int i30 = (1 << i) - 1;
            int i31 = 0;
            int i32 = 0;
            while (i31 < i25) {
                int i33 = iArr2[i31];
                if (i33 == 0 || i33 == i30) {
                    throw FormatException.a();
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
                bArr[i42] = (byte) (i44 >= 8 ? b(zArr2, i43, 8) : b(zArr2, i43, i44) << (8 - i44));
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
                    int iB = b(zArr2, i47, i48);
                    i47 += i48;
                    int iH = b.h(i45);
                    int i49 = 3;
                    if (iH == 0) {
                        str = a[iB];
                    } else if (iH == 1) {
                        str = f1827b[iB];
                    } else if (iH == 2) {
                        str = c[iB];
                    } else if (iH == 3) {
                        str = e[iB];
                    } else {
                        if (iH != 4) {
                            throw new IllegalStateException("Bad table");
                        }
                        str = d[iB];
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
                    int iB2 = b(zArr2, i47, 5);
                    i47 += 5;
                    if (iB2 == 0) {
                        if (i34 - i47 < 11) {
                            break;
                        }
                        iB2 = b(zArr2, i47, 11) + 31;
                        i47 += 11;
                    }
                    for (int i50 = 0; i50 < iB2; i50++) {
                        if (i34 - i47 < i24) {
                            i47 = i34;
                            break;
                        }
                        sb.append((char) b(zArr2, i47, i24));
                        i47 += 8;
                    }
                    i45 = i46;
                }
                i24 = 8;
            }
            DecoderResult decoderResult = new DecoderResult(bArr, sb.toString(), null, null);
            decoderResult.f1835b = i34;
            return decoderResult;
        } catch (ReedSolomonException e2) {
            if (ReaderException.j) {
                throw new FormatException(e2);
            }
            throw FormatException.l;
        }
    }
}
