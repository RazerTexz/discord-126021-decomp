package p600f0.p601e0.p606h;

import androidx.browser.trusted.sharing.ShareTarget;
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
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;
import p600f0.AbstractC12376t;
import p600f0.C12261a;
import p600f0.C12266c0;
import p600f0.C12363g;
import p600f0.C12378v;
import p600f0.C12379w;
import p600f0.C12380x;
import p600f0.EnumC12381y;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p605g.C12283c;
import p600f0.p601e0.p605g.C12284d;
import p600f0.p601e0.p605g.C12285e;
import p600f0.p601e0.p605g.C12290j;
import p600f0.p601e0.p605g.C12291k;
import p600f0.p601e0.p605g.C12293m;

/* JADX INFO: renamed from: f0.e0.h.i */
/* JADX INFO: compiled from: RetryAndFollowUpInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12303i implements Interceptor {

    /* JADX INFO: renamed from: b */
    public final C12380x f25543b;

    public C12303i(C12380x c12380x) {
        C12238m.checkParameterIsNotNull(c12380x, "client");
        this.f25543b = c12380x;
    }

    /* JADX INFO: renamed from: a */
    public final Request m10231a(Response response, C12283c c12283c) throws IOException {
        String strM10989a;
        C12290j c12290j;
        C12266c0 c12266c0 = (c12283c == null || (c12290j = c12283c.f25438b) == null) ? null : c12290j.f25506q;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        Request request = response.request;
        String str = request.method;
        if (i != 307 && i != 308) {
            if (i == 401) {
                return this.f25543b.f26018s.mo10102a(c12266c0, response);
            }
            if (i == 421) {
                RequestBody requestBody = request.body;
                if ((requestBody != null && requestBody.isOneShot()) || c12283c == null || !(!C12238m.areEqual(c12283c.f25441e.f25461h.f25353a.f25979g, c12283c.f25438b.f25506q.f25370a.f25353a.f25979g))) {
                    return null;
                }
                C12290j c12290j2 = c12283c.f25438b;
                synchronized (c12290j2) {
                    c12290j2.f25499j = true;
                }
                return response.request;
            }
            if (i == 503) {
                Response response2 = response.priorResponse;
                if ((response2 == null || response2.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 503) && m10233c(response, Integer.MAX_VALUE) == 0) {
                    return response.request;
                }
                return null;
            }
            if (i == 407) {
                if (c12266c0 == null) {
                    C12238m.throwNpe();
                }
                if (c12266c0.f25371b.type() == Proxy.Type.HTTP) {
                    return this.f25543b.f26025z.mo10102a(c12266c0, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (i == 408) {
                if (!this.f25543b.f26017r) {
                    return null;
                }
                RequestBody requestBody2 = request.body;
                if (requestBody2 != null && requestBody2.isOneShot()) {
                    return null;
                }
                Response response3 = response.priorResponse;
                if ((response3 == null || response3.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String != 408) && m10233c(response, 0) <= 0) {
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
        if (!this.f25543b.f26019t || (strM10989a = Response.m10989a(response, "Location", null, 2)) == null) {
            return null;
        }
        C12379w c12379w = response.request.url;
        Objects.requireNonNull(c12379w);
        C12238m.checkParameterIsNotNull(strM10989a, "link");
        C12379w.a aVarM10405g = c12379w.m10405g(strM10989a);
        C12379w c12379wM10409b = aVarM10405g != null ? aVarM10405g.m10409b() : null;
        if (c12379wM10409b == null) {
            return null;
        }
        if (!C12238m.areEqual(c12379wM10409b.f25976d, response.request.url.f25976d) && !this.f25543b.f26020u) {
            return null;
        }
        Request.C12935a c12935a = new Request.C12935a(response.request);
        if (C12300f.m10226a(str)) {
            int i2 = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            C12238m.checkParameterIsNotNull(str, "method");
            boolean z2 = C12238m.areEqual(str, "PROPFIND") || i2 == 308 || i2 == 307;
            C12238m.checkParameterIsNotNull(str, "method");
            if (!(!C12238m.areEqual(str, "PROPFIND")) || i2 == 308 || i2 == 307) {
                c12935a.m10980c(str, z2 ? response.request.body : null);
            } else {
                c12935a.m10980c(ShareTarget.METHOD_GET, null);
            }
            if (!z2) {
                c12935a.m10981d("Transfer-Encoding");
                c12935a.m10981d("Content-Length");
                c12935a.m10981d("Content-Type");
            }
        }
        if (!C12272c.m10120a(response.request.url, c12379wM10409b)) {
            c12935a.m10981d("Authorization");
        }
        c12935a.m10984g(c12379wM10409b);
        return c12935a.m10978a();
    }

    /* JADX INFO: renamed from: b */
    public final boolean m10232b(IOException iOException, C12285e c12285e, Request request, boolean z2) {
        boolean zM10209a;
        C12293m c12293m;
        C12290j c12290j;
        if (!this.f25543b.f26017r) {
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
        C12284d c12284d = c12285e.f25470o;
        if (c12284d == null) {
            C12238m.throwNpe();
        }
        int i = c12284d.f25456c;
        if (i == 0 && c12284d.f25457d == 0 && c12284d.f25458e == 0) {
            zM10209a = false;
        } else if (c12284d.f25459f != null) {
            zM10209a = true;
        } else {
            C12266c0 c12266c0 = null;
            if (i <= 1 && c12284d.f25457d <= 1 && c12284d.f25458e <= 0 && (c12290j = c12284d.f25462i.f25471p) != null) {
                synchronized (c12290j) {
                    if (c12290j.f25500k == 0 && C12272c.m10120a(c12290j.f25506q.f25370a.f25353a, c12284d.f25461h.f25353a)) {
                        c12266c0 = c12290j.f25506q;
                    }
                }
            }
            if (c12266c0 != null) {
                c12284d.f25459f = c12266c0;
            } else {
                C12293m.a aVar = c12284d.f25454a;
                if ((aVar == null || !aVar.m10211a()) && (c12293m = c12284d.f25455b) != null) {
                    zM10209a = c12293m.m10209a();
                }
            }
            zM10209a = true;
        }
        return zM10209a;
    }

    /* JADX INFO: renamed from: c */
    public final int m10233c(Response response, int i) {
        String strM10989a = Response.m10989a(response, "Retry-After", null, 2);
        if (strM10989a == null) {
            return i;
        }
        if (!new Regex("\\d+").matches(strM10989a)) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strM10989a);
        C12238m.checkExpressionValueIsNotNull(numValueOf, "Integer.valueOf(header)");
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
        C12363g c12363g;
        ?? r3 = this;
        C12238m.checkParameterIsNotNull(chain, "chain");
        C12301g c12301g = (C12301g) chain;
        Request request = c12301g.f25536f;
        C12285e c12285e = c12301g.f25532b;
        boolean z3 = true;
        List listEmptyList = C12147n.emptyList();
        Response response = null;
        int i = 0;
        Request request2 = request;
        boolean z4 = true;
        ?? r4 = c12285e;
        while (true) {
            Objects.requireNonNull(r4);
            C12238m.checkParameterIsNotNull(request2, "request");
            if (!(r4.f25473r == null)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            synchronized (r4) {
                try {
                    try {
                        if (!(r4.f25475t ^ z3)) {
                            throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                        }
                        if (!(r4.f25474s ^ z3)) {
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
                C12291k c12291k = r4.f25465j;
                C12379w c12379w = request2.url;
                if (c12379w.f25975c) {
                    C12380x c12380x = r4.f25480y;
                    SSLSocketFactory sSLSocketFactory2 = c12380x.f25998B;
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("CLEARTEXT-only client");
                    }
                    HostnameVerifier hostnameVerifier2 = c12380x.f26002F;
                    c12363g = c12380x.f26003G;
                    sSLSocketFactory = sSLSocketFactory2;
                    hostnameVerifier = hostnameVerifier2;
                } else {
                    sSLSocketFactory = null;
                    hostnameVerifier = null;
                    c12363g = null;
                }
                String str = c12379w.f25979g;
                int i2 = c12379w.f25980h;
                C12380x c12380x2 = r4.f25480y;
                C12261a c12261a = new C12261a(str, i2, c12380x2.f26022w, c12380x2.f25997A, sSLSocketFactory, hostnameVerifier, c12363g, c12380x2.f26025z, c12380x2.f26023x, c12380x2.f26001E, c12380x2.f26000D, c12380x2.f26024y);
                AbstractC12376t abstractC12376t = r4.f25466k;
                r4.f25470o = new C12284d(c12291k, c12261a, r4, abstractC12376t);
                r1 = abstractC12376t;
            } else {
                r1 = r3;
            }
            try {
                if (r4.f25477v) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        Response responseMo10228a = c12301g.mo10228a(request2);
                        if (response != 0) {
                            try {
                                C12238m.checkParameterIsNotNull(responseMo10228a, "response");
                                Request request3 = responseMo10228a.request;
                                EnumC12381y enumC12381y = responseMo10228a.protocol;
                                int i3 = responseMo10228a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                String str2 = responseMo10228a.message;
                                C12378v c12378v = responseMo10228a.handshake;
                                Headers.C12930a c12930aM10956e = responseMo10228a.headers.m10956e();
                                ResponseBody responseBody = responseMo10228a.body;
                                Response response2 = responseMo10228a.networkResponse;
                                Response response3 = responseMo10228a.cacheResponse;
                                long j = responseMo10228a.sentRequestAtMillis;
                                r21 = r4;
                                try {
                                    long j2 = responseMo10228a.receivedResponseAtMillis;
                                    C12283c c12283c = responseMo10228a.exchange;
                                    Response response4 = response;
                                    C12238m.checkParameterIsNotNull(response4, "response");
                                    Request request4 = response4.request;
                                    EnumC12381y enumC12381y2 = response4.protocol;
                                    int i4 = response4.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                                    String str3 = response4.message;
                                    C12378v c12378v2 = response4.handshake;
                                    Headers.C12930a c12930aM10956e2 = response4.headers.m10956e();
                                    Response response5 = response4.networkResponse;
                                    Response response6 = response4.cacheResponse;
                                    Response response7 = response4.priorResponse;
                                    long j3 = response4.sentRequestAtMillis;
                                    long j4 = response4.receivedResponseAtMillis;
                                    C12283c c12283c2 = response4.exchange;
                                    if (!(i4 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i4).toString());
                                    }
                                    if (request4 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (enumC12381y2 == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str3 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    Response response8 = new Response(request4, enumC12381y2, str3, i4, c12378v2, c12930aM10956e2.m10960c(), null, response5, response6, response7, j3, j4, c12283c2);
                                    if (!(response8.body == null)) {
                                        throw new IllegalArgumentException("priorResponse.body != null".toString());
                                    }
                                    if (!(i3 >= 0)) {
                                        throw new IllegalStateException(("code < 0: " + i3).toString());
                                    }
                                    if (request3 == null) {
                                        throw new IllegalStateException("request == null".toString());
                                    }
                                    if (enumC12381y == null) {
                                        throw new IllegalStateException("protocol == null".toString());
                                    }
                                    if (str2 == null) {
                                        throw new IllegalStateException("message == null".toString());
                                    }
                                    responseMo10228a = new Response(request3, enumC12381y, str2, i3, c12378v, c12930aM10956e.m10960c(), responseBody, response2, response3, response8, j, j2, c12283c);
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
                        response = responseMo10228a;
                        r1 = r22;
                        try {
                            C12283c c12283c3 = r1.f25473r;
                            r2 = this;
                            try {
                                Request requestM10231a = r2.m10231a(response, c12283c3);
                                if (requestM10231a == null) {
                                    if (c12283c3 != null && c12283c3.f25437a) {
                                        r1.m10189n();
                                    }
                                    r1.m10184i(false);
                                    return response;
                                }
                                RequestBody requestBody = requestM10231a.body;
                                if (requestBody != null && requestBody.isOneShot()) {
                                    r1.m10184i(false);
                                    return response;
                                }
                                ResponseBody responseBody2 = response.body;
                                if (responseBody2 != null) {
                                    byte[] bArr = C12272c.f25397a;
                                    C12238m.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
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
                                r1.m10184i(true);
                                request2 = requestM10231a;
                                listEmptyList = listEmptyList;
                                z4 = true;
                                r4 = r1;
                                r3 = r2;
                                c12301g = c12301g;
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
                        if (!r6.m10232b(e2, r5, request2, !(e2 instanceof ConnectionShutdownException))) {
                            C12272c.m10119D(e2, listEmptyList);
                            throw e2;
                        }
                        listPlus = C12163u.plus((Collection<? extends IOException>) listEmptyList, e2);
                        z2 = true;
                        r1 = r5;
                        r2 = r6;
                        r1.m10184i(z2);
                        listEmptyList = listPlus;
                        response = response;
                        i = i;
                        z4 = false;
                    }
                } catch (RouteException e3) {
                    ?? r7 = r4;
                    List list = listEmptyList;
                    ?? r8 = this;
                    if (!r8.m10232b(e3.getLastConnectException(), r7, request2, false)) {
                        IOException firstConnectException = e3.getFirstConnectException();
                        C12272c.m10119D(firstConnectException, list);
                        throw firstConnectException;
                    }
                    listPlus = C12163u.plus((Collection<? extends IOException>) list, e3.getFirstConnectException());
                    z2 = true;
                    r1 = r7;
                    r2 = r8;
                    r1.m10184i(z2);
                    listEmptyList = listPlus;
                    response = response;
                    i = i;
                    z4 = false;
                }
            } catch (Throwable th7) {
                th = th7;
                r1 = r4;
            }
            r1.m10184i(true);
            throw th;
        }
    }
}
