package b.i.e.p;

import androidx.exifinterface.media.ExifInterface;
import b.i.e.BarcodeFormat;
import b.i.e.BinaryBitmap;
import b.i.e.DecodeHintType;
import b.i.e.Reader;
import b.i.e.ResultMetadataType;
import b.i.e.ResultPoint;
import b.i.e.n.BitMatrix;
import b.i.e.p.b.BitMatrixParser2;
import b.i.e.p.b.DecodedBitStreamParser2;
import b.i.e.p.b.Decoder4;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Objects;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.p.a, reason: use source file name */
/* JADX INFO: compiled from: MaxiCodeReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MaxiCodeReader implements Reader {
    public static final ResultPoint[] a = new ResultPoint[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Decoder4 f1852b = new Decoder4();

    @Override // b.i.e.Reader
    public Result a(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        byte[] bArr;
        String strValueOf;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            throw NotFoundException.l;
        }
        BitMatrix bitMatrixA = binaryBitmap.a();
        int i = bitMatrixA.j;
        int i2 = bitMatrixA.k;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < bitMatrixA.k; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = bitMatrixA.l;
                if (i6 < i7) {
                    int i8 = bitMatrixA.m[(i7 * i5) + i6];
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
            throw NotFoundException.l;
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
                if (bitMatrixA.f((((((i19 & 1) * i16) / 2) + ((i16 / 2) + (i21 * i16))) / 30) + i14, i20)) {
                    int i22 = (i21 / 32) + (i19 * i18);
                    iArr2[i22] = (1 << (i21 & 31)) | iArr2[i22];
                }
            }
        }
        Decoder4 decoder4 = this.f1852b;
        Objects.requireNonNull(decoder4);
        byte[] bArr2 = new byte[Opcodes.D2F];
        for (int i23 = 0; i23 < 33; i23++) {
            int[] iArr3 = BitMatrixParser2.a[i23];
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
        decoder4.a(bArr2, 0, 10, 10, 0);
        int i27 = bArr2[0] & 15;
        if (i27 == 2 || i27 == 3 || i27 == 4) {
            decoder4.a(bArr2, 20, 84, 40, 1);
            decoder4.a(bArr2, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i27 != 5) {
                throw FormatException.a();
            }
            decoder4.a(bArr2, 20, 68, 56, 1);
            decoder4.a(bArr2, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(bArr2, 0, bArr, 0, 10);
        System.arraycopy(bArr2, 20, bArr, 10, bArr.length - 10);
        StringBuilder sb = new StringBuilder(Opcodes.D2F);
        if (i27 == 2 || i27 == 3) {
            if (i27 == 2) {
                strValueOf = new DecimalFormat("0000000000".substring(0, DecodedBitStreamParser2.a(bArr, new byte[]{39, 40, 41, ExifInterface.START_CODE, 31, 32}))).format(DecodedBitStreamParser2.a(bArr, new byte[]{33, 34, 35, 36, 25, 26, 27, 28, 29, 30, 19, 20, 21, 22, 23, 24, 13, 14, 15, 16, 17, 18, 7, 8, 9, 10, 11, 12, 1, 2}));
            } else {
                String[] strArr = DecodedBitStreamParser2.a;
                strValueOf = String.valueOf(new char[]{strArr[0].charAt(DecodedBitStreamParser2.a(bArr, new byte[]{39, 40, 41, ExifInterface.START_CODE, 31, 32})), strArr[0].charAt(DecodedBitStreamParser2.a(bArr, new byte[]{33, 34, 35, 36, 25, 26})), strArr[0].charAt(DecodedBitStreamParser2.a(bArr, new byte[]{27, 28, 29, 30, 19, 20})), strArr[0].charAt(DecodedBitStreamParser2.a(bArr, new byte[]{21, 22, 23, 24, 13, 14})), strArr[0].charAt(DecodedBitStreamParser2.a(bArr, new byte[]{15, 16, 17, 18, 7, 8})), strArr[0].charAt(DecodedBitStreamParser2.a(bArr, new byte[]{9, 10, 11, 12, 1, 2}))});
            }
            DecimalFormat decimalFormat = new DecimalFormat("000");
            String str = decimalFormat.format(DecodedBitStreamParser2.a(bArr, new byte[]{53, 54, 43, 44, 45, 46, 47, 48, 37, 38}));
            String str2 = decimalFormat.format(DecodedBitStreamParser2.a(bArr, new byte[]{55, 56, 57, 58, 59, 60, 49, 50, 51, 52}));
            sb.append(DecodedBitStreamParser2.b(bArr, 10, 84));
            if (sb.toString().startsWith("[)>\u001e01\u001d")) {
                sb.insert(9, strValueOf + (char) 29 + str + (char) 29 + str2 + (char) 29);
            } else {
                sb.insert(0, strValueOf + (char) 29 + str + (char) 29 + str2 + (char) 29);
            }
        } else if (i27 == 4) {
            sb.append(DecodedBitStreamParser2.b(bArr, 1, 93));
        } else if (i27 == 5) {
            sb.append(DecodedBitStreamParser2.b(bArr, 1, 77));
        }
        String string = sb.toString();
        String strValueOf2 = String.valueOf(i27);
        Result result = new Result(string, bArr, a, BarcodeFormat.MAXICODE);
        if (strValueOf2 != null) {
            result.b(ResultMetadataType.ERROR_CORRECTION_LEVEL, strValueOf2);
        }
        return result;
    }

    @Override // b.i.e.Reader
    public void reset() {
    }
}
