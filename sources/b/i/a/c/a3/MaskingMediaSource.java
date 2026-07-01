package b.i.a.c.a3;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.MediaItem2;
import b.i.a.c.Timeline;
import b.i.a.c.a3.CompositeMediaSource;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.p0.AdPlaybackState;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.f3.Util2;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: b.i.a.c.a3.v, reason: use source file name */
/* JADX INFO: compiled from: MaskingMediaSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MaskingMediaSource extends CompositeMediaSource<Void> {
    public final MediaSource2 j;
    public final boolean k;
    public final Timeline.c l;
    public final Timeline.b m;
    public a n;

    @Nullable
    public MaskingMediaPeriod o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* JADX INFO: renamed from: b.i.a.c.a3.v$a */
    /* JADX INFO: compiled from: MaskingMediaSource.java */
    public static final class a extends ForwardingTimeline {
        public static final Object l = new Object();

        @Nullable
        public final Object m;

        @Nullable
        public final Object n;

        public a(Timeline timeline, @Nullable Object obj, @Nullable Object obj2) {
            super(timeline);
            this.m = obj;
            this.n = obj2;
        }

        @Override // b.i.a.c.a3.ForwardingTimeline, b.i.a.c.Timeline
        public int b(Object obj) {
            Object obj2;
            Timeline timeline = this.k;
            if (l.equals(obj) && (obj2 = this.n) != null) {
                obj = obj2;
            }
            return timeline.b(obj);
        }

        @Override // b.i.a.c.Timeline
        public Timeline.b g(int i, Timeline.b bVar, boolean z2) {
            this.k.g(i, bVar, z2);
            if (Util2.a(bVar.k, this.n) && z2) {
                bVar.k = l;
            }
            return bVar;
        }

        @Override // b.i.a.c.a3.ForwardingTimeline, b.i.a.c.Timeline
        public Object m(int i) {
            Object objM = this.k.m(i);
            return Util2.a(objM, this.n) ? l : objM;
        }

        @Override // b.i.a.c.Timeline
        public Timeline.c o(int i, Timeline.c cVar, long j) {
            this.k.o(i, cVar, j);
            if (Util2.a(cVar.n, this.m)) {
                cVar.n = Timeline.c.j;
            }
            return cVar;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.v$b */
    /* JADX INFO: compiled from: MaskingMediaSource.java */
    @VisibleForTesting
    public static final class b extends Timeline {
        public final MediaItem2 k;

        public b(MediaItem2 mediaItem2) {
            this.k = mediaItem2;
        }

        @Override // b.i.a.c.Timeline
        public int b(Object obj) {
            return obj == a.l ? 0 : -1;
        }

        @Override // b.i.a.c.Timeline
        public Timeline.b g(int i, Timeline.b bVar, boolean z2) {
            bVar.f(z2 ? 0 : null, z2 ? a.l : null, 0, -9223372036854775807L, 0L, AdPlaybackState.j, true);
            return bVar;
        }

        @Override // b.i.a.c.Timeline
        public int i() {
            return 1;
        }

        @Override // b.i.a.c.Timeline
        public Object m(int i) {
            return a.l;
        }

        @Override // b.i.a.c.Timeline
        public Timeline.c o(int i, Timeline.c cVar, long j) {
            cVar.e(Timeline.c.j, this.k, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, false, true, null, 0L, -9223372036854775807L, 0, 0, 0L);
            cVar.f1044y = true;
            return cVar;
        }

        @Override // b.i.a.c.Timeline
        public int p() {
            return 1;
        }
    }

    public MaskingMediaSource(MediaSource2 mediaSource2, boolean z2) {
        this.j = mediaSource2;
        this.k = z2 && mediaSource2.i();
        this.l = new Timeline.c();
        this.m = new Timeline.b();
        Timeline timelineK = mediaSource2.k();
        if (timelineK == null) {
            this.n = new a(new b(mediaSource2.e()), Timeline.c.j, a.l);
        } else {
            this.n = new a(timelineK, null, null);
            this.r = true;
        }
    }

    @Override // b.i.a.c.a3.MediaSource2
    public MediaItem2 e() {
        return this.j.e();
    }

    @Override // b.i.a.c.a3.MediaSource2
    public void h() {
    }

    @Override // b.i.a.c.a3.MediaSource2
    public void j(MediaPeriod mediaPeriod) {
        MaskingMediaPeriod maskingMediaPeriod = (MaskingMediaPeriod) mediaPeriod;
        if (maskingMediaPeriod.n != null) {
            MediaSource2 mediaSource2 = maskingMediaPeriod.m;
            Objects.requireNonNull(mediaSource2);
            mediaSource2.j(maskingMediaPeriod.n);
        }
        if (mediaPeriod == this.o) {
            this.o = null;
        }
    }

    @Override // b.i.a.c.a3.BaseMediaSource
    public void q(@Nullable TransferListener transferListener) {
        this.i = transferListener;
        this.h = Util2.j();
        if (this.k) {
            return;
        }
        this.p = true;
        t(null, this.j);
    }

    @Override // b.i.a.c.a3.BaseMediaSource
    public void s() {
        this.q = false;
        this.p = false;
        for (CompositeMediaSource.b bVar : this.g.values()) {
            bVar.a.a(bVar.f831b);
            bVar.a.c(bVar.c);
            bVar.a.g(bVar.c);
        }
        this.g.clear();
    }

    @Override // b.i.a.c.a3.MediaSource2
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public MaskingMediaPeriod n(MediaSource2.a aVar, DefaultAllocator defaultAllocator, long j) {
        MaskingMediaPeriod maskingMediaPeriod = new MaskingMediaPeriod(aVar, defaultAllocator, j);
        MediaSource2 mediaSource2 = this.j;
        AnimatableValueParser.D(maskingMediaPeriod.m == null);
        maskingMediaPeriod.m = mediaSource2;
        if (this.q) {
            Object obj = aVar.a;
            if (this.n.n != null && obj.equals(a.l)) {
                obj = this.n.n;
            }
            maskingMediaPeriod.d(aVar.b(obj));
        } else {
            this.o = maskingMediaPeriod;
            if (!this.p) {
                this.p = true;
                t(null, this.j);
            }
        }
        return maskingMediaPeriod;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    public final void v(long j) {
        MaskingMediaPeriod maskingMediaPeriod = this.o;
        int iB = this.n.b(maskingMediaPeriod.j.a);
        if (iB == -1) {
            return;
        }
        long j2 = this.n.f(iB, this.m).m;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        maskingMediaPeriod.p = j;
    }
}
