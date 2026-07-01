package b.i.a.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.core.view.PointerIconCompat;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.DefaultMediaClock;
import b.i.a.c.MediaItem2;
import b.i.a.c.MediaSourceList;
import b.i.a.c.PlayerMessage;
import b.i.a.c.Timeline;
import b.i.a.c.a3.MediaPeriod;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.SampleStream;
import b.i.a.c.a3.SequenceableLoader;
import b.i.a.c.a3.ShuffleOrder;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.b3.TextRenderer;
import b.i.a.c.c3.ExoTrackSelection2;
import b.i.a.c.c3.TrackSelector;
import b.i.a.c.c3.TrackSelectorResult;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.e3.DefaultAllocator;
import b.i.a.c.e3.TransferListener;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.HandlerWrapper;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.MediaClock;
import b.i.a.c.f3.StandaloneMediaClock;
import b.i.a.c.f3.SystemHandlerWrapper;
import b.i.a.c.f3.Util2;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.Collections2;
import b.i.b.b.ImmutableCollection;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.upstream.DataSourceException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: b.i.a.c.h1, reason: use source file name */
/* JADX INFO: compiled from: ExoPlayerImplInternal.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExoPlayerImplInternal2 implements Handler.Callback, MediaPeriod.a, MediaSourceList.d, DefaultMediaClock.a, PlayerMessage.a {
    public final e A;
    public final MediaPeriodQueue B;
    public final MediaSourceList C;
    public final LivePlaybackSpeedControl D;
    public final long E;
    public SeekParameters F;
    public PlaybackInfo G;
    public d H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public int S;

    @Nullable
    public g T;
    public long U;
    public int V;
    public boolean W;

    @Nullable
    public ExoPlaybackException X;
    public final Renderer2[] j;
    public final Set<Renderer2> k;
    public final RendererCapabilities[] l;
    public final TrackSelector m;
    public final TrackSelectorResult n;
    public final LoadControl o;
    public final BandwidthMeter p;
    public final HandlerWrapper q;
    public final HandlerThread r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Looper f1007s;
    public final Timeline.c t;
    public final Timeline.b u;
    public final long v;
    public final boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DefaultMediaClock f1008x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final ArrayList<c> f1009y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Clock4 f1010z;

    /* JADX INFO: renamed from: b.i.a.c.h1$a */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class a {
        public final List<MediaSourceList.c> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ShuffleOrder f1011b;
        public final int c;
        public final long d;

        public a(List list, ShuffleOrder shuffleOrder, int i, long j, ExoPlayerImplInternal exoPlayerImplInternal) {
            this.a = list;
            this.f1011b = shuffleOrder;
            this.c = i;
            this.d = j;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$b */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static class b {
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$c */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class c implements Comparable<c> {
        public final PlayerMessage j;
        public int k;
        public long l;

        @Nullable
        public Object m;

        /* JADX WARN: Code duplicated, block: B:13:0x0017  */
        @Override // java.lang.Comparable
        public int compareTo(c cVar) {
            c cVar2 = cVar;
            Object obj = this.m;
            int i = 1;
            if ((obj == null) != (cVar2.m == null)) {
                if (obj != null) {
                    i = -1;
                }
            } else {
                if (obj == null) {
                    return 0;
                }
                int i2 = this.k - cVar2.k;
                if (i2 != 0) {
                    return i2;
                }
                long j = this.l;
                long j2 = cVar2.l;
                int i3 = Util2.a;
                if (j < j2) {
                    i = -1;
                } else if (j == j2) {
                    i = 0;
                }
            }
            return i;
        }

        public void f(int i, long j, Object obj) {
            this.k = i;
            this.l = j;
            this.m = obj;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$d */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class d {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public PlaybackInfo f1012b;
        public int c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;

        public d(PlaybackInfo playbackInfo) {
            this.f1012b = playbackInfo;
        }

        public void a(int i) {
            this.a |= i > 0;
            this.c += i;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$e */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public interface e {
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$f */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class f {
        public final MediaSource2.a a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1013b;
        public final long c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        public f(MediaSource2.a aVar, long j, long j2, boolean z2, boolean z3, boolean z4) {
            this.a = aVar;
            this.f1013b = j;
            this.c = j2;
            this.d = z2;
            this.e = z3;
            this.f = z4;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.h1$g */
    /* JADX INFO: compiled from: ExoPlayerImplInternal.java */
    public static final class g {
        public final Timeline a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1014b;
        public final long c;

        public g(Timeline timeline, int i, long j) {
            this.a = timeline;
            this.f1014b = i;
            this.c = j;
        }
    }

    public ExoPlayerImplInternal2(Renderer2[] renderer2Arr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i, boolean z2, @Nullable AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j, boolean z3, Looper looper, Clock4 clock4, e eVar) {
        this.A = eVar;
        this.j = renderer2Arr;
        this.m = trackSelector;
        this.n = trackSelectorResult;
        this.o = loadControl;
        this.p = bandwidthMeter;
        this.N = i;
        this.O = z2;
        this.F = seekParameters;
        this.D = livePlaybackSpeedControl;
        this.E = j;
        this.J = z3;
        this.f1010z = clock4;
        this.v = loadControl.b();
        this.w = loadControl.a();
        PlaybackInfo playbackInfoH = PlaybackInfo.h(trackSelectorResult);
        this.G = playbackInfoH;
        this.H = new d(playbackInfoH);
        this.l = new RendererCapabilities[renderer2Arr.length];
        for (int i2 = 0; i2 < renderer2Arr.length; i2++) {
            renderer2Arr[i2].f(i2);
            this.l[i2] = renderer2Arr[i2].m();
        }
        this.f1008x = new DefaultMediaClock(this, clock4);
        this.f1009y = new ArrayList<>();
        this.k = Collections2.c();
        this.t = new Timeline.c();
        this.u = new Timeline.b();
        trackSelector.a = bandwidthMeter;
        this.W = true;
        Handler handler = new Handler(looper);
        this.B = new MediaPeriodQueue(analyticsCollector, handler);
        this.C = new MediaSourceList(this, analyticsCollector, handler);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.r = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.f1007s = looper2;
        this.q = clock4.b(looper2, this);
    }

    public static boolean K(c cVar, Timeline timeline, Timeline timeline2, int i, boolean z2, Timeline.c cVar2, Timeline.b bVar) {
        Object obj = cVar.m;
        if (obj == null) {
            Objects.requireNonNull(cVar.j);
            Objects.requireNonNull(cVar.j);
            long jB = Util2.B(-9223372036854775807L);
            PlayerMessage playerMessage = cVar.j;
            Pair<Object, Long> pairM = M(timeline, new g(playerMessage.d, playerMessage.h, jB), false, i, z2, cVar2, bVar);
            if (pairM == null) {
                return false;
            }
            cVar.f(timeline.b(pairM.first), ((Long) pairM.second).longValue(), pairM.first);
            Objects.requireNonNull(cVar.j);
            return true;
        }
        int iB = timeline.b(obj);
        if (iB == -1) {
            return false;
        }
        Objects.requireNonNull(cVar.j);
        cVar.k = iB;
        timeline2.h(cVar.m, bVar);
        if (bVar.o && timeline2.n(bVar.l, cVar2).B == timeline2.b(cVar.m)) {
            Pair<Object, Long> pairJ = timeline.j(cVar2, bVar, timeline.h(cVar.m, bVar).l, cVar.l + bVar.n);
            cVar.f(timeline.b(pairJ.first), ((Long) pairJ.second).longValue(), pairJ.first);
        }
        return true;
    }

    @Nullable
    public static Pair<Object, Long> M(Timeline timeline, g gVar, boolean z2, int i, boolean z3, Timeline.c cVar, Timeline.b bVar) {
        Object objN;
        Timeline timeline2 = gVar.a;
        if (timeline.q()) {
            return null;
        }
        Timeline timeline3 = timeline2.q() ? timeline : timeline2;
        try {
            Pair<Object, Long> pairJ = timeline3.j(cVar, bVar, gVar.f1014b, gVar.c);
            if (timeline.equals(timeline3)) {
                return pairJ;
            }
            if (timeline.b(pairJ.first) != -1) {
                return (timeline3.h(pairJ.first, bVar).o && timeline3.n(bVar.l, cVar).B == timeline3.b(pairJ.first)) ? timeline.j(cVar, bVar, timeline.h(pairJ.first, bVar).l, gVar.c) : pairJ;
            }
            if (z2 && (objN = N(cVar, bVar, i, z3, pairJ.first, timeline3, timeline)) != null) {
                return timeline.j(cVar, bVar, timeline.h(objN, bVar).l, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    @Nullable
    public static Object N(Timeline.c cVar, Timeline.b bVar, int i, boolean z2, Object obj, Timeline timeline, Timeline timeline2) {
        int iB = timeline.b(obj);
        int i2 = timeline.i();
        int iD = iB;
        int iB2 = -1;
        for (int i3 = 0; i3 < i2 && iB2 == -1; i3++) {
            iD = timeline.d(iD, bVar, cVar, i, z2);
            if (iD == -1) {
                break;
            }
            iB2 = timeline2.b(timeline.m(iD));
        }
        if (iB2 == -1) {
            return null;
        }
        return timeline2.m(iB2);
    }

    public static Format2[] i(ExoTrackSelection2 exoTrackSelection2) {
        int length = exoTrackSelection2 != null ? exoTrackSelection2.length() : 0;
        Format2[] format2Arr = new Format2[length];
        for (int i = 0; i < length; i++) {
            format2Arr[i] = exoTrackSelection2.d(i);
        }
        return format2Arr;
    }

    public static boolean w(Renderer2 renderer2) {
        return renderer2.getState() != 0;
    }

    public static boolean y(PlaybackInfo playbackInfo, Timeline.b bVar) {
        MediaSource2.a aVar = playbackInfo.c;
        Timeline timeline = playbackInfo.f1146b;
        return timeline.q() || timeline.h(aVar.a, bVar).o;
    }

    public final void A() {
        d dVar = this.H;
        PlaybackInfo playbackInfo = this.G;
        boolean z2 = dVar.a | (dVar.f1012b != playbackInfo);
        dVar.a = z2;
        dVar.f1012b = playbackInfo;
        if (z2) {
            ExoPlayerImpl exoPlayerImpl = ((w) this.A).a;
            exoPlayerImpl.g.b(new c0(exoPlayerImpl, dVar));
            this.H = new d(this.G);
        }
    }

    public final void B() throws Throwable {
        r(this.C.c(), true);
    }

    public final void C(b bVar) throws Throwable {
        this.H.a(1);
        MediaSourceList mediaSourceList = this.C;
        Objects.requireNonNull(bVar);
        Objects.requireNonNull(mediaSourceList);
        AnimatableValueParser.j(mediaSourceList.e() >= 0);
        mediaSourceList.i = null;
        r(mediaSourceList.c(), false);
    }

    public final void D() {
        this.H.a(1);
        H(false, false, false, true);
        this.o.c();
        f0(this.G.f1146b.q() ? 4 : 2);
        MediaSourceList mediaSourceList = this.C;
        TransferListener transferListenerC = this.p.c();
        AnimatableValueParser.D(!mediaSourceList.j);
        mediaSourceList.k = transferListenerC;
        for (int i = 0; i < mediaSourceList.a.size(); i++) {
            MediaSourceList.c cVar = mediaSourceList.a.get(i);
            mediaSourceList.g(cVar);
            mediaSourceList.h.add(cVar);
        }
        mediaSourceList.j = true;
        this.q.f(2);
    }

    public final void E() {
        H(true, false, true, false);
        this.o.e();
        f0(1);
        this.r.quit();
        synchronized (this) {
            this.I = true;
            notifyAll();
        }
    }

    public final void F(int i, int i2, ShuffleOrder shuffleOrder) throws Throwable {
        this.H.a(1);
        MediaSourceList mediaSourceList = this.C;
        Objects.requireNonNull(mediaSourceList);
        AnimatableValueParser.j(i >= 0 && i <= i2 && i2 <= mediaSourceList.e());
        mediaSourceList.i = shuffleOrder;
        mediaSourceList.i(i, i2);
        r(mediaSourceList.c(), false);
    }

    public final void G() throws ExoPlaybackException {
        boolean z2;
        float f2 = this.f1008x.c().k;
        MediaPeriodQueue mediaPeriodQueue = this.B;
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.h;
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.i;
        boolean z3 = true;
        for (MediaPeriodHolder mediaPeriodHolder3 = mediaPeriodHolder; mediaPeriodHolder3 != null && mediaPeriodHolder3.d; mediaPeriodHolder3 = mediaPeriodHolder3.l) {
            TrackSelectorResult trackSelectorResultI = mediaPeriodHolder3.i(f2, this.G.f1146b);
            TrackSelectorResult trackSelectorResult = mediaPeriodHolder3.n;
            if (trackSelectorResult == null || trackSelectorResult.c.length != trackSelectorResultI.c.length) {
                z2 = false;
                break;
            }
            int i = 0;
            while (true) {
                if (i >= trackSelectorResultI.c.length) {
                    z2 = true;
                    break;
                } else {
                    if (!trackSelectorResultI.a(trackSelectorResult, i)) {
                        z2 = false;
                        break;
                    }
                    i++;
                }
            }
            if (!z2) {
                if (z3) {
                    MediaPeriodQueue mediaPeriodQueue2 = this.B;
                    MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodQueue2.h;
                    boolean zN = mediaPeriodQueue2.n(mediaPeriodHolder4);
                    boolean[] zArr = new boolean[this.j.length];
                    long jA = mediaPeriodHolder4.a(trackSelectorResultI, this.G.t, zN, zArr);
                    PlaybackInfo playbackInfo = this.G;
                    boolean z4 = (playbackInfo.f == 4 || jA == playbackInfo.t) ? false : true;
                    PlaybackInfo playbackInfo2 = this.G;
                    this.G = u(playbackInfo2.c, jA, playbackInfo2.d, playbackInfo2.e, z4, 5);
                    if (z4) {
                        J(jA);
                    }
                    boolean[] zArr2 = new boolean[this.j.length];
                    int i2 = 0;
                    while (true) {
                        Renderer2[] renderer2Arr = this.j;
                        if (i2 >= renderer2Arr.length) {
                            break;
                        }
                        Renderer2 renderer2 = renderer2Arr[i2];
                        zArr2[i2] = w(renderer2);
                        SampleStream sampleStream = mediaPeriodHolder4.c[i2];
                        if (zArr2[i2]) {
                            if (sampleStream != renderer2.h()) {
                                e(renderer2);
                            } else if (zArr[i2]) {
                                renderer2.u(this.U);
                            }
                        }
                        i2++;
                    }
                    h(zArr2);
                } else {
                    this.B.n(mediaPeriodHolder3);
                    if (mediaPeriodHolder3.d) {
                        mediaPeriodHolder3.a(trackSelectorResultI, Math.max(mediaPeriodHolder3.f.f1058b, this.U - mediaPeriodHolder3.o), false, new boolean[mediaPeriodHolder3.i.length]);
                    }
                }
                q(true);
                if (this.G.f != 4) {
                    z();
                    n0();
                    this.q.f(2);
                    return;
                }
                return;
            }
            if (mediaPeriodHolder3 == mediaPeriodHolder2) {
                z3 = false;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b4 A[PHI: r4 r5 r7
      0x00b4: PHI (r4v4 b.i.a.c.a3.a0$a) = (r4v3 b.i.a.c.a3.a0$a), (r4v10 b.i.a.c.a3.a0$a) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r5v2 long) = (r5v1 long), (r5v7 long) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]
      0x00b4: PHI (r7v3 long) = (r7v2 long), (r7v6 long) binds: [B:33:0x0087, B:35:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    public final void H(boolean z2, boolean z3, boolean z4, boolean z5) {
        MediaSource2.a aVar;
        long j;
        boolean z6;
        List list;
        this.q.h(2);
        this.X = null;
        this.L = false;
        DefaultMediaClock defaultMediaClock = this.f1008x;
        defaultMediaClock.o = false;
        StandaloneMediaClock standaloneMediaClock = defaultMediaClock.j;
        if (standaloneMediaClock.k) {
            standaloneMediaClock.a(standaloneMediaClock.e());
            standaloneMediaClock.k = false;
        }
        this.U = 1000000000000L;
        for (Renderer2 renderer2 : this.j) {
            try {
                e(renderer2);
            } catch (ExoPlaybackException | RuntimeException e2) {
                Log2.b("ExoPlayerImplInternal", "Disable failed.", e2);
            }
        }
        if (z2) {
            for (Renderer2 renderer3 : this.j) {
                if (this.k.remove(renderer3)) {
                    try {
                        renderer3.reset();
                    } catch (RuntimeException e3) {
                        Log2.b("ExoPlayerImplInternal", "Reset failed.", e3);
                    }
                }
            }
        }
        this.S = 0;
        PlaybackInfo playbackInfo = this.G;
        MediaSource2.a aVar2 = playbackInfo.c;
        long jLongValue = playbackInfo.t;
        long j2 = (this.G.c.a() || y(this.G, this.u)) ? this.G.d : this.G.t;
        if (z3) {
            this.T = null;
            Pair<MediaSource2.a, Long> pairL = l(this.G.f1146b);
            aVar2 = (MediaSource2.a) pairL.first;
            jLongValue = ((Long) pairL.second).longValue();
            j2 = -9223372036854775807L;
            if (aVar2.equals(this.G.c)) {
                aVar = aVar2;
                j = jLongValue;
                z6 = false;
            } else {
                z6 = true;
                aVar = aVar2;
                j = jLongValue;
            }
        } else {
            aVar = aVar2;
            j = jLongValue;
            z6 = false;
        }
        this.B.b();
        this.M = false;
        PlaybackInfo playbackInfo2 = this.G;
        Timeline timeline = playbackInfo2.f1146b;
        int i = playbackInfo2.f;
        ExoPlaybackException exoPlaybackException = z5 ? null : playbackInfo2.g;
        TrackGroupArray trackGroupArray = z6 ? TrackGroupArray.j : playbackInfo2.i;
        TrackSelectorResult trackSelectorResult = z6 ? this.n : playbackInfo2.j;
        if (z6) {
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            list = RegularImmutableList.l;
        } else {
            list = playbackInfo2.k;
        }
        this.G = new PlaybackInfo(timeline, aVar, j2, j, i, exoPlaybackException, false, trackGroupArray, trackSelectorResult, list, aVar, playbackInfo2.m, playbackInfo2.n, playbackInfo2.o, j, 0L, j, this.R, false);
        if (z4) {
            MediaSourceList mediaSourceList = this.C;
            for (MediaSourceList.b bVar : mediaSourceList.g.values()) {
                try {
                    bVar.a.a(bVar.f1138b);
                } catch (RuntimeException e4) {
                    Log2.b("MediaSourceList", "Failed to release child source.", e4);
                }
                bVar.a.c(bVar.c);
                bVar.a.g(bVar.c);
            }
            mediaSourceList.g.clear();
            mediaSourceList.h.clear();
            mediaSourceList.j = false;
        }
    }

    public final void I() {
        MediaPeriodHolder mediaPeriodHolder = this.B.h;
        this.K = mediaPeriodHolder != null && mediaPeriodHolder.f.h && this.J;
    }

    public final void J(long j) throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder = this.B.h;
        long j2 = j + (mediaPeriodHolder == null ? 1000000000000L : mediaPeriodHolder.o);
        this.U = j2;
        this.f1008x.j.a(j2);
        for (Renderer2 renderer2 : this.j) {
            if (w(renderer2)) {
                renderer2.u(this.U);
            }
        }
        for (MediaPeriodHolder mediaPeriodHolder2 = this.B.h; mediaPeriodHolder2 != null; mediaPeriodHolder2 = mediaPeriodHolder2.l) {
            for (ExoTrackSelection2 exoTrackSelection2 : mediaPeriodHolder2.n.c) {
                if (exoTrackSelection2 != null) {
                    exoTrackSelection2.j();
                }
            }
        }
    }

    public final void L(Timeline timeline, Timeline timeline2) {
        if (timeline.q() && timeline2.q()) {
            return;
        }
        int size = this.f1009y.size();
        while (true) {
            size--;
            if (size < 0) {
                Collections.sort(this.f1009y);
                return;
            } else if (!K(this.f1009y.get(size), timeline, timeline2, this.N, this.O, this.t, this.u)) {
                this.f1009y.get(size).j.c(false);
                this.f1009y.remove(size);
            }
        }
    }

    public final void O(long j, long j2) {
        this.q.h(2);
        this.q.g(2, j + j2);
    }

    public final void P(boolean z2) throws ExoPlaybackException {
        MediaSource2.a aVar = this.B.h.f.a;
        long jS = S(aVar, this.G.t, true, false);
        if (jS != this.G.t) {
            PlaybackInfo playbackInfo = this.G;
            this.G = u(aVar, jS, playbackInfo.d, playbackInfo.e, z2, 5);
        }
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ab A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b1 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00b7 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c0 A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ca A[Catch: all -> 0x0145, TryCatch #1 {all -> 0x0145, blocks: (B:22:0x00a1, B:24:0x00ab, B:27:0x00b1, B:29:0x00b7, B:30:0x00ba, B:32:0x00c0, B:34:0x00ca, B:36:0x00d0, B:40:0x00d8, B:42:0x00e2, B:44:0x00f2, B:48:0x00fc, B:52:0x010e, B:56:0x0117), top: B:74:0x00a1 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:51:0x010d  */
    /* JADX WARN: Code duplicated, block: B:54:0x0114  */
    /* JADX WARN: Code duplicated, block: B:55:0x0116  */
    /* JADX WARN: Code duplicated, block: B:60:0x0120  */
    public final void Q(g gVar) throws Throwable {
        long jLongValue;
        long j;
        boolean z2;
        MediaSource2.a aVar;
        long j2;
        long j3;
        long j4;
        long jI;
        boolean z3;
        long jR;
        boolean z4;
        long j5;
        MediaPeriodHolder mediaPeriodHolder;
        PlaybackInfo playbackInfo;
        int i;
        this.H.a(1);
        Pair<Object, Long> pairM = M(this.G.f1146b, gVar, true, this.N, this.O, this.t, this.u);
        try {
            if (pairM != null) {
                Object obj = pairM.first;
                jLongValue = ((Long) pairM.second).longValue();
                long j6 = gVar.c == -9223372036854775807L ? -9223372036854775807L : jLongValue;
                MediaSource2.a aVarO = this.B.o(this.G.f1146b, obj, jLongValue);
                if (aVarO.a()) {
                    this.G.f1146b.h(aVarO.a, this.u);
                    j2 = this.u.d(aVarO.f835b) == aVarO.c ? this.u.p.o : 0L;
                    j3 = j6;
                    z2 = true;
                    aVar = aVarO;
                } else {
                    j = j6;
                    z2 = gVar.c == -9223372036854775807L;
                    aVar = aVarO;
                }
                if (this.G.f1146b.q()) {
                    if (pairM == null) {
                        if (this.G.f != 1) {
                            f0(4);
                        }
                        H(false, true, false, true);
                    } else {
                        if (aVar.equals(this.G.c)) {
                            mediaPeriodHolder = this.B.h;
                            if (mediaPeriodHolder == null && mediaPeriodHolder.d && j2 != 0) {
                                jI = mediaPeriodHolder.a.i(j2, this.F);
                            } else {
                                jI = j2;
                            }
                            if (Util2.M(jI) == Util2.M(this.G.t) && ((i = (playbackInfo = this.G).f) == 2 || i == 3)) {
                                long j7 = playbackInfo.t;
                                this.G = u(aVar, j7, j3, j7, z2, 2);
                                return;
                            }
                        } else {
                            jI = j2;
                        }
                        if (this.G.f == 4) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        jR = R(aVar, jI, z3);
                        z4 = (j2 != jR) | z2;
                        try {
                            PlaybackInfo playbackInfo2 = this.G;
                            Timeline timeline = playbackInfo2.f1146b;
                            m0(timeline, aVar, timeline, playbackInfo2.c, j3);
                            z2 = z4;
                            j5 = jR;
                        } catch (Throwable th) {
                            th = th;
                            z2 = z4;
                            j4 = jR;
                            this.G = u(aVar, j4, j3, j4, z2, 2);
                            throw th;
                        }
                    }
                    this.G = u(aVar, j5, j3, j5, z2, 2);
                    return;
                }
                this.T = gVar;
                j5 = j2;
                this.G = u(aVar, j5, j3, j5, z2, 2);
                return;
            }
            Pair<MediaSource2.a, Long> pairL = l(this.G.f1146b);
            aVar = (MediaSource2.a) pairL.first;
            jLongValue = ((Long) pairL.second).longValue();
            z2 = !this.G.f1146b.q();
            j = -9223372036854775807L;
            if (this.G.f1146b.q()) {
                if (pairM == null) {
                    if (this.G.f != 1) {
                        f0(4);
                    }
                    H(false, true, false, true);
                } else {
                    if (aVar.equals(this.G.c)) {
                        mediaPeriodHolder = this.B.h;
                        if (mediaPeriodHolder == null) {
                            jI = j2;
                        } else {
                            jI = j2;
                        }
                        if (Util2.M(jI) == Util2.M(this.G.t)) {
                            long j8 = playbackInfo.t;
                            this.G = u(aVar, j8, j3, j8, z2, 2);
                            return;
                        }
                    } else {
                        jI = j2;
                    }
                    if (this.G.f == 4) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    jR = R(aVar, jI, z3);
                    z4 = (j2 != jR) | z2;
                    PlaybackInfo playbackInfo3 = this.G;
                    Timeline timeline2 = playbackInfo3.f1146b;
                    m0(timeline2, aVar, timeline2, playbackInfo3.c, j3);
                    z2 = z4;
                    j5 = jR;
                }
                this.G = u(aVar, j5, j3, j5, z2, 2);
                return;
            }
            this.T = gVar;
            j5 = j2;
            this.G = u(aVar, j5, j3, j5, z2, 2);
            return;
        } catch (Throwable th2) {
            th = th2;
            j4 = j2;
        }
        j2 = jLongValue;
        j3 = j;
    }

    public final long R(MediaSource2.a aVar, long j, boolean z2) throws ExoPlaybackException {
        MediaPeriodQueue mediaPeriodQueue = this.B;
        return S(aVar, j, mediaPeriodQueue.h != mediaPeriodQueue.i, z2);
    }

    public final long S(MediaSource2.a aVar, long j, boolean z2, boolean z3) throws ExoPlaybackException {
        MediaPeriodQueue mediaPeriodQueue;
        k0();
        this.L = false;
        if (z3 || this.G.f == 3) {
            f0(2);
        }
        MediaPeriodHolder mediaPeriodHolder = this.B.h;
        MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodHolder;
        while (mediaPeriodHolder2 != null && !aVar.equals(mediaPeriodHolder2.f.a)) {
            mediaPeriodHolder2 = mediaPeriodHolder2.l;
        }
        if (z2 || mediaPeriodHolder != mediaPeriodHolder2 || (mediaPeriodHolder2 != null && mediaPeriodHolder2.o + j < 0)) {
            for (Renderer2 renderer2 : this.j) {
                e(renderer2);
            }
            if (mediaPeriodHolder2 != null) {
                while (true) {
                    mediaPeriodQueue = this.B;
                    if (mediaPeriodQueue.h == mediaPeriodHolder2) {
                        break;
                    }
                    mediaPeriodQueue.a();
                }
                mediaPeriodQueue.n(mediaPeriodHolder2);
                mediaPeriodHolder2.o = 1000000000000L;
                g();
            }
        }
        if (mediaPeriodHolder2 != null) {
            this.B.n(mediaPeriodHolder2);
            if (!mediaPeriodHolder2.d) {
                mediaPeriodHolder2.f = mediaPeriodHolder2.f.b(j);
            } else if (mediaPeriodHolder2.e) {
                long jF = mediaPeriodHolder2.a.f(j);
                mediaPeriodHolder2.a.r(jF - this.v, this.w);
                j = jF;
            }
            J(j);
            z();
        } else {
            this.B.b();
            J(j);
        }
        q(false);
        this.q.f(2);
        return j;
    }

    public final void T(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.g != this.f1007s) {
            ((SystemHandlerWrapper.b) this.q.i(15, playerMessage)).b();
            return;
        }
        d(playerMessage);
        int i = this.G.f;
        if (i == 3 || i == 2) {
            this.q.f(2);
        }
    }

    public final void U(final PlayerMessage playerMessage) {
        Looper looper = playerMessage.g;
        if (looper.getThread().isAlive()) {
            this.f1010z.b(looper, null).b(new Runnable() { // from class: b.i.a.c.g0
                @Override // java.lang.Runnable
                public final void run() {
                    ExoPlayerImplInternal2 exoPlayerImplInternal2 = this.j;
                    PlayerMessage playerMessage2 = playerMessage;
                    Objects.requireNonNull(exoPlayerImplInternal2);
                    try {
                        exoPlayerImplInternal2.d(playerMessage2);
                    } catch (ExoPlaybackException e2) {
                        Log2.b("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e2);
                        throw new RuntimeException(e2);
                    }
                }
            });
        } else {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.c(false);
        }
    }

    public final void V(Renderer2 renderer2, long j) {
        renderer2.l();
        if (renderer2 instanceof TextRenderer) {
            TextRenderer textRenderer = (TextRenderer) renderer2;
            AnimatableValueParser.D(textRenderer.f1140s);
            textRenderer.I = j;
        }
    }

    public final void W(boolean z2, @Nullable AtomicBoolean atomicBoolean) {
        if (this.P != z2) {
            this.P = z2;
            if (!z2) {
                for (Renderer2 renderer2 : this.j) {
                    if (!w(renderer2) && this.k.remove(renderer2)) {
                        renderer2.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    public final void X(a aVar) throws Throwable {
        this.H.a(1);
        if (aVar.c != -1) {
            this.T = new g(new PlaylistTimeline(aVar.a, aVar.f1011b), aVar.c, aVar.d);
        }
        MediaSourceList mediaSourceList = this.C;
        List<MediaSourceList.c> list = aVar.a;
        ShuffleOrder shuffleOrder = aVar.f1011b;
        mediaSourceList.i(0, mediaSourceList.a.size());
        r(mediaSourceList.a(mediaSourceList.a.size(), list, shuffleOrder), false);
    }

    public final void Y(boolean z2) {
        if (z2 == this.R) {
            return;
        }
        this.R = z2;
        PlaybackInfo playbackInfo = this.G;
        int i = playbackInfo.f;
        if (z2 || i == 4 || i == 1) {
            this.G = playbackInfo.c(z2);
        } else {
            this.q.f(2);
        }
    }

    public final void Z(boolean z2) throws ExoPlaybackException {
        this.J = z2;
        I();
        if (this.K) {
            MediaPeriodQueue mediaPeriodQueue = this.B;
            if (mediaPeriodQueue.i != mediaPeriodQueue.h) {
                P(true);
                q(false);
            }
        }
    }

    @Override // b.i.a.c.a3.SequenceableLoader.a
    public void a(SequenceableLoader sequenceableLoader) {
        ((SystemHandlerWrapper.b) this.q.i(9, (MediaPeriod) sequenceableLoader)).b();
    }

    public final void a0(boolean z2, int i, boolean z3, int i2) throws ExoPlaybackException {
        this.H.a(z3 ? 1 : 0);
        d dVar = this.H;
        dVar.a = true;
        dVar.f = true;
        dVar.g = i2;
        this.G = this.G.d(z2, i);
        this.L = false;
        for (MediaPeriodHolder mediaPeriodHolder = this.B.h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.l) {
            for (ExoTrackSelection2 exoTrackSelection2 : mediaPeriodHolder.n.c) {
                if (exoTrackSelection2 != null) {
                    exoTrackSelection2.c(z2);
                }
            }
        }
        if (!g0()) {
            k0();
            n0();
            return;
        }
        int i3 = this.G.f;
        if (i3 == 3) {
            i0();
            this.q.f(2);
        } else if (i3 == 2) {
            this.q.f(2);
        }
    }

    @Override // b.i.a.c.a3.MediaPeriod.a
    public void b(MediaPeriod mediaPeriod) {
        ((SystemHandlerWrapper.b) this.q.i(8, mediaPeriod)).b();
    }

    public final void b0(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        this.f1008x.i(playbackParameters);
        PlaybackParameters playbackParametersC = this.f1008x.c();
        t(playbackParametersC, playbackParametersC.k, true, true);
    }

    public final void c(a aVar, int i) throws Throwable {
        this.H.a(1);
        MediaSourceList mediaSourceList = this.C;
        if (i == -1) {
            i = mediaSourceList.e();
        }
        r(mediaSourceList.a(i, aVar.a, aVar.f1011b), false);
    }

    public final void c0(int i) throws ExoPlaybackException {
        this.N = i;
        MediaPeriodQueue mediaPeriodQueue = this.B;
        Timeline timeline = this.G.f1146b;
        mediaPeriodQueue.f = i;
        if (!mediaPeriodQueue.q(timeline)) {
            P(true);
        }
        q(false);
    }

    public final void d(PlayerMessage playerMessage) throws ExoPlaybackException {
        playerMessage.b();
        try {
            playerMessage.a.r(playerMessage.e, playerMessage.f);
        } finally {
            playerMessage.c(true);
        }
    }

    public final void d0(boolean z2) throws ExoPlaybackException {
        this.O = z2;
        MediaPeriodQueue mediaPeriodQueue = this.B;
        Timeline timeline = this.G.f1146b;
        mediaPeriodQueue.g = z2;
        if (!mediaPeriodQueue.q(timeline)) {
            P(true);
        }
        q(false);
    }

    public final void e(Renderer2 renderer2) throws ExoPlaybackException {
        if (renderer2.getState() != 0) {
            DefaultMediaClock defaultMediaClock = this.f1008x;
            if (renderer2 == defaultMediaClock.l) {
                defaultMediaClock.m = null;
                defaultMediaClock.l = null;
                defaultMediaClock.n = true;
            }
            if (renderer2.getState() == 2) {
                renderer2.stop();
            }
            renderer2.g();
            this.S--;
        }
    }

    public final void e0(ShuffleOrder shuffleOrder) throws Throwable {
        this.H.a(1);
        MediaSourceList mediaSourceList = this.C;
        int iE = mediaSourceList.e();
        if (shuffleOrder.b() != iE) {
            shuffleOrder = shuffleOrder.h().f(0, iE);
        }
        mediaSourceList.i = shuffleOrder;
        r(mediaSourceList.c(), false);
    }

    /* JADX WARN: Code duplicated, block: B:297:0x0476  */
    /* JADX WARN: Code duplicated, block: B:303:0x048b  */
    /* JADX WARN: Code duplicated, block: B:313:0x04ab  */
    /* JADX WARN: Code duplicated, block: B:315:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:317:0x04b9  */
    /* JADX WARN: Code duplicated, block: B:319:0x04bd  */
    /* JADX WARN: Code duplicated, block: B:325:0x04d6  */
    /* JADX WARN: Code duplicated, block: B:419:0x04c0 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:315:0x04b1, please report this as an issue */
    public final void f() throws ExoPlaybackException, IOException {
        boolean z2;
        boolean z3;
        boolean z4;
        MediaPeriodHolder mediaPeriodHolder;
        DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl;
        long j;
        long j2;
        int i;
        boolean zX;
        int i2;
        boolean z5;
        boolean z6;
        MediaPeriodHolder mediaPeriodHolder2;
        MediaPeriodHolder mediaPeriodHolder3;
        boolean z7;
        long jA = this.f1010z.a();
        if (!this.G.f1146b.q() && this.C.j) {
            this.B.m(this.U);
            MediaPeriodQueue mediaPeriodQueue = this.B;
            MediaPeriodHolder mediaPeriodHolder4 = mediaPeriodQueue.j;
            if (mediaPeriodHolder4 == null || (!mediaPeriodHolder4.f.i && mediaPeriodHolder4.f() && mediaPeriodQueue.j.f.e != -9223372036854775807L && mediaPeriodQueue.k < 100)) {
                MediaPeriodQueue mediaPeriodQueue2 = this.B;
                long j3 = this.U;
                PlaybackInfo playbackInfo = this.G;
                MediaPeriodHolder mediaPeriodHolder5 = mediaPeriodQueue2.j;
                MediaPeriodInfo mediaPeriodInfoD = mediaPeriodHolder5 == null ? mediaPeriodQueue2.d(playbackInfo.f1146b, playbackInfo.c, playbackInfo.d, playbackInfo.t) : mediaPeriodQueue2.c(playbackInfo.f1146b, mediaPeriodHolder5, j3);
                if (mediaPeriodInfoD != null) {
                    MediaPeriodQueue mediaPeriodQueue3 = this.B;
                    RendererCapabilities[] rendererCapabilitiesArr = this.l;
                    TrackSelector trackSelector = this.m;
                    DefaultAllocator defaultAllocatorH = this.o.h();
                    MediaSourceList mediaSourceList = this.C;
                    TrackSelectorResult trackSelectorResult = this.n;
                    MediaPeriodHolder mediaPeriodHolder6 = mediaPeriodQueue3.j;
                    MediaPeriodHolder mediaPeriodHolder7 = new MediaPeriodHolder(rendererCapabilitiesArr, mediaPeriodHolder6 == null ? 1000000000000L : (mediaPeriodHolder6.o + mediaPeriodHolder6.f.e) - mediaPeriodInfoD.f1058b, trackSelector, defaultAllocatorH, mediaSourceList, mediaPeriodInfoD, trackSelectorResult);
                    MediaPeriodHolder mediaPeriodHolder8 = mediaPeriodQueue3.j;
                    if (mediaPeriodHolder8 == null) {
                        mediaPeriodQueue3.h = mediaPeriodHolder7;
                        mediaPeriodQueue3.i = mediaPeriodHolder7;
                    } else if (mediaPeriodHolder7 != mediaPeriodHolder8.l) {
                        mediaPeriodHolder8.b();
                        mediaPeriodHolder8.l = mediaPeriodHolder7;
                        mediaPeriodHolder8.c();
                    }
                    mediaPeriodQueue3.l = null;
                    mediaPeriodQueue3.j = mediaPeriodHolder7;
                    mediaPeriodQueue3.k++;
                    mediaPeriodQueue3.l();
                    mediaPeriodHolder7.a.l(this, mediaPeriodInfoD.f1058b);
                    if (this.B.h == mediaPeriodHolder7) {
                        J(mediaPeriodInfoD.f1058b);
                    }
                    q(false);
                }
            }
            if (this.M) {
                this.M = v();
                l0();
            } else {
                z();
            }
            MediaPeriodHolder mediaPeriodHolder9 = this.B.i;
            if (mediaPeriodHolder9 != null) {
                if (mediaPeriodHolder9.l != null && !this.K) {
                    if (!mediaPeriodHolder9.d) {
                        z7 = false;
                        break;
                    }
                    int i3 = 0;
                    while (true) {
                        Renderer2[] renderer2Arr = this.j;
                        if (i3 >= renderer2Arr.length) {
                            z7 = true;
                            break;
                        }
                        Renderer2 renderer2 = renderer2Arr[i3];
                        SampleStream sampleStream = mediaPeriodHolder9.c[i3];
                        if (renderer2.h() == sampleStream) {
                            if (sampleStream != null && !renderer2.j()) {
                                MediaPeriodHolder mediaPeriodHolder10 = mediaPeriodHolder9.l;
                                if (!(mediaPeriodHolder9.f.f && mediaPeriodHolder10.d && ((renderer2 instanceof TextRenderer) || renderer2.t() >= mediaPeriodHolder10.e()))) {
                                }
                            }
                            i3++;
                        }
                        z7 = false;
                        break;
                    }
                    if (z7) {
                        MediaPeriodHolder mediaPeriodHolder11 = mediaPeriodHolder9.l;
                        if (mediaPeriodHolder11.d || this.U >= mediaPeriodHolder11.e()) {
                            TrackSelectorResult trackSelectorResult2 = mediaPeriodHolder9.n;
                            MediaPeriodQueue mediaPeriodQueue4 = this.B;
                            MediaPeriodHolder mediaPeriodHolder12 = mediaPeriodQueue4.i;
                            AnimatableValueParser.D((mediaPeriodHolder12 == null || mediaPeriodHolder12.l == null) ? false : true);
                            mediaPeriodQueue4.i = mediaPeriodQueue4.i.l;
                            mediaPeriodQueue4.l();
                            MediaPeriodHolder mediaPeriodHolder13 = mediaPeriodQueue4.i;
                            TrackSelectorResult trackSelectorResult3 = mediaPeriodHolder13.n;
                            if (!mediaPeriodHolder13.d || mediaPeriodHolder13.a.k() == -9223372036854775807L) {
                                for (int i4 = 0; i4 < this.j.length; i4++) {
                                    boolean zB = trackSelectorResult2.b(i4);
                                    boolean zB2 = trackSelectorResult3.b(i4);
                                    if (zB && !this.j[i4].v()) {
                                        boolean z8 = ((BaseRenderer) this.l[i4]).j == -2;
                                        RendererConfiguration rendererConfiguration = trackSelectorResult2.f912b[i4];
                                        RendererConfiguration rendererConfiguration2 = trackSelectorResult3.f912b[i4];
                                        if (!zB2 || !rendererConfiguration2.equals(rendererConfiguration) || z8) {
                                            V(this.j[i4], mediaPeriodHolder13.e());
                                        }
                                    }
                                }
                            } else {
                                long jE = mediaPeriodHolder13.e();
                                for (Renderer2 renderer3 : this.j) {
                                    if (renderer3.h() != null) {
                                        V(renderer3, jE);
                                    }
                                }
                            }
                        }
                    }
                } else if (mediaPeriodHolder9.f.i || this.K) {
                    int i5 = 0;
                    while (true) {
                        Renderer2[] renderer2Arr2 = this.j;
                        if (i5 >= renderer2Arr2.length) {
                            break;
                        }
                        Renderer2 renderer4 = renderer2Arr2[i5];
                        SampleStream sampleStream2 = mediaPeriodHolder9.c[i5];
                        if (sampleStream2 != null && renderer4.h() == sampleStream2 && renderer4.j()) {
                            long j4 = mediaPeriodHolder9.f.e;
                            V(renderer4, (j4 == -9223372036854775807L || j4 == Long.MIN_VALUE) ? -9223372036854775807L : j4 + mediaPeriodHolder9.o);
                        }
                        i5++;
                    }
                }
            }
            MediaPeriodQueue mediaPeriodQueue5 = this.B;
            MediaPeriodHolder mediaPeriodHolder14 = mediaPeriodQueue5.i;
            if (mediaPeriodHolder14 != null && mediaPeriodQueue5.h != mediaPeriodHolder14 && !mediaPeriodHolder14.g) {
                TrackSelectorResult trackSelectorResult4 = mediaPeriodHolder14.n;
                int i6 = 0;
                boolean z9 = false;
                while (true) {
                    Renderer2[] renderer2Arr3 = this.j;
                    if (i6 >= renderer2Arr3.length) {
                        break;
                    }
                    Renderer2 renderer5 = renderer2Arr3[i6];
                    if (w(renderer5)) {
                        boolean z10 = renderer5.h() != mediaPeriodHolder14.c[i6];
                        if (!trackSelectorResult4.b(i6) || z10) {
                            if (!renderer5.v()) {
                                renderer5.k(i(trackSelectorResult4.c[i6]), mediaPeriodHolder14.c[i6], mediaPeriodHolder14.e(), mediaPeriodHolder14.o);
                            } else if (renderer5.b()) {
                                e(renderer5);
                            } else {
                                z9 = true;
                            }
                        }
                    }
                    i6++;
                }
                if (!z9) {
                    g();
                }
            }
            boolean z11 = false;
            while (true) {
                if (!(g0() && !this.K && (mediaPeriodHolder2 = this.B.h) != null && (mediaPeriodHolder3 = mediaPeriodHolder2.l) != null && this.U >= mediaPeriodHolder3.e() && mediaPeriodHolder3.g)) {
                    break;
                }
                if (z11) {
                    A();
                }
                MediaPeriodQueue mediaPeriodQueue6 = this.B;
                MediaPeriodHolder mediaPeriodHolder15 = mediaPeriodQueue6.h;
                MediaPeriodHolder mediaPeriodHolderA = mediaPeriodQueue6.a();
                MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolderA.f;
                MediaSource2.a aVar = mediaPeriodInfo.a;
                long j5 = mediaPeriodInfo.f1058b;
                PlaybackInfo playbackInfoU = u(aVar, j5, mediaPeriodInfo.c, j5, true, 0);
                this.G = playbackInfoU;
                Timeline timeline = playbackInfoU.f1146b;
                m0(timeline, mediaPeriodHolderA.f.a, timeline, mediaPeriodHolder15.f.a, -9223372036854775807L);
                I();
                n0();
                z11 = true;
            }
        }
        int i7 = this.G.f;
        if (i7 == 1 || i7 == 4) {
            this.q.h(2);
            return;
        }
        MediaPeriodHolder mediaPeriodHolder16 = this.B.h;
        if (mediaPeriodHolder16 == null) {
            O(jA, 10L);
            return;
        }
        AnimatableValueParser.f("doSomeWork");
        n0();
        if (mediaPeriodHolder16.d) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            mediaPeriodHolder16.a.r(this.G.t - this.v, this.w);
            boolean z12 = true;
            z2 = true;
            int i8 = 0;
            while (true) {
                Renderer2[] renderer2Arr4 = this.j;
                if (i8 >= renderer2Arr4.length) {
                    break;
                }
                Renderer2 renderer6 = renderer2Arr4[i8];
                if (w(renderer6)) {
                    renderer6.q(this.U, jElapsedRealtime);
                    boolean z13 = z12 && renderer6.b();
                    boolean z14 = mediaPeriodHolder16.c[i8] != renderer6.h();
                    boolean z15 = z14 || (!z14 && renderer6.j()) || renderer6.d() || renderer6.b();
                    boolean z16 = z2 && z15;
                    if (!z15) {
                        renderer6.s();
                    }
                    z2 = z16;
                    z12 = z13;
                }
                i8++;
            }
            z3 = z12;
        } else {
            mediaPeriodHolder16.a.e();
            z2 = true;
            z3 = true;
        }
        long j6 = mediaPeriodHolder16.f.e;
        boolean z17 = z3 && mediaPeriodHolder16.d && (j6 == -9223372036854775807L || j6 <= this.G.t);
        if (z17 && this.K) {
            z4 = false;
            this.K = false;
            a0(false, this.G.n, false, 5);
        } else {
            z4 = false;
        }
        if (z17 && mediaPeriodHolder16.f.i) {
            f0(4);
            k0();
        } else {
            PlaybackInfo playbackInfo2 = this.G;
            if (playbackInfo2.f == 2) {
                if (this.S == 0) {
                    zX = x();
                } else if (z2) {
                    if (playbackInfo2.h) {
                        long j7 = h0(playbackInfo2.f1146b, this.B.h.f.a) ? ((DefaultLivePlaybackSpeedControl) this.D).i : -9223372036854775807L;
                        MediaPeriodHolder mediaPeriodHolder17 = this.B.j;
                        boolean z18 = mediaPeriodHolder17.f() && mediaPeriodHolder17.f.i;
                        boolean z19 = mediaPeriodHolder17.f.a.a() && !mediaPeriodHolder17.d;
                        if (!z18 && !z19 && !this.o.f(m(), this.f1008x.c().k, this.L, j7)) {
                            zX = false;
                        }
                    }
                    zX = true;
                } else {
                    zX = false;
                }
                if (zX) {
                    f0(3);
                    this.X = null;
                    if (g0()) {
                        i0();
                    }
                } else if (this.G.f == 3) {
                    this.L = g0();
                    f0(2);
                    if (this.L) {
                        for (mediaPeriodHolder = this.B.h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.l) {
                            for (ExoTrackSelection2 exoTrackSelection2 : mediaPeriodHolder.n.c) {
                                if (exoTrackSelection2 != null) {
                                    exoTrackSelection2.k();
                                }
                            }
                        }
                        defaultLivePlaybackSpeedControl = (DefaultLivePlaybackSpeedControl) this.D;
                        j = defaultLivePlaybackSpeedControl.i;
                        if (j != -9223372036854775807L) {
                            long j8 = j + defaultLivePlaybackSpeedControl.f1302b;
                            defaultLivePlaybackSpeedControl.i = j8;
                            j2 = defaultLivePlaybackSpeedControl.h;
                            if (j2 != -9223372036854775807L) {
                                defaultLivePlaybackSpeedControl.i = j2;
                            }
                            defaultLivePlaybackSpeedControl.m = -9223372036854775807L;
                        }
                    }
                    k0();
                }
            } else if (this.G.f == 3 && (this.S != 0 ? !z2 : !x())) {
                this.L = g0();
                f0(2);
                if (this.L) {
                    while (mediaPeriodHolder != null) {
                        while (i < r7) {
                            if (exoTrackSelection2 != null) {
                                exoTrackSelection2.k();
                            }
                        }
                    }
                    defaultLivePlaybackSpeedControl = (DefaultLivePlaybackSpeedControl) this.D;
                    j = defaultLivePlaybackSpeedControl.i;
                    if (j != -9223372036854775807L) {
                        long j9 = j + defaultLivePlaybackSpeedControl.f1302b;
                        defaultLivePlaybackSpeedControl.i = j9;
                        j2 = defaultLivePlaybackSpeedControl.h;
                        if (j2 != -9223372036854775807L && j9 > j2) {
                            defaultLivePlaybackSpeedControl.i = j2;
                        }
                        defaultLivePlaybackSpeedControl.m = -9223372036854775807L;
                    }
                }
                k0();
            }
        }
        if (this.G.f == 2) {
            int i9 = 0;
            while (true) {
                Renderer2[] renderer2Arr5 = this.j;
                if (i9 >= renderer2Arr5.length) {
                    break;
                }
                if (w(renderer2Arr5[i9]) && this.j[i9].h() == mediaPeriodHolder16.c[i9]) {
                    this.j[i9].s();
                }
                i9++;
            }
            PlaybackInfo playbackInfo3 = this.G;
            if (!playbackInfo3.h && playbackInfo3.f1147s < 500000 && v()) {
                throw new IllegalStateException("Playback stuck buffering and not loading");
            }
        }
        boolean z20 = this.R;
        PlaybackInfo playbackInfo4 = this.G;
        if (z20 != playbackInfo4.p) {
            this.G = playbackInfo4.c(z20);
        }
        if ((g0() && this.G.f == 3) || (i2 = this.G.f) == 2) {
            if (this.R && this.Q) {
                z6 = false;
            } else {
                this.q.h(2);
                this.q.g(2, jA + 10);
                z6 = true;
            }
            z5 = !z6;
        } else {
            if (this.S == 0 || i2 == 4) {
                this.q.h(2);
            } else {
                O(jA, 1000L);
            }
            z5 = false;
        }
        PlaybackInfo playbackInfo5 = this.G;
        if (playbackInfo5.q != z5) {
            this.G = new PlaybackInfo(playbackInfo5.f1146b, playbackInfo5.c, playbackInfo5.d, playbackInfo5.e, playbackInfo5.f, playbackInfo5.g, playbackInfo5.h, playbackInfo5.i, playbackInfo5.j, playbackInfo5.k, playbackInfo5.l, playbackInfo5.m, playbackInfo5.n, playbackInfo5.o, playbackInfo5.r, playbackInfo5.f1147s, playbackInfo5.t, playbackInfo5.p, z5);
        }
        this.Q = z4;
        AnimatableValueParser.d0();
    }

    public final void f0(int i) {
        PlaybackInfo playbackInfo = this.G;
        if (playbackInfo.f != i) {
            this.G = playbackInfo.f(i);
        }
    }

    public final void g() throws ExoPlaybackException {
        h(new boolean[this.j.length]);
    }

    public final boolean g0() {
        PlaybackInfo playbackInfo = this.G;
        return playbackInfo.m && playbackInfo.n == 0;
    }

    public final void h(boolean[] zArr) throws ExoPlaybackException {
        MediaClock mediaClock;
        MediaPeriodHolder mediaPeriodHolder = this.B.i;
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.n;
        for (int i = 0; i < this.j.length; i++) {
            if (!trackSelectorResult.b(i) && this.k.remove(this.j[i])) {
                this.j[i].reset();
            }
        }
        for (int i2 = 0; i2 < this.j.length; i2++) {
            if (trackSelectorResult.b(i2)) {
                boolean z2 = zArr[i2];
                Renderer2 renderer2 = this.j[i2];
                if (w(renderer2)) {
                    continue;
                } else {
                    MediaPeriodQueue mediaPeriodQueue = this.B;
                    MediaPeriodHolder mediaPeriodHolder2 = mediaPeriodQueue.i;
                    boolean z3 = mediaPeriodHolder2 == mediaPeriodQueue.h;
                    TrackSelectorResult trackSelectorResult2 = mediaPeriodHolder2.n;
                    RendererConfiguration rendererConfiguration = trackSelectorResult2.f912b[i2];
                    Format2[] format2ArrI = i(trackSelectorResult2.c[i2]);
                    boolean z4 = g0() && this.G.f == 3;
                    boolean z5 = !z2 && z4;
                    this.S++;
                    this.k.add(renderer2);
                    renderer2.o(rendererConfiguration, format2ArrI, mediaPeriodHolder2.c[i2], this.U, z5, z3, mediaPeriodHolder2.e(), mediaPeriodHolder2.o);
                    renderer2.r(11, new ExoPlayerImplInternal(this));
                    DefaultMediaClock defaultMediaClock = this.f1008x;
                    Objects.requireNonNull(defaultMediaClock);
                    MediaClock mediaClockW = renderer2.w();
                    if (mediaClockW != null && mediaClockW != (mediaClock = defaultMediaClock.m)) {
                        if (mediaClock != null) {
                            throw ExoPlaybackException.b(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
                        }
                        defaultMediaClock.m = mediaClockW;
                        defaultMediaClock.l = renderer2;
                        mediaClockW.i(defaultMediaClock.j.n);
                    }
                    if (z4) {
                        renderer2.start();
                    }
                }
            }
        }
        mediaPeriodHolder.g = true;
    }

    public final boolean h0(Timeline timeline, MediaSource2.a aVar) {
        if (aVar.a() || timeline.q()) {
            return false;
        }
        timeline.n(timeline.h(aVar.a, this.u).l, this.t);
        if (!this.t.c()) {
            return false;
        }
        Timeline.c cVar = this.t;
        return cVar.v && cVar.f1042s != -9223372036854775807L;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) throws Throwable {
        MediaPeriodHolder mediaPeriodHolder;
        int i = 1000;
        try {
            switch (message.what) {
                case 0:
                    D();
                    break;
                case 1:
                    a0(message.arg1 != 0, message.arg2, true, 1);
                    break;
                case 2:
                    f();
                    break;
                case 3:
                    Q((g) message.obj);
                    break;
                case 4:
                    b0((PlaybackParameters) message.obj);
                    break;
                case 5:
                    this.F = (SeekParameters) message.obj;
                    break;
                case 6:
                    j0(false, true);
                    break;
                case 7:
                    E();
                    return true;
                case 8:
                    s((MediaPeriod) message.obj);
                    break;
                case 9:
                    o((MediaPeriod) message.obj);
                    break;
                case 10:
                    G();
                    break;
                case 11:
                    c0(message.arg1);
                    break;
                case 12:
                    d0(message.arg1 != 0);
                    break;
                case 13:
                    W(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 14:
                    PlayerMessage playerMessage = (PlayerMessage) message.obj;
                    Objects.requireNonNull(playerMessage);
                    T(playerMessage);
                    break;
                case 15:
                    U((PlayerMessage) message.obj);
                    break;
                case 16:
                    PlaybackParameters playbackParameters = (PlaybackParameters) message.obj;
                    t(playbackParameters, playbackParameters.k, true, false);
                    break;
                case 17:
                    X((a) message.obj);
                    break;
                case 18:
                    c((a) message.obj, message.arg1);
                    break;
                case 19:
                    C((b) message.obj);
                    break;
                case 20:
                    F(message.arg1, message.arg2, (ShuffleOrder) message.obj);
                    break;
                case 21:
                    e0((ShuffleOrder) message.obj);
                    break;
                case 22:
                    B();
                    break;
                case 23:
                    Z(message.arg1 != 0);
                    break;
                case 24:
                    Y(message.arg1 == 1);
                    break;
                case 25:
                    P(true);
                    break;
                default:
                    return false;
            }
        } catch (ExoPlaybackException e2) {
            e = e2;
            if (e.type == 1 && (mediaPeriodHolder = this.B.i) != null) {
                e = e.a(mediaPeriodHolder.f.a);
            }
            if (e.isRecoverable && this.X == null) {
                Log2.c("ExoPlayerImplInternal", "Recoverable renderer error", e);
                this.X = e;
                HandlerWrapper handlerWrapper = this.q;
                handlerWrapper.d(handlerWrapper.i(25, e));
            } else {
                ExoPlaybackException exoPlaybackException = this.X;
                if (exoPlaybackException != null) {
                    exoPlaybackException.addSuppressed(e);
                    e = this.X;
                }
                Log2.b("ExoPlayerImplInternal", "Playback error", e);
                j0(true, false);
                this.G = this.G.e(e);
            }
        } catch (ParserException e3) {
            int i2 = e3.dataType;
            if (i2 == 1) {
                i = e3.contentIsMalformed ? 3001 : 3003;
            } else if (i2 == 4) {
                i = e3.contentIsMalformed ? 3002 : 3004;
            }
            p(e3, i);
        } catch (DrmSession.DrmSessionException e4) {
            p(e4, e4.errorCode);
        } catch (BehindLiveWindowException e5) {
            p(e5, PointerIconCompat.TYPE_HAND);
        } catch (DataSourceException e6) {
            p(e6, e6.reason);
        } catch (IOException e7) {
            p(e7, 2000);
        } catch (RuntimeException e8) {
            ExoPlaybackException exoPlaybackExceptionB = ExoPlaybackException.b(e8, ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) ? PointerIconCompat.TYPE_WAIT : 1000);
            Log2.b("ExoPlayerImplInternal", "Playback error", exoPlaybackExceptionB);
            j0(true, false);
            this.G = this.G.e(exoPlaybackExceptionB);
        }
        A();
        return true;
    }

    public final void i0() throws ExoPlaybackException {
        this.L = false;
        DefaultMediaClock defaultMediaClock = this.f1008x;
        defaultMediaClock.o = true;
        defaultMediaClock.j.b();
        for (Renderer2 renderer2 : this.j) {
            if (w(renderer2)) {
                renderer2.start();
            }
        }
    }

    public final long j(Timeline timeline, Object obj, long j) {
        timeline.n(timeline.h(obj, this.u).l, this.t);
        Timeline.c cVar = this.t;
        if (cVar.f1042s != -9223372036854775807L && cVar.c()) {
            Timeline.c cVar2 = this.t;
            if (cVar2.v) {
                long j2 = cVar2.t;
                int i = Util2.a;
                return Util2.B((j2 == -9223372036854775807L ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - this.t.f1042s) - (j + this.u.n);
            }
        }
        return -9223372036854775807L;
    }

    public final void j0(boolean z2, boolean z3) {
        H(z2 || !this.P, false, true, false);
        this.H.a(z3 ? 1 : 0);
        this.o.i();
        f0(1);
    }

    public final long k() {
        MediaPeriodHolder mediaPeriodHolder = this.B.i;
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        long jMax = mediaPeriodHolder.o;
        if (!mediaPeriodHolder.d) {
            return jMax;
        }
        int i = 0;
        while (true) {
            Renderer2[] renderer2Arr = this.j;
            if (i >= renderer2Arr.length) {
                return jMax;
            }
            if (w(renderer2Arr[i]) && this.j[i].h() == mediaPeriodHolder.c[i]) {
                long jT = this.j[i].t();
                if (jT == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                jMax = Math.max(jT, jMax);
            }
            i++;
        }
    }

    public final void k0() throws ExoPlaybackException {
        DefaultMediaClock defaultMediaClock = this.f1008x;
        defaultMediaClock.o = false;
        StandaloneMediaClock standaloneMediaClock = defaultMediaClock.j;
        if (standaloneMediaClock.k) {
            standaloneMediaClock.a(standaloneMediaClock.e());
            standaloneMediaClock.k = false;
        }
        for (Renderer2 renderer2 : this.j) {
            if (w(renderer2) && renderer2.getState() == 2) {
                renderer2.stop();
            }
        }
    }

    public final Pair<MediaSource2.a, Long> l(Timeline timeline) {
        if (timeline.q()) {
            MediaSource2.a aVar = PlaybackInfo.a;
            return Pair.create(PlaybackInfo.a, 0L);
        }
        Pair<Object, Long> pairJ = timeline.j(this.t, this.u, timeline.a(this.O), -9223372036854775807L);
        MediaSource2.a aVarO = this.B.o(timeline, pairJ.first, 0L);
        long jLongValue = ((Long) pairJ.second).longValue();
        if (aVarO.a()) {
            timeline.h(aVarO.a, this.u);
            jLongValue = aVarO.c == this.u.d(aVarO.f835b) ? this.u.p.o : 0L;
        }
        return Pair.create(aVarO, Long.valueOf(jLongValue));
    }

    public final void l0() {
        MediaPeriodHolder mediaPeriodHolder = this.B.j;
        boolean z2 = this.M || (mediaPeriodHolder != null && mediaPeriodHolder.a.h());
        PlaybackInfo playbackInfo = this.G;
        if (z2 != playbackInfo.h) {
            this.G = new PlaybackInfo(playbackInfo.f1146b, playbackInfo.c, playbackInfo.d, playbackInfo.e, playbackInfo.f, playbackInfo.g, z2, playbackInfo.i, playbackInfo.j, playbackInfo.k, playbackInfo.l, playbackInfo.m, playbackInfo.n, playbackInfo.o, playbackInfo.r, playbackInfo.f1147s, playbackInfo.t, playbackInfo.p, playbackInfo.q);
        }
    }

    public final long m() {
        return n(this.G.r);
    }

    public final void m0(Timeline timeline, MediaSource2.a aVar, Timeline timeline2, MediaSource2.a aVar2, long j) {
        if (timeline.q() || !h0(timeline, aVar)) {
            float f2 = this.f1008x.c().k;
            PlaybackParameters playbackParameters = this.G.o;
            if (f2 != playbackParameters.k) {
                this.f1008x.i(playbackParameters);
                return;
            }
            return;
        }
        timeline.n(timeline.h(aVar.a, this.u).l, this.t);
        LivePlaybackSpeedControl livePlaybackSpeedControl = this.D;
        MediaItem2.g gVar = this.t.f1043x;
        int i = Util2.a;
        DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = (DefaultLivePlaybackSpeedControl) livePlaybackSpeedControl;
        Objects.requireNonNull(defaultLivePlaybackSpeedControl);
        defaultLivePlaybackSpeedControl.d = Util2.B(gVar.l);
        defaultLivePlaybackSpeedControl.g = Util2.B(gVar.m);
        defaultLivePlaybackSpeedControl.h = Util2.B(gVar.n);
        float f3 = gVar.o;
        if (f3 == -3.4028235E38f) {
            f3 = 0.97f;
        }
        defaultLivePlaybackSpeedControl.k = f3;
        float f4 = gVar.p;
        if (f4 == -3.4028235E38f) {
            f4 = 1.03f;
        }
        defaultLivePlaybackSpeedControl.j = f4;
        defaultLivePlaybackSpeedControl.a();
        if (j != -9223372036854775807L) {
            DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl2 = (DefaultLivePlaybackSpeedControl) this.D;
            defaultLivePlaybackSpeedControl2.e = j(timeline, aVar.a, j);
            defaultLivePlaybackSpeedControl2.a();
        } else {
            if (Util2.a(timeline2.q() ? null : timeline2.n(timeline2.h(aVar2.a, this.u).l, this.t).n, this.t.n)) {
                return;
            }
            DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl3 = (DefaultLivePlaybackSpeedControl) this.D;
            defaultLivePlaybackSpeedControl3.e = -9223372036854775807L;
            defaultLivePlaybackSpeedControl3.a();
        }
    }

    public final long n(long j) {
        MediaPeriodHolder mediaPeriodHolder = this.B.j;
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.U - mediaPeriodHolder.o));
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c3  */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0166, code lost:
    
        r6 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void n0() throws ExoPlaybackException {
        PlaybackParameters playbackParametersC;
        StandaloneMediaClock standaloneMediaClock;
        long j;
        ExoPlayerImplInternal2 exoPlayerImplInternal2;
        c cVar;
        MediaPeriodHolder mediaPeriodHolder = this.B.h;
        if (mediaPeriodHolder == null) {
            return;
        }
        long jK = mediaPeriodHolder.d ? mediaPeriodHolder.a.k() : -9223372036854775807L;
        if (jK != -9223372036854775807L) {
            J(jK);
            if (jK != this.G.t) {
                PlaybackInfo playbackInfo = this.G;
                this.G = u(playbackInfo.c, jK, playbackInfo.d, jK, true, 5);
            }
        } else {
            DefaultMediaClock defaultMediaClock = this.f1008x;
            boolean z2 = mediaPeriodHolder != this.B.i;
            Renderer2 renderer2 = defaultMediaClock.l;
            if (renderer2 == null || renderer2.b() || (!defaultMediaClock.l.d() && (z2 || defaultMediaClock.l.j()))) {
                defaultMediaClock.n = true;
                if (defaultMediaClock.o) {
                    defaultMediaClock.j.b();
                }
            } else {
                MediaClock mediaClock = defaultMediaClock.m;
                Objects.requireNonNull(mediaClock);
                long jE = mediaClock.e();
                if (!defaultMediaClock.n) {
                    defaultMediaClock.j.a(jE);
                    playbackParametersC = mediaClock.c();
                    if (!playbackParametersC.equals(defaultMediaClock.j.n)) {
                        standaloneMediaClock = defaultMediaClock.j;
                        if (standaloneMediaClock.k) {
                            standaloneMediaClock.a(standaloneMediaClock.e());
                        }
                        standaloneMediaClock.n = playbackParametersC;
                        ((SystemHandlerWrapper.b) ((ExoPlayerImplInternal2) defaultMediaClock.k).q.i(16, playbackParametersC)).b();
                    }
                } else if (jE < defaultMediaClock.j.e()) {
                    StandaloneMediaClock standaloneMediaClock2 = defaultMediaClock.j;
                    if (standaloneMediaClock2.k) {
                        standaloneMediaClock2.a(standaloneMediaClock2.e());
                        standaloneMediaClock2.k = false;
                    }
                } else {
                    defaultMediaClock.n = false;
                    if (defaultMediaClock.o) {
                        defaultMediaClock.j.b();
                    }
                    defaultMediaClock.j.a(jE);
                    playbackParametersC = mediaClock.c();
                    if (!playbackParametersC.equals(defaultMediaClock.j.n)) {
                        standaloneMediaClock = defaultMediaClock.j;
                        if (standaloneMediaClock.k) {
                            standaloneMediaClock.a(standaloneMediaClock.e());
                        }
                        standaloneMediaClock.n = playbackParametersC;
                        ((SystemHandlerWrapper.b) ((ExoPlayerImplInternal2) defaultMediaClock.k).q.i(16, playbackParametersC)).b();
                    }
                }
            }
            long jE2 = defaultMediaClock.e();
            this.U = jE2;
            long j2 = jE2 - mediaPeriodHolder.o;
            long j3 = this.G.t;
            if (!this.f1009y.isEmpty() && !this.G.c.a()) {
                if (this.W) {
                    j3--;
                    this.W = false;
                }
                PlaybackInfo playbackInfo2 = this.G;
                int iB = playbackInfo2.f1146b.b(playbackInfo2.c.a);
                int iMin = Math.min(this.V, this.f1009y.size());
                if (iMin > 0) {
                    cVar = this.f1009y.get(iMin - 1);
                    j = j2;
                    exoPlayerImplInternal2 = this;
                } else {
                    j = j2;
                    exoPlayerImplInternal2 = this;
                    cVar = null;
                }
                while (cVar != null) {
                    int i = cVar.k;
                    if (i <= iB && (i != iB || cVar.l <= j3)) {
                        break;
                    }
                    iMin--;
                    if (iMin > 0) {
                        cVar = exoPlayerImplInternal2.f1009y.get(iMin - 1);
                    } else {
                        j = j;
                        exoPlayerImplInternal2 = exoPlayerImplInternal2;
                        cVar = null;
                    }
                }
                if (iMin < exoPlayerImplInternal2.f1009y.size()) {
                    c cVar2 = exoPlayerImplInternal2.f1009y.get(iMin);
                    while (cVar2 != null && cVar2.m != null) {
                        int i2 = cVar2.k;
                        if (i2 >= iB && (i2 != iB || cVar2.l > j3)) {
                            break;
                        }
                        iMin++;
                        cVar2 = iMin < exoPlayerImplInternal2.f1009y.size() ? exoPlayerImplInternal2.f1009y.get(iMin) : null;
                    }
                    while (cVar2 != null && cVar2.m != null && cVar2.k == iB) {
                        long j4 = cVar2.l;
                        if (j4 <= j3 || j4 > j) {
                            break;
                        }
                        try {
                            exoPlayerImplInternal2.T(cVar2.j);
                            Objects.requireNonNull(cVar2.j);
                            exoPlayerImplInternal2.f1009y.remove(iMin);
                            cVar2 = iMin < exoPlayerImplInternal2.f1009y.size() ? exoPlayerImplInternal2.f1009y.get(iMin) : null;
                        } catch (Throwable th) {
                            Objects.requireNonNull(cVar2.j);
                            exoPlayerImplInternal2.f1009y.remove(iMin);
                            throw th;
                        }
                    }
                    exoPlayerImplInternal2.V = iMin;
                }
            }
            this.G.t = j2;
        }
        this.G.r = this.B.j.d();
        this.G.f1147s = m();
        PlaybackInfo playbackInfo3 = this.G;
        if (playbackInfo3.m && playbackInfo3.f == 3 && h0(playbackInfo3.f1146b, playbackInfo3.c)) {
            PlaybackInfo playbackInfo4 = this.G;
            float f2 = 1.0f;
            if (playbackInfo4.o.k == 1.0f) {
                LivePlaybackSpeedControl livePlaybackSpeedControl = this.D;
                long j5 = j(playbackInfo4.f1146b, playbackInfo4.c.a, playbackInfo4.t);
                long jM = m();
                DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = (DefaultLivePlaybackSpeedControl) livePlaybackSpeedControl;
                if (defaultLivePlaybackSpeedControl.d != -9223372036854775807L) {
                    long j6 = j5 - jM;
                    long j7 = defaultLivePlaybackSpeedControl.n;
                    if (j7 == -9223372036854775807L) {
                        defaultLivePlaybackSpeedControl.n = j6;
                        defaultLivePlaybackSpeedControl.o = 0L;
                    } else {
                        float f3 = defaultLivePlaybackSpeedControl.c;
                        long jMax = Math.max(j6, (long) (((1.0f - f3) * j6) + (j7 * f3)));
                        defaultLivePlaybackSpeedControl.n = jMax;
                        long jAbs = Math.abs(j6 - jMax);
                        long j8 = defaultLivePlaybackSpeedControl.o;
                        float f4 = defaultLivePlaybackSpeedControl.c;
                        defaultLivePlaybackSpeedControl.o = (long) (((1.0f - f4) * jAbs) + (j8 * f4));
                    }
                    if (defaultLivePlaybackSpeedControl.m == -9223372036854775807L || SystemClock.elapsedRealtime() - defaultLivePlaybackSpeedControl.m >= 1000) {
                        defaultLivePlaybackSpeedControl.m = SystemClock.elapsedRealtime();
                        long j9 = (defaultLivePlaybackSpeedControl.o * 3) + defaultLivePlaybackSpeedControl.n;
                        if (defaultLivePlaybackSpeedControl.i > j9) {
                            float fB = Util2.B(1000L);
                            long[] jArr = {j9, defaultLivePlaybackSpeedControl.f, defaultLivePlaybackSpeedControl.i - (((long) ((defaultLivePlaybackSpeedControl.l - 1.0f) * fB)) + ((long) ((defaultLivePlaybackSpeedControl.j - 1.0f) * fB)))};
                            b.i.a.f.e.o.f.v(true);
                            long j10 = jArr[0];
                            for (int i3 = 1; i3 < 3; i3++) {
                                if (jArr[i3] > j10) {
                                    j10 = jArr[i3];
                                }
                            }
                            defaultLivePlaybackSpeedControl.i = j10;
                        } else {
                            long jI = Util2.i(j5 - ((long) (Math.max(0.0f, defaultLivePlaybackSpeedControl.l - 1.0f) / 1.0E-7f)), defaultLivePlaybackSpeedControl.i, j9);
                            defaultLivePlaybackSpeedControl.i = jI;
                            long j11 = defaultLivePlaybackSpeedControl.h;
                            if (j11 != -9223372036854775807L && jI > j11) {
                                defaultLivePlaybackSpeedControl.i = j11;
                            }
                        }
                        long j12 = j5 - defaultLivePlaybackSpeedControl.i;
                        if (Math.abs(j12) < defaultLivePlaybackSpeedControl.a) {
                            defaultLivePlaybackSpeedControl.l = 1.0f;
                        } else {
                            defaultLivePlaybackSpeedControl.l = Util2.g((1.0E-7f * j12) + 1.0f, defaultLivePlaybackSpeedControl.k, defaultLivePlaybackSpeedControl.j);
                        }
                        f2 = defaultLivePlaybackSpeedControl.l;
                    } else {
                        f2 = defaultLivePlaybackSpeedControl.l;
                    }
                }
                if (this.f1008x.c().k != f2) {
                    this.f1008x.i(new PlaybackParameters(f2, this.G.o.l));
                    t(this.G.o, this.f1008x.c().k, false, false);
                }
            }
        }
    }

    public final void o(MediaPeriod mediaPeriod) {
        MediaPeriodQueue mediaPeriodQueue = this.B;
        MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.j;
        if (mediaPeriodHolder != null && mediaPeriodHolder.a == mediaPeriod) {
            mediaPeriodQueue.m(this.U);
            z();
        }
    }

    public final void p(IOException iOException, int i) {
        ExoPlaybackException exoPlaybackException = new ExoPlaybackException(0, iOException, i);
        MediaPeriodHolder mediaPeriodHolder = this.B.h;
        if (mediaPeriodHolder != null) {
            exoPlaybackException = exoPlaybackException.a(mediaPeriodHolder.f.a);
        }
        Log2.b("ExoPlayerImplInternal", "Playback error", exoPlaybackException);
        j0(false, false);
        this.G = this.G.e(exoPlaybackException);
    }

    public final void q(boolean z2) {
        MediaPeriodHolder mediaPeriodHolder = this.B.j;
        MediaSource2.a aVar = mediaPeriodHolder == null ? this.G.c : mediaPeriodHolder.f.a;
        boolean z3 = !this.G.l.equals(aVar);
        if (z3) {
            this.G = this.G.a(aVar);
        }
        PlaybackInfo playbackInfo = this.G;
        playbackInfo.r = mediaPeriodHolder == null ? playbackInfo.t : mediaPeriodHolder.d();
        this.G.f1147s = m();
        if ((z3 || z2) && mediaPeriodHolder != null && mediaPeriodHolder.d) {
            this.o.d(this.j, mediaPeriodHolder.m, mediaPeriodHolder.n.c);
        }
    }

    public final void r(Timeline timeline, boolean z2) throws Throwable {
        MediaSource2.a aVar;
        Object obj;
        int iA;
        Object obj2;
        long j;
        long j2;
        int i;
        int i2;
        boolean z3;
        boolean z4;
        boolean z5;
        int iA2;
        boolean z6;
        boolean z7;
        long j3;
        long j4;
        f fVar;
        long j5;
        int i3;
        long jLongValue;
        Object obj3;
        boolean z8;
        int i4;
        int iA3;
        boolean z9;
        boolean z10;
        boolean z11;
        long j6;
        g gVar;
        boolean z12;
        boolean z13;
        boolean z14;
        PlaybackInfo playbackInfo = this.G;
        g gVar2 = this.T;
        MediaPeriodQueue mediaPeriodQueue = this.B;
        int i5 = this.N;
        boolean z15 = this.O;
        Timeline.c cVar = this.t;
        Timeline.b bVar = this.u;
        if (timeline.q()) {
            MediaSource2.a aVar2 = PlaybackInfo.a;
            fVar = new f(PlaybackInfo.a, 0L, -9223372036854775807L, false, true, false);
        } else {
            MediaSource2.a aVar3 = playbackInfo.c;
            Object obj4 = aVar3.a;
            boolean zY = y(playbackInfo, bVar);
            long j7 = (playbackInfo.c.a() || zY) ? playbackInfo.d : playbackInfo.t;
            if (gVar2 != null) {
                Object obj5 = obj4;
                Pair<Object, Long> pairM = M(timeline, gVar2, true, i5, z15, cVar, bVar);
                if (pairM == null) {
                    iA3 = timeline.a(z15);
                    j6 = j7;
                    z11 = false;
                    z10 = false;
                    z9 = true;
                } else {
                    if (gVar2.c == -9223372036854775807L) {
                        i4 = timeline.h(pairM.first, bVar).l;
                        jLongValue = j7;
                        obj3 = obj5;
                        z8 = false;
                    } else {
                        Object obj6 = pairM.first;
                        jLongValue = ((Long) pairM.second).longValue();
                        obj3 = obj6;
                        z8 = true;
                        i4 = -1;
                    }
                    obj5 = obj3;
                    iA3 = i4;
                    z9 = false;
                    long j8 = jLongValue;
                    z10 = playbackInfo.f == 4;
                    z11 = z8;
                    j6 = j8;
                }
                z5 = z11;
                z3 = z10;
                j2 = j6;
                z4 = z9;
                aVar = aVar3;
                i2 = -1;
                i = iA3;
                obj2 = obj5;
            } else {
                aVar = aVar3;
                if (playbackInfo.f1146b.q()) {
                    iA = timeline.a(z15);
                    obj = obj4;
                } else if (timeline.b(obj4) == -1) {
                    obj = obj4;
                    Object objN = N(cVar, bVar, i5, z15, obj4, playbackInfo.f1146b, timeline);
                    if (objN == null) {
                        iA2 = timeline.a(z15);
                        z6 = true;
                    } else {
                        iA2 = timeline.h(objN, bVar).l;
                        z6 = false;
                    }
                    z7 = z6;
                    aVar = aVar;
                    i = iA2;
                    z4 = z7;
                    obj2 = obj;
                    j2 = j7;
                    i2 = -1;
                    z3 = false;
                    z5 = false;
                } else {
                    obj = obj4;
                    if (j7 == -9223372036854775807L) {
                        iA = timeline.h(obj, bVar).l;
                    } else if (zY) {
                        aVar = aVar;
                        playbackInfo.f1146b.h(aVar.a, bVar);
                        if (playbackInfo.f1146b.n(bVar.l, cVar).B == playbackInfo.f1146b.b(aVar.a)) {
                            Pair<Object, Long> pairJ = timeline.j(cVar, bVar, timeline.h(obj, bVar).l, j7 + bVar.n);
                            Object obj7 = pairJ.first;
                            long jLongValue2 = ((Long) pairJ.second).longValue();
                            obj2 = obj7;
                            j = jLongValue2;
                        } else {
                            obj2 = obj;
                            j = j7;
                        }
                        j2 = j;
                        i = -1;
                        i2 = -1;
                        z3 = false;
                        z4 = false;
                        z5 = true;
                    } else {
                        iA = -1;
                        iA2 = iA;
                        z7 = false;
                        i = iA2;
                        z4 = z7;
                        obj2 = obj;
                        j2 = j7;
                        i2 = -1;
                        z3 = false;
                        z5 = false;
                    }
                }
                iA2 = iA;
                z7 = false;
                i = iA2;
                z4 = z7;
                obj2 = obj;
                j2 = j7;
                i2 = -1;
                z3 = false;
                z5 = false;
            }
            if (i != i2) {
                Pair<Object, Long> pairJ2 = timeline.j(cVar, bVar, i, -9223372036854775807L);
                Object obj8 = pairJ2.first;
                long jLongValue3 = ((Long) pairJ2.second).longValue();
                obj2 = obj8;
                j2 = jLongValue3;
                j3 = -9223372036854775807L;
            } else {
                j3 = j2;
            }
            MediaSource2.a aVarO = mediaPeriodQueue.o(timeline, obj2, j2);
            boolean z16 = aVarO.e == -1 || ((i3 = aVar.e) != -1 && aVarO.f835b >= i3);
            boolean zEquals = aVar.a.equals(obj2);
            boolean z17 = zEquals && !aVar.a() && !aVarO.a() && z16;
            timeline.h(obj2, bVar);
            boolean z18 = zEquals && !zY && j7 == j3 && ((aVarO.a() && bVar.e(aVarO.f835b)) || (aVar.a() && bVar.e(aVar.f835b)));
            if (z17 || z18) {
                aVarO = aVar;
            }
            if (aVarO.a()) {
                if (aVarO.equals(aVar)) {
                    j5 = playbackInfo.t;
                } else {
                    timeline.h(aVarO.a, bVar);
                    j5 = aVarO.c == bVar.d(aVarO.f835b) ? bVar.p.o : 0L;
                }
                j4 = j5;
            } else {
                j4 = j2;
            }
            fVar = new f(aVarO, j4, j3, z3, z4, z5);
        }
        f fVar2 = fVar;
        MediaSource2.a aVar4 = fVar2.a;
        long j9 = fVar2.c;
        boolean z19 = fVar2.d;
        long jR = fVar2.f1013b;
        boolean z20 = (this.G.c.equals(aVar4) && jR == this.G.t) ? false : true;
        try {
            if (fVar2.e) {
                if (this.G.f != 1) {
                    f0(4);
                }
                H(false, false, false, true);
            }
            try {
                if (z20) {
                    z13 = false;
                    z14 = true;
                    if (!timeline.q()) {
                        for (MediaPeriodHolder mediaPeriodHolder = this.B.h; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.l) {
                            if (mediaPeriodHolder.f.a.equals(aVar4)) {
                                mediaPeriodHolder.f = this.B.h(timeline, mediaPeriodHolder.f);
                                mediaPeriodHolder.j();
                            }
                        }
                        jR = R(aVar4, jR, z19);
                    }
                } else {
                    try {
                        z13 = false;
                        z14 = true;
                        if (!this.B.r(timeline, this.U, k())) {
                            P(false);
                        }
                    } catch (Throwable th) {
                        th = th;
                        z12 = true;
                        gVar = null;
                        PlaybackInfo playbackInfo2 = this.G;
                        g gVar3 = gVar;
                        m0(timeline, aVar4, playbackInfo2.f1146b, playbackInfo2.c, fVar2.f ? jR : -9223372036854775807L);
                        if (z20 || j9 != this.G.d) {
                            PlaybackInfo playbackInfo3 = this.G;
                            Object obj9 = playbackInfo3.c.a;
                            Timeline timeline2 = playbackInfo3.f1146b;
                            if (!z20 || !z2 || timeline2.q() || timeline2.h(obj9, this.u).o) {
                                z12 = false;
                            }
                            this.G = u(aVar4, jR, j9, this.G.e, z12, timeline.b(obj9) == -1 ? 4 : 3);
                        }
                        I();
                        L(timeline, this.G.f1146b);
                        this.G = this.G.g(timeline);
                        if (!timeline.q()) {
                            this.T = gVar3;
                        }
                        q(false);
                        throw th;
                    }
                }
                PlaybackInfo playbackInfo4 = this.G;
                m0(timeline, aVar4, playbackInfo4.f1146b, playbackInfo4.c, fVar2.f ? jR : -9223372036854775807L);
                if (z20 || j9 != this.G.d) {
                    PlaybackInfo playbackInfo5 = this.G;
                    Object obj10 = playbackInfo5.c.a;
                    Timeline timeline3 = playbackInfo5.f1146b;
                    if (!z20 || !z2 || timeline3.q() || timeline3.h(obj10, this.u).o) {
                        z14 = false;
                    }
                    this.G = u(aVar4, jR, j9, this.G.e, z14, timeline.b(obj10) == -1 ? 4 : 3);
                }
                I();
                L(timeline, this.G.f1146b);
                this.G = this.G.g(timeline);
                if (!timeline.q()) {
                    this.T = null;
                }
                q(z13);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            gVar = null;
            z12 = true;
        }
    }

    public final void s(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        MediaPeriodHolder mediaPeriodHolder = this.B.j;
        if (mediaPeriodHolder != null && mediaPeriodHolder.a == mediaPeriod) {
            float f2 = this.f1008x.c().k;
            Timeline timeline = this.G.f1146b;
            mediaPeriodHolder.d = true;
            mediaPeriodHolder.m = mediaPeriodHolder.a.n();
            TrackSelectorResult trackSelectorResultI = mediaPeriodHolder.i(f2, timeline);
            MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f;
            long jMax = mediaPeriodInfo.f1058b;
            long j = mediaPeriodInfo.e;
            if (j != -9223372036854775807L && jMax >= j) {
                jMax = Math.max(0L, j - 1);
            }
            long jA = mediaPeriodHolder.a(trackSelectorResultI, jMax, false, new boolean[mediaPeriodHolder.i.length]);
            long j2 = mediaPeriodHolder.o;
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.f;
            mediaPeriodHolder.o = (mediaPeriodInfo2.f1058b - jA) + j2;
            mediaPeriodHolder.f = mediaPeriodInfo2.b(jA);
            this.o.d(this.j, mediaPeriodHolder.m, mediaPeriodHolder.n.c);
            if (mediaPeriodHolder == this.B.h) {
                J(mediaPeriodHolder.f.f1058b);
                g();
                PlaybackInfo playbackInfo = this.G;
                MediaSource2.a aVar = playbackInfo.c;
                long j3 = mediaPeriodHolder.f.f1058b;
                this.G = u(aVar, j3, playbackInfo.d, j3, false, 5);
            }
            z();
        }
    }

    public final void t(PlaybackParameters playbackParameters, float f2, boolean z2, boolean z3) throws ExoPlaybackException {
        int i;
        ExoPlayerImplInternal2 exoPlayerImplInternal2 = this;
        if (z2) {
            if (z3) {
                exoPlayerImplInternal2.H.a(1);
            }
            PlaybackInfo playbackInfo = exoPlayerImplInternal2.G;
            exoPlayerImplInternal2 = this;
            exoPlayerImplInternal2.G = new PlaybackInfo(playbackInfo.f1146b, playbackInfo.c, playbackInfo.d, playbackInfo.e, playbackInfo.f, playbackInfo.g, playbackInfo.h, playbackInfo.i, playbackInfo.j, playbackInfo.k, playbackInfo.l, playbackInfo.m, playbackInfo.n, playbackParameters, playbackInfo.r, playbackInfo.f1147s, playbackInfo.t, playbackInfo.p, playbackInfo.q);
        }
        float f3 = playbackParameters.k;
        MediaPeriodHolder mediaPeriodHolder = exoPlayerImplInternal2.B.h;
        while (true) {
            i = 0;
            if (mediaPeriodHolder == null) {
                break;
            }
            ExoTrackSelection2[] exoTrackSelection2Arr = mediaPeriodHolder.n.c;
            int length = exoTrackSelection2Arr.length;
            while (i < length) {
                ExoTrackSelection2 exoTrackSelection2 = exoTrackSelection2Arr[i];
                if (exoTrackSelection2 != null) {
                    exoTrackSelection2.i(f3);
                }
                i++;
            }
            mediaPeriodHolder = mediaPeriodHolder.l;
        }
        Renderer2[] renderer2Arr = exoPlayerImplInternal2.j;
        int length2 = renderer2Arr.length;
        while (i < length2) {
            Renderer2 renderer2 = renderer2Arr[i];
            if (renderer2 != null) {
                renderer2.n(f2, playbackParameters.k);
            }
            i++;
        }
    }

    @CheckResult
    public final PlaybackInfo u(MediaSource2.a aVar, long j, long j2, long j3, boolean z2, int i) {
        TrackGroupArray trackGroupArray;
        TrackSelectorResult trackSelectorResult;
        List<Metadata> list;
        ImmutableList2<Object> immutableList2L;
        int i2 = 0;
        this.W = (!this.W && j == this.G.t && aVar.equals(this.G.c)) ? false : true;
        I();
        PlaybackInfo playbackInfo = this.G;
        TrackGroupArray trackGroupArray2 = playbackInfo.i;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.j;
        List<Metadata> list2 = playbackInfo.k;
        if (this.C.j) {
            MediaPeriodHolder mediaPeriodHolder = this.B.h;
            TrackGroupArray trackGroupArray3 = mediaPeriodHolder == null ? TrackGroupArray.j : mediaPeriodHolder.m;
            TrackSelectorResult trackSelectorResult3 = mediaPeriodHolder == null ? this.n : mediaPeriodHolder.n;
            ExoTrackSelection2[] exoTrackSelection2Arr = trackSelectorResult3.c;
            b.i.a.f.e.o.f.A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int length = exoTrackSelection2Arr.length;
            int i3 = 0;
            boolean z3 = false;
            int i4 = 0;
            while (i3 < length) {
                ExoTrackSelection2 exoTrackSelection2 = exoTrackSelection2Arr[i3];
                if (exoTrackSelection2 != null) {
                    Metadata metadata = exoTrackSelection2.d(i2).u;
                    if (metadata == null) {
                        Metadata metadata2 = new Metadata(new Metadata.Entry[i2]);
                        int i5 = i4 + 1;
                        if (objArrCopyOf.length < i5) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i5));
                        }
                        objArrCopyOf[i4] = metadata2;
                        i4 = i5;
                    } else {
                        int i6 = i4 + 1;
                        if (objArrCopyOf.length < i6) {
                            objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i6));
                        }
                        objArrCopyOf[i4] = metadata;
                        i4 = i6;
                        z3 = true;
                    }
                }
                i3++;
                trackGroupArray3 = trackGroupArray3;
                i2 = 0;
            }
            TrackGroupArray trackGroupArray4 = trackGroupArray3;
            if (z3) {
                immutableList2L = ImmutableList2.l(objArrCopyOf, i4);
            } else {
                AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
                immutableList2L = RegularImmutableList.l;
            }
            if (mediaPeriodHolder != null) {
                MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f;
                if (mediaPeriodInfo.c != j2) {
                    mediaPeriodHolder.f = mediaPeriodInfo.a(j2);
                }
            }
            list = immutableList2L;
            trackSelectorResult = trackSelectorResult3;
            trackGroupArray = trackGroupArray4;
        } else if (aVar.equals(playbackInfo.c)) {
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
            list = list2;
        } else {
            TrackGroupArray trackGroupArray5 = TrackGroupArray.j;
            TrackSelectorResult trackSelectorResult4 = this.n;
            AbstractIndexedListIterator<Object> abstractIndexedListIterator2 = ImmutableList2.k;
            trackGroupArray = trackGroupArray5;
            trackSelectorResult = trackSelectorResult4;
            list = RegularImmutableList.l;
        }
        if (z2) {
            d dVar = this.H;
            if (!dVar.d || dVar.e == 5) {
                dVar.a = true;
                dVar.d = true;
                dVar.e = i;
            } else {
                AnimatableValueParser.j(i == 5);
            }
        }
        return this.G.b(aVar, j, j2, j3, m(), trackGroupArray, trackSelectorResult, list);
    }

    public final boolean v() {
        MediaPeriodHolder mediaPeriodHolder = this.B.j;
        if (mediaPeriodHolder == null) {
            return false;
        }
        return (!mediaPeriodHolder.d ? 0L : mediaPeriodHolder.a.c()) != Long.MIN_VALUE;
    }

    public final boolean x() {
        MediaPeriodHolder mediaPeriodHolder = this.B.h;
        long j = mediaPeriodHolder.f.e;
        return mediaPeriodHolder.d && (j == -9223372036854775807L || this.G.t < j || !g0());
    }

    public final void z() {
        long j;
        long j2;
        boolean zG;
        if (v()) {
            MediaPeriodHolder mediaPeriodHolder = this.B.j;
            long jN = n(!mediaPeriodHolder.d ? 0L : mediaPeriodHolder.a.c());
            if (mediaPeriodHolder == this.B.h) {
                j = this.U;
                j2 = mediaPeriodHolder.o;
            } else {
                j = this.U - mediaPeriodHolder.o;
                j2 = mediaPeriodHolder.f.f1058b;
            }
            zG = this.o.g(j - j2, jN, this.f1008x.c().k);
        } else {
            zG = false;
        }
        this.M = zG;
        if (zG) {
            MediaPeriodHolder mediaPeriodHolder2 = this.B.j;
            long j3 = this.U;
            AnimatableValueParser.D(mediaPeriodHolder2.g());
            mediaPeriodHolder2.a.g(j3 - mediaPeriodHolder2.o);
        }
        l0();
    }
}
