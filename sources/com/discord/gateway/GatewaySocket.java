package com.discord.gateway;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import b.i.d.FieldNamingPolicy;
import b.i.d.GsonBuilder;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityType;
import com.discord.api.activity.ActivityType2;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.gateway.GatewaySocketLogger;
import com.discord.gateway.io.Incoming;
import com.discord.gateway.io.Incoming2;
import com.discord.gateway.io.Outgoing;
import com.discord.gateway.io.Outgoing2;
import com.discord.gateway.opcodes.Opcode;
import com.discord.gateway.rest.RestClient;
import com.discord.gateway.rest.RestConfig;
import com.discord.models.domain.Model;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.collections.ListenerCollection;
import com.discord.utilities.collections.ListenerCollection2;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.networking.Backoff;
import com.discord.utilities.networking.NetworkMonitor;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.websocket.RawMessageHandler;
import com.discord.utilities.websocket.WebSocket;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.TypeIntrinsics;
import j0.k.Func1;
import j0.l.a.OnSubscribeLift;
import j0.l.a.OperatorSkipWhile2;
import j0.l.a.OperatorSkipWhile3;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Scheduler;
import rx.Subscription;
import rx.functions.Action1;

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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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
    private Timer heartbeatExpeditedTimeout;
    private long heartbeatInterval;
    private Timer heartbeater;
    private Timer helloTimeout;
    private final Function0<IdentifyData> identifyDataProvider;
    private final Map<String, Object> identifyProperties;
    private long identifyStartTime;
    private final ListenerCollection2<Listener> listenerSubject;
    private final ListenerCollection<Listener> listeners;
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

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "message");
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.this.logger, str, false, 2, null);
        }
    }

    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class Companion {
        private Companion() {
        }

        private final long getDelay(long startTime, Long currentTime) {
            return (currentTime != null ? currentTime.longValue() : ClockFactory.get().currentTimeMillis()) - startTime;
        }

        public static /* synthetic */ long getDelay$default(Companion companion, long j, Long l, int i, Object obj) {
            if ((i & 2) != 0) {
                l = null;
            }
            return companion.getDelay(j, l);
        }

        private final void log(Logger logger, String str, boolean z2) {
            Logger.v$default(logger, outline.w("[GatewaySocket] ", str), null, 2, null);
            if (z2) {
                logger.recordBreadcrumb("Gateway [" + str + ']', "log");
            }
        }

        public static /* synthetic */ void log$default(Companion companion, Logger logger, String str, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = true;
            }
            companion.log(logger, str, z2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static abstract class DefaultListener implements Listener {
        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onConnected(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onConnecting(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onDisconnected(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }

        @Override // com.discord.gateway.GatewaySocket.Listener
        public void onHello(GatewaySocket gatewaySocket) {
            Intrinsics3.checkNotNullParameter(gatewaySocket, "gatewaySocket");
        }
    }

    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class IdentifyData {
        private final Outgoing2.IdentifyClientState clientState;
        private final String token;

        public IdentifyData(String str, Outgoing2.IdentifyClientState identifyClientState) {
            Intrinsics3.checkNotNullParameter(str, "token");
            this.token = str;
            this.clientState = identifyClientState;
        }

        public final Outgoing2.IdentifyClientState getClientState() {
            return this.clientState;
        }

        public final String getToken() {
            return this.token;
        }
    }

    /* JADX INFO: compiled from: GatewaySocket.kt */
    public interface Listener {
        void onConnected(GatewaySocket gatewaySocket);

        void onConnecting(GatewaySocket gatewaySocket);

        void onDisconnected(GatewaySocket gatewaySocket);

        void onHello(GatewaySocket gatewaySocket);
    }

    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class SizeRecordingInputStreamReader extends Reader {
        private int size;
        private final InputStreamReader source;

        public SizeRecordingInputStreamReader(InputStreamReader inputStreamReader, int i) {
            Intrinsics3.checkNotNullParameter(inputStreamReader, "source");
            this.source = inputStreamReader;
            this.size = i;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.source.close();
        }

        public final int getSize() {
            return this.size;
        }

        public final InputStreamReader getSource() {
            return this.source;
        }

        @Override // java.io.Reader
        public int read(char[] buffer, int offset, int len) throws IOException {
            Intrinsics3.checkNotNullParameter(buffer, "buffer");
            int i = this.source.read(buffer, offset, len);
            if (i != -1) {
                this.size += i;
            }
            return i;
        }

        public final void setSize(int i) {
            this.size = i;
        }

        public /* synthetic */ SizeRecordingInputStreamReader(InputStreamReader inputStreamReader, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(inputStreamReader, (i2 & 2) != 0 ? 0 : i);
        }
    }

    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class Timer implements Backoff.Scheduler {
        private final Scheduler scheduler;
        private Subscription subscription;

        public Timer(Scheduler scheduler) {
            Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
            this.scheduler = scheduler;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void cancel$default(Timer timer, Function0 function0, int i, Object obj) {
            if ((i & 1) != 0) {
                function0 = null;
            }
            timer.cancel(function0);
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public void cancel() {
            cancel(null);
        }

        public final boolean getPending() {
            return this.subscription != null;
        }

        public final void postInterval(final Function0<Unit> callback, long delayMillis) {
            Intrinsics3.checkNotNullParameter(callback, "callback");
            cancel();
            this.subscription = Observable.F(delayMillis, delayMillis, TimeUnit.MILLISECONDS, Schedulers2.a()).J(this.scheduler).W(new Action1<Long>() { // from class: com.discord.gateway.GatewaySocket$Timer$postInterval$1
                @Override // rx.functions.Action1
                public final void call(Long l) {
                    callback.invoke();
                }
            }, new Action1<Throwable>() { // from class: com.discord.gateway.GatewaySocket$Timer$postInterval$2
                @Override // rx.functions.Action1
                public final void call(Throwable th) {
                }
            });
        }

        @Override // com.discord.utilities.networking.Backoff.Scheduler
        public void schedule(final Function0<Unit> action, long delayMs) {
            Intrinsics3.checkNotNullParameter(action, "action");
            cancel();
            this.subscription = Observable.d0(delayMs, TimeUnit.MILLISECONDS).J(this.scheduler).W(new Action1<Long>() { // from class: com.discord.gateway.GatewaySocket$Timer$schedule$1
                @Override // rx.functions.Action1
                public final void call(Long l) {
                    try {
                        action.invoke();
                    } finally {
                        this.this$0.subscription = null;
                    }
                }
            }, new Action1<Throwable>() { // from class: com.discord.gateway.GatewaySocket$Timer$schedule$2
                @Override // rx.functions.Action1
                public final void call(Throwable th) {
                }
            });
        }

        public final void cancel(Function0<Unit> callback) {
            Subscription subscription = this.subscription;
            if (subscription != null) {
                if (subscription != null) {
                    subscription.unsubscribe();
                }
                this.subscription = null;
                if (callback != null) {
                    callback.invoke();
                }
            }
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            GatewaySocketLogger.LogLevel.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[GatewaySocketLogger.LogLevel.NONE.ordinal()] = 1;
            iArr[GatewaySocketLogger.LogLevel.VERBOSE.ordinal()] = 2;
            Opcode.values();
            int[] iArr2 = new int[21];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[Opcode.HELLO.ordinal()] = 1;
            iArr2[Opcode.RECONNECT.ordinal()] = 2;
            iArr2[Opcode.INVALID_SESSION.ordinal()] = 3;
            iArr2[Opcode.HEARTBEAT.ordinal()] = 4;
            iArr2[Opcode.HEARTBEAT_ACK.ordinal()] = 5;
            iArr2[Opcode.DISPATCH.ordinal()] = 6;
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$callConnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Companion companion = GatewaySocket.INSTANCE;
            Logger logger = GatewaySocket.this.logger;
            StringBuilder sbU = outline.U("Sending call connect sync on channel id: ");
            sbU.append(this.$channelId);
            sbU.append('.');
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.CALL_CONNECT, new Outgoing2.CallConnect(this.$channelId)), false, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$close$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ boolean $clean;

        /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$close$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GatewaySocket.kt */
        public static final class C00651 extends Lambda implements Function1<WebSocket, Unit> {
            public final /* synthetic */ int $code;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C00651(int i) {
                super(1);
                this.$code = i;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
                invoke2(webSocket);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebSocket webSocket) {
                if (webSocket != null) {
                    WebSocket.disconnect$default(webSocket, this.$code, null, 2, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(boolean z2) {
            super(0);
            this.$clean = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (GatewaySocket.this.connectionState == 0) {
                return;
            }
            int i = this.$clean ? 1000 : 4000;
            GatewaySocket.this.cleanup(new C00651(i));
            GatewaySocket.this.connectionState = 0;
            GatewaySocket.this.reset(this.$clean, i, "Disconnect requested by client");
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$connect$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (GatewaySocket.this.connectionState == 0) {
                GatewaySocket.this.connectionState = 1;
                GatewaySocket.this.discover();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$connect$2, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<WebSocket, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                webSocket.disconnect(4000, "Connect called with an existing web socket.");
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$connect$3, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket gatewaySocket = GatewaySocket.this;
            StringBuilder sbU = outline.U("Connection timed out after ");
            sbU.append(Companion.getDelay$default(GatewaySocket.INSTANCE, GatewaySocket.this.connectionStartTime, null, 2, null));
            sbU.append("ms, did not receive hello in time.");
            gatewaySocket.handleClose(false, 0, sbU.toString());
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$connect$4, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function3<String, Exception, Map<String, ? extends String>, Unit> {
        public AnonymousClass4(GatewaySocket gatewaySocket) {
            super(3, gatewaySocket, GatewaySocket.class, "logError", "logError(Ljava/lang/String;Ljava/lang/Exception;Ljava/util/Map;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(String str, Exception exc, Map<String, ? extends String> map) {
            invoke2(str, exc, (Map<String, String>) map);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str, Exception exc, Map<String, String> map) {
            Intrinsics3.checkNotNullParameter(str, "p1");
            Intrinsics3.checkNotNullParameter(exc, "p2");
            ((GatewaySocket) this.receiver).logError(str, exc, map);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$discover$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnecting(GatewaySocket.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$discover$2, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            String str2;
            Intrinsics3.checkNotNullParameter(str, "gatewayUrl");
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Function1 function1 = gatewaySocket.gatewayUrlTransform;
            if (function1 != null && (str2 = (String) function1.invoke(str)) != null) {
                str = str2;
            }
            gatewaySocket.connect(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$discover$3, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Throwable, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            Intrinsics3.checkNotNullParameter(th, "it");
            GatewaySocket.this.discoveryFailed();
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $reason;
        public final /* synthetic */ boolean $shouldResetBackoff;
        public final /* synthetic */ long $timeout;

        /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GatewaySocket.kt */
        public static final class C00661 extends Lambda implements Function1<String, Unit> {
            public C00661() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_REASON);
                Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.this.logger, "Connection backoff reset " + str + '.', false, 2, null);
                GatewaySocket.this.gatewayBackoff.succeed();
                GatewaySocket.this.nextReconnectIsImmediate = true;
                if (GatewaySocket.this.connectionState == 1) {
                    GatewaySocket.this.discover();
                }
            }
        }

        /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$expeditedHeartbeat$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: GatewaySocket.kt */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (GatewaySocket.this.heartbeatAck) {
                    return;
                }
                GatewaySocket.this.handleHeartbeatTimeout();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, long j, boolean z2) {
            super(0);
            this.$reason = str;
            this.$timeout = j;
            this.$shouldResetBackoff = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String strH = this.$reason != null ? outline.H(outline.U("with reason '"), this.$reason, '\'') : "";
            C00661 c00661 = new C00661();
            if (GatewaySocket.this.webSocket == null) {
                if (this.$shouldResetBackoff) {
                    c00661.invoke2(strH);
                    return;
                } else {
                    Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.this.logger, outline.y("Expedited heartbeat requested ", strH, ", but disconnected and no reset backoff."), false, 2, null);
                    return;
                }
            }
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.this.logger, "Performing an expedited heartbeat " + strH + '.', false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            gatewaySocket.heartbeat(gatewaySocket.seq);
            GatewaySocket.this.heartbeatAck = false;
            GatewaySocket.this.heartbeatExpeditedTimeout.schedule(new AnonymousClass2(), this.$timeout);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$handleClose$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WebSocket, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$handleHeartbeatAck$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.this.logger, "Expedited heartbeat succeeded.", false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$handleHeartbeatTimeout$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WebSocket, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                WebSocket.disconnect$default(webSocket, 4000, null, 2, null);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$handleHello$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onHello(GatewaySocket.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$handleReconnect$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<WebSocket, Unit> {
        public final /* synthetic */ String $reason;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(1);
            this.$reason = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WebSocket webSocket) {
            invoke2(webSocket);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WebSocket webSocket) {
            if (webSocket != null) {
                webSocket.disconnect(4000, this.$reason);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$handleWebSocketClose$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onDisconnected(GatewaySocket.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$handleWebSocketOpened$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Listener, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Listener listener) {
            invoke2(listener);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Listener listener) {
            Intrinsics3.checkNotNullParameter(listener, "it");
            listener.onConnected(GatewaySocket.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$presenceUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $activities;
        public final /* synthetic */ Boolean $afk;
        public final /* synthetic */ Long $since;
        public final /* synthetic */ ClientStatus $status;

        /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$presenceUpdate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: GatewaySocket.kt */
        public static final class C00671 extends Lambda implements Function1<Activity, CharSequence> {
            public static final C00671 INSTANCE = new C00671();

            public C00671() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(Activity activity) {
                Intrinsics3.checkNotNullParameter(activity, "it");
                return activity.getName();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ClientStatus clientStatus, List list, Long l, Boolean bool) {
            super(0);
            this.$status = clientStatus;
            this.$activities = list;
            this.$since = l;
            this.$afk = bool;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            String strName;
            Companion companion = GatewaySocket.INSTANCE;
            Logger logger = GatewaySocket.this.logger;
            StringBuilder sbU = outline.U("Sending self presence update: ");
            sbU.append(this.$status);
            sbU.append(' ');
            List list = this.$activities;
            String lowerCase = null;
            sbU.append(list != null ? _Collections.joinToString$default(list, null, null, null, 0, null, C00671.INSTANCE, 31, null) : null);
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Opcode opcode = Opcode.PRESENCE_UPDATE;
            ClientStatus clientStatus = this.$status;
            if (clientStatus != null && (strName = clientStatus.name()) != null) {
                Locale locale = Locale.ROOT;
                Intrinsics3.checkNotNullExpressionValue(locale, "Locale.ROOT");
                lowerCase = strName.toLowerCase(locale);
                Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            }
            Long l = this.$since;
            List listEmptyList = this.$activities;
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
            GatewaySocket.send$default(gatewaySocket, new Outgoing(opcode, new Outgoing2.PresenceUpdate(lowerCase, l, listEmptyList, this.$afk)), false, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$requestGuildMembers$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $guildIds;
        public final /* synthetic */ Integer $limit;
        public final /* synthetic */ String $query;
        public final /* synthetic */ List $userIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, String str, List list2, Integer num) {
            super(0);
            this.$guildIds = list;
            this.$query = str;
            this.$userIds = list2;
            this.$limit = num;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Outgoing2.GuildMembersRequest guildMembersRequest = new Outgoing2.GuildMembersRequest(this.$guildIds, this.$query, this.$userIds, this.$limit, false, 16, null);
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.this.logger, "Sending guild member request: " + guildMembersRequest, false, 2, null);
            GatewaySocket gatewaySocket = GatewaySocket.this;
            Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_MEMBERS, guildMembersRequest);
            Gson gson = GatewaySocket.gsonOmitNulls;
            Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
            GatewaySocket.send$default(gatewaySocket, outgoing, false, gson, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$resetOnError$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket.this.nextReconnectIsImmediate = false;
            GatewaySocket.handleReconnect$default(GatewaySocket.this, "encountered an error", false, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$simulateReconnectForTesting$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            GatewaySocket.handleReconnect$default(GatewaySocket.this, null, false, 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$startHeartbeater$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (GatewaySocket.this.heartbeatAck) {
                GatewaySocket.this.heartbeatAck = false;
                GatewaySocket gatewaySocket = GatewaySocket.this;
                gatewaySocket.heartbeat(gatewaySocket.seq);
            } else {
                if (GatewaySocket.this.heartbeatExpeditedTimeout.getPending()) {
                    return;
                }
                GatewaySocket.this.handleHeartbeatTimeout();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$streamDelete$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Companion companion = GatewaySocket.INSTANCE;
            Logger logger = GatewaySocket.this.logger;
            StringBuilder sbU = outline.U("Sending STREAM_DELETE: ");
            sbU.append(this.$streamKey);
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.STREAM_DELETE, new Outgoing2.DeleteStream(this.$streamKey)), false, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$streamPing$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Companion companion = GatewaySocket.INSTANCE;
            Logger logger = GatewaySocket.this.logger;
            StringBuilder sbU = outline.U("Sending OPCODE_STREAM_PING: ");
            sbU.append(this.$streamKey);
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.OPCODE_STREAM_PING, new Outgoing2.StreamPing(this.$streamKey)), false, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$streamWatch$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $streamKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$streamKey = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Companion companion = GatewaySocket.INSTANCE;
            Logger logger = GatewaySocket.this.logger;
            StringBuilder sbU = outline.U("Sending STREAM_WATCH: ");
            sbU.append(this.$streamKey);
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.STREAM_WATCH, new Outgoing2.WatchStream(this.$streamKey)), false, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$voiceServerPing$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Companion.log$default(GatewaySocket.INSTANCE, GatewaySocket.this.logger, "Sending ping to voice server.", false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.VOICE_SERVER_PING, (Object) null), false, null, 6, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.gateway.GatewaySocket$voiceStateUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: GatewaySocket.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $channelId;
        public final /* synthetic */ Long $guildId;
        public final /* synthetic */ String $preferredRegion;
        public final /* synthetic */ boolean $selfDeaf;
        public final /* synthetic */ boolean $selfMute;
        public final /* synthetic */ boolean $selfVideo;
        public final /* synthetic */ boolean $shouldIncludePreferredRegion;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, Long l2, boolean z2, boolean z3, String str, boolean z4, boolean z5) {
            super(0);
            this.$guildId = l;
            this.$channelId = l2;
            this.$selfMute = z2;
            this.$selfDeaf = z3;
            this.$preferredRegion = str;
            this.$shouldIncludePreferredRegion = z4;
            this.$selfVideo = z5;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Companion companion = GatewaySocket.INSTANCE;
            Logger logger = GatewaySocket.this.logger;
            StringBuilder sbU = outline.U("Sending voice state update for guild [");
            sbU.append(this.$guildId);
            sbU.append("] and channel [");
            sbU.append(this.$channelId);
            sbU.append("]. ");
            sbU.append("Muted: ");
            sbU.append(this.$selfMute);
            sbU.append(", deafened: ");
            sbU.append(this.$selfDeaf);
            sbU.append(", preferredRegion: ");
            sbU.append(this.$preferredRegion);
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            GatewaySocket.send$default(GatewaySocket.this, new Outgoing(Opcode.VOICE_STATE_UPDATE, this.$shouldIncludePreferredRegion ? new Outgoing2.VoiceStateUpdate(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo, this.$preferredRegion) : new Outgoing2.VoiceStateUpdateNoPreferredRegion(this.$guildId, this.$channelId, this.$selfMute, this.$selfDeaf, this.$selfVideo)), false, null, 6, null);
        }
    }

    static {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.g = true;
        FieldNamingPolicy fieldNamingPolicy = FieldNamingPolicy.m;
        gsonBuilder.c = fieldNamingPolicy;
        gsonBuilder.b(ActivityType.class, new ActivityType2());
        gsonIncludeNulls = gsonBuilder.a();
        GsonBuilder gsonBuilder2 = new GsonBuilder();
        gsonBuilder2.c = fieldNamingPolicy;
        gsonOmitNulls = gsonBuilder2.a();
        EXPECTED_NULL_DATA_EVENTS = Sets5.setOf((Object[]) new String[]{"USER_SUBSCRIPTIONS_UPDATE", "USER_PAYMENT_SOURCES_UPDATE"});
        clock = ClockFactory.get();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GatewaySocket(Function0<IdentifyData> function0, Function1<? super Map<String, ? extends Object>, Unit> function1, GatewayEventHandler gatewayEventHandler, Scheduler scheduler, Logger logger, NetworkMonitor networkMonitor, RestConfig restConfig, Context context, Function1<? super String, String> function2, SSLSocketFactory sSLSocketFactory, Map<String, ? extends Object> map, GatewaySocketLogger gatewaySocketLogger) {
        Intrinsics3.checkNotNullParameter(function0, "identifyDataProvider");
        Intrinsics3.checkNotNullParameter(function1, "trackReadyPayload");
        Intrinsics3.checkNotNullParameter(gatewayEventHandler, "eventHandler");
        Intrinsics3.checkNotNullParameter(scheduler, "scheduler");
        Intrinsics3.checkNotNullParameter(logger, "logger");
        Intrinsics3.checkNotNullParameter(networkMonitor, "networkMonitor");
        Intrinsics3.checkNotNullParameter(restConfig, "restConfig");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(map, "identifyProperties");
        Intrinsics3.checkNotNullParameter(gatewaySocketLogger, "gatewaySocketLogger");
        this.identifyDataProvider = function0;
        this.trackReadyPayload = function1;
        this.eventHandler = gatewayEventHandler;
        this.scheduler = scheduler;
        this.logger = logger;
        this.gatewayUrlTransform = function2;
        this.sslSocketFactory = sSLSocketFactory;
        this.identifyProperties = map;
        this.gatewaySocketLogger = gatewaySocketLogger;
        Backoff backoff = new Backoff(1000L, 10000L, 4, true, new Timer(scheduler));
        this.gatewayBackoff = backoff;
        this.heartbeatExpeditedTimeout = new Timer(scheduler);
        this.heartbeatInterval = RecyclerView.FOREVER_NS;
        this.heartbeater = new Timer(scheduler);
        this.heartbeatAck = true;
        this.helloTimeout = new Timer(scheduler);
        ListenerCollection2<Listener> listenerCollection2 = new ListenerCollection2<>();
        this.listenerSubject = listenerCollection2;
        this.listeners = listenerCollection2;
        RestClient restClient = RestClient.INSTANCE;
        restClient.init(restConfig, context);
        this.gatewayDiscovery = new GatewayDiscovery(context, scheduler, backoff, new AnonymousClass1(), restClient.getGateway());
        Observable<Boolean> observableJ = networkMonitor.observeIsConnected().J(scheduler);
        Observable.h0(new OnSubscribeLift(observableJ.j, new OperatorSkipWhile3(new OperatorSkipWhile2(new Func1<Boolean, Boolean>() { // from class: com.discord.gateway.GatewaySocket.2
            @Override // j0.k.Func1
            public final Boolean call(Boolean bool) {
                return bool;
            }
        })))).W(new Action1<Boolean>() { // from class: com.discord.gateway.GatewaySocket.3
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                GatewaySocket gatewaySocket = GatewaySocket.this;
                Intrinsics3.checkNotNullExpressionValue(bool, "isConnected");
                gatewaySocket.handleDeviceConnectivityChange(bool.booleanValue());
            }
        }, new Action1<Throwable>() { // from class: com.discord.gateway.GatewaySocket.4
            @Override // rx.functions.Action1
            public final void call(Throwable th) {
                Logger logger2 = GatewaySocket.this.logger;
                StringBuilder sbU = outline.U("failed to handle connectivity change in ");
                sbU.append(GatewaySocket.this.getClass().getSimpleName());
                Logger.e$default(logger2, sbU.toString(), th, null, 4, null);
            }
        });
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
        this.listenerSubject.notify(new AnonymousClass1());
        this.gatewayDiscovery.discoverGatewayUrl(new AnonymousClass2(), new AnonymousClass3());
    }

    private final void discoveryFailed() {
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$discoveryFailed$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, "Discovery failed, retrying in " + jFail + "ms.", false, 2, null);
        if (this.gatewayBackoff.hasReachedFailureThreshold()) {
            reset(false, 0, "Gateway discovery failed.");
        }
    }

    private final void doIdentify() {
        this.seq = 0;
        this.sessionId = null;
        IdentifyData identifyDataInvoke = this.identifyDataProvider.invoke();
        if (identifyDataInvoke == null) {
            handleClose(true, CLOSE_CODE_UNAUTHORIZED, "No connection info provided.");
            return;
        }
        this.connectionState = 3;
        this.identifyStartTime = clock.currentTimeMillis();
        this.token = identifyDataInvoke.getToken();
        Companion.log$default(INSTANCE, this.logger, "Sending identify.", false, 2, null);
        send$default(this, new Outgoing(Opcode.IDENTIFY, new Outgoing2.Identify(identifyDataInvoke.getToken(), 100, true, CLIENT_CAPABILITIES, this.identifyProperties, identifyDataInvoke.getClientState())), false, null, 4, null);
    }

    private final void doResume() {
        this.connectionState = 4;
        this.replayedEvents = 0;
        Companion companion = INSTANCE;
        Logger logger = this.logger;
        StringBuilder sbU = outline.U("Resuming session ");
        String str = this.sessionId;
        if (str == null) {
            str = "";
        }
        sbU.append(str);
        sbU.append(" at sequence: ");
        Companion.log$default(companion, logger, outline.A(sbU, this.seq, '.'), false, 2, null);
        send$default(this, new Outgoing(Opcode.RESUME, new Outgoing2.Resume(this.token, this.sessionId, this.seq)), false, null, 4, null);
    }

    private final void doResumeOrIdentify() {
        Companion companion = INSTANCE;
        long delay$default = Companion.getDelay$default(companion, this.heartbeatAckTimeMostRecent, null, 2, null);
        float f = this.heartbeatAckTimeMostRecent == 0 ? 0.0f : (delay$default / 1000.0f) / 60.0f;
        if (this.sessionId != null && delay$default <= ((long) HEARTBEAT_MAX_RESUME_THRESHOLD)) {
            Logger logger = this.logger;
            StringBuilder sbU = outline.U("Attempting to resume after elapsed duration of ");
            String str = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
            Intrinsics3.checkNotNullExpressionValue(str, "java.lang.String.format(this, *args)");
            sbU.append(str);
            sbU.append(" minutes.");
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
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

    private final void flattenTraces(Object trace, ArrayList<Tuples2<String, Integer>> result) {
        if (trace == null) {
            return;
        }
        try {
            if (!TypeIntrinsics.isMutableList(trace)) {
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
                if (!TypeIntrinsics.isMutableMap(obj3)) {
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
                        result.add(new Tuples2<>(str, Integer.valueOf(number.intValue() / 1000)));
                    }
                    flattenTraces(map.get("calls"), result);
                }
            }
        } catch (Exception e) {
            Logger.e$default(this.logger, "Unable to parse ready payload traces", e, null, 4, null);
        }
    }

    private final String getConnectionPath(ModelPayload.Hello hello) {
        String strJoinToString$default;
        List<String> trace = hello.getTrace();
        return (trace == null || (strJoinToString$default = _Collections.joinToString$default(trace, " -> ", null, null, 0, null, null, 62, null)) == null) ? "???" : strJoinToString$default;
    }

    private final void handleClose(boolean wasClean, int code, String reason) {
        cleanup(AnonymousClass1.INSTANCE);
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
        String strJ = outline.J(sb, reason, "'.");
        if (this.nextReconnectIsImmediate) {
            Companion.log$default(INSTANCE, this.logger, outline.w(strJ, " Retrying immediately."), false, 2, null);
            discover();
            return;
        }
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleClose$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, strJ + " Retrying in: " + jFail + "ms.", false, 2, null);
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
        if (Intrinsics3.areEqual(type, "READY") || Intrinsics3.areEqual(type, "RESUMED")) {
            if (type != null) {
                int iHashCode = type.hashCode();
                if (iHashCode != 77848963) {
                    if (iHashCode == 1815529911 && type.equals("RESUMED")) {
                        StringBuilder sb = new StringBuilder();
                        StringBuilder sbU = outline.U("Resumed session, took ");
                        Companion companion = INSTANCE;
                        sbU.append(Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null));
                        sbU.append("ms, ");
                        sb.append(sbU.toString());
                        sb.append("replayed " + this.replayedEvents + " events, new seq: " + this.seq + '.');
                        String string = sb.toString();
                        Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …              .toString()");
                        Companion.log$default(companion, this.logger, string, false, 2, null);
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
                    Companion companion2 = INSTANCE;
                    Logger logger = this.logger;
                    StringBuilder sbU2 = outline.U("Ready with session id: ");
                    sbU2.append(this.sessionId);
                    sbU2.append(", took ");
                    Companion.log$default(companion2, logger, outline.C(sbU2, Companion.getDelay$default(companion2, this.connectionStartTime, null, 2, null), "ms"), false, 2, null);
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
        if (_Collections.contains(EXPECTED_NULL_DATA_EVENTS, type)) {
            this.eventHandler.handleDispatch(type, Unit.a);
        } else if ((!Intrinsics3.areEqual(type, "READY")) && (!Intrinsics3.areEqual(type, "RESUMED"))) {
            Logger.w$default(this.logger, outline.y("handleDispatch() ", type, " is unhandled!"), null, 2, null);
        }
    }

    private final void handleHeartbeat() {
        heartbeat(this.seq);
    }

    private final void handleHeartbeatAck() {
        INSTANCE.log(this.logger, "Received heartbeat ACK.", false);
        this.heartbeatAckTimeMostRecent = clock.currentTimeMillis();
        this.heartbeatAck = true;
        this.heartbeatExpeditedTimeout.cancel(new AnonymousClass1());
    }

    private final void handleHeartbeatTimeout() {
        cleanup(AnonymousClass1.INSTANCE);
        this.connectionState = 1;
        long jFail = this.gatewayBackoff.fail(new GatewaySocket$handleHeartbeatTimeout$delay$1(this));
        Companion.log$default(INSTANCE, this.logger, "Ack timeout, reconnecting om " + jFail + "ms.", false, 2, null);
    }

    private final void handleHello(ModelPayload.Hello data) {
        this.listenerSubject.notify(new AnonymousClass1());
        clearHelloTimeout();
        this.heartbeatInterval = data.getHeartbeatInterval();
        Companion companion = INSTANCE;
        Logger logger = this.logger;
        StringBuilder sbU = outline.U("Hello via ");
        sbU.append(getConnectionPath(data));
        sbU.append(", at interval ");
        sbU.append(this.heartbeatInterval);
        sbU.append(" took ");
        Companion.log$default(companion, logger, outline.C(sbU, Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        startHeartbeater();
    }

    private final void handleInvalidSession(boolean canResume) {
        Companion.log$default(INSTANCE, this.logger, outline.J(outline.U("Invalid session, is "), canResume ? "" : "not", " resumable."), false, 2, null);
        if (canResume) {
            doResumeOrIdentify();
            return;
        }
        Boolean bool = Boolean.FALSE;
        handleConnected(bool, bool);
        doIdentify();
    }

    private final void handleReconnect(String reason, boolean resetSession) {
        cleanup(new AnonymousClass1(reason));
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
    private final void handleWebSocketClose(WebSocket.Closed closed) {
        String reason = closed.getReason();
        if (reason == null) {
            reason = "unspecified reason";
        } else {
            if (!(reason.length() > 0)) {
                reason = "unspecified reason";
            }
        }
        this.listenerSubject.notify(new AnonymousClass1());
        handleClose(true, closed.getCode(), reason);
    }

    private final void handleWebSocketError() {
        handleClose(false, 0, "An error with the web socket occurred.");
    }

    private final void handleWebSocketMessage(InputStreamReader reader, int compressedByteSize) {
        long jCurrentTimeMillis = clock.currentTimeMillis();
        SizeRecordingInputStreamReader sizeRecordingInputStreamReader = new SizeRecordingInputStreamReader(reader, 0, 2, null);
        Incoming incomingBuild = ((Incoming2) new Model.JsonReader(new JsonReader(sizeRecordingInputStreamReader)).parse(new Incoming2(new GatewaySocket$handleWebSocketMessage$incomingParser$1(this)))).build();
        Integer seq = incomingBuild.getSeq();
        Companion companion = INSTANCE;
        long delay$default = Companion.getDelay$default(companion, jCurrentTimeMillis, null, 2, null);
        if (seq != null) {
            this.seq = seq.intValue();
        }
        int iOrdinal = incomingBuild.getOpcode().ordinal();
        if (iOrdinal == 1) {
            handleDispatch(incomingBuild.getData(), incomingBuild.getType(), compressedByteSize, sizeRecordingInputStreamReader.getSize(), delay$default);
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
                handleHello((ModelPayload.Hello) data2);
                break;
            case 12:
                handleHeartbeatAck();
                break;
            default:
                Logger logger = this.logger;
                StringBuilder sbU = outline.U("Unhandled op code ");
                sbU.append(incomingBuild.getOpcode());
                sbU.append('.');
                Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
                break;
        }
    }

    private final void handleWebSocketOpened(String gatewayUrl) {
        Companion companion = INSTANCE;
        Companion.log$default(companion, this.logger, outline.C(outline.Y("Connected to ", gatewayUrl, " in "), Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null), "ms."), false, 2, null);
        this.listenerSubject.notify(new AnonymousClass1());
        doResumeOrIdentify();
    }

    private final void heartbeat(int seq) {
        INSTANCE.log(this.logger, "Sending heartbeat at sequence: " + seq + '.', false);
        send$default(this, new Outgoing(Opcode.HEARTBEAT, Integer.valueOf(seq)), false, null, 4, null);
    }

    private final void logError(String message, Exception exception, Map<String, String> metadata) {
        Logger logger = this.logger;
        if (metadata == null) {
            metadata = Maps6.emptyMap();
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
        Companion.log$default(INSTANCE, this.logger, "Reset " + str + ", with code " + code + ", at sequence " + this.seq + ". Reason: '" + reason + "'.", false, 2, null);
        handleConnected(Boolean.valueOf(code == 4000 && this.connected), Boolean.FALSE);
        this.eventHandler.handleDisconnect(code == CLOSE_CODE_UNAUTHORIZED);
    }

    private final void schedule(Function0<Unit> callback) {
        new ScalarSynchronousObservable(callback).X(this.scheduler).W(new Action1<Function0<? extends Unit>>() { // from class: com.discord.gateway.GatewaySocket.schedule.1
            @Override // rx.functions.Action1
            public /* bridge */ /* synthetic */ void call(Function0<? extends Unit> function0) {
                call2((Function0<Unit>) function0);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(Function0<Unit> function0) {
                function0.invoke();
            }
        }, new Action1<Throwable>() { // from class: com.discord.gateway.GatewaySocket.schedule.2
            @Override // rx.functions.Action1
            public final void call(Throwable th) {
            }
        });
    }

    private final void send(Outgoing data, boolean checkSessionEstablished, Gson gson) {
        if (checkSessionEstablished && !isSessionEstablished()) {
            Companion companion = INSTANCE;
            Logger logger = this.logger;
            StringBuilder sbU = outline.U("Attempted to send while not being in a connected state, opcode: ");
            sbU.append(data.getOp());
            sbU.append('.');
            Companion.log$default(companion, logger, sbU.toString(), false, 2, null);
            return;
        }
        WebSocket webSocket = this.webSocket;
        if (webSocket != null) {
            String strM = gson.m(data);
            GatewaySocketLogger gatewaySocketLogger = this.gatewaySocketLogger;
            Intrinsics3.checkNotNullExpressionValue(strM, GATEWAY_ENCODING);
            gatewaySocketLogger.logOutboundMessage(strM);
            webSocket.message(strM);
            return;
        }
        Companion companion2 = INSTANCE;
        Logger logger2 = this.logger;
        StringBuilder sbU2 = outline.U("Attempted to send without a web socket that exists, opcode: ");
        sbU2.append(data.getOp());
        sbU2.append('.');
        Companion.log$default(companion2, logger2, sbU2.toString(), false, 2, null);
    }

    public static /* synthetic */ void send$default(GatewaySocket gatewaySocket, Outgoing outgoing, boolean z2, Gson gson, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            gson = gsonIncludeNulls;
            Intrinsics3.checkNotNullExpressionValue(gson, "gsonIncludeNulls");
        }
        gatewaySocket.send(outgoing, z2, gson);
    }

    private final void startHeartbeater() {
        this.heartbeater.cancel();
        this.heartbeatAck = true;
        this.heartbeater.postInterval(new AnonymousClass1(), this.heartbeatInterval);
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
        ArrayList<Tuples2<String, Integer>> arrayList = new ArrayList<>();
        flattenTraces(payload.getTrace(), arrayList);
        if (arrayList.size() > 0) {
            Tuples2<String, Integer> tuples2 = arrayList.get(0);
            String strComponent1 = tuples2.component1();
            iIntValue = tuples2.component2().intValue();
            if (!StringsJVM.startsWith$default(strComponent1, "gateway-", false, 2, null)) {
                iIntValue = 0;
            }
        } else {
            iIntValue = 0;
        }
        int i3 = 0;
        int i4 = 0;
        for (Tuples2<String, Integer> tuples3 : arrayList) {
            String strComponent2 = tuples3.component1();
            int iIntValue2 = tuples3.component2().intValue();
            if (Intrinsics3.areEqual(strComponent2, "start_session")) {
                i3 = iIntValue2;
            } else if (Intrinsics3.areEqual(strComponent2, "guilds_connect")) {
                i4 = iIntValue2;
            }
        }
        Function1<Map<String, ? extends Object>, Unit> function1 = this.trackReadyPayload;
        Companion companion = INSTANCE;
        function1.invoke(Maps6.mapOf(Tuples.to("duration_ms_since_connection_start", Long.valueOf(Companion.getDelay$default(companion, this.connectionStartTime, null, 2, null))), Tuples.to("duration_ms_since_identify_start", Long.valueOf(Companion.getDelay$default(companion, this.identifyStartTime, null, 2, null))), Tuples.to("identify_total_server_duration_ms", Integer.valueOf(iIntValue)), Tuples.to("identify_api_duration_ms", Integer.valueOf(i3)), Tuples.to("identify_guilds_duration_ms", Integer.valueOf(i4)), Tuples.to("compressed_byte_size", Integer.valueOf(compressedByteSize)), Tuples.to("uncompressed_byte_size", Integer.valueOf(uncompressedByteSize)), Tuples.to("compression_algorithm", "zlib"), Tuples.to("packing_algorithm", GATEWAY_ENCODING), Tuples.to("unpack_duration_ms", Long.valueOf(unpackDurationMs)), Tuples.to("is_reconnect", Boolean.valueOf(this.hasConnectedOnce)), Tuples.to("is_fast_connect", Boolean.FALSE), Tuples.to("num_guilds", Integer.valueOf(size)), Tuples.to("num_guild_channels", Integer.valueOf(i)), Tuples.to("num_guild_category_channels", Integer.valueOf(i2))));
    }

    public final void callConnect(long channelId) {
        schedule(new AnonymousClass1(channelId));
    }

    public final void close(boolean clean) {
        schedule(new AnonymousClass1(clean));
    }

    public final void connect() {
        schedule(new AnonymousClass1());
    }

    public final void expeditedHeartbeat(long timeout, String reason, boolean shouldResetBackoff) {
        schedule(new AnonymousClass1(reason, timeout, shouldResetBackoff));
    }

    public final ListenerCollection<Listener> getListeners() {
        return this.listeners;
    }

    public final boolean isSessionEstablished() {
        return this.connectionState == 5;
    }

    public final void presenceUpdate(ClientStatus status, Long since, List<Activity> activities, Boolean afk) {
        schedule(new AnonymousClass1(status, activities, since, afk));
    }

    public final void requestApplicationCommands(Outgoing2.ApplicationCommandRequest request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_GUILD_APPLICATION_COMMANDS, request);
        Gson gson = gsonOmitNulls;
        Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void requestForumUnreads(Outgoing2.ForumUnreadsRequest request) {
        Intrinsics3.checkNotNullParameter(request, "request");
        Outgoing outgoing = new Outgoing(Opcode.REQUEST_FORUM_UNREADS, request);
        Gson gson = gsonOmitNulls;
        Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
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
        Intrinsics3.checkNotNullParameter(guildIds, "guildIds");
        schedule(new AnonymousClass1(guildIds, query, userIds, limit));
    }

    public final void resetOnError() {
        schedule(new AnonymousClass1());
    }

    public final void simulateReconnectForTesting() {
        schedule(new AnonymousClass1());
    }

    public final void streamCreate(String streamType, long channelId, Long guildId, String preferredRegion) {
        Intrinsics3.checkNotNullParameter(streamType, "streamType");
        Companion.log$default(INSTANCE, this.logger, "Sending STREAM_CREATE: " + channelId + ' ' + guildId, false, 2, null);
        send$default(this, new Outgoing(Opcode.STREAM_CREATE, new Outgoing2.CreateStream(streamType, channelId, guildId, preferredRegion)), false, null, 6, null);
    }

    public final void streamDelete(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        schedule(new AnonymousClass1(streamKey));
    }

    public final void streamPing(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        schedule(new AnonymousClass1(streamKey));
    }

    public final void streamWatch(String streamKey) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        schedule(new AnonymousClass1(streamKey));
    }

    public final void updateGuildSubscriptions(long guildId, Outgoing2.GuildSubscriptions guildSubscriptions) {
        Intrinsics3.checkNotNullParameter(guildSubscriptions, "guildSubscriptions");
        Companion.log$default(INSTANCE, this.logger, "sending guild subscriptions: " + guildId + " -- " + guildSubscriptions, false, 2, null);
        Opcode opcode = Opcode.GUILD_SUBSCRIPTIONS;
        Boolean typing = guildSubscriptions.getTyping();
        Boolean activities = guildSubscriptions.getActivities();
        List<Long> members = guildSubscriptions.getMembers();
        Outgoing outgoing = new Outgoing(opcode, new Outgoing2.GuildSubscriptionsUpdate(guildId, typing, activities, members != null ? _Collections.toList(members) : null, guildSubscriptions.getChannels(), guildSubscriptions.getThreads(), guildSubscriptions.getThreadMemberLists()));
        Gson gson = gsonOmitNulls;
        Intrinsics3.checkNotNullExpressionValue(gson, "gsonOmitNulls");
        send$default(this, outgoing, false, gson, 2, null);
    }

    public final void voiceServerPing() {
        schedule(new AnonymousClass1());
    }

    public final void voiceStateUpdate(Long guildId, Long channelId, boolean selfMute, boolean selfDeaf, boolean selfVideo, String preferredRegion, boolean shouldIncludePreferredRegion) {
        schedule(new AnonymousClass1(guildId, channelId, selfMute, selfDeaf, preferredRegion, shouldIncludePreferredRegion, selfVideo));
    }

    private final void connect(final String gatewayUrl) {
        RawMessageHandler rawMessageHandler;
        if (this.connectionState != 1) {
            return;
        }
        this.connectionState = 2;
        Companion.log$default(INSTANCE, this.logger, outline.y("Connect to: ", gatewayUrl, ", encoding: json, version 9."), false, 2, null);
        cleanup(AnonymousClass2.INSTANCE);
        this.connectionStartTime = clock.currentTimeMillis();
        this.helloTimeout.schedule(new AnonymousClass3(), HELLO_TIMEOUT);
        WebSocket webSocket = new WebSocket(this.scheduler, new AnonymousClass4(this), this.sslSocketFactory);
        webSocket.setOnOpened(new GatewaySocket$connect$$inlined$apply$lambda$1(this, gatewayUrl));
        webSocket.setOnClosed(new GatewaySocket$connect$$inlined$apply$lambda$2(this, gatewayUrl));
        webSocket.setOnMessage(new GatewaySocket$connect$$inlined$apply$lambda$3(this, gatewayUrl));
        int iOrdinal = this.gatewaySocketLogger.getLogLevel().ordinal();
        if (iOrdinal == 0) {
            rawMessageHandler = null;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            rawMessageHandler = new RawMessageHandler() { // from class: com.discord.gateway.GatewaySocket$connect$$inlined$apply$lambda$4
                @Override // com.discord.utilities.websocket.RawMessageHandler
                public void onRawMessage(String rawMessage) {
                    Intrinsics3.checkNotNullParameter(rawMessage, "rawMessage");
                    this.this$0.gatewaySocketLogger.logInboundMessage(rawMessage);
                }

                @Override // com.discord.utilities.websocket.RawMessageHandler
                public void onRawMessageInflateFailed(Throwable throwable) {
                    Intrinsics3.checkNotNullParameter(throwable, "throwable");
                    this.this$0.gatewaySocketLogger.logMessageInflateFailed(throwable);
                }
            };
        }
        webSocket.setRawMessageHandler(rawMessageHandler);
        webSocket.setOnError(new GatewaySocket$connect$$inlined$apply$lambda$5(this, gatewayUrl));
        webSocket.connect(gatewayUrl + "/?encoding=json&v=9&compress=zlib-stream");
        this.webSocket = webSocket;
    }

    public /* synthetic */ GatewaySocket(Function0 function0, Function1 function1, GatewayEventHandler gatewayEventHandler, Scheduler scheduler, Logger logger, NetworkMonitor networkMonitor, RestConfig restConfig, Context context, Function1 function2, SSLSocketFactory sSLSocketFactory, Map map, GatewaySocketLogger gatewaySocketLogger, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, function1, gatewayEventHandler, scheduler, logger, networkMonitor, restConfig, context, (i & 256) != 0 ? null : function2, (i & 512) != 0 ? null : sSLSocketFactory, (i & 1024) != 0 ? Maps6.emptyMap() : map, gatewaySocketLogger);
    }
}
