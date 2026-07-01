package b.a.q.m0.c;

import android.content.Intent;
import android.media.projection.MediaProjection;
import b.a.q.MediaEngineExecutorService;
import b.a.q.m0.Codec2;
import b.a.q.m0.ScreenCapturer;
import co.discord.media_engine.Codecs2;
import co.discord.media_engine.Codecs3;
import co.discord.media_engine.Codecs4;
import co.discord.media_engine.Codecs5;
import co.discord.media_engine.Connection;
import co.discord.media_engine.EncryptionSettings;
import co.discord.media_engine.Stats;
import co.discord.media_engine.StreamParameters;
import com.discord.rtcconnection.KrispOveruseDetector;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
import d0.Tuples;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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

/* JADX INFO: renamed from: b.a.q.m0.c.e, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy5 implements MediaEngineConnection {
    public final CopyOnWriteArrayList<MediaEngineConnection.d> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaEngineConnection.ConnectionState f270b;
    public boolean c;
    public final Map<Long, Integer> d;
    public final Map<Long, Long> e;
    public final Set<Long> f;
    public final Set<Long> g;
    public final Set<Long> h;
    public final List<Codec2> i;
    public final Connection j;
    public final MediaEngineExecutorService k;
    public final Logger l;
    public final NoiseCancellationConfig m;
    public final Discord n;
    public final List<Codec2> o;
    public final MediaEngineConnection.Type p;
    public final long q;

    /* JADX INFO: renamed from: b.a.q.m0.c.e$a */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends Lambda implements Function1<Connection, Unit> {
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
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            long j = this.$userId;
            int i = this.$audioSsrc;
            int i2 = (int) this.$resolvedVideoSsrc;
            Objects.requireNonNull(MediaEngineConnectionLegacy5.this);
            connection2.connectUser(j, i, i2, i2 > 0 ? i2 + 1 : 0, this.$isMuted, this.$volume);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$b */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Connection, Unit> {
        public static final b j = new b();

        public b() {
            super(1, Connection.class, "dispose", "dispose()V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "p1");
            connection2.dispose();
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$c */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class c extends Lambda implements Function1<MediaEngineConnection.d, Unit> {
        public c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            Intrinsics3.checkNotNullParameter(dVar2, "it");
            dVar2.onConnectionStateChange(MediaEngineConnectionLegacy5.this, MediaEngineConnection.ConnectionState.DISCONNECTED);
            dVar2.onDestroy(MediaEngineConnectionLegacy5.this);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$d */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class d extends Lambda implements Function1<Connection, Unit> {
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
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.disableVideo(this.$userId, this.$disabled);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$e */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class e extends Lambda implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ KrispOveruseDetector.Status $status;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(KrispOveruseDetector.Status status) {
            super(1);
            this.$status = status;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            Intrinsics3.checkNotNullParameter(dVar2, "it");
            dVar2.onKrispStatus(MediaEngineConnectionLegacy5.this, this.$status);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$f */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class f extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ Function1 $onStats;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Function1 function1) {
            super(1);
            this.$onStats = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.getStats(new MediaEngineConnectionLegacy6(this));
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$g */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class g extends Lambda implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ MediaEngineConnection.FailedConnectionException $e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(MediaEngineConnection.FailedConnectionException failedConnectionException) {
            super(1);
            this.$e = failedConnectionException;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            Intrinsics3.checkNotNullParameter(dVar2, "it");
            dVar2.onError(MediaEngineConnectionLegacy5.this, this.$e);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$h */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class h extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ Codecs2 $audioDecoder;
        public final /* synthetic */ Codecs3 $audioEncoder;
        public final /* synthetic */ Codecs4 $videoDecoder;
        public final /* synthetic */ Codecs5 $videoEncoder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Codecs3 codecs3, Codecs5 codecs5, Codecs2 codecs2, Codecs4 codecs4) {
            super(1);
            this.$audioEncoder = codecs3;
            this.$videoEncoder = codecs5;
            this.$audioDecoder = codecs2;
            this.$videoDecoder = codecs4;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setCodecs(this.$audioEncoder, this.$videoEncoder, new Codecs2[]{this.$audioDecoder}, new Codecs4[]{this.$videoDecoder});
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$i */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class i extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ EncryptionSettings $encryptionSettings;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(EncryptionSettings encryptionSettings) {
            super(1);
            this.$encryptionSettings = encryptionSettings;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setEncryptionSettings(this.$encryptionSettings);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$j */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class j extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ MediaEngineConnection.InputMode $inputMode;
        public final /* synthetic */ MediaEngineConnection.c $inputModeOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(MediaEngineConnection.c cVar, MediaEngineConnection.InputMode inputMode) {
            super(1);
            this.$inputModeOptions = cVar;
            this.$inputMode = inputMode;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setVADLeadingFramesToBuffer(this.$inputModeOptions.f2800b);
            connection2.setVADTrailingFramesToSend(this.$inputModeOptions.c);
            connection2.setVADTriggerThreshold(this.$inputModeOptions.a);
            connection2.setVADAutoThreshold(this.$inputModeOptions.d ? 3 : -1);
            connection2.setVADUseKrisp(this.$inputModeOptions.e);
            connection2.setAudioInputMode(this.$inputMode.getNumeral());
            connection2.enableForwardErrorCorrection(true);
            connection2.setExpectedPacketLossRate(0.3f);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$k */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class k extends Lambda implements Function1<Connection, Unit> {
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
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.muteUser(this.$userId, this.$mute);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$l */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class l extends Lambda implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ boolean $mute;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$mute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            Intrinsics3.checkNotNullParameter(dVar2, "it");
            dVar2.onLocalMute(this.$userId, this.$mute);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$m */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class m extends Lambda implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ boolean $offScreen;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(long j, boolean z2) {
            super(1);
            this.$userId = j;
            this.$offScreen = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            Intrinsics3.checkNotNullParameter(dVar2, "it");
            dVar2.onLocalVideoOffScreen(this.$userId, this.$offScreen);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$n */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class n extends Lambda implements Function1<Connection, Unit> {
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
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setUserPlayoutVolume(this.$userId, this.$volume / 100.0f);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$o */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class o extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $active;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(boolean z2) {
            super(1);
            this.$active = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setPTTActive(this.$active);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$p */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class p extends Lambda implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ int $frameRate;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(int i) {
            super(1);
            this.$frameRate = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            Intrinsics3.checkNotNullParameter(dVar2, "it");
            dVar2.onTargetFrameRate(this.$frameRate);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$q */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class q extends Lambda implements Function1<MediaEngineConnection.d, Unit> {
        public final /* synthetic */ MediaEngineConnection.b $quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(MediaEngineConnection.b bVar) {
            super(1);
            this.$quality = bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(MediaEngineConnection.d dVar) {
            MediaEngineConnection.d dVar2 = dVar;
            Intrinsics3.checkNotNullParameter(dVar2, "it");
            dVar2.onTargetBitrate(this.$quality.f2799b);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$r */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class r extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ int $frameRate;
        public final /* synthetic */ MediaEngineConnection.b $quality;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(MediaEngineConnection.b bVar, int i) {
            super(1);
            this.$quality = bVar;
            this.$frameRate = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            MediaEngineConnection.b bVar = this.$quality;
            connection2.setEncodingQuality(bVar.a, bVar.f2799b, bVar.c, bVar.d, this.$frameRate);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$s */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class s extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $selfDeaf;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(boolean z2) {
            super(1);
            this.$selfDeaf = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.deafenLocalUser(this.$selfDeaf);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$t */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class t extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $selfMute;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(boolean z2) {
            super(1);
            this.$selfMute = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.muteLocalUser(this.$selfMute);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$u */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class u extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ boolean $isVideoBroadcast;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(boolean z2) {
            super(1);
            this.$isVideoBroadcast = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.setVideoBroadcast(this.$isVideoBroadcast);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.m0.c.e$v */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class v extends Lambda implements Function1<Connection, Unit> {
        public final /* synthetic */ ScreenCapturer $screenCapturer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public v(ScreenCapturer screenCapturer) {
            super(1);
            this.$screenCapturer = screenCapturer;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            ScreenCapturer screenCapturer = this.$screenCapturer;
            connection2.startScreenshareBroadcast(screenCapturer, screenCapturer.o.getNativeInstance());
            return Unit.a;
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
    public static final class x extends Lambda implements Function1<Connection, Unit> {
        public static final x j = new x();

        public x() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Connection connection) {
            Connection connection2 = connection;
            Intrinsics3.checkNotNullParameter(connection2, "$receiver");
            connection2.stopScreenshareBroadcast();
            return Unit.a;
        }
    }

    public MediaEngineConnectionLegacy5(MediaEngineExecutorService mediaEngineExecutorService, Logger logger, NoiseCancellationConfig noiseCancellationConfig, Discord discord, List<Codec2> list, MediaEngineConnection.Type type, long j2, MediaEngine.a aVar, List<? extends MediaEngineConnection.d> list2) {
        Intrinsics3.checkNotNullParameter(mediaEngineExecutorService, "mediaEngineThreadExecutor");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(noiseCancellationConfig, "noiseCancellationConfig");
        Intrinsics3.checkNotNullParameter(discord, "voiceEngineLegacy");
        Intrinsics3.checkNotNullParameter(list, "supportedVideoCodecs");
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(aVar, "connectionOptions");
        Intrinsics3.checkNotNullParameter(list2, "listeners");
        this.k = mediaEngineExecutorService;
        this.l = logger;
        this.m = noiseCancellationConfig;
        this.n = discord;
        this.o = list;
        this.p = type;
        this.q = j2;
        MediaEngineConnection.ConnectionState connectionState = MediaEngineConnection.ConnectionState.CONNECTING;
        this.f270b = connectionState;
        this.d = Maps6.mutableMapOf(Tuples.to(Long.valueOf(j2), Integer.valueOf(aVar.a)));
        this.e = new LinkedHashMap();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
        this.i = new ArrayList();
        int i2 = aVar.a;
        String str = aVar.f2797b;
        int i3 = aVar.c;
        Object[] array = aVar.d.toArray(new StreamParameters[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Connection connectionConnectToServer = discord.connectToServer(i2, j2, str, i3, (StreamParameters[]) array, new MediaEngineConnectionLegacy4(this));
        Intrinsics3.checkNotNullExpressionValue(connectionConnectToServer, "voiceEngineLegacy.connec…fo, errorMessage) }\n    }");
        connectionConnectToServer.setOnVideoCallback(new MediaEngineConnectionLegacy2(this));
        connectionConnectToServer.setUserSpeakingStatusChangedCallback(new MediaEngineConnectionLegacy3(this));
        this.j = connectionConnectToServer;
        this.a = new CopyOnWriteArrayList<>(list2);
        this.f270b = connectionState;
        y(new MediaEngineConnectionLegacy(this, connectionState));
    }

    public static final void x(MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5, Function0 function0) {
        MediaEngineExecutorService mediaEngineExecutorService = mediaEngineConnectionLegacy5.k;
        mediaEngineExecutorService.l.execute(new MediaEngineConnectionLegacy9(function0));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public synchronized void a(Intent intent, ThumbnailEmitter thumbnailEmitter) {
        Intrinsics3.checkNotNullParameter(intent, "permission");
        z(new v(new ScreenCapturer(intent, new w(), this.l, thumbnailEmitter)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean b() {
        return this.m.a;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void c(boolean z2) {
        this.c = z2;
        z(new t(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void d(long j2, boolean z2) {
        if (z2) {
            this.h.add(Long.valueOf(j2));
        } else {
            this.h.remove(Long.valueOf(j2));
        }
        y(new m(j2, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void destroy() {
        Logger.i$default(this.l, "MediaEngineConnectionLegacy", "destroy(). Disconnecting from server", null, 4, null);
        z(b.j);
        y(new c());
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void e(long j2, float f2) {
        z(new n(j2, f2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void f(KrispOveruseDetector.Status status) {
        Intrinsics3.checkNotNullParameter(status, "status");
        y(new e(status));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean g(long j2) {
        return this.g.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public MediaEngineConnection.Type getType() {
        return this.p;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public synchronized void h() {
        z(x.j);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void i(long j2, boolean z2) {
        z(new d(j2, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void j(boolean z2) {
        z(new u(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void k(MediaEngineConnection.InputMode inputMode, MediaEngineConnection.c cVar) {
        Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
        Intrinsics3.checkNotNullParameter(cVar, "inputModeOptions");
        NoiseCancellationConfig noiseCancellationConfig = this.m;
        if (inputMode == MediaEngineConnection.InputMode.VOICE_ACTIVITY) {
            boolean z2 = cVar.d;
        }
        Objects.requireNonNull(noiseCancellationConfig);
        z(new j(cVar, inputMode));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void l(MediaEngineConnection.d dVar) {
        Intrinsics3.checkNotNullParameter(dVar, "listener");
        this.a.add(dVar);
        dVar.onConnectionStateChange(this, this.f270b);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void m(MediaEngineConnection.b bVar) {
        Intrinsics3.checkNotNullParameter(bVar, "quality");
        int i2 = this.c ? bVar.e : bVar.f;
        y(new p(i2));
        y(new q(bVar));
        z(new r(bVar, i2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void n(Function1<? super Stats, Unit> function1) {
        Intrinsics3.checkNotNullParameter(function1, "onStats");
        z(new f(function1));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void o(MediaEngineConnection.d dVar) {
        Intrinsics3.checkNotNullParameter(dVar, "listener");
        this.a.remove(dVar);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean p(long j2) {
        return this.h.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void q(boolean z2) {
        z(new o(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void r(String str, String str2) {
        Object obj;
        Object next;
        Intrinsics3.checkNotNullParameter(str, "audioCodec");
        Intrinsics3.checkNotNullParameter(str2, "videoCodec");
        Iterator<T> it = this.i.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics3.areEqual(((Codec2) next).a, str));
        Codec2 codec2 = (Codec2) next;
        for (Object obj2 : this.i) {
            if (Intrinsics3.areEqual(((Codec2) obj2).a, str2)) {
                obj = obj2;
                break;
            }
        }
        Codec2 codec3 = (Codec2) obj;
        try {
            if (codec2 == null) {
                throw new MediaEngineConnection.FailedConnectionException("Missing audio codec: " + str + '.', MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            if (codec3 == null) {
                throw new MediaEngineConnection.FailedConnectionException("Missing video codec: " + str2 + '.', MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            Integer num = codec3.e;
            if (num == null) {
                throw new MediaEngineConnection.FailedConnectionException("Video codec " + str2 + " rtxPayloadType was null.", MediaEngineConnection.FailedConnectionException.FailureType.CODEC_NEGOTIATION_FAILED);
            }
            num.intValue();
            Codecs3 codecs3 = new Codecs3(codec2.d, str, 48000, 960, 1, 64000);
            Codecs2 codecs2 = new Codecs2(codec2.d, str, 48000, 2, MapsJVM.mapOf(Tuples.to("stereo", "1")));
            Map mapMapOf = Maps6.mapOf(Tuples.to("level-asymmetry-allowed", "1"), Tuples.to("packetization-mode", "1"), Tuples.to("profile-level-id", "42e01f"));
            z(new h(codecs3, new Codecs5(str2, codec3.d, codec3.e.intValue(), mapMapOf), codecs2, new Codecs4(str2, codec3.d, codec3.e.intValue(), mapMapOf)));
        } catch (MediaEngineConnection.FailedConnectionException e2) {
            y(new g(e2));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void s(long j2, int i2, Integer num, boolean z2, float f2) {
        if (i2 == 0) {
            Logger.w$default(this.l, "MediaEngineConnectionLegacy", "Attempting to create user " + j2 + " with 0 audio SSRC", null, 4, null);
            return;
        }
        Long lValueOf = num != null ? Long.valueOf(num.intValue()) : this.e.get(Long.valueOf(j2));
        long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
        Integer num2 = this.d.get(Long.valueOf(j2));
        boolean z3 = num2 == null || num2.intValue() != i2;
        Long l2 = this.e.get(Long.valueOf(j2));
        boolean z4 = l2 == null || l2.longValue() != jLongValue;
        if (z3 || z4) {
            Logger.i$default(this.l, "MediaEngineConnectionLegacy", "creating user: " + j2 + " with audio SSRC: " + i2 + " and video SSRC: " + num, null, 4, null);
            z(new a(j2, i2, jLongValue, z2, f2));
        }
        if (z2) {
            this.f.add(Long.valueOf(j2));
        } else {
            this.f.remove(Long.valueOf(j2));
        }
        this.d.put(Long.valueOf(j2), Integer.valueOf(i2));
        this.e.put(Long.valueOf(j2), Long.valueOf(jLongValue));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void t(String str, int[] iArr) {
        Intrinsics3.checkNotNullParameter(str, "mode");
        Intrinsics3.checkNotNullParameter(iArr, "secretKey");
        z(new i(new EncryptionSettings(str, iArr)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean u(long j2) {
        return this.f.contains(Long.valueOf(j2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void v(boolean z2) {
        z(new s(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void w(long j2, boolean z2) {
        z(new k(j2, z2));
        if (z2) {
            this.f.add(Long.valueOf(j2));
        } else {
            this.f.remove(Long.valueOf(j2));
        }
        y(new l(j2, z2));
    }

    public final void y(Function1<? super MediaEngineConnection.d, Unit> function1) {
        for (MediaEngineConnection.d dVar : this.a) {
            try {
                Intrinsics3.checkNotNullExpressionValue(dVar, "it");
                function1.invoke(dVar);
            } catch (Exception e2) {
                Logger.e$default(this.l, "MediaEngineConnectionLegacy", "Error in listener", e2, null, 8, null);
            }
        }
    }

    public final synchronized void z(Function1<? super Connection, Unit> function1) {
        function1.invoke(this.j);
    }
}
