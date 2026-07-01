package b.i.a.c;

import android.util.Pair;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.MediaSourceList;
import b.i.a.c.a3.ClippingMediaPeriod;
import b.i.a.c.a3.EmptySampleStream;
import b.i.a.c.a3.MediaPeriod;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.SampleStream;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.c3.ExoTrackSelection2;
import b.i.a.c.c3.TrackSelector;
import b.i.a.c.c3.TrackSelectorResult;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.f3.Log2;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.q1, reason: use source file name */
/* JADX INFO: compiled from: MediaPeriodHolder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MediaPeriodHolder {
    public final MediaPeriod a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f1056b;
    public final SampleStream[] c;
    public boolean d;
    public boolean e;
    public MediaPeriodInfo f;
    public boolean g;
    public final boolean[] h;
    public final RendererCapabilities[] i;
    public final TrackSelector j;
    public final MediaSourceList k;

    @Nullable
    public MediaPeriodHolder l;
    public TrackGroupArray m;
    public TrackSelectorResult n;
    public long o;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector, DefaultAllocator defaultAllocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        this.i = rendererCapabilitiesArr;
        this.o = j;
        this.j = trackSelector;
        this.k = mediaSourceList;
        MediaSource2.a aVar = mediaPeriodInfo.a;
        this.f1056b = aVar.a;
        this.f = mediaPeriodInfo;
        this.m = TrackGroupArray.j;
        this.n = trackSelectorResult;
        this.c = new SampleStream[rendererCapabilitiesArr.length];
        this.h = new boolean[rendererCapabilitiesArr.length];
        long j2 = mediaPeriodInfo.f1058b;
        long j3 = mediaPeriodInfo.d;
        Objects.requireNonNull(mediaSourceList);
        Pair pair = (Pair) aVar.a;
        Object obj = pair.first;
        MediaSource2.a aVarB = aVar.b(pair.second);
        MediaSourceList.c cVar = mediaSourceList.c.get(obj);
        Objects.requireNonNull(cVar);
        mediaSourceList.h.add(cVar);
        MediaSourceList.b bVar = mediaSourceList.g.get(cVar);
        if (bVar != null) {
            bVar.a.m(bVar.f1138b);
        }
        cVar.c.add(aVarB);
        MediaPeriod mediaPeriodU = cVar.a.n(aVarB, defaultAllocator, j2);
        mediaSourceList.f1137b.put(mediaPeriodU, cVar);
        mediaSourceList.d();
        this.a = j3 != -9223372036854775807L ? new ClippingMediaPeriod(mediaPeriodU, true, 0L, j3) : mediaPeriodU;
    }

    public long a(TrackSelectorResult trackSelectorResult, long j, boolean z2, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z3 = true;
            if (i >= trackSelectorResult.a) {
                break;
            }
            boolean[] zArr2 = this.h;
            if (z2 || !trackSelectorResult.a(this.n, i)) {
                z3 = false;
            }
            zArr2[i] = z3;
            i++;
        }
        SampleStream[] sampleStreamArr = this.c;
        int i2 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.i;
            if (i2 >= rendererCapabilitiesArr.length) {
                break;
            }
            if (((BaseRenderer) rendererCapabilitiesArr[i2]).j == -2) {
                sampleStreamArr[i2] = null;
            }
            i2++;
        }
        b();
        this.n = trackSelectorResult;
        c();
        long jM = this.a.m(trackSelectorResult.c, this.h, this.c, zArr, j);
        SampleStream[] sampleStreamArr2 = this.c;
        int i3 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr2 = this.i;
            if (i3 >= rendererCapabilitiesArr2.length) {
                break;
            }
            if (((BaseRenderer) rendererCapabilitiesArr2[i3]).j == -2 && this.n.b(i3)) {
                sampleStreamArr2[i3] = new EmptySampleStream();
            }
            i3++;
        }
        this.e = false;
        int i4 = 0;
        while (true) {
            SampleStream[] sampleStreamArr3 = this.c;
            if (i4 >= sampleStreamArr3.length) {
                return jM;
            }
            if (sampleStreamArr3[i4] != null) {
                AnimatableValueParser.D(trackSelectorResult.b(i4));
                if (((BaseRenderer) this.i[i4]).j != -2) {
                    this.e = true;
                }
            } else {
                AnimatableValueParser.D(trackSelectorResult.c[i4] == null);
            }
            i4++;
        }
    }

    public final void b() {
        if (!g()) {
            return;
        }
        int i = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.n;
            if (i >= trackSelectorResult.a) {
                return;
            }
            boolean zB = trackSelectorResult.b(i);
            ExoTrackSelection2 exoTrackSelection2 = this.n.c[i];
            if (zB && exoTrackSelection2 != null) {
                exoTrackSelection2.g();
            }
            i++;
        }
    }

    public final void c() {
        if (!g()) {
            return;
        }
        int i = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.n;
            if (i >= trackSelectorResult.a) {
                return;
            }
            boolean zB = trackSelectorResult.b(i);
            ExoTrackSelection2 exoTrackSelection2 = this.n.c[i];
            if (zB && exoTrackSelection2 != null) {
                exoTrackSelection2.e();
            }
            i++;
        }
    }

    public long d() {
        if (!this.d) {
            return this.f.f1058b;
        }
        long jQ = this.e ? this.a.q() : Long.MIN_VALUE;
        return jQ == Long.MIN_VALUE ? this.f.e : jQ;
    }

    public long e() {
        return this.f.f1058b + this.o;
    }

    public boolean f() {
        return this.d && (!this.e || this.a.q() == Long.MIN_VALUE);
    }

    public final boolean g() {
        return this.l == null;
    }

    public void h() {
        b();
        MediaSourceList mediaSourceList = this.k;
        MediaPeriod mediaPeriod = this.a;
        try {
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                mediaSourceList.h(((ClippingMediaPeriod) mediaPeriod).j);
            } else {
                mediaSourceList.h(mediaPeriod);
            }
        } catch (RuntimeException e) {
            Log2.b("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    public TrackSelectorResult i(float f, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult trackSelectorResultB = this.j.b(this.i, this.m, this.f.a, timeline);
        for (ExoTrackSelection2 exoTrackSelection2 : trackSelectorResultB.c) {
            if (exoTrackSelection2 != null) {
                exoTrackSelection2.i(f);
            }
        }
        return trackSelectorResultB;
    }

    public void j() {
        MediaPeriod mediaPeriod = this.a;
        if (mediaPeriod instanceof ClippingMediaPeriod) {
            long j = this.f.d;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            clippingMediaPeriod.n = 0L;
            clippingMediaPeriod.o = j;
        }
    }
}
