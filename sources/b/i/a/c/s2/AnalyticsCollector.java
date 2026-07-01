package b.i.a.c.s2;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import b.i.a.c.DeviceInfo2;
import b.i.a.c.Format2;
import b.i.a.c.MediaItem2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.PlaybackParameters;
import b.i.a.c.Player;
import b.i.a.c.Player2;
import b.i.a.c.Player3;
import b.i.a.c.Timeline;
import b.i.a.c.TracksInfo;
import b.i.a.c.a3.LoadEventInfo;
import b.i.a.c.a3.MediaLoadData;
import b.i.a.c.a3.MediaPeriodId;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.MediaSourceEventListener;
import b.i.a.c.a3.TrackGroupArray;
import b.i.a.c.c3.TrackSelectionArray;
import b.i.a.c.e3.BandwidthMeter;
import b.i.a.c.f3.Clock4;
import b.i.a.c.f3.FlagSet;
import b.i.a.c.f3.HandlerWrapper;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.f3.Util2;
import b.i.a.c.g3.VideoRendererEventListener;
import b.i.a.c.g3.VideoRendererEventListener2;
import b.i.a.c.g3.VideoSize;
import b.i.a.c.s2.AnalyticsListener;
import b.i.a.c.t2.AudioRendererEventListener;
import b.i.a.c.t2.AudioRendererEventListener2;
import b.i.a.c.v2.DecoderCounters;
import b.i.a.c.v2.DecoderReuseEvaluation;
import b.i.a.c.w2.DrmSessionEventListener;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.ImmutableMap2;
import b.i.b.b.RegularImmutableList;
import b.i.b.b.RegularImmutableMap;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: b.i.a.c.s2.g1, reason: use source file name */
/* JADX INFO: compiled from: AnalyticsCollector.java */
/* JADX INFO: loaded from: classes3.dex */
public class AnalyticsCollector implements Player2.e, AudioRendererEventListener2, VideoRendererEventListener2, MediaSourceEventListener, BandwidthMeter.a, DrmSessionEventListener {
    public final Clock4 j;
    public final Timeline.b k;
    public final Timeline.c l;
    public final a m;
    public final SparseArray<AnalyticsListener.a> n;
    public ListenerSet<AnalyticsListener> o;
    public Player2 p;
    public HandlerWrapper q;
    public boolean r;

    /* JADX INFO: renamed from: b.i.a.c.s2.g1$a */
    /* JADX INFO: compiled from: AnalyticsCollector.java */
    public static final class a {
        public final Timeline.b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ImmutableList2<MediaSource2.a> f1081b;
        public ImmutableMap2<MediaSource2.a, Timeline> c;

        @Nullable
        public MediaSource2.a d;
        public MediaSource2.a e;
        public MediaSource2.a f;

        public a(Timeline.b bVar) {
            this.a = bVar;
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            this.f1081b = RegularImmutableList.l;
            this.c = RegularImmutableMap.m;
        }

        @Nullable
        public static MediaSource2.a b(Player2 player2, ImmutableList2<MediaSource2.a> immutableList2, @Nullable MediaSource2.a aVar, Timeline.b bVar) {
            Timeline timelineK = player2.K();
            int iM = player2.m();
            Object objM = timelineK.q() ? null : timelineK.m(iM);
            int iB = (player2.f() || timelineK.q()) ? -1 : timelineK.f(iM, bVar).b(Util2.B(player2.T()) - bVar.n);
            for (int i = 0; i < immutableList2.size(); i++) {
                MediaSource2.a aVar2 = immutableList2.get(i);
                if (c(aVar2, objM, player2.f(), player2.B(), player2.q(), iB)) {
                    return aVar2;
                }
            }
            if (immutableList2.isEmpty() && aVar != null) {
                if (c(aVar, objM, player2.f(), player2.B(), player2.q(), iB)) {
                    return aVar;
                }
            }
            return null;
        }

        public static boolean c(MediaSource2.a aVar, @Nullable Object obj, boolean z2, int i, int i2, int i3) {
            if (aVar.a.equals(obj)) {
                return (z2 && aVar.f835b == i && aVar.c == i2) || (!z2 && aVar.f835b == -1 && aVar.e == i3);
            }
            return false;
        }

        public final void a(ImmutableMap2.a<MediaSource2.a, Timeline> aVar, @Nullable MediaSource2.a aVar2, Timeline timeline) {
            if (aVar2 == null) {
                return;
            }
            if (timeline.b(aVar2.a) != -1) {
                aVar.c(aVar2, timeline);
                return;
            }
            Timeline timeline2 = this.c.get(aVar2);
            if (timeline2 != null) {
                aVar.c(aVar2, timeline2);
            }
        }

        public final void d(Timeline timeline) {
            ImmutableMap2.a<MediaSource2.a, Timeline> aVar = new ImmutableMap2.a<>(4);
            if (this.f1081b.isEmpty()) {
                a(aVar, this.e, timeline);
                if (!b.i.a.f.e.o.f.V(this.f, this.e)) {
                    a(aVar, this.f, timeline);
                }
                if (!b.i.a.f.e.o.f.V(this.d, this.e) && !b.i.a.f.e.o.f.V(this.d, this.f)) {
                    a(aVar, this.d, timeline);
                }
            } else {
                for (int i = 0; i < this.f1081b.size(); i++) {
                    a(aVar, this.f1081b.get(i), timeline);
                }
                if (!this.f1081b.contains(this.d)) {
                    a(aVar, this.d, timeline);
                }
            }
            this.c = aVar.a();
        }
    }

    public AnalyticsCollector(Clock4 clock4) {
        this.j = clock4;
        this.o = new ListenerSet<>(new CopyOnWriteArraySet(), Util2.o(), clock4, new ListenerSet.b() { // from class: b.i.a.c.s2.o0
            @Override // b.i.a.c.f3.ListenerSet.b
            public final void a(Object obj, FlagSet flagSet) {
            }
        });
        Timeline.b bVar = new Timeline.b();
        this.k = bVar;
        this.l = new Timeline.c();
        this.m = new a(bVar);
        this.n = new SparseArray<>();
    }

    @Override // b.i.a.c.Player2.c
    public void A(final MediaMetadata mediaMetadata) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.r0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).o0();
            }
        };
        this.n.put(14, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(14, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void B(final String str) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.t
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).W();
            }
        };
        this.n.put(PointerIconCompat.TYPE_ALL_SCROLL, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_ALL_SCROLL, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void C(final String str, final long j, final long j2) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.l0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.k0();
                analyticsListener.U();
                analyticsListener.T();
            }
        };
        this.n.put(PointerIconCompat.TYPE_VERTICAL_TEXT, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_VERTICAL_TEXT, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void D(final boolean z2) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.g0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).o();
            }
        };
        this.n.put(9, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(9, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void E(Player2 player2, Player2.d dVar) {
        Player.e(this, player2, dVar);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void F(final int i, final long j) {
        final AnalyticsListener.a aVarO0 = o0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.z
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).f();
            }
        };
        this.n.put(AudioAttributesCompat.FLAG_ALL, aVarO0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(AudioAttributesCompat.FLAG_ALL, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void G(int i, boolean z2) {
        Player.d(this, i, z2);
    }

    @Override // b.i.a.c.Player2.c
    public final void H(final boolean z2, final int i) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.j0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).G();
            }
        };
        this.n.put(-1, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(-1, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void I(final Format2 format2, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.i0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.d0();
                analyticsListener.v();
                analyticsListener.x();
            }
        };
        this.n.put(PointerIconCompat.TYPE_ALIAS, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_ALIAS, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void J(int i, @Nullable MediaSource2.a aVar) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.t0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).Y();
            }
        };
        this.n.put(1034, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1034, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void K(final Object obj, final long j) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.f1
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj2) {
                ((AnalyticsListener) obj2).c();
            }
        };
        this.n.put(1027, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1027, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void L(final int i) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.b0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).b();
            }
        };
        this.n.put(8, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(8, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void M(@Nullable final MediaItem2 mediaItem2, final int i) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.q
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).t();
            }
        };
        this.n.put(1, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void N(final Exception exc) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.e0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).w();
            }
        };
        this.n.put(PointerIconCompat.TYPE_ZOOM_IN, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_ZOOM_IN, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public /* synthetic */ void O(Format2 format2) {
        VideoRendererEventListener.a(this, format2);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void P(final DecoderCounters decoderCounters) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.d0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.Z();
                analyticsListener.F();
            }
        };
        this.n.put(PointerIconCompat.TYPE_GRAB, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_GRAB, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void Q(final Format2 format2, @Nullable final DecoderReuseEvaluation decoderReuseEvaluation) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.y0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.h0();
                analyticsListener.B();
                analyticsListener.x();
            }
        };
        this.n.put(1022, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1022, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void R(final long j) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.n0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).j();
            }
        };
        this.n.put(PointerIconCompat.TYPE_COPY, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_COPY, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void S(int i, @Nullable MediaSource2.a aVar) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.e1
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).A();
            }
        };
        this.n.put(1031, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1031, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void T(final Exception exc) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.k
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).V();
            }
        };
        this.n.put(1037, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1037, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public /* synthetic */ void U(Format2 format2) {
        AudioRendererEventListener.a(this, format2);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void V(final Exception exc) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.q0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).O();
            }
        };
        this.n.put(1038, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1038, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void W(final boolean z2, final int i) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.d1
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).e();
            }
        };
        this.n.put(5, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(5, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void X(int i, @Nullable MediaSource2.a aVar, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.y
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).p();
            }
        };
        this.n.put(PointerIconCompat.TYPE_CONTEXT_MENU, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_CONTEXT_MENU, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void Y(final TrackGroupArray trackGroupArray, final TrackSelectionArray trackSelectionArray) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.i
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).m0();
            }
        };
        this.n.put(2, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(2, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void Z(final DecoderCounters decoderCounters) {
        final AnalyticsListener.a aVarO0 = o0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.j
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.m();
                analyticsListener.g();
            }
        };
        this.n.put(InputDeviceCompat.SOURCE_GAMEPAD, aVarO0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(InputDeviceCompat.SOURCE_GAMEPAD, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void a() {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.u
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).a();
            }
        };
        this.n.put(-1, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(-1, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public void a0(final int i, final int i2) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.n
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).l();
            }
        };
        this.n.put(1029, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1029, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public final void b(final Metadata metadata) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.v
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).f0();
            }
        };
        this.n.put(PointerIconCompat.TYPE_CROSSHAIR, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_CROSSHAIR, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void b0(final PlaybackParameters playbackParameters) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.m
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).I();
            }
        };
        this.n.put(12, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(12, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void c() {
        Player.r(this);
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void c0(int i, @Nullable MediaSource2.a aVar, final int i2) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.p0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.p0();
                analyticsListener.X();
            }
        };
        this.n.put(1030, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1030, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public final void d(final boolean z2) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.u0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).q();
            }
        };
        this.n.put(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void d0(int i, @Nullable MediaSource2.a aVar) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.b
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).g0();
            }
        };
        this.n.put(1035, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1035, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void e(List list) {
        Player.b(this, list);
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void e0(final int i, final long j, final long j2) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.c0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).C();
            }
        };
        this.n.put(PointerIconCompat.TYPE_NO_DROP, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_NO_DROP, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public final void f(final VideoSize videoSize) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.m0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                VideoSize videoSize2 = videoSize;
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.n0();
                int i = videoSize2.k;
                analyticsListener.r();
            }
        };
        this.n.put(1028, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1028, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void f0(PlaybackException playbackException) {
        Player.p(this, playbackException);
    }

    @Override // b.i.a.c.Player2.c
    public final void g(final Player2.f fVar, final Player2.f fVar2, final int i) {
        if (i == 1) {
            this.r = false;
        }
        a aVar = this.m;
        Player2 player2 = this.p;
        Objects.requireNonNull(player2);
        aVar.d = a.b(player2, aVar.f1081b, aVar.e, aVar.a);
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.r
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.S();
                analyticsListener.y();
            }
        };
        this.n.put(11, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(11, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void g0(int i, @Nullable MediaSource2.a aVar, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z2) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.f0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).u();
            }
        };
        this.n.put(PointerIconCompat.TYPE_HELP, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_HELP, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void h(final int i) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.b1
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).e0();
            }
        };
        this.n.put(6, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(6, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void h0(final long j, final int i) {
        final AnalyticsListener.a aVarO0 = o0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.c1
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).a0();
            }
        };
        this.n.put(1026, aVarO0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1026, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void i(boolean z2) {
        Player3.d(this, z2);
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void i0(int i, @Nullable MediaSource2.a aVar) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.v0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).s();
            }
        };
        this.n.put(1033, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1033, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public /* synthetic */ void j(int i) {
        Player3.l(this, i);
    }

    @Override // b.i.a.c.Player2.c
    public void j0(final boolean z2) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.z0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).D();
            }
        };
        this.n.put(7, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(7, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void k(final DecoderCounters decoderCounters) {
        final AnalyticsListener.a aVarO0 = o0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.w0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.d();
                analyticsListener.g();
            }
        };
        this.n.put(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, aVarO0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, aVar);
        listenerSet.a();
    }

    public final AnalyticsListener.a k0() {
        return m0(this.m.d);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void l(final String str) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.f
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).N();
            }
        };
        this.n.put(1024, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1024, aVar);
        listenerSet.a();
    }

    @RequiresNonNull({"player"})
    public final AnalyticsListener.a l0(Timeline timeline, int i, @Nullable MediaSource2.a aVar) {
        long jW;
        MediaSource2.a aVar2 = timeline.q() ? null : aVar;
        long jD = this.j.d();
        boolean z2 = false;
        boolean z3 = timeline.equals(this.p.K()) && i == this.p.C();
        long jA = 0;
        if (aVar2 == null || !aVar2.a()) {
            if (z3) {
                jW = this.p.w();
            } else if (!timeline.q()) {
                jA = timeline.o(i, this.l, 0L).a();
            }
            return new AnalyticsListener.a(jD, timeline, i, aVar2, jW, this.p.K(), this.p.C(), this.m.d, this.p.T(), this.p.g());
        }
        if (z3 && this.p.B() == aVar2.f835b && this.p.q() == aVar2.c) {
            z2 = true;
        }
        if (z2) {
            jA = this.p.T();
        }
        jW = jA;
        return new AnalyticsListener.a(jD, timeline, i, aVar2, jW, this.p.K(), this.p.C(), this.m.d, this.p.T(), this.p.g());
    }

    @Override // b.i.a.c.t2.AudioRendererEventListener2
    public final void m(final DecoderCounters decoderCounters) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.l
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.h();
                analyticsListener.F();
            }
        };
        this.n.put(PointerIconCompat.TYPE_TEXT, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_TEXT, aVar);
        listenerSet.a();
    }

    public final AnalyticsListener.a m0(@Nullable MediaSource2.a aVar) {
        Objects.requireNonNull(this.p);
        Timeline timeline = aVar == null ? null : this.m.c.get(aVar);
        if (aVar != null && timeline != null) {
            return l0(timeline, timeline.h(aVar.a, this.k).l, aVar);
        }
        int iC = this.p.C();
        Timeline timelineK = this.p.K();
        if (!(iC < timelineK.p())) {
            timelineK = Timeline.j;
        }
        return l0(timelineK, iC, null);
    }

    @Override // b.i.a.c.g3.VideoRendererEventListener2
    public final void n(final String str, final long j, final long j2) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.d
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.i0();
                analyticsListener.M();
                analyticsListener.T();
            }
        };
        this.n.put(PointerIconCompat.TYPE_GRABBING, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_GRABBING, aVar);
        listenerSet.a();
    }

    public final AnalyticsListener.a n0(int i, @Nullable MediaSource2.a aVar) {
        Objects.requireNonNull(this.p);
        if (aVar != null) {
            return this.m.c.get(aVar) != null ? m0(aVar) : l0(Timeline.j, i, aVar);
        }
        Timeline timelineK = this.p.K();
        if (!(i < timelineK.p())) {
            timelineK = Timeline.j;
        }
        return l0(timelineK, i, null);
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void o(int i, @Nullable MediaSource2.a aVar, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.g
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).H();
            }
        };
        this.n.put(PointerIconCompat.TYPE_WAIT, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_WAIT, aVar2);
        listenerSet.a();
    }

    public final AnalyticsListener.a o0() {
        return m0(this.m.e);
    }

    @Override // b.i.a.c.Player2.c
    public void p(final TracksInfo tracksInfo) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.w
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).i();
            }
        };
        this.n.put(2, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(2, aVar);
        listenerSet.a();
    }

    public final AnalyticsListener.a p0() {
        return m0(this.m.f);
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void q(int i, @Nullable MediaSource2.a aVar, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.h0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).k();
            }
        };
        this.n.put(PointerIconCompat.TYPE_HAND, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_HAND, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void r(final boolean z2) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.e
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                AnalyticsListener analyticsListener = (AnalyticsListener) obj;
                analyticsListener.L();
                analyticsListener.Q();
            }
        };
        this.n.put(3, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(3, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void s(final PlaybackException playbackException) {
        MediaPeriodId mediaPeriodId;
        final AnalyticsListener.a aVarM0 = (!(playbackException instanceof ExoPlaybackException) || (mediaPeriodId = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? null : m0(new MediaSource2.a(mediaPeriodId));
        if (aVarM0 == null) {
            aVarM0 = k0();
        }
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.a
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).J();
            }
        };
        this.n.put(10, aVarM0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(10, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public void t(final Player2.b bVar) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.a0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).P();
            }
        };
        this.n.put(13, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(13, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.w2.DrmSessionEventListener
    public final void u(int i, @Nullable MediaSource2.a aVar, final Exception exc) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.c
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).n();
            }
        };
        this.n.put(1032, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1032, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void v(Timeline timeline, final int i) {
        a aVar = this.m;
        Player2 player2 = this.p;
        Objects.requireNonNull(player2);
        aVar.d = a.b(player2, aVar.f1081b, aVar.e, aVar.a);
        aVar.d(player2.K());
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.x
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).z();
            }
        };
        this.n.put(0, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(0, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public final void w(final float f) {
        final AnalyticsListener.a aVarP0 = p0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.s
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).b0();
            }
        };
        this.n.put(PointerIconCompat.TYPE_ZOOM_OUT, aVarP0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(PointerIconCompat.TYPE_ZOOM_OUT, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.a3.MediaSourceEventListener
    public final void x(int i, @Nullable MediaSource2.a aVar, final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData) {
        final AnalyticsListener.a aVarN0 = n0(i, aVar);
        ListenerSet.a<AnalyticsListener> aVar2 = new ListenerSet.a() { // from class: b.i.a.c.s2.k0
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).R();
            }
        };
        this.n.put(1000, aVarN0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(1000, aVar2);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.c
    public final void y(final int i) {
        final AnalyticsListener.a aVarK0 = k0();
        ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.a1
            @Override // b.i.a.c.f3.ListenerSet.a
            public final void invoke(Object obj) {
                ((AnalyticsListener) obj).c0();
            }
        };
        this.n.put(4, aVarK0);
        ListenerSet<AnalyticsListener> listenerSet = this.o;
        listenerSet.b(4, aVar);
        listenerSet.a();
    }

    @Override // b.i.a.c.Player2.e
    public /* synthetic */ void z(DeviceInfo2 deviceInfo2) {
        Player.c(this, deviceInfo2);
    }
}
