package p007b.p225i.p414e.p424p;

import androidx.exifinterface.media.ExifInterface;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p414e.C4948c;
import p007b.p225i.p414e.C4956k;
import p007b.p225i.p414e.EnumC4946a;
import p007b.p225i.p414e.EnumC4949d;
import p007b.p225i.p414e.EnumC4955j;
import p007b.p225i.p414e.InterfaceC4954i;
import p007b.p225i.p414e.p418n.C4963b;
import p007b.p225i.p414e.p424p.p425b.C4984a;
import p007b.p225i.p414e.p424p.p425b.C4985b;
import p007b.p225i.p414e.p424p.p425b.C4986c;

/* JADX INFO: renamed from: b.i.e.p.a */
/* JADX INFO: compiled from: MaxiCodeReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4983a implements InterfaceC4954i {

    /* JADX INFO: renamed from: a */
    public static final C4956k[] f13347a = new C4956k[0];

    /* JADX INFO: renamed from: b */
    public final C4986c f13348b = new C4986c();

    @Override // p007b.p225i.p414e.InterfaceC4954i
    /* JADX INFO: renamed from: a */
    public Result mo6919a(C4948c c4948c, Map<EnumC4949d, ?> map) throws NotFoundException, ChecksumException, FormatException {
        byte[] bArr;
        String strValueOf;
        if (map == null || !map.containsKey(EnumC4949d.PURE_BARCODE)) {
            throw NotFoundException.f21665l;
        }
        C4963b c4963bM6913a = c4948c.m6913a();
        int i = c4963bM6913a.f13229j;
        int i2 = c4963bM6913a.f13230k;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < c4963bM6913a.f13230k; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = c4963bM6913a.f13231l;
                if (i6 < i7) {
                    int i8 = c4963bM6913a.f13232m[(i7 * i5) + i6];
                    if (i8 != 0) {
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        if (i5 > i4) {
                            i4 = i5;
                        }
                        int i9 = i6 << 5;
                        if (i9 < i) {
                            int i10 = 0;
                            while ((i8 << (31 - i10)) == 0) {
                                i10++;
                            }
                            int i11 = i10 + i9;
                            if (i11 < i) {
                                i = i11;
                            }
                        }
                        if (i9 + 31 > i3) {
                            int i12 = 31;
                            while ((i8 >>> i12) == 0) {
                                i12--;
                            }
                            int i13 = i9 + i12;
                            if (i13 > i3) {
                                i3 = i13;
                            }
                        }
                    }
                    i6++;
                }
            }
        }
        int[] iArr = (i3 < i || i4 < i2) ? null : new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
        if (iArr == null) {
            throw NotFoundException.f21665l;
        }
        int i14 = iArr[0];
        int i15 = iArr[1];
        int i16 = iArr[2];
        int i17 = iArr[3];
        int i18 = (30 + 31) / 32;
        int[] iArr2 = new int[i18 * 33];
        for (int i19 = 0; i19 < 33; i19++) {
            int i20 = (((i17 / 2) + (i19 * i17)) / 33) + i15;
            for (int i21 = 0; i21 < 30; i21++) {
                if (c4963bM6913a.m6942f((((((i19 & 1) * i16) / 2) + ((i16 / 2) + (i21 * i16))) / 30) + i14, i20)) {
                    int i22 = (i21 / 32) + (i19 * i18);
                    iArr2[i22] = (1 << (i21 & 31)) | iArr2[i22];
                }
            }
        }
        C4986c c4986c = this.f13348b;
        Objects.requireNonNull(c4986c);
        byte[] bArr2 = new byte[Opcodes.D2F];
        for (int i23 = 0; i23 < 33; i23++) {
            int[] iArr3 = C4984a.f13349a[i23];
            for (int i24 = 0; i24 < 30; i24++) {
                int i25 = iArr3[i24];
                if (i25 >= 0) {
                    if (((iArr2[(i24 / 32) + (i23 * i18)] >>> (i24 & 31)) & 1) != 0) {
                        int i26 = i25 / 6;
                        bArr2[i26] = (byte) (((byte) (1 << (5 - (i25 % 6)))) | bArr2[i26]);
                    }
                }
            }
        }
        c4986c.m6981a(bArr2, 0, 10, 10, 0);
        int i27 = bArr2[0] & 15;
        if (i27 == 2 || i27 == 3 || i27 == 4) {
            c4986c.m6981a(bArr2, 20, 84, 40, 1);
            c4986c.m6981a(bArr2, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i27 != 5) {
                throw FormatException.m9260a();
            }
            c4986c.m6981a(bArr2, 20, 68, 56, 1);
            c4986c.m6981a(bArr2, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArr2, 0, bArr, 0, 10);
        System.arraycopy(bArr2, 20, bArr, 10, bArr.length - 10);
        StringBuilder sb = new StringBuilder(Opcodes.D2F);
        if (i27 == 2 || i27 == 3) {
            if (i27 == 2) {
                strValueOf = new DecimalFormat("0000000000".substring(0, C4985b.m6979a(bArr, new byte[]{39, 40, 41, ExifInterface.START_CODE, 31, 32}))).format(C4985b.m6979a(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2}));
            } else {
                String[] strArr = C4985b.f13350a;
                strValueOf = String.valueOf(new char[]{strArr[0].charAt(C4985b.m6979a(bArr, new byte[]{39, 40, 41, ExifInterface.START_CODE, 31, 32})), strArr[0].charAt(C4985b.m6979a(bArr, new byte[]{33, 34, 35, 36, 25, 26})), strArr[0].charAt(C4985b.m6979a(bArr, new byte[]{27, 28, 29, 30, 19, 20})), strArr[0].charAt(C4985b.m6979a(bArr, new byte[]{21, 22, 23, 24, 13, 14})), strArr[0].charAt(C4985b.m6979a(bArr, new byte[]{15, 16, 17, 18, 7, 8})), strArr[0].charAt(C4985b.m6979a(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String str = decimalFormat.format(C4985b.m6979a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38}));
            String str2 = decimalFormat.format(C4985b.m6979a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52}));
            sb.append(C4985b.m6980b(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, strValueOf + (char) 29 + str + (char) 29 + str2 + (char) 29);
            } else {
                sb.insert(0, strValueOf + (char) 29 + str + (char) 29 + str2 + (char) 29);
            }
        } else if (i27 == 4) {
            sb.append(C4985b.m6980b(bArr, 1, 93));
        } else if (i27 == 5) {
            sb.append(C4985b.m6980b(bArr, 1, 77));
        }
        String string = sb.toString();
        String strValueOf2 = String.valueOf(i27);
        Result result = new Result(string, bArr, f13347a, EnumC4946a.MAXICODE);
        if (strValueOf2 != null) {
            result.m9262b(EnumC4955j.ERROR_CORRECTION_LEVEL, strValueOf2);
        }
        return result;
    }

    @Override // p007b.p225i.p414e.InterfaceC4954i
    public void reset() {
    }
}
