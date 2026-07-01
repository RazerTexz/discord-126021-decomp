package b.i.e.s.b;

import b.i.e.DecodeHintType;
import b.i.e.n.BitMatrix;
import b.i.e.n.BitSource;
import b.i.e.n.CharacterSetECI;
import b.i.e.n.DecoderResult;
import b.i.e.n.l.GenericGF;
import b.i.e.n.l.ReedSolomonDecoder;
import b.i.e.s.b.Version3;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.ArrayList;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.e.s.b.e, reason: use source file name */
/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Decoder5 {
    public final ReedSolomonDecoder a = new ReedSolomonDecoder(GenericGF.e);

    public DecoderResult a(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        ChecksumException checksumException;
        BitMatrixParser3 bitMatrixParser3 = new BitMatrixParser3(bitMatrix);
        try {
            return b(bitMatrixParser3, map);
        } catch (ChecksumException e) {
            checksumException = e;
            e = null;
            try {
                bitMatrixParser3.e();
                bitMatrixParser3.f1886b = null;
                bitMatrixParser3.c = null;
                bitMatrixParser3.d = true;
                bitMatrixParser3.d();
                bitMatrixParser3.c();
                bitMatrixParser3.b();
                DecoderResult decoderResultB = b(bitMatrixParser3, map);
                decoderResultB.f = new QRCodeDecoderMetaData(true);
                return decoderResultB;
            } catch (ChecksumException | FormatException unused) {
                if (e != null) {
                    throw e;
                }
                throw checksumException;
            }
        } catch (FormatException e2) {
            e = e2;
            checksumException = null;
            bitMatrixParser3.e();
            bitMatrixParser3.f1886b = null;
            bitMatrixParser3.c = null;
            bitMatrixParser3.d = true;
            bitMatrixParser3.d();
            bitMatrixParser3.c();
            bitMatrixParser3.b();
            DecoderResult decoderResultB2 = b(bitMatrixParser3, map);
            decoderResultB2.f = new QRCodeDecoderMetaData(true);
            return decoderResultB2;
        }
    }

    public final DecoderResult b(BitMatrixParser3 bitMatrixParser3, Map<DecodeHintType, ?> map) throws ChecksumException, FormatException {
        int iB;
        Mode2 mode2;
        int i;
        int i2;
        int iB2;
        BitMatrix bitMatrix;
        Version3 version3D = bitMatrixParser3.d();
        ErrorCorrectionLevel errorCorrectionLevel = bitMatrixParser3.c().f1888b;
        FormatInformation formatInformationC = bitMatrixParser3.c();
        Version3 version3D2 = bitMatrixParser3.d();
        DataMask dataMask = DataMask.values()[formatInformationC.c];
        BitMatrix bitMatrix2 = bitMatrixParser3.a;
        int i3 = bitMatrix2.k;
        dataMask.g(bitMatrix2, i3);
        int iC = version3D2.c();
        BitMatrix bitMatrix3 = new BitMatrix(iC, iC);
        int i4 = 0;
        bitMatrix3.k(0, 0, 9, 9);
        int i5 = iC - 8;
        bitMatrix3.k(i5, 0, 8, 9);
        bitMatrix3.k(0, i5, 9, 8);
        int length = version3D2.d.length;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = version3D2.d[i6] - 2;
            for (int i8 = 0; i8 < length; i8++) {
                if ((i6 != 0 || (i8 != 0 && i8 != length - 1)) && (i6 != length - 1 || i8 != 0)) {
                    bitMatrix3.k(version3D2.d[i8] - 2, i7, 5, 5);
                }
            }
        }
        int i9 = iC - 17;
        int i10 = 6;
        bitMatrix3.k(6, 9, 1, i9);
        bitMatrix3.k(9, 6, i9, 1);
        if (version3D2.c > 6) {
            int i11 = iC - 11;
            bitMatrix3.k(i11, 0, 3, 6);
            bitMatrix3.k(0, i11, 6, 3);
        }
        int i12 = version3D2.f;
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
                    if (bitMatrix3.f(i21, i20)) {
                        bitMatrix = bitMatrix3;
                    } else {
                        int i22 = i16 + 1;
                        int i23 = i17 << 1;
                        bitMatrix = bitMatrix3;
                        int i24 = bitMatrixParser3.a.f(i21, i20) ? i23 | 1 : i23;
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
                    bitMatrix3 = bitMatrix;
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
        if (i15 != version3D2.f) {
            throw FormatException.a();
        }
        if (i12 != version3D.f) {
            throw new IllegalArgumentException();
        }
        Version3.b bVar = version3D.e[errorCorrectionLevel.ordinal()];
        Version3.a[] aVarArr = bVar.f1892b;
        int i25 = 0;
        for (Version3.a aVar : aVarArr) {
            i25 += aVar.a;
        }
        DataBlock2[] dataBlock2Arr = new DataBlock2[i25];
        int i26 = 0;
        for (Version3.a aVar2 : aVarArr) {
            int i27 = 0;
            while (i27 < aVar2.a) {
                int i28 = aVar2.f1891b;
                dataBlock2Arr[i26] = new DataBlock2(i28, new byte[bVar.a + i28]);
                i27++;
                i26++;
            }
        }
        int length2 = dataBlock2Arr[0].f1887b.length;
        int i29 = i25 - 1;
        while (i29 >= 0 && dataBlock2Arr[i29].f1887b.length != length2) {
            i29--;
        }
        int i30 = i29 + 1;
        int i31 = length2 - bVar.a;
        int i32 = 0;
        for (int i33 = 0; i33 < i31; i33++) {
            int i34 = 0;
            while (i34 < i26) {
                dataBlock2Arr[i34].f1887b[i33] = bArr[i32];
                i34++;
                i32++;
            }
        }
        int i35 = i30;
        while (i35 < i26) {
            dataBlock2Arr[i35].f1887b[i31] = bArr[i32];
            i35++;
            i32++;
        }
        boolean z3 = false;
        int length3 = dataBlock2Arr[0].f1887b.length;
        while (i31 < length3) {
            int i36 = 0;
            while (i36 < i26) {
                dataBlock2Arr[i36].f1887b[i36 < i30 ? i31 : i31 + 1] = bArr[i32];
                i36++;
                i32++;
            }
            i31++;
        }
        int i37 = 0;
        for (int i38 = 0; i38 < i25; i38++) {
            i37 += dataBlock2Arr[i38].a;
        }
        byte[] bArr2 = new byte[i37];
        int i39 = 0;
        for (int i40 = 0; i40 < i25; i40++) {
            DataBlock2 dataBlock2 = dataBlock2Arr[i40];
            byte[] bArr3 = dataBlock2.f1887b;
            int i41 = dataBlock2.a;
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
        char[] cArr = DecodedBitStreamParser4.a;
        Mode2 mode3 = Mode2.TERMINATOR;
        BitSource bitSource = new BitSource(bArr2);
        StringBuilder sb = new StringBuilder(50);
        ArrayList arrayList = new ArrayList(1);
        int iB3 = -1;
        int iB4 = -1;
        CharacterSetECI characterSetECIF = null;
        while (true) {
            try {
                if (bitSource.a() < 4 || (iB = bitSource.b(4)) == 0) {
                    mode2 = mode3;
                } else if (iB == 1) {
                    mode2 = Mode2.NUMERIC;
                } else if (iB == 2) {
                    mode2 = Mode2.ALPHANUMERIC;
                } else if (iB == 3) {
                    mode2 = Mode2.STRUCTURED_APPEND;
                } else if (iB == 4) {
                    mode2 = Mode2.BYTE;
                } else if (iB == 5) {
                    mode2 = Mode2.FNC1_FIRST_POSITION;
                } else if (iB == 7) {
                    mode2 = Mode2.ECI;
                } else if (iB == 8) {
                    mode2 = Mode2.KANJI;
                } else if (iB == 9) {
                    mode2 = Mode2.FNC1_SECOND_POSITION;
                } else {
                    if (iB != 13) {
                        throw new IllegalArgumentException();
                    }
                    mode2 = Mode2.HANZI;
                }
                int iOrdinal = mode2.ordinal();
                if (iOrdinal == 0) {
                    i2 = iB3;
                    i = iB4;
                } else {
                    if (iOrdinal != 3) {
                        if (iOrdinal == 5) {
                            int iB5 = bitSource.b(8);
                            if ((iB5 & 128) == 0) {
                                iB2 = iB5 & Opcodes.LAND;
                            } else if ((iB5 & Opcodes.CHECKCAST) == 128) {
                                iB2 = ((iB5 & 63) << 8) | bitSource.b(8);
                            } else {
                                if ((iB5 & 224) != 192) {
                                    throw FormatException.a();
                                }
                                iB2 = ((iB5 & 31) << 16) | bitSource.b(16);
                            }
                            characterSetECIF = CharacterSetECI.f(iB2);
                            if (characterSetECIF == null) {
                                throw FormatException.a();
                            }
                        } else if (iOrdinal == 7 || iOrdinal == 8) {
                            z3 = true;
                        } else if (iOrdinal != 9) {
                            int iB6 = bitSource.b(mode2.f(version3D));
                            int iOrdinal2 = mode2.ordinal();
                            if (iOrdinal2 == 1) {
                                DecodedBitStreamParser4.e(bitSource, sb, iB6);
                            } else if (iOrdinal2 == 2) {
                                DecodedBitStreamParser4.a(bitSource, sb, iB6, z3);
                            } else if (iOrdinal2 == 4) {
                                DecodedBitStreamParser4.b(bitSource, sb, iB6, characterSetECIF, arrayList, map);
                            } else {
                                if (iOrdinal2 != 6) {
                                    throw FormatException.a();
                                }
                                DecodedBitStreamParser4.d(bitSource, sb, iB6);
                            }
                        } else {
                            int iB7 = bitSource.b(4);
                            int iB8 = bitSource.b(mode2.f(version3D));
                            if (iB7 == 1) {
                                DecodedBitStreamParser4.c(bitSource, sb, iB8);
                            }
                        }
                        i2 = iB3;
                        i = iB4;
                    } else {
                        if (bitSource.a() < 16) {
                            throw FormatException.a();
                        }
                        iB3 = bitSource.b(8);
                        iB4 = bitSource.b(8);
                    }
                    i2 = iB3;
                    i = iB4;
                }
                if (mode2 == mode3) {
                    return new DecoderResult(bArr2, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel.toString(), i2, i);
                }
                iB3 = i2;
                iB4 = i;
            } catch (IllegalArgumentException unused2) {
                throw FormatException.a();
            }
        }
    }
}
