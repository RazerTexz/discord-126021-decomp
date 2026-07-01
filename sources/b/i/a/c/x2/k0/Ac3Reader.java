package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.t2.Ac3Util;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.g, reason: use source file name */
/* JADX INFO: compiled from: Ac3Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Ac3Reader implements ElementaryStreamReader {
    public final ParsableBitArray a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1249b;

    @Nullable
    public final String c;
    public String d;
    public TrackOutput2 e;
    public int f;
    public int g;
    public boolean h;
    public long i;
    public Format2 j;
    public int k;
    public long l;

    public Ac3Reader(@Nullable String str) {
        ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[128]);
        this.a = parsableBitArray;
        this.f1249b = new ParsableByteArray(parsableBitArray.a);
        this.f = 0;
        this.l = -9223372036854775807L;
        this.c = str;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x0204  */
    /* JADX WARN: Code duplicated, block: B:127:0x0212  */
    /* JADX WARN: Code duplicated, block: B:129:0x021a  */
    /* JADX WARN: Code duplicated, block: B:136:0x022e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:137:0x0230  */
    /* JADX WARN: Code duplicated, block: B:138:0x0234  */
    /* JADX WARN: Code duplicated, block: B:140:0x0237  */
    /* JADX WARN: Code duplicated, block: B:142:0x023d  */
    /* JADX WARN: Code duplicated, block: B:256:0x0240 A[SYNTHETIC] */
    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        int i3;
        String str;
        int iG;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z2;
        AnimatableValueParser.H(this.e);
        while (parsableByteArray.a() > 0) {
            int i13 = this.f;
            if (i13 == 0) {
                while (true) {
                    if (parsableByteArray.a() <= 0) {
                        z2 = false;
                        break;
                    }
                    if (this.h) {
                        int iT = parsableByteArray.t();
                        if (iT == 119) {
                            this.h = false;
                            z2 = true;
                            break;
                        }
                        this.h = iT == 11;
                    } else {
                        this.h = parsableByteArray.t() == 11;
                    }
                }
                if (z2) {
                    this.f = 1;
                    byte[] bArr = this.f1249b.a;
                    bArr[0] = 11;
                    bArr[1] = 119;
                    this.g = 2;
                }
            } else if (i13 == 1) {
                byte[] bArr2 = this.f1249b.a;
                int iMin = Math.min(parsableByteArray.a(), 128 - this.g);
                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, bArr2, this.g, iMin);
                parsableByteArray.f984b += iMin;
                int i14 = this.g + iMin;
                this.g = i14;
                if (i14 == 128) {
                    this.a.k(0);
                    ParsableBitArray parsableBitArray = this.a;
                    int iE = parsableBitArray.e();
                    parsableBitArray.m(40);
                    boolean z3 = parsableBitArray.g(5) > 10;
                    parsableBitArray.k(iE);
                    int i15 = -1;
                    if (z3) {
                        parsableBitArray.m(16);
                        int iG2 = parsableBitArray.g(2);
                        if (iG2 == 0) {
                            i15 = 0;
                        } else if (iG2 == 1) {
                            i15 = 1;
                        } else if (iG2 == 2) {
                            i15 = 2;
                        }
                        parsableBitArray.m(3);
                        iG = (parsableBitArray.g(11) + 1) * 2;
                        int iG3 = parsableBitArray.g(2);
                        if (iG3 == 3) {
                            i6 = Ac3Util.c[parsableBitArray.g(2)];
                            i5 = 6;
                            i4 = 3;
                        } else {
                            int iG4 = parsableBitArray.g(2);
                            i4 = iG4;
                            i5 = Ac3Util.a[iG4];
                            i6 = Ac3Util.f1123b[iG3];
                        }
                        i3 = i5 * 256;
                        int iG5 = parsableBitArray.g(3);
                        boolean zF = parsableBitArray.f();
                        i2 = Ac3Util.d[iG5] + (zF ? 1 : 0);
                        parsableBitArray.m(10);
                        if (parsableBitArray.f()) {
                            parsableBitArray.m(8);
                        }
                        if (iG5 == 0) {
                            parsableBitArray.m(5);
                            if (parsableBitArray.f()) {
                                parsableBitArray.m(8);
                            }
                        }
                        if (i15 == 1 && parsableBitArray.f()) {
                            parsableBitArray.m(16);
                        }
                        if (parsableBitArray.f()) {
                            if (iG5 > 2) {
                                parsableBitArray.m(2);
                            }
                            if ((iG5 & 1) == 0 || iG5 <= 2) {
                                i9 = 6;
                            } else {
                                i9 = 6;
                                parsableBitArray.m(6);
                            }
                            if ((iG5 & 4) != 0) {
                                parsableBitArray.m(i9);
                            }
                            if (zF && parsableBitArray.f()) {
                                parsableBitArray.m(5);
                            }
                            if (i15 == 0) {
                                if (parsableBitArray.f()) {
                                    i10 = 6;
                                    parsableBitArray.m(6);
                                } else {
                                    i10 = 6;
                                }
                                if (iG5 == 0 && parsableBitArray.f()) {
                                    parsableBitArray.m(i10);
                                }
                                if (parsableBitArray.f()) {
                                    parsableBitArray.m(i10);
                                }
                                int iG6 = parsableBitArray.g(2);
                                if (iG6 == 1) {
                                    parsableBitArray.m(5);
                                } else if (iG6 == 2) {
                                    parsableBitArray.m(12);
                                } else {
                                    if (iG6 == 3) {
                                        int iG7 = parsableBitArray.g(5);
                                        if (parsableBitArray.f()) {
                                            parsableBitArray.m(5);
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(4);
                                            }
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(4);
                                            }
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(4);
                                            }
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(4);
                                            }
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(4);
                                            }
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(4);
                                            }
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(4);
                                            }
                                            if (parsableBitArray.f()) {
                                                if (parsableBitArray.f()) {
                                                    parsableBitArray.m(4);
                                                }
                                                if (parsableBitArray.f()) {
                                                    parsableBitArray.m(4);
                                                }
                                            }
                                        }
                                        if (parsableBitArray.f()) {
                                            parsableBitArray.m(5);
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(7);
                                                if (parsableBitArray.f()) {
                                                    parsableBitArray.m(8);
                                                }
                                            }
                                        }
                                        i11 = 2;
                                        parsableBitArray.m((iG7 + 2) * 8);
                                        parsableBitArray.c();
                                    }
                                    if (iG5 < i11) {
                                        if (parsableBitArray.f()) {
                                            parsableBitArray.m(14);
                                        }
                                        if (iG5 == 0 && parsableBitArray.f()) {
                                            parsableBitArray.m(14);
                                        }
                                    }
                                    if (parsableBitArray.f()) {
                                        if (i4 == 0) {
                                            parsableBitArray.m(5);
                                        } else {
                                            for (i12 = 0; i12 < i5; i12++) {
                                                if (parsableBitArray.f()) {
                                                    parsableBitArray.m(5);
                                                }
                                            }
                                        }
                                    }
                                }
                                i11 = 2;
                                if (iG5 < i11) {
                                    if (parsableBitArray.f()) {
                                        parsableBitArray.m(14);
                                    }
                                    if (iG5 == 0) {
                                        parsableBitArray.m(14);
                                    }
                                }
                                if (parsableBitArray.f()) {
                                    if (i4 == 0) {
                                        parsableBitArray.m(5);
                                    } else {
                                        while (i12 < i5) {
                                            if (parsableBitArray.f()) {
                                                parsableBitArray.m(5);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (parsableBitArray.f()) {
                            parsableBitArray.m(5);
                            if (iG5 == 2) {
                                parsableBitArray.m(4);
                            }
                            if (iG5 >= 6) {
                                parsableBitArray.m(2);
                            }
                            if (parsableBitArray.f()) {
                                i8 = 8;
                                parsableBitArray.m(8);
                            } else {
                                i8 = 8;
                            }
                            if (iG5 == 0 && parsableBitArray.f()) {
                                parsableBitArray.m(i8);
                            }
                            if (iG3 < 3) {
                                parsableBitArray.l();
                            }
                        }
                        if (i15 == 0 && i4 != 3) {
                            parsableBitArray.l();
                        }
                        if (i15 == 2 && (i4 == 3 || parsableBitArray.f())) {
                            i7 = 6;
                            parsableBitArray.m(6);
                        } else {
                            i7 = 6;
                        }
                        str = (parsableBitArray.f() && parsableBitArray.g(i7) == 1 && parsableBitArray.g(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
                        i15 = i6;
                    } else {
                        parsableBitArray.m(32);
                        int iG8 = parsableBitArray.g(2);
                        String str2 = iG8 == 3 ? null : "audio/ac3";
                        int iA = Ac3Util.a(iG8, parsableBitArray.g(6));
                        parsableBitArray.m(8);
                        int iG9 = parsableBitArray.g(3);
                        if ((iG9 & 1) == 0 || iG9 == 1) {
                            i = 2;
                        } else {
                            i = 2;
                            parsableBitArray.m(2);
                        }
                        if ((iG9 & 4) != 0) {
                            parsableBitArray.m(i);
                        }
                        if (iG9 == i) {
                            parsableBitArray.m(i);
                        }
                        int[] iArr = Ac3Util.f1123b;
                        i15 = iG8 < iArr.length ? iArr[iG8] : -1;
                        i2 = Ac3Util.d[iG9] + (parsableBitArray.f() ? 1 : 0);
                        i3 = 1536;
                        str = str2;
                        iG = iA;
                    }
                    int i16 = i2;
                    Format2 format2 = this.j;
                    if (format2 == null || i16 != format2.J || i15 != format2.K || !Util2.a(str, format2.w)) {
                        Format2.b bVar = new Format2.b();
                        bVar.a = this.d;
                        bVar.k = str;
                        bVar.f1023x = i16;
                        bVar.f1024y = i15;
                        bVar.c = this.c;
                        Format2 format2A = bVar.a();
                        this.j = format2A;
                        this.e.e(format2A);
                    }
                    this.k = iG;
                    this.i = (((long) i3) * 1000000) / ((long) this.j.K);
                    this.f1249b.E(0);
                    this.e.c(this.f1249b, 128);
                    this.f = 2;
                }
            } else if (i13 == 2) {
                int iMin2 = Math.min(parsableByteArray.a(), this.k - this.g);
                this.e.c(parsableByteArray, iMin2);
                int i17 = this.g + iMin2;
                this.g = i17;
                int i18 = this.k;
                if (i17 == i18) {
                    long j = this.l;
                    if (j != -9223372036854775807L) {
                        this.e.d(j, 1, i18, 0, null);
                        this.l += this.i;
                    }
                    this.f = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.f = 0;
        this.g = 0;
        this.h = false;
        this.l = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.d = dVar.b();
        this.e = extractorOutput.p(dVar.c(), 1);
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }
}
