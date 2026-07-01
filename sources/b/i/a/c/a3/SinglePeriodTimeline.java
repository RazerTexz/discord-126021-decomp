package b.i.a.c.a3;

import android.net.Uri;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.MediaItem2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.Timeline;
import b.i.a.c.a3.p0.AdPlaybackState;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a3.l0, reason: use source file name */
/* JADX INFO: compiled from: SinglePeriodTimeline.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SinglePeriodTimeline extends Timeline {
    public static final Object k = new Object();
    public final long l;
    public final long m;
    public final boolean n;

    @Nullable
    public final MediaItem2 o;

    @Nullable
    public final MediaItem2.g p;

    static {
        MediaItem2.d.a aVar = new MediaItem2.d.a();
        MediaItem2.f.a aVar2 = new MediaItem2.f.a(null);
        List listEmptyList = Collections.emptyList();
        ImmutableList2<Object> immutableList2 = RegularImmutableList.l;
        MediaItem2.g.a aVar3 = new MediaItem2.g.a();
        Uri uri = Uri.EMPTY;
        AnimatableValueParser.D(aVar2.f1037b == null || aVar2.a != null);
        if (uri != null) {
            new MediaItem2.i(uri, null, aVar2.a != null ? new MediaItem2.f(aVar2, null) : null, null, listEmptyList, null, immutableList2, null, null);
        }
        aVar.a();
        new MediaItem2.g(aVar3, null);
        MediaMetadata mediaMetadata = MediaMetadata.j;
    }

    public SinglePeriodTimeline(long j, boolean z2, boolean z3, boolean z4, @Nullable Object obj, MediaItem2 mediaItem2) {
        MediaItem2.g gVar = z4 ? mediaItem2.m : null;
        this.l = j;
        this.m = j;
        this.n = z2;
        Objects.requireNonNull(mediaItem2);
        this.o = mediaItem2;
        this.p = gVar;
    }

    @Override // b.i.a.c.Timeline
    public int b(Object obj) {
        return k.equals(obj) ? 0 : -1;
    }

    @Override // b.i.a.c.Timeline
    public Timeline.b g(int i, Timeline.b bVar, boolean z2) {
        AnimatableValueParser.t(i, 0, 1);
        Object obj = z2 ? k : null;
        long j = this.l;
        Objects.requireNonNull(bVar);
        bVar.f(null, obj, 0, j, 0L, AdPlaybackState.j, false);
        return bVar;
    }

    @Override // b.i.a.c.Timeline
    public int i() {
        return 1;
    }

    @Override // b.i.a.c.Timeline
    public Object m(int i) {
        AnimatableValueParser.t(i, 0, 1);
        return k;
    }

    @Override // b.i.a.c.Timeline
    public Timeline.c o(int i, Timeline.c cVar, long j) {
        AnimatableValueParser.t(i, 0, 1);
        cVar.e(Timeline.c.j, this.o, null, -9223372036854775807L, -9223372036854775807L, -9223372036854775807L, this.n, false, this.p, 0L, this.m, 0, 0, 0L);
        return cVar;
    }

    @Override // b.i.a.c.Timeline
    public int p() {
        return 1;
    }
}
