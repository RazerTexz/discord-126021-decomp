package com.discord.player;

import android.media.AudioTrack;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.MainThread;
import b.a.p.AppMediaPlayer2;
import b.a.p.AppMediaPlayer3;
import b.a.p.AppMediaPlayer4;
import b.a.p.AppMediaPlayer5;
import b.a.p.AppMediaPlayer6;
import b.a.p.AppMediaPlayer7;
import b.a.p.RxPlayerEventListener;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.AudioFocusManager;
import b.i.a.c.BasePlayer;
import b.i.a.c.Bundleable;
import b.i.a.c.ExoPlayer2;
import b.i.a.c.ExoPlayerImpl;
import b.i.a.c.ExoPlayerImplInternal2;
import b.i.a.c.MediaItem2;
import b.i.a.c.MediaMetadata;
import b.i.a.c.MediaSourceList;
import b.i.a.c.PlaybackInfo;
import b.i.a.c.Player2;
import b.i.a.c.PlaylistTimeline;
import b.i.a.c.SimpleExoPlayer;
import b.i.a.c.StreamVolumeManager;
import b.i.a.c.WakeLockManager;
import b.i.a.c.WifiLockManager;
import b.i.a.c.a3.MediaSource2;
import b.i.a.c.a3.ProgressiveMediaSource;
import b.i.a.c.a3.ShuffleOrder;
import b.i.a.c.a3.j;
import b.i.a.c.e3.DataSource3;
import b.i.a.c.e3.DefaultLoadErrorHandlingPolicy;
import b.i.a.c.f3.HandlerWrapper;
import b.i.a.c.f3.ListenerSet;
import b.i.a.c.f3.Log2;
import b.i.a.c.f3.SystemHandlerWrapper;
import b.i.a.c.f3.Util2;
import b.i.a.c.s2.AnalyticsCollector;
import b.i.a.c.s2.AnalyticsListener;
import b.i.a.c.w2.DefaultDrmSessionManagerProvider;
import b.i.a.c.w2.DrmSessionManager2;
import b.i.a.c.x2.DefaultExtractorsFactory;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import com.discord.utilities.logging.Logger;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Scheduler;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final PublishSubject<Event> eventSubject;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Subscription positionPollingSubscription;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final CompositeSubscription compositeSubscription;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final BehaviorSubject<Float> volumeSubject;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public MediaSource mediaSource;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final ExoPlayer2 exoPlayer;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final RxPlayerEventListener rxPlayerEventListener;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final DataSource3.a dataSourceFactory;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Scheduler timerScheduler;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Logger logger;

    /* JADX INFO: compiled from: AppMediaPlayer.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class a extends Event {
            public static final a a = new a();

            public a() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class b extends Event {
            public static final b a = new b();

            public b() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class c extends Event {
            public final long a;

            public c(long j) {
                super(null);
                this.a = j;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof c) && this.a == ((c) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return a0.a.a.b.a(this.a);
            }

            public String toString() {
                return outline.C(outline.U("CurrentPositionUpdate(positionMs="), this.a, ")");
            }
        }

        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class d extends Event {
            public static final d a = new d();

            public d() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class e extends Event {
            public static final e a = new e();

            public e() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class f extends Event {
            public static final f a = new f();

            public f() {
                super(null);
            }
        }

        public Event() {
        }

        public Event(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public AppMediaPlayer(ExoPlayer2 exoPlayer2, RxPlayerEventListener rxPlayerEventListener, DataSource3.a aVar, Scheduler scheduler, Logger logger) {
        Intrinsics3.checkNotNullParameter(exoPlayer2, "exoPlayer");
        Intrinsics3.checkNotNullParameter(rxPlayerEventListener, "rxPlayerEventListener");
        Intrinsics3.checkNotNullParameter(aVar, "dataSourceFactory");
        Intrinsics3.checkNotNullParameter(scheduler, "timerScheduler");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        this.exoPlayer = exoPlayer2;
        this.rxPlayerEventListener = rxPlayerEventListener;
        this.dataSourceFactory = aVar;
        this.timerScheduler = scheduler;
        this.logger = logger;
        PublishSubject<Event> publishSubjectK0 = PublishSubject.k0();
        Intrinsics3.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        this.compositeSubscription = compositeSubscription;
        BehaviorSubject<Float> behaviorSubjectL0 = BehaviorSubject.l0(Float.valueOf(((SimpleExoPlayer) exoPlayer2).B));
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(exoPlayer.volume)");
        this.volumeSubject = behaviorSubjectL0;
        PublishSubject<RxPlayerEventListener.c> publishSubject = rxPlayerEventListener.j;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "playerStateChangeSubject");
        compositeSubscription.a(publishSubject.K().W(new AppMediaPlayer6(this), new AppMediaPlayer7(this)));
        PublishSubject<RxPlayerEventListener.a> publishSubject2 = rxPlayerEventListener.k;
        Intrinsics3.checkNotNullExpressionValue(publishSubject2, "isPlayingChangeSubject");
        compositeSubscription.a(publishSubject2.L().W(new AppMediaPlayer2(this), new AppMediaPlayer3(this)));
        MediaSource mediaSource = this.mediaSource;
        String str = (mediaSource == null || (str = mediaSource.featureTag) == null) ? "" : str;
        PublishSubject<RxPlayerEventListener.b> publishSubject3 = rxPlayerEventListener.l;
        Intrinsics3.checkNotNullExpressionValue(publishSubject3, "playerErrorSubject");
        compositeSubscription.a(publishSubject3.K().W(new AppMediaPlayer4(this, str), new AppMediaPlayer5(this)));
    }

    public static /* synthetic */ void b(AppMediaPlayer appMediaPlayer, MediaSource mediaSource, boolean z2, boolean z3, long j, PlayerView playerView, PlayerControlView playerControlView, int i) {
        int i2 = i & 32;
        appMediaPlayer.a(mediaSource, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? 0L : j, playerView, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @MainThread
    public final void a(MediaSource mediaSource, boolean autoPlayWhenReady, boolean loopMedia, long initialSeekPositionMs, PlayerView playerView, PlayerControlView playerControlView) {
        DrmSessionManager2 drmSessionManager2;
        Intrinsics3.checkNotNullParameter(mediaSource, "mediaSource");
        Intrinsics3.checkNotNullParameter(playerView, "playerView");
        this.mediaSource = mediaSource;
        SimpleExoPlayer simpleExoPlayer = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer.n0();
        simpleExoPlayer.w = 1;
        int i = 4;
        simpleExoPlayer.j0(2, 4, 1);
        playerView.setPlayer(this.exoPlayer);
        if (playerControlView != null) {
            playerControlView.setPlayer(this.exoPlayer);
        }
        DataSource3.a aVar = this.dataSourceFactory;
        j jVar = new j(new DefaultExtractorsFactory());
        DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
        DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        Uri uri = mediaSource.progressiveMediaUri;
        Bundleable.a<MediaItem2> aVar2 = MediaItem2.j;
        MediaItem2.d.a aVar3 = new MediaItem2.d.a();
        MediaItem2.f.a aVar4 = new MediaItem2.f.a(null);
        List listEmptyList = Collections.emptyList();
        ImmutableList2<Object> immutableList2 = RegularImmutableList.l;
        MediaItem2.g.a aVar5 = new MediaItem2.g.a();
        AnimatableValueParser.D(aVar4.f1037b == null || aVar4.a != null);
        MediaItem2.i iVar = uri != null ? new MediaItem2.i(uri, null, aVar4.a != null ? new MediaItem2.f(aVar4, null) : null, null, listEmptyList, null, immutableList2, null, null) : null;
        MediaItem2 mediaItem2 = new MediaItem2("", aVar3.a(), iVar, new MediaItem2.g(aVar5, null), MediaMetadata.j, null);
        Objects.requireNonNull(iVar);
        MediaItem2.f fVar = iVar.c;
        if (fVar == null || Util2.a < 18) {
            drmSessionManager2 = DrmSessionManager2.a;
        } else {
            synchronized (defaultDrmSessionManagerProvider.a) {
                if (!Util2.a(fVar, defaultDrmSessionManagerProvider.f1155b)) {
                    defaultDrmSessionManagerProvider.f1155b = fVar;
                    defaultDrmSessionManagerProvider.c = defaultDrmSessionManagerProvider.a(fVar);
                }
                drmSessionManager2 = defaultDrmSessionManagerProvider.c;
                Objects.requireNonNull(drmSessionManager2);
            }
        }
        ProgressiveMediaSource progressiveMediaSource = new ProgressiveMediaSource(mediaItem2, aVar, jVar, drmSessionManager2, defaultLoadErrorHandlingPolicy, 1048576, null);
        Intrinsics3.checkNotNullExpressionValue(progressiveMediaSource, "ProgressiveMediaSource.F…rce.progressiveMediaUri))");
        SimpleExoPlayer simpleExoPlayer2 = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer2.n0();
        ExoPlayerImpl exoPlayerImpl = simpleExoPlayer2.e;
        Objects.requireNonNull(exoPlayerImpl);
        List listSingletonList = Collections.singletonList(progressiveMediaSource);
        exoPlayerImpl.h0();
        exoPlayerImpl.T();
        exoPlayerImpl.f960x++;
        if (!exoPlayerImpl.m.isEmpty()) {
            exoPlayerImpl.p0(0, exoPlayerImpl.m.size());
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            MediaSourceList.c cVar = new MediaSourceList.c((MediaSource2) listSingletonList.get(i2), exoPlayerImpl.n);
            arrayList.add(cVar);
            exoPlayerImpl.m.add(i2 + 0, new ExoPlayerImpl.a(cVar.f1139b, cVar.a.n));
        }
        ShuffleOrder shuffleOrderF = exoPlayerImpl.B.f(0, arrayList.size());
        exoPlayerImpl.B = shuffleOrderF;
        PlaylistTimeline playlistTimeline = new PlaylistTimeline(exoPlayerImpl.m, shuffleOrderF);
        if (!playlistTimeline.q() && -1 >= playlistTimeline.n) {
            throw new IllegalSeekPositionException(playlistTimeline, -1, -9223372036854775807L);
        }
        int iA = playlistTimeline.a(exoPlayerImpl.w);
        PlaybackInfo playbackInfoL0 = exoPlayerImpl.l0(exoPlayerImpl.F, playlistTimeline, exoPlayerImpl.i0(playlistTimeline, iA, -9223372036854775807L));
        int i3 = playbackInfoL0.f;
        if (iA == -1 || i3 == 1) {
            i = i3;
        } else if (!playlistTimeline.q() && iA < playlistTimeline.n) {
            i = 2;
        }
        PlaybackInfo playbackInfoF = playbackInfoL0.f(i);
        ((SystemHandlerWrapper.b) exoPlayerImpl.i.q.i(17, new ExoPlayerImplInternal2.a(arrayList, exoPlayerImpl.B, iA, Util2.B(-9223372036854775807L), null))).b();
        exoPlayerImpl.s0(playbackInfoF, 0, 1, false, (exoPlayerImpl.F.c.a.equals(playbackInfoF.c.a) || exoPlayerImpl.F.f1146b.q()) ? false : true, 4, exoPlayerImpl.g0(playbackInfoF), -1);
        ((SimpleExoPlayer) this.exoPlayer).a();
        if (autoPlayWhenReady) {
            ((SimpleExoPlayer) this.exoPlayer).u(true);
        }
        if (initialSeekPositionMs > 0) {
            BasePlayer basePlayer = (BasePlayer) this.exoPlayer;
            basePlayer.h(basePlayer.C(), initialSeekPositionMs);
        }
        SimpleExoPlayer simpleExoPlayer3 = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer3.n0();
        simpleExoPlayer3.e.E(loopMedia ? 1 : 0);
    }

    @MainThread
    public final void c() {
        AudioTrack audioTrack;
        ((SimpleExoPlayer) this.exoPlayer).u(false);
        Subscription subscription = this.positionPollingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.compositeSubscription.unsubscribe();
        SimpleExoPlayer simpleExoPlayer = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer.n0();
        if (Util2.a < 21 && (audioTrack = simpleExoPlayer.p) != null) {
            audioTrack.release();
            simpleExoPlayer.p = null;
        }
        simpleExoPlayer.j.a(false);
        StreamVolumeManager streamVolumeManager = simpleExoPlayer.l;
        StreamVolumeManager.c cVar = streamVolumeManager.e;
        if (cVar != null) {
            try {
                streamVolumeManager.a.unregisterReceiver(cVar);
            } catch (RuntimeException e) {
                Log2.c("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            streamVolumeManager.e = null;
        }
        WakeLockManager wakeLockManager = simpleExoPlayer.m;
        wakeLockManager.d = false;
        wakeLockManager.a();
        WifiLockManager wifiLockManager = simpleExoPlayer.n;
        wifiLockManager.d = false;
        wifiLockManager.a();
        AudioFocusManager audioFocusManager = simpleExoPlayer.k;
        audioFocusManager.c = null;
        audioFocusManager.a();
        simpleExoPlayer.e.n0();
        final AnalyticsCollector analyticsCollector = simpleExoPlayer.i;
        HandlerWrapper handlerWrapper = analyticsCollector.q;
        AnimatableValueParser.H(handlerWrapper);
        handlerWrapper.b(new Runnable() { // from class: b.i.a.c.s2.p
            @Override // java.lang.Runnable
            public final void run() {
                AnalyticsCollector analyticsCollector2 = analyticsCollector;
                final AnalyticsListener.a aVarK0 = analyticsCollector2.k0();
                ListenerSet.a<AnalyticsListener> aVar = new ListenerSet.a() { // from class: b.i.a.c.s2.x0
                    @Override // b.i.a.c.f3.ListenerSet.a
                    public final void invoke(Object obj) {
                        ((AnalyticsListener) obj).E();
                    }
                };
                analyticsCollector2.n.put(1036, aVarK0);
                ListenerSet<AnalyticsListener> listenerSet = analyticsCollector2.o;
                listenerSet.b(1036, aVar);
                listenerSet.a();
                analyticsCollector2.o.c();
            }
        });
        simpleExoPlayer.i0();
        Surface surface = simpleExoPlayer.r;
        if (surface != null) {
            surface.release();
            simpleExoPlayer.r = null;
        }
        if (simpleExoPlayer.G) {
            Objects.requireNonNull(null);
            throw null;
        }
        simpleExoPlayer.D = Collections.emptyList();
    }

    @MainThread
    public final void d(float volume) {
        SimpleExoPlayer simpleExoPlayer = (SimpleExoPlayer) this.exoPlayer;
        simpleExoPlayer.n0();
        float fG = Util2.g(volume, 0.0f, 1.0f);
        if (simpleExoPlayer.B != fG) {
            simpleExoPlayer.B = fG;
            simpleExoPlayer.j0(1, 2, Float.valueOf(simpleExoPlayer.k.g * fG));
            simpleExoPlayer.i.w(fG);
            Iterator<Player2.e> it = simpleExoPlayer.h.iterator();
            while (it.hasNext()) {
                it.next().w(fG);
            }
        }
        this.volumeSubject.onNext(Float.valueOf(volume));
    }
}
