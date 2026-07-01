package b.i.a.c;

import androidx.annotation.Nullable;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.MediaClock;
import b.i.a.c.f3.StandaloneMediaClock;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.a1, reason: use source file name */
/* JADX INFO: compiled from: DefaultMediaClock.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultMediaClock implements MediaClock {
    public final StandaloneMediaClock j;
    public final a k;

    @Nullable
    public Renderer2 l;

    @Nullable
    public MediaClock m;
    public boolean n = true;
    public boolean o;

    /* JADX INFO: renamed from: b.i.a.c.a1$a */
    /* JADX INFO: compiled from: DefaultMediaClock.java */
    public interface a {
    }

    public DefaultMediaClock(a aVar, Clock4 clock4) {
        this.k = aVar;
        this.j = new StandaloneMediaClock(clock4);
    }

    @Override // b.i.a.c.f3.MediaClock
    public PlaybackParameters c() {
        MediaClock mediaClock = this.m;
        return mediaClock != null ? mediaClock.c() : this.j.n;
    }

    @Override // b.i.a.c.f3.MediaClock
    public long e() {
        if (this.n) {
            return this.j.e();
        }
        MediaClock mediaClock = this.m;
        Objects.requireNonNull(mediaClock);
        return mediaClock.e();
    }

    @Override // b.i.a.c.f3.MediaClock
    public void i(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.m;
        if (mediaClock != null) {
            mediaClock.i(playbackParameters);
            playbackParameters = this.m.c();
        }
        this.j.i(playbackParameters);
    }
}
