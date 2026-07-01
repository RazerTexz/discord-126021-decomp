package b.i.a.c.x2.j0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.VorbisBitArray;
import b.i.a.c.x2.VorbisUtil;
import b.i.a.c.x2.VorbisUtil2;
import b.i.a.c.x2.VorbisUtil3;
import b.i.a.c.x2.j0.StreamReader;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.j, reason: use source file name */
/* JADX INFO: compiled from: VorbisReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class VorbisReader extends StreamReader {

    @Nullable
    public a n;
    public int o;
    public boolean p;

    @Nullable
    public VorbisUtil2 q;

    @Nullable
    public VorbisUtil3 r;

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.j$a */
    /* JADX INFO: compiled from: VorbisReader.java */
    public static final class a {
        public final VorbisUtil2 a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f1241b;
        public final VorbisUtil[] c;
        public final int d;

        public a(VorbisUtil2 vorbisUtil2, VorbisUtil3 vorbisUtil3, byte[] bArr, VorbisUtil[] vorbisUtilArr, int i) {
            this.a = vorbisUtil2;
            this.f1241b = bArr;
            this.c = vorbisUtilArr;
            this.d = i;
        }
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public void b(long j) {
        this.g = j;
        this.p = j != 0;
        VorbisUtil2 vorbisUtil2 = this.q;
        this.o = vorbisUtil2 != null ? vorbisUtil2.e : 0;
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public long c(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.a;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        byte b2 = bArr[0];
        a aVar = this.n;
        AnimatableValueParser.H(aVar);
        a aVar2 = aVar;
        int i = !aVar2.c[(b2 >> 1) & (255 >>> (8 - aVar2.d))].a ? aVar2.a.e : aVar2.a.f;
        long j = this.p ? (this.o + i) / 4 : 0;
        byte[] bArr2 = parsableByteArray.a;
        int length = bArr2.length;
        int i2 = parsableByteArray.c + 4;
        if (length < i2) {
            parsableByteArray.B(Arrays.copyOf(bArr2, i2));
        } else {
            parsableByteArray.D(i2);
        }
        byte[] bArr3 = parsableByteArray.a;
        int i3 = parsableByteArray.c;
        bArr3[i3 - 4] = (byte) (j & 255);
        bArr3[i3 - 3] = (byte) ((j >>> 8) & 255);
        bArr3[i3 - 2] = (byte) ((j >>> 16) & 255);
        bArr3[i3 - 1] = (byte) ((j >>> 24) & 255);
        this.p = true;
        this.o = i;
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:169:0x03b9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:171:0x03bb  */
    @Override // b.i.a.c.x2.j0.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(ParsableByteArray parsableByteArray, long j, StreamReader.b bVar) throws IOException {
        a aVar;
        int i;
        int iB;
        int i2;
        int i3;
        if (this.n != null) {
            Objects.requireNonNull(bVar.a);
            return false;
        }
        VorbisUtil2 vorbisUtil2 = this.q;
        if (vorbisUtil2 != null) {
            VorbisUtil3 vorbisUtil3 = this.r;
            if (vorbisUtil3 == null) {
                this.r = AnimatableValueParser.N1(parsableByteArray, true, true);
            } else {
                int i4 = parsableByteArray.c;
                byte[] bArr = new byte[i4];
                System.arraycopy(parsableByteArray.a, 0, bArr, 0, i4);
                int i5 = vorbisUtil2.a;
                int i6 = 5;
                AnimatableValueParser.n2(5, parsableByteArray, false);
                int iT = parsableByteArray.t() + 1;
                VorbisBitArray vorbisBitArray = new VorbisBitArray(parsableByteArray.a);
                vorbisBitArray.c(parsableByteArray.f984b * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 16;
                    if (i7 >= iT) {
                        VorbisUtil3 vorbisUtil4 = vorbisUtil3;
                        byte[] bArr2 = bArr;
                        int i9 = 6;
                        int iB2 = vorbisBitArray.b(6) + 1;
                        for (int i10 = 0; i10 < iB2; i10++) {
                            if (vorbisBitArray.b(16) != 0) {
                                throw ParserException.a("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i11 = 1;
                        int iB3 = vorbisBitArray.b(6) + 1;
                        int i12 = 0;
                        while (true) {
                            int i13 = 3;
                            if (i12 >= iB3) {
                                int i14 = 1;
                                int iB4 = vorbisBitArray.b(i9) + 1;
                                int i15 = 0;
                                while (i15 < iB4) {
                                    if (vorbisBitArray.b(16) > 2) {
                                        throw ParserException.a("residueType greater than 2 is not decodable", null);
                                    }
                                    vorbisBitArray.c(24);
                                    vorbisBitArray.c(24);
                                    vorbisBitArray.c(24);
                                    int iB5 = vorbisBitArray.b(i9) + i14;
                                    int i16 = 8;
                                    vorbisBitArray.c(8);
                                    int[] iArr = new int[iB5];
                                    for (int i17 = 0; i17 < iB5; i17++) {
                                        iArr[i17] = ((vorbisBitArray.a() ? vorbisBitArray.b(5) : 0) * 8) + vorbisBitArray.b(3);
                                    }
                                    int i18 = 0;
                                    while (i18 < iB5) {
                                        int i19 = 0;
                                        while (i19 < i16) {
                                            if ((iArr[i18] & (1 << i19)) != 0) {
                                                vorbisBitArray.c(i16);
                                            }
                                            i19++;
                                            i16 = 8;
                                        }
                                        i18++;
                                        i16 = 8;
                                    }
                                    i15++;
                                    i9 = 6;
                                    i14 = 1;
                                }
                                int iB6 = vorbisBitArray.b(i9) + 1;
                                for (int i20 = 0; i20 < iB6; i20++) {
                                    int iB7 = vorbisBitArray.b(16);
                                    if (iB7 != 0) {
                                        StringBuilder sb = new StringBuilder(52);
                                        sb.append("mapping type other than 0 not supported: ");
                                        sb.append(iB7);
                                        Log.e("VorbisUtil", sb.toString());
                                    } else {
                                        if (vorbisBitArray.a()) {
                                            i = 1;
                                            iB = vorbisBitArray.b(4) + 1;
                                        } else {
                                            i = 1;
                                            iB = 1;
                                        }
                                        if (vorbisBitArray.a()) {
                                            int iB8 = vorbisBitArray.b(8) + i;
                                            for (int i21 = 0; i21 < iB8; i21++) {
                                                int i22 = i5 - 1;
                                                vorbisBitArray.c(AnimatableValueParser.M0(i22));
                                                vorbisBitArray.c(AnimatableValueParser.M0(i22));
                                            }
                                        }
                                        if (vorbisBitArray.b(2) != 0) {
                                            throw ParserException.a("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iB > 1) {
                                            for (int i23 = 0; i23 < i5; i23++) {
                                                vorbisBitArray.c(4);
                                            }
                                        }
                                        for (int i24 = 0; i24 < iB; i24++) {
                                            vorbisBitArray.c(8);
                                            vorbisBitArray.c(8);
                                            vorbisBitArray.c(8);
                                        }
                                    }
                                }
                                int iB9 = vorbisBitArray.b(6) + 1;
                                VorbisUtil[] vorbisUtilArr = new VorbisUtil[iB9];
                                for (int i25 = 0; i25 < iB9; i25++) {
                                    vorbisUtilArr[i25] = new VorbisUtil(vorbisBitArray.a(), vorbisBitArray.b(16), vorbisBitArray.b(16), vorbisBitArray.b(8));
                                }
                                if (!vorbisBitArray.a()) {
                                    throw ParserException.a("framing bit after modes not set as expected", null);
                                }
                                aVar = new a(vorbisUtil2, vorbisUtil4, bArr2, vorbisUtilArr, AnimatableValueParser.M0(iB9 - 1));
                                break;
                            }
                            int iB10 = vorbisBitArray.b(i8);
                            if (iB10 == 0) {
                                i2 = iB3;
                                int i26 = 8;
                                vorbisBitArray.c(8);
                                vorbisBitArray.c(16);
                                vorbisBitArray.c(16);
                                vorbisBitArray.c(6);
                                vorbisBitArray.c(8);
                                int iB11 = vorbisBitArray.b(4) + 1;
                                int i27 = 0;
                                while (i27 < iB11) {
                                    vorbisBitArray.c(i26);
                                    i27++;
                                    i26 = 8;
                                }
                            } else {
                                if (iB10 != i11) {
                                    throw outline.w0(52, "floor type greater than 1 not decodable: ", iB10, null);
                                }
                                int iB12 = vorbisBitArray.b(5);
                                int[] iArr2 = new int[iB12];
                                int i28 = -1;
                                for (int i29 = 0; i29 < iB12; i29++) {
                                    iArr2[i29] = vorbisBitArray.b(4);
                                    if (iArr2[i29] > i28) {
                                        i28 = iArr2[i29];
                                    }
                                }
                                int i30 = i28 + 1;
                                int[] iArr3 = new int[i30];
                                int i31 = 0;
                                while (i31 < i30) {
                                    iArr3[i31] = vorbisBitArray.b(i13) + 1;
                                    int iB13 = vorbisBitArray.b(2);
                                    int i32 = 8;
                                    if (iB13 > 0) {
                                        vorbisBitArray.c(8);
                                    }
                                    int i33 = iB3;
                                    int i34 = 0;
                                    for (int i35 = 1; i34 < (i35 << iB13); i35 = 1) {
                                        vorbisBitArray.c(i32);
                                        i34++;
                                        i32 = 8;
                                    }
                                    i31++;
                                    i13 = 3;
                                    iB3 = i33;
                                }
                                i2 = iB3;
                                vorbisBitArray.c(2);
                                int iB14 = vorbisBitArray.b(4);
                                int i36 = 0;
                                int i37 = 0;
                                for (int i38 = 0; i38 < iB12; i38++) {
                                    i36 += iArr3[iArr2[i38]];
                                    while (i37 < i36) {
                                        vorbisBitArray.c(iB14);
                                        i37++;
                                    }
                                }
                            }
                            i12++;
                            i9 = 6;
                            i11 = 1;
                            i8 = 16;
                            iB3 = i2;
                        }
                    } else {
                        if (vorbisBitArray.b(24) != 5653314) {
                            throw outline.w0(66, "expected code book to start with [0x56, 0x43, 0x42] at ", (vorbisBitArray.c * 8) + vorbisBitArray.d, null);
                        }
                        int iB15 = vorbisBitArray.b(16);
                        int iB16 = vorbisBitArray.b(24);
                        long[] jArr = new long[iB16];
                        if (vorbisBitArray.a()) {
                            i3 = iT;
                            int iB17 = vorbisBitArray.b(5) + 1;
                            int i39 = 0;
                            while (i39 < iB16) {
                                int iB18 = vorbisBitArray.b(AnimatableValueParser.M0(iB16 - i39));
                                int i40 = 0;
                                while (i40 < iB18 && i39 < iB16) {
                                    jArr[i39] = iB17;
                                    i39++;
                                    i40++;
                                    vorbisUtil3 = vorbisUtil3;
                                    bArr = bArr;
                                }
                                iB17++;
                                vorbisUtil3 = vorbisUtil3;
                                bArr = bArr;
                            }
                        } else {
                            boolean zA = vorbisBitArray.a();
                            int i41 = 0;
                            while (i41 < iB16) {
                                if (!zA) {
                                    jArr[i41] = vorbisBitArray.b(5) + 1;
                                } else if (vorbisBitArray.a()) {
                                    jArr[i41] = vorbisBitArray.b(i6) + 1;
                                } else {
                                    jArr[i41] = 0;
                                }
                                i41++;
                                i6 = 5;
                                iT = iT;
                            }
                            i3 = iT;
                        }
                        VorbisUtil3 vorbisUtil5 = vorbisUtil3;
                        byte[] bArr3 = bArr;
                        int iB19 = vorbisBitArray.b(4);
                        if (iB19 > 2) {
                            throw outline.w0(53, "lookup type greater than 2 not decodable: ", iB19, null);
                        }
                        if (iB19 == 1 || iB19 == 2) {
                            vorbisBitArray.c(32);
                            vorbisBitArray.c(32);
                            int iB20 = vorbisBitArray.b(4) + 1;
                            vorbisBitArray.c(1);
                            vorbisBitArray.c((int) (((long) iB20) * (iB19 == 1 ? iB15 != 0 ? (long) Math.floor(Math.pow(iB16, 1.0d / ((double) iB15))) : 0L : ((long) iB16) * ((long) iB15))));
                        }
                        i7++;
                        i6 = 5;
                        iT = i3;
                        vorbisUtil3 = vorbisUtil5;
                        bArr = bArr3;
                    }
                }
            }
            this.n = aVar;
            if (aVar == null) {
                return true;
            }
            VorbisUtil2 vorbisUtil6 = aVar.a;
            ArrayList arrayList = new ArrayList();
            arrayList.add(vorbisUtil6.g);
            arrayList.add(aVar.f1241b);
            Format2.b bVar2 = new Format2.b();
            bVar2.k = "audio/vorbis";
            bVar2.f = vorbisUtil6.d;
            bVar2.g = vorbisUtil6.c;
            bVar2.f1023x = vorbisUtil6.a;
            bVar2.f1024y = vorbisUtil6.f1163b;
            bVar2.m = arrayList;
            bVar.a = bVar2.a();
            return true;
        }
        AnimatableValueParser.n2(1, parsableByteArray, false);
        int iK = parsableByteArray.k();
        int iT2 = parsableByteArray.t();
        int iK2 = parsableByteArray.k();
        int iH = parsableByteArray.h();
        int i42 = iH <= 0 ? -1 : iH;
        int iH2 = parsableByteArray.h();
        int i43 = iH2 <= 0 ? -1 : iH2;
        int iH3 = parsableByteArray.h();
        int i44 = iH3 <= 0 ? -1 : iH3;
        int iT3 = parsableByteArray.t();
        this.q = new VorbisUtil2(iK, iT2, iK2, i42, i43, i44, (int) Math.pow(2.0d, iT3 & 15), (int) Math.pow(2.0d, (iT3 & 240) >> 4), (parsableByteArray.t() & 1) > 0, Arrays.copyOf(parsableByteArray.a, parsableByteArray.c));
        aVar = null;
        this.n = aVar;
        if (aVar == null) {
            return true;
        }
        VorbisUtil2 vorbisUtil7 = aVar.a;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(vorbisUtil7.g);
        arrayList2.add(aVar.f1241b);
        Format2.b bVar3 = new Format2.b();
        bVar3.k = "audio/vorbis";
        bVar3.f = vorbisUtil7.d;
        bVar3.g = vorbisUtil7.c;
        bVar3.f1023x = vorbisUtil7.a;
        bVar3.f1024y = vorbisUtil7.f1163b;
        bVar3.m = arrayList2;
        bVar.a = bVar3.a();
        return true;
    }

    @Override // b.i.a.c.x2.j0.StreamReader
    public void e(boolean z2) {
        super.e(z2);
        if (z2) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }
}
