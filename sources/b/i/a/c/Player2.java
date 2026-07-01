package b.i.a.c;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.b3.Cue;
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.f3.FlagSet;
import b.i.a.c.g3.VideoSize;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.y1, reason: use source file name */
/* JADX INFO: compiled from: Player.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Player2 {

    /* JADX INFO: renamed from: b.i.a.c.y1$b */
    /* JADX INFO: compiled from: Player.java */
    public static final class b implements Bundleable {
        public static final b j = new b(new FlagSet.b().b(), null);
        public final FlagSet k;

        /* JADX INFO: renamed from: b.i.a.c.y1$b$a */
        /* JADX INFO: compiled from: Player.java */
        public static final class a {
            public final FlagSet.b a = new FlagSet.b();

            public a a(b bVar) {
                FlagSet.b bVar2 = this.a;
                FlagSet flagSet = bVar.k;
                Objects.requireNonNull(bVar2);
                for (int i = 0; i < flagSet.c(); i++) {
                    bVar2.a(flagSet.b(i));
                }
                return this;
            }

            public a b(int i, boolean z2) {
                FlagSet.b bVar = this.a;
                Objects.requireNonNull(bVar);
                if (z2) {
                    AnimatableValueParser.D(!bVar.f972b);
                    bVar.a.append(i, true);
                }
                return this;
            }

            public b c() {
                return new b(this.a.b(), null);
            }
        }

        public b(FlagSet flagSet, a aVar) {
            this.k = flagSet;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.k.equals(((b) obj).k);
            }
            return false;
        }

        public int hashCode() {
            return this.k.hashCode();
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.y1$c */
    /* JADX INFO: compiled from: Player.java */
    @Deprecated
    public interface c {
        void A(MediaMetadata mediaMetadata);

        void D(boolean z2);

        void E(Player2 player2, d dVar);

        @Deprecated
        void H(boolean z2, int i);

        void L(int i);

        void M(@Nullable MediaItem2 mediaItem2, int i);

        void W(boolean z2, int i);

        @Deprecated
        void Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray);

        @Deprecated
        void a();

        void b0(PlaybackParameters playbackParameters);

        void f0(@Nullable PlaybackException playbackException);

        void g(f fVar, f fVar2, int i);

        void h(int i);

        @Deprecated
        void i(boolean z2);

        @Deprecated
        void j(int i);

        void j0(boolean z2);

        void p(TracksInfo tracksInfo);

        void r(boolean z2);

        void s(PlaybackException playbackException);

        void t(b bVar);

        void v(Timeline timeline, int i);

        void y(int i);
    }

    /* JADX INFO: renamed from: b.i.a.c.y1$d */
    /* JADX INFO: compiled from: Player.java */
    public static final class d {
        public final FlagSet a;

        public d(FlagSet flagSet) {
            this.a = flagSet;
        }

        public boolean a(int... iArr) {
            FlagSet flagSet = this.a;
            Objects.requireNonNull(flagSet);
            for (int i : iArr) {
                if (flagSet.a(i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.y1$e */
    /* JADX INFO: compiled from: Player.java */
    public interface e extends c {
        void G(int i, boolean z2);

        void a0(int i, int i2);

        void b(Metadata metadata);

        void c();

        void d(boolean z2);

        void e(List<Cue> list);

        void f(VideoSize videoSize);

        void w(float f);

        void z(DeviceInfo2 deviceInfo2);
    }

    /* JADX INFO: renamed from: b.i.a.c.y1$f */
    /* JADX INFO: compiled from: Player.java */
    public static final class f implements Bundleable {

        @Nullable
        public final Object j;
        public final int k;

        @Nullable
        public final MediaItem2 l;

        @Nullable
        public final Object m;
        public final int n;
        public final long o;
        public final long p;
        public final int q;
        public final int r;

        public f(@Nullable Object obj, int i, @Nullable MediaItem2 mediaItem2, @Nullable Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.j = obj;
            this.k = i;
            this.l = mediaItem2;
            this.m = obj2;
            this.n = i2;
            this.o = j;
            this.p = j2;
            this.q = i3;
            this.r = i4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.k == fVar.k && this.n == fVar.n && this.o == fVar.o && this.p == fVar.p && this.q == fVar.q && this.r == fVar.r && b.i.a.f.e.o.f.V(this.j, fVar.j) && b.i.a.f.e.o.f.V(this.m, fVar.m) && b.i.a.f.e.o.f.V(this.l, fVar.l);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.j, Integer.valueOf(this.k), this.l, this.m, Integer.valueOf(this.n), Long.valueOf(this.o), Long.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r)});
        }
    }

    List<Cue> A();

    int B();

    int C();

    boolean D(int i);

    void E(int i);

    void F(@Nullable SurfaceView surfaceView);

    int G();

    TracksInfo H();

    int I();

    long J();

    Timeline K();

    Looper L();

    boolean M();

    long N();

    void O();

    void P();

    void Q(@Nullable TextureView textureView);

    void R();

    MediaMetadata S();

    long T();

    long U();

    void a();

    PlaybackParameters c();

    void d();

    void e();

    boolean f();

    long g();

    void h(int i, long j);

    b i();

    boolean j();

    void k(boolean z2);

    long l();

    int m();

    void n(@Nullable TextureView textureView);

    VideoSize o();

    void p(e eVar);

    int q();

    void r(@Nullable SurfaceView surfaceView);

    void s();

    @Nullable
    PlaybackException t();

    void u(boolean z2);

    long v();

    long w();

    void x(e eVar);

    int y();

    boolean z();
}
