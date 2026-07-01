package b.a.q.n0;

import androidx.annotation.AnyThread;
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.rtcconnection.socket.io.Opcodes;
import com.discord.rtcconnection.socket.io.Payloads$Incoming;
import com.discord.rtcconnection.socket.io.Payloads$Outgoing;
import com.discord.utilities.debug.DebugPrintBuilder;
import com.discord.utilities.debug.DebugPrintable;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.Backoff$TimerScheduler;
import com.discord.utilities.time.Clock;
import com.google.gson.Gson;
import d0.z.d.m;
import f0.e0.k.h;
import f0.e0.k.h$a;
import f0.x;
import f0.x$a;
import java.lang.reflect.Type;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Request$a;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/* JADX INFO: compiled from: RtcControlSocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends WebSocketListener implements DebugPrintable {
    public static int j;
    public Long A;
    public a$c B;
    public boolean C;
    public final String D;
    public final String E;
    public final SSLSocketFactory F;
    public final Logger G;
    public final b.a.q.c H;
    public final Clock I;
    public final String J;
    public final String m;
    public final Gson n;
    public final Timer o;
    public final Backoff p;
    public final CopyOnWriteArraySet<a$d> q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public WebSocket f275s;
    public String t;
    public String u;
    public Long v;
    public boolean w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public b f276x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Long f277y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public TimerTask f278z;
    public static final a$b l = new a$b(null);
    public static final Type k = new a$a().getType();

    public a(String str, String str2, SSLSocketFactory sSLSocketFactory, Logger logger, b.a.q.c cVar, Clock clock, String str3) {
        m.checkNotNullParameter(str, "endpoint");
        m.checkNotNullParameter(str2, "token");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(cVar, "mediaEngineThreadExecutor");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(str3, "loggingTagPrefix");
        this.D = str;
        this.E = str2;
        this.F = sSLSocketFactory;
        this.G = logger;
        this.H = cVar;
        this.I = clock;
        this.J = str3;
        StringBuilder sbX = b.d.b.a.a.X(str3, "->RtcControlSocket ");
        int i = j + 1;
        j = i;
        sbX.append(i);
        String string = sbX.toString();
        this.m = string;
        this.n = new b.i.d.e().a();
        this.o = new Timer();
        this.p = new Backoff(1000L, 5000L, 3, false, new Backoff$TimerScheduler(string, cVar), 8, null);
        this.q = new CopyOnWriteArraySet<>();
        this.r = 3;
        this.f276x = new b(this);
        this.B = a$c.DISCONNECTED;
    }

    public static final void a(a aVar, boolean z2, Integer num, String str) {
        aVar.B = a$c.DISCONNECTED;
        if ((num != null && num.intValue() == 4004) || ((num != null && num.intValue() == 4015) || ((num != null && num.intValue() == 4011) || (num != null && num.intValue() == 4006)))) {
            aVar.f(true, num, str);
            return;
        }
        if (aVar.p.hasReachedFailureThreshold()) {
            aVar.j("[WS CLOSED] Backoff exceeded. Resetting.");
            aVar.f(z2, num, str);
            return;
        }
        aVar.b(null);
        aVar.j("`[WS CLOSED] (" + z2 + ", " + num + ", " + str + ") retrying in " + b.d.b.a.a.P(new Object[]{Double.valueOf(aVar.p.fail(new c(aVar, z2, num, str)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
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
        b(a$e.j);
        this.t = null;
        this.u = null;
        this.C = false;
        this.B = a$c.DISCONNECTED;
        this.H.a();
        for (a$d a_d : this.q) {
            m.checkNotNullExpressionValue(a_d, "it");
            a_d.b(false, 1000, "Force Close");
        }
    }

    public final boolean d() {
        this.H.a();
        if (this.B != a$c.DISCONNECTED) {
            j("Cannot start a new connection, connection state is not disconnected");
            return false;
        }
        this.B = a$c.CONNECTING;
        e();
        this.H.a();
        for (a$d a_d : this.q) {
            m.checkNotNullExpressionValue(a_d, "it");
            a_d.onConnecting();
        }
        return true;
    }

    @Override // com.discord.utilities.debug.DebugPrintable
    public void debugPrint(DebugPrintBuilder debugPrintBuilder) {
        m.checkNotNullParameter(debugPrintBuilder, "dp");
        debugPrintBuilder.appendKeyValue("serverId", this.t);
        debugPrintBuilder.appendKeyValue("sessionId", this.u);
        debugPrintBuilder.appendKeyValue("heartbeatInterval", this.v);
        debugPrintBuilder.appendKeyValue("lastHeartbeatAckTime", this.f277y);
        debugPrintBuilder.appendKeyValue("connectionStartTime", this.A);
        debugPrintBuilder.appendKeyValue("connectionState", this.B);
        debugPrintBuilder.appendKeyValue("resumable", Boolean.valueOf(this.C));
    }

    public final void e() {
        StringBuilder sbU = b.d.b.a.a.U("[CONNECT] ");
        sbU.append(this.D);
        i(sbU.toString());
        if (this.f275s != null) {
            this.G.e(this.m, "Connect called with already existing websocket", null, null);
            b(a$f.j);
            return;
        }
        this.A = Long.valueOf(this.I.currentTimeMillis());
        TimerTask timerTask = this.f278z;
        if (timerTask != null) {
            timerTask.cancel();
        }
        a$g a_g = new a$g(this);
        this.f278z = a_g;
        this.o.schedule(a_g, 20000L);
        x$a x_a = new x$a();
        x_a.a(1L, TimeUnit.MINUTES);
        SSLSocketFactory sSLSocketFactory = this.F;
        if (sSLSocketFactory != null) {
            h$a h_a = h.c;
            x_a.b(sSLSocketFactory, h.a.n());
        }
        String strJ = b.d.b.a.a.J(new StringBuilder(), this.D, "?v=5");
        i("attempting WSS connection with " + strJ);
        x xVar = new x(x_a);
        Request$a request$a = new Request$a();
        request$a.f(strJ);
        this.f275s = xVar.g(request$a.a(), this);
    }

    public final void f(boolean z2, Integer num, String str) {
        j("[DISCONNECT] (" + z2 + ", " + num + ", " + str + ')');
        b(null);
        this.t = null;
        this.u = null;
        this.C = false;
        this.B = a$c.DISCONNECTED;
        this.H.a();
        for (a$d a_d : this.q) {
            m.checkNotNullExpressionValue(a_d, "it");
            a_d.b(z2, num, str);
        }
    }

    public final void g(long j2, String str, boolean z2) {
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.H.a();
        if (this.f275s != null) {
            i("Performing an immediate heartbeat on existing socket: " + str);
            this.f276x.cancel();
            b bVar = new b(this);
            this.f276x = bVar;
            this.o.schedule(bVar, j2);
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
            b(d.j);
            j("[ACK TIMEOUT] reconnecting in " + b.d.b.a.a.P(new Object[]{Double.valueOf(this.p.fail(new e(this)) / 1000.0d)}, 1, "%.2f", "java.lang.String.format(this, *args)") + " seconds.");
            return;
        }
        this.w = false;
        n(3, String.valueOf(this.I.currentTimeMillis()));
        Long l2 = this.v;
        if (l2 == null) {
            j("onHeartbeatInterval called when heartbeatInterval was null");
            return;
        }
        b bVar = new b(this);
        this.f276x = bVar;
        this.o.schedule(bVar, l2.longValue());
    }

    public final void l(boolean z2, Integer num, String str) {
        i("[RECONNECT] wasFatal=" + z2 + " code=" + num + " reason=" + str);
        b(a$l.j);
        this.B = a$c.RECONNECTING;
        e();
    }

    @AnyThread
    public final void m(Function0<Unit> function0) {
        b.a.q.c cVar = this.H;
        Object fVar = function0;
        if (function0 != null) {
            fVar = new f(function0);
        }
        cVar.l.execute((Runnable) fVar);
    }

    public final void n(int i, Object obj) {
        WebSocket webSocket = this.f275s;
        if (webSocket == null) {
            StringBuilder sbU = b.d.b.a.a.U("opcode() websocket null. opcode: ");
            sbU.append(Opcodes.INSTANCE.getNameOf(i));
            this.G.e(this.m, sbU.toString(), null, null);
            return;
        }
        try {
            String strM = this.n.m(new Payloads$Outgoing(i, obj));
            h("sending (" + Opcodes.INSTANCE.getNameOf(i) + "): " + strM);
            m.checkNotNullExpressionValue(strM, "json");
            webSocket.a(strM);
        } catch (Exception unused) {
            j("exception sending opcode: " + i + " and payload: " + obj);
        }
    }

    @Override // okhttp3.WebSocketListener
    public void onClosed(WebSocket webSocket, int i, String str) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        super.onClosed(webSocket, i, str);
        m(new a$h(this, webSocket, i, str));
    }

    @Override // okhttp3.WebSocketListener
    public void onClosing(WebSocket webSocket, int i, String str) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
        ((f0.e0.n.d) webSocket).e(i, str);
    }

    @Override // okhttp3.WebSocketListener
    public void onFailure(WebSocket webSocket, Throwable th, Response response) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(th, "t");
        super.onFailure(webSocket, th, response);
        m(new a$i(this, webSocket, th));
    }

    @Override // okhttp3.WebSocketListener
    public void onMessage(WebSocket webSocket, String str) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        Payloads$Incoming payloads$Incoming = (Payloads$Incoming) b.i.a.f.e.o.f.E1(Payloads$Incoming.class).cast(this.n.g(str, Payloads$Incoming.class));
        super.onMessage(webSocket, str);
        StringBuilder sbU = b.d.b.a.a.U("received (");
        sbU.append(Opcodes.INSTANCE.getNameOf(payloads$Incoming.getOpcode()));
        sbU.append("): ");
        sbU.append(payloads$Incoming);
        h(sbU.toString());
        m(new a$j(this, webSocket, payloads$Incoming));
    }

    @Override // okhttp3.WebSocketListener
    public void onOpen(WebSocket webSocket, Response response) {
        m.checkNotNullParameter(webSocket, "webSocket");
        m.checkNotNullParameter(response, "response");
        super.onOpen(webSocket, response);
        m(new a$k(this, webSocket));
    }
}
