package b.i.a.c.x2.j0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.f3.x;
import b.i.a.c.j1$b;
import b.i.a.c.x2.a0;
import b.i.a.c.x2.b0;
import b.i.a.c.x2.y;
import b.i.a.c.x2.z;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: compiled from: VorbisReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends i {

    @Nullable
    public j$a n;
    public int o;
    public boolean p;

    @Nullable
    public b0 q;

    @Nullable
    public z r;

    @Override // b.i.a.c.x2.j0.i
    public void b(long j) {
        this.g = j;
        this.p = j != 0;
        b0 b0Var = this.q;
        this.o = b0Var != null ? b0Var.e : 0;
    }

    @Override // b.i.a.c.x2.j0.i
    public long c(x xVar) {
        byte[] bArr = xVar.a;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        byte b2 = bArr[0];
        j$a j_a = this.n;
        b.c.a.a0.d.H(j_a);
        j$a j_a2 = j_a;
        int i = !j_a2.c[(b2 >> 1) & (255 >>> (8 - j_a2.d))].a ? j_a2.a.e : j_a2.a.f;
        long j = this.p ? (this.o + i) / 4 : 0;
        byte[] bArr2 = xVar.a;
        int length = bArr2.length;
        int i2 = xVar.c + 4;
        if (length < i2) {
            xVar.B(Arrays.copyOf(bArr2, i2));
        } else {
            xVar.D(i2);
        }
        byte[] bArr3 = xVar.a;
        int i3 = xVar.c;
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
    @Override // b.i.a.c.x2.j0.i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean d(x xVar, long j, i$b i_b) throws IOException {
        j$a j_a;
        int i;
        int iB;
        int i2;
        int i3;
        if (this.n != null) {
            Objects.requireNonNull(i_b.a);
            return false;
        }
        b0 b0Var = this.q;
        if (b0Var != null) {
            z zVar = this.r;
            if (zVar == null) {
                this.r = b.c.a.a0.d.N1(xVar, true, true);
            } else {
                int i4 = xVar.c;
                byte[] bArr = new byte[i4];
                System.arraycopy(xVar.a, 0, bArr, 0, i4);
                int i5 = b0Var.a;
                int i6 = 5;
                b.c.a.a0.d.n2(5, xVar, false);
                int iT = xVar.t() + 1;
                y yVar = new y(xVar.a);
                yVar.c(xVar.f984b * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 16;
                    if (i7 >= iT) {
                        z zVar2 = zVar;
                        byte[] bArr2 = bArr;
                        int i9 = 6;
                        int iB2 = yVar.b(6) + 1;
                        for (int i10 = 0; i10 < iB2; i10++) {
                            if (yVar.b(16) != 0) {
                                throw ParserException.a("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i11 = 1;
                        int iB3 = yVar.b(6) + 1;
                        int i12 = 0;
                        while (true) {
                            int i13 = 3;
                            if (i12 >= iB3) {
                                int i14 = 1;
                                int iB4 = yVar.b(i9) + 1;
                                int i15 = 0;
                                while (i15 < iB4) {
                                    if (yVar.b(16) > 2) {
                                        throw ParserException.a("residueType greater than 2 is not decodable", null);
                                    }
                                    yVar.c(24);
                                    yVar.c(24);
                                    yVar.c(24);
                                    int iB5 = yVar.b(i9) + i14;
                                    int i16 = 8;
                                    yVar.c(8);
                                    int[] iArr = new int[iB5];
                                    for (int i17 = 0; i17 < iB5; i17++) {
                                        iArr[i17] = ((yVar.a() ? yVar.b(5) : 0) * 8) + yVar.b(3);
                                    }
                                    int i18 = 0;
                                    while (i18 < iB5) {
                                        int i19 = 0;
                                        while (i19 < i16) {
                                            if ((iArr[i18] & (1 << i19)) != 0) {
                                                yVar.c(i16);
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
                                int iB6 = yVar.b(i9) + 1;
                                for (int i20 = 0; i20 < iB6; i20++) {
                                    int iB7 = yVar.b(16);
                                    if (iB7 != 0) {
                                        StringBuilder sb = new StringBuilder(52);
                                        sb.append("mapping type other than 0 not supported: ");
                                        sb.append(iB7);
                                        Log.e("VorbisUtil", sb.toString());
                                    } else {
                                        if (yVar.a()) {
                                            i = 1;
                                            iB = yVar.b(4) + 1;
                                        } else {
                                            i = 1;
                                            iB = 1;
                                        }
                                        if (yVar.a()) {
                                            int iB8 = yVar.b(8) + i;
                                            for (int i21 = 0; i21 < iB8; i21++) {
                                                int i22 = i5 - 1;
                                                yVar.c(b.c.a.a0.d.M0(i22));
                                                yVar.c(b.c.a.a0.d.M0(i22));
                                            }
                                        }
                                        if (yVar.b(2) != 0) {
                                            throw ParserException.a("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iB > 1) {
                                            for (int i23 = 0; i23 < i5; i23++) {
                                                yVar.c(4);
                                            }
                                        }
                                        for (int i24 = 0; i24 < iB; i24++) {
                                            yVar.c(8);
                                            yVar.c(8);
                                            yVar.c(8);
                                        }
                                    }
                                }
                                int iB9 = yVar.b(6) + 1;
                                a0[] a0VarArr = new a0[iB9];
                                for (int i25 = 0; i25 < iB9; i25++) {
                                    a0VarArr[i25] = new a0(yVar.a(), yVar.b(16), yVar.b(16), yVar.b(8));
                                }
                                if (!yVar.a()) {
                                    throw ParserException.a("framing bit after modes not set as expected", null);
                                }
                                j_a = new j$a(b0Var, zVar2, bArr2, a0VarArr, b.c.a.a0.d.M0(iB9 - 1));
                                break;
                            }
                            int iB10 = yVar.b(i8);
                            if (iB10 == 0) {
                                i2 = iB3;
                                int i26 = 8;
                                yVar.c(8);
                                yVar.c(16);
                                yVar.c(16);
                                yVar.c(6);
                                yVar.c(8);
                                int iB11 = yVar.b(4) + 1;
                                int i27 = 0;
                                while (i27 < iB11) {
                                    yVar.c(i26);
                                    i27++;
                                    i26 = 8;
                                }
                            } else {
                                if (iB10 != i11) {
                                    throw b.d.b.a.a.w0(52, "floor type greater than 1 not decodable: ", iB10, null);
                                }
                                int iB12 = yVar.b(5);
                                int[] iArr2 = new int[iB12];
                                int i28 = -1;
                                for (int i29 = 0; i29 < iB12; i29++) {
                                    iArr2[i29] = yVar.b(4);
                                    if (iArr2[i29] > i28) {
                                        i28 = iArr2[i29];
                                    }
                                }
                                int i30 = i28 + 1;
                                int[] iArr3 = new int[i30];
                                int i31 = 0;
                                while (i31 < i30) {
                                    iArr3[i31] = yVar.b(i13) + 1;
                                    int iB13 = yVar.b(2);
                                    int i32 = 8;
                                    if (iB13 > 0) {
                                        yVar.c(8);
                                    }
                                    int i33 = iB3;
                                    int i34 = 0;
                                    for (int i35 = 1; i34 < (i35 << iB13); i35 = 1) {
                                        yVar.c(i32);
                                        i34++;
                                        i32 = 8;
                                    }
                                    i31++;
                                    i13 = 3;
                                    iB3 = i33;
                                }
                                i2 = iB3;
                                yVar.c(2);
                                int iB14 = yVar.b(4);
                                int i36 = 0;
                                int i37 = 0;
                                for (int i38 = 0; i38 < iB12; i38++) {
                                    i36 += iArr3[iArr2[i38]];
                                    while (i37 < i36) {
                                        yVar.c(iB14);
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
                        if (yVar.b(24) != 5653314) {
                            throw b.d.b.a.a.w0(66, "expected code book to start with [0x56, 0x43, 0x42] at ", (yVar.c * 8) + yVar.d, null);
                        }
                        int iB15 = yVar.b(16);
                        int iB16 = yVar.b(24);
                        long[] jArr = new long[iB16];
                        if (yVar.a()) {
                            i3 = iT;
                            int iB17 = yVar.b(5) + 1;
                            int i39 = 0;
                            while (i39 < iB16) {
                                int iB18 = yVar.b(b.c.a.a0.d.M0(iB16 - i39));
                                int i40 = 0;
                                while (i40 < iB18 && i39 < iB16) {
                                    jArr[i39] = iB17;
                                    i39++;
                                    i40++;
                                    zVar = zVar;
                                    bArr = bArr;
                                }
                                iB17++;
                                zVar = zVar;
                                bArr = bArr;
                            }
                        } else {
                            boolean zA = yVar.a();
                            int i41 = 0;
                            while (i41 < iB16) {
                                if (!zA) {
                                    jArr[i41] = yVar.b(5) + 1;
                                } else if (yVar.a()) {
                                    jArr[i41] = yVar.b(i6) + 1;
                                } else {
                                    jArr[i41] = 0;
                                }
                                i41++;
                                i6 = 5;
                                iT = iT;
                            }
                            i3 = iT;
                        }
                        z zVar3 = zVar;
                        byte[] bArr3 = bArr;
                        int iB19 = yVar.b(4);
                        if (iB19 > 2) {
                            throw b.d.b.a.a.w0(53, "lookup type greater than 2 not decodable: ", iB19, null);
                        }
                        if (iB19 == 1 || iB19 == 2) {
                            yVar.c(32);
                            yVar.c(32);
                            int iB20 = yVar.b(4) + 1;
                            yVar.c(1);
                            yVar.c((int) (((long) iB20) * (iB19 == 1 ? iB15 != 0 ? (long) Math.floor(Math.pow(iB16, 1.0d / ((double) iB15))) : 0L : ((long) iB16) * ((long) iB15))));
                        }
                        i7++;
                        i6 = 5;
                        iT = i3;
                        zVar = zVar3;
                        bArr = bArr3;
                    }
                }
            }
            this.n = j_a;
            if (j_a == null) {
                return true;
            }
            b0 b0Var2 = j_a.a;
            ArrayList arrayList = new ArrayList();
            arrayList.add(b0Var2.g);
            arrayList.add(j_a.f1241b);
            j1$b j1_b = new j1$b();
            j1_b.k = "audio/vorbis";
            j1_b.f = b0Var2.d;
            j1_b.g = b0Var2.c;
            j1_b.f1023x = b0Var2.a;
            j1_b.f1024y = b0Var2.f1163b;
            j1_b.m = arrayList;
            i_b.a = j1_b.a();
            return true;
        }
        b.c.a.a0.d.n2(1, xVar, false);
        int iK = xVar.k();
        int iT2 = xVar.t();
        int iK2 = xVar.k();
        int iH = xVar.h();
        int i42 = iH <= 0 ? -1 : iH;
        int iH2 = xVar.h();
        int i43 = iH2 <= 0 ? -1 : iH2;
        int iH3 = xVar.h();
        int i44 = iH3 <= 0 ? -1 : iH3;
        int iT3 = xVar.t();
        this.q = new b0(iK, iT2, iK2, i42, i43, i44, (int) Math.pow(2.0d, iT3 & 15), (int) Math.pow(2.0d, (iT3 & 240) >> 4), (xVar.t() & 1) > 0, Arrays.copyOf(xVar.a, xVar.c));
        j_a = null;
        this.n = j_a;
        if (j_a == null) {
            return true;
        }
        b0 b0Var3 = j_a.a;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(b0Var3.g);
        arrayList2.add(j_a.f1241b);
        j1$b j1_b2 = new j1$b();
        j1_b2.k = "audio/vorbis";
        j1_b2.f = b0Var3.d;
        j1_b2.g = b0Var3.c;
        j1_b2.f1023x = b0Var3.a;
        j1_b2.f1024y = b0Var3.f1163b;
        j1_b2.m = arrayList2;
        i_b.a = j1_b2.a();
        return true;
    }

    @Override // b.i.a.c.x2.j0.i
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
