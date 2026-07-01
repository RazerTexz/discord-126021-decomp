package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.i.a.c.SeekParameters;
import b.i.a.c.a3.MediaPeriod;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.c3.ExoTrackSelection2;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.f3.Util2;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a3.u, reason: use source file name */
/* JADX INFO: compiled from: MaskingMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.a {
    public final MediaSource2.a j;
    public final long k;
    public final DefaultAllocator l;
    public MediaSource2 m;
    public MediaPeriod n;

    @Nullable
    public MediaPeriod.a o;
    public long p = -9223372036854775807L;

    public MaskingMediaPeriod(MediaSource2.a aVar, DefaultAllocator defaultAllocator, long j) {
        this.j = aVar;
        this.l = defaultAllocator;
        this.k = j;
    }

    @Override // b.i.a.c.a3.SequenceableLoader.a
    public void a(SequenceableLoader sequenceableLoader) {
        MediaPeriod.a aVar = this.o;
        int i = Util2.a;
        aVar.a(this);
    }

    @Override // b.i.a.c.a3.MediaPeriod.a
    public void b(MediaPeriod mediaPeriod) {
        MediaPeriod.a aVar = this.o;
        int i = Util2.a;
        aVar.b(this);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long c() {
        MediaPeriod mediaPeriod = this.n;
        int i = Util2.a;
        return mediaPeriod.c();
    }

    public void d(MediaSource2.a aVar) {
        long j = this.k;
        long j2 = this.p;
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        MediaSource2 mediaSource2 = this.m;
        Objects.requireNonNull(mediaSource2);
        MediaPeriod mediaPeriodN = mediaSource2.n(aVar, this.l, j);
        this.n = mediaPeriodN;
        if (this.o != null) {
            mediaPeriodN.l(this, j);
        }
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void e() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.n;
            if (mediaPeriod != null) {
                mediaPeriod.e();
                return;
            }
            MediaSource2 mediaSource2 = this.m;
            if (mediaSource2 != null) {
                mediaSource2.h();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long f(long j) {
        MediaPeriod mediaPeriod = this.n;
        int i = Util2.a;
        return mediaPeriod.f(j);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public boolean g(long j) {
        MediaPeriod mediaPeriod = this.n;
        return mediaPeriod != null && mediaPeriod.g(j);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public boolean h() {
        MediaPeriod mediaPeriod = this.n;
        return mediaPeriod != null && mediaPeriod.h();
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long i(long j, SeekParameters seekParameters) {
        MediaPeriod mediaPeriod = this.n;
        int i = Util2.a;
        return mediaPeriod.i(j, seekParameters);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long k() {
        MediaPeriod mediaPeriod = this.n;
        int i = Util2.a;
        return mediaPeriod.k();
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void l(MediaPeriod.a aVar, long j) {
        this.o = aVar;
        MediaPeriod mediaPeriod = this.n;
        if (mediaPeriod != null) {
            long j2 = this.k;
            long j3 = this.p;
            if (j3 != -9223372036854775807L) {
                j2 = j3;
            }
            mediaPeriod.l(this, j2);
        }
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long m(ExoTrackSelection2[] exoTrackSelection2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.p;
        if (j3 == -9223372036854775807L || j != this.k) {
            j2 = j;
        } else {
            this.p = -9223372036854775807L;
            j2 = j3;
        }
        MediaPeriod mediaPeriod = this.n;
        int i = Util2.a;
        return mediaPeriod.m(exoTrackSelection2Arr, zArr, sampleStreamArr, zArr2, j2);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public TrackGroupArray n() {
        MediaPeriod mediaPeriod = this.n;
        int i = Util2.a;
        return mediaPeriod.n();
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public long q() {
        MediaPeriod mediaPeriod = this.n;
        int i = Util2.a;
        return mediaPeriod.q();
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void r(long j, boolean z2) {
        MediaPeriod mediaPeriod = this.n;
        int i = Util2.a;
        mediaPeriod.r(j, z2);
    }

    @Override // b.i.a.c.a3.MediaPeriod
    public void s(long j) {
        MediaPeriod mediaPeriod = this.n;
        int i = Util2.a;
        mediaPeriod.s(j);
    }
}
