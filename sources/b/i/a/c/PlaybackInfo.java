package b.i.a.c;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.c3.TrackSelectorResult;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.w1, reason: use source file name */
/* JADX INFO: compiled from: PlaybackInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PlaybackInfo {
    public static final MediaSource2.a a = new MediaSource2.a(new Object());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Timeline f1146b;
    public final MediaSource2.a c;
    public final long d;
    public final long e;
    public final int f;

    @Nullable
    public final ExoPlaybackException g;
    public final boolean h;
    public final TrackGroupArray i;
    public final TrackSelectorResult j;
    public final List<Metadata> k;
    public final MediaSource2.a l;
    public final boolean m;
    public final int n;
    public final PlaybackParameters o;
    public final boolean p;
    public final boolean q;
    public volatile long r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile long f1147s;
    public volatile long t;

    public PlaybackInfo(Timeline timeline, MediaSource2.a aVar, long j, long j2, int i, @Nullable ExoPlaybackException exoPlaybackException, boolean z2, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list, MediaSource2.a aVar2, boolean z3, int i2, PlaybackParameters playbackParameters, long j3, long j4, long j5, boolean z4, boolean z5) {
        this.f1146b = timeline;
        this.c = aVar;
        this.d = j;
        this.e = j2;
        this.f = i;
        this.g = exoPlaybackException;
        this.h = z2;
        this.i = trackGroupArray;
        this.j = trackSelectorResult;
        this.k = list;
        this.l = aVar2;
        this.m = z3;
        this.n = i2;
        this.o = playbackParameters;
        this.r = j3;
        this.f1147s = j4;
        this.t = j5;
        this.p = z4;
        this.q = z5;
    }

    public static PlaybackInfo h(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.j;
        MediaSource2.a aVar = a;
        TrackGroupArray trackGroupArray = TrackGroupArray.j;
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
        return new PlaybackInfo(timeline, aVar, -9223372036854775807L, 0L, 1, null, false, trackGroupArray, trackSelectorResult, RegularImmutableList.l, aVar, false, 0, PlaybackParameters.j, 0L, 0L, 0L, false, false);
    }

    @CheckResult
    public PlaybackInfo a(MediaSource2.a aVar) {
        return new PlaybackInfo(this.f1146b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, aVar, this.m, this.n, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }

    @CheckResult
    public PlaybackInfo b(MediaSource2.a aVar, long j, long j2, long j3, long j4, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list) {
        return new PlaybackInfo(this.f1146b, aVar, j2, j3, this.f, this.g, this.h, trackGroupArray, trackSelectorResult, list, this.l, this.m, this.n, this.o, this.r, j4, j, this.p, this.q);
    }

    @CheckResult
    public PlaybackInfo c(boolean z2) {
        return new PlaybackInfo(this.f1146b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.f1147s, this.t, z2, this.q);
    }

    @CheckResult
    public PlaybackInfo d(boolean z2, int i) {
        return new PlaybackInfo(this.f1146b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, z2, i, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }

    @CheckResult
    public PlaybackInfo e(@Nullable ExoPlaybackException exoPlaybackException) {
        return new PlaybackInfo(this.f1146b, this.c, this.d, this.e, this.f, exoPlaybackException, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }

    @CheckResult
    public PlaybackInfo f(int i) {
        return new PlaybackInfo(this.f1146b, this.c, this.d, this.e, i, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }

    @CheckResult
    public PlaybackInfo g(Timeline timeline) {
        return new PlaybackInfo(timeline, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.r, this.f1147s, this.t, this.p, this.q);
    }
}
