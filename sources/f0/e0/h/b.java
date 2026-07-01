package f0.e0.h;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import f0.e0.g.c$b;
import f0.t;
import f0.y;
import g0.q;
import g0.r;
import g0.v;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import okhttp3.Headers$a;
import okhttp3.Interceptor;
import okhttp3.Interceptor$Chain;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response$a;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: CallServerInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3625b;

    public b(boolean z2) {
        this.f3625b = z2;
    }

    /* JADX WARN: Code duplicated, block: B:84:0x0278  */
    /* JADX WARN: Code duplicated, block: B:86:0x027c  */
    /* JADX WARN: Code duplicated, block: B:87:0x0281  */
    /* JADX WARN: Code duplicated, block: B:90:0x0289  */
    /* JADX WARN: Code duplicated, block: B:92:0x0297  */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor$Chain interceptor$Chain) throws Throwable {
        boolean z2;
        Response response;
        Long lValueOf;
        int i;
        ResponseBody responseBody;
        long jA;
        ResponseBody responseBody2;
        Response$a response$aE;
        m.checkParameterIsNotNull(interceptor$Chain, "chain");
        g gVar = (g) interceptor$Chain;
        f0.e0.g.c cVar = gVar.e;
        if (cVar == null) {
            m.throwNpe();
        }
        Request request = gVar.f;
        RequestBody requestBody = request.body;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Objects.requireNonNull(cVar);
        m.checkParameterIsNotNull(request, "request");
        try {
            t tVar = cVar.d;
            f0.e0.g.e eVar = cVar.c;
            Objects.requireNonNull(tVar);
            m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            cVar.f.b(request);
            t tVar2 = cVar.d;
            f0.e0.g.e eVar2 = cVar.c;
            Objects.requireNonNull(tVar2);
            m.checkParameterIsNotNull(eVar2, NotificationCompat.CATEGORY_CALL);
            m.checkParameterIsNotNull(request, "request");
            Response$a response$aE2 = null;
            if (!f.a(request.method) || requestBody == null) {
                cVar.c.k(cVar, true, false, null);
                z2 = true;
            } else {
                if (d0.g0.t.equals("100-continue", request.b("Expect"), true)) {
                    cVar.c();
                    response$aE = cVar.e(true);
                    cVar.f();
                    z2 = false;
                } else {
                    z2 = true;
                    response$aE = null;
                }
                if (response$aE != null) {
                    cVar.c.k(cVar, true, false, null);
                    if (!cVar.f3614b.j()) {
                        cVar.f.e().l();
                    }
                } else if (requestBody.isDuplex()) {
                    cVar.c();
                    v vVarB = cVar.b(request, true);
                    m.checkParameterIsNotNull(vVarB, "$this$buffer");
                    requestBody.writeTo(new q(vVarB));
                } else {
                    v vVarB2 = cVar.b(request, false);
                    m.checkParameterIsNotNull(vVarB2, "$this$buffer");
                    q qVar = new q(vVarB2);
                    requestBody.writeTo(qVar);
                    qVar.close();
                }
                response$aE2 = response$aE;
            }
            if (requestBody == null || !requestBody.isDuplex()) {
                try {
                    cVar.f.a();
                } catch (IOException e) {
                    t tVar3 = cVar.d;
                    f0.e0.g.e eVar3 = cVar.c;
                    Objects.requireNonNull(tVar3);
                    m.checkParameterIsNotNull(eVar3, NotificationCompat.CATEGORY_CALL);
                    m.checkParameterIsNotNull(e, "ioe");
                    cVar.g(e);
                    throw e;
                }
            }
            if (response$aE2 == null) {
                response$aE2 = cVar.e(false);
                if (response$aE2 == null) {
                    m.throwNpe();
                }
                if (z2) {
                    cVar.f();
                    z2 = false;
                }
            }
            response$aE2.g(request);
            response$aE2.e = cVar.f3614b.d;
            response$aE2.k = jCurrentTimeMillis;
            response$aE2.l = System.currentTimeMillis();
            Response responseA = response$aE2.a();
            int i2 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            if (i2 == 100) {
                Response$a response$aE3 = cVar.e(false);
                if (response$aE3 == null) {
                    m.throwNpe();
                }
                if (z2) {
                    cVar.f();
                }
                response$aE3.g(request);
                response$aE3.e = cVar.f3614b.d;
                response$aE3.k = jCurrentTimeMillis;
                response$aE3.l = System.currentTimeMillis();
                responseA = response$aE3.a();
                i2 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            }
            m.checkParameterIsNotNull(responseA, "response");
            t tVar4 = cVar.d;
            f0.e0.g.e eVar4 = cVar.c;
            Objects.requireNonNull(tVar4);
            m.checkParameterIsNotNull(eVar4, NotificationCompat.CATEGORY_CALL);
            m.checkParameterIsNotNull(responseA, "response");
            if (this.f3625b && i2 == 101) {
                m.checkParameterIsNotNull(responseA, "response");
                Request request2 = responseA.request;
                y yVar = responseA.protocol;
                int i3 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                String str = responseA.message;
                f0.v vVar = responseA.handshake;
                Headers$a headers$aE = responseA.headers.e();
                Response response2 = responseA.networkResponse;
                Response response3 = responseA.cacheResponse;
                Response response4 = responseA.priorResponse;
                long j = responseA.sentRequestAtMillis;
                long j2 = responseA.receivedResponseAtMillis;
                f0.e0.g.c cVar2 = responseA.exchange;
                ResponseBody responseBody3 = f0.e0.c.c;
                if (!(i3 >= 0)) {
                    throw new IllegalStateException(b.d.b.a.a.q("code < 0: ", i3).toString());
                }
                if (request2 == null) {
                    throw new IllegalStateException("request == null".toString());
                }
                if (yVar == null) {
                    throw new IllegalStateException("protocol == null".toString());
                }
                if (str == null) {
                    throw new IllegalStateException("message == null".toString());
                }
                response = new Response(request2, yVar, str, i3, vVar, headers$aE.c(), responseBody3, response2, response3, response4, j, j2, cVar2);
            } else {
                m.checkParameterIsNotNull(responseA, "response");
                Request request3 = responseA.request;
                y yVar2 = responseA.protocol;
                int i4 = responseA.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                String str2 = responseA.message;
                f0.v vVar2 = responseA.handshake;
                Headers$a headers$aE2 = responseA.headers.e();
                Response response5 = responseA.networkResponse;
                Response response6 = responseA.cacheResponse;
                Response response7 = responseA.priorResponse;
                long j3 = responseA.sentRequestAtMillis;
                long j4 = responseA.receivedResponseAtMillis;
                f0.e0.g.c cVar3 = responseA.exchange;
                m.checkParameterIsNotNull(responseA, "response");
                try {
                    String strA = Response.a(responseA, "Content-Type", null, 2);
                    long jG = cVar.f.g(responseA);
                    c$b c_b = new c$b(cVar, cVar.f.c(responseA), jG);
                    m.checkParameterIsNotNull(c_b, "$this$buffer");
                    h hVar = new h(strA, jG, new r(c_b));
                    if (!(i4 >= 0)) {
                        throw new IllegalStateException(b.d.b.a.a.q("code < 0: ", i4).toString());
                    }
                    if (request3 == null) {
                        throw new IllegalStateException("request == null".toString());
                    }
                    if (yVar2 == null) {
                        throw new IllegalStateException("protocol == null".toString());
                    }
                    if (str2 == null) {
                        throw new IllegalStateException("message == null".toString());
                    }
                    response = new Response(request3, yVar2, str2, i4, vVar2, headers$aE2.c(), hVar, response5, response6, response7, j3, j4, cVar3);
                } catch (IOException e2) {
                    t tVar5 = cVar.d;
                    f0.e0.g.e eVar5 = cVar.c;
                    Objects.requireNonNull(tVar5);
                    m.checkParameterIsNotNull(eVar5, NotificationCompat.CATEGORY_CALL);
                    m.checkParameterIsNotNull(e2, "ioe");
                    cVar.g(e2);
                    throw e2;
                }
            }
            if (!d0.g0.t.equals("close", response.request.b("Connection"), true)) {
                lValueOf = null;
                if (d0.g0.t.equals("close", Response.a(response, "Connection", null, 2), true)) {
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
                        StringBuilder sbV = b.d.b.a.a.V("HTTP ", i, " had non-zero Content-Length: ");
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
            cVar.f.e().l();
            i = i2;
            if (i != 204) {
                responseBody = response.body;
                if (responseBody != null) {
                    jA = responseBody.a();
                } else {
                    jA = -1;
                }
                if (jA > 0) {
                    StringBuilder sbV2 = b.d.b.a.a.V("HTTP ", i, " had non-zero Content-Length: ");
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
                    StringBuilder sbV3 = b.d.b.a.a.V("HTTP ", i, " had non-zero Content-Length: ");
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
            t tVar6 = cVar.d;
            f0.e0.g.e eVar6 = cVar.c;
            Objects.requireNonNull(tVar6);
            m.checkParameterIsNotNull(eVar6, NotificationCompat.CATEGORY_CALL);
            m.checkParameterIsNotNull(e3, "ioe");
            cVar.g(e3);
            throw e3;
        }
    }
}
