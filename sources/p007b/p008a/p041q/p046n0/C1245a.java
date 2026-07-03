package p007b.p008a.p041q.p046n0;

import androidx.annotation.AnyThread;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.socket.p499io.Opcodes;
import com.discord.rtcconnection.socket.p499io.Payloads;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.time.Clock;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
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
import p007b.p008a.p041q.ExecutorServiceC1192c;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p408d.C4901e;
import p007b.p225i.p408d.p410q.p411x.C4939a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12380x;
import p600f0.p601e0.p609k.C12333h;
import p600f0.p601e0.p613n.C12355d;

/* JADX INFO: renamed from: b.a.q.n0.a */
/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1245a extends WebSocketListener implements DebugPrintable {

    /* JADX INFO: renamed from: j */
    public static int f1763j;

    /* JADX INFO: renamed from: A */
    public Long f1766A;

    /* JADX INFO: renamed from: B */
    public c f1767B;

    /* JADX INFO: renamed from: C */
    public boolean f1768C;

    /* JADX INFO: renamed from: D */
    public final String f1769D;

    /* JADX INFO: renamed from: E */
    public final String f1770E;

    /* JADX INFO: renamed from: F */
    public final SSLSocketFactory f1771F;

    /* JADX INFO: renamed from: G */
    public final Logger f1772G;

    /* JADX INFO: renamed from: H */
    public final ExecutorServiceC1192c f1773H;

    /* JADX INFO: renamed from: I */
    public final Clock f1774I;

    /* JADX INFO: renamed from: J */
    public final String f1775J;

    /* JADX INFO: renamed from: m */
    public final String f1776m;

    /* JADX INFO: renamed from: n */
    public final Gson f1777n;

    /* JADX INFO: renamed from: o */
    public final Timer f1778o;

    /* JADX INFO: renamed from: p */
    public final Backoff f1779p;

    /* JADX INFO: renamed from: q */
    public final CopyOnWriteArraySet<d> f1780q;

    /* JADX INFO: renamed from: r */
    public int f1781r;

    /* JADX INFO: renamed from: s */
    public WebSocket f1782s;

    /* JADX INFO: renamed from: t */
    public String f1783t;

    /* JADX INFO: renamed from: u */
    public String f1784u;

    /* JADX INFO: renamed from: v */
    public Long f1785v;

    /* JADX INFO: renamed from: w */
    public boolean f1786w;

    /* JADX INFO: renamed from: x */
    public C1246b f1787x;

    /* JADX INFO: renamed from: y */
    public Long f1788y;

    /* JADX INFO: renamed from: z */
    public TimerTask f1789z;

    /* JADX INFO: renamed from: l */
    public static final b f1765l = new b(null);

    /* JADX INFO: renamed from: k */
    public static final Type f1764k = new a().getType();

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
        /* JADX INFO: renamed from: a */
        void mo267a(String str, String str2);

        /* JADX INFO: renamed from: b */
        void mo268b(boolean z2, Integer num, String str);

        /* JADX INFO: renamed from: c */
        void mo269c(String str, List<Integer> list);

        /* JADX INFO: renamed from: d */
        void mo270d(String str);

        /* JADX INFO: renamed from: e */
        void mo271e(long j, int i, int i2, List<Payloads.Stream> list);

        /* JADX INFO: renamed from: f */
        void mo272f(Map<String, Integer> map);

        /* JADX INFO: renamed from: g */
        void mo273g(long j);

        /* JADX INFO: renamed from: h */
        void mo274h();

        /* JADX INFO: renamed from: i */
        void mo275i();

        /* JADX INFO: renamed from: j */
        void mo276j(long j);

        /* JADX INFO: renamed from: k */
        void mo277k(int i, int i2, String str, List<Payloads.Stream> list);

        void onConnecting();

        void onSpeaking(long j, int i, boolean z2);
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$e */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class e extends AbstractC12240o implements Function1<WebSocket, Unit> {

        /* JADX INFO: renamed from: j */
        public static final e f1797j = new e();

        public e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            C12238m.checkNotNullParameter(webSocket2, "it");
            webSocket2.mo10349e(1000, "Force Close");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$f */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class f extends AbstractC12240o implements Function1<WebSocket, Unit> {

        /* JADX INFO: renamed from: j */
        public static final f f1798j = new f();

        public f() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            C12238m.checkNotNullParameter(webSocket2, "it");
            webSocket2.mo10349e(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "close reason");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$g */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class g extends TimerTask {

        /* JADX INFO: renamed from: b.a.q.n0.a$g$a */
        /* JADX INFO: compiled from: RtcControlSocket.kt */
        public static final class a extends AbstractC12240o implements Function0<Unit> {
            public a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                C1245a.m337a(C1245a.this, true, null, "The connection timed out. Did not receive OP_HELLO in time.");
                return Unit.f27425a;
            }
        }

        public g() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            C1245a.this.m349m(new a());
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$h */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class h extends AbstractC12240o implements Function0<Unit> {
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
            if (!(!C12238m.areEqual(this.$webSocket, C1245a.this.f1782s))) {
                C1245a.m337a(C1245a.this, true, Integer.valueOf(this.$code), this.$reason);
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$i */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class i extends AbstractC12240o implements Function0<Unit> {

        /* JADX INFO: renamed from: $t */
        public final /* synthetic */ Throwable f1800$t;
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(WebSocket webSocket, Throwable th) {
            super(0);
            this.$webSocket = webSocket;
            this.f1800$t = th;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            if (!(!C12238m.areEqual(this.$webSocket, C1245a.this.f1782s))) {
                C1245a c1245a = C1245a.this;
                StringBuilder sbM833U = C1643a.m833U("An error with the websocket occurred: ");
                sbM833U.append(this.f1800$t.getMessage());
                C1245a.m337a(c1245a, true, null, sbM833U.toString());
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$j */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class j extends AbstractC12240o implements Function0<Unit> {
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
            if (!(!C12238m.areEqual(this.$webSocket, C1245a.this.f1782s))) {
                switch (this.$message.getOpcode()) {
                    case 2:
                        C1245a c1245a = C1245a.this;
                        Object objM9199c = c1245a.f1777n.m9199c(this.$message.getData(), Payloads.Ready.class);
                        C12238m.checkNotNullExpressionValue(objM9199c, "gson.fromJson(message.da…yloads.Ready::class.java)");
                        Payloads.Ready ready = (Payloads.Ready) objM9199c;
                        c1245a.f1779p.succeed();
                        long jCurrentTimeMillis = c1245a.f1774I.currentTimeMillis();
                        Long l = c1245a.f1766A;
                        c1245a.m345i("[READY] took " + (jCurrentTimeMillis - (l != null ? l.longValue() : 0L)) + " ms");
                        c1245a.f1773H.m266a();
                        for (d dVar : c1245a.f1780q) {
                            C12238m.checkNotNullExpressionValue(dVar, "it");
                            dVar.mo277k(ready.getPort(), ready.getSsrc(), ready.getIp(), ready.getStreams());
                        }
                        break;
                    case 3:
                        C1245a c1245a2 = C1245a.this;
                        c1245a2.m350n(3, String.valueOf(c1245a2.f1774I.currentTimeMillis()));
                        break;
                    case 4:
                        C1245a c1245a3 = C1245a.this;
                        Object objM9199c2 = c1245a3.f1777n.m9199c(this.$message.getData(), Payloads.Description.class);
                        C12238m.checkNotNullExpressionValue(objM9199c2, "gson.fromJson(message.da….Description::class.java)");
                        Payloads.Description description = (Payloads.Description) objM9199c2;
                        c1245a3.f1773H.m266a();
                        for (d dVar2 : c1245a3.f1780q) {
                            C12238m.checkNotNullExpressionValue(dVar2, "it");
                            dVar2.mo269c(description.getMode(), description.getSecretKey());
                            dVar2.mo267a(description.getAudioCodec(), description.getVideoCodec());
                            String mediaSessionId = description.getMediaSessionId();
                            if (mediaSessionId != null) {
                                dVar2.mo270d(mediaSessionId);
                            }
                        }
                        c1245a3.f1768C = true;
                        break;
                    case 5:
                        C1245a c1245a4 = C1245a.this;
                        Object objM9199c3 = c1245a4.f1777n.m9199c(this.$message.getData(), Payloads.Speaking.class);
                        C12238m.checkNotNullExpressionValue(objM9199c3, "gson.fromJson(message.da…ads.Speaking::class.java)");
                        Payloads.Speaking speaking = (Payloads.Speaking) objM9199c3;
                        if (speaking.getUserId() != null && speaking.getSpeaking() != null) {
                            Integer speaking2 = speaking.getSpeaking();
                            boolean z2 = speaking2 != null && speaking2.intValue() == 1;
                            c1245a4.f1773H.m266a();
                            for (d dVar3 : c1245a4.f1780q) {
                                C12238m.checkNotNullExpressionValue(dVar3, "it");
                                dVar3.onSpeaking(speaking.getUserId().longValue(), speaking.getSsrc(), z2);
                            }
                        }
                        break;
                    case 6:
                        C1245a c1245a5 = C1245a.this;
                        Object objM9199c4 = c1245a5.f1777n.m9199c(this.$message.getData(), Long.TYPE);
                        C12238m.checkNotNullExpressionValue(objM9199c4, "gson.fromJson(message.data, Long::class.java)");
                        long jLongValue = ((Number) objM9199c4).longValue();
                        long jCurrentTimeMillis2 = c1245a5.f1774I.currentTimeMillis();
                        long j = jCurrentTimeMillis2 - jLongValue;
                        c1245a5.m344h("got heartbeat ack after " + j + " ms");
                        c1245a5.f1788y = Long.valueOf(jCurrentTimeMillis2);
                        c1245a5.f1786w = true;
                        c1245a5.f1773H.m266a();
                        for (d dVar4 : c1245a5.f1780q) {
                            C12238m.checkNotNullExpressionValue(dVar4, "it");
                            dVar4.mo273g(j);
                        }
                        break;
                    case 7:
                    case 10:
                    case 11:
                    default:
                        C1245a c1245a6 = C1245a.this;
                        StringBuilder sbM833U = C1643a.m833U("unknown opcode: ");
                        sbM833U.append(this.$message.getOpcode());
                        c1245a6.m345i(sbM833U.toString());
                        break;
                    case 8:
                        C1245a c1245a7 = C1245a.this;
                        Object objM9199c5 = c1245a7.f1777n.m9199c(this.$message.getData(), Payloads.Hello.class);
                        C12238m.checkNotNullExpressionValue(objM9199c5, "gson.fromJson(message.da…yloads.Hello::class.java)");
                        Payloads.Hello hello = (Payloads.Hello) objM9199c5;
                        TimerTask timerTask = c1245a7.f1789z;
                        if (timerTask != null) {
                            timerTask.cancel();
                        }
                        c1245a7.m345i("[HELLO] raw: " + hello);
                        c1245a7.f1785v = Long.valueOf(hello.getHeartbeatIntervalMs());
                        c1245a7.f1781r = hello.getServerVersion();
                        c1245a7.f1787x.cancel();
                        c1245a7.f1786w = true;
                        c1245a7.m347k();
                        break;
                    case 9:
                        C1245a.this.f1779p.succeed();
                        break;
                    case 12:
                        C1245a c1245a8 = C1245a.this;
                        Object objM9199c6 = c1245a8.f1777n.m9199c(this.$message.getData(), Payloads.Video.class);
                        C12238m.checkNotNullExpressionValue(objM9199c6, "gson.fromJson(message.da…yloads.Video::class.java)");
                        Payloads.Video video = (Payloads.Video) objM9199c6;
                        if (video.getUserId() != null) {
                            c1245a8.f1773H.m266a();
                            for (d dVar5 : c1245a8.f1780q) {
                                C12238m.checkNotNullExpressionValue(dVar5, "it");
                                dVar5.mo271e(video.getUserId().longValue(), video.getAudioSsrc(), video.getVideoSsrc(), video.getStreams());
                            }
                        }
                        break;
                    case 13:
                        C1245a c1245a9 = C1245a.this;
                        Object objM9199c7 = c1245a9.f1777n.m9199c(this.$message.getData(), Payloads.ClientDisconnect.class);
                        C12238m.checkNotNullExpressionValue(objM9199c7, "gson.fromJson(message.da…ntDisconnect::class.java)");
                        Payloads.ClientDisconnect clientDisconnect = (Payloads.ClientDisconnect) objM9199c7;
                        c1245a9.f1773H.m266a();
                        for (d dVar6 : c1245a9.f1780q) {
                            C12238m.checkNotNullExpressionValue(dVar6, "it");
                            dVar6.mo276j(clientDisconnect.getUserId());
                        }
                        break;
                    case 14:
                        C1245a c1245a10 = C1245a.this;
                        Object objM9199c8 = c1245a10.f1777n.m9199c(this.$message.getData(), Payloads.SessionUpdate.class);
                        C12238m.checkNotNullExpressionValue(objM9199c8, "gson.fromJson(message.da…essionUpdate::class.java)");
                        Payloads.SessionUpdate sessionUpdate = (Payloads.SessionUpdate) objM9199c8;
                        c1245a10.f1773H.m266a();
                        for (d dVar7 : c1245a10.f1780q) {
                            C12238m.checkNotNullExpressionValue(dVar7, "it");
                            String mediaSessionId2 = sessionUpdate.getMediaSessionId();
                            if (mediaSessionId2 != null) {
                                dVar7.mo270d(mediaSessionId2);
                            }
                        }
                        break;
                    case 15:
                        C1245a c1245a11 = C1245a.this;
                        Gson gson = c1245a11.f1777n;
                        JsonElement data = this.$message.getData();
                        Type type = C1245a.f1764k;
                        Objects.requireNonNull(gson);
                        Object objM9200d = data == null ? null : gson.m9200d(new C4939a(data), type);
                        C12238m.checkNotNullExpressionValue(objM9200d, "gson.fromJson(message.data, MEDIA_SINK_WANTS_TYPE)");
                        Map<String, Integer> map = (Map) objM9200d;
                        c1245a11.f1773H.m266a();
                        for (d dVar8 : c1245a11.f1780q) {
                            C12238m.checkNotNullExpressionValue(dVar8, "it");
                            dVar8.mo272f(map);
                        }
                        break;
                }
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$k */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class k extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ WebSocket $webSocket;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(WebSocket webSocket) {
            super(0);
            this.$webSocket = webSocket;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            boolean z2 = true;
            if (!(!C12238m.areEqual(this.$webSocket, C1245a.this.f1782s))) {
                C1245a c1245a = C1245a.this;
                c cVar = c1245a.f1767B;
                if (cVar == c.CONNECTING) {
                    c1245a.f1773H.m266a();
                    for (d dVar : c1245a.f1780q) {
                        C12238m.checkNotNullExpressionValue(dVar, "it");
                        dVar.mo275i();
                    }
                } else if (cVar == c.RECONNECTING) {
                    String str = c1245a.f1784u;
                    String str2 = c1245a.f1783t;
                    String str3 = c1245a.f1770E;
                    Long l = c1245a.f1788y;
                    if (l != null && c1245a.f1774I.currentTimeMillis() - l.longValue() > 60000) {
                        z2 = false;
                    }
                    if (str == null || str2 == null || !c1245a.f1768C || !z2) {
                        StringBuilder sbM833U = C1643a.m833U("Cannot resume connection. resumable: ");
                        sbM833U.append(c1245a.f1768C);
                        sbM833U.append(" -- isHeartbeatRecentEnough: ");
                        sbM833U.append(z2);
                        c1245a.m342f(false, 4801, sbM833U.toString());
                    } else {
                        c1245a.m345i("[RESUME] resuming session. serverId=" + str2 + " sessionId=" + str);
                        c1245a.f1773H.m266a();
                        for (d dVar2 : c1245a.f1780q) {
                            C12238m.checkNotNullExpressionValue(dVar2, "it");
                            dVar2.mo274h();
                        }
                        c1245a.f1767B = c.RESUMING;
                        c1245a.m350n(7, new Payloads.Resume(str3, str, str2));
                    }
                }
                C1245a c1245a2 = C1245a.this;
                c1245a2.f1767B = c.CONNECTED;
                long jCurrentTimeMillis = c1245a2.f1774I.currentTimeMillis();
                Long l2 = C1245a.this.f1766A;
                long jLongValue = jCurrentTimeMillis - (l2 != null ? l2.longValue() : 0L);
                C1245a c1245a3 = C1245a.this;
                StringBuilder sbM833U2 = C1643a.m833U("[CONNECTED] to ");
                sbM833U2.append(C1245a.this.f1769D);
                c1245a3.m345i(sbM833U2.toString());
                C1245a c1245a4 = C1245a.this;
                c1245a4.f1773H.m266a();
                for (d dVar3 : c1245a4.f1780q) {
                    C12238m.checkNotNullExpressionValue(dVar3, "it");
                    dVar3.mo273g(jLongValue / ((long) 2));
                }
            }
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: b.a.q.n0.a$l */
    /* JADX INFO: compiled from: RtcControlSocket.kt */
    public static final class l extends AbstractC12240o implements Function1<WebSocket, Unit> {

        /* JADX INFO: renamed from: j */
        public static final l f1801j = new l();

        public l() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(WebSocket webSocket) {
            WebSocket webSocket2 = webSocket;
            C12238m.checkNotNullParameter(webSocket2, "it");
            webSocket2.mo10349e(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM, "reconnecting");
            return Unit.f27425a;
        }
    }

    public C1245a(String str, String str2, SSLSocketFactory sSLSocketFactory, Logger logger, ExecutorServiceC1192c executorServiceC1192c, Clock clock, String str3) {
        C12238m.checkNotNullParameter(str, "endpoint");
        C12238m.checkNotNullParameter(str2, "token");
        C12238m.checkNotNullParameter(logger, "logger");
        C12238m.checkNotNullParameter(executorServiceC1192c, "mediaEngineThreadExecutor");
        C12238m.checkNotNullParameter(clock, "clock");
        C12238m.checkNotNullParameter(str3, "loggingTagPrefix");
        this.f1769D = str;
        this.f1770E = str2;
        this.f1771F = sSLSocketFactory;
        this.f1772G = logger;
        this.f1773H = executorServiceC1192c;
        this.f1774I = clock;
        this.f1775J = str3;
        StringBuilder sbM836X = C1643a.m836X(str3, "->RtcControlSocket ");
        int i2 = f1763j + 1;
        f1763j = i2;
        sbM836X.append(i2);
        String string = sbM836X.toString();
        this.f1776m = string;
        this.f1777n = new C4901e().m6851a();
        this.f1778o = new Timer();
        this.f1779p = new Backoff(1000L, 5000L, 3, false, new Backoff.TimerScheduler(string, executorServiceC1192c), 8, null);
        this.f1780q = new CopyOnWriteArraySet<>();
        this.f1781r = 3;
        this.f1787x = new C1246b(this);
        this.f1767B = c.DISCONNECTED;
    }

    /* JADX INFO: renamed from: a */
    public static final void m337a(C1245a c1245a, boolean z2, Integer num, String str) {
        c1245a.f1767B = c.DISCONNECTED;
        if ((num != null && num.intValue() == 4004) || ((num != null && num.intValue() == 4015) || ((num != null && num.intValue() == 4011) || (num != null && num.intValue() == 4006)))) {
            c1245a.m342f(true, num, str);
            return;
        }
        if (c1245a.f1779p.hasReachedFailureThreshold()) {
            c1245a.m346j("[WS CLOSED] Backoff exceeded. Resetting.");
            c1245a.m342f(z2, num, str);
            return;
        }
        c1245a.m338b(null);
        c1245a.m346j("`[WS CLOSED] (" + z2 + ", " + num + ", " + str + ") retrying in " + C1643a.m828P(new Object[]{Double.valueOf(c1245a.f1779p.fail(new C1247c(c1245a, z2, num, str)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
    }

    /* JADX INFO: renamed from: b */
    public final void m338b(Function1<? super WebSocket, Unit> function1) {
        this.f1779p.cancel();
        this.f1787x.cancel();
        TimerTask timerTask = this.f1789z;
        if (timerTask != null) {
            timerTask.cancel();
        }
        WebSocket webSocket = this.f1782s;
        if (webSocket != null && function1 != null) {
            function1.invoke(webSocket);
        }
        this.f1782s = (WebSocket) null;
    }

    /* JADX INFO: renamed from: c */
    public final void m339c() {
        this.f1773H.m266a();
        m345i("[CLOSE]");
        m338b(e.f1797j);
        this.f1783t = null;
        this.f1784u = null;
        this.f1768C = false;
        this.f1767B = c.DISCONNECTED;
        this.f1773H.m266a();
        for (d dVar : this.f1780q) {
            C12238m.checkNotNullExpressionValue(dVar, "it");
            dVar.mo268b(false, 1000, "Force Close");
        }
    }

    /* JADX INFO: renamed from: d */
    public final boolean m340d() {
        this.f1773H.m266a();
        if (this.f1767B != c.DISCONNECTED) {
            m346j("Cannot start a new connection, connection state is not disconnected");
            return false;
        }
        this.f1767B = c.CONNECTING;
        m341e();
        this.f1773H.m266a();
        for (d dVar : this.f1780q) {
            C12238m.checkNotNullExpressionValue(dVar, "it");
            dVar.onConnecting();
        }
        return true;
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintBuilder debugPrintBuilder) {
        C12238m.checkNotNullParameter(debugPrintBuilder, "dp");
        debugPrintBuilder.appendKeyValue("serverId", this.f1783t);
        debugPrintBuilder.appendKeyValue("sessionId", this.f1784u);
        debugPrintBuilder.appendKeyValue("heartbeatInterval", this.f1785v);
        debugPrintBuilder.appendKeyValue("lastHeartbeatAckTime", this.f1788y);
        debugPrintBuilder.appendKeyValue("connectionStartTime", this.f1766A);
        debugPrintBuilder.appendKeyValue("connectionState", this.f1767B);
        debugPrintBuilder.appendKeyValue("resumable", Boolean.valueOf(this.f1768C));
    }

    /* JADX INFO: renamed from: e */
    public final void m341e() {
        StringBuilder sbM833U = C1643a.m833U("[CONNECT] ");
        sbM833U.append(this.f1769D);
        m345i(sbM833U.toString());
        if (this.f1782s != null) {
            this.f1772G.mo8363e(this.f1776m, "Connect called with already existing websocket", null, null);
            m338b(f.f1798j);
            return;
        }
        this.f1766A = Long.valueOf(this.f1774I.currentTimeMillis());
        TimerTask timerTask = this.f1789z;
        if (timerTask != null) {
            timerTask.cancel();
        }
        g gVar = new g();
        this.f1789z = gVar;
        this.f1778o.schedule(gVar, 20000L);
        C12380x.a aVar = new C12380x.a();
        aVar.m10420a(1L, TimeUnit.MINUTES);
        SSLSocketFactory sSLSocketFactory = this.f1771F;
        if (sSLSocketFactory != null) {
            C12333h.a aVar2 = C12333h.f25785c;
            aVar.m10421b(sSLSocketFactory, C12333h.f25783a.mo10325n());
        }
        String strM822J = C1643a.m822J(new StringBuilder(), this.f1769D, "?v=5");
        m345i("attempting WSS connection with " + strM822J);
        C12380x c12380x = new C12380x(aVar);
        Request.C12935a c12935a = new Request.C12935a();
        c12935a.m10983f(strM822J);
        this.f1782s = c12380x.m10419g(c12935a.m10978a(), this);
    }

    /* JADX INFO: renamed from: f */
    public final void m342f(boolean z2, Integer num, String str) {
        m346j("[DISCONNECT] (" + z2 + ", " + num + ", " + str + ')');
        m338b(null);
        this.f1783t = null;
        this.f1784u = null;
        this.f1768C = false;
        this.f1767B = c.DISCONNECTED;
        this.f1773H.m266a();
        for (d dVar : this.f1780q) {
            C12238m.checkNotNullExpressionValue(dVar, "it");
            dVar.mo268b(z2, num, str);
        }
    }

    /* JADX INFO: renamed from: g */
    public final void m343g(long j2, String str, boolean z2) {
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.f1773H.m266a();
        if (this.f1782s != null) {
            m345i("Performing an immediate heartbeat on existing socket: " + str);
            this.f1787x.cancel();
            C1246b c1246b = new C1246b(this);
            this.f1787x = c1246b;
            this.f1778o.schedule(c1246b, j2);
            return;
        }
        if (!z2) {
            m345i("Immediate heartbeat requested, but is disconnected and a reset was not requested: " + str);
            return;
        }
        if (this.f1779p.getIsPending() && this.f1782s == null) {
            m345i("Connection backoff reset Immediate heartbeat when socket was disconnected.");
            this.f1779p.succeed();
            m348l(false, 4802, "Reset backoff.");
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m344h(String str) {
        Logger.d$default(this.f1772G, this.f1776m, str, null, 4, null);
    }

    /* JADX INFO: renamed from: i */
    public final void m345i(String str) {
        Logger.i$default(this.f1772G, this.f1776m, str, null, 4, null);
    }

    /* JADX INFO: renamed from: j */
    public final void m346j(String str) {
        Logger.w$default(this.f1772G, this.f1776m, str, null, 4, null);
    }

    /* JADX INFO: renamed from: k */
    public final void m347k() {
        if (!this.f1786w) {
            m338b(C1248d.f1803j);
            m346j("[ACK TIMEOUT] reconnecting in " + C1643a.m828P(new Object[]{Double.valueOf(this.f1779p.fail(new C1249e(this)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
            return;
        }
        this.f1786w = false;
        m350n(3, String.valueOf(this.f1774I.currentTimeMillis()));
        Long l2 = this.f1785v;
        if (l2 == null) {
            m346j("onHeartbeatInterval called when heartbeatInterval was null");
            return;
        }
        C1246b c1246b = new C1246b(this);
        this.f1787x = c1246b;
        this.f1778o.schedule(c1246b, l2.longValue());
    }

    /* JADX INFO: renamed from: l */
    public final void m348l(boolean z2, Integer num, String str) {
        m345i("[RECONNECT] wasFatal=" + z2 + " code=" + num + " reason=" + str);
        m338b(l.f1801j);
        this.f1767B = c.RECONNECTING;
        m341e();
    }

    @AnyThread
    /* JADX INFO: renamed from: m */
    public final void m349m(Function0<Unit> function0) {
        ExecutorServiceC1192c executorServiceC1192c = this.f1773H;
        Object runnableC1250f = function0;
        if (function0 != null) {
            runnableC1250f = new RunnableC1250f(function0);
        }
        executorServiceC1192c.f1609l.execute((Runnable) runnableC1250f);
    }

    /* JADX INFO: renamed from: n */
    public final void m350n(int i2, Object obj) {
        WebSocket webSocket = this.f1782s;
        if (webSocket == null) {
            StringBuilder sbM833U = C1643a.m833U("opcode() websocket null. opcode: ");
            sbM833U.append(Opcodes.INSTANCE.getNameOf(i2));
            this.f1772G.mo8363e(this.f1776m, sbM833U.toString(), null, null);
            return;
        }
        try {
            String strM9209m = this.f1777n.m9209m(new Payloads.Outgoing(i2, obj));
            m344h("sending (" + Opcodes.INSTANCE.getNameOf(i2) + "): " + strM9209m);
            C12238m.checkNotNullExpressionValue(strM9209m, "json");
            webSocket.mo10345a(strM9209m);
        } catch (Exception unused) {
            m346j("exception sending opcode: " + i2 + " and payload: " + obj);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i2, String str) {
        C12238m.checkNotNullParameter(webSocket, "webSocket");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        super.onClosed(webSocket, i2, str);
        m349m(new h(webSocket, i2, str));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i2, String str) {
        C12238m.checkNotNullParameter(webSocket, "webSocket");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        ((C12355d) webSocket).mo10349e(i2, str);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        C12238m.checkNotNullParameter(webSocket, "webSocket");
        C12238m.checkNotNullParameter(th, "t");
        super.onFailure(webSocket, th, response);
        m349m(new i(webSocket, th));
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String str) {
        C12238m.checkNotNullParameter(webSocket, "webSocket");
        C12238m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        Payloads.Incoming incoming = (Payloads.Incoming) C3404f.m4203E1(Payloads.Incoming.class).cast(this.f1777n.m9203g(str, Payloads.Incoming.class));
        super.onMessage(webSocket, str);
        StringBuilder sbM833U = C1643a.m833U("received (");
        sbM833U.append(Opcodes.INSTANCE.getNameOf(incoming.getOpcode()));
        sbM833U.append("): ");
        sbM833U.append(incoming);
        m344h(sbM833U.toString());
        m349m(new j(webSocket, incoming));
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        C12238m.checkNotNullParameter(webSocket, "webSocket");
        C12238m.checkNotNullParameter(response, "response");
        super.onOpen(webSocket, response);
        m349m(new k(webSocket));
    }
}
