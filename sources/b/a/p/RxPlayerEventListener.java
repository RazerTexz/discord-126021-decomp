package b.a.p;

import b.d.b.a.outline;
import b.i.a.c.DeviceInfo2;
import b.i.a.c.MediaItem2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.PlaybackParameters;
import b.i.a.c.Player;
import b.i.a.c.Player2;
import b.i.a.c.Player3;
import b.i.a.c.Timeline;
import b.i.a.c.TracksInfo;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.g3.VideoSize;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import d0.z.d.Intrinsics3;
import java.util.List;
import rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.p.k, reason: use source file name */
/* JADX INFO: compiled from: RxPlayerEventListener.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RxPlayerEventListener implements Player2.e {
    public final PublishSubject<c> j = PublishSubject.k0();
    public final PublishSubject<a> k = PublishSubject.k0();
    public final PublishSubject<b> l = PublishSubject.k0();

    /* JADX INFO: renamed from: b.a.p.k$a */
    /* JADX INFO: compiled from: RxPlayerEventListener.kt */
    public static final class a {
        public final boolean a;

        public a(boolean z2) {
            this.a = z2;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && this.a == ((a) obj).a;
            }
            return true;
        }

        public int hashCode() {
            boolean z2 = this.a;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return outline.O(outline.U("IsPlayingChange(isPlaying="), this.a, ")");
        }
    }

    /* JADX INFO: renamed from: b.a.p.k$b */
    /* JADX INFO: compiled from: RxPlayerEventListener.kt */
    public static final class b {
        public final PlaybackException a;

        public b(PlaybackException playbackException) {
            Intrinsics3.checkNotNullParameter(playbackException, "exoPlaybackException");
            this.a = playbackException;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && Intrinsics3.areEqual(this.a, ((b) obj).a);
            }
            return true;
        }

        public int hashCode() {
            PlaybackException playbackException = this.a;
            if (playbackException != null) {
                return playbackException.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("PlayerError(exoPlaybackException=");
            sbU.append(this.a);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: b.a.p.k$c */
    /* JADX INFO: compiled from: RxPlayerEventListener.kt */
    public static final class c {
        public final int a;

        public c(int i) {
            this.a = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && this.a == ((c) obj).a;
            }
            return true;
        }

        public int hashCode() {
            return this.a;
        }

        public String toString() {
            return outline.B(outline.U("PlayerStateChange(playbackState="), this.a, ")");
        }
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void A(MediaMetadata mediaMetadata) {
        Player.i(this, mediaMetadata);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void D(boolean z2) {
        Player.t(this, z2);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void E(Player2 player2, Player2.d dVar) {
        Player.e(this, player2, dVar);
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void G(int i, boolean z2) {
        Player.d(this, i, z2);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void H(boolean z2, int i) {
        Player3.k(this, z2, i);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void L(int i) {
        Player.s(this, i);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void M(MediaItem2 mediaItem2, int i) {
        Player.h(this, mediaItem2, i);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void W(boolean z2, int i) {
        Player.k(this, z2, i);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        Player3.r(this, trackGroupArray, trackSelectionArray);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void a() {
        Player3.o(this);
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void a0(int i, int i2) {
        Player.v(this, i, i2);
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void b(Metadata metadata) {
        Player.j(this, metadata);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void b0(PlaybackParameters playbackParameters) {
        Player.l(this, playbackParameters);
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void c() {
        Player.r(this);
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void d(boolean z2) {
        Player.u(this, z2);
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void e(List list) {
        Player.b(this, list);
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void f(VideoSize videoSize) {
        Player.y(this, videoSize);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void f0(PlaybackException playbackException) {
        Player.p(this, playbackException);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void g(Player2.f fVar, Player2.f fVar2, int i) {
        Player.q(this, fVar, fVar2, i);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void h(int i) {
        Player.n(this, i);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void i(boolean z2) {
        Player3.d(this, z2);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void j(int i) {
        Player3.l(this, i);
    }

    @Override // b.i.a.c.Player2.c
    public void j0(boolean z2) {
        PublishSubject<a> publishSubject = this.k;
        publishSubject.k.onNext(new a(z2));
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void p(TracksInfo tracksInfo) {
        Player.x(this, tracksInfo);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void r(boolean z2) {
        Player.f(this, z2);
    }

    @Override // b.i.a.c.Player2.c
    public void s(PlaybackException playbackException) {
        Intrinsics3.checkNotNullParameter(playbackException, "error");
        PublishSubject<b> publishSubject = this.l;
        publishSubject.k.onNext(new b(playbackException));
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void t(Player2.b bVar) {
        Player.a(this, bVar);
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void v(Timeline timeline, int i) {
        Player.w(this, timeline, i);
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void w(float f) {
        Player.z(this, f);
    }

    @Override // b.i.a.c.Player2.c
    public void y(int i) {
        PublishSubject<c> publishSubject = this.j;
        publishSubject.k.onNext(new c(i));
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void z(DeviceInfo2 deviceInfo2) {
        Player.c(this, deviceInfo2);
    }
}
