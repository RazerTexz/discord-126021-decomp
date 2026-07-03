package p007b.p008a.p041q.p044m0.p045c;

import android.content.Intent;
import android.media.projection.MediaProjection;
import co.discord.media_engine.AudioDecoder;
import co.discord.media_engine.AudioEncoder;
import co.discord.media_engine.Connection;
import co.discord.media_engine.EncryptionSettings;
import co.discord.media_engine.Stats;
import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.VideoDecoder;
import co.discord.media_engine.VideoEncoder;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p041q.ExecutorServiceC1192c;
import p007b.p008a.p041q.p044m0.C1221a;
import p007b.p008a.p041q.p044m0.C1222b;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.q.m0.c.e */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1227e implements MediaEngineConnection {

    /* JADX INFO: renamed from: a */
    public final CopyOnWriteArrayList<MediaEngineConnection.InterfaceC5648d> f1698a;

    /* JADX INFO: renamed from: b */
    public MediaEngineConnection.ConnectionState f1699b;

    /* JADX INFO: renamed from: c */
    public boolean f1700c;

    /* JADX INFO: renamed from: d */
    public final Map<Long, Integer> f1701d;

    /* JADX INFO: renamed from: e */
    public final Map<Long, Long> f1702e;

    /* JADX INFO: renamed from: f */
    public final Set<Long> f1703f;

    /* JADX INFO: renamed from: g */
    public final Set<Long> f1704g;

    /* JADX INFO: renamed from: h */
    public final Set<Long> f1705h;

    /* JADX INFO: renamed from: i */
    public final List<C1221a> f1706i;

    /* JADX INFO: renamed from: j */
    public final Connection f1707j;

    /* JADX INFO: renamed from: k */
    public final ExecutorServiceC1192c f1708k;

    /* JADX INFO: renamed from: l */
    public final Logger f1709l;

    /* JADX INFO: renamed from: m */
    public final C1243u f1710m;

    /* JADX INFO: renamed from: n */
    public final Discord f1711n;

    /* JADX INFO: renamed from: o */
    public final List<C1221a> f1712o;

    /* JADX INFO: renamed from: p */
    public final MediaEngineConnection.Type f1713p;

    /* JADX INFO: renamed from: q */
    public final long f1714q;

    /* JADX INFO: renamed from: b.a.q.m0.c.e$a */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ int $audioSsrc;
        public final /* synthetic */ boolean $isMuted;
        public final /* synthetic */ long $resolvedVideoSsrc;
        public final /* synthetic */ long $userId;
        public final /* synthetic */ float $volume;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, int i, long j2, boolean z2, float f) {
            super(1);
            this.$userId = j;
            this.$audioSsrc = i;
            this.$resolvedVideoSsrc = j2;
            this.$isMuted = z2;
            this.$volume = f;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            long j = this.$userId;
            int i = this.$audioSsrc;
            int i2 = (int) this.$resolvedVideoSsrc;
            Objects.requireNonNull(C1227e.this);
            connection2.connectUser(j, i, i2, i2 > 0 ? i2 + 1 : 0, this.$isMuted, this.$volume);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$b */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final /* synthetic */ class b extends C12236k implements Function1<Connection, Unit> {

        /* JADX INFO: renamed from: j */
        public static final b f1715j = new b();

        public b() {
            super(1, Connection.class, "dispose", "dispose()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "p1");
            connection2.dispose();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$c */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class c extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            C12238m.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onConnectionStateChange(C1227e.this, MediaEngineConnection.ConnectionState.DISCONNECTED);
            interfaceC5648d2.onDestroy(C1227e.this);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$d */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class d extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $disabled;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$disabled = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.disableVideo(this.$userId, this.$disabled);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$e */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class e extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ KrispOveruseDetector.Status $status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(KrispOveruseDetector.Status status) {
            super(1);
            this.$status = status;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            C12238m.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onKrispStatus(C1227e.this, this.$status);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$f */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class f extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ Function1 $onStats;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Function1 function1) {
            super(1);
            this.$onStats = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.getStats(new C1228f(this));
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$g */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class g extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {

        /* JADX INFO: renamed from: $e */
        public final /* synthetic */ MediaEngineConnection.FailedConnectionException f1716$e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MediaEngineConnection.FailedConnectionException failedConnectionException) {
            super(1);
            this.f1716$e = failedConnectionException;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            C12238m.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onError(C1227e.this, this.f1716$e);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$h */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class h extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ AudioDecoder $audioDecoder;
        public final /* synthetic */ AudioEncoder $audioEncoder;
        public final /* synthetic */ VideoDecoder $videoDecoder;
        public final /* synthetic */ VideoEncoder $videoEncoder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(AudioEncoder audioEncoder, VideoEncoder videoEncoder, AudioDecoder audioDecoder, VideoDecoder videoDecoder) {
            super(1);
            this.$audioEncoder = audioEncoder;
            this.$videoEncoder = videoEncoder;
            this.$audioDecoder = audioDecoder;
            this.$videoDecoder = videoDecoder;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.setCodecs(this.$audioEncoder, this.$videoEncoder, new AudioDecoder[]{this.$audioDecoder}, new VideoDecoder[]{this.$videoDecoder});
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$i */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class i extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ EncryptionSettings $encryptionSettings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(EncryptionSettings encryptionSettings) {
            super(1);
            this.$encryptionSettings = encryptionSettings;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.setEncryptionSettings(this.$encryptionSettings);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$j */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class j extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ MediaEngineConnection.InputMode $inputMode;
        public final /* synthetic */ MediaEngineConnection.C5647c $inputModeOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(MediaEngineConnection.C5647c c5647c, MediaEngineConnection.InputMode inputMode) {
            super(1);
            this.$inputModeOptions = c5647c;
            this.$inputMode = inputMode;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.setVADLeadingFramesToBuffer(this.$inputModeOptions.f18912b);
            connection2.setVADTrailingFramesToSend(this.$inputModeOptions.f18913c);
            connection2.setVADTriggerThreshold(this.$inputModeOptions.f18911a);
            connection2.setVADAutoThreshold(this.$inputModeOptions.f18914d ? 3 : -1);
            connection2.setVADUseKrisp(this.$inputModeOptions.f18915e);
            connection2.setAudioInputMode(this.$inputMode.getNumeral());
            connection2.enableForwardErrorCorrection(true);
            connection2.setExpectedPacketLossRate(0.3f);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$k */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class k extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $mute;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$mute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.muteUser(this.$userId, this.$mute);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$l */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class l extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ boolean $mute;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$mute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            C12238m.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onLocalMute(this.$userId, this.$mute);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$m */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class m extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ boolean $offScreen;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$offScreen = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            C12238m.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onLocalVideoOffScreen(this.$userId, this.$offScreen);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$n */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class n extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ long $userId;
        public final /* synthetic */ float $volume;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(long j, float f) {
            super(1);
            this.$userId = j;
            this.$volume = f;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.setUserPlayoutVolume(this.$userId, this.$volume / 100.0f);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$o */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class o extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $active;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(boolean z2) {
            super(1);
            this.$active = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.setPTTActive(this.$active);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$p */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class p extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ int $frameRate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(int i) {
            super(1);
            this.$frameRate = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            C12238m.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onTargetFrameRate(this.$frameRate);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$q */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class q extends AbstractC12240o implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
        public final /* synthetic */ MediaEngineConnection.C5646b $quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(MediaEngineConnection.C5646b c5646b) {
            super(1);
            this.$quality = c5646b;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
            MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
            C12238m.checkNotNullParameter(interfaceC5648d2, "it");
            interfaceC5648d2.onTargetBitrate(this.$quality.f18906b);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$r */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class r extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ int $frameRate;
        public final /* synthetic */ MediaEngineConnection.C5646b $quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(MediaEngineConnection.C5646b c5646b, int i) {
            super(1);
            this.$quality = c5646b;
            this.$frameRate = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            MediaEngineConnection.C5646b c5646b = this.$quality;
            connection2.setEncodingQuality(c5646b.f18905a, c5646b.f18906b, c5646b.f18907c, c5646b.f18908d, this.$frameRate);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$s */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class s extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $selfDeaf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(boolean z2) {
            super(1);
            this.$selfDeaf = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.deafenLocalUser(this.$selfDeaf);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$t */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class t extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $selfMute;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(boolean z2) {
            super(1);
            this.$selfMute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.muteLocalUser(this.$selfMute);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$u */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class u extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $isVideoBroadcast;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(boolean z2) {
            super(1);
            this.$isVideoBroadcast = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.setVideoBroadcast(this.$isVideoBroadcast);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$v */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class v extends AbstractC12240o implements Function1<Connection, Unit> {
        public final /* synthetic */ C1222b $screenCapturer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(C1222b c1222b) {
            super(1);
            this.$screenCapturer = c1222b;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            C1222b c1222b = this.$screenCapturer;
            connection2.startScreenshareBroadcast(c1222b, c1222b.f1681o.getNativeInstance());
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$w */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class w extends MediaProjection.Callback {
        @Override // android.media.projection.MediaProjection.Callback
        public void onStop() {
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$x */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class x extends AbstractC12240o implements Function1<Connection, Unit> {

        /* JADX INFO: renamed from: j */
        public static final x f1717j = new x();

        public x() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            C12238m.checkNotNullParameter(connection2, "$receiver");
            connection2.stopScreenshareBroadcast();
            return Unit.f27425a;
        }
    }

    public C1227e(ExecutorServiceC1192c executorServiceC1192c, Logger logger, C1243u c1243u, Discord discord, List<C1221a> list, MediaEngineConnection.Type type, long j2, MediaEngine.C5640a c5640a, List<? extends MediaEngineConnection.InterfaceC5648d> list2) {
        C12238m.checkNotNullParameter(executorServiceC1192c, "mediaEngineThreadExecutor");
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(c1243u, "noiseCancellationConfig");
        C12238m.checkNotNullParameter(discord, "voiceEngineLegacy");
        C12238m.checkNotNullParameter(list, "supportedVideoCodecs");
        C12238m.checkNotNullParameter(type, "type");
        C12238m.checkNotNullParameter(c5640a, "connectionOptions");
        C12238m.checkNotNullParameter(list2, "listeners");
        this.f1708k = executorServiceC1192c;
        this.f1709l = logger;
        this.f1710m = c1243u;
        this.f1711n = discord;
        this.f1712o = list;
        this.f1713p = type;
        this.f1714q = j2;
        MediaEngineConnection.ConnectionState connectionState = MediaEngineConnection.ConnectionState.CONNECTING;
        this.f1699b = connectionState;
        this.f1701d = C12136h0.mutableMapOf(C12116o.m10073to(Long.valueOf(j2), Integer.valueOf(c5640a.f18898a)));
        this.f1702e = new LinkedHashMap();
        this.f1703f = new LinkedHashSet();
        this.f1704g = new LinkedHashSet();
        this.f1705h = new LinkedHashSet();
        this.f1706i = new ArrayList();
        int i2 = c5640a.f18898a;
        String str = c5640a.f18899b;
        int i3 = c5640a.f18900c;
        Object[] array = c5640a.f18901d.toArray(new StreamParameters[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Connection connectionConnectToServer = discord.connectToServer(i2, j2, str, i3, (StreamParameters[]) array, new C1226d(this));
        C12238m.checkNotNullExpressionValue(connectionConnectToServer, "voiceEngineLegacy.connec…fo, errorMessage) }\n    }");
        connectionConnectToServer.setOnVideoCallback(new C1224b(this));
        connectionConnectToServer.setUserSpeakingStatusChangedCallback(new C1225c(this));
        this.f1707j = connectionConnectToServer;
        this.f1698a = new CopyOnWriteArrayList<>(list2);
        this.f1699b = connectionState;
        m318y(new C1223a(this, connectionState));
    }

    /* JADX INFO: renamed from: x */
    public static final void m294x(C1227e c1227e, Function0 function0) {
        ExecutorServiceC1192c executorServiceC1192c = c1227e.f1708k;
        executorServiceC1192c.f1609l.execute(new RunnableC1231i(function0));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: a */
    public synchronized void mo295a(Intent intent, ThumbnailEmitter thumbnailEmitter) {
        C12238m.checkNotNullParameter(intent, "permission");
        m319z(new v(new C1222b(intent, new w(), this.f1709l, thumbnailEmitter)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: b */
    public boolean mo296b() {
        return this.f1710m.f1757a;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: c */
    public void mo297c(boolean z2) {
        this.f1700c = z2;
        m319z(new t(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: d */
    public void mo298d(long j2, boolean z2) {
        if (z2) {
            this.f1705h.add(Long.valueOf(j2));
        } else {
            this.f1705h.remove(Long.valueOf(j2));
        }
        m318y(new m(j2, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void destroy() {
        Logger.i$default(this.f1709l, "MediaEngineConnectionLegacy", "destroy(). Disconnecting from server", null, 4, null);
        m319z(b.f1715j);
        m318y(new c());
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: e */
    public void mo299e(long j2, float f2) {
        m319z(new n(j2, f2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: f */
    public void mo300f(KrispOveruseDetector.Status status) {
        C12238m.checkNotNullParameter(status, "status");
        m318y(new e(status));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: g */
    public boolean mo301g(long j2) {
        return this.f1704g.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public MediaEngineConnection.Type getType() {
        return this.f1713p;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: h */
    public synchronized void mo302h() {
        m319z(x.f1717j);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: i */
    public void mo303i(long j2, boolean z2) {
        m319z(new d(j2, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: j */
    public void mo304j(boolean z2) {
        m319z(new u(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: k */
    public void mo305k(MediaEngineConnection.InputMode inputMode, MediaEngineConnection.C5647c c5647c) {
        C12238m.checkNotNullParameter(inputMode, "inputMode");
        C12238m.checkNotNullParameter(c5647c, "inputModeOptions");
        C1243u c1243u = this.f1710m;
        if (inputMode == MediaEngineConnection.InputMode.VOICE_ACTIVITY) {
            boolean z2 = c5647c.f18914d;
        }
        Objects.requireNonNull(c1243u);
        m319z(new j(c5647c, inputMode));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: l */
    public void mo306l(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
        C12238m.checkNotNullParameter(interfaceC5648d, "listener");
        this.f1698a.add(interfaceC5648d);
        interfaceC5648d.onConnectionStateChange(this, this.f1699b);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: m */
    public void mo307m(MediaEngineConnection.C5646b c5646b) {
        C12238m.checkNotNullParameter(c5646b, "quality");
        int i2 = this.f1700c ? c5646b.f18909e : c5646b.f18910f;
        m318y(new p(i2));
        m318y(new q(c5646b));
        m319z(new r(c5646b, i2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: n */
    public void mo308n(Function1<? super Stats, Unit> function1) {
        C12238m.checkNotNullParameter(function1, "onStats");
        m319z(new f(function1));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: o */
    public void mo309o(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
        C12238m.checkNotNullParameter(interfaceC5648d, "listener");
        this.f1698a.remove(interfaceC5648d);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: p */
    public boolean mo310p(long j2) {
        return this.f1705h.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: q */
    public void mo311q(boolean z2) {
        m319z(new o(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: r */
    public void mo312r(String str, String str2) {
        Object obj;
        Object next;
        C12238m.checkNotNullParameter(str, "audioCodec");
        C12238m.checkNotNullParameter(str2, "videoCodec");
        Iterator<T> it = this.f1706i.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!C12238m.areEqual(((C1221a) next).f1671a, str));
        C1221a c1221a = (C1221a) next;
        for (Object obj2 : this.f1706i) {
            if (C12238m.areEqual(((C1221a) obj2).f1671a, str2)) {
                obj = obj2;
                break;
            }
        }
        C1221a c1221a2 = (C1221a) obj;
        try {
            if (c1221a == null) {
                throw new MediaEngineConnection.FailedConnectionException("Missing audio codec: " + str + '.', MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            if (c1221a2 == null) {
                throw new MediaEngineConnection.FailedConnectionException("Missing video codec: " + str2 + '.', MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            Integer num = c1221a2.f1675e;
            if (num == null) {
                throw new MediaEngineConnection.FailedConnectionException("Video codec " + str2 + " rtxPayloadType was null.", MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            num.intValue();
            AudioEncoder audioEncoder = new AudioEncoder(c1221a.f1674d, str, 48000, 960, 1, 64000);
            AudioDecoder audioDecoder = new AudioDecoder(c1221a.f1674d, str, 48000, 2, C12134g0.mapOf(C12116o.m10073to("stereo", "1")));
            Map mapMapOf = C12136h0.mapOf(C12116o.m10073to("level-asymmetry-allowed", "1"), C12116o.m10073to("packetization-mode", "1"), C12116o.m10073to("profile-level-id", "42e01f"));
            m319z(new h(audioEncoder, new VideoEncoder(str2, c1221a2.f1674d, c1221a2.f1675e.intValue(), mapMapOf), audioDecoder, new VideoDecoder(str2, c1221a2.f1674d, c1221a2.f1675e.intValue(), mapMapOf)));
        } catch (MediaEngineConnection.FailedConnectionException e2) {
            m318y(new g(e2));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: s */
    public void mo313s(long j2, int i2, Integer num, boolean z2, float f2) {
        if (i2 == 0) {
            Logger.w$default(this.f1709l, "MediaEngineConnectionLegacy", "Attempting to create user " + j2 + " with 0 audio SSRC", null, 4, null);
            return;
        }
        Long lValueOf = num != null ? Long.valueOf(num.intValue()) : this.f1702e.get(Long.valueOf(j2));
        long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
        Integer num2 = this.f1701d.get(Long.valueOf(j2));
        boolean z3 = num2 == null || num2.intValue() != i2;
        Long l2 = this.f1702e.get(Long.valueOf(j2));
        boolean z4 = l2 == null || l2.longValue() != jLongValue;
        if (z3 || z4) {
            Logger.i$default(this.f1709l, "MediaEngineConnectionLegacy", "creating user: " + j2 + " with audio SSRC: " + i2 + " and video SSRC: " + num, null, 4, null);
            m319z(new a(j2, i2, jLongValue, z2, f2));
        }
        if (z2) {
            this.f1703f.add(Long.valueOf(j2));
        } else {
            this.f1703f.remove(Long.valueOf(j2));
        }
        this.f1701d.put(Long.valueOf(j2), Integer.valueOf(i2));
        this.f1702e.put(Long.valueOf(j2), Long.valueOf(jLongValue));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: t */
    public void mo314t(String str, int[] iArr) {
        C12238m.checkNotNullParameter(str, "mode");
        C12238m.checkNotNullParameter(iArr, "secretKey");
        m319z(new i(new EncryptionSettings(str, iArr)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: u */
    public boolean mo315u(long j2) {
        return this.f1703f.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: v */
    public void mo316v(boolean z2) {
        m319z(new s(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    /* JADX INFO: renamed from: w */
    public void mo317w(long j2, boolean z2) {
        m319z(new k(j2, z2));
        if (z2) {
            this.f1703f.add(Long.valueOf(j2));
        } else {
            this.f1703f.remove(Long.valueOf(j2));
        }
        m318y(new l(j2, z2));
    }

    /* JADX INFO: renamed from: y */
    public final void m318y(Function1<? super MediaEngineConnection.InterfaceC5648d, Unit> function1) {
        for (MediaEngineConnection.InterfaceC5648d interfaceC5648d : this.f1698a) {
            try {
                C12238m.checkNotNullExpressionValue(interfaceC5648d, "it");
                function1.invoke(interfaceC5648d);
            } catch (Exception e2) {
                Logger.e$default(this.f1709l, "MediaEngineConnectionLegacy", "Error in listener", e2, null, 8, null);
            }
        }
    }

    /* JADX INFO: renamed from: z */
    public final synchronized void m319z(Function1<? super Connection, Unit> function1) {
        function1.invoke(this.f1707j);
    }
}
