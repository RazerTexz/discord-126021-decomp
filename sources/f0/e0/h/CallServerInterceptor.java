package f0.e0.h;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import f0.EventListener;
import f0.Handshake;
import f0.Protocol2;
import f0.e0.Util7;
import f0.e0.g.Exchange;
import f0.e0.g.RealCall;
import g0.RealBufferedSink;
import g0.RealBufferedSource;
import g0.Sink;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: f0.e0.h.b, reason: use source file name */
/* JADX INFO: compiled from: CallServerInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CallServerInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3625b;

    public CallServerInterceptor(boolean z2) {
        this.f3625b = z2;
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0278  */
    /* JADX WARN: Code duplicated, block: B:86:0x027c  */
    /* JADX WARN: Code duplicated, block: B:87:0x0281  */
    /* JADX WARN: Code duplicated, block: B:90:0x0289  */
    /* JADX WARN: Code duplicated, block: B:92:0x0297  */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Throwable {
        boolean z2;
        Response response;
        Long lValueOf;
        int i;
        ResponseBody responseBody;
        long jA;
        ResponseBody responseBody2;
        Response.a aVarE;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Exchange exchange = realInterceptorChain.e;
        if (exchange == null) {
            Intrinsics3.throwNpe();
        }
        Request request = realInterceptorChain.f;
        RequestBody requestBody = request.body;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Objects.requireNonNull(exchange);
        Intrinsics3.checkParameterIsNotNull(request, "request");
        try {
            EventListener eventListener = exchange.d;
            RealCall realCall = exchange.c;
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            exchange.f.b(request);
            EventListener eventListener2 = exchange.d;
            RealCall realCall2 = exchange.c;
            Objects.requireNonNull(eventListener2);
            Intrinsics3.checkParameterIsNotNull(realCall2, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(request, "request");
            Response.a aVarE2 = null;
            if (!HttpMethod.a(request.method) || requestBody == null) {
                exchange.c.k(exchange, true, false, null);
                z2 = true;
            } else {
                if (StringsJVM.equals("100-continue", request.b("Expect"), true)) {
                    exchange.c();
                    aVarE = exchange.e(true);
                    exchange.f();
                    z2 = false;
                } else {
                    z2 = true;
                    aVarE = null;
                }
                if (aVarE != null) {
                    exchange.c.k(exchange, true, false, null);
                    if (!exchange.f3614b.j()) {
                        exchange.f.e().l();
                    }
                } else if (requestBody.isDuplex()) {
                    exchange.c();
                    Sink sinkB = exchange.b(request, true);
                    Intrinsics3.checkParameterIsNotNull(sinkB, "$this$buffer");
                    requestBody.writeTo(new RealBufferedSink(sinkB));
                } else {
                    Sink sinkB2 = exchange.b(request, false);
                    Intrinsics3.checkParameterIsNotNull(sinkB2, "$this$buffer");
                    RealBufferedSink realBufferedSink = new RealBufferedSink(sinkB2);
                    requestBody.writeTo(realBufferedSink);
                    realBufferedSink.close();
                }
                aVarE2 = aVarE;
            }
            if (requestBody == null || !requestBody.isDuplex()) {
                try {
                    exchange.f.a();
                } catch (IOException e) {
                    EventListener eventListener3 = exchange.d;
                    RealCall realCall3 = exchange.c;
                    Objects.requireNonNull(eventListener3);
                    Intrinsics3.checkParameterIsNotNull(realCall3, NotificationCompat.CATEGORY_CALL);
                    Intrinsics3.checkParameterIsNotNull(e, "ioe");
                    exchange.g(e);
                    throw e;
                }
            }
            if (aVarE2 == null) {
                aVarE2 = exchange.e(false);
                if (aVarE2 == null) {
                    Intrinsics3.throwNpe();
                }
                if (z2) {
                    exchange.f();
                    z2 = false;
                }
            }
            aVarE2.g(request);
            aVarE2.e = exchange.f3614b.d;
            aVarE2.k = jCurrentTimeMillis;
            aVarE2.l = System.currentTimeMillis();
            Response responseA = aVarE2.a();
            int i2 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            if (i2 == 100) {
                Response.a aVarE3 = exchange.e(false);
                if (aVarE3 == null) {
                    Intrinsics3.throwNpe();
                }
                if (z2) {
                    exchange.f();
                }
                aVarE3.g(request);
                aVarE3.e = exchange.f3614b.d;
                aVarE3.k = jCurrentTimeMillis;
                aVarE3.l = System.currentTimeMillis();
                responseA = aVarE3.a();
                i2 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            }
            Intrinsics3.checkParameterIsNotNull(responseA, "response");
            EventListener eventListener4 = exchange.d;
            RealCall realCall4 = exchange.c;
            Objects.requireNonNull(eventListener4);
            Intrinsics3.checkParameterIsNotNull(realCall4, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(responseA, "response");
            if (this.f3625b && i2 == 101) {
                Intrinsics3.checkParameterIsNotNull(responseA, "response");
                Request request2 = responseA.request;
                Protocol2 protocol2 = responseA.protocol;
                int i3 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                String str = responseA.message;
                Handshake handshake = responseA.handshake;
                Headers.a aVarE4 = responseA.headers.e();
                Response response2 = responseA.networkResponse;
                Response response3 = responseA.cacheResponse;
                Response response4 = responseA.priorResponse;
                long j = responseA.sentRequestAtMillis;
                long j2 = responseA.receivedResponseAtMillis;
                Exchange exchange2 = responseA.exchange;
                ResponseBody responseBody3 = Util7.c;
                if (!(i3 >= 0)) {
                    throw new IllegalStateException(outline.q("code < 0: ", i3).toString());
                }
                if (request2 == null) {
                    throw new IllegalStateException("request == null".toString());
                }
                if (protocol2 == null) {
                    throw new IllegalStateException("protocol == null".toString());
                }
                if (str == null) {
                    throw new IllegalStateException("message == null".toString());
                }
                response = new Response(request2, protocol2, str, i3, handshake, aVarE4.c(), responseBody3, response2, response3, response4, j, j2, exchange2);
            } else {
                Intrinsics3.checkParameterIsNotNull(responseA, "response");
                Request request3 = responseA.request;
                Protocol2 protocol3 = responseA.protocol;
                int i4 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                String str2 = responseA.message;
                Handshake handshake2 = responseA.handshake;
                Headers.a aVarE5 = responseA.headers.e();
                Response response5 = responseA.networkResponse;
                Response response6 = responseA.cacheResponse;
                Response response7 = responseA.priorResponse;
                long j3 = responseA.sentRequestAtMillis;
                long j4 = responseA.receivedResponseAtMillis;
                Exchange exchange3 = responseA.exchange;
                Intrinsics3.checkParameterIsNotNull(responseA, "response");
                try {
                    String strA = Response.a(responseA, "Content-Type", null, 2);
                    long jG = exchange.f.g(responseA);
                    Exchange.b bVar = new Exchange.b(exchange, exchange.f.c(responseA), jG);
                    Intrinsics3.checkParameterIsNotNull(bVar, "$this$buffer");
                    RealResponseBody realResponseBody = new RealResponseBody(strA, jG, new RealBufferedSource(bVar));
                    if (!(i4 >= 0)) {
                        throw new IllegalStateException(outline.q("code < 0: ", i4).toString());
                    }
                    if (request3 == null) {
                        throw new IllegalStateException("request == null".toString());
                    }
                    if (protocol3 == null) {
                        throw new IllegalStateException("protocol == null".toString());
                    }
                    if (str2 == null) {
                        throw new IllegalStateException("message == null".toString());
                    }
                    response = new Response(request3, protocol3, str2, i4, handshake2, aVarE5.c(), realResponseBody, response5, response6, response7, j3, j4, exchange3);
                } catch (IOException e2) {
                    EventListener eventListener5 = exchange.d;
                    RealCall realCall5 = exchange.c;
                    Objects.requireNonNull(eventListener5);
                    Intrinsics3.checkParameterIsNotNull(realCall5, NotificationCompat.CATEGORY_CALL);
                    Intrinsics3.checkParameterIsNotNull(e2, "ioe");
                    exchange.g(e2);
                    throw e2;
                }
            }
            if (!StringsJVM.equals("close", response.request.b("Connection"), true)) {
                lValueOf = null;
                if (StringsJVM.equals("close", Response.a(response, "Connection", null, 2), true)) {
                }
                i = i2;
                if (i != 204 || i == 205) {
                    responseBody = response.body;
                    if (responseBody != null) {
                        jA = responseBody.a();
                    } else {
                        jA = -1;
                    }
                    if (jA > 0) {
                        StringBuilder sbV = outline.V("HTTP ", i, " had non-zero Content-Length: ");
                        responseBody2 = response.body;
                        if (responseBody2 != null) {
                            lValueOf = Long.valueOf(responseBody2.a());
                        }
                        sbV.append(lValueOf);
                        throw new ProtocolException(sbV.toString());
                    }
                }
                return response;
            }
            lValueOf = null;
            exchange.f.e().l();
            i = i2;
            if (i != 204) {
                responseBody = response.body;
                if (responseBody != null) {
                    jA = responseBody.a();
                } else {
                    jA = -1;
                }
                if (jA > 0) {
                    StringBuilder sbV2 = outline.V("HTTP ", i, " had non-zero Content-Length: ");
                    responseBody2 = response.body;
                    if (responseBody2 != null) {
                        lValueOf = Long.valueOf(responseBody2.a());
                    }
                    sbV2.append(lValueOf);
                    throw new ProtocolException(sbV2.toString());
                }
            } else {
                responseBody = response.body;
                if (responseBody != null) {
                    jA = responseBody.a();
                } else {
                    jA = -1;
                }
                if (jA > 0) {
                    StringBuilder sbV3 = outline.V("HTTP ", i, " had non-zero Content-Length: ");
                    responseBody2 = response.body;
                    if (responseBody2 != null) {
                        lValueOf = Long.valueOf(responseBody2.a());
                    }
                    sbV3.append(lValueOf);
                    throw new ProtocolException(sbV3.toString());
                }
            }
            return response;
        } catch (IOException e3) {
            EventListener eventListener6 = exchange.d;
            RealCall realCall6 = exchange.c;
            Objects.requireNonNull(eventListener6);
            Intrinsics3.checkParameterIsNotNull(realCall6, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(e3, "ioe");
            exchange.g(e3);
            throw e3;
        }
    }
}
