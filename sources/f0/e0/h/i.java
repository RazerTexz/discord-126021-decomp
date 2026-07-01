package f0.e0.h;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import f0.c0;
import f0.e0.g.k;
import f0.e0.g.m$a;
import f0.t;
import f0.v;
import f0.w;
import f0.w$a;
import f0.x;
import f0.y;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy$Type;
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
import okhttp3.Headers$a;
import okhttp3.Interceptor;
import okhttp3.Interceptor$Chain;
import okhttp3.Request;
import okhttp3.Request$a;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f3629b;

    public i(x xVar) {
        m.checkParameterIsNotNull(xVar, "client");
        this.f3629b = xVar;
    }

    public final Request a(Response response, f0.e0.g.c cVar) throws IOException {
        String strA;
        f0.e0.g.j jVar;
        c0 c0Var = (cVar == null || (jVar = cVar.f3614b) == null) ? null : jVar.q;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        Request request = response.request;
        String str = request.method;
        if (i != 307 && i != 308) {
            if (i == 401) {
                return this.f3629b.f3683s.a(c0Var, response);
            }
            if (i == 421) {
                RequestBody requestBody = request.body;
                if ((requestBody != null && requestBody.isOneShot()) || cVar == null || !(!m.areEqual(cVar.e.h.a.g, cVar.f3614b.q.a.a.g))) {
                    return null;
                }
                f0.e0.g.j jVar2 = cVar.f3614b;
                synchronized (jVar2) {
                    jVar2.j = true;
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
                if (c0Var == null) {
                    m.throwNpe();
                }
                if (c0Var.f3603b.type() == Proxy$Type.HTTP) {
                    return this.f3629b.f3686z.a(c0Var, response);
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
        w wVar = response.request.url;
        Objects.requireNonNull(wVar);
        m.checkParameterIsNotNull(strA, "link");
        w$a w_aG = wVar.g(strA);
        w wVarB = w_aG != null ? w_aG.b() : null;
        if (wVarB == null) {
            return null;
        }
        if (!m.areEqual(wVarB.d, response.request.url.d) && !this.f3629b.u) {
            return null;
        }
        Request$a request$a = new Request$a(response.request);
        if (f.a(str)) {
            int i2 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            m.checkParameterIsNotNull(str, "method");
            boolean z2 = m.areEqual(str, "PROPFIND") || i2 == 308 || i2 == 307;
            m.checkParameterIsNotNull(str, "method");
            if (!(!m.areEqual(str, "PROPFIND")) || i2 == 308 || i2 == 307) {
                request$a.c(str, z2 ? response.request.body : null);
            } else {
                request$a.c(ShareTarget.METHOD_GET, null);
            }
            if (!z2) {
                request$a.d("Transfer-Encoding");
                request$a.d("Content-Length");
                request$a.d("Content-Type");
            }
        }
        if (!f0.e0.c.a(response.request.url, wVarB)) {
            request$a.d("Authorization");
        }
        request$a.g(wVarB);
        return request$a.a();
    }

    public final boolean b(IOException iOException, f0.e0.g.e eVar, Request request, boolean z2) {
        boolean zA;
        f0.e0.g.m mVar;
        f0.e0.g.j jVar;
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
        f0.e0.g.d dVar = eVar.o;
        if (dVar == null) {
            m.throwNpe();
        }
        int i = dVar.c;
        if (i == 0 && dVar.d == 0 && dVar.e == 0) {
            zA = false;
        } else if (dVar.f != null) {
            zA = true;
        } else {
            c0 c0Var = null;
            if (i <= 1 && dVar.d <= 1 && dVar.e <= 0 && (jVar = dVar.i.p) != null) {
                synchronized (jVar) {
                    if (jVar.k == 0 && f0.e0.c.a(jVar.q.a.a, dVar.h.a)) {
                        c0Var = jVar.q;
                    }
                }
            }
            if (c0Var != null) {
                dVar.f = c0Var;
            } else {
                m$a m_a = dVar.a;
                if ((m_a == null || !m_a.a()) && (mVar = dVar.f3615b) != null) {
                    zA = mVar.a();
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
        m.checkExpressionValueIsNotNull(numValueOf, "Integer.valueOf(header)");
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
    public Response intercept(Interceptor$Chain interceptor$Chain) throws Throwable {
        ?? r1;
        List listPlus;
        boolean z2;
        ?? r2;
        ?? r21;
        ?? r22;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        f0.g gVar;
        ?? r3 = this;
        m.checkParameterIsNotNull(interceptor$Chain, "chain");
        g gVar2 = (g) interceptor$Chain;
        Request request = gVar2.f;
        f0.e0.g.e eVar = gVar2.f3628b;
        boolean z3 = true;
        List listEmptyList = n.emptyList();
        Response response = null;
        int i = 0;
        Request request2 = request;
        boolean z4 = true;
        ?? r4 = eVar;
        while (true) {
            Objects.requireNonNull(r4);
            m.checkParameterIsNotNull(request2, "request");
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
                k kVar = r4.j;
                w wVar = request2.url;
                if (wVar.c) {
                    x xVar = r4.f3618y;
                    SSLSocketFactory sSLSocketFactory2 = xVar.B;
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("CLEARTEXT-only client");
                    }
                    HostnameVerifier hostnameVerifier2 = xVar.F;
                    gVar = xVar.G;
                    sSLSocketFactory = sSLSocketFactory2;
                    hostnameVerifier = hostnameVerifier2;
                } else {
                    sSLSocketFactory = null;
                    hostnameVerifier = null;
                    gVar = null;
                }
                String str = wVar.g;
                int i2 = wVar.h;
                x xVar2 = r4.f3618y;
                f0.a aVar = new f0.a(str, i2, xVar2.w, xVar2.A, sSLSocketFactory, hostnameVerifier, gVar, xVar2.f3686z, xVar2.f3684x, xVar2.E, xVar2.D, xVar2.f3685y);
                t tVar = r4.k;
                r4.o = new f0.e0.g.d(kVar, aVar, r4, tVar);
                r1 = tVar;
            } else {
                r1 = r3;
            }
            try {
                if (r4.v) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        Response responseA = gVar2.a(request2);
                        if (response != 0) {
                            try {
                                m.checkParameterIsNotNull(responseA, "response");
                                Request request3 = responseA.request;
                                y yVar = responseA.protocol;
                                int i3 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                String str2 = responseA.message;
                                v vVar = responseA.handshake;
                                Headers$a headers$aE = responseA.headers.e();
                                ResponseBody responseBody = responseA.body;
                                Response response2 = responseA.networkResponse;
                                Response response3 = responseA.cacheResponse;
                                long j = responseA.sentRequestAtMillis;
                                r21 = r4;
                                try {
                                    long j2 = responseA.receivedResponseAtMillis;
                                    f0.e0.g.c cVar = responseA.exchange;
                                    Response response4 = response;
                                    m.checkParameterIsNotNull(response4, "response");
                                    Request request4 = response4.request;
                                    y yVar2 = response4.protocol;
                                    int i4 = response4.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                    String str3 = response4.message;
                                    v vVar2 = response4.handshake;
                                    Headers$a headers$aE2 = response4.headers.e();
                                    Response response5 = response4.networkResponse;
                                    Response response6 = response4.cacheResponse;
                                    Response response7 = response4.priorResponse;
                                    long j3 = response4.sentRequestAtMillis;
                                    long j4 = response4.receivedResponseAtMillis;
                                    f0.e0.g.c cVar2 = response4.exchange;
                                    if (!(i4 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i4).toString());
                                    }
                                    if (request4 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (yVar2 == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str3 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    Response response8 = new Response(request4, yVar2, str3, i4, vVar2, headers$aE2.c(), null, response5, response6, response7, j3, j4, cVar2);
                                    if (!(response8.body == null)) {
                                        throw new IllegalArgumentException("priorResponse.body != null".toString());
                                    }
                                    if (!(i3 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i3).toString());
                                    }
                                    if (request3 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (yVar == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str2 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    responseA = new Response(request3, yVar, str2, i3, vVar, headers$aE.c(), responseBody, response2, response3, response8, j, j2, cVar);
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
                            f0.e0.g.c cVar3 = r1.r;
                            r2 = this;
                            try {
                                Request requestA = r2.a(response, cVar3);
                                if (requestA == null) {
                                    if (cVar3 != null && cVar3.a) {
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
                                    byte[] bArr = f0.e0.c.a;
                                    m.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
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
                                gVar2 = gVar2;
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
                            f0.e0.c.D(e2, listEmptyList);
                            throw e2;
                        }
                        listPlus = u.plus((Collection<? extends IOException>) listEmptyList, e2);
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
                        f0.e0.c.D(firstConnectException, list);
                        throw firstConnectException;
                    }
                    listPlus = u.plus((Collection<? extends IOException>) list, e3.getFirstConnectException());
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
