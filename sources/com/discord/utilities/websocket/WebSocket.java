package com.discord.utilities.websocket;

import androidx.core.view.PointerIconCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import f0.e0.k.h;
import f0.e0.k.h$a;
import f0.x;
import f0.x$a;
import j0.p.a;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import okhttp3.Request$a;
import okhttp3.Response;
import okhttp3.WebSocketListener;
import rx.Observable;
import rx.Scheduler;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WebSocket.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WebSocket {
    private static final int CLOSE_NORMAL = 1000;
    public static final WebSocket$Companion Companion = new WebSocket$Companion(null);
    private okhttp3.WebSocket client;
    private final Function3<String, Exception, Map<String, String>, Unit> errorLogger;
    private Function1<? super WebSocket$Closed, Unit> onClosed;
    private Function1<? super WebSocket$Error, Unit> onError;
    private Function2<? super InputStreamReader, ? super Integer, Unit> onMessage;
    private Function1<? super WebSocket$Opened, Unit> onOpened;
    private RawMessageHandler rawMessageHandler;
    private final PublishSubject<Function0<Unit>> schedulerSubject;
    private final SSLSocketFactory socketFactory;
    private WebSocket$State state;

    /* JADX WARN: Multi-variable type inference failed */
    public WebSocket(Scheduler scheduler, Function3<? super String, ? super Exception, ? super Map<String, String>, Unit> function3, SSLSocketFactory sSLSocketFactory) {
        m.checkNotNullParameter(function3, "errorLogger");
        this.errorLogger = function3;
        this.socketFactory = sSLSocketFactory;
        PublishSubject<Function0<Unit>> publishSubjectK0 = PublishSubject.k0();
        this.schedulerSubject = publishSubjectK0;
        this.onOpened = WebSocket$onOpened$1.INSTANCE;
        this.onClosed = WebSocket$onClosed$1.INSTANCE;
        this.onMessage = WebSocket$onMessage$1.INSTANCE;
        this.onError = WebSocket$onError$1.INSTANCE;
        this.state = WebSocket$State.NOT_YET_CONNECTED;
        Observable<Function0<Unit>> observableK = publishSubjectK0.K();
        if (scheduler == null) {
            AtomicReference<a> atomicReference = a.a;
            scheduler = j0.l.c.m.a;
        }
        observableK.J(scheduler).W(WebSocket$1.INSTANCE, new WebSocket$2(this));
    }

    public static final /* synthetic */ okhttp3.WebSocket access$getClient$p(WebSocket webSocket) {
        return webSocket.client;
    }

    public static final /* synthetic */ Function3 access$getErrorLogger$p(WebSocket webSocket) {
        return webSocket.errorLogger;
    }

    public static final /* synthetic */ WebSocket$State access$getState$p(WebSocket webSocket) {
        return webSocket.state;
    }

    public static final /* synthetic */ void access$handleOnFailure(WebSocket webSocket, Throwable th, Response response, boolean z2) {
        webSocket.handleOnFailure(th, response, z2);
    }

    public static final /* synthetic */ void access$schedule(WebSocket webSocket, Function0 function0) {
        webSocket.schedule(function0);
    }

    public static final /* synthetic */ void access$setClient$p(WebSocket webSocket, okhttp3.WebSocket webSocket2) {
        webSocket.client = webSocket2;
    }

    public static final /* synthetic */ void access$setState$p(WebSocket webSocket, WebSocket$State webSocket$State) {
        webSocket.state = webSocket$State;
    }

    private final okhttp3.WebSocket createWebSocket(String url, SSLSocketFactory socketFactory, WebSocketListener listener) {
        x$a x_a = new x$a();
        if (socketFactory != null) {
            h$a h_a = h.c;
            x_a.b(socketFactory, h.a.n());
        }
        x_a.a(1L, TimeUnit.MINUTES);
        x xVar = new x(x_a);
        Request$a request$a = new Request$a();
        request$a.f(url);
        return xVar.g(request$a.a(), listener);
    }

    public static /* synthetic */ void disconnect$default(WebSocket webSocket, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1000;
        }
        if ((i2 & 2) != 0) {
            str = null;
        }
        webSocket.disconnect(i, str);
    }

    private final void handleOnFailure(Throwable throwable, Response response, boolean closed) {
        if (closed) {
            this.state = WebSocket$State.CLOSED;
        } else {
            disconnect(PointerIconCompat.TYPE_COPY, "Closing due to failure " + throwable + ", " + response);
        }
        this.onError.invoke(new WebSocket$Error(throwable, response));
    }

    private final void schedule(Function0<Unit> callback) {
        this.schedulerSubject.k.onNext(callback);
    }

    public final void connect(String url) {
        m.checkNotNullParameter(url, "url");
        disconnect(1000, "Closing existing connection.");
        this.state = WebSocket$State.CONNECTING;
        this.client = createWebSocket(url, this.socketFactory, new ZLibWebSocketListener(new WebSocket$connect$1(this)));
    }

    public final void disconnect() {
        disconnect$default(this, 0, null, 3, null);
    }

    public final void disconnect(int i) {
        disconnect$default(this, i, null, 2, null);
    }

    public final void disconnect(int code, String reason) {
        okhttp3.WebSocket webSocket = this.client;
        if (webSocket != null) {
            this.state = WebSocket$State.CLOSING;
            try {
                try {
                    webSocket.e(code, reason);
                } catch (Exception e) {
                    handleOnFailure(e, null, true);
                }
            } finally {
                this.client = null;
            }
        }
    }

    public final Function1<WebSocket$Closed, Unit> getOnClosed() {
        return this.onClosed;
    }

    public final Function1<WebSocket$Error, Unit> getOnError() {
        return this.onError;
    }

    public final Function2<InputStreamReader, Integer, Unit> getOnMessage() {
        return this.onMessage;
    }

    public final Function1<WebSocket$Opened, Unit> getOnOpened() {
        return this.onOpened;
    }

    public final RawMessageHandler getRawMessageHandler() {
        return this.rawMessageHandler;
    }

    public final WebSocket$State getState() {
        return this.state;
    }

    public final void message(String message) {
        m.checkNotNullParameter(message, "message");
        okhttp3.WebSocket webSocket = this.client;
        if (webSocket == null || this.state != WebSocket$State.CONNECTED) {
            return;
        }
        try {
            webSocket.a(message);
        } catch (IllegalStateException e) {
            handleOnFailure(e, null, true);
        }
    }

    public final void resetListeners() {
        this.onOpened = WebSocket$resetListeners$1.INSTANCE;
        this.onClosed = WebSocket$resetListeners$2.INSTANCE;
        this.onMessage = WebSocket$resetListeners$3.INSTANCE;
        this.rawMessageHandler = null;
        this.onError = WebSocket$resetListeners$4.INSTANCE;
    }

    public final void setOnClosed(Function1<? super WebSocket$Closed, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClosed = function1;
    }

    public final void setOnError(Function1<? super WebSocket$Error, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onError = function1;
    }

    public final void setOnMessage(Function2<? super InputStreamReader, ? super Integer, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onMessage = function2;
    }

    public final void setOnOpened(Function1<? super WebSocket$Opened, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onOpened = function1;
    }

    public final void setRawMessageHandler(RawMessageHandler rawMessageHandler) {
        this.rawMessageHandler = rawMessageHandler;
    }
}
