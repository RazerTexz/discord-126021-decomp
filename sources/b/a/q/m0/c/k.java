package b.a.q.m0.c;

import android.content.Context;
import android.os.Build;
import androidx.annotation.AnyThread;
import b.a.q.MediaEngineExecutorService;
import b.a.q.e0;
import b.a.q.k0.EchoCancellation;
import b.a.q.m0.Codec2;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import co.discord.media_engine.DeviceDescription4;
import co.discord.media_engine.RtcRegion;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
import d0.t.CollectionsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Future;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.webrtc.Logging;
import org.webrtc.voiceengine.WebRtcAudioManager;
import org.webrtc.voiceengine.WebRtcAudioUtils;
import rx.Emitter;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class k implements MediaEngine {
    public static final Set<String> a = Sets5.setOf((Object[]) new String[]{"Pixel", "Pixel XL", "Pixel 3a XL", "Pixel 4", "Pixel 4 XL", "Pixel 5"});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f271b = Sets5.setOf((Object[]) new String[]{"Pixel 3a", "Redmi Note 8 Pro", "Redmi Note 8 pro"});
    public final NoiseCancellationConfig c;
    public final List<MediaEngineConnection> d;
    public boolean e;
    public Discord f;
    public List<Codec2> g;
    public MediaEngine.OpenSLUsageMode h;
    public MediaEngine.EchoCancellationInfo i;
    public final Context j;
    public final MediaEngine.c k;
    public final MediaEngineExecutorService l;
    public final MediaEngine.OpenSLESConfig m;
    public final Logger n;
    public final EchoCancellation o;
    public final MediaEngine.b p;
    public final Set<String> q;
    public final Set<String> r;

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class a extends Lambda implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            k kVar = k.this;
            b.a.q.m0.c.j jVar = b.a.q.m0.c.j.j;
            Set<String> set = k.a;
            kVar.n(jVar);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class b extends Lambda implements Function1<MediaEngine.c, Unit> {
        public final /* synthetic */ MediaEngineConnectionLegacy5 $connection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5) {
            super(1);
            this.$connection = mediaEngineConnectionLegacy5;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngine.c cVar) {
            MediaEngine.c cVar2 = cVar;
            Intrinsics3.checkNotNullParameter(cVar2, "it");
            cVar2.onNewConnection(this.$connection);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class c extends MediaEngineConnection.a {

        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class a extends Lambda implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                k kVar = k.this;
                l lVar = l.j;
                Set<String> set = k.a;
                kVar.n(lVar);
                return Unit.a;
            }
        }

        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MediaEngineConnection $connection;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(MediaEngineConnection mediaEngineConnection) {
                super(0);
                this.$connection = mediaEngineConnection;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                k.m(k.this, this.$connection);
                return Unit.a;
            }
        }

        /* JADX INFO: renamed from: b.a.q.m0.c.k$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class C0016c extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MediaEngineConnection $connection;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0016c(MediaEngineConnection mediaEngineConnection) {
                super(0);
                this.$connection = mediaEngineConnection;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                k.m(k.this, this.$connection);
                return Unit.a;
            }
        }

        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class d extends Lambda implements Function0<Unit> {
            public final /* synthetic */ MediaEngineConnection $connection;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(MediaEngineConnection mediaEngineConnection) {
                super(0);
                this.$connection = mediaEngineConnection;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                k.m(k.this, this.$connection);
                return Unit.a;
            }
        }

        public c() {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.TransportInfo transportInfo, List<Codec2> list) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(transportInfo, "transportInfo");
            Intrinsics3.checkNotNullParameter(list, "supportedVideoCodecs");
            k.this.o(new a());
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.ConnectionState connectionState) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(connectionState, "connectionState");
            if (connectionState == MediaEngineConnection.ConnectionState.DISCONNECTED) {
                k.this.o(new b(mediaEngineConnection));
            }
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onDestroy(MediaEngineConnection mediaEngineConnection) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            k.this.o(new C0016c(mediaEngineConnection));
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.d
        public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.FailedConnectionException failedConnectionException) {
            Intrinsics3.checkNotNullParameter(mediaEngineConnection, "connection");
            Intrinsics3.checkNotNullParameter(failedConnectionException, "exception");
            k.this.o(new d(mediaEngineConnection));
        }
    }

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class d<T> implements Action1<Emitter<MediaEngine.AudioInfo>> {
        public d() {
        }

        @Override // rx.functions.Action1
        public void call(Emitter<MediaEngine.AudioInfo> emitter) {
            Emitter<MediaEngine.AudioInfo> emitter2 = emitter;
            Discord discord = k.this.f;
            if (discord != null) {
                discord.getAudioSubsystem(new o(emitter2));
            }
        }
    }

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class e<T> implements Action1<List<? extends Codec2>> {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Action1
        public void call(List<? extends Codec2> list) {
            List<? extends Codec2> list2 = list;
            k kVar = k.this;
            Intrinsics3.checkNotNullExpressionValue(list2, "codecs");
            kVar.g = list2;
        }
    }

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class f<T, R> implements Func1<List<? extends Codec2>, Unit> {
        public static final f j = new f();

        @Override // j0.k.Func1
        public Unit call(List<? extends Codec2> list) {
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class g implements Discord.LocalVoiceLevelChangedCallback {
        public final /* synthetic */ Function1 a;

        public g(Function1 function1) {
            this.a = function1;
        }

        @Override // com.hammerandchisel.libdiscord.Discord.LocalVoiceLevelChangedCallback
        public final void onLocalVoiceLevelChanged(float f, int i) {
            this.a.invoke(new MediaEngine.LocalVoiceStatus(f, (i & 1) != 0));
        }
    }

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class h implements Discord.BuiltinAECCallback {
        public final /* synthetic */ EchoCancellation a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f272b;

        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ boolean $available;
            public final /* synthetic */ boolean $enabled;
            public final /* synthetic */ boolean $requestEnabled;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(boolean z2, boolean z3, boolean z4) {
                super(0);
                this.$enabled = z2;
                this.$requestEnabled = z3;
                this.$available = z4;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                h.this.a.d = this.$enabled;
                k kVar = h.this.f272b;
                boolean z2 = this.$requestEnabled;
                boolean z3 = this.$available;
                Objects.requireNonNull(kVar.o);
                kVar.i = new MediaEngine.EchoCancellationInfo(z2, z3, WebRtcAudioUtils.isAcousticEchoCancelerSupported(), this.$enabled, false, false, false, false, false, 496);
                return Unit.a;
            }
        }

        public h(EchoCancellation echoCancellation, Discord discord, k kVar) {
            this.a = echoCancellation;
            this.f272b = kVar;
        }

        @Override // com.hammerandchisel.libdiscord.Discord.BuiltinAECCallback
        public final void onConfigureBuiltinAEC(boolean z2, boolean z3, boolean z4) {
            this.f272b.o(new a(z4, z2, z3));
        }
    }

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class i implements Logging.ExternalReporter {
        public i() {
        }

        @Override // org.webrtc.Logging.ExternalReporter
        public final void e(String str, String str2, Throwable th) {
            Logger logger = k.this.n;
            Intrinsics3.checkNotNullExpressionValue(str, "tag");
            Intrinsics3.checkNotNullExpressionValue(str2, "message");
            Logger.e$default(logger, str, str2, th, null, 8, null);
        }
    }

    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final /* synthetic */ class j extends FunctionReferenceImpl implements Function1<MediaEngine.c, Unit> {
        public static final j j = new j();

        public j() {
            super(1, MediaEngine.c.class, "onNativeEngineInitialized", "onNativeEngineInitialized()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngine.c cVar) {
            MediaEngine.c cVar2 = cVar;
            Intrinsics3.checkNotNullParameter(cVar2, "p1");
            cVar2.onNativeEngineInitialized();
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$k, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class C0017k extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MediaEngine.VoiceConfig $voiceConfig;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0017k(MediaEngine.VoiceConfig voiceConfig) {
            super(0);
            this.$voiceConfig = voiceConfig;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            boolean z2;
            StringBuilder sbU = outline.U("updateVoiceConfig: ");
            sbU.append(this.$voiceConfig);
            AnimatableValueParser.b1("MediaEngineLegacy", sbU.toString());
            MediaEngine.VoiceConfig voiceConfig = this.$voiceConfig;
            k kVar = k.this;
            float f = voiceConfig.outputVolume;
            Discord discord = kVar.f;
            if (discord != null) {
                discord.setSpeakerVolume(Math.min(300.0f, Math.max(0.0f, f)) / 100.0f);
            }
            k kVar2 = k.this;
            boolean z3 = voiceConfig.echoCancellation;
            kVar2.l.a();
            EchoCancellation echoCancellation = kVar2.o;
            if (echoCancellation.g && echoCancellation.d) {
                z2 = false;
            } else {
                EchoCancellation echoCancellation2 = kVar2.o;
                z2 = echoCancellation2.f && !echoCancellation2.d ? true : z3;
            }
            if (z2 != z3) {
                AnimatableValueParser.b1("MediaEngineLegacy", "ignoring call to setEchoCancellation(" + z3 + "), config=" + kVar2.o);
            }
            Discord discord2 = kVar2.f;
            if (discord2 != null) {
                discord2.setEchoCancellation(z2, false, new m(kVar2));
            }
            k kVar3 = k.this;
            boolean z4 = voiceConfig.noiseSuppression;
            Discord discord3 = kVar3.f;
            if (discord3 != null) {
                discord3.setNoiseSuppression(z4);
            }
            k kVar4 = k.this;
            boolean z5 = voiceConfig.noiseCancellation;
            kVar4.c.a = z5;
            Discord discord4 = kVar4.f;
            if (discord4 != null) {
                discord4.setNoiseCancellation(z5);
            }
            k kVar5 = k.this;
            boolean z6 = voiceConfig.automaticGainControl;
            Discord discord5 = kVar5.f;
            if (discord5 != null) {
                discord5.setAutomaticGainControl(z6);
            }
            for (MediaEngineConnection mediaEngineConnection : k.this.getConnections()) {
                mediaEngineConnection.k(voiceConfig.inputMode, voiceConfig.inputModeOptions);
                mediaEngineConnection.v(voiceConfig.isSelfDeafened);
                mediaEngineConnection.c(voiceConfig.isSelfMuted || mediaEngineConnection.getType() == MediaEngineConnection.Type.STREAM);
            }
            return Unit.a;
        }
    }

    public k(Context context, MediaEngine.c cVar, MediaEngineExecutorService mediaEngineExecutorService, MediaEngine.OpenSLESConfig openSLESConfig, Logger logger, EchoCancellation echoCancellation, MediaEngine.b bVar, Set set, Set set2, int i2) {
        Set<String> set3 = (i2 & 128) != 0 ? a : null;
        Set<String> set4 = (i2 & 256) != 0 ? f271b : null;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(cVar, "listener");
        Intrinsics3.checkNotNullParameter(mediaEngineExecutorService, "mediaEngineThreadExecutor");
        Intrinsics3.checkNotNullParameter(openSLESConfig, "openSLESConfig");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(echoCancellation, "echoCancellation");
        Intrinsics3.checkNotNullParameter(bVar, "echoCancellationCallback");
        Intrinsics3.checkNotNullParameter(set3, "defaultOpenSLAllowList");
        Intrinsics3.checkNotNullParameter(set4, "defaultOpenSLExcludeList");
        this.j = context;
        this.k = cVar;
        this.l = mediaEngineExecutorService;
        this.m = openSLESConfig;
        this.n = logger;
        this.o = echoCancellation;
        this.p = bVar;
        this.q = set3;
        this.r = set4;
        this.c = new NoiseCancellationConfig();
        this.d = new ArrayList();
        this.e = true;
        this.h = MediaEngine.OpenSLUsageMode.ALLOW_LIST;
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
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Unit.a);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(Unit)");
            return scalarSynchronousObservable;
        }
        p();
        if (this.f == null) {
            Observable<Unit> observableX = Observable.x(new IllegalStateException("Failed to initialize native media engine"));
            Intrinsics3.checkNotNullExpressionValue(observableX, "Observable.error(Illegal…ze native media engine\"))");
            return observableX;
        }
        Observable observableO = Observable.o(new q(this), Emitter.BackpressureMode.NONE);
        Intrinsics3.checkNotNullExpressionValue(observableO, "Observable.create({ emit…er.BackpressureMode.NONE)");
        Observable<Unit> observableG = observableO.u(new e()).G(f.j);
        Intrinsics3.checkNotNullExpressionValue(observableG, "getSupportedVideoCodecs(…s }\n        .map { Unit }");
        return observableG;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void b(RtcRegion[] rtcRegionArr, Function1<? super String[], Unit> function1) {
        Intrinsics3.checkNotNullParameter(rtcRegionArr, "regionsWithIps");
        Intrinsics3.checkNotNullParameter(function1, "callback");
        p();
        Discord discord = this.f;
        if (discord != null) {
            discord.getRankedRtcRegions(rtcRegionArr, new r(function1));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public MediaEngineExecutorService c() {
        return this.l;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    @AnyThread
    public void d(MediaEngine.VoiceConfig voiceConfig) {
        Intrinsics3.checkNotNullParameter(voiceConfig, "voiceConfig");
        o(new C0017k(voiceConfig));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public Observable<MediaEngine.AudioInfo> e() {
        Observable<MediaEngine.AudioInfo> observableO = Observable.o(new d(), Emitter.BackpressureMode.LATEST);
        Intrinsics3.checkNotNullExpressionValue(observableO, "Observable.create({ emit….BackpressureMode.LATEST)");
        return observableO;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void f(int i2) {
        Discord discord = this.f;
        if (discord != null) {
            discord.setVideoInputDevice(i2);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public synchronized MediaEngineConnection g(long j2, MediaEngine.a aVar, MediaEngineConnection.Type type, Function1<? super Exception, Unit> function1) {
        Intrinsics3.checkNotNullParameter(aVar, "options");
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(function1, "onFailure");
        if (!(this.g != null)) {
            ((e0) function1).invoke(new IllegalStateException("connect() called on unprepared media engine."));
            return null;
        }
        Discord discord = this.f;
        if (discord == null) {
            Logger.e$default(this.n, "MediaEngineLegacy", "connect() called without voiceEngineLegacy.", null, null, 12, null);
            return null;
        }
        o(new a());
        Logger.i$default(this.n, "MediaEngineLegacy", "Connecting with options: " + aVar, null, 4, null);
        c cVar = new c();
        MediaEngineExecutorService mediaEngineExecutorService = this.l;
        Logger logger = this.n;
        NoiseCancellationConfig noiseCancellationConfig = this.c;
        List<Codec2> list = this.g;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("supportedVideoCodecs");
        }
        MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5 = new MediaEngineConnectionLegacy5(mediaEngineExecutorService, logger, noiseCancellationConfig, discord, list, type, j2, aVar, CollectionsJVM.listOf(cVar));
        this.d.add(mediaEngineConnectionLegacy5);
        n(new b(mediaEngineConnectionLegacy5));
        return mediaEngineConnectionLegacy5;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public synchronized List<MediaEngineConnection> getConnections() {
        return _Collections.toList(this.d);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void h(MediaEngine.OpenSLUsageMode openSLUsageMode) {
        Intrinsics3.checkNotNullParameter(openSLUsageMode, "openSLUsageMode");
        if (this.f != null) {
            Logger.e$default(this.n, "MediaEngineLegacy", "setting openSLUsageMode too late", null, null, 12, null);
        }
        this.h = openSLUsageMode;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public Discord i() {
        return this.f;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public void j(Function1<? super DeviceDescription4[], Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "devicesCallback");
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
    public void l(Function1<? super MediaEngine.LocalVoiceStatus, Unit> function1) {
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
            discord2.setLocalVoiceLevelChangedCallback(new g(function1));
        }
    }

    public final void n(Function1<? super MediaEngine.c, Unit> function1) {
        try {
            function1.invoke(this.k);
        } catch (Exception e2) {
            Logger.e$default(this.n, "MediaEngineLegacy", "Error in listener", e2, null, 8, null);
        }
    }

    public final Future<?> o(Function0<Unit> function0) {
        MediaEngineExecutorService mediaEngineExecutorService = this.l;
        Object tVar = function0;
        if (function0 != null) {
            tVar = new t(function0);
        }
        return mediaEngineExecutorService.submit((Runnable) tVar);
    }

    public final void p() {
        if (this.f != null) {
            return;
        }
        Logger logger = this.n;
        StringBuilder sbU = outline.U("initializing voice engine. OpenSL ES: ");
        sbU.append(this.m);
        sbU.append(", OpenSL usage mode: ");
        sbU.append(this.h);
        Logger.i$default(logger, "MediaEngineLegacy", sbU.toString(), null, 4, null);
        int iOrdinal = this.m.ordinal();
        boolean zContains = false;
        if (iOrdinal == 0) {
            if (this.h == MediaEngine.OpenSLUsageMode.ALLOW_LIST) {
                zContains = this.q.contains(Build.MODEL);
            } else if (!this.r.contains(Build.MODEL)) {
                zContains = true;
            }
            Logger logger2 = this.n;
            StringBuilder sbU2 = outline.U("OpenSL ES default. mode: ");
            sbU2.append(this.h);
            sbU2.append(", enableOpenSL: ");
            sbU2.append(zContains);
            sbU2.append(", model: '");
            Logger.i$default(logger2, "MediaEngineLegacy", outline.H(sbU2, Build.MODEL, '\''), null, 4, null);
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(!zContains);
        } else if (iOrdinal == 1) {
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else if (iOrdinal == 2) {
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        Logging.externalReporter = new i();
        try {
            Discord discord = new Discord(this.j, 2);
            EchoCancellation echoCancellation = this.o;
            if (echoCancellation.e) {
                discord.enableBuiltInAEC(true, new h(echoCancellation, discord, this));
            }
            discord.setAudioInputEnabled(this.e);
            this.f = discord;
        } catch (ExceptionInInitializerError e2) {
            Logger.e$default(this.n, "MediaEngineLegacy", "Unable to initialize voice engine.", e2, null, 8, null);
        } catch (UnsatisfiedLinkError e3) {
            Logger.e$default(this.n, "MediaEngineLegacy", "Unable to initialize voice engine.", e3, null, 8, null);
        } catch (Throwable th) {
            Logger.e$default(this.n, "MediaEngineLegacy", "Unable to initialize voice engine, new error discovered", th, null, 8, null);
        }
        if (this.f != null) {
            n(j.j);
        }
    }
}
