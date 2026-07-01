package b.i.a.c.x2.k0;

import android.util.Log;
import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.AacUtil;
import b.i.a.c.x2.DummyTrackOutput;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import com.google.android.exoplayer2.ParserException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.k, reason: use source file name */
/* JADX INFO: compiled from: AdtsReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AdtsReader implements ElementaryStreamReader {
    public static final byte[] a = {73, 68, 51};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1262b;
    public final ParsableBitArray c = new ParsableBitArray(new byte[7]);
    public final ParsableByteArray d = new ParsableByteArray(Arrays.copyOf(a, 10));

    @Nullable
    public final String e;
    public String f;
    public TrackOutput2 g;
    public TrackOutput2 h;
    public int i;
    public int j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1263s;
    public long t;
    public TrackOutput2 u;
    public long v;

    public AdtsReader(boolean z2, @Nullable String str) {
        h();
        this.n = -1;
        this.o = -1;
        this.r = -9223372036854775807L;
        this.t = -9223372036854775807L;
        this.f1262b = z2;
        this.e = str;
    }

    public static boolean g(int i) {
        return (i & 65526) == 65520;
    }

    public final boolean a(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        int iMin = Math.min(parsableByteArray.a(), i - this.j);
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, this.j, iMin);
        parsableByteArray.f984b += iMin;
        int i2 = this.j + iMin;
        this.j = i2;
        return i2 == i;
    }

    /* JADX WARN: Code duplicated, block: B:109:0x0272  */
    /* JADX WARN: Code duplicated, block: B:120:0x0297  */
    /* JADX WARN: Code duplicated, block: B:122:0x029f  */
    /* JADX WARN: Code duplicated, block: B:124:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:126:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:128:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:130:0x02af  */
    /* JADX WARN: Code duplicated, block: B:131:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:133:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:134:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:135:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:158:0x02ba A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:78:0x021d  */
    /* JADX WARN: Code duplicated, block: B:81:0x022d  */
    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        int i2;
        boolean z2;
        int iG;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Objects.requireNonNull(this.g);
        int i8 = Util2.a;
        while (parsableByteArray.a() > 0) {
            int i9 = this.i;
            int i10 = 13;
            int i11 = 2;
            if (i9 == 0) {
                byte[] bArr = parsableByteArray.a;
                int i12 = parsableByteArray.f984b;
                int i13 = parsableByteArray.c;
                while (true) {
                    if (i12 < i13) {
                        int i14 = i12 + 1;
                        int i15 = bArr[i12] & 255;
                        if (this.k == 512 && g((((byte) i15) & 255) | 65280)) {
                            if (!this.m) {
                                int i16 = i14 - 2;
                                parsableByteArray.E(i16 + 1);
                                if (i(parsableByteArray, this.c.a, 1)) {
                                    this.c.k(4);
                                    int iG2 = this.c.g(1);
                                    int i17 = this.n;
                                    if (i17 != -1 && iG2 != i17) {
                                        z2 = false;
                                    } else if (this.o == -1) {
                                        if (i(parsableByteArray, this.c.a, 4)) {
                                            this.c.k(14);
                                            iG = this.c.g(i10);
                                            if (iG >= 7) {
                                                byte[] bArr2 = parsableByteArray.a;
                                                i3 = parsableByteArray.c;
                                                i4 = i16 + iG;
                                                if (i4 < i3 && (bArr2[i4] != -1 ? !(bArr2[i4] == 73 && ((i5 = i4 + 1) == i3 || (bArr2[i5] == 68 && ((i6 = i4 + 2) == i3 || bArr2[i6] == 51)))) : !((i7 = i4 + 1) == i3 || (g((bArr2[i7] & 255) | 65280) && ((bArr2[i7] & 8) >> 3) == iG2)))) {
                                                }
                                            }
                                            z2 = false;
                                        }
                                        z2 = true;
                                    } else if (i(parsableByteArray, this.c.a, 1)) {
                                        this.c.k(i11);
                                        if (this.c.g(4) != this.o) {
                                            z2 = false;
                                        } else {
                                            parsableByteArray.E(i16 + 2);
                                            if (i(parsableByteArray, this.c.a, 4)) {
                                                this.c.k(14);
                                                iG = this.c.g(i10);
                                                if (iG >= 7) {
                                                    byte[] bArr3 = parsableByteArray.a;
                                                    i3 = parsableByteArray.c;
                                                    i4 = i16 + iG;
                                                    if (i4 < i3) {
                                                    }
                                                }
                                                z2 = false;
                                            }
                                            z2 = true;
                                        }
                                    } else {
                                        z2 = true;
                                    }
                                } else {
                                    z2 = false;
                                }
                                if (!z2) {
                                    i = this.k;
                                    i2 = i15 | i;
                                    if (i2 != 329) {
                                        this.k = 768;
                                    } else if (i2 != 511) {
                                        this.k = 512;
                                    } else if (i2 != 836) {
                                        this.k = 1024;
                                    } else if (i2 != 1075) {
                                        if (i != 256) {
                                            this.k = 256;
                                            i12 = i14 - 1;
                                        }
                                        i10 = 13;
                                        i11 = 2;
                                    } else {
                                        this.i = 2;
                                        this.j = a.length;
                                        this.f1263s = 0;
                                        this.d.E(0);
                                        parsableByteArray.E(i14);
                                    }
                                    i12 = i14;
                                    i10 = 13;
                                    i11 = 2;
                                }
                            }
                            this.p = (i15 & 8) >> 3;
                            this.l = (i15 & 1) == 0;
                            if (this.m) {
                                this.i = 3;
                                this.j = 0;
                            } else {
                                this.i = 1;
                                this.j = 0;
                            }
                            parsableByteArray.E(i14);
                        } else {
                            i = this.k;
                            i2 = i15 | i;
                            if (i2 != 329) {
                                this.k = 768;
                            } else if (i2 != 511) {
                                this.k = 512;
                            } else if (i2 != 836) {
                                this.k = 1024;
                            } else if (i2 != 1075) {
                                if (i != 256) {
                                    this.k = 256;
                                    i12 = i14 - 1;
                                }
                                i10 = 13;
                                i11 = 2;
                            } else {
                                this.i = 2;
                                this.j = a.length;
                                this.f1263s = 0;
                                this.d.E(0);
                                parsableByteArray.E(i14);
                            }
                            i12 = i14;
                            i10 = 13;
                            i11 = 2;
                        }
                    } else {
                        parsableByteArray.E(i12);
                    }
                }
            } else if (i9 != 1) {
                if (i9 != 2) {
                    if (i9 == 3) {
                        if (a(parsableByteArray, this.c.a, this.l ? 7 : 5)) {
                            this.c.k(0);
                            if (this.q) {
                                this.c.m(10);
                            } else {
                                int iG3 = this.c.g(2) + 1;
                                if (iG3 != 2) {
                                    StringBuilder sb = new StringBuilder(61);
                                    sb.append("Detected audio object type: ");
                                    sb.append(iG3);
                                    sb.append(", but assuming AAC LC.");
                                    Log.w("AdtsReader", sb.toString());
                                    iG3 = 2;
                                }
                                this.c.m(5);
                                int iG4 = this.c.g(3);
                                int i18 = this.o;
                                byte[] bArr4 = {(byte) (((iG3 << 3) & 248) | ((i18 >> 1) & 7)), (byte) (((i18 << 7) & 128) | ((iG4 << 3) & 120))};
                                AacUtil.b bVarB = AacUtil.b(new ParsableBitArray(bArr4), false);
                                Format2.b bVar = new Format2.b();
                                bVar.a = this.f;
                                bVar.k = "audio/mp4a-latm";
                                bVar.h = bVarB.c;
                                bVar.f1023x = bVarB.f1122b;
                                bVar.f1024y = bVarB.a;
                                bVar.m = Collections.singletonList(bArr4);
                                bVar.c = this.e;
                                Format2 format2A = bVar.a();
                                this.r = 1024000000 / ((long) format2A.K);
                                this.g.e(format2A);
                                this.q = true;
                            }
                            this.c.m(4);
                            int iG5 = (this.c.g(13) - 2) - 5;
                            if (this.l) {
                                iG5 -= 2;
                            }
                            TrackOutput2 trackOutput2 = this.g;
                            long j = this.r;
                            this.i = 4;
                            this.j = 0;
                            this.u = trackOutput2;
                            this.v = j;
                            this.f1263s = iG5;
                        }
                    } else {
                        if (i9 != 4) {
                            throw new IllegalStateException();
                        }
                        int iMin = Math.min(parsableByteArray.a(), this.f1263s - this.j);
                        this.u.c(parsableByteArray, iMin);
                        int i19 = this.j + iMin;
                        this.j = i19;
                        int i20 = this.f1263s;
                        if (i19 == i20) {
                            long j2 = this.t;
                            if (j2 != -9223372036854775807L) {
                                this.u.d(j2, 1, i20, 0, null);
                                this.t += this.v;
                            }
                            h();
                        }
                    }
                } else if (a(parsableByteArray, this.d.a, 10)) {
                    this.h.c(this.d, 10);
                    this.d.E(6);
                    TrackOutput2 trackOutput3 = this.h;
                    int iS = this.d.s() + 10;
                    this.i = 4;
                    this.j = 10;
                    this.u = trackOutput3;
                    this.v = 0L;
                    this.f1263s = iS;
                }
            } else if (parsableByteArray.a() != 0) {
                ParsableBitArray parsableBitArray = this.c;
                parsableBitArray.a[0] = parsableByteArray.a[parsableByteArray.f984b];
                parsableBitArray.k(2);
                int iG6 = this.c.g(4);
                int i21 = this.o;
                if (i21 == -1 || iG6 == i21) {
                    if (!this.m) {
                        this.m = true;
                        this.n = this.p;
                        this.o = iG6;
                    }
                    this.i = 3;
                    this.j = 0;
                } else {
                    this.m = false;
                    h();
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.t = -9223372036854775807L;
        this.m = false;
        h();
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.f = dVar.b();
        TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 1);
        this.g = trackOutput2P;
        this.u = trackOutput2P;
        if (!this.f1262b) {
            this.h = new DummyTrackOutput();
            return;
        }
        dVar.a();
        TrackOutput2 trackOutput2P2 = extractorOutput.p(dVar.c(), 5);
        this.h = trackOutput2P2;
        Format2.b bVar = new Format2.b();
        bVar.a = dVar.b();
        bVar.k = "application/id3";
        trackOutput2P2.e(bVar.a());
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.t = j;
        }
    }

    public final void h() {
        this.i = 0;
        this.j = 0;
        this.k = 256;
    }

    public final boolean i(ParsableByteArray parsableByteArray, byte[] bArr, int i) {
        if (parsableByteArray.a() < i) {
            return false;
        }
        System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr, 0, i);
        parsableByteArray.f984b += i;
        return true;
    }
}
