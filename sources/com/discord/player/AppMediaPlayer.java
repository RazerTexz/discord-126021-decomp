package com.discord.player;

import android.media.AudioTrack;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.MainThread;
import com.discord.utilities.logging.Logger;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.p505ui.PlayerControlView;
import com.google.android.exoplayer2.p505ui.PlayerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p040p.C1176a;
import p007b.p008a.p040p.C1177b;
import p007b.p008a.p040p.C1178c;
import p007b.p008a.p040p.C1179d;
import p007b.p008a.p040p.C1180e;
import p007b.p008a.p040p.C1181f;
import p007b.p008a.p040p.C1186k;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p242c.AbstractC2944u0;
import p007b.p225i.p226a.p242c.C2634c2;
import p007b.p225i.p226a.p242c.C2727f1;
import p007b.p225i.p226a.p242c.C2803h1;
import p007b.p225i.p226a.p242c.C2816k2;
import p007b.p225i.p226a.p242c.C2824m2;
import p007b.p225i.p226a.p242c.C2831o1;
import p007b.p225i.p226a.p242c.C2835p1;
import p007b.p225i.p226a.p242c.C2840q2;
import p007b.p225i.p226a.p242c.C2844r2;
import p007b.p225i.p226a.p242c.C2909t0;
import p007b.p225i.p226a.p242c.C2945u1;
import p007b.p225i.p226a.p242c.C2964w1;
import p007b.p225i.p226a.p242c.InterfaceC2677e1;
import p007b.p225i.p226a.p242c.InterfaceC2963w0;
import p007b.p225i.p226a.p242c.InterfaceC3128y1;
import p007b.p225i.p226a.p242c.p243a3.C2540f0;
import p007b.p225i.p226a.p242c.p243a3.C2547j;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2550k0;
import p007b.p225i.p226a.p242c.p257e3.C2717s;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l;
import p007b.p225i.p226a.p242c.p259f3.C2732b0;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2749p;
import p007b.p225i.p226a.p242c.p259f3.C2750q;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2748o;
import p007b.p225i.p226a.p242c.p262s2.C2868g1;
import p007b.p225i.p226a.p242c.p266w2.C2987r;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u;
import p007b.p225i.p226a.p242c.p267x2.C3017f;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4508h0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Scheduler;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.PublishSubject;
import p658rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final PublishSubject<Event> eventSubject;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public Subscription positionPollingSubscription;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final CompositeSubscription compositeSubscription;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final BehaviorSubject<Float> volumeSubject;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public MediaSource mediaSource;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final InterfaceC2677e1 exoPlayer;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final C1186k rxPlayerEventListener;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final InterfaceC2710l.a dataSourceFactory;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Scheduler timerScheduler;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Logger logger;

    /* JADX INFO: compiled from: AppMediaPlayer.kt */
    public static abstract class Event {

        /* JADX INFO: renamed from: com.discord.player.AppMediaPlayer$Event$a */
        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class C5583a extends Event {

            /* JADX INFO: renamed from: a */
            public static final C5583a f18654a = new C5583a();

            public C5583a() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.player.AppMediaPlayer$Event$b */
        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class C5584b extends Event {

            /* JADX INFO: renamed from: a */
            public static final C5584b f18655a = new C5584b();

            public C5584b() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.player.AppMediaPlayer$Event$c */
        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class C5585c extends Event {

            /* JADX INFO: renamed from: a */
            public final long f18656a;

            public C5585c(long j) {
                super(null);
                this.f18656a = j;
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C5585c) && this.f18656a == ((C5585c) obj).f18656a;
                }
                return true;
            }

            public int hashCode() {
                return C0002b.m3a(this.f18656a);
            }

            public String toString() {
                return C1643a.m815C(C1643a.m833U("CurrentPositionUpdate(positionMs="), this.f18656a, ")");
            }
        }

        /* JADX INFO: renamed from: com.discord.player.AppMediaPlayer$Event$d */
        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class C5586d extends Event {

            /* JADX INFO: renamed from: a */
            public static final C5586d f18657a = new C5586d();

            public C5586d() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.player.AppMediaPlayer$Event$e */
        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class C5587e extends Event {

            /* JADX INFO: renamed from: a */
            public static final C5587e f18658a = new C5587e();

            public C5587e() {
                super(null);
            }
        }

        /* JADX INFO: renamed from: com.discord.player.AppMediaPlayer$Event$f */
        /* JADX INFO: compiled from: AppMediaPlayer.kt */
        public static final class C5588f extends Event {

            /* JADX INFO: renamed from: a */
            public static final C5588f f18659a = new C5588f();

            public C5588f() {
                super(null);
            }
        }

        public Event() {
        }

        public Event(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public AppMediaPlayer(InterfaceC2677e1 interfaceC2677e1, C1186k c1186k, InterfaceC2710l.a aVar, Scheduler scheduler, Logger logger) {
        C12238m.checkNotNullParameter(interfaceC2677e1, "exoPlayer");
        C12238m.checkNotNullParameter(c1186k, "rxPlayerEventListener");
        C12238m.checkNotNullParameter(aVar, "dataSourceFactory");
        C12238m.checkNotNullParameter(scheduler, "timerScheduler");
        C12238m.checkNotNullParameter(logger, "logger");
        this.exoPlayer = interfaceC2677e1;
        this.rxPlayerEventListener = c1186k;
        this.dataSourceFactory = aVar;
        this.timerScheduler = scheduler;
        this.logger = logger;
        PublishSubject<Event> publishSubjectM11133k0 = PublishSubject.m11133k0();
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "PublishSubject.create()");
        this.eventSubject = publishSubjectM11133k0;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        this.compositeSubscription = compositeSubscription;
        BehaviorSubject<Float> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(Float.valueOf(((C2816k2) interfaceC2677e1).f7198B));
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(exoPlayer.volume)");
        this.volumeSubject = behaviorSubjectM11130l0;
        PublishSubject<C1186k.c> publishSubject = c1186k.f1590j;
        C12238m.checkNotNullExpressionValue(publishSubject, "playerStateChangeSubject");
        compositeSubscription.m11136a(publishSubject.m11085K().m11097W(new C1180e(this), new C1181f(this)));
        PublishSubject<C1186k.a> publishSubject2 = c1186k.f1591k;
        C12238m.checkNotNullExpressionValue(publishSubject2, "isPlayingChangeSubject");
        compositeSubscription.m11136a(publishSubject2.m11086L().m11097W(new C1176a(this), new C1177b(this)));
        MediaSource mediaSource = this.mediaSource;
        String str = (mediaSource == null || (str = mediaSource.featureTag) == null) ? "" : str;
        PublishSubject<C1186k.b> publishSubject3 = c1186k.f1592l;
        C12238m.checkNotNullExpressionValue(publishSubject3, "playerErrorSubject");
        compositeSubscription.m11136a(publishSubject3.m11085K().m11097W(new C1178c(this, str), new C1179d(this)));
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m8438b(AppMediaPlayer appMediaPlayer, MediaSource mediaSource, boolean z2, boolean z3, long j, PlayerView playerView, PlayerControlView playerControlView, int i) {
        int i2 = i & 32;
        appMediaPlayer.m8439a(mediaSource, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? false : z3, (i & 8) != 0 ? 0L : j, playerView, null);
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
    /* JADX INFO: renamed from: a */
    public final void m8439a(MediaSource mediaSource, boolean autoPlayWhenReady, boolean loopMedia, long initialSeekPositionMs, PlayerView playerView, PlayerControlView playerControlView) {
        InterfaceC2990u interfaceC2990u;
        C12238m.checkNotNullParameter(mediaSource, "mediaSource");
        C12238m.checkNotNullParameter(playerView, "playerView");
        this.mediaSource = mediaSource;
        C2816k2 c2816k2 = (C2816k2) this.exoPlayer;
        c2816k2.m3290n0();
        c2816k2.f7227w = 1;
        int i = 4;
        c2816k2.m3286j0(2, 4, 1);
        playerView.setPlayer(this.exoPlayer);
        if (playerControlView != null) {
            playerControlView.setPlayer(this.exoPlayer);
        }
        InterfaceC2710l.a aVar = this.dataSourceFactory;
        C2547j c2547j = new C2547j(new C3017f());
        C2987r c2987r = new C2987r();
        C2717s c2717s = new C2717s();
        Uri uri = mediaSource.progressiveMediaUri;
        InterfaceC2963w0.a<C2831o1> aVar2 = C2831o1.f7261j;
        C2831o1.d.a aVar3 = new C2831o1.d.a();
        C2831o1.f.a aVar4 = new C2831o1.f.a(null);
        List listEmptyList = Collections.emptyList();
        AbstractC4523p<Object> abstractC4523p = C4508h0.f12012l;
        C2831o1.g.a aVar5 = new C2831o1.g.a();
        C1460d.m426D(aVar4.f7299b == null || aVar4.f7298a != null);
        C2831o1.i iVar = uri != null ? new C2831o1.i(uri, null, aVar4.f7298a != null ? new C2831o1.f(aVar4, null) : null, null, listEmptyList, null, abstractC4523p, null, null) : null;
        C2831o1 c2831o1 = new C2831o1("", aVar3.m3322a(), iVar, new C2831o1.g(aVar5, null), C2835p1.f7368j, null);
        Objects.requireNonNull(iVar);
        C2831o1.f fVar = iVar.f7320c;
        if (fVar == null || C2738e0.f6708a < 18) {
            interfaceC2990u = InterfaceC2990u.f8017a;
        } else {
            synchronized (c2987r.f8009a) {
                if (!C2738e0.m2993a(fVar, c2987r.f8010b)) {
                    c2987r.f8010b = fVar;
                    c2987r.f8011c = c2987r.m3586a(fVar);
                }
                interfaceC2990u = c2987r.f8011c;
                Objects.requireNonNull(interfaceC2990u);
            }
        }
        C2540f0 c2540f0 = new C2540f0(c2831o1, aVar, c2547j, interfaceC2990u, c2717s, 1048576, null);
        C12238m.checkNotNullExpressionValue(c2540f0, "ProgressiveMediaSource.F…rce.progressiveMediaUri))");
        C2816k2 c2816k3 = (C2816k2) this.exoPlayer;
        c2816k3.m3290n0();
        C2727f1 c2727f1 = c2816k3.f7209e;
        Objects.requireNonNull(c2727f1);
        List listSingletonList = Collections.singletonList(c2540f0);
        c2727f1.m2905h0();
        c2727f1.mo2894T();
        c2727f1.f6681x++;
        if (!c2727f1.f6670m.isEmpty()) {
            c2727f1.m2919p0(0, c2727f1.f6670m.size());
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            C2945u1.c cVar = new C2945u1.c((InterfaceC2530a0) listSingletonList.get(i2), c2727f1.f6671n);
            arrayList.add(cVar);
            c2727f1.f6670m.add(i2 + 0, new C2727f1.a(cVar.f7883b, cVar.f7882a.f5716n));
        }
        InterfaceC2550k0 interfaceC2550k0Mo2548f = c2727f1.f6653B.mo2548f(0, arrayList.size());
        c2727f1.f6653B = interfaceC2550k0Mo2548f;
        C2634c2 c2634c2 = new C2634c2(c2727f1.f6670m, interfaceC2550k0Mo2548f);
        if (!c2634c2.m3331q() && -1 >= c2634c2.f6170n) {
            throw new IllegalSeekPositionException(c2634c2, -1, -9223372036854775807L);
        }
        int iMo2582a = c2634c2.mo2582a(c2727f1.f6680w);
        C2964w1 c2964w1M2911l0 = c2727f1.m2911l0(c2727f1.f6657F, c2634c2, c2727f1.m2907i0(c2634c2, iMo2582a, -9223372036854775807L));
        int i3 = c2964w1M2911l0.f7951f;
        if (iMo2582a == -1 || i3 == 1) {
            i = i3;
        } else if (!c2634c2.m3331q() && iMo2582a < c2634c2.f6170n) {
            i = 2;
        }
        C2964w1 c2964w1M3567f = c2964w1M2911l0.m3567f(i);
        ((C2732b0.b) c2727f1.f6666i.f7083q.mo2962i(17, new C2803h1.a(arrayList, c2727f1.f6653B, iMo2582a, C2738e0.m2981B(-9223372036854775807L), null))).m2965b();
        c2727f1.m2924s0(c2964w1M3567f, 0, 1, false, (c2727f1.f6657F.f7948c.f5732a.equals(c2964w1M3567f.f7948c.f5732a) || c2727f1.f6657F.f7947b.m3331q()) ? false : true, 4, c2727f1.m2903g0(c2964w1M3567f), -1);
        ((C2816k2) this.exoPlayer).mo2896a();
        if (autoPlayWhenReady) {
            ((C2816k2) this.exoPlayer).mo2926u(true);
        }
        if (initialSeekPositionMs > 0) {
            AbstractC2944u0 abstractC2944u0 = (AbstractC2944u0) this.exoPlayer;
            abstractC2944u0.mo2904h(abstractC2944u0.mo2881C(), initialSeekPositionMs);
        }
        C2816k2 c2816k4 = (C2816k2) this.exoPlayer;
        c2816k4.m3290n0();
        c2816k4.f7209e.mo2882E(loopMedia ? 1 : 0);
    }

    @MainThread
    /* JADX INFO: renamed from: c */
    public final void m8440c() {
        AudioTrack audioTrack;
        ((C2816k2) this.exoPlayer).mo2926u(false);
        Subscription subscription = this.positionPollingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.compositeSubscription.unsubscribe();
        C2816k2 c2816k2 = (C2816k2) this.exoPlayer;
        c2816k2.m3290n0();
        if (C2738e0.f6708a < 21 && (audioTrack = c2816k2.f7220p) != null) {
            audioTrack.release();
            c2816k2.f7220p = null;
        }
        c2816k2.f7214j.m3363a(false);
        C2824m2 c2824m2 = c2816k2.f7216l;
        C2824m2.c cVar = c2824m2.f7250e;
        if (cVar != null) {
            try {
                c2824m2.f7246a.unregisterReceiver(cVar);
            } catch (RuntimeException e) {
                C2750q.m3040c("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            c2824m2.f7250e = null;
        }
        C2840q2 c2840q2 = c2816k2.f7217m;
        c2840q2.f7460d = false;
        c2840q2.m3357a();
        C2844r2 c2844r2 = c2816k2.f7218n;
        c2844r2.f7477d = false;
        c2844r2.m3362a();
        C2909t0 c2909t0 = c2816k2.f7215k;
        c2909t0.f7660c = null;
        c2909t0.m3460a();
        c2816k2.f7209e.m2915n0();
        final C2868g1 c2868g1 = c2816k2.f7213i;
        InterfaceC2748o interfaceC2748o = c2868g1.f7554q;
        C1460d.m438H(interfaceC2748o);
        interfaceC2748o.mo2955b(new Runnable() { // from class: b.i.a.c.s2.p
            @Override // java.lang.Runnable
            public final void run() {
                C2868g1 c2868g2 = c2868g1;
                final InterfaceC2871h1.a aVarM3382k0 = c2868g2.m3382k0();
                C2749p.a<InterfaceC2871h1> aVar = new C2749p.a() { // from class: b.i.a.c.s2.x0
                    @Override // p007b.p225i.p226a.p242c.p259f3.C2749p.a
                    public final void invoke(Object obj) {
                        ((InterfaceC2871h1) obj).m3396E();
                    }
                };
                c2868g2.f7551n.put(1036, aVarM3382k0);
                C2749p<InterfaceC2871h1> c2749p = c2868g2.f7552o;
                c2749p.m3035b(1036, aVar);
                c2749p.m3034a();
                c2868g2.f7552o.m3036c();
            }
        });
        c2816k2.m3285i0();
        Surface surface = c2816k2.f7222r;
        if (surface != null) {
            surface.release();
            c2816k2.f7222r = null;
        }
        if (c2816k2.f7203G) {
            Objects.requireNonNull(null);
            throw null;
        }
        c2816k2.f7200D = Collections.emptyList();
    }

    @MainThread
    /* JADX INFO: renamed from: d */
    public final void m8441d(float volume) {
        C2816k2 c2816k2 = (C2816k2) this.exoPlayer;
        c2816k2.m3290n0();
        float fM2999g = C2738e0.m2999g(volume, 0.0f, 1.0f);
        if (c2816k2.f7198B != fM2999g) {
            c2816k2.f7198B = fM2999g;
            c2816k2.m3286j0(1, 2, Float.valueOf(c2816k2.f7215k.f7664g * fM2999g));
            c2816k2.f7213i.mo263w(fM2999g);
            Iterator<InterfaceC3128y1.e> it = c2816k2.f7212h.iterator();
            while (it.hasNext()) {
                it.next().mo263w(fM2999g);
            }
        }
        this.volumeSubject.onNext(Float.valueOf(volume));
    }
}
