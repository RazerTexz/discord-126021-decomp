package b.a.q.m0.c;

import android.content.Context;
import android.os.Build;
import androidx.annotation.AnyThread;
import b.a.q.e0;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngine$AudioInfo;
import com.discord.rtcconnection.mediaengine.MediaEngine$EchoCancellationInfo;
import com.discord.rtcconnection.mediaengine.MediaEngine$LocalVoiceStatus;
import com.discord.rtcconnection.mediaengine.MediaEngine$OpenSLESConfig;
import com.discord.rtcconnection.mediaengine.MediaEngine$OpenSLUsageMode;
import com.discord.rtcconnection.mediaengine.MediaEngine$VoiceConfig;
import com.discord.rtcconnection.mediaengine.MediaEngine$a;
import com.discord.rtcconnection.mediaengine.MediaEngine$b;
import com.discord.rtcconnection.mediaengine.MediaEngine$c;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$Type;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
import d0.t.n0;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.webrtc.Logging;
import org.webrtc.voiceengine.WebRtcAudioManager;
import rx.Emitter$BackpressureMode;
import rx.Observable;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k implements MediaEngine {
    public static final Set<String> a = n0.setOf((Object[]) new String[]{"Pixel", "Pixel XL", "Pixel 3a XL", "Pixel 4", "Pixel 4 XL", "Pixel 5"});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f271b = n0.setOf((Object[]) new String[]{"Pixel 3a", "Redmi Note 8 Pro", "Redmi Note 8 pro"});
    public final u c;
    public final List<MediaEngineConnection> d;
    public boolean e;
    public Discord f;
    public List<b.a.q.m0.a> g;
    public MediaEngine$OpenSLUsageMode h;
    public MediaEngine$EchoCancellationInfo i;
    public final Context j;
    public final MediaEngine$c k;
    public final b.a.q.c l;
    public final MediaEngine$OpenSLESConfig m;
    public final Logger n;
    public final b.a.q.k0.g o;
    public final MediaEngine$b p;
    public final Set<String> q;
    public final Set<String> r;

    public k(Context context, MediaEngine$c mediaEngine$c, b.a.q.c cVar, MediaEngine$OpenSLESConfig mediaEngine$OpenSLESConfig, Logger logger, b.a.q.k0.g gVar, MediaEngine$b mediaEngine$b, Set set, Set set2, int i) {
        Set<String> set3 = (i & 128) != 0 ? a : null;
        Set<String> set4 = (i & 256) != 0 ? f271b : null;
        d0.z.d.m.checkNotNullParameter(context, "context");
        d0.z.d.m.checkNotNullParameter(mediaEngine$c, "listener");
        d0.z.d.m.checkNotNullParameter(cVar, "mediaEngineThreadExecutor");
        d0.z.d.m.checkNotNullParameter(mediaEngine$OpenSLESConfig, "openSLESConfig");
        d0.z.d.m.checkNotNullParameter(logger, "logger");
        d0.z.d.m.checkNotNullParameter(gVar, "echoCancellation");
        d0.z.d.m.checkNotNullParameter(mediaEngine$b, "echoCancellationCallback");
        d0.z.d.m.checkNotNullParameter(set3, "defaultOpenSLAllowList");
        d0.z.d.m.checkNotNullParameter(set4, "defaultOpenSLExcludeList");
        this.j = context;
        this.k = mediaEngine$c;
        this.l = cVar;
        this.m = mediaEngine$OpenSLESConfig;
        this.n = logger;
        this.o = gVar;
        this.p = mediaEngine$b;
        this.q = set3;
        this.r = set4;
        this.c = new u();
        this.d = new ArrayList();
        this.e = true;
        this.h = MediaEngine$OpenSLUsageMode.ALLOW_LIST;
    }

    public static final void m(k kVar, MediaEngineConnection mediaEngineConnection) {
        synchronized (kVar) {
            Discord discord = kVar.f;
            if (discord != null) {
                discord.setLocalVoiceLevelChangedCallback(null);
            }
            kVar.d.remove(mediaEngineConnection);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public Observable<Unit> a() {
        if (this.g != null) {
            j0.l.e.k kVar = new j0.l.e.k(Unit.a);
            d0.z.d.m.checkNotNullExpressionValue(kVar, "Observable.just(Unit)");
            return kVar;
        }
        p();
        if (this.f == null) {
            Observable<Unit> observableX = Observable.x(new IllegalStateException("Failed to initialize native media engine"));
            d0.z.d.m.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…ze native media engine\"))");
            return observableX;
        }
        Observable observableO = Observable.o(new q(this), Emitter$BackpressureMode.NONE);
        d0.z.d.m.checkNotNullExpressionValue(observableO, "Observable.create({ emit…er.BackpressureMode.NONE)");
        Observable<Unit> observableG = observableO.u(new k$e(this)).G(k$f.j);
        d0.z.d.m.checkNotNullExpressionValue(observableG, "getSupportedVideoCodecs(…s }\n        .map { Unit }");
        return observableG;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void b(RtcRegion[] rtcRegionArr, Function1<? super String[], Unit> function1) {
        d0.z.d.m.checkNotNullParameter(rtcRegionArr, "regionsWithIps");
        d0.z.d.m.checkNotNullParameter(function1, "callback");
        p();
        Discord discord = this.f;
        if (discord != null) {
            discord.getRankedRtcRegions(rtcRegionArr, new r(function1));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public b.a.q.c c() {
        return this.l;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    @AnyThread
    public void d(MediaEngine$VoiceConfig mediaEngine$VoiceConfig) {
        d0.z.d.m.checkNotNullParameter(mediaEngine$VoiceConfig, "voiceConfig");
        o(new k$k(this, mediaEngine$VoiceConfig));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public Observable<MediaEngine$AudioInfo> e() {
        Observable<MediaEngine$AudioInfo> observableO = Observable.o(new k$d(this), Emitter$BackpressureMode.LATEST);
        d0.z.d.m.checkNotNullExpressionValue(observableO, "Observable.create({ emit….BackpressureMode.LATEST)");
        return observableO;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void f(int i) {
        Discord discord = this.f;
        if (discord != null) {
            discord.setVideoInputDevice(i);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public synchronized MediaEngineConnection g(long j, MediaEngine$a mediaEngine$a, MediaEngineConnection$Type mediaEngineConnection$Type, Function1<? super Exception, Unit> function1) {
        d0.z.d.m.checkNotNullParameter(mediaEngine$a, "options");
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$Type, "type");
        d0.z.d.m.checkNotNullParameter(function1, "onFailure");
        if (!(this.g != null)) {
            ((e0) function1).invoke(new IllegalStateException("connect() called on unprepared media engine."));
            return null;
        }
        Discord discord = this.f;
        if (discord == null) {
            Logger.e$default(this.n, "MediaEngineLegacy", "connect() called without voiceEngineLegacy.", null, null, 12, null);
            return null;
        }
        o(new k$a(this));
        Logger.i$default(this.n, "MediaEngineLegacy", "Connecting with options: " + mediaEngine$a, null, 4, null);
        k$c k_c = new k$c(this);
        b.a.q.c cVar = this.l;
        Logger logger = this.n;
        u uVar = this.c;
        List<b.a.q.m0.a> list = this.g;
        if (list == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("supportedVideoCodecs");
        }
        e eVar = new e(cVar, logger, uVar, discord, list, mediaEngineConnection$Type, j, mediaEngine$a, d0.t.m.listOf(k_c));
        this.d.add(eVar);
        n(new k$b(eVar));
        return eVar;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public synchronized List<MediaEngineConnection> getConnections() {
        return d0.t.u.toList(this.d);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void h(MediaEngine$OpenSLUsageMode mediaEngine$OpenSLUsageMode) {
        d0.z.d.m.checkNotNullParameter(mediaEngine$OpenSLUsageMode, "openSLUsageMode");
        if (this.f != null) {
            Logger.e$default(this.n, "MediaEngineLegacy", "setting openSLUsageMode too late", null, null, 12, null);
        }
        this.h = mediaEngine$OpenSLUsageMode;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public Discord i() {
        return this.f;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void j(Function1<? super VideoInputDeviceDescription[], Unit> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "devicesCallback");
        p();
        Discord discord = this.f;
        if (discord != null) {
            discord.getVideoInputDevices(new s(function1));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void k(boolean z2) {
        this.e = z2;
        Discord discord = this.f;
        if (discord != null) {
            discord.setAudioInputEnabled(z2);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void l(Function1<? super MediaEngine$LocalVoiceStatus, Unit> function1) {
        if (function1 == null) {
            Discord discord = this.f;
            if (discord != null) {
                discord.setLocalVoiceLevelChangedCallback(null);
                return;
            }
            return;
        }
        p();
        Discord discord2 = this.f;
        if (discord2 != null) {
            discord2.setLocalVoiceLevelChangedCallback(new k$g(function1));
        }
    }

    public final void n(Function1<? super MediaEngine$c, Unit> function1) {
        try {
            function1.invoke(this.k);
        } catch (Exception e) {
            Logger.e$default(this.n, "MediaEngineLegacy", "Error in listener", e, null, 8, null);
        }
    }

    public final Future<?> o(Function0<Unit> function0) {
        b.a.q.c cVar = this.l;
        Object tVar = function0;
        if (function0 != null) {
            tVar = new t(function0);
        }
        return cVar.submit((Runnable) tVar);
    }

    public final void p() {
        if (this.f != null) {
            return;
        }
        Logger logger = this.n;
        StringBuilder sbU = b.d.b.a.a.U("initializing voice engine. OpenSL ES: ");
        sbU.append(this.m);
        sbU.append(", OpenSL usage mode: ");
        sbU.append(this.h);
        Logger.i$default(logger, "MediaEngineLegacy", sbU.toString(), null, 4, null);
        int iOrdinal = this.m.ordinal();
        boolean zContains = false;
        if (iOrdinal == 0) {
            if (this.h == MediaEngine$OpenSLUsageMode.ALLOW_LIST) {
                zContains = this.q.contains(Build.MODEL);
            } else if (!this.r.contains(Build.MODEL)) {
                zContains = true;
            }
            Logger logger2 = this.n;
            StringBuilder sbU2 = b.d.b.a.a.U("OpenSL ES default. mode: ");
            sbU2.append(this.h);
            sbU2.append(", enableOpenSL: ");
            sbU2.append(zContains);
            sbU2.append(", model: '");
            Logger.i$default(logger2, "MediaEngineLegacy", b.d.b.a.a.H(sbU2, Build.MODEL, '\''), null, 4, null);
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(!zContains);
        } else if (iOrdinal == 1) {
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else if (iOrdinal == 2) {
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        Logging.externalReporter = new k$i(this);
        try {
            Discord discord = new Discord(this.j, 2);
            b.a.q.k0.g gVar = this.o;
            if (gVar.e) {
                discord.enableBuiltInAEC(true, new k$h(gVar, discord, this));
            }
            discord.setAudioInputEnabled(this.e);
            this.f = discord;
        } catch (ExceptionInInitializerError e) {
            Logger.e$default(this.n, "MediaEngineLegacy", "Unable to initialize voice engine.", e, null, 8, null);
        } catch (UnsatisfiedLinkError e2) {
            Logger.e$default(this.n, "MediaEngineLegacy", "Unable to initialize voice engine.", e2, null, 8, null);
        } catch (Throwable th) {
            Logger.e$default(this.n, "MediaEngineLegacy", "Unable to initialize voice engine, new error discovered", th, null, 8, null);
        }
        if (this.f != null) {
            n(k$j.j);
        }
    }
}
