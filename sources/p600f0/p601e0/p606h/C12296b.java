package p600f0.p601e0.p606h;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;
import p600f0.AbstractC12376t;
import p600f0.C12378v;
import p600f0.EnumC12381y;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p605g.C12283c;
import p600f0.p601e0.p605g.C12285e;
import p615g0.C12400q;
import p615g0.C12401r;
import p615g0.InterfaceC12405v;

/* JADX INFO: renamed from: f0.e0.h.b */
/* JADX INFO: compiled from: CallServerInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12296b implements Interceptor {

    /* JADX INFO: renamed from: b */
    public final boolean f25525b;

    public C12296b(boolean z2) {
        this.f25525b = z2;
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
        long jMo10103a;
        ResponseBody responseBody2;
        Response.C12937a c12937aM10171e;
        C12238m.checkParameterIsNotNull(chain, "chain");
        C12301g c12301g = (C12301g) chain;
        C12283c c12283c = c12301g.f25535e;
        if (c12283c == null) {
            C12238m.throwNpe();
        }
        Request request = c12301g.f25536f;
        RequestBody requestBody = request.body;
        long jCurrentTimeMillis = System.currentTimeMillis();
        Objects.requireNonNull(c12283c);
        C12238m.checkParameterIsNotNull(request, "request");
        try {
            AbstractC12376t abstractC12376t = c12283c.f25440d;
            C12285e c12285e = c12283c.f25439c;
            Objects.requireNonNull(abstractC12376t);
            C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
            c12283c.f25442f.mo10214b(request);
            AbstractC12376t abstractC12376t2 = c12283c.f25440d;
            C12285e c12285e2 = c12283c.f25439c;
            Objects.requireNonNull(abstractC12376t2);
            C12238m.checkParameterIsNotNull(c12285e2, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(request, "request");
            Response.C12937a c12937aM10171e2 = null;
            if (!C12300f.m10226a(request.method) || requestBody == null) {
                c12283c.f25439c.m10186k(c12283c, true, false, null);
                z2 = true;
            } else {
                if (C12103t.equals("100-continue", request.m10977b("Expect"), true)) {
                    c12283c.m10169c();
                    c12937aM10171e = c12283c.m10171e(true);
                    c12283c.m10172f();
                    z2 = false;
                } else {
                    z2 = true;
                    c12937aM10171e = null;
                }
                if (c12937aM10171e != null) {
                    c12283c.f25439c.m10186k(c12283c, true, false, null);
                    if (!c12283c.f25438b.m10201j()) {
                        c12283c.f25442f.mo10217e().m10203l();
                    }
                } else if (requestBody.isDuplex()) {
                    c12283c.m10169c();
                    InterfaceC12405v interfaceC12405vM10168b = c12283c.m10168b(request, true);
                    C12238m.checkParameterIsNotNull(interfaceC12405vM10168b, "$this$buffer");
                    requestBody.writeTo(new C12400q(interfaceC12405vM10168b));
                } else {
                    InterfaceC12405v interfaceC12405vM10168b2 = c12283c.m10168b(request, false);
                    C12238m.checkParameterIsNotNull(interfaceC12405vM10168b2, "$this$buffer");
                    C12400q c12400q = new C12400q(interfaceC12405vM10168b2);
                    requestBody.writeTo(c12400q);
                    c12400q.close();
                }
                c12937aM10171e2 = c12937aM10171e;
            }
            if (requestBody == null || !requestBody.isDuplex()) {
                try {
                    c12283c.f25442f.mo10213a();
                } catch (IOException e) {
                    AbstractC12376t abstractC12376t3 = c12283c.f25440d;
                    C12285e c12285e3 = c12283c.f25439c;
                    Objects.requireNonNull(abstractC12376t3);
                    C12238m.checkParameterIsNotNull(c12285e3, NotificationCompat.CATEGORY_CALL);
                    C12238m.checkParameterIsNotNull(e, "ioe");
                    c12283c.m10173g(e);
                    throw e;
                }
            }
            if (c12937aM10171e2 == null) {
                c12937aM10171e2 = c12283c.m10171e(false);
                if (c12937aM10171e2 == null) {
                    C12238m.throwNpe();
                }
                if (z2) {
                    c12283c.m10172f();
                    z2 = false;
                }
            }
            c12937aM10171e2.m10997g(request);
            c12937aM10171e2.f27569e = c12283c.f25438b.f25493d;
            c12937aM10171e2.f27575k = jCurrentTimeMillis;
            c12937aM10171e2.f27576l = System.currentTimeMillis();
            Response responseM10991a = c12937aM10171e2.m10991a();
            int i2 = responseM10991a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            if (i2 == 100) {
                Response.C12937a c12937aM10171e3 = c12283c.m10171e(false);
                if (c12937aM10171e3 == null) {
                    C12238m.throwNpe();
                }
                if (z2) {
                    c12283c.m10172f();
                }
                c12937aM10171e3.m10997g(request);
                c12937aM10171e3.f27569e = c12283c.f25438b.f25493d;
                c12937aM10171e3.f27575k = jCurrentTimeMillis;
                c12937aM10171e3.f27576l = System.currentTimeMillis();
                responseM10991a = c12937aM10171e3.m10991a();
                i2 = responseM10991a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            }
            C12238m.checkParameterIsNotNull(responseM10991a, "response");
            AbstractC12376t abstractC12376t4 = c12283c.f25440d;
            C12285e c12285e4 = c12283c.f25439c;
            Objects.requireNonNull(abstractC12376t4);
            C12238m.checkParameterIsNotNull(c12285e4, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(responseM10991a, "response");
            if (this.f25525b && i2 == 101) {
                C12238m.checkParameterIsNotNull(responseM10991a, "response");
                Request request2 = responseM10991a.request;
                EnumC12381y enumC12381y = responseM10991a.protocol;
                int i3 = responseM10991a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                String str = responseM10991a.message;
                C12378v c12378v = responseM10991a.handshake;
                Headers.C12930a c12930aM10956e = responseM10991a.headers.m10956e();
                Response response2 = responseM10991a.networkResponse;
                Response response3 = responseM10991a.cacheResponse;
                Response response4 = responseM10991a.priorResponse;
                long j = responseM10991a.sentRequestAtMillis;
                long j2 = responseM10991a.receivedResponseAtMillis;
                C12283c c12283c2 = responseM10991a.exchange;
                ResponseBody responseBody3 = C12272c.f25399c;
                if (!(i3 >= 0)) {
                    throw new IllegalStateException(C1643a.m871q("code < 0: ", i3).toString());
                }
                if (request2 == null) {
                    throw new IllegalStateException("request == null".toString());
                }
                if (enumC12381y == null) {
                    throw new IllegalStateException("protocol == null".toString());
                }
                if (str == null) {
                    throw new IllegalStateException("message == null".toString());
                }
                response = new Response(request2, enumC12381y, str, i3, c12378v, c12930aM10956e.m10960c(), responseBody3, response2, response3, response4, j, j2, c12283c2);
            } else {
                C12238m.checkParameterIsNotNull(responseM10991a, "response");
                Request request3 = responseM10991a.request;
                EnumC12381y enumC12381y2 = responseM10991a.protocol;
                int i4 = responseM10991a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
                String str2 = responseM10991a.message;
                C12378v c12378v2 = responseM10991a.handshake;
                Headers.C12930a c12930aM10956e2 = responseM10991a.headers.m10956e();
                Response response5 = responseM10991a.networkResponse;
                Response response6 = responseM10991a.cacheResponse;
                Response response7 = responseM10991a.priorResponse;
                long j3 = responseM10991a.sentRequestAtMillis;
                long j4 = responseM10991a.receivedResponseAtMillis;
                C12283c c12283c3 = responseM10991a.exchange;
                C12238m.checkParameterIsNotNull(responseM10991a, "response");
                try {
                    String strM10989a = Response.m10989a(responseM10991a, "Content-Type", null, 2);
                    long jMo10219g = c12283c.f25442f.mo10219g(responseM10991a);
                    C12283c.b bVar = new C12283c.b(c12283c, c12283c.f25442f.mo10215c(responseM10991a), jMo10219g);
                    C12238m.checkParameterIsNotNull(bVar, "$this$buffer");
                    C12302h c12302h = new C12302h(strM10989a, jMo10219g, new C12401r(bVar));
                    if (!(i4 >= 0)) {
                        throw new IllegalStateException(C1643a.m871q("code < 0: ", i4).toString());
                    }
                    if (request3 == null) {
                        throw new IllegalStateException("request == null".toString());
                    }
                    if (enumC12381y2 == null) {
                        throw new IllegalStateException("protocol == null".toString());
                    }
                    if (str2 == null) {
                        throw new IllegalStateException("message == null".toString());
                    }
                    response = new Response(request3, enumC12381y2, str2, i4, c12378v2, c12930aM10956e2.m10960c(), c12302h, response5, response6, response7, j3, j4, c12283c3);
                } catch (IOException e2) {
                    AbstractC12376t abstractC12376t5 = c12283c.f25440d;
                    C12285e c12285e5 = c12283c.f25439c;
                    Objects.requireNonNull(abstractC12376t5);
                    C12238m.checkParameterIsNotNull(c12285e5, NotificationCompat.CATEGORY_CALL);
                    C12238m.checkParameterIsNotNull(e2, "ioe");
                    c12283c.m10173g(e2);
                    throw e2;
                }
            }
            if (!C12103t.equals("close", response.request.m10977b("Connection"), true)) {
                lValueOf = null;
                if (C12103t.equals("close", Response.m10989a(response, "Connection", null, 2), true)) {
                }
                i = i2;
                if (i != 204 || i == 205) {
                    responseBody = response.body;
                    if (responseBody != null) {
                        jMo10103a = responseBody.mo10103a();
                    } else {
                        jMo10103a = -1;
                    }
                    if (jMo10103a > 0) {
                        StringBuilder sbM834V = C1643a.m834V("HTTP ", i, " had non-zero Content-Length: ");
                        responseBody2 = response.body;
                        if (responseBody2 != null) {
                            lValueOf = Long.valueOf(responseBody2.mo10103a());
                        }
                        sbM834V.append(lValueOf);
                        throw new ProtocolException(sbM834V.toString());
                    }
                }
                return response;
            }
            lValueOf = null;
            c12283c.f25442f.mo10217e().m10203l();
            i = i2;
            if (i != 204) {
                responseBody = response.body;
                if (responseBody != null) {
                    jMo10103a = responseBody.mo10103a();
                } else {
                    jMo10103a = -1;
                }
                if (jMo10103a > 0) {
                    StringBuilder sbM834V2 = C1643a.m834V("HTTP ", i, " had non-zero Content-Length: ");
                    responseBody2 = response.body;
                    if (responseBody2 != null) {
                        lValueOf = Long.valueOf(responseBody2.mo10103a());
                    }
                    sbM834V2.append(lValueOf);
                    throw new ProtocolException(sbM834V2.toString());
                }
            } else {
                responseBody = response.body;
                if (responseBody != null) {
                    jMo10103a = responseBody.mo10103a();
                } else {
                    jMo10103a = -1;
                }
                if (jMo10103a > 0) {
                    StringBuilder sbM834V3 = C1643a.m834V("HTTP ", i, " had non-zero Content-Length: ");
                    responseBody2 = response.body;
                    if (responseBody2 != null) {
                        lValueOf = Long.valueOf(responseBody2.mo10103a());
                    }
                    sbM834V3.append(lValueOf);
                    throw new ProtocolException(sbM834V3.toString());
                }
            }
            return response;
        } catch (IOException e3) {
            AbstractC12376t abstractC12376t6 = c12283c.f25440d;
            C12285e c12285e6 = c12283c.f25439c;
            Objects.requireNonNull(abstractC12376t6);
            C12238m.checkParameterIsNotNull(c12285e6, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(e3, "ioe");
            c12283c.m10173g(e3);
            throw e3;
        }
    }
}
