package f0.e0.h;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import f0.Address;
import f0.CertificatePinner;
import f0.EventListener;
import f0.Handshake;
import f0.HttpUrl;
import f0.OkHttpClient;
import f0.Protocol2;
import f0.Route;
import f0.e0.Util7;
import f0.e0.g.Exchange;
import f0.e0.g.ExchangeFinder;
import f0.e0.g.RealCall;
import f0.e0.g.RealConnection4;
import f0.e0.g.RealConnectionPool;
import f0.e0.g.RouteSelector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import kotlin.text.Regex;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

/* JADX INFO: renamed from: f0.e0.h.i, reason: use source file name */
/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OkHttpClient f3629b;

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        this.f3629b = okHttpClient;
    }

    public final Request a(Response response, Exchange exchange) throws IOException {
        String strA;
        RealConnection4 realConnection4;
        Route route = (exchange == null || (realConnection4 = exchange.f3614b) == null) ? null : realConnection4.q;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        Request request = response.request;
        String str = request.method;
        if (i != 307 && i != 308) {
            if (i == 401) {
                return this.f3629b.f3683s.a(route, response);
            }
            if (i == 421) {
                RequestBody requestBody = request.body;
                if ((requestBody != null && requestBody.isOneShot()) || exchange == null || !(!Intrinsics3.areEqual(exchange.e.h.a.g, exchange.f3614b.q.a.a.g))) {
                    return null;
                }
                RealConnection4 realConnection5 = exchange.f3614b;
                synchronized (realConnection5) {
                    realConnection5.j = true;
                }
                return response.request;
            }
            if (i == 503) {
                Response response2 = response.priorResponse;
                if ((response2 == null || response2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 503) && c(response, Integer.MAX_VALUE) == 0) {
                    return response.request;
                }
                return null;
            }
            if (i == 407) {
                if (route == null) {
                    Intrinsics3.throwNpe();
                }
                if (route.f3603b.type() == Proxy.Type.HTTP) {
                    return this.f3629b.f3686z.a(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (i == 408) {
                if (!this.f3629b.r) {
                    return null;
                }
                RequestBody requestBody2 = request.body;
                if (requestBody2 != null && requestBody2.isOneShot()) {
                    return null;
                }
                Response response3 = response.priorResponse;
                if ((response3 == null || response3.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 408) && c(response, 0) <= 0) {
                    return response.request;
                }
                return null;
            }
            switch (i) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f3629b.t || (strA = Response.a(response, "Location", null, 2)) == null) {
            return null;
        }
        HttpUrl httpUrl = response.request.url;
        Objects.requireNonNull(httpUrl);
        Intrinsics3.checkParameterIsNotNull(strA, "link");
        HttpUrl.a aVarG = httpUrl.g(strA);
        HttpUrl httpUrlB = aVarG != null ? aVarG.b() : null;
        if (httpUrlB == null) {
            return null;
        }
        if (!Intrinsics3.areEqual(httpUrlB.d, response.request.url.d) && !this.f3629b.u) {
            return null;
        }
        Request.a aVar = new Request.a(response.request);
        if (HttpMethod.a(str)) {
            int i2 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            Intrinsics3.checkParameterIsNotNull(str, "method");
            boolean z2 = Intrinsics3.areEqual(str, "PROPFIND") || i2 == 308 || i2 == 307;
            Intrinsics3.checkParameterIsNotNull(str, "method");
            if (!(!Intrinsics3.areEqual(str, "PROPFIND")) || i2 == 308 || i2 == 307) {
                aVar.c(str, z2 ? response.request.body : null);
            } else {
                aVar.c(ShareTarget.METHOD_GET, null);
            }
            if (!z2) {
                aVar.d("Transfer-Encoding");
                aVar.d("Content-Length");
                aVar.d("Content-Type");
            }
        }
        if (!Util7.a(response.request.url, httpUrlB)) {
            aVar.d("Authorization");
        }
        aVar.g(httpUrlB);
        return aVar.a();
    }

    public final boolean b(IOException iOException, RealCall realCall, Request request, boolean z2) {
        boolean zA;
        RouteSelector routeSelector;
        RealConnection4 realConnection4;
        if (!this.f3629b.r) {
            return false;
        }
        if (z2) {
            RequestBody requestBody = request.body;
            if ((requestBody != null && requestBody.isOneShot()) || (iOException instanceof FileNotFoundException)) {
                return false;
            }
        }
        if (!(!(iOException instanceof ProtocolException) && (!(iOException instanceof InterruptedIOException) ? ((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException) : !((iOException instanceof SocketTimeoutException) && !z2)))) {
            return false;
        }
        ExchangeFinder exchangeFinder = realCall.o;
        if (exchangeFinder == null) {
            Intrinsics3.throwNpe();
        }
        int i = exchangeFinder.c;
        if (i == 0 && exchangeFinder.d == 0 && exchangeFinder.e == 0) {
            zA = false;
        } else if (exchangeFinder.f != null) {
            zA = true;
        } else {
            Route route = null;
            if (i <= 1 && exchangeFinder.d <= 1 && exchangeFinder.e <= 0 && (realConnection4 = exchangeFinder.i.p) != null) {
                synchronized (realConnection4) {
                    if (realConnection4.k == 0 && Util7.a(realConnection4.q.a.a, exchangeFinder.h.a)) {
                        route = realConnection4.q;
                    }
                }
            }
            if (route != null) {
                exchangeFinder.f = route;
            } else {
                RouteSelector.a aVar = exchangeFinder.a;
                if ((aVar == null || !aVar.a()) && (routeSelector = exchangeFinder.f3615b) != null) {
                    zA = routeSelector.a();
                }
            }
            zA = true;
        }
        return zA;
    }

    public final int c(Response response, int i) {
        String strA = Response.a(response, "Retry-After", null, 2);
        if (strA == null) {
            return i;
        }
        if (!new Regex("\\d+").matches(strA)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        Intrinsics3.checkExpressionValueIsNotNull(numValueOf, "Integer.valueOf(header)");
        return numValueOf.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11, types: [f0.e0.g.e] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [f0.e0.g.e] */
    /* JADX WARN: Type inference failed for: r1v14, types: [f0.e0.g.e] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v41, types: [f0.e0.g.e] */
    /* JADX WARN: Type inference failed for: r1v44 */
    /* JADX WARN: Type inference failed for: r1v45 */
    /* JADX WARN: Type inference failed for: r1v46 */
    /* JADX WARN: Type inference failed for: r1v47 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [f0.e0.g.e] */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r21v2 */
    /* JADX WARN: Type inference failed for: r21v3 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    /* JADX WARN: Type inference failed for: r2v10, types: [f0.e0.h.i] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12, types: [f0.e0.h.i] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v19, types: [f0.e0.h.i] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v1, types: [f0.e0.g.e, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v18 */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Throwable {
        ?? r1;
        List listPlus;
        boolean z2;
        ?? r2;
        ?? r21;
        ?? r22;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        ?? r3 = this;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.f;
        RealCall realCall = realInterceptorChain.f3628b;
        boolean z3 = true;
        List listEmptyList = Collections2.emptyList();
        Response response = null;
        int i = 0;
        Request request2 = request;
        boolean z4 = true;
        ?? r4 = realCall;
        while (true) {
            Objects.requireNonNull(r4);
            Intrinsics3.checkParameterIsNotNull(request2, "request");
            if (!(r4.r == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            synchronized (r4) {
                try {
                    try {
                        if (!(r4.t ^ z3)) {
                            throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                        }
                        if (!(r4.f3616s ^ z3)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = r4;
                }
                throw th;
            }
            if (z4) {
                RealConnectionPool realConnectionPool = r4.j;
                HttpUrl httpUrl = request2.url;
                if (httpUrl.c) {
                    OkHttpClient okHttpClient = r4.f3618y;
                    SSLSocketFactory sSLSocketFactory2 = okHttpClient.B;
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("CLEARTEXT-only client");
                    }
                    HostnameVerifier hostnameVerifier2 = okHttpClient.F;
                    certificatePinner = okHttpClient.G;
                    sSLSocketFactory = sSLSocketFactory2;
                    hostnameVerifier = hostnameVerifier2;
                } else {
                    sSLSocketFactory = null;
                    hostnameVerifier = null;
                    certificatePinner = null;
                }
                String str = httpUrl.g;
                int i2 = httpUrl.h;
                OkHttpClient okHttpClient2 = r4.f3618y;
                Address address = new Address(str, i2, okHttpClient2.w, okHttpClient2.A, sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient2.f3686z, okHttpClient2.f3684x, okHttpClient2.E, okHttpClient2.D, okHttpClient2.f3685y);
                EventListener eventListener = r4.k;
                r4.o = new ExchangeFinder(realConnectionPool, address, r4, eventListener);
                r1 = eventListener;
            } else {
                r1 = r3;
            }
            try {
                if (r4.v) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        Response responseA = realInterceptorChain.a(request2);
                        if (response != 0) {
                            try {
                                Intrinsics3.checkParameterIsNotNull(responseA, "response");
                                Request request3 = responseA.request;
                                Protocol2 protocol2 = responseA.protocol;
                                int i3 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                String str2 = responseA.message;
                                Handshake handshake = responseA.handshake;
                                Headers.a aVarE = responseA.headers.e();
                                ResponseBody responseBody = responseA.body;
                                Response response2 = responseA.networkResponse;
                                Response response3 = responseA.cacheResponse;
                                long j = responseA.sentRequestAtMillis;
                                r21 = r4;
                                try {
                                    long j2 = responseA.receivedResponseAtMillis;
                                    Exchange exchange = responseA.exchange;
                                    Response response4 = response;
                                    Intrinsics3.checkParameterIsNotNull(response4, "response");
                                    Request request4 = response4.request;
                                    Protocol2 protocol3 = response4.protocol;
                                    int i4 = response4.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                    String str3 = response4.message;
                                    Handshake handshake2 = response4.handshake;
                                    Headers.a aVarE2 = response4.headers.e();
                                    Response response5 = response4.networkResponse;
                                    Response response6 = response4.cacheResponse;
                                    Response response7 = response4.priorResponse;
                                    long j3 = response4.sentRequestAtMillis;
                                    long j4 = response4.receivedResponseAtMillis;
                                    Exchange exchange2 = response4.exchange;
                                    if (!(i4 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i4).toString());
                                    }
                                    if (request4 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (protocol3 == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str3 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    Response response8 = new Response(request4, protocol3, str3, i4, handshake2, aVarE2.c(), null, response5, response6, response7, j3, j4, exchange2);
                                    if (!(response8.body == null)) {
                                        throw new IllegalArgumentException("priorResponse.body != null".toString());
                                    }
                                    if (!(i3 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i3).toString());
                                    }
                                    if (request3 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (protocol2 == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str2 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    responseA = new Response(request3, protocol2, str2, i3, handshake, aVarE.c(), responseBody, response2, response3, response8, j, j2, exchange);
                                    r22 = r21;
                                } catch (Throwable th3) {
                                    th = th3;
                                    r1 = r21;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                r21 = r4;
                            }
                        } else {
                            r22 = r4;
                        }
                        response = responseA;
                        r1 = r22;
                        try {
                            Exchange exchange3 = r1.r;
                            r2 = this;
                            try {
                                Request requestA = r2.a(response, exchange3);
                                if (requestA == null) {
                                    if (exchange3 != null && exchange3.a) {
                                        r1.n();
                                    }
                                    r1.i(false);
                                    return response;
                                }
                                RequestBody requestBody = requestA.body;
                                if (requestBody != null && requestBody.isOneShot()) {
                                    r1.i(false);
                                    return response;
                                }
                                ResponseBody responseBody2 = response.body;
                                if (responseBody2 != null) {
                                    byte[] bArr = Util7.a;
                                    Intrinsics3.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
                                    try {
                                        responseBody2.close();
                                    } catch (RuntimeException e) {
                                        throw e;
                                    } catch (Exception unused) {
                                    }
                                }
                                i++;
                                if (i > 20) {
                                    throw new ProtocolException("Too many follow-up requests: " + i);
                                }
                                r1.i(true);
                                request2 = requestA;
                                listEmptyList = listEmptyList;
                                z4 = true;
                                r4 = r1;
                                r3 = r2;
                                realInterceptorChain = realInterceptorChain;
                                z3 = true;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (IOException e2) {
                        ?? r5 = r4;
                        ?? r6 = this;
                        if (!r6.b(e2, r5, request2, !(e2 instanceof ConnectionShutdownException))) {
                            Util7.D(e2, listEmptyList);
                            throw e2;
                        }
                        listPlus = _Collections.plus((Collection<? extends IOException>) listEmptyList, e2);
                        z2 = true;
                        r1 = r5;
                        r2 = r6;
                        r1.i(z2);
                        listEmptyList = listPlus;
                        response = response;
                        i = i;
                        z4 = false;
                    }
                } catch (RouteException e3) {
                    ?? r7 = r4;
                    List list = listEmptyList;
                    ?? r8 = this;
                    if (!r8.b(e3.getLastConnectException(), r7, request2, false)) {
                        IOException firstConnectException = e3.getFirstConnectException();
                        Util7.D(firstConnectException, list);
                        throw firstConnectException;
                    }
                    listPlus = _Collections.plus((Collection<? extends IOException>) list, e3.getFirstConnectException());
                    z2 = true;
                    r1 = r7;
                    r2 = r8;
                    r1.i(z2);
                    listEmptyList = listPlus;
                    response = response;
                    i = i;
                    z4 = false;
                }
            } catch (Throwable th7) {
                th = th7;
                r1 = r4;
            }
            r1.i(true);
            throw th;
        }
    }
}
