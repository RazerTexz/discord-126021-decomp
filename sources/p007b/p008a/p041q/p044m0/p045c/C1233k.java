package p007b.p008a.p041q.p044m0.p045c;

import android.content.Context;
import android.os.Build;
import androidx.annotation.AnyThread;
import co.discord.media_engine.RtcRegion;
import co.discord.media_engine.VideoInputDeviceDescription;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
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
import p007b.p008a.p041q.C1197e0;
import p007b.p008a.p041q.ExecutorServiceC1192c;
import p007b.p008a.p041q.p042k0.C1215g;
import p007b.p008a.p041q.p044m0.C1221a;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.q.m0.c.k */
/* JADX INFO: compiled from: MediaEngineLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1233k implements MediaEngine {

    /* JADX INFO: renamed from: a */
    public static final Set<String> f1721a = C12148n0.setOf((Object[]) new String[]{"Pixel", "Pixel XL", "Pixel 3a XL", "Pixel 4", "Pixel 4 XL", "Pixel 5"});

    /* JADX INFO: renamed from: b */
    public static final Set<String> f1722b = C12148n0.setOf((Object[]) new String[]{"Pixel 3a", "Redmi Note 8 Pro", "Redmi Note 8 pro"});

    /* JADX INFO: renamed from: c */
    public final C1243u f1723c;

    /* JADX INFO: renamed from: d */
    public final List<MediaEngineConnection> f1724d;

    /* JADX INFO: renamed from: e */
    public boolean f1725e;

    /* JADX INFO: renamed from: f */
    public Discord f1726f;

    /* JADX INFO: renamed from: g */
    public List<C1221a> f1727g;

    /* JADX INFO: renamed from: h */
    public MediaEngine.OpenSLUsageMode f1728h;

    /* JADX INFO: renamed from: i */
    public MediaEngine.EchoCancellationInfo f1729i;

    /* JADX INFO: renamed from: j */
    public final Context f1730j;

    /* JADX INFO: renamed from: k */
    public final MediaEngine.InterfaceC5642c f1731k;

    /* JADX INFO: renamed from: l */
    public final ExecutorServiceC1192c f1732l;

    /* JADX INFO: renamed from: m */
    public final MediaEngine.OpenSLESConfig f1733m;

    /* JADX INFO: renamed from: n */
    public final Logger f1734n;

    /* JADX INFO: renamed from: o */
    public final C1215g f1735o;

    /* JADX INFO: renamed from: p */
    public final MediaEngine.InterfaceC5641b f1736p;

    /* JADX INFO: renamed from: q */
    public final Set<String> f1737q;

    /* JADX INFO: renamed from: r */
    public final Set<String> f1738r;

    /* JADX INFO: renamed from: b.a.q.m0.c.k$a */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class a extends AbstractC12240o implements Function0<Unit> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            C1233k c1233k = C1233k.this;
            C1232j c1232j = C1232j.f1720j;
            Set<String> set = C1233k.f1721a;
            c1233k.m333n(c1232j);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$b */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class b extends AbstractC12240o implements Function1<MediaEngine.InterfaceC5642c, Unit> {
        public final /* synthetic */ C1227e $connection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C1227e c1227e) {
            super(1);
            this.$connection = c1227e;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngine.InterfaceC5642c interfaceC5642c) {
            MediaEngine.InterfaceC5642c interfaceC5642c2 = interfaceC5642c;
            C12238m.checkNotNullParameter(interfaceC5642c2, "it");
            interfaceC5642c2.onNewConnection(this.$connection);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$c */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class c extends MediaEngineConnection.AbstractC5645a {

        /* JADX INFO: renamed from: b.a.q.m0.c.k$c$a */
        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class a extends AbstractC12240o implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                C1233k c1233k = C1233k.this;
                C1234l c1234l = C1234l.f1748j;
                Set<String> set = C1233k.f1721a;
                c1233k.m333n(c1234l);
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: b.a.q.m0.c.k$c$b */
        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class b extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ MediaEngineConnection $connection;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(MediaEngineConnection mediaEngineConnection) {
                super(0);
                this.$connection = mediaEngineConnection;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                C1233k.m320m(C1233k.this, this.$connection);
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: b.a.q.m0.c.k$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class C13212c extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ MediaEngineConnection $connection;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C13212c(MediaEngineConnection mediaEngineConnection) {
                super(0);
                this.$connection = mediaEngineConnection;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                C1233k.m320m(C1233k.this, this.$connection);
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: b.a.q.m0.c.k$c$d */
        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class d extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ MediaEngineConnection $connection;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(MediaEngineConnection mediaEngineConnection) {
                super(0);
                this.$connection = mediaEngineConnection;
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                C1233k.m320m(C1233k.this, this.$connection);
                return Unit.f27425a;
            }
        }

        public c() {
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.AbstractC5645a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onConnected(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.TransportInfo transportInfo, List<C1221a> list) {
            C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
            C12238m.checkNotNullParameter(transportInfo, "transportInfo");
            C12238m.checkNotNullParameter(list, "supportedVideoCodecs");
            C1233k.this.m334o(new a());
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.AbstractC5645a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onConnectionStateChange(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.ConnectionState connectionState) {
            C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
            C12238m.checkNotNullParameter(connectionState, "connectionState");
            if (connectionState == MediaEngineConnection.ConnectionState.DISCONNECTED) {
                C1233k.this.m334o(new b(mediaEngineConnection));
            }
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.AbstractC5645a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onDestroy(MediaEngineConnection mediaEngineConnection) {
            C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
            C1233k.this.m334o(new C13212c(mediaEngineConnection));
        }

        @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection.AbstractC5645a, com.discord.rtcconnection.mediaengine.MediaEngineConnection.InterfaceC5648d
        public void onError(MediaEngineConnection mediaEngineConnection, MediaEngineConnection.FailedConnectionException failedConnectionException) {
            C12238m.checkNotNullParameter(mediaEngineConnection, "connection");
            C12238m.checkNotNullParameter(failedConnectionException, "exception");
            C1233k.this.m334o(new d(mediaEngineConnection));
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$d */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class d<T> implements Action1<Emitter<MediaEngine.AudioInfo>> {
        public d() {
        }

        @Override // p658rx.functions.Action1
        public void call(Emitter<MediaEngine.AudioInfo> emitter) {
            Emitter<MediaEngine.AudioInfo> emitter2 = emitter;
            Discord discord = C1233k.this.f1726f;
            if (discord != null) {
                discord.getAudioSubsystem(new C1237o(emitter2));
            }
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$e */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class e<T> implements Action1<List<? extends C1221a>> {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Action1
        public void call(List<? extends C1221a> list) {
            List<? extends C1221a> list2 = list;
            C1233k c1233k = C1233k.this;
            C12238m.checkNotNullExpressionValue(list2, "codecs");
            c1233k.f1727g = list2;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$f */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class f<T, R> implements InterfaceC12589b<List<? extends C1221a>, Unit> {

        /* JADX INFO: renamed from: j */
        public static final f f1742j = new f();

        @Override // p637j0.p641k.InterfaceC12589b
        public Unit call(List<? extends C1221a> list) {
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$g */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class g implements Discord.LocalVoiceLevelChangedCallback {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Function1 f1743a;

        public g(Function1 function1) {
            this.f1743a = function1;
        }

        @Override // com.hammerandchisel.libdiscord.Discord.LocalVoiceLevelChangedCallback
        public final void onLocalVoiceLevelChanged(float f, int i) {
            this.f1743a.invoke(new MediaEngine.LocalVoiceStatus(f, (i & 1) != 0));
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$h */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class h implements Discord.BuiltinAECCallback {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ C1215g f1744a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ C1233k f1745b;

        /* JADX INFO: renamed from: b.a.q.m0.c.k$h$a */
        /* JADX INFO: compiled from: MediaEngineLegacy.kt */
        public static final class a extends AbstractC12240o implements Function0<Unit> {
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
                h.this.f1744a.f1663d = this.$enabled;
                C1233k c1233k = h.this.f1745b;
                boolean z2 = this.$requestEnabled;
                boolean z3 = this.$available;
                Objects.requireNonNull(c1233k.f1735o);
                c1233k.f1729i = new MediaEngine.EchoCancellationInfo(z2, z3, WebRtcAudioUtils.isAcousticEchoCancelerSupported(), this.$enabled, false, false, false, false, false, 496);
                return Unit.f27425a;
            }
        }

        public h(C1215g c1215g, Discord discord, C1233k c1233k) {
            this.f1744a = c1215g;
            this.f1745b = c1233k;
        }

        @Override // com.hammerandchisel.libdiscord.Discord.BuiltinAECCallback
        public final void onConfigureBuiltinAEC(boolean z2, boolean z3, boolean z4) {
            this.f1745b.m334o(new a(z4, z2, z3));
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$i */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class i implements Logging.ExternalReporter {
        public i() {
        }

        @Override // org.webrtc.Logging.ExternalReporter
        /* JADX INFO: renamed from: e */
        public final void mo336e(String str, String str2, Throwable th) {
            Logger logger = C1233k.this.f1734n;
            C12238m.checkNotNullExpressionValue(str, "tag");
            C12238m.checkNotNullExpressionValue(str2, "message");
            Logger.e$default(logger, str, str2, th, null, 8, null);
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$j */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final /* synthetic */ class j extends C12236k implements Function1<MediaEngine.InterfaceC5642c, Unit> {

        /* JADX INFO: renamed from: j */
        public static final j f1747j = new j();

        public j() {
            super(1, MediaEngine.InterfaceC5642c.class, "onNativeEngineInitialized", "onNativeEngineInitialized()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngine.InterfaceC5642c interfaceC5642c) {
            MediaEngine.InterfaceC5642c interfaceC5642c2 = interfaceC5642c;
            C12238m.checkNotNullParameter(interfaceC5642c2, "p1");
            interfaceC5642c2.onNativeEngineInitialized();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.k$k */
    /* JADX INFO: compiled from: MediaEngineLegacy.kt */
    public static final class k extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ MediaEngine.VoiceConfig $voiceConfig;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(MediaEngine.VoiceConfig voiceConfig) {
            super(0);
            this.$voiceConfig = voiceConfig;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            boolean z2;
            StringBuilder sbM833U = C1643a.m833U("updateVoiceConfig: ");
            sbM833U.append(this.$voiceConfig);
            C1460d.m501b1("MediaEngineLegacy", sbM833U.toString());
            MediaEngine.VoiceConfig voiceConfig = this.$voiceConfig;
            C1233k c1233k = C1233k.this;
            float f = voiceConfig.outputVolume;
            Discord discord = c1233k.f1726f;
            if (discord != null) {
                discord.setSpeakerVolume(Math.min(300.0f, Math.max(0.0f, f)) / 100.0f);
            }
            C1233k c1233k2 = C1233k.this;
            boolean z3 = voiceConfig.echoCancellation;
            c1233k2.f1732l.m266a();
            C1215g c1215g = c1233k2.f1735o;
            if (c1215g.f1666g && c1215g.f1663d) {
                z2 = false;
            } else {
                C1215g c1215g2 = c1233k2.f1735o;
                z2 = c1215g2.f1665f && !c1215g2.f1663d ? true : z3;
            }
            if (z2 != z3) {
                C1460d.m501b1("MediaEngineLegacy", "ignoring call to setEchoCancellation(" + z3 + "), config=" + c1233k2.f1735o);
            }
            Discord discord2 = c1233k2.f1726f;
            if (discord2 != null) {
                discord2.setEchoCancellation(z2, false, new C1235m(c1233k2));
            }
            C1233k c1233k3 = C1233k.this;
            boolean z4 = voiceConfig.noiseSuppression;
            Discord discord3 = c1233k3.f1726f;
            if (discord3 != null) {
                discord3.setNoiseSuppression(z4);
            }
            C1233k c1233k4 = C1233k.this;
            boolean z5 = voiceConfig.noiseCancellation;
            c1233k4.f1723c.f1757a = z5;
            Discord discord4 = c1233k4.f1726f;
            if (discord4 != null) {
                discord4.setNoiseCancellation(z5);
            }
            C1233k c1233k5 = C1233k.this;
            boolean z6 = voiceConfig.automaticGainControl;
            Discord discord5 = c1233k5.f1726f;
            if (discord5 != null) {
                discord5.setAutomaticGainControl(z6);
            }
            for (MediaEngineConnection mediaEngineConnection : C1233k.this.getConnections()) {
                mediaEngineConnection.mo305k(voiceConfig.inputMode, voiceConfig.inputModeOptions);
                mediaEngineConnection.mo316v(voiceConfig.isSelfDeafened);
                mediaEngineConnection.mo297c(voiceConfig.isSelfMuted || mediaEngineConnection.getType() == MediaEngineConnection.Type.STREAM);
            }
            return Unit.f27425a;
        }
    }

    public C1233k(Context context, MediaEngine.InterfaceC5642c interfaceC5642c, ExecutorServiceC1192c executorServiceC1192c, MediaEngine.OpenSLESConfig openSLESConfig, Logger logger, C1215g c1215g, MediaEngine.InterfaceC5641b interfaceC5641b, Set set, Set set2, int i2) {
        Set<String> set3 = (i2 & 128) != 0 ? f1721a : null;
        Set<String> set4 = (i2 & 256) != 0 ? f1722b : null;
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(interfaceC5642c, "listener");
        C12238m.checkNotNullParameter(executorServiceC1192c, "mediaEngineThreadExecutor");
        C12238m.checkNotNullParameter(openSLESConfig, "openSLESConfig");
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(c1215g, "echoCancellation");
        C12238m.checkNotNullParameter(interfaceC5641b, "echoCancellationCallback");
        C12238m.checkNotNullParameter(set3, "defaultOpenSLAllowList");
        C12238m.checkNotNullParameter(set4, "defaultOpenSLExcludeList");
        this.f1730j = context;
        this.f1731k = interfaceC5642c;
        this.f1732l = executorServiceC1192c;
        this.f1733m = openSLESConfig;
        this.f1734n = logger;
        this.f1735o = c1215g;
        this.f1736p = interfaceC5641b;
        this.f1737q = set3;
        this.f1738r = set4;
        this.f1723c = new C1243u();
        this.f1724d = new ArrayList();
        this.f1725e = true;
        this.f1728h = MediaEngine.OpenSLUsageMode.ALLOW_LIST;
    }

    /* JADX INFO: renamed from: m */
    public static final void m320m(C1233k c1233k, MediaEngineConnection mediaEngineConnection) {
        synchronized (c1233k) {
            Discord discord = c1233k.f1726f;
            if (discord != null) {
                discord.setLocalVoiceLevelChangedCallback(null);
            }
            c1233k.f1724d.remove(mediaEngineConnection);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: a */
    public Observable<Unit> mo321a() {
        if (this.f1727g != null) {
            C12721k c12721k = new C12721k(Unit.f27425a);
            C12238m.checkNotNullExpressionValue(c12721k, "Observable.just(Unit)");
            return c12721k;
        }
        m335p();
        if (this.f1726f == null) {
            Observable<Unit> observableM11081x = Observable.m11081x(new IllegalStateException("Failed to initialize native media engine"));
            C12238m.checkNotNullExpressionValue(observableM11081x, "Observable.error(Illegal…ze native media engine\"))");
            return observableM11081x;
        }
        Observable observableM11080o = Observable.m11080o(new C1239q(this), Emitter.BackpressureMode.NONE);
        C12238m.checkNotNullExpressionValue(observableM11080o, "Observable.create({ emit…er.BackpressureMode.NONE)");
        Observable<Unit> observableM11083G = observableM11080o.m11115u(new e()).m11083G(f.f1742j);
        C12238m.checkNotNullExpressionValue(observableM11083G, "getSupportedVideoCodecs(…s }\n        .map { Unit }");
        return observableM11083G;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: b */
    public void mo322b(RtcRegion[] rtcRegionArr, Function1<? super String[], Unit> function1) {
        C12238m.checkNotNullParameter(rtcRegionArr, "regionsWithIps");
        C12238m.checkNotNullParameter(function1, "callback");
        m335p();
        Discord discord = this.f1726f;
        if (discord != null) {
            discord.getRankedRtcRegions(rtcRegionArr, new C1240r(function1));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: c */
    public ExecutorServiceC1192c mo323c() {
        return this.f1732l;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    @AnyThread
    /* JADX INFO: renamed from: d */
    public void mo324d(MediaEngine.VoiceConfig voiceConfig) {
        C12238m.checkNotNullParameter(voiceConfig, "voiceConfig");
        m334o(new k(voiceConfig));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: e */
    public Observable<MediaEngine.AudioInfo> mo325e() {
        Observable<MediaEngine.AudioInfo> observableM11080o = Observable.m11080o(new d(), Emitter.BackpressureMode.LATEST);
        C12238m.checkNotNullExpressionValue(observableM11080o, "Observable.create({ emit….BackpressureMode.LATEST)");
        return observableM11080o;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: f */
    public void mo326f(int i2) {
        Discord discord = this.f1726f;
        if (discord != null) {
            discord.setVideoInputDevice(i2);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: g */
    public synchronized MediaEngineConnection mo327g(long j2, MediaEngine.C5640a c5640a, MediaEngineConnection.Type type, Function1<? super Exception, Unit> function1) {
        C12238m.checkNotNullParameter(c5640a, "options");
        C12238m.checkNotNullParameter(type, "type");
        C12238m.checkNotNullParameter(function1, "onFailure");
        if (!(this.f1727g != null)) {
            ((C1197e0) function1).invoke(new IllegalStateException("connect() called on unprepared media engine."));
            return null;
        }
        Discord discord = this.f1726f;
        if (discord == null) {
            Logger.e$default(this.f1734n, "MediaEngineLegacy", "connect() called without voiceEngineLegacy.", null, null, 12, null);
            return null;
        }
        m334o(new a());
        Logger.i$default(this.f1734n, "MediaEngineLegacy", "Connecting with options: " + c5640a, null, 4, null);
        c cVar = new c();
        ExecutorServiceC1192c executorServiceC1192c = this.f1732l;
        Logger logger = this.f1734n;
        C1243u c1243u = this.f1723c;
        List<C1221a> list = this.f1727g;
        if (list == null) {
            C12238m.throwUninitializedPropertyAccessException("supportedVideoCodecs");
        }
        C1227e c1227e = new C1227e(executorServiceC1192c, logger, c1243u, discord, list, type, j2, c5640a, C12145m.listOf(cVar));
        this.f1724d.add(c1227e);
        m333n(new b(c1227e));
        return c1227e;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    public synchronized List<MediaEngineConnection> getConnections() {
        return C12163u.toList(this.f1724d);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: h */
    public void mo328h(MediaEngine.OpenSLUsageMode openSLUsageMode) {
        C12238m.checkNotNullParameter(openSLUsageMode, "openSLUsageMode");
        if (this.f1726f != null) {
            Logger.e$default(this.f1734n, "MediaEngineLegacy", "setting openSLUsageMode too late", null, null, 12, null);
        }
        this.f1728h = openSLUsageMode;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: i */
    public Discord mo329i() {
        return this.f1726f;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: j */
    public void mo330j(Function1<? super VideoInputDeviceDescription[], Unit> function1) {
        C12238m.checkNotNullParameter(function1, "devicesCallback");
        m335p();
        Discord discord = this.f1726f;
        if (discord != null) {
            discord.getVideoInputDevices(new C1241s(function1));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: k */
    public void mo331k(boolean z2) {
        this.f1725e = z2;
        Discord discord = this.f1726f;
        if (discord != null) {
            discord.setAudioInputEnabled(z2);
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngine
    /* JADX INFO: renamed from: l */
    public void mo332l(Function1<? super MediaEngine.LocalVoiceStatus, Unit> function1) {
        if (function1 == null) {
            Discord discord = this.f1726f;
            if (discord != null) {
                discord.setLocalVoiceLevelChangedCallback(null);
                return;
            }
            return;
        }
        m335p();
        Discord discord2 = this.f1726f;
        if (discord2 != null) {
            discord2.setLocalVoiceLevelChangedCallback(new g(function1));
        }
    }

    /* JADX INFO: renamed from: n */
    public final void m333n(Function1<? super MediaEngine.InterfaceC5642c, Unit> function1) {
        try {
            function1.invoke(this.f1731k);
        } catch (Exception e2) {
            Logger.e$default(this.f1734n, "MediaEngineLegacy", "Error in listener", e2, null, 8, null);
        }
    }

    /* JADX INFO: renamed from: o */
    public final Future<?> m334o(Function0<Unit> function0) {
        ExecutorServiceC1192c executorServiceC1192c = this.f1732l;
        Object runnableC1242t = function0;
        if (function0 != null) {
            runnableC1242t = new RunnableC1242t(function0);
        }
        return executorServiceC1192c.submit((Runnable) runnableC1242t);
    }

    /* JADX INFO: renamed from: p */
    public final void m335p() {
        if (this.f1726f != null) {
            return;
        }
        Logger logger = this.f1734n;
        StringBuilder sbM833U = C1643a.m833U("initializing voice engine. OpenSL ES: ");
        sbM833U.append(this.f1733m);
        sbM833U.append(", OpenSL usage mode: ");
        sbM833U.append(this.f1728h);
        Logger.i$default(logger, "MediaEngineLegacy", sbM833U.toString(), null, 4, null);
        int iOrdinal = this.f1733m.ordinal();
        boolean zContains = false;
        if (iOrdinal == 0) {
            if (this.f1728h == MediaEngine.OpenSLUsageMode.ALLOW_LIST) {
                zContains = this.f1737q.contains(Build.MODEL);
            } else if (!this.f1738r.contains(Build.MODEL)) {
                zContains = true;
            }
            Logger logger2 = this.f1734n;
            StringBuilder sbM833U2 = C1643a.m833U("OpenSL ES default. mode: ");
            sbM833U2.append(this.f1728h);
            sbM833U2.append(", enableOpenSL: ");
            sbM833U2.append(zContains);
            sbM833U2.append(", model: '");
            Logger.i$default(logger2, "MediaEngineLegacy", C1643a.m820H(sbM833U2, Build.MODEL, '\''), null, 4, null);
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(!zContains);
        } else if (iOrdinal == 1) {
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(false);
        } else if (iOrdinal == 2) {
            WebRtcAudioManager.setBlacklistDeviceForOpenSLESUsage(true);
        }
        Logging.externalReporter = new i();
        try {
            Discord discord = new Discord(this.f1730j, 2);
            C1215g c1215g = this.f1735o;
            if (c1215g.f1664e) {
                discord.enableBuiltInAEC(true, new h(c1215g, discord, this));
            }
            discord.setAudioInputEnabled(this.f1725e);
            this.f1726f = discord;
        } catch (ExceptionInInitializerError e2) {
            Logger.e$default(this.f1734n, "MediaEngineLegacy", "Unable to initialize voice engine.", e2, null, 8, null);
        } catch (UnsatisfiedLinkError e3) {
            Logger.e$default(this.f1734n, "MediaEngineLegacy", "Unable to initialize voice engine.", e3, null, 8, null);
        } catch (Throwable th) {
            Logger.e$default(this.f1734n, "MediaEngineLegacy", "Unable to initialize voice engine, new error discovered", th, null, 8, null);
        }
        if (this.f1726f != null) {
            m333n(j.f1747j);
        }
    }
}
