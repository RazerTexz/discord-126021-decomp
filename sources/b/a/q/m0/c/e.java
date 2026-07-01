package b.a.q.m0.c;

import android.content.Intent;
import co.discord.media_engine.AudioDecoder;
import co.discord.media_engine.AudioEncoder;
import co.discord.media_engine.Connection;
import co.discord.media_engine.EncryptionSettings;
import co.discord.media_engine.Stats;
import co.discord.media_engine.StreamParameters;
import co.discord.media_engine.VideoDecoder;
import co.discord.media_engine.VideoEncoder;
import com.discord.rtcconnection.KrispOveruseDetector$Status;
import com.discord.rtcconnection.mediaengine.MediaEngine$a;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$ConnectionState;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$FailedConnectionException;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$FailedConnectionException$FailureType;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$InputMode;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$Type;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$b;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$c;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection$d;
import com.discord.rtcconnection.mediaengine.ThumbnailEmitter;
import com.discord.utilities.logging.Logger;
import com.hammerandchisel.libdiscord.Discord;
import d0.t.g0;
import d0.t.h0;
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

/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class e implements MediaEngineConnection {
    public final CopyOnWriteArrayList<MediaEngineConnection$d> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaEngineConnection$ConnectionState f270b;
    public boolean c;
    public final Map<Long, Integer> d;
    public final Map<Long, Long> e;
    public final Set<Long> f;
    public final Set<Long> g;
    public final Set<Long> h;
    public final List<b.a.q.m0.a> i;
    public final Connection j;
    public final b.a.q.c k;
    public final Logger l;
    public final u m;
    public final Discord n;
    public final List<b.a.q.m0.a> o;
    public final MediaEngineConnection$Type p;
    public final long q;

    public e(b.a.q.c cVar, Logger logger, u uVar, Discord discord, List<b.a.q.m0.a> list, MediaEngineConnection$Type mediaEngineConnection$Type, long j, MediaEngine$a mediaEngine$a, List<? extends MediaEngineConnection$d> list2) {
        d0.z.d.m.checkNotNullParameter(cVar, "mediaEngineThreadExecutor");
        d0.z.d.m.checkNotNullParameter(logger, "logger");
        d0.z.d.m.checkNotNullParameter(uVar, "noiseCancellationConfig");
        d0.z.d.m.checkNotNullParameter(discord, "voiceEngineLegacy");
        d0.z.d.m.checkNotNullParameter(list, "supportedVideoCodecs");
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$Type, "type");
        d0.z.d.m.checkNotNullParameter(mediaEngine$a, "connectionOptions");
        d0.z.d.m.checkNotNullParameter(list2, "listeners");
        this.k = cVar;
        this.l = logger;
        this.m = uVar;
        this.n = discord;
        this.o = list;
        this.p = mediaEngineConnection$Type;
        this.q = j;
        MediaEngineConnection$ConnectionState mediaEngineConnection$ConnectionState = MediaEngineConnection$ConnectionState.CONNECTING;
        this.f270b = mediaEngineConnection$ConnectionState;
        this.d = h0.mutableMapOf(d0.o.to(Long.valueOf(j), Integer.valueOf(mediaEngine$a.a)));
        this.e = new LinkedHashMap();
        this.f = new LinkedHashSet();
        this.g = new LinkedHashSet();
        this.h = new LinkedHashSet();
        this.i = new ArrayList();
        int i = mediaEngine$a.a;
        String str = mediaEngine$a.f2797b;
        int i2 = mediaEngine$a.c;
        Object[] array = mediaEngine$a.d.toArray(new StreamParameters[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        Connection connectionConnectToServer = discord.connectToServer(i, j, str, i2, (StreamParameters[]) array, new d(this));
        d0.z.d.m.checkNotNullExpressionValue(connectionConnectToServer, "voiceEngineLegacy.connec…fo, errorMessage) }\n    }");
        connectionConnectToServer.setOnVideoCallback(new b(this));
        connectionConnectToServer.setUserSpeakingStatusChangedCallback(new c(this));
        this.j = connectionConnectToServer;
        this.a = new CopyOnWriteArrayList<>(list2);
        this.f270b = mediaEngineConnection$ConnectionState;
        y(new a(this, mediaEngineConnection$ConnectionState));
    }

    public static final void x(e eVar, Function0 function0) {
        b.a.q.c cVar = eVar.k;
        cVar.l.execute(new i(function0));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public synchronized void a(Intent intent, ThumbnailEmitter thumbnailEmitter) {
        d0.z.d.m.checkNotNullParameter(intent, "permission");
        z(new e$v(new b.a.q.m0.b(intent, new e$w(), this.l, thumbnailEmitter)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean b() {
        return this.m.a;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void c(boolean z2) {
        this.c = z2;
        z(new e$t(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void d(long j, boolean z2) {
        if (z2) {
            this.h.add(Long.valueOf(j));
        } else {
            this.h.remove(Long.valueOf(j));
        }
        y(new e$m(j, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void destroy() {
        Logger.i$default(this.l, "MediaEngineConnectionLegacy", "destroy(). Disconnecting from server", null, 4, null);
        z(e$b.j);
        y(new e$c(this));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void e(long j, float f) {
        z(new e$n(j, f));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void f(KrispOveruseDetector$Status krispOveruseDetector$Status) {
        d0.z.d.m.checkNotNullParameter(krispOveruseDetector$Status, "status");
        y(new e$e(this, krispOveruseDetector$Status));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean g(long j) {
        return this.g.contains(Long.valueOf(j));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public MediaEngineConnection$Type getType() {
        return this.p;
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public synchronized void h() {
        z(e$x.j);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void i(long j, boolean z2) {
        z(new e$d(j, z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void j(boolean z2) {
        z(new e$u(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void k(MediaEngineConnection$InputMode mediaEngineConnection$InputMode, MediaEngineConnection$c mediaEngineConnection$c) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$InputMode, "inputMode");
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$c, "inputModeOptions");
        u uVar = this.m;
        if (mediaEngineConnection$InputMode == MediaEngineConnection$InputMode.VOICE_ACTIVITY) {
            boolean z2 = mediaEngineConnection$c.d;
        }
        Objects.requireNonNull(uVar);
        z(new e$j(mediaEngineConnection$c, mediaEngineConnection$InputMode));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void l(MediaEngineConnection$d mediaEngineConnection$d) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d, "listener");
        this.a.add(mediaEngineConnection$d);
        mediaEngineConnection$d.onConnectionStateChange(this, this.f270b);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void m(MediaEngineConnection$b mediaEngineConnection$b) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$b, "quality");
        int i = this.c ? mediaEngineConnection$b.e : mediaEngineConnection$b.f;
        y(new e$p(i));
        y(new e$q(mediaEngineConnection$b));
        z(new e$r(mediaEngineConnection$b, i));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void n(Function1<? super Stats, Unit> function1) {
        d0.z.d.m.checkNotNullParameter(function1, "onStats");
        z(new e$f(this, function1));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void o(MediaEngineConnection$d mediaEngineConnection$d) {
        d0.z.d.m.checkNotNullParameter(mediaEngineConnection$d, "listener");
        this.a.remove(mediaEngineConnection$d);
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean p(long j) {
        return this.h.contains(Long.valueOf(j));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void q(boolean z2) {
        z(new e$o(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void r(String str, String str2) {
        Object obj;
        Object next;
        d0.z.d.m.checkNotNullParameter(str, "audioCodec");
        d0.z.d.m.checkNotNullParameter(str2, "videoCodec");
        Iterator<T> it = this.i.iterator();
        do {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!d0.z.d.m.areEqual(((b.a.q.m0.a) next).a, str));
        b.a.q.m0.a aVar = (b.a.q.m0.a) next;
        for (Object obj2 : this.i) {
            if (d0.z.d.m.areEqual(((b.a.q.m0.a) obj2).a, str2)) {
                obj = obj2;
                break;
            }
        }
        b.a.q.m0.a aVar2 = (b.a.q.m0.a) obj;
        try {
            if (aVar == null) {
                throw new MediaEngineConnection$FailedConnectionException("Missing audio codec: " + str + '.', MediaEngineConnection$FailedConnectionException$FailureType.CODEC_NEGOTIATION_FAILED);
            }
            if (aVar2 == null) {
                throw new MediaEngineConnection$FailedConnectionException("Missing video codec: " + str2 + '.', MediaEngineConnection$FailedConnectionException$FailureType.CODEC_NEGOTIATION_FAILED);
            }
            Integer num = aVar2.e;
            if (num == null) {
                throw new MediaEngineConnection$FailedConnectionException("Video codec " + str2 + " rtxPayloadType was null.", MediaEngineConnection$FailedConnectionException$FailureType.CODEC_NEGOTIATION_FAILED);
            }
            num.intValue();
            AudioEncoder audioEncoder = new AudioEncoder(aVar.d, str, 48000, 960, 1, 64000);
            AudioDecoder audioDecoder = new AudioDecoder(aVar.d, str, 48000, 2, g0.mapOf(d0.o.to("stereo", "1")));
            Map mapMapOf = h0.mapOf(d0.o.to("level-asymmetry-allowed", "1"), d0.o.to("packetization-mode", "1"), d0.o.to("profile-level-id", "42e01f"));
            z(new e$h(audioEncoder, new VideoEncoder(str2, aVar2.d, aVar2.e.intValue(), mapMapOf), audioDecoder, new VideoDecoder(str2, aVar2.d, aVar2.e.intValue(), mapMapOf)));
        } catch (MediaEngineConnection$FailedConnectionException e) {
            y(new e$g(this, e));
        }
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void s(long j, int i, Integer num, boolean z2, float f) {
        if (i == 0) {
            Logger.w$default(this.l, "MediaEngineConnectionLegacy", "Attempting to create user " + j + " with 0 audio SSRC", null, 4, null);
            return;
        }
        Long lValueOf = num != null ? Long.valueOf(num.intValue()) : this.e.get(Long.valueOf(j));
        long jLongValue = lValueOf != null ? lValueOf.longValue() : 0L;
        Integer num2 = this.d.get(Long.valueOf(j));
        boolean z3 = num2 == null || num2.intValue() != i;
        Long l = this.e.get(Long.valueOf(j));
        boolean z4 = l == null || l.longValue() != jLongValue;
        if (z3 || z4) {
            Logger.i$default(this.l, "MediaEngineConnectionLegacy", "creating user: " + j + " with audio SSRC: " + i + " and video SSRC: " + num, null, 4, null);
            z(new e$a(this, j, i, jLongValue, z2, f));
        }
        if (z2) {
            this.f.add(Long.valueOf(j));
        } else {
            this.f.remove(Long.valueOf(j));
        }
        this.d.put(Long.valueOf(j), Integer.valueOf(i));
        this.e.put(Long.valueOf(j), Long.valueOf(jLongValue));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void t(String str, int[] iArr) {
        d0.z.d.m.checkNotNullParameter(str, "mode");
        d0.z.d.m.checkNotNullParameter(iArr, "secretKey");
        z(new e$i(new EncryptionSettings(str, iArr)));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public boolean u(long j) {
        return this.f.contains(Long.valueOf(j));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void v(boolean z2) {
        z(new e$s(z2));
    }

    @Override // com.discord.rtcconnection.mediaengine.MediaEngineConnection
    public void w(long j, boolean z2) {
        z(new e$k(j, z2));
        if (z2) {
            this.f.add(Long.valueOf(j));
        } else {
            this.f.remove(Long.valueOf(j));
        }
        y(new e$l(j, z2));
    }

    public final void y(Function1<? super MediaEngineConnection$d, Unit> function1) {
        for (MediaEngineConnection$d mediaEngineConnection$d : this.a) {
            try {
                d0.z.d.m.checkNotNullExpressionValue(mediaEngineConnection$d, "it");
                function1.invoke(mediaEngineConnection$d);
            } catch (Exception e) {
                Logger.e$default(this.l, "MediaEngineConnectionLegacy", "Error in listener", e, null, 8, null);
            }
        }
    }

    public final synchronized void z(Function1<? super Connection, Unit> function1) {
        function1.invoke(this.j);
    }
}
