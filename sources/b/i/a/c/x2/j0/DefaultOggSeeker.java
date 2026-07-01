package b.i.a.c.x2.j0;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorInput;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.SeekPoint;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.b, reason: use source file name */
/* JADX INFO: compiled from: DefaultOggSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultOggSeeker implements OggSeeker {
    public final OggPageHeader a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1234b;
    public final long c;
    public final StreamReader d;
    public int e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;

    /* JADX INFO: renamed from: b.i.a.c.x2.j0.b$b */
    /* JADX INFO: compiled from: DefaultOggSeeker.java */
    public final class b implements SeekMap {
        public b(a aVar) {
        }

        @Override // b.i.a.c.x2.SeekMap
        public boolean c() {
            return true;
        }

        @Override // b.i.a.c.x2.SeekMap
        public SeekMap.a h(long j) {
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            long j2 = (((long) defaultOggSeeker.d.i) * j) / 1000000;
            long j3 = defaultOggSeeker.f1234b;
            long j4 = defaultOggSeeker.c;
            return new SeekMap.a(new SeekPoint(j, Util2.i(((((j4 - j3) * j2) / defaultOggSeeker.f) + j3) - 30000, j3, j4 - 1)));
        }

        @Override // b.i.a.c.x2.SeekMap
        public long i() {
            DefaultOggSeeker defaultOggSeeker = DefaultOggSeeker.this;
            return (defaultOggSeeker.f * 1000000) / ((long) defaultOggSeeker.d.i);
        }
    }

    public DefaultOggSeeker(StreamReader streamReader, long j, long j2, long j3, long j4, boolean z2) {
        AnimatableValueParser.j(j >= 0 && j2 > j);
        this.d = streamReader;
        this.f1234b = j;
        this.c = j2;
        if (j3 == j2 - j || z2) {
            this.f = j4;
            this.e = 4;
        } else {
            this.e = 0;
        }
        this.a = new OggPageHeader();
    }

    @Override // b.i.a.c.x2.j0.OggSeeker
    @Nullable
    public SeekMap a() {
        if (this.f != 0) {
            return new b(null);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    @Override // b.i.a.c.x2.j0.OggSeeker
    public long b(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        long jI;
        long j;
        int i = this.e;
        if (i == 0) {
            long position = extractorInput.getPosition();
            this.g = position;
            this.e = 1;
            long j2 = this.c - 65307;
            if (j2 > position) {
                return j2;
            }
        } else if (i != 1) {
            if (i == 2) {
                if (this.i == this.j) {
                    jI = -1;
                } else {
                    long position2 = extractorInput.getPosition();
                    if (this.a.c(extractorInput, this.j)) {
                        this.a.a(extractorInput, false);
                        extractorInput.k();
                        long j3 = this.h;
                        OggPageHeader oggPageHeader = this.a;
                        long j4 = oggPageHeader.c;
                        long j5 = j3 - j4;
                        int i2 = oggPageHeader.e + oggPageHeader.f;
                        if (0 > j5 || j5 >= 72000) {
                            if (j5 < 0) {
                                this.j = position2;
                                this.l = j4;
                            } else {
                                this.i = extractorInput.getPosition() + ((long) i2);
                                this.k = this.a.c;
                            }
                            long j6 = this.j;
                            long j7 = this.i;
                            if (j6 - j7 < 100000) {
                                this.j = j7;
                                jI = j7;
                            } else {
                                long position3 = extractorInput.getPosition() - (((long) i2) * (j5 <= 0 ? 2L : 1L));
                                long j8 = this.j;
                                long j9 = this.i;
                                jI = Util2.i((((j8 - j9) * j5) / (this.l - this.k)) + position3, j9, j8 - 1);
                            }
                        } else {
                            jI = -1;
                        }
                    } else {
                        jI = this.i;
                        if (jI == position2) {
                            throw new IOException("No ogg page can be found.");
                        }
                    }
                }
                j = -1;
                if (jI != -1) {
                    return jI;
                }
                this.e = 3;
            } else {
                if (i != 3) {
                    if (i == 4) {
                        return -1L;
                    }
                    throw new IllegalStateException();
                }
                j = -1;
            }
            while (true) {
                this.a.c(extractorInput, j);
                this.a.a(extractorInput, false);
                OggPageHeader oggPageHeader2 = this.a;
                if (oggPageHeader2.c > this.h) {
                    extractorInput.k();
                    this.e = 4;
                    return -(this.k + 2);
                }
                extractorInput.l(oggPageHeader2.e + oggPageHeader2.f);
                this.i = extractorInput.getPosition();
                this.k = this.a.c;
                j = -1;
            }
        }
        this.a.b();
        if (!this.a.c(extractorInput, -1L)) {
            throw new EOFException();
        }
        this.a.a(extractorInput, false);
        OggPageHeader oggPageHeader3 = this.a;
        extractorInput.l(oggPageHeader3.e + oggPageHeader3.f);
        long j10 = this.a.c;
        while (true) {
            OggPageHeader oggPageHeader4 = this.a;
            if ((oggPageHeader4.f1238b & 4) == 4 || !oggPageHeader4.c(extractorInput, -1L) || extractorInput.getPosition() >= this.c || !this.a.a(extractorInput, true)) {
                break;
            }
            OggPageHeader oggPageHeader5 = this.a;
            try {
                extractorInput.l(oggPageHeader5.e + oggPageHeader5.f);
                z2 = true;
            } catch (EOFException unused) {
                z2 = false;
            }
            if (!z2) {
                break;
            }
            j10 = this.a.c;
        }
        this.f = j10;
        this.e = 4;
        return this.g;
    }

    @Override // b.i.a.c.x2.j0.OggSeeker
    public void c(long j) {
        this.h = Util2.i(j, 0L, this.f - 1);
        this.e = 2;
        this.i = this.f1234b;
        this.j = this.c;
        this.k = 0L;
        this.l = this.f;
    }
}
