package com.discord.player;

import android.media.AudioTrack;
import android.net.Uri;
import android.view.Surface;
import androidx.annotation.MainThread;
import b.a.p.a;
import b.a.p.b;
import b.a.p.c;
import b.a.p.d;
import b.a.p.e;
import b.a.p.f;
import b.a.p.k;
import b.a.p.k$a;
import b.a.p.k$b;
import b.a.p.k$c;
import b.i.a.c.a3.a0;
import b.i.a.c.a3.f0;
import b.i.a.c.a3.j;
import b.i.a.c.a3.k0;
import b.i.a.c.c2;
import b.i.a.c.e1;
import b.i.a.c.e3.l$a;
import b.i.a.c.e3.s;
import b.i.a.c.f1;
import b.i.a.c.f1$a;
import b.i.a.c.f3.b0$b;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.o;
import b.i.a.c.f3.q;
import b.i.a.c.h1$a;
import b.i.a.c.k2;
import b.i.a.c.m2;
import b.i.a.c.m2$c;
import b.i.a.c.o1;
import b.i.a.c.o1$d$a;
import b.i.a.c.o1$f;
import b.i.a.c.o1$f$a;
import b.i.a.c.o1$g;
import b.i.a.c.o1$g$a;
import b.i.a.c.o1$i;
import b.i.a.c.p1;
import b.i.a.c.q2;
import b.i.a.c.r2;
import b.i.a.c.s2.g1;
import b.i.a.c.t0;
import b.i.a.c.u0;
import b.i.a.c.u1$c;
import b.i.a.c.w0$a;
import b.i.a.c.w1;
import b.i.a.c.w2.r;
import b.i.a.c.w2.u;
import b.i.a.c.y1$e;
import b.i.b.b.h0;
import b.i.b.b.p;
import com.discord.utilities.logging.Logger;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import rx.Scheduler;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final PublishSubject<AppMediaPlayer$Event> eventSubject;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Subscription positionPollingSubscription;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final CompositeSubscription compositeSubscription;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final BehaviorSubject<Float> volumeSubject;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public MediaSource mediaSource;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final e1 exoPlayer;

    /* JADX INFO: renamed from: g, reason: from kotlin metadata */
    public final k rxPlayerEventListener;

    /* JADX INFO: renamed from: h, reason: from kotlin metadata */
    public final l$a dataSourceFactory;

    /* JADX INFO: renamed from: i, reason: from kotlin metadata */
    public final Scheduler timerScheduler;

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Logger logger;

    public AppMediaPlayer(e1 e1Var, k kVar, l$a l_a, Scheduler scheduler, Logger logger) {
        m.checkNotNullParameter(e1Var, "exoPlayer");
        m.checkNotNullParameter(kVar, "rxPlayerEventListener");
        m.checkNotNullParameter(l_a, "dataSourceFactory");
        m.checkNotNullParameter(scheduler, "timerScheduler");
        m.checkNotNullParameter(logger, "logger");
        this.exoPlayer = e1Var;
        this.rxPlayerEventListener = kVar;
        this.dataSourceFactory = l_a;
        this.timerScheduler = scheduler;
        this.logger = logger;
        PublishSubject<AppMediaPlayer$Event> publishSubjectK0 = PublishSubject.k0();
        m.checkNotNullExpressionValue(publishSubjectK0, "PublishSubject.create()");
        this.eventSubject = publishSubjectK0;
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        this.compositeSubscription = compositeSubscription;
        BehaviorSubject<Float> behaviorSubjectL0 = BehaviorSubject.l0(Float.valueOf(((k2) e1Var).B));
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(exoPlayer.volume)");
        this.volumeSubject = behaviorSubjectL0;
        PublishSubject<k$c> publishSubject = kVar.j;
        m.checkNotNullExpressionValue(publishSubject, "playerStateChangeSubject");
        compositeSubscription.a(publishSubject.K().W(new e(this), new f(this)));
        PublishSubject<k$a> publishSubject2 = kVar.k;
        m.checkNotNullExpressionValue(publishSubject2, "isPlayingChangeSubject");
        compositeSubscription.a(publishSubject2.L().W(new a(this), new b(this)));
        MediaSource mediaSource = this.mediaSource;
        String str = (mediaSource == null || (str = mediaSource.featureTag) == null) ? "" : str;
        PublishSubject<k$b> publishSubject3 = kVar.l;
        m.checkNotNullExpressionValue(publishSubject3, "playerErrorSubject");
        compositeSubscription.a(publishSubject3.K().W(new c(this, str), new d(this)));
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
        u uVar;
        m.checkNotNullParameter(mediaSource, "mediaSource");
        m.checkNotNullParameter(playerView, "playerView");
        this.mediaSource = mediaSource;
        k2 k2Var = (k2) this.exoPlayer;
        k2Var.n0();
        k2Var.w = 1;
        int i = 4;
        k2Var.j0(2, 4, 1);
        playerView.setPlayer(this.exoPlayer);
        if (playerControlView != null) {
            playerControlView.setPlayer(this.exoPlayer);
        }
        l$a l_a = this.dataSourceFactory;
        j jVar = new j(new b.i.a.c.x2.f());
        r rVar = new r();
        s sVar = new s();
        Uri uri = mediaSource.progressiveMediaUri;
        w0$a<o1> w0_a = o1.j;
        o1$d$a o1_d_a = new o1$d$a();
        o1$f$a o1_f_a = new o1$f$a(null);
        List listEmptyList = Collections.emptyList();
        p<Object> pVar = h0.l;
        o1$g$a o1_g_a = new o1$g$a();
        b.c.a.a0.d.D(o1_f_a.f1037b == null || o1_f_a.a != null);
        o1$i o1_i = uri != null ? new o1$i(uri, null, o1_f_a.a != null ? new o1$f(o1_f_a, null) : null, null, listEmptyList, null, pVar, null, null) : null;
        o1 o1Var = new o1("", o1_d_a.a(), o1_i, new o1$g(o1_g_a, null), p1.j, null);
        Objects.requireNonNull(o1_i);
        o1$f o1_f = o1_i.c;
        if (o1_f == null || e0.a < 18) {
            uVar = u.a;
        } else {
            synchronized (rVar.a) {
                if (!e0.a(o1_f, rVar.f1155b)) {
                    rVar.f1155b = o1_f;
                    rVar.c = rVar.a(o1_f);
                }
                uVar = rVar.c;
                Objects.requireNonNull(uVar);
            }
        }
        f0 f0Var = new f0(o1Var, l_a, jVar, uVar, sVar, 1048576, null);
        m.checkNotNullExpressionValue(f0Var, "ProgressiveMediaSource.F…rce.progressiveMediaUri))");
        k2 k2Var2 = (k2) this.exoPlayer;
        k2Var2.n0();
        f1 f1Var = k2Var2.e;
        Objects.requireNonNull(f1Var);
        List listSingletonList = Collections.singletonList(f0Var);
        f1Var.h0();
        f1Var.T();
        f1Var.f960x++;
        if (!f1Var.m.isEmpty()) {
            f1Var.p0(0, f1Var.m.size());
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < listSingletonList.size(); i2++) {
            u1$c u1_c = new u1$c((a0) listSingletonList.get(i2), f1Var.n);
            arrayList.add(u1_c);
            f1Var.m.add(i2 + 0, new f1$a(u1_c.f1139b, u1_c.a.n));
        }
        k0 k0VarF = f1Var.B.f(0, arrayList.size());
        f1Var.B = k0VarF;
        c2 c2Var = new c2(f1Var.m, k0VarF);
        if (!c2Var.q() && -1 >= c2Var.n) {
            throw new IllegalSeekPositionException(c2Var, -1, -9223372036854775807L);
        }
        int iA = c2Var.a(f1Var.w);
        w1 w1VarL0 = f1Var.l0(f1Var.F, c2Var, f1Var.i0(c2Var, iA, -9223372036854775807L));
        int i3 = w1VarL0.f;
        if (iA == -1 || i3 == 1) {
            i = i3;
        } else if (!c2Var.q() && iA < c2Var.n) {
            i = 2;
        }
        w1 w1VarF = w1VarL0.f(i);
        ((b0$b) f1Var.i.q.i(17, new h1$a(arrayList, f1Var.B, iA, e0.B(-9223372036854775807L), null))).b();
        f1Var.s0(w1VarF, 0, 1, false, (f1Var.F.c.a.equals(w1VarF.c.a) || f1Var.F.f1146b.q()) ? false : true, 4, f1Var.g0(w1VarF), -1);
        ((k2) this.exoPlayer).a();
        if (autoPlayWhenReady) {
            ((k2) this.exoPlayer).u(true);
        }
        if (initialSeekPositionMs > 0) {
            u0 u0Var = (u0) this.exoPlayer;
            u0Var.h(u0Var.C(), initialSeekPositionMs);
        }
        k2 k2Var3 = (k2) this.exoPlayer;
        k2Var3.n0();
        k2Var3.e.E(loopMedia ? 1 : 0);
    }

    @MainThread
    public final void c() {
        AudioTrack audioTrack;
        ((k2) this.exoPlayer).u(false);
        Subscription subscription = this.positionPollingSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.compositeSubscription.unsubscribe();
        k2 k2Var = (k2) this.exoPlayer;
        k2Var.n0();
        if (e0.a < 21 && (audioTrack = k2Var.p) != null) {
            audioTrack.release();
            k2Var.p = null;
        }
        k2Var.j.a(false);
        m2 m2Var = k2Var.l;
        m2$c m2_c = m2Var.e;
        if (m2_c != null) {
            try {
                m2Var.a.unregisterReceiver(m2_c);
            } catch (RuntimeException e) {
                q.c("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            m2Var.e = null;
        }
        q2 q2Var = k2Var.m;
        q2Var.d = false;
        q2Var.a();
        r2 r2Var = k2Var.n;
        r2Var.d = false;
        r2Var.a();
        t0 t0Var = k2Var.k;
        t0Var.c = null;
        t0Var.a();
        k2Var.e.n0();
        g1 g1Var = k2Var.i;
        o oVar = g1Var.q;
        b.c.a.a0.d.H(oVar);
        oVar.b(new b.i.a.c.s2.p(g1Var));
        k2Var.i0();
        Surface surface = k2Var.r;
        if (surface != null) {
            surface.release();
            k2Var.r = null;
        }
        if (k2Var.G) {
            Objects.requireNonNull(null);
            throw null;
        }
        k2Var.D = Collections.emptyList();
    }

    @MainThread
    public final void d(float volume) {
        k2 k2Var = (k2) this.exoPlayer;
        k2Var.n0();
        float fG = e0.g(volume, 0.0f, 1.0f);
        if (k2Var.B != fG) {
            k2Var.B = fG;
            k2Var.j0(1, 2, Float.valueOf(k2Var.k.g * fG));
            k2Var.i.w(fG);
            Iterator<y1$e> it = k2Var.h.iterator();
            while (it.hasNext()) {
                it.next().w(fG);
            }
        }
        this.volumeSubject.onNext(Float.valueOf(volume));
    }
}
