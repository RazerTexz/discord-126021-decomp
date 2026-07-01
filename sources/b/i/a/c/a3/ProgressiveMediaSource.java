package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.i.a.c.MediaItem2;
import b.i.a.c.Timeline;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.ProgressiveMediaExtractor;
import b.i.a.c.a3.ProgressiveMediaPeriod;
import b.i.a.c.e3.DataSource3;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.e3.LoadErrorHandlingPolicy;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.w2.DrmSessionManager2;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.upstream.Loader;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a3.f0, reason: use source file name */
/* JADX INFO: compiled from: ProgressiveMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ProgressiveMediaSource extends BaseMediaSource implements ProgressiveMediaPeriod.b {
    public final MediaItem2 g;
    public final MediaItem2.h h;
    public final DataSource3.a i;
    public final ProgressiveMediaExtractor.a j;
    public final DrmSessionManager2 k;
    public final LoadErrorHandlingPolicy l;
    public final int m;
    public boolean n;
    public long o;
    public boolean p;
    public boolean q;

    @Nullable
    public TransferListener r;

    /* JADX INFO: renamed from: b.i.a.c.a3.f0$a */
    /* JADX INFO: compiled from: ProgressiveMediaSource.java */
    public class a extends ForwardingTimeline {
        public a(Timeline timeline) {
            super(timeline);
        }

        @Override // b.i.a.c.Timeline
        public Timeline.b g(int i, Timeline.b bVar, boolean z2) {
            this.k.g(i, bVar, z2);
            bVar.o = true;
            return bVar;
        }

        @Override // b.i.a.c.Timeline
        public Timeline.c o(int i, Timeline.c cVar, long j) {
            this.k.o(i, cVar, j);
            cVar.f1044y = true;
            return cVar;
        }
    }

    public ProgressiveMediaSource(MediaItem2 mediaItem2, DataSource3.a aVar, ProgressiveMediaExtractor.a aVar2, DrmSessionManager2 drmSessionManager2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int i, a aVar3) {
        MediaItem2.h hVar = mediaItem2.l;
        Objects.requireNonNull(hVar);
        this.h = hVar;
        this.g = mediaItem2;
        this.i = aVar;
        this.j = aVar2;
        this.k = drmSessionManager2;
        this.l = loadErrorHandlingPolicy;
        this.m = i;
        this.n = true;
        this.o = -9223372036854775807L;
    }

    @Override // b.i.a.c.a3.MediaSource2
    public MediaItem2 e() {
        return this.g;
    }

    @Override // b.i.a.c.a3.MediaSource2
    public void h() {
    }

    @Override // b.i.a.c.a3.MediaSource2
    public void j(MediaPeriod mediaPeriod) {
        ProgressiveMediaPeriod progressiveMediaPeriod = (ProgressiveMediaPeriod) mediaPeriod;
        if (progressiveMediaPeriod.G) {
            for (SampleQueue sampleQueue : progressiveMediaPeriod.D) {
                sampleQueue.h();
                DrmSession drmSession = sampleQueue.i;
                if (drmSession != null) {
                    drmSession.b(sampleQueue.e);
                    sampleQueue.i = null;
                    sampleQueue.h = null;
                }
            }
        }
        Loader loader = progressiveMediaPeriod.v;
        Loader.d<? extends Loader.e> dVar = loader.d;
        if (dVar != null) {
            dVar.a(true);
        }
        loader.c.execute(new Loader.g(progressiveMediaPeriod));
        loader.c.shutdown();
        progressiveMediaPeriod.A.removeCallbacksAndMessages(null);
        progressiveMediaPeriod.B = null;
        progressiveMediaPeriod.W = true;
    }

    @Override // b.i.a.c.a3.MediaSource2
    public MediaPeriod n(MediaSource2.a aVar, DefaultAllocator defaultAllocator, long j) {
        DataSource3 dataSource3A = this.i.a();
        TransferListener transferListener = this.r;
        if (transferListener != null) {
            dataSource3A.d(transferListener);
        }
        return new ProgressiveMediaPeriod(this.h.a, dataSource3A, new BundledExtractorsAdapter(((j) this.j).a), this.k, this.d.g(0, aVar), this.l, this.c.g(0, aVar, 0L), this, defaultAllocator, this.h.e, this.m);
    }

    @Override // b.i.a.c.a3.BaseMediaSource
    public void q(@Nullable TransferListener transferListener) {
        this.r = transferListener;
        this.k.a();
        t();
    }

    @Override // b.i.a.c.a3.BaseMediaSource
    public void s() {
        this.k.release();
    }

    public final void t() {
        Timeline singlePeriodTimeline = new SinglePeriodTimeline(this.o, this.p, false, this.q, null, this.g);
        if (this.n) {
            singlePeriodTimeline = new a(singlePeriodTimeline);
        }
        r(singlePeriodTimeline);
    }

    public void u(long j, boolean z2, boolean z3) {
        if (j == -9223372036854775807L) {
            j = this.o;
        }
        if (!this.n && this.o == j && this.p == z2 && this.q == z3) {
            return;
        }
        this.o = j;
        this.p = z2;
        this.q = z3;
        this.n = false;
        t();
    }
}
