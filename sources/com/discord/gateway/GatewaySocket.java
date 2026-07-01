package com.discord.gateway;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import b.i.d.c;
import b.i.d.e;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityType;
import com.discord.api.activity.ActivityTypeTypeAdapter;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.gateway.io.Incoming;
import com.discord.gateway.io.IncomingParser;
import com.discord.gateway.io.Outgoing;
import com.discord.gateway.io.OutgoingPayload$ApplicationCommandRequest;
import com.discord.gateway.io.OutgoingPayload$CreateStream;
import com.discord.gateway.io.OutgoingPayload$ForumUnreadsRequest;
import com.discord.gateway.io.OutgoingPayload$GuildSubscriptions;
import com.discord.gateway.io.OutgoingPayload$GuildSubscriptionsUpdate;
import com.discord.gateway.io.OutgoingPayload$Identify;
import com.discord.gateway.io.OutgoingPayload$Resume;
import com.discord.gateway.opcodes.Opcode;
import com.discord.gateway.rest.RestClient;
import com.discord.gateway.rest.RestConfig;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelPayload$Hello;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollectionSubject;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.websocket.WebSocket;
import com.discord.utilities.websocket.WebSocket$Closed;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import d0.g0.t;
import d0.o;
import d0.t.h0;
import d0.t.n0;
import d0.t.u;
import d0.z.d.e0;
import d0.z.d.m;
import j0.l.a.r;
import j0.l.a.v1;
import j0.l.a.w1;
import j0.l.e.k;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;

/* JADX INFO: compiled from: GatewaySocket.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GatewaySocket {
    private static final long AUTH_TOKEN_REFRESH = 256;
    private static final long CLIENT_CAPABILITIES = 351;
    private static final int CLOSE_CODE_CLEAN = 1000;
    private static final int CLOSE_CODE_DIRTY = 4000;
    private static final int CLOSE_CODE_UNAUTHORIZED = 4004;
    private static final boolean COMPRESS_DATA = true;
    private static final int CONNECTED = 5;
    private static final int CONNECTING = 2;
    public static final GatewaySocket$Companion Companion = new GatewaySocket$Companion(null);
    private static final long DEDUPE_USER_OBJECTS = 16;
    private static final int DISCONNECTED = 0;
    private static final int DISCOVERING = 1;
    private static final Set<String> EXPECTED_NULL_DATA_EVENTS;
    private static final String GATEWAY_COMPRESSION = "zlib-stream";
    private static final String GATEWAY_ENCODING = "json";
    private static final int GATEWAY_URL_RESET_THRESHOLD = 4;
    private static final int GATEWAY_VERSION = 9;
    private static final int HEARTBEAT_MAX_RESUME_THRESHOLD = 180000;
    private static final long HELLO_TIMEOUT = 20000;
    private static final int IDENTIFYING = 3;
    private static final int LARGE_GUILD_THRESHOLD = 100;
    private static final long LAZY_USER_NOTES = 1;
    private static final long MULTIPLE_GUILD_EXPERIMENT_POPULATIONS = 64;
    private static final long NO_AFFINE_USER_IDS = 2;
    private static final int RESUMING = 4;
    private static final long VERSIONED_READ_STATES = 4;
    private static final long VERSIONED_USER_GUILD_SETTINGS = 8;
    private static final Clock clock;
    private static final Gson gsonIncludeNulls;
    private static final Gson gsonOmitNulls;
    private boolean connected;
    private boolean connectionReady;
    private long connectionStartTime;
    private int connectionState;
    private final GatewayEventHandler eventHandler;
    private final Backoff gatewayBackoff;
    private final GatewayDiscovery gatewayDiscovery;
    private final GatewaySocketLogger gatewaySocketLogger;
    private final Function1<String, String> gatewayUrlTransform;
    private boolean hasConnectedOnce;
    private boolean heartbeatAck;
    private long heartbeatAckTimeMostRecent;
    private GatewaySocket$Timer heartbeatExpeditedTimeout;
    private long heartbeatInterval;
    private GatewaySocket$Timer heartbeater;
    private GatewaySocket$Timer helloTimeout;
    private final Function0<GatewaySocket$IdentifyData> identifyDataProvider;
    private final Map<String, Object> identifyProperties;
    private long identifyStartTime;
    private final ListenerCollectionSubject<GatewaySocket$Listener> listenerSubject;
    private final ListenerCollection<GatewaySocket$Listener> listeners;
    private final Logger logger;
    private boolean nextReconnectIsImmediate;
    private int replayedEvents;
    private final Scheduler scheduler;
    private int seq;
    private String sessionId;
    private final SSLSocketFactory sslSocketFactory;
    private String token;
    private final Function1<Map<String, ? extends Object>, Unit> trackReadyPayload;
    private WebSocket webSocket;

    static {
        e eVar = new e();
        eVar.g = true;
        c cVar = c.m;
        eVar.c = cVar;
        eVar.b(ActivityType.class, new ActivityTypeTypeAdapter());
        gsonIncludeNulls = eVar.a();
        e eVar2 = new e();
        eVar2.c = cVar;
        gsonOmitNulls = eVar2.a();
        EXPECTED_NULL_DATA_EVENTS = n0.setOf((Object[]) new String[]{"USER_SUBSCRIPTIONS_UPDATE", "USER_PAYMENT_SOURCES_UPDATE"});
        clock = ClockFactory.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GatewaySocket(Function0<GatewaySocket$IdentifyData> function0, Function1<? super Map<String, ? extends Object>, Unit> function1, GatewayEventHandler gatewayEventHandler, Scheduler scheduler, Logger logger, NetworkMonitor networkMonitor, RestConfig restConfig, Context context, Function1<? super String, String> function2, SSLSocketFactory sSLSocketFactory, Map<String, ? extends Object> map, GatewaySocketLogger gatewaySocketLogger) {
        m.checkNotNullParameter(function0, "identifyDataProvider");
        m.checkNotNullParameter(function1, "trackReadyPayload");
        m.checkNotNullParameter(gatewayEventHandler, "eventHandler");
        m.checkNotNullParameter(scheduler, "scheduler");
        m.checkNotNullParameter(logger, "logger");
        m.checkNotNullParameter(networkMonitor, "networkMonitor");
        m.checkNotNullParameter(restConfig, "restConfig");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(map, "identifyProperties");
        m.checkNotNullParameter(gatewaySocketLogger, "gatewaySocketLogger");
        this.identifyDataProvider = function0;
        this.trackReadyPayload = function1;
        this.eventHandler = gatewayEventHandler;
        this.scheduler = scheduler;
        this.logger = logger;
        this.gatewayUrlTransform = function2;
        this.sslSocketFactory = sSLSocketFactory;
        this.identifyProperties = map;
        this.gatewaySocketLogger = gatewaySocketLogger;
        Backoff backoff = new Backoff(1000L, 10000L, 4, true, new GatewaySocket$Timer(scheduler));
        this.gatewayBackoff = backoff;
        this.heartbeatExpeditedTimeout = new GatewaySocket$Timer(scheduler);
        this.heartbeatInterval = RecyclerView.FOREVER_NS;
        this.heartbeater = new GatewaySocket$Timer(scheduler);
        this.heartbeatAck = true;
        this.helloTimeout = new GatewaySocket$Timer(scheduler);
        ListenerCollectionSubject<GatewaySocket$Listener> listenerCollectionSubject = new ListenerCollectionSubject<>();
        this.listenerSubject = listenerCollectionSubject;
        this.listeners = listenerCollectionSubject;
        RestClient restClient = RestClient.INSTANCE;
        restClient.init(restConfig, context);
        this.gatewayDiscovery = new GatewayDiscovery(context, scheduler, backoff, new GatewaySocket$1(this), restClient.getGateway());
        Observable<Boolean> observableJ = networkMonitor.observeIsConnected().J(scheduler);
        Observable.h0(new r(observableJ.j, new w1(new v1(GatewaySocket$2.INSTANCE)))).W(new GatewaySocket$3(this), new GatewaySocket$4(this));
    }

    public static final /* synthetic */ void access$cleanup(GatewaySocket gatewaySocket, Function1 function1) {
        gatewaySocket.cleanup(function1);
    }

    public static final /* synthetic */ void access$connect(GatewaySocket gatewaySocket, String str) {
        gatewaySocket.connect(str);
    }

    public static final /* synthetic */ void access$discover(GatewaySocket gatewaySocket) {
        gatewaySocket.discover();
    }

    public static final /* synthetic */ void access$discoveryFailed(GatewaySocket gatewaySocket) {
        gatewaySocket.discoveryFailed();
    }

    public static final /* synthetic */ long access$getConnectionStartTime$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.connectionStartTime;
    }

    public static final /* synthetic */ int access$getConnectionState$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.connectionState;
    }

    public static final /* synthetic */ Backoff access$getGatewayBackoff$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.gatewayBackoff;
    }

    public static final /* synthetic */ GatewaySocketLogger access$getGatewaySocketLogger$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.gatewaySocketLogger;
    }

    public static final /* synthetic */ Function1 access$getGatewayUrlTransform$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.gatewayUrlTransform;
    }

    public static final /* synthetic */ Gson access$getGsonOmitNulls$cp() {
        return gsonOmitNulls;
    }

    public static final /* synthetic */ boolean access$getHeartbeatAck$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.heartbeatAck;
    }

    public static final /* synthetic */ GatewaySocket$Timer access$getHeartbeatExpeditedTimeout$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.heartbeatExpeditedTimeout;
    }

    public static final /* synthetic */ Logger access$getLogger$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.logger;
    }

    public static final /* synthetic */ boolean access$getNextReconnectIsImmediate$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.nextReconnectIsImmediate;
    }

    public static final /* synthetic */ int access$getSeq$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.seq;
    }

    public static final /* synthetic */ WebSocket access$getWebSocket$p(GatewaySocket gatewaySocket) {
        return gatewaySocket.webSocket;
    }

    public static final /* synthetic */ void access$handleClose(GatewaySocket gatewaySocket, boolean z2, int i, String str) {
        gatewaySocket.handleClose(z2, i, str);
    }

    public static final /* synthetic */ void access$handleDeviceConnectivityChange(GatewaySocket gatewaySocket, boolean z2) {
        gatewaySocket.handleDeviceConnectivityChange(z2);
    }

    public static final /* synthetic */ void access$handleHeartbeatTimeout(GatewaySocket gatewaySocket) {
        gatewaySocket.handleHeartbeatTimeout();
    }

    public static final /* synthetic */ void access$handleWebSocketClose(GatewaySocket gatewaySocket, WebSocket$Closed webSocket$Closed) {
        gatewaySocket.handleWebSocketClose(webSocket$Closed);
    }

    public static final /* synthetic */ void access$handleWebSocketError(GatewaySocket gatewaySocket) {
        gatewaySocket.handleWebSocketError();
    }

    public static final /* synthetic */ void access$handleWebSocketMessage(GatewaySocket gatewaySocket, InputStreamReader inputStreamReader, int i) {
        gatewaySocket.handleWebSocketMessage(inputStreamReader, i);
    }

    public static final /* synthetic */ void access$handleWebSocketOpened(GatewaySocket gatewaySocket, String str) {
        gatewaySocket.handleWebSocketOpened(str);
    }

    public static final /* synthetic */ void access$heartbeat(GatewaySocket gatewaySocket, int i) {
        gatewaySocket.heartbeat(i);
    }

    public static final /* synthetic */ void access$logError(GatewaySocket gatewaySocket, String str, Exception exc, Map map) {
        gatewaySocket.logError(str, exc, map);
    }

    public static final /* synthetic */ void access$reset(GatewaySocket gatewaySocket, boolean z2, int i, String str) {
        gatewaySocket.reset(z2, i, str);
    }

    public static final /* synthetic */ void access$setConnectionStartTime$p(GatewaySocket gatewaySocket, long j) {
        gatewaySocket.connectionStartTime = j;
    }

    public static final /* synthetic */ void access$setConnectionState$p(GatewaySocket gatewaySocket, int i) {
        gatewaySocket.connectionState = i;
    }

    public static final /* synthetic */ void access$setHeartbeatAck$p(GatewaySocket gatewaySocket, boolean z2) {
        gatewaySocket.heartbeatAck = z2;
    }

    public static final /* synthetic */ void access$setHeartbeatExpeditedTimeout$p(GatewaySocket gatewaySocket, GatewaySocket$Timer gatewaySocket$Timer) {
        gatewaySocket.heartbeatExpeditedTimeout = gatewaySocket$Timer;
    }

    public static final /* synthetic */ void access$setNextReconnectIsImmediate$p(GatewaySocket gatewaySocket, boolean z2) {
        gatewaySocket.nextReconnectIsImmediate = z2;
    }

    public static final /* synthetic */ void access$setSeq$p(GatewaySocket gatewaySocket, int i) {
        gatewaySocket.seq = i;
    }

    public static final /* synthetic */ void access$setWebSocket$p(GatewaySocket gatewaySocket, WebSocket webSocket) {
        gatewaySocket.webSocket = webSocket;
    }

    private final void cleanup(Function1<? super WebSocket, Unit> callback) {
        stopHeartbeater();
        clearHelloTimeout();
        if (callback != null) {
            callback.invoke(this.webSocket);
        }
        WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            webSocket.resetListeners();
        }
        this.webSocket = null;
        this.gatewayBackoff.cancel();
    }

    private final void clearHelloTimeout() {
        this.helloTimeout.cancel();
    }

    public static /* synthetic */ void close$default(GatewaySocket gatewaySocket, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        gatewaySocket.close(z2);
    }

    private final void discover() {
        this.nextReconnectIsImmediate = false;
        if (this.connectionState != 1) {
            return;
        }
        this.listenerSubject.notify(new GatewaySocket$discover$1(this));
        this.gatewayDiscovery.discoverGatewayUrl(new GatewaySocket$discover$2(this), new GatewaySocket$discover$3(this));
    }

    private final void discoveryFailed() {
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$discoveryFailed$delay$1(this));
        GatewaySocket$Companion.log$default(Companion, this.logger, "Discovery failed, retrying in " + jFail + "ms.", false, 2, null);
        if (this.gatewayBackoff.hasReachedFailureThreshold()) {
            reset(false, 0, "Gateway discovery failed.");
        }
    }

    private final void doIdentify() {
        this.seq = 0;
        this.sessionId = null;
        GatewaySocket$IdentifyData gatewaySocket$IdentifyDataInvoke = this.identifyDataProvider.invoke();
        if (gatewaySocket$IdentifyDataInvoke == null) {
            handleClose(true, CLOSE_CODE_UNAUTHORIZED, "No connection info provided.");
            return;
        }
        this.connectionState = 3;
        this.identifyStartTime = clock.currentTimeMillis();
        this.token = gatewaySocket$IdentifyDataInvoke.getToken();
        GatewaySocket$Companion.log$default(Companion, this.logger, "Sending identify.", false, 2, null);
        send$default(this, new Outgoing(Opcode.IDENTIFY, new OutgoingPayload$Identify(gatewaySocket$IdentifyDataInvoke.getToken(), 100, true, CLIENT_CAPABILITIES, this.identifyProperties, gatewaySocket$IdentifyDataInvoke.getClientState())), false, null, 4, null);
    }

    private final void doResume() {
        this.connectionState = 4;
        this.replayedEvents = 0;
        GatewaySocket$Companion gatewaySocket$Companion = Companion;
        Logger logger = this.logger;
        StringBuilder sbU = a.U("Resuming session ");
        String str = this.sessionId;
        if (str == null) {
            str = "";
        }
        sbU.append(str);
        sbU.append(" at sequence: ");
        GatewaySocket$Companion.log$default(gatewaySocket$Companion, logger, a.A(sbU, this.seq, '.'), false, 2, null);
        send$default(this, new Outgoing(Opcode.RESUME, new OutgoingPayload$Resume(this.token, this.sessionId, this.seq)), false, null, 4, null);
    }

    private final void doResumeOrIdentify() {
        GatewaySocket$Companion gatewaySocket$Companion = Companion;
        long delay$default = GatewaySocket$Companion.getDelay$default(gatewaySocket$Companion, this.heartbeatAckTimeMostRecent, null, 2, null);
        float f = this.heartbeatAckTimeMostRecent == 0 ? 0.0f : (delay$default / 1000.0f) / 60.0f;
        if (this.sessionId != null && delay$default <= ((long) HEARTBEAT_MAX_RESUME_THRESHOLD)) {
            Logger logger = this.logger;
            StringBuilder sbU = a.U("Attempting to resume after elapsed duration of ");
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
            m.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
            sbU.append(str);
            sbU.append(" minutes.");
            GatewaySocket$Companion.log$default(gatewaySocket$Companion, logger, sbU.toString(), false, 2, null);
            doResume();
        } else {
            handleInvalidSession(false);
        }
        this.heartbeatAckTimeMostRecent = clock.currentTimeMillis();
    }

    public static /* synthetic */ void expeditedHeartbeat$default(GatewaySocket gatewaySocket, long j, String str, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            z2 = true;
        }
        gatewaySocket.expeditedHeartbeat(j, str, z2);
    }

    private final void flattenTraces(Object trace, ArrayList<Pair<String, Integer>> result) {
        if (trace == null) {
            return;
        }
        try {
            if (!e0.isMutableList(trace)) {
                return;
            }
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= ((List) trace).size()) {
                    return;
                }
                Object obj = ((List) trace).get(i);
                Number number = null;
                Object obj2 = null;
                if (!(obj instanceof String)) {
                    obj = null;
                }
                String str = (String) obj;
                Object obj3 = ((List) trace).get(i2);
                if (!e0.isMutableMap(obj3)) {
                    obj3 = null;
                }
                Map map = (Map) obj3;
                i += 2;
                if (str != null && map != null) {
                    if (map.containsKey("micros")) {
                        Object obj4 = map.get("micros");
                        if (obj4 instanceof Number) {
                            obj2 = obj4;
                        }
                        number = (Number) obj2;
                    }
                    if (number != null) {
                        result.add(new Pair<>(str, Integer.valueOf(number.intValue() / 1000)));
                    }
                    flattenTraces(map.get("calls"), result);
                }
            }
        } catch (Exception e) {
            Logger.e$default(this.logger, "Unable to parse ready payload traces", e, null, 4, null);
        }
    }

    private final String getConnectionPath(ModelPayload$Hello modelPayload$Hello) {
        String strJoinToString$default;
        List<String> trace = modelPayload$Hello.getTrace();
        return (trace == null || (strJoinToString$default = u.joinToString$default(trace, " -> ", null, null, 0, null, null, 62, null)) == null) ? "???" : strJoinToString$default;
    }

    private final void handleClose(boolean wasClean, int code, String reason) {
        cleanup(GatewaySocket$handleClose$1.INSTANCE);
        handleConnected$default(this, null, Boolean.FALSE, 1, null);
        if (code == CLOSE_CODE_UNAUTHORIZED) {
            this.connectionState = 0;
            reset(wasClean, code, reason);
            return;
        }
        this.connectionState = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("Closed cleanly: ");
        sb.append(wasClean);
        sb.append(", with code: ");
        sb.append(code);
        sb.append(", for reason: '");
        String strJ = a.J(sb, reason, "'.");
        if (this.nextReconnectIsImmediate) {
            GatewaySocket$Companion.log$default(Companion, this.logger, a.w(strJ, " Retrying immediately."), false, 2, null);
            discover();
            return;
        }
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleClose$delay$1(this));
        GatewaySocket$Companion.log$default(Companion, this.logger, strJ + " Retrying in: " + jFail + "ms.", false, 2, null);
        if (this.gatewayBackoff.hasReachedFailureThreshold()) {
            reset(wasClean, code, reason);
        }
    }

    private final void handleConnected(Boolean connected, Boolean connectionReady) {
        if (connected != null) {
            boolean zBooleanValue = connected.booleanValue();
            this.connected = zBooleanValue;
            this.hasConnectedOnce = this.hasConnectedOnce || zBooleanValue;
            this.eventHandler.handleConnected(zBooleanValue);
        }
        if (connectionReady != null) {
            boolean zBooleanValue2 = connectionReady.booleanValue();
            this.connectionReady = zBooleanValue2;
            this.eventHandler.handleConnectionReady(zBooleanValue2);
        }
    }

    public static /* synthetic */ void handleConnected$default(GatewaySocket gatewaySocket, Boolean bool, Boolean bool2, int i, Object obj) {
        if ((i & 1) != 0) {
            bool = null;
        }
        if ((i & 2) != 0) {
            bool2 = null;
        }
        gatewaySocket.handleConnected(bool, bool2);
    }

    private final void handleDeviceConnectivityChange(boolean isConnected) {
        if (isConnected) {
            expeditedHeartbeat$default(this, 4500L, "network detected online", false, 4, null);
        } else {
            expeditedHeartbeat$default(this, 9000L, "network detected offline", false, 4, null);
        }
    }

    private final void handleDispatch(Object data, String type, int compressedByteSize, int uncompressedByteSize, long unpackDurationMs) {
        if (this.connectionState == 4) {
            this.replayedEvents++;
        }
        if (m.areEqual(type, "READY") || m.areEqual(type, "RESUMED")) {
            if (type != null) {
                int iHashCode = type.hashCode();
                if (iHashCode != 77848963) {
                    if (iHashCode == 1815529911 && type.equals("RESUMED")) {
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sbU = a.U("Resumed session, took ");
                        GatewaySocket$Companion gatewaySocket$Companion = Companion;
                        sbU.append(GatewaySocket$Companion.getDelay$default(gatewaySocket$Companion, this.connectionStartTime, null, 2, null));
                        sbU.append("ms, ");
                        sb.append(sbU.toString());
                        sb.append("replayed " + this.replayedEvents + " events, new seq: " + this.seq + '.');
                        String string = sb.toString();
                        m.checkNotNullExpressionValue(string, "StringBuilder()\n        …              .toString()");
                        GatewaySocket$Companion.log$default(gatewaySocket$Companion, this.logger, string, false, 2, null);
                        this.replayedEvents = 0;
                    }
                } else if (type.equals("READY")) {
                    ModelPayload modelPayload = (ModelPayload) data;
                    if (modelPayload == null) {
                        handleReconnect$default(this, "Reconnect due to invalid ready payload received.", false, 2, null);
                        return;
                    }
                    this.sessionId = modelPayload.getSessionId();
                    trackReadyPayload(modelPayload, compressedByteSize, uncompressedByteSize, unpackDurationMs);
                    GatewaySocket$Companion gatewaySocket$Companion2 = Companion;
                    Logger logger = this.logger;
                    StringBuilder sbU2 = a.U("Ready with session id: ");
                    sbU2.append(this.sessionId);
                    sbU2.append(", took ");
                    GatewaySocket$Companion.log$default(gatewaySocket$Companion2, logger, a.C(sbU2, GatewaySocket$Companion.getDelay$default(gatewaySocket$Companion2, this.connectionStartTime, null, 2, null), "ms"), false, 2, null);
                }
            }
            this.gatewayBackoff.succeed();
            this.connectionState = 5;
            Boolean bool = Boolean.TRUE;
            handleConnected(bool, bool);
        }
        if (data != null) {
            this.eventHandler.handleDispatch(type, data);
            return;
        }
        if (u.contains(EXPECTED_NULL_DATA_EVENTS, type)) {
            this.eventHandler.handleDispatch(type, Unit.a);
        } else if ((!m.areEqual(type, "READY")) && (!m.areEqual(type, "RESUMED"))) {
            Logger.w$default(this.logger, a.y("handleDispatch() ", type, " is unhandled!"), null, 2, null);
        }
    }

    private final void handleHeartbeat() {
        heartbeat(this.seq);
    }

    private final void handleHeartbeatAck() {
        GatewaySocket$Companion.access$log(Companion, this.logger, "Received heartbeat ACK.", false);
        this.heartbeatAckTimeMostRecent = clock.currentTimeMillis();
        this.heartbeatAck = true;
        this.heartbeatExpeditedTimeout.cancel(new GatewaySocket$handleHeartbeatAck$1(this));
    }

    private final void handleHeartbeatTimeout() {
        cleanup(GatewaySocket$handleHeartbeatTimeout$1.INSTANCE);
        this.connectionState = 1;
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleHeartbeatTimeout$delay$1(this));
        GatewaySocket$Companion.log$default(Companion, this.logger, "Ack timeout, reconnecting om " + jFail + "ms.", false, 2, null);
    }

    private final void handleHello(ModelPayload$Hello data) {
        this.listenerSubject.notify(new GatewaySocket$handleHello$1(this));
        clearHelloTimeout();
        this.heartbeatInterval = data.getHeartbeatInterval();
        GatewaySocket$Companion gatewaySocket$Companion = Companion;
        Logger logger = this.logger;
        StringBuilder sbU = a.U("Hello via ");
        sbU.append(getConnectionPath(data));
        sbU.append(", at interval ");
        sbU.append(this.heartbeatInterval);
        sbU.append(" took ");
        GatewaySocket$Companion.log$default(gatewaySocket$Companion, logger, a.C(sbU, GatewaySocket$Companion.getDelay$default(gatewaySocket$Companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        startHeartbeater();
    }

    private final void handleInvalidSession(boolean canResume) {
        GatewaySocket$Companion.log$default(Companion, this.logger, a.J(a.U("Invalid session, is "), canResume ? "" : "not", " resumable."), false, 2, null);
        if (canResume) {
            doResumeOrIdentify();
            return;
        }
        Boolean bool = Boolean.FALSE;
        handleConnected(bool, bool);
        doIdentify();
    }

    private final void handleReconnect(String reason, boolean resetSession) {
        cleanup(new GatewaySocket$handleReconnect$1(reason));
        reset(!resetSession, resetSession ? 1000 : 4000, reason);
        handleClose(!resetSession, 0, reason);
    }

    public static /* synthetic */ void handleReconnect$default(GatewaySocket gatewaySocket, String str, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "Reconnect to gateway requested.";
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        gatewaySocket.handleReconnect(str, z2);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0013  */
    private final void handleWebSocketClose(WebSocket$Closed closed) {
        String reason = closed.getReason();
        if (reason == null) {
            reason = "unspecified reason";
        } else {
            if (!(reason.length() > 0)) {
                reason = "unspecified reason";
            }
        }
        this.listenerSubject.notify(new GatewaySocket$handleWebSocketClose$1(this));
        handleClose(true, closed.getCode(), reason);
    }

    private final void handleWebSocketError() {
        handleClose(false, 0, "An error with the web socket occurred.");
    }

    private final void handleWebSocketMessage(InputStreamReader reader, int compressedByteSize) {
        long jCurrentTimeMillis = clock.currentTimeMillis();
        GatewaySocket$SizeRecordingInputStreamReader gatewaySocket$SizeRecordingInputStreamReader = new GatewaySocket$SizeRecordingInputStreamReader(reader, 0, 2, null);
        Incoming incomingBuild = ((IncomingParser) new Model$JsonReader(new JsonReader(gatewaySocket$SizeRecordingInputStreamReader)).parse(new IncomingParser(new GatewaySocket$handleWebSocketMessage$incomingParser$1(this)))).build();
        Integer seq = incomingBuild.getSeq();
        GatewaySocket$Companion gatewaySocket$Companion = Companion;
        long delay$default = GatewaySocket$Companion.getDelay$default(gatewaySocket$Companion, jCurrentTimeMillis, null, 2, null);
        if (seq != null) {
            this.seq = seq.intValue();
        }
        int iOrdinal = incomingBuild.getOpcode().ordinal();
        if (iOrdinal == 1) {
            handleDispatch(incomingBuild.getData(), incomingBuild.getType(), compressedByteSize, gatewaySocket$SizeRecordingInputStreamReader.getSize(), delay$default);
        }
        if (iOrdinal == 2) {
            handleHeartbeat();
            return;
        }
        if (iOrdinal == 8) {
            handleReconnect$default(this, null, false, 1, null);
            return;
        }
        switch (iOrdinal) {
            case 10:
                Object data = incomingBuild.getData();
                Objects.requireNonNull(data, "null cannot be cast to non-null type kotlin.Boolean");
                handleInvalidSession(((Boolean) data).booleanValue());
                break;
            case 11:
                Object data2 = incomingBuild.getData();
                Objects.requireNonNull(data2, "null cannot be cast to non-null type com.discord.models.domain.ModelPayload.Hello");
                handleHello((ModelPayload$Hello) data2);
                break;
            case 12:
                handleHeartbeatAck();
                break;
            default:
                Logger logger = this.logger;
                StringBuilder sbU = a.U("Unhandled op code ");
                sbU.append(incomingBuild.getOpcode());
                sbU.append('.');
                GatewaySocket$Companion.log$default(gatewaySocket$Companion, logger, sbU.toString(), false, 2, null);
                break;
        }
    }

    private final void handleWebSocketOpened(String gatewayUrl) {
        GatewaySocket$Companion gatewaySocket$Companion = Companion;
        GatewaySocket$Companion.log$default(gatewaySocket$Companion, this.logger, a.C(a.Y("Connected to ", gatewayUrl, " in "), GatewaySocket$Companion.getDelay$default(gatewaySocket$Companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        this.listenerSubject.notify(new GatewaySocket$handleWebSocketOpened$1(this));
        doResumeOrIdentify();
    }

    private final void heartbeat(int seq) {
        GatewaySocket$Companion.access$log(Companion, this.logger, "Sending heartbeat at sequence: " + seq + '.', false);
        send$default(this, new Outgoing(Opcode.HEARTBEAT, Integer.valueOf(seq)), false, null, 4, null);
    }

    private final void logError(String message, Exception exception, Map<String, String> metadata) {
        Logger logger = this.logger;
        if (metadata == null) {
            metadata = h0.emptyMap();
        }
        logger.e(message, exception, metadata);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void presenceUpdate$default(GatewaySocket gatewaySocket, ClientStatus clientStatus, Long l, List list, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            l = Long.valueOf(clock.currentTimeMillis());
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            bool = Boolean.FALSE;
        }
        gatewaySocket.presenceUpdate(clientStatus, l, list, bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void requestGuildMembers$default(GatewaySocket gatewaySocket, List list, String str, List list2, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            list2 = null;
        }
        if ((i & 8) != 0) {
            num = null;
        }
        gatewaySocket.requestGuildMembers(list, str, list2, num);
    }

    private final void reset(boolean wasClean, int code, String reason) {
        if (code != 4000) {
            this.sessionId = null;
            this.seq = 0;
        }
        String str = wasClean ? "cleanly" : "dirty";
        GatewaySocket$Companion.log$default(Companion, this.logger, "Reset " + str + ", with code " + code + ", at sequence " + this.seq + ". Reason: '" + reason + "'.", false, 2, null);
        handleConnected(Boolean.valueOf(code == 4000 && this.connected), Boolean.FALSE);
        this.eventHandler.handleDisconnect(code == CLOSE_CODE_UNAUTHORIZED);
    }

    private final void schedule(Function0<Unit> callback) {
        new k(callback).X(this.scheduler).W(GatewaySocket$schedule$1.INSTANCE, GatewaySocket$schedule$2.INSTANCE);
    }

    private final void send(Outgoing data, boolean checkSessionEstablished, Gson gson) {
        if (checkSessionEstablished && !isSessionEstablished()) {
            GatewaySocket$Companion gatewaySocket$Companion = Companion;
            Logger logger = this.logger;
            StringBuilder sbU = a.U("Attempted to send while not being in a connected state, opcode: ");
            sbU.append(data.getOp());
            sbU.append('.');
            GatewaySocket$Companion.log$default(gatewaySocket$Companion, logger, sbU.toString(), false, 2, null);
            return;
        }
        WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            String strM = gson.m(data);
            GatewaySocketLogger gatewaySocketLogger = this.gatewaySocketLogger;
            m.checkNotNullExpressionValue(strM, GATEWAY_ENCODING);
            gatewaySocketLogger.logOutboundMessage(strM);
            webSocket.message(strM);
            return;
        }
        GatewaySocket$Companion gatewaySocket$Companion2 = Companion;
        Logger logger2 = this.logger;
        StringBuilder sbU2 = a.U("Attempted to send without a web socket that exists, opcode: ");
        sbU2.append(data.getOp());
        sbU2.append('.');
        GatewaySocket$Companion.log$default(gatewaySocket$Companion2, logger2, sbU2.toString(), false, 2, null);
    }

    public static /* synthetic */ void send$default(GatewaySocket gatewaySocket, Outgoing outgoing, boolean z2, Gson gson, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            gson = gsonIncludeNulls;
            m.checkNotNullExpressionValue(gson, "gsonIncludeNulls");
        }
        gatewaySocket.send(outgoing, z2, gson);
    }

    private final void startHeartbeater() {
        this.heartbeater.cancel();
        this.heartbeatAck = true;
        this.heartbeater.postInterval(new GatewaySocket$startHeartbeater$1(this), this.heartbeatInterval);
    }

    private final void stopHeartbeater() {
        this.heartbeater.cancel();
        this.heartbeatExpeditedTimeout.cancel();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0076  */
    private final void trackReadyPayload(ModelPayload payload, int compressedByteSize, int uncompressedByteSize, long unpackDurationMs) {
        int iIntValue;
        int size = payload.getGuilds().size();
        Iterator<Guild> it = payload.getGuilds().iterator();
        int i = 0;
        int i2 = 0;
        while (it.hasNext()) {
            List<Channel> listG = it.next().g();
            if (listG != null) {
                Iterator<T> it2 = listG.iterator();
                while (it2.hasNext()) {
                    i++;
                    if (((Channel) it2.next()).getType() == 4) {
                        i2++;
                    }
                }
            }
        }
        ArrayList<Pair<String, Integer>> arrayList = new ArrayList<>();
        flattenTraces(payload.getTrace(), arrayList);
        if (arrayList.size() > 0) {
            Pair<String, Integer> pair = arrayList.get(0);
            String strComponent1 = pair.component1();
            iIntValue = pair.component2().intValue();
            if (!t.startsWith$default(strComponent1, "gateway-", false, 2, null)) {
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        int i3 = 0;
        int i4 = 0;
        for (Pair<String, Integer> pair2 : arrayList) {
            String strComponent2 = pair2.component1();
            int iIntValue2 = pair2.component2().intValue();
            if (m.areEqual(strComponent2, "start_session")) {
                i3 = iIntValue2;
            } else if (m.areEqual(strComponent2, "guilds_connect")) {
                i4 = iIntValue2;
            }
        }
        Function1<Map<String, ? extends Object>, Unit> function1 = this.trackReadyPayload;
        GatewaySocket$Companion gatewaySocket$Companion = Companion;
        function1.invoke(h0.mapOf(o.to("duration_ms_since_connection_start", Long.valueOf(GatewaySocket$Companion.getDelay$default(gatewaySocket$Companion, this.connectionStartTime, null, 2, null))), o.to("duration_ms_since_identify_start", Long.valueOf(GatewaySocket$Companion.getDelay$default(gatewaySocket$Companion, this.identifyStartTime, null, 2, null))), o.to("identify_total_server_duration_ms", Integer.valueOf(iIntValue)), o.to("identify_api_duration_ms", Integer.valueOf(i3)), o.to("identify_guilds_duration_ms", Integer.valueOf(i4)), o.to("compressed_byte_size", Integer.valueOf(compressedByteSize)), o.to("uncompressed_byte_size", Integer.valueOf(uncompressedByteSize)), o.to("compression_algorithm", "zlib"), o.to("packing_algorithm", GATEWAY_ENCODING), o.to("unpack_duration_ms", Long.valueOf(unpackDurationMs)), o.to("is_reconnect", Boolean.valueOf(this.hasConnectedOnce)), o.to("is_fast_connect", Boolean.FALSE), o.to("num_guilds", Integer.valueOf(size)), o.to("num_guild_channels", Integer.valueOf(i)), o.to("num_guild_category_channels", Integer.valueOf(i2))));
    }

    public final void callConnect(long channelId) {
        schedule(new GatewaySocket$callConnect$1(this, channelId));
    }

    public final void close(boolean clean) {
        schedule(new GatewaySocket$close$1(this, clean));
    }

    public final void connect() {
        schedule(new GatewaySocket$connect$1(this));
    }

    public final void expeditedHeartbeat(long timeout, String reason, boolean shouldResetBackoff) {
        schedule(new GatewaySocket$expeditedHeartbeat$1(this, reason, timeout, shouldResetBackoff));
    }

    public final ListenerCollection<GatewaySocket$Listener> getListeners() {
        return this.listeners;
    }

    public final boolean isSessionEstablished() {
        return this.connectionState == 5;
    }

    public final void presenceUpdate(ClientStatus status, Long since, List<Activity> activities, Boolean afk) {
        schedule(new GatewaySocket$presenceUpdate$1(this, status, activities, since, afk));
    }

    public final void requestApplicationCommands(OutgoingPayload$ApplicationCommandRequest request) {
        m.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_APPLICATION_COMMANDS, request);
        Gson gson = gsonOmitNulls;
        m.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void requestForumUnreads(OutgoingPayload$ForumUnreadsRequest request) {
        m.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_FORUM_UNREADS, request);
        Gson gson = gsonOmitNulls;
        m.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void requestGuildMembers(List<Long> list) {
        requestGuildMembers$default(this, list, null, null, null, 14, null);
    }

    public final void requestGuildMembers(List<Long> list, String str) {
        requestGuildMembers$default(this, list, str, null, null, 12, null);
    }

    public final void requestGuildMembers(List<Long> list, String str, List<Long> list2) {
        requestGuildMembers$default(this, list, str, list2, null, 8, null);
    }

    public final void requestGuildMembers(List<Long> guildIds, String query, List<Long> userIds, Integer limit) {
        m.checkNotNullParameter(guildIds, "guildIds");
        schedule(new GatewaySocket$requestGuildMembers$1(this, guildIds, query, userIds, limit));
    }

    public final void resetOnError() {
        schedule(new GatewaySocket$resetOnError$1(this));
    }

    public final void simulateReconnectForTesting() {
        schedule(new GatewaySocket$simulateReconnectForTesting$1(this));
    }

    public final void streamCreate(String streamType, long channelId, Long guildId, String preferredRegion) {
        m.checkNotNullParameter(streamType, "streamType");
        GatewaySocket$Companion.log$default(Companion, this.logger, "Sending STREAM_CREATE: " + channelId + ' ' + guildId, false, 2, null);
        send$default(this, new Outgoing(Opcode.STREAM_CREATE, new OutgoingPayload$CreateStream(streamType, channelId, guildId, preferredRegion)), false, null, 6, null);
    }

    public final void streamDelete(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        schedule(new GatewaySocket$streamDelete$1(this, streamKey));
    }

    public final void streamPing(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        schedule(new GatewaySocket$streamPing$1(this, streamKey));
    }

    public final void streamWatch(String streamKey) {
        m.checkNotNullParameter(streamKey, "streamKey");
        schedule(new GatewaySocket$streamWatch$1(this, streamKey));
    }

    public final void updateGuildSubscriptions(long guildId, OutgoingPayload$GuildSubscriptions guildSubscriptions) {
        m.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
        GatewaySocket$Companion.log$default(Companion, this.logger, "sending guild subscriptions: " + guildId + " -- " + guildSubscriptions, false, 2, null);
        Opcode opcode = Opcode.GUILD_SUBSCRIPTIONS;
        Boolean typing = guildSubscriptions.getTyping();
        Boolean activities = guildSubscriptions.getActivities();
        List<Long> members = guildSubscriptions.getMembers();
        Outgoing outgoing = new Outgoing(opcode, new OutgoingPayload$GuildSubscriptionsUpdate(guildId, typing, activities, members != null ? u.toList(members) : null, guildSubscriptions.getChannels(), guildSubscriptions.getThreads(), guildSubscriptions.getThreadMemberLists()));
        Gson gson = gsonOmitNulls;
        m.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void voiceServerPing() {
        schedule(new GatewaySocket$voiceServerPing$1(this));
    }

    public final void voiceStateUpdate(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion, boolean shouldIncludePreferredRegion) {
        schedule(new GatewaySocket$voiceStateUpdate$1(this, guildId, channelId, selfMute, selfDeaf, preferredRegion, shouldIncludePreferredRegion, selfVideo));
    }

    private final void connect(String gatewayUrl) {
        GatewaySocket$connect$$inlined$apply$lambda$4 gatewaySocket$connect$$inlined$apply$lambda$4;
        if (this.connectionState != 1) {
            return;
        }
        this.connectionState = 2;
        GatewaySocket$Companion.log$default(Companion, this.logger, a.y("Connect to: ", gatewayUrl, ", encoding: json, version 9."), false, 2, null);
        cleanup(GatewaySocket$connect$2.INSTANCE);
        this.connectionStartTime = clock.currentTimeMillis();
        this.helloTimeout.schedule(new GatewaySocket$connect$3(this), HELLO_TIMEOUT);
        WebSocket webSocket = new WebSocket(this.scheduler, new GatewaySocket$connect$4(this), this.sslSocketFactory);
        webSocket.setOnOpened(new GatewaySocket$connect$$inlined$apply$lambda$1(this, gatewayUrl));
        webSocket.setOnClosed(new GatewaySocket$connect$$inlined$apply$lambda$2(this, gatewayUrl));
        webSocket.setOnMessage(new GatewaySocket$connect$$inlined$apply$lambda$3(this, gatewayUrl));
        int iOrdinal = this.gatewaySocketLogger.getLogLevel().ordinal();
        if (iOrdinal == 0) {
            gatewaySocket$connect$$inlined$apply$lambda$4 = null;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            gatewaySocket$connect$$inlined$apply$lambda$4 = new GatewaySocket$connect$$inlined$apply$lambda$4(this, gatewayUrl);
        }
        webSocket.setRawMessageHandler(gatewaySocket$connect$$inlined$apply$lambda$4);
        webSocket.setOnError(new GatewaySocket$connect$$inlined$apply$lambda$5(this, gatewayUrl));
        webSocket.connect(gatewayUrl + "/?encoding=json&v=9&compress=zlib-stream");
        this.webSocket = webSocket;
    }

    public /* synthetic */ GatewaySocket(Function0 function0, Function1 function1, GatewayEventHandler gatewayEventHandler, Scheduler scheduler, Logger logger, NetworkMonitor networkMonitor, RestConfig restConfig, Context context, Function1 function2, SSLSocketFactory sSLSocketFactory, Map map, GatewaySocketLogger gatewaySocketLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, gatewayEventHandler, scheduler, logger, networkMonitor, restConfig, context, (i & 256) != 0 ? null : function2, (i & 512) != 0 ? null : sSLSocketFactory, (i & 1024) != 0 ? h0.emptyMap() : map, gatewaySocketLogger);
    }
}
