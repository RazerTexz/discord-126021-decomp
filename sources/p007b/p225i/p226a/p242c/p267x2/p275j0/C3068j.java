package p007b.p225i.p226a.p242c.p267x2.p275j0;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.p259f3.C2757x;
import p007b.p225i.p226a.p242c.p267x2.C3000a0;
import p007b.p225i.p226a.p242c.p267x2.C3002b0;
import p007b.p225i.p226a.p242c.p267x2.C3124y;
import p007b.p225i.p226a.p242c.p267x2.C3125z;
import p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.j */
/* JADX INFO: compiled from: VorbisReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C3068j extends AbstractC3067i {

    /* JADX INFO: renamed from: n */
    @Nullable
    public a f8555n;

    /* JADX INFO: renamed from: o */
    public int f8556o;

    /* JADX INFO: renamed from: p */
    public boolean f8557p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public C3002b0 f8558q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public C3125z f8559r;

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.j$a */
    /* JADX INFO: compiled from: VorbisReader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final C3002b0 f8560a;

        /* JADX INFO: renamed from: b */
        public final byte[] f8561b;

        /* JADX INFO: renamed from: c */
        public final C3000a0[] f8562c;

        /* JADX INFO: renamed from: d */
        public final int f8563d;

        public a(C3002b0 c3002b0, C3125z c3125z, byte[] bArr, C3000a0[] c3000a0Arr, int i) {
            this.f8560a = c3002b0;
            this.f8561b = bArr;
            this.f8562c = c3000a0Arr;
            this.f8563d = i;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    /* JADX INFO: renamed from: b */
    public void mo3747b(long j) {
        this.f8546g = j;
        this.f8557p = j != 0;
        C3002b0 c3002b0 = this.f8558q;
        this.f8556o = c3002b0 != null ? c3002b0.f8058e : 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    /* JADX INFO: renamed from: c */
    public long mo3737c(C2757x c2757x) {
        byte[] bArr = c2757x.f6793a;
        if ((bArr[0] & 1) == 1) {
            return -1L;
        }
        byte b2 = bArr[0];
        a aVar = this.f8555n;
        C1460d.m438H(aVar);
        a aVar2 = aVar;
        int i = !aVar2.f8562c[(b2 >> 1) & (255 >>> (8 - aVar2.f8563d))].f8053a ? aVar2.f8560a.f8058e : aVar2.f8560a.f8059f;
        long j = this.f8557p ? (this.f8556o + i) / 4 : 0;
        byte[] bArr2 = c2757x.f6793a;
        int length = bArr2.length;
        int i2 = c2757x.f6795c + 4;
        if (length < i2) {
            c2757x.m3076B(Arrays.copyOf(bArr2, i2));
        } else {
            c2757x.m3078D(i2);
        }
        byte[] bArr3 = c2757x.f6793a;
        int i3 = c2757x.f6795c;
        bArr3[i3 - 4] = (byte) (j & 255);
        bArr3[i3 - 3] = (byte) ((j >>> 8) & 255);
        bArr3[i3 - 2] = (byte) ((j >>> 16) & 255);
        bArr3[i3 - 1] = (byte) ((j >>> 24) & 255);
        this.f8557p = true;
        this.f8556o = i;
        return j;
    }

    /* JADX WARN: Code duplicated, block: B:169:0x03b9 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:171:0x03bb  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* JADX INFO: renamed from: d */
    public boolean mo3738d(C2757x c2757x, long j, AbstractC3067i.b bVar) throws IOException {
        a aVar;
        int i;
        int iM3823b;
        int i2;
        int i3;
        if (this.f8555n != null) {
            Objects.requireNonNull(bVar.f8553a);
            return false;
        }
        C3002b0 c3002b0 = this.f8558q;
        if (c3002b0 != null) {
            C3125z c3125z = this.f8559r;
            if (c3125z == null) {
                this.f8559r = C1460d.m458N1(c2757x, true, true);
            } else {
                int i4 = c2757x.f6795c;
                byte[] bArr = new byte[i4];
                System.arraycopy(c2757x.f6793a, 0, bArr, 0, i4);
                int i5 = c3002b0.f8054a;
                int i6 = 5;
                C1460d.m550n2(5, c2757x, false);
                int iM3100t = c2757x.m3100t() + 1;
                C3124y c3124y = new C3124y(c2757x.f6793a);
                c3124y.m3824c(c2757x.f6794b * 8);
                int i7 = 0;
                while (true) {
                    int i8 = 16;
                    if (i7 >= iM3100t) {
                        C3125z c3125z2 = c3125z;
                        byte[] bArr2 = bArr;
                        int i9 = 6;
                        int iM3823b2 = c3124y.m3823b(6) + 1;
                        for (int i10 = 0; i10 < iM3823b2; i10++) {
                            if (c3124y.m3823b(16) != 0) {
                                throw ParserException.m8755a("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i11 = 1;
                        int iM3823b3 = c3124y.m3823b(6) + 1;
                        int i12 = 0;
                        while (true) {
                            int i13 = 3;
                            if (i12 >= iM3823b3) {
                                int i14 = 1;
                                int iM3823b4 = c3124y.m3823b(i9) + 1;
                                int i15 = 0;
                                while (i15 < iM3823b4) {
                                    if (c3124y.m3823b(16) > 2) {
                                        throw ParserException.m8755a("residueType greater than 2 is not decodable", null);
                                    }
                                    c3124y.m3824c(24);
                                    c3124y.m3824c(24);
                                    c3124y.m3824c(24);
                                    int iM3823b5 = c3124y.m3823b(i9) + i14;
                                    int i16 = 8;
                                    c3124y.m3824c(8);
                                    int[] iArr = new int[iM3823b5];
                                    for (int i17 = 0; i17 < iM3823b5; i17++) {
                                        iArr[i17] = ((c3124y.m3822a() ? c3124y.m3823b(5) : 0) * 8) + c3124y.m3823b(3);
                                    }
                                    int i18 = 0;
                                    while (i18 < iM3823b5) {
                                        int i19 = 0;
                                        while (i19 < i16) {
                                            if ((iArr[i18] & (1 << i19)) != 0) {
                                                c3124y.m3824c(i16);
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
                                int iM3823b6 = c3124y.m3823b(i9) + 1;
                                for (int i20 = 0; i20 < iM3823b6; i20++) {
                                    int iM3823b7 = c3124y.m3823b(16);
                                    if (iM3823b7 != 0) {
                                        StringBuilder sb = new StringBuilder(52);
                                        sb.append("mapping type other than 0 not supported: ");
                                        sb.append(iM3823b7);
                                        Log.e("VorbisUtil", sb.toString());
                                    } else {
                                        if (c3124y.m3822a()) {
                                            i = 1;
                                            iM3823b = c3124y.m3823b(4) + 1;
                                        } else {
                                            i = 1;
                                            iM3823b = 1;
                                        }
                                        if (c3124y.m3822a()) {
                                            int iM3823b8 = c3124y.m3823b(8) + i;
                                            for (int i21 = 0; i21 < iM3823b8; i21++) {
                                                int i22 = i5 - 1;
                                                c3124y.m3824c(C1460d.m454M0(i22));
                                                c3124y.m3824c(C1460d.m454M0(i22));
                                            }
                                        }
                                        if (c3124y.m3823b(2) != 0) {
                                            throw ParserException.m8755a("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iM3823b > 1) {
                                            for (int i23 = 0; i23 < i5; i23++) {
                                                c3124y.m3824c(4);
                                            }
                                        }
                                        for (int i24 = 0; i24 < iM3823b; i24++) {
                                            c3124y.m3824c(8);
                                            c3124y.m3824c(8);
                                            c3124y.m3824c(8);
                                        }
                                    }
                                }
                                int iM3823b9 = c3124y.m3823b(6) + 1;
                                C3000a0[] c3000a0Arr = new C3000a0[iM3823b9];
                                for (int i25 = 0; i25 < iM3823b9; i25++) {
                                    c3000a0Arr[i25] = new C3000a0(c3124y.m3822a(), c3124y.m3823b(16), c3124y.m3823b(16), c3124y.m3823b(8));
                                }
                                if (!c3124y.m3822a()) {
                                    throw ParserException.m8755a("framing bit after modes not set as expected", null);
                                }
                                aVar = new a(c3002b0, c3125z2, bArr2, c3000a0Arr, C1460d.m454M0(iM3823b9 - 1));
                                break;
                            }
                            int iM3823b10 = c3124y.m3823b(i8);
                            if (iM3823b10 == 0) {
                                i2 = iM3823b3;
                                int i26 = 8;
                                c3124y.m3824c(8);
                                c3124y.m3824c(16);
                                c3124y.m3824c(16);
                                c3124y.m3824c(6);
                                c3124y.m3824c(8);
                                int iM3823b11 = c3124y.m3823b(4) + 1;
                                int i27 = 0;
                                while (i27 < iM3823b11) {
                                    c3124y.m3824c(i26);
                                    i27++;
                                    i26 = 8;
                                }
                            } else {
                                if (iM3823b10 != i11) {
                                    throw C1643a.m884w0(52, "floor type greater than 1 not decodable: ", iM3823b10, null);
                                }
                                int iM3823b12 = c3124y.m3823b(5);
                                int[] iArr2 = new int[iM3823b12];
                                int i28 = -1;
                                for (int i29 = 0; i29 < iM3823b12; i29++) {
                                    iArr2[i29] = c3124y.m3823b(4);
                                    if (iArr2[i29] > i28) {
                                        i28 = iArr2[i29];
                                    }
                                }
                                int i30 = i28 + 1;
                                int[] iArr3 = new int[i30];
                                int i31 = 0;
                                while (i31 < i30) {
                                    iArr3[i31] = c3124y.m3823b(i13) + 1;
                                    int iM3823b13 = c3124y.m3823b(2);
                                    int i32 = 8;
                                    if (iM3823b13 > 0) {
                                        c3124y.m3824c(8);
                                    }
                                    int i33 = iM3823b3;
                                    int i34 = 0;
                                    for (int i35 = 1; i34 < (i35 << iM3823b13); i35 = 1) {
                                        c3124y.m3824c(i32);
                                        i34++;
                                        i32 = 8;
                                    }
                                    i31++;
                                    i13 = 3;
                                    iM3823b3 = i33;
                                }
                                i2 = iM3823b3;
                                c3124y.m3824c(2);
                                int iM3823b14 = c3124y.m3823b(4);
                                int i36 = 0;
                                int i37 = 0;
                                for (int i38 = 0; i38 < iM3823b12; i38++) {
                                    i36 += iArr3[iArr2[i38]];
                                    while (i37 < i36) {
                                        c3124y.m3824c(iM3823b14);
                                        i37++;
                                    }
                                }
                            }
                            i12++;
                            i9 = 6;
                            i11 = 1;
                            i8 = 16;
                            iM3823b3 = i2;
                        }
                    } else {
                        if (c3124y.m3823b(24) != 5653314) {
                            throw C1643a.m884w0(66, "expected code book to start with [0x56, 0x43, 0x42] at ", (c3124y.f9013c * 8) + c3124y.f9014d, null);
                        }
                        int iM3823b15 = c3124y.m3823b(16);
                        int iM3823b16 = c3124y.m3823b(24);
                        long[] jArr = new long[iM3823b16];
                        if (c3124y.m3822a()) {
                            i3 = iM3100t;
                            int iM3823b17 = c3124y.m3823b(5) + 1;
                            int i39 = 0;
                            while (i39 < iM3823b16) {
                                int iM3823b18 = c3124y.m3823b(C1460d.m454M0(iM3823b16 - i39));
                                int i40 = 0;
                                while (i40 < iM3823b18 && i39 < iM3823b16) {
                                    jArr[i39] = iM3823b17;
                                    i39++;
                                    i40++;
                                    c3125z = c3125z;
                                    bArr = bArr;
                                }
                                iM3823b17++;
                                c3125z = c3125z;
                                bArr = bArr;
                            }
                        } else {
                            boolean zM3822a = c3124y.m3822a();
                            int i41 = 0;
                            while (i41 < iM3823b16) {
                                if (!zM3822a) {
                                    jArr[i41] = c3124y.m3823b(5) + 1;
                                } else if (c3124y.m3822a()) {
                                    jArr[i41] = c3124y.m3823b(i6) + 1;
                                } else {
                                    jArr[i41] = 0;
                                }
                                i41++;
                                i6 = 5;
                                iM3100t = iM3100t;
                            }
                            i3 = iM3100t;
                        }
                        C3125z c3125z3 = c3125z;
                        byte[] bArr3 = bArr;
                        int iM3823b19 = c3124y.m3823b(4);
                        if (iM3823b19 > 2) {
                            throw C1643a.m884w0(53, "lookup type greater than 2 not decodable: ", iM3823b19, null);
                        }
                        if (iM3823b19 == 1 || iM3823b19 == 2) {
                            c3124y.m3824c(32);
                            c3124y.m3824c(32);
                            int iM3823b20 = c3124y.m3823b(4) + 1;
                            c3124y.m3824c(1);
                            c3124y.m3824c((int) (((long) iM3823b20) * (iM3823b19 == 1 ? iM3823b15 != 0 ? (long) Math.floor(Math.pow(iM3823b16, 1.0d / ((double) iM3823b15))) : 0L : ((long) iM3823b16) * ((long) iM3823b15))));
                        }
                        i7++;
                        i6 = 5;
                        iM3100t = i3;
                        c3125z = c3125z3;
                        bArr = bArr3;
                    }
                }
            }
            this.f8555n = aVar;
            if (aVar == null) {
                return true;
            }
            C3002b0 c3002b1 = aVar.f8560a;
            ArrayList arrayList = new ArrayList();
            arrayList.add(c3002b1.f8060g);
            arrayList.add(aVar.f8561b);
            C2811j1.b bVar2 = new C2811j1.b();
            bVar2.f7173k = "audio/vorbis";
            bVar2.f7168f = c3002b1.f8057d;
            bVar2.f7169g = c3002b1.f8056c;
            bVar2.f7186x = c3002b1.f8054a;
            bVar2.f7187y = c3002b1.f8055b;
            bVar2.f7175m = arrayList;
            bVar.f8553a = bVar2.m3277a();
            return true;
        }
        C1460d.m550n2(1, c2757x, false);
        int iM3091k = c2757x.m3091k();
        int iM3100t2 = c2757x.m3100t();
        int iM3091k2 = c2757x.m3091k();
        int iM3088h = c2757x.m3088h();
        int i42 = iM3088h <= 0 ? -1 : iM3088h;
        int iM3088h2 = c2757x.m3088h();
        int i43 = iM3088h2 <= 0 ? -1 : iM3088h2;
        int iM3088h3 = c2757x.m3088h();
        int i44 = iM3088h3 <= 0 ? -1 : iM3088h3;
        int iM3100t3 = c2757x.m3100t();
        this.f8558q = new C3002b0(iM3091k, iM3100t2, iM3091k2, i42, i43, i44, (int) Math.pow(2.0d, iM3100t3 & 15), (int) Math.pow(2.0d, (iM3100t3 & 240) >> 4), (c2757x.m3100t() & 1) > 0, Arrays.copyOf(c2757x.f6793a, c2757x.f6795c));
        aVar = null;
        this.f8555n = aVar;
        if (aVar == null) {
            return true;
        }
        C3002b0 c3002b2 = aVar.f8560a;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(c3002b2.f8060g);
        arrayList2.add(aVar.f8561b);
        C2811j1.b bVar3 = new C2811j1.b();
        bVar3.f7173k = "audio/vorbis";
        bVar3.f7168f = c3002b2.f8057d;
        bVar3.f7169g = c3002b2.f8056c;
        bVar3.f7186x = c3002b2.f8054a;
        bVar3.f7187y = c3002b2.f8055b;
        bVar3.f7175m = arrayList2;
        bVar.f8553a = bVar3.m3277a();
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.AbstractC3067i
    /* JADX INFO: renamed from: e */
    public void mo3739e(boolean z2) {
        super.mo3739e(z2);
        if (z2) {
            this.f8555n = null;
            this.f8558q = null;
            this.f8559r = null;
        }
        this.f8556o = 0;
        this.f8557p = false;
    }
}
