package b.i.a.c.x2.k0;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableBitArray;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.t2.AacUtil;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.u, reason: use source file name */
/* JADX INFO: compiled from: LatmReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class LatmReader implements ElementaryStreamReader {

    @Nullable
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ParsableByteArray f1278b;
    public final ParsableBitArray c;
    public TrackOutput2 d;
    public String e;
    public Format2 f;
    public int g;
    public int h;
    public int i;
    public int j;
    public long k;
    public boolean l;
    public int m;
    public int n;
    public int o;
    public boolean p;
    public long q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f1279s;
    public int t;

    @Nullable
    public String u;

    public LatmReader(@Nullable String str) {
        this.a = str;
        ParsableByteArray parsableByteArray = new ParsableByteArray(1024);
        this.f1278b = parsableByteArray;
        this.c = new ParsableBitArray(parsableByteArray.a);
        this.k = -9223372036854775807L;
    }

    public static long a(ParsableBitArray parsableBitArray) {
        return parsableBitArray.g((parsableBitArray.g(2) + 1) * 8);
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        boolean zF;
        AnimatableValueParser.H(this.d);
        while (parsableByteArray.a() > 0) {
            int i2 = this.g;
            if (i2 != 0) {
                if (i2 == 1) {
                    int iT = parsableByteArray.t();
                    if ((iT & 224) == 224) {
                        this.j = iT;
                        this.g = 2;
                    } else if (iT != 86) {
                        this.g = 0;
                    }
                } else if (i2 == 2) {
                    int iT2 = ((this.j & (-225)) << 8) | parsableByteArray.t();
                    this.i = iT2;
                    ParsableByteArray parsableByteArray2 = this.f1278b;
                    byte[] bArr = parsableByteArray2.a;
                    if (iT2 > bArr.length) {
                        if (bArr.length < iT2) {
                            bArr = new byte[iT2];
                        }
                        parsableByteArray2.C(bArr, iT2);
                        ParsableBitArray parsableBitArray = this.c;
                        byte[] bArr2 = this.f1278b.a;
                        Objects.requireNonNull(parsableBitArray);
                        int length = bArr2.length;
                        parsableBitArray.a = bArr2;
                        parsableBitArray.f983b = 0;
                        parsableBitArray.c = 0;
                        parsableBitArray.d = length;
                    }
                    this.h = 0;
                    this.g = 3;
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException();
                    }
                    int iMin = Math.min(parsableByteArray.a(), this.i - this.h);
                    parsableByteArray.e(this.c.a, this.h, iMin);
                    int i3 = this.h + iMin;
                    this.h = i3;
                    if (i3 == this.i) {
                        this.c.k(0);
                        ParsableBitArray parsableBitArray2 = this.c;
                        if (parsableBitArray2.f()) {
                            if (this.l) {
                            }
                            this.g = 0;
                        } else {
                            this.l = true;
                            int iG = parsableBitArray2.g(1);
                            int iG2 = iG == 1 ? parsableBitArray2.g(1) : 0;
                            this.m = iG2;
                            if (iG2 != 0) {
                                throw ParserException.a(null, null);
                            }
                            if (iG == 1) {
                                a(parsableBitArray2);
                            }
                            if (!parsableBitArray2.f()) {
                                throw ParserException.a(null, null);
                            }
                            this.n = parsableBitArray2.g(6);
                            int iG3 = parsableBitArray2.g(4);
                            int iG4 = parsableBitArray2.g(3);
                            if (iG3 != 0 || iG4 != 0) {
                                throw ParserException.a(null, null);
                            }
                            if (iG == 0) {
                                int iE = parsableBitArray2.e();
                                int iG5 = g(parsableBitArray2);
                                parsableBitArray2.k(iE);
                                byte[] bArr3 = new byte[(iG5 + 7) / 8];
                                parsableBitArray2.h(bArr3, 0, iG5);
                                Format2.b bVar = new Format2.b();
                                bVar.a = this.e;
                                bVar.k = "audio/mp4a-latm";
                                bVar.h = this.u;
                                bVar.f1023x = this.t;
                                bVar.f1024y = this.r;
                                bVar.m = Collections.singletonList(bArr3);
                                bVar.c = this.a;
                                Format2 format2A = bVar.a();
                                if (!format2A.equals(this.f)) {
                                    this.f = format2A;
                                    this.f1279s = 1024000000 / ((long) format2A.K);
                                    this.d.e(format2A);
                                }
                            } else {
                                parsableBitArray2.m(((int) a(parsableBitArray2)) - g(parsableBitArray2));
                            }
                            int iG6 = parsableBitArray2.g(3);
                            this.o = iG6;
                            if (iG6 == 0) {
                                parsableBitArray2.m(8);
                            } else if (iG6 == 1) {
                                parsableBitArray2.m(9);
                            } else if (iG6 == 3 || iG6 == 4 || iG6 == 5) {
                                parsableBitArray2.m(6);
                            } else {
                                if (iG6 != 6 && iG6 != 7) {
                                    throw new IllegalStateException();
                                }
                                parsableBitArray2.m(1);
                            }
                            boolean zF2 = parsableBitArray2.f();
                            this.p = zF2;
                            this.q = 0L;
                            if (zF2) {
                                if (iG == 1) {
                                    this.q = a(parsableBitArray2);
                                } else {
                                    do {
                                        zF = parsableBitArray2.f();
                                        this.q = (this.q << 8) + ((long) parsableBitArray2.g(8));
                                    } while (zF);
                                }
                            }
                            if (parsableBitArray2.f()) {
                                parsableBitArray2.m(8);
                            }
                        }
                        if (this.m != 0) {
                            throw ParserException.a(null, null);
                        }
                        if (this.n != 0) {
                            throw ParserException.a(null, null);
                        }
                        if (this.o != 0) {
                            throw ParserException.a(null, null);
                        }
                        int i4 = 0;
                        while (true) {
                            int iG7 = parsableBitArray2.g(8);
                            i = i4 + iG7;
                            if (iG7 != 255) {
                                break;
                            } else {
                                i4 = i;
                            }
                        }
                        int iE2 = parsableBitArray2.e();
                        if ((iE2 & 7) == 0) {
                            this.f1278b.E(iE2 >> 3);
                        } else {
                            parsableBitArray2.h(this.f1278b.a, 0, i * 8);
                            this.f1278b.E(0);
                        }
                        this.d.c(this.f1278b, i);
                        long j = this.k;
                        if (j != -9223372036854775807L) {
                            this.d.d(j, 1, i, 0, null);
                            this.k += this.f1279s;
                        }
                        if (this.p) {
                            parsableBitArray2.m((int) this.q);
                        }
                        this.g = 0;
                    } else {
                        continue;
                    }
                }
            } else if (parsableByteArray.t() == 86) {
                this.g = 1;
            }
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.g = 0;
        this.k = -9223372036854775807L;
        this.l = false;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        this.d = extractorOutput.p(dVar.c(), 1);
        this.e = dVar.b();
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    public final int g(ParsableBitArray parsableBitArray) throws ParserException {
        int iB = parsableBitArray.b();
        AacUtil.b bVarB = AacUtil.b(parsableBitArray, true);
        this.u = bVarB.c;
        this.r = bVarB.a;
        this.t = bVarB.f1122b;
        return iB - parsableBitArray.b();
    }
}
