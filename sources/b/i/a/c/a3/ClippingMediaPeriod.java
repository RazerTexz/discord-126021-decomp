package b.i.a.c.a3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.FormatHolder;
import b.i.a.c.SeekParameters;
import b.i.a.c.a3.MediaPeriod;
import b.i.a.c.c3.ExoTrackSelection2;
import b.i.a.c.f3.MimeTypes;
import b.i.a.c.f3.Util2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a3.n, reason: use source file name */
/* JADX INFO: compiled from: ClippingMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.a {
    public final MediaPeriod j;

    @Nullable
    public MediaPeriod.a k;
    public a[] l = new a[0];
    public long m;
    public long n;
    public long o;

    /* JADX INFO: renamed from: b.i.a.c.a3.n$a */
    /* JADX INFO: compiled from: ClippingMediaPeriod.java */
    public final class a implements SampleStream {
        public final SampleStream a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f830b;

        public a(SampleStream sampleStream) {
            this.a = sampleStream;
        }

        @Override // b.i.a.c.a3.SampleStream
        public int a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            if (ClippingMediaPeriod.this.d()) {
                return -3;
            }
            if (this.f830b) {
                decoderInputBuffer.j = 4;
                return -4;
            }
            int iA = this.a.a(formatHolder, decoderInputBuffer, i);
            if (iA != -5) {
                ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                long j = clippingMediaPeriod.o;
                if (j == Long.MIN_VALUE || ((iA != -4 || decoderInputBuffer.n < j) && !(iA == -3 && clippingMediaPeriod.q() == Long.MIN_VALUE && !decoderInputBuffer.m))) {
                    return iA;
                }
                decoderInputBuffer.p();
                decoderInputBuffer.j = 4;
                this.f830b = true;
                return -4;
            }
            Format2 format2 = formatHolder.f1027b;
            Objects.requireNonNull(format2);
            int i2 = format2.M;
            if (i2 != 0 || format2.N != 0) {
                ClippingMediaPeriod clippingMediaPeriod2 = ClippingMediaPeriod.this;
                if (clippingMediaPeriod2.n != 0) {
                    i2 = 0;
                }
                int i3 = clippingMediaPeriod2.o == Long.MIN_VALUE ? format2.N : 0;
                Format2.b bVarA = format2.a();
                bVarA.A = i2;
                bVarA.B = i3;
                formatHolder.f1027b = bVarA.a();
            }
            return -5;
        }

        @Override // b.i.a.c.a3.SampleStream
        public void b() throws IOException {
            this.a.b();
        }

        @Override // b.i.a.c.a3.SampleStream
        public int c(long j) {
            if (ClippingMediaPeriod.this.d()) {
                return -3;
            }
            return this.a.c(j);
        }

        @Override // b.i.a.c.a3.SampleStream
        public boolean d() {
            return !ClippingMediaPeriod.this.d() && this.a.d();
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z2, long j, long j2) {
        this.j = mediaPeriod;
        this.m = z2 ? j : -9223372036854775807L;
        this.n = j;
        this.o = j2;
    }

    @Override // b.i.a.c.a3.SequenceableLoader.a
    public void a(SequenceableLoader sequenceableLoader) {
        MediaPeriod.a aVar = this.k;
        Objects.requireNonNull(aVar);
        aVar.a(this);
    }

    @Override // b.i.a.c.a3.MediaPeriod.a
    public void b(MediaPeriod mediaPeriod) {
        MediaPeriod.a aVar = this.k;
        Objects.requireNonNull(aVar);
        aVar.b(this);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long c() {
        long jC = this.j.c();
        if (jC != Long.MIN_VALUE) {
            long j = this.o;
            if (j == Long.MIN_VALUE || jC < j) {
                return jC;
            }
        }
        return Long.MIN_VALUE;
    }

    public boolean d() {
        return this.m != -9223372036854775807L;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void e() throws IOException {
        this.j.e();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0033  */
    @Override // b.i.a.c.a3.MediaPeriod
    public long f(long j) {
        this.m = -9223372036854775807L;
        boolean z2 = false;
        for (a aVar : this.l) {
            if (aVar != null) {
                aVar.f830b = false;
            }
        }
        long jF = this.j.f(j);
        if (jF == j) {
            z2 = true;
        } else if (jF >= this.n) {
            long j2 = this.o;
            if (j2 == Long.MIN_VALUE || jF <= j2) {
                z2 = true;
            }
        }
        AnimatableValueParser.D(z2);
        return jF;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public boolean g(long j) {
        return this.j.g(j);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public boolean h() {
        return this.j.h();
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long i(long j, SeekParameters seekParameters) {
        long j2 = this.n;
        if (j == j2) {
            return j2;
        }
        long jI = Util2.i(seekParameters.c, 0L, j - j2);
        long j3 = seekParameters.d;
        long j4 = this.o;
        long jI2 = Util2.i(j3, 0L, j4 == Long.MIN_VALUE ? RecyclerView.FOREVER_NS : j4 - j);
        if (jI != seekParameters.c || jI2 != seekParameters.d) {
            seekParameters = new SeekParameters(jI, jI2);
        }
        return this.j.i(j, seekParameters);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long k() {
        if (d()) {
            long j = this.m;
            this.m = -9223372036854775807L;
            long jK = k();
            return jK != -9223372036854775807L ? jK : j;
        }
        long jK2 = this.j.k();
        if (jK2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z2 = true;
        AnimatableValueParser.D(jK2 >= this.n);
        long j2 = this.o;
        if (j2 != Long.MIN_VALUE && jK2 > j2) {
            z2 = false;
        }
        AnimatableValueParser.D(z2);
        return jK2;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void l(MediaPeriod.a aVar, long j) {
        this.k = aVar;
        this.j.l(this, j);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x006a  */
    /* JADX WARN: Code duplicated, block: B:36:0x0088  */
    @Override // b.i.a.c.a3.MediaPeriod
    public long m(ExoTrackSelection2[] exoTrackSelection2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        boolean z2;
        this.l = new a[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i >= sampleStreamArr.length) {
                break;
            }
            a[] aVarArr = this.l;
            aVarArr[i] = (a) sampleStreamArr[i];
            if (aVarArr[i] != null) {
                sampleStream = aVarArr[i].a;
            }
            sampleStreamArr2[i] = sampleStream;
            i++;
        }
        long jM = this.j.m(exoTrackSelection2Arr, zArr, sampleStreamArr2, zArr2, j);
        boolean z3 = true;
        if (d()) {
            long j3 = this.n;
            if (j != j3) {
                j2 = -9223372036854775807L;
            } else {
                if (j3 == 0) {
                    z2 = false;
                    break;
                }
                int length = exoTrackSelection2Arr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        z2 = false;
                        break;
                    }
                    ExoTrackSelection2 exoTrackSelection2 = exoTrackSelection2Arr[i2];
                    if (exoTrackSelection2 != null) {
                        Format2 format2H = exoTrackSelection2.h();
                        if (!MimeTypes.a(format2H.w, format2H.t)) {
                            z2 = true;
                            break;
                        }
                    }
                    i2++;
                }
                if (z2) {
                    j2 = jM;
                } else {
                    j2 = -9223372036854775807L;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        this.m = j2;
        if (jM != j) {
            if (jM >= this.n) {
                long j4 = this.o;
                if (j4 != Long.MIN_VALUE && jM > j4) {
                    z3 = false;
                }
            } else {
                z3 = false;
            }
        }
        AnimatableValueParser.D(z3);
        for (int i3 = 0; i3 < sampleStreamArr.length; i3++) {
            if (sampleStreamArr2[i3] == null) {
                this.l[i3] = null;
            } else {
                a[] aVarArr2 = this.l;
                if (aVarArr2[i3] == null || aVarArr2[i3].a != sampleStreamArr2[i3]) {
                    aVarArr2[i3] = new a(sampleStreamArr2[i3]);
                }
            }
            sampleStreamArr[i3] = this.l[i3];
        }
        return jM;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public TrackGroupArray n() {
        return this.j.n();
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long q() {
        long jQ = this.j.q();
        if (jQ != Long.MIN_VALUE) {
            long j = this.o;
            if (j == Long.MIN_VALUE || jQ < j) {
                return jQ;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void r(long j, boolean z2) {
        this.j.r(j, z2);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void s(long j) {
        this.j.s(j);
    }
}
