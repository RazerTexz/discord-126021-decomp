package b.i.a.c;

import android.content.Context;
import android.os.Looper;
import b.i.a.c.a3.DefaultMediaSourceFactory;
import b.i.a.c.a3.MediaSourceFactory;
import b.i.a.c.c3.DefaultTrackSelector;
import b.i.a.c.c3.TrackSelector;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.e3.DefaultBandwidthMeter;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.Util2;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.a.c.t2.AudioAttributes;
import b.i.a.c.x2.DefaultExtractorsFactory;
import b.i.b.a.Supplier2;
import b.i.b.b.ImmutableList2;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.e1, reason: use source file name */
/* JADX INFO: compiled from: ExoPlayer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface ExoPlayer2 extends Player2 {

    /* JADX INFO: renamed from: b.i.a.c.e1$a */
    /* JADX INFO: compiled from: ExoPlayer.java */
    public interface a {
        void o(boolean z2);

        void x(boolean z2);
    }

    /* JADX INFO: renamed from: b.i.a.c.e1$b */
    /* JADX INFO: compiled from: ExoPlayer.java */
    public static final class b {
        public final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Clock4 f923b;
        public Supplier2<RenderersFactory> c;
        public Supplier2<MediaSourceFactory> d;
        public Supplier2<TrackSelector> e;
        public Supplier2<LoadControl> f;
        public Supplier2<BandwidthMeter> g;
        public Supplier2<AnalyticsCollector> h;
        public Looper i;
        public AudioAttributes j;
        public int k;
        public boolean l;
        public SeekParameters m;
        public long n;
        public long o;
        public LivePlaybackSpeedControl p;
        public long q;
        public long r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public boolean f924s;

        public b(final Context context) {
            Supplier2<RenderersFactory> supplier2 = new Supplier2() { // from class: b.i.a.c.f
                @Override // b.i.b.a.Supplier2
                public final Object get() {
                    return new DefaultRenderersFactory(context);
                }
            };
            Supplier2<MediaSourceFactory> supplier3 = new Supplier2() { // from class: b.i.a.c.h
                @Override // b.i.b.a.Supplier2
                public final Object get() {
                    return new DefaultMediaSourceFactory(context, new DefaultExtractorsFactory());
                }
            };
            Supplier2<TrackSelector> supplier4 = new Supplier2() { // from class: b.i.a.c.g
                @Override // b.i.b.a.Supplier2
                public final Object get() {
                    return new DefaultTrackSelector(context);
                }
            };
            b.i.a.c.a aVar = new Supplier2() { // from class: b.i.a.c.a
                @Override // b.i.b.a.Supplier2
                public final Object get() {
                    return new DefaultLoadControl(new DefaultAllocator(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
                }
            };
            Supplier2<BandwidthMeter> supplier5 = new Supplier2() { // from class: b.i.a.c.e
                @Override // b.i.b.a.Supplier2
                public final Object get() {
                    DefaultBandwidthMeter defaultBandwidthMeter;
                    Context context2 = context;
                    ImmutableList2<Long> immutableList2 = DefaultBandwidthMeter.a;
                    synchronized (DefaultBandwidthMeter.class) {
                        if (DefaultBandwidthMeter.g == null) {
                            DefaultBandwidthMeter.b bVar = new DefaultBandwidthMeter.b(context2);
                            DefaultBandwidthMeter.g = new DefaultBandwidthMeter(bVar.a, bVar.f947b, bVar.c, bVar.d, bVar.e, null);
                        }
                        defaultBandwidthMeter = DefaultBandwidthMeter.g;
                    }
                    return defaultBandwidthMeter;
                }
            };
            this.a = context;
            this.c = supplier2;
            this.d = supplier3;
            this.e = supplier4;
            this.f = aVar;
            this.g = supplier5;
            this.h = new Supplier2() { // from class: b.i.a.c.i
                @Override // b.i.b.a.Supplier2
                public final Object get() {
                    Clock4 clock4 = this.j.f923b;
                    Objects.requireNonNull(clock4);
                    return new AnalyticsCollector(clock4);
                }
            };
            this.i = Util2.o();
            this.j = AudioAttributes.j;
            this.k = 1;
            this.l = true;
            this.m = SeekParameters.f1026b;
            this.n = 5000L;
            this.o = 15000L;
            this.p = new DefaultLivePlaybackSpeedControl(0.97f, 1.03f, 1000L, 1.0E-7f, Util2.B(20L), Util2.B(500L), 0.999f, null);
            this.f923b = Clock4.a;
            this.q = 500L;
            this.r = 2000L;
        }
    }
}
