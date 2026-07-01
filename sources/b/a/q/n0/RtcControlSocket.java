package b.a.q.n0;

import androidx.annotation.AnyThread;
import androidx.core.app.NotificationCompat;
import b.a.q.MediaEngineExecutorService;
import b.d.b.a.outline;
import b.i.d.GsonBuilder;
import b.i.d.q.x.JsonTreeReader;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.socket.io.Opcodes;
import com.discord.rtcconnection.socket.io.Payloads;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.debug.DebugPrintable2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.time.Clock;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import f0.OkHttpClient;
import f0.e0.k.Platform2;
import f0.e0.n.RealWebSocket;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/* JADX INFO: renamed from: b.a.q.n0.a, reason: use source file name */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RtcControlSocket extends WebSocketListener implements DebugPrintable {
    public static int j;
    public Long A;
    public c B;
    public boolean C;
    public final String D;
    public final String E;
    public final SSLSocketFactory F;
    public final Logger G;
    public final MediaEngineExecutorService H;
    public final Clock I;
    public final String J;
    public final String m;
    public final Gson n;
    public final Timer o;
    public final Backoff p;
    public final CopyOnWriteArraySet<d> q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WebSocket f275s;
    public String t;
    public String u;
    public Long v;
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public RtcControlSocket2 f276x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Long f277y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TimerTask f278z;
    public static final b l = new b(null);
    public static final Type k = new a().getType();

    /* JADX INFO: renamed from: b.a.q.n0.a$a */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class a extends TypeToken<Map<String, ? extends Integer>> {
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$b */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$c */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public enum c {
        DISCONNECTED,
        CONNECTING,
        IDENTIFYING,
        RESUMING,
        CONNECTED,
        RECONNECTING
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$d */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public interface d {
        void a(String str, String str2);

        void b(boolean z2, Integer num, String str);

        void c(String str, List<Integer> list);

        void d(String str);

        void e(long j, int i, int i2, List<Payloads.Stream> list);

        void f(Map<String, Integer> map);

        void g(long j);

        void h();

        void i();

        void j(long j);

        void k(int i, int i2, String str, List<Payloads.Stream> list);

        void onConnecting();

        void onSpeaking(long j, int i, boolean z2);
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$e */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class e extends Lambda implements Function1<WebSocket, Unit> {
        public static final e j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            Intrinsics3.checkNotNullParameter(webSocket2, "it");
            webSocket2.e(1000, "Force Close");
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$f */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class f extends Lambda implements Function1<WebSocket, Unit> {
        public static final f j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            Intrinsics3.checkNotNullParameter(webSocket2, "it");
            webSocket2.e(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "close reason");
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$g */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class g extends TimerTask {

        /* JADX INFO: renamed from: b.a.q.n0.a$g$a */
        /* JADX INFO: compiled from: RtcControlSocket.kt */
        public static final class a extends Lambda implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                RtcControlSocket.a(RtcControlSocket.this, true, null, "The connection timed out. Did not receive OP_HELLO in time.");
                return Unit.a;
            }
        }

        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            RtcControlSocket.this.m(new a());
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$h */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class h extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $code;
        public final /* synthetic */ String $reason;
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(WebSocket webSocket, int i, String str) {
            super(0);
            this.$webSocket = webSocket;
            this.$code = i;
            this.$reason = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!(!Intrinsics3.areEqual(this.$webSocket, RtcControlSocket.this.f275s))) {
                RtcControlSocket.a(RtcControlSocket.this, true, Integer.valueOf(this.$code), this.$reason);
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$i */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class i extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Throwable $t;
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(WebSocket webSocket, Throwable th) {
            super(0);
            this.$webSocket = webSocket;
            this.$t = th;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!(!Intrinsics3.areEqual(this.$webSocket, RtcControlSocket.this.f275s))) {
                RtcControlSocket rtcControlSocket = RtcControlSocket.this;
                StringBuilder sbU = outline.U("An error with the websocket occurred: ");
                sbU.append(this.$t.getMessage());
                RtcControlSocket.a(rtcControlSocket, true, null, sbU.toString());
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$j */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class j extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Payloads.Incoming $message;
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(WebSocket webSocket, Payloads.Incoming incoming) {
            super(0);
            this.$webSocket = webSocket;
            this.$message = incoming;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!(!Intrinsics3.areEqual(this.$webSocket, RtcControlSocket.this.f275s))) {
                switch (this.$message.getOpcode()) {
                    case 2:
                        RtcControlSocket rtcControlSocket = RtcControlSocket.this;
                        Object objC = rtcControlSocket.n.c(this.$message.getData(), Payloads.Ready.class);
                        Intrinsics3.checkNotNullExpressionValue(objC, "gson.fromJson(message.da…yloads.Ready::class.java)");
                        Payloads.Ready ready = (Payloads.Ready) objC;
                        rtcControlSocket.p.succeed();
                        long jCurrentTimeMillis = rtcControlSocket.I.currentTimeMillis();
                        Long l = rtcControlSocket.A;
                        rtcControlSocket.i("[READY] took " + (jCurrentTimeMillis - (l != null ? l.longValue() : 0L)) + " ms");
                        rtcControlSocket.H.a();
                        for (d dVar : rtcControlSocket.q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar, "it");
                            dVar.k(ready.getPort(), ready.getSsrc(), ready.getIp(), ready.getStreams());
                        }
                        break;
                    case 3:
                        RtcControlSocket rtcControlSocket2 = RtcControlSocket.this;
                        rtcControlSocket2.n(3, String.valueOf(rtcControlSocket2.I.currentTimeMillis()));
                        break;
                    case 4:
                        RtcControlSocket rtcControlSocket3 = RtcControlSocket.this;
                        Object objC2 = rtcControlSocket3.n.c(this.$message.getData(), Payloads.Description.class);
                        Intrinsics3.checkNotNullExpressionValue(objC2, "gson.fromJson(message.da….Description::class.java)");
                        Payloads.Description description = (Payloads.Description) objC2;
                        rtcControlSocket3.H.a();
                        for (d dVar2 : rtcControlSocket3.q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar2, "it");
                            dVar2.c(description.getMode(), description.getSecretKey());
                            dVar2.a(description.getAudioCodec(), description.getVideoCodec());
                            String mediaSessionId = description.getMediaSessionId();
                            if (mediaSessionId != null) {
                                dVar2.d(mediaSessionId);
                            }
                        }
                        rtcControlSocket3.C = true;
                        break;
                    case 5:
                        RtcControlSocket rtcControlSocket4 = RtcControlSocket.this;
                        Object objC3 = rtcControlSocket4.n.c(this.$message.getData(), Payloads.Speaking.class);
                        Intrinsics3.checkNotNullExpressionValue(objC3, "gson.fromJson(message.da…ads.Speaking::class.java)");
                        Payloads.Speaking speaking = (Payloads.Speaking) objC3;
                        if (speaking.getUserId() != null && speaking.getSpeaking() != null) {
                            Integer speaking2 = speaking.getSpeaking();
                            boolean z2 = speaking2 != null && speaking2.intValue() == 1;
                            rtcControlSocket4.H.a();
                            for (d dVar3 : rtcControlSocket4.q) {
                                Intrinsics3.checkNotNullExpressionValue(dVar3, "it");
                                dVar3.onSpeaking(speaking.getUserId().longValue(), speaking.getSsrc(), z2);
                            }
                        }
                        break;
                    case 6:
                        RtcControlSocket rtcControlSocket5 = RtcControlSocket.this;
                        Object objC4 = rtcControlSocket5.n.c(this.$message.getData(), Long.TYPE);
                        Intrinsics3.checkNotNullExpressionValue(objC4, "gson.fromJson(message.data, Long::class.java)");
                        long jLongValue = ((Number) objC4).longValue();
                        long jCurrentTimeMillis2 = rtcControlSocket5.I.currentTimeMillis();
                        long j = jCurrentTimeMillis2 - jLongValue;
                        rtcControlSocket5.h("got heartbeat ack after " + j + " ms");
                        rtcControlSocket5.f277y = Long.valueOf(jCurrentTimeMillis2);
                        rtcControlSocket5.w = true;
                        rtcControlSocket5.H.a();
                        for (d dVar4 : rtcControlSocket5.q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar4, "it");
                            dVar4.g(j);
                        }
                        break;
                    case 7:
                    case 10:
                    case 11:
                    default:
                        RtcControlSocket rtcControlSocket6 = RtcControlSocket.this;
                        StringBuilder sbU = outline.U("unknown opcode: ");
                        sbU.append(this.$message.getOpcode());
                        rtcControlSocket6.i(sbU.toString());
                        break;
                    case 8:
                        RtcControlSocket rtcControlSocket7 = RtcControlSocket.this;
                        Object objC5 = rtcControlSocket7.n.c(this.$message.getData(), Payloads.Hello.class);
                        Intrinsics3.checkNotNullExpressionValue(objC5, "gson.fromJson(message.da…yloads.Hello::class.java)");
                        Payloads.Hello hello = (Payloads.Hello) objC5;
                        TimerTask timerTask = rtcControlSocket7.f278z;
                        if (timerTask != null) {
                            timerTask.cancel();
                        }
                        rtcControlSocket7.i("[HELLO] raw: " + hello);
                        rtcControlSocket7.v = Long.valueOf(hello.getHeartbeatIntervalMs());
                        rtcControlSocket7.r = hello.getServerVersion();
                        rtcControlSocket7.f276x.cancel();
                        rtcControlSocket7.w = true;
                        rtcControlSocket7.k();
                        break;
                    case 9:
                        RtcControlSocket.this.p.succeed();
                        break;
                    case 12:
                        RtcControlSocket rtcControlSocket8 = RtcControlSocket.this;
                        Object objC6 = rtcControlSocket8.n.c(this.$message.getData(), Payloads.Video.class);
                        Intrinsics3.checkNotNullExpressionValue(objC6, "gson.fromJson(message.da…yloads.Video::class.java)");
                        Payloads.Video video = (Payloads.Video) objC6;
                        if (video.getUserId() != null) {
                            rtcControlSocket8.H.a();
                            for (d dVar5 : rtcControlSocket8.q) {
                                Intrinsics3.checkNotNullExpressionValue(dVar5, "it");
                                dVar5.e(video.getUserId().longValue(), video.getAudioSsrc(), video.getVideoSsrc(), video.getStreams());
                            }
                        }
                        break;
                    case 13:
                        RtcControlSocket rtcControlSocket9 = RtcControlSocket.this;
                        Object objC7 = rtcControlSocket9.n.c(this.$message.getData(), Payloads.ClientDisconnect.class);
                        Intrinsics3.checkNotNullExpressionValue(objC7, "gson.fromJson(message.da…ntDisconnect::class.java)");
                        Payloads.ClientDisconnect clientDisconnect = (Payloads.ClientDisconnect) objC7;
                        rtcControlSocket9.H.a();
                        for (d dVar6 : rtcControlSocket9.q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar6, "it");
                            dVar6.j(clientDisconnect.getUserId());
                        }
                        break;
                    case 14:
                        RtcControlSocket rtcControlSocket10 = RtcControlSocket.this;
                        Object objC8 = rtcControlSocket10.n.c(this.$message.getData(), Payloads.SessionUpdate.class);
                        Intrinsics3.checkNotNullExpressionValue(objC8, "gson.fromJson(message.da…essionUpdate::class.java)");
                        Payloads.SessionUpdate sessionUpdate = (Payloads.SessionUpdate) objC8;
                        rtcControlSocket10.H.a();
                        for (d dVar7 : rtcControlSocket10.q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar7, "it");
                            String mediaSessionId2 = sessionUpdate.getMediaSessionId();
                            if (mediaSessionId2 != null) {
                                dVar7.d(mediaSessionId2);
                            }
                        }
                        break;
                    case 15:
                        RtcControlSocket rtcControlSocket11 = RtcControlSocket.this;
                        Gson gson = rtcControlSocket11.n;
                        JsonElement data = this.$message.getData();
                        Type type = RtcControlSocket.k;
                        Objects.requireNonNull(gson);
                        Object objD = data == null ? null : gson.d(new JsonTreeReader(data), type);
                        Intrinsics3.checkNotNullExpressionValue(objD, "gson.fromJson(message.data, MEDIA_SINK_WANTS_TYPE)");
                        Map<String, Integer> map = (Map) objD;
                        rtcControlSocket11.H.a();
                        for (d dVar8 : rtcControlSocket11.q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar8, "it");
                            dVar8.f(map);
                        }
                        break;
                }
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$k */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class k extends Lambda implements Function0<Unit> {
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(WebSocket webSocket) {
            super(0);
            this.$webSocket = webSocket;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            boolean z2 = true;
            if (!(!Intrinsics3.areEqual(this.$webSocket, RtcControlSocket.this.f275s))) {
                RtcControlSocket rtcControlSocket = RtcControlSocket.this;
                c cVar = rtcControlSocket.B;
                if (cVar == c.CONNECTING) {
                    rtcControlSocket.H.a();
                    for (d dVar : rtcControlSocket.q) {
                        Intrinsics3.checkNotNullExpressionValue(dVar, "it");
                        dVar.i();
                    }
                } else if (cVar == c.RECONNECTING) {
                    String str = rtcControlSocket.u;
                    String str2 = rtcControlSocket.t;
                    String str3 = rtcControlSocket.E;
                    Long l = rtcControlSocket.f277y;
                    if (l != null && rtcControlSocket.I.currentTimeMillis() - l.longValue() > 60000) {
                        z2 = false;
                    }
                    if (str == null || str2 == null || !rtcControlSocket.C || !z2) {
                        StringBuilder sbU = outline.U("Cannot resume connection. resumable: ");
                        sbU.append(rtcControlSocket.C);
                        sbU.append(" -- isHeartbeatRecentEnough: ");
                        sbU.append(z2);
                        rtcControlSocket.f(false, 4801, sbU.toString());
                    } else {
                        rtcControlSocket.i("[RESUME] resuming session. serverId=" + str2 + " sessionId=" + str);
                        rtcControlSocket.H.a();
                        for (d dVar2 : rtcControlSocket.q) {
                            Intrinsics3.checkNotNullExpressionValue(dVar2, "it");
                            dVar2.h();
                        }
                        rtcControlSocket.B = c.RESUMING;
                        rtcControlSocket.n(7, new Payloads.Resume(str3, str, str2));
                    }
                }
                RtcControlSocket rtcControlSocket2 = RtcControlSocket.this;
                rtcControlSocket2.B = c.CONNECTED;
                long jCurrentTimeMillis = rtcControlSocket2.I.currentTimeMillis();
                Long l2 = RtcControlSocket.this.A;
                long jLongValue = jCurrentTimeMillis - (l2 != null ? l2.longValue() : 0L);
                RtcControlSocket rtcControlSocket3 = RtcControlSocket.this;
                StringBuilder sbU2 = outline.U("[CONNECTED] to ");
                sbU2.append(RtcControlSocket.this.D);
                rtcControlSocket3.i(sbU2.toString());
                RtcControlSocket rtcControlSocket4 = RtcControlSocket.this;
                rtcControlSocket4.H.a();
                for (d dVar3 : rtcControlSocket4.q) {
                    Intrinsics3.checkNotNullExpressionValue(dVar3, "it");
                    dVar3.g(jLongValue / ((long) 2));
                }
            }
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$l */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class l extends Lambda implements Function1<WebSocket, Unit> {
        public static final l j = new l();

        public l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            Intrinsics3.checkNotNullParameter(webSocket2, "it");
            webSocket2.e(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "reconnecting");
            return Unit.a;
        }
    }

    public RtcControlSocket(String str, String str2, SSLSocketFactory sSLSocketFactory, Logger logger, MediaEngineExecutorService mediaEngineExecutorService, Clock clock, String str3) {
        Intrinsics3.checkNotNullParameter(str, "endpoint");
        Intrinsics3.checkNotNullParameter(str2, "token");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(mediaEngineExecutorService, "mediaEngineThreadExecutor");
        Intrinsics3.checkNotNullParameter(clock, "clock");
        Intrinsics3.checkNotNullParameter(str3, "loggingTagPrefix");
        this.D = str;
        this.E = str2;
        this.F = sSLSocketFactory;
        this.G = logger;
        this.H = mediaEngineExecutorService;
        this.I = clock;
        this.J = str3;
        StringBuilder sbX = outline.X(str3, "->RtcControlSocket ");
        int i2 = j + 1;
        j = i2;
        sbX.append(i2);
        String string = sbX.toString();
        this.m = string;
        this.n = new GsonBuilder().a();
        this.o = new Timer();
        this.p = new Backoff(1000L, 5000L, 3, false, new Backoff.TimerScheduler(string, mediaEngineExecutorService), 8, null);
        this.q = new CopyOnWriteArraySet<>();
        this.r = 3;
        this.f276x = new RtcControlSocket2(this);
        this.B = c.DISCONNECTED;
    }

    public static final void a(RtcControlSocket rtcControlSocket, boolean z2, Integer num, String str) {
        rtcControlSocket.B = c.DISCONNECTED;
        if ((num != null && num.intValue() == 4004) || ((num != null && num.intValue() == 4015) || ((num != null && num.intValue() == 4011) || (num != null && num.intValue() == 4006)))) {
            rtcControlSocket.f(true, num, str);
            return;
        }
        if (rtcControlSocket.p.hasReachedFailureThreshold()) {
            rtcControlSocket.j("[WS CLOSED] Backoff exceeded. Resetting.");
            rtcControlSocket.f(z2, num, str);
            return;
        }
        rtcControlSocket.b(null);
        rtcControlSocket.j("`[WS CLOSED] (" + z2 + ", " + num + ", " + str + ") retrying in " + outline.P(new Object[]{Double.valueOf(rtcControlSocket.p.fail(new RtcControlSocket3(rtcControlSocket, z2, num, str)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
    }

    public final void b(Function1<? super WebSocket, Unit> function1) {
        this.p.cancel();
        this.f276x.cancel();
        TimerTask timerTask = this.f278z;
        if (timerTask != null) {
            timerTask.cancel();
        }
        WebSocket webSocket = this.f275s;
        if (webSocket != null && function1 != null) {
            function1.invoke(webSocket);
        }
        this.f275s = (WebSocket) null;
    }

    public final void c() {
        this.H.a();
        i("[CLOSE]");
        b(e.j);
        this.t = null;
        this.u = null;
        this.C = false;
        this.B = c.DISCONNECTED;
        this.H.a();
        for (d dVar : this.q) {
            Intrinsics3.checkNotNullExpressionValue(dVar, "it");
            dVar.b(false, 1000, "Force Close");
        }
    }

    public final boolean d() {
        this.H.a();
        if (this.B != c.DISCONNECTED) {
            j("Cannot start a new connection, connection state is not disconnected");
            return false;
        }
        this.B = c.CONNECTING;
        e();
        this.H.a();
        for (d dVar : this.q) {
            Intrinsics3.checkNotNullExpressionValue(dVar, "it");
            dVar.onConnecting();
        }
        return true;
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintable2 debugPrintable2) {
        Intrinsics3.checkNotNullParameter(debugPrintable2, "dp");
        debugPrintable2.appendKeyValue("serverId", this.t);
        debugPrintable2.appendKeyValue("sessionId", this.u);
        debugPrintable2.appendKeyValue("heartbeatInterval", this.v);
        debugPrintable2.appendKeyValue("lastHeartbeatAckTime", this.f277y);
        debugPrintable2.appendKeyValue("connectionStartTime", this.A);
        debugPrintable2.appendKeyValue("connectionState", this.B);
        debugPrintable2.appendKeyValue("resumable", Boolean.valueOf(this.C));
    }

    public final void e() {
        StringBuilder sbU = outline.U("[CONNECT] ");
        sbU.append(this.D);
        i(sbU.toString());
        if (this.f275s != null) {
            this.G.e(this.m, "Connect called with already existing websocket", null, null);
            b(f.j);
            return;
        }
        this.A = Long.valueOf(this.I.currentTimeMillis());
        TimerTask timerTask = this.f278z;
        if (timerTask != null) {
            timerTask.cancel();
        }
        g gVar = new g();
        this.f278z = gVar;
        this.o.schedule(gVar, 20000L);
        OkHttpClient.a aVar = new OkHttpClient.a();
        aVar.a(1L, TimeUnit.MINUTES);
        SSLSocketFactory sSLSocketFactory = this.F;
        if (sSLSocketFactory != null) {
            Platform2.a aVar2 = Platform2.c;
            aVar.b(sSLSocketFactory, Platform2.a.n());
        }
        String strJ = outline.J(new StringBuilder(), this.D, "?v=5");
        i("attempting WSS connection with " + strJ);
        OkHttpClient okHttpClient = new OkHttpClient(aVar);
        Request.a aVar3 = new Request.a();
        aVar3.f(strJ);
        this.f275s = okHttpClient.g(aVar3.a(), this);
    }

    public final void f(boolean z2, Integer num, String str) {
        j("[DISCONNECT] (" + z2 + ", " + num + ", " + str + ')');
        b(null);
        this.t = null;
        this.u = null;
        this.C = false;
        this.B = c.DISCONNECTED;
        this.H.a();
        for (d dVar : this.q) {
            Intrinsics3.checkNotNullExpressionValue(dVar, "it");
            dVar.b(z2, num, str);
        }
    }

    public final void g(long j2, String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.H.a();
        if (this.f275s != null) {
            i("Performing an immediate heartbeat on existing socket: " + str);
            this.f276x.cancel();
            RtcControlSocket2 rtcControlSocket2 = new RtcControlSocket2(this);
            this.f276x = rtcControlSocket2;
            this.o.schedule(rtcControlSocket2, j2);
            return;
        }
        if (!z2) {
            i("Immediate heartbeat requested, but is disconnected and a reset was not requested: " + str);
            return;
        }
        if (this.p.getIsPending() && this.f275s == null) {
            i("Connection backoff reset Immediate heartbeat when socket was disconnected.");
            this.p.succeed();
            l(false, 4802, "Reset backoff.");
        }
    }

    public final void h(String str) {
        Logger.d$default(this.G, this.m, str, null, 4, null);
    }

    public final void i(String str) {
        Logger.i$default(this.G, this.m, str, null, 4, null);
    }

    public final void j(String str) {
        Logger.w$default(this.G, this.m, str, null, 4, null);
    }

    public final void k() {
        if (!this.w) {
            b(RtcControlSocket4.j);
            j("[ACK TIMEOUT] reconnecting in " + outline.P(new Object[]{Double.valueOf(this.p.fail(new RtcControlSocket5(this)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
            return;
        }
        this.w = false;
        n(3, String.valueOf(this.I.currentTimeMillis()));
        Long l2 = this.v;
        if (l2 == null) {
            j("onHeartbeatInterval called when heartbeatInterval was null");
            return;
        }
        RtcControlSocket2 rtcControlSocket2 = new RtcControlSocket2(this);
        this.f276x = rtcControlSocket2;
        this.o.schedule(rtcControlSocket2, l2.longValue());
    }

    public final void l(boolean z2, Integer num, String str) {
        i("[RECONNECT] wasFatal=" + z2 + " code=" + num + " reason=" + str);
        b(l.j);
        this.B = c.RECONNECTING;
        e();
    }

    @AnyThread
    public final void m(Function0<Unit> function0) {
        MediaEngineExecutorService mediaEngineExecutorService = this.H;
        Object rtcControlSocket6 = function0;
        if (function0 != null) {
            rtcControlSocket6 = new RtcControlSocket6(function0);
        }
        mediaEngineExecutorService.l.execute((Runnable) rtcControlSocket6);
    }

    public final void n(int i2, Object obj) {
        WebSocket webSocket = this.f275s;
        if (webSocket == null) {
            StringBuilder sbU = outline.U("opcode() websocket null. opcode: ");
            sbU.append(Opcodes.INSTANCE.getNameOf(i2));
            this.G.e(this.m, sbU.toString(), null, null);
            return;
        }
        try {
            String strM = this.n.m(new Payloads.Outgoing(i2, obj));
            h("sending (" + Opcodes.INSTANCE.getNameOf(i2) + "): " + strM);
            Intrinsics3.checkNotNullExpressionValue(strM, "json");
            webSocket.a(strM);
        } catch (Exception unused) {
            j("exception sending opcode: " + i2 + " and payload: " + obj);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i2, String str) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        super.onClosed(webSocket, i2, str);
        m(new h(webSocket, i2, str));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i2, String str) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        ((RealWebSocket) webSocket).e(i2, str);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(th, "t");
        super.onFailure(webSocket, th, response);
        m(new i(webSocket, th));
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String str) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Payloads.Incoming incoming = (Payloads.Incoming) b.i.a.f.e.o.f.E1(Payloads.Incoming.class).cast(this.n.g(str, Payloads.Incoming.class));
        super.onMessage(webSocket, str);
        StringBuilder sbU = outline.U("received (");
        sbU.append(Opcodes.INSTANCE.getNameOf(incoming.getOpcode()));
        sbU.append("): ");
        sbU.append(incoming);
        h(sbU.toString());
        m(new j(webSocket, incoming));
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        Intrinsics3.checkNotNullParameter(webSocket, "webSocket");
        Intrinsics3.checkNotNullParameter(response, "response");
        super.onOpen(webSocket, response);
        m(new k(webSocket));
    }
}
