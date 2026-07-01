package okhttp3;

import b.d.b.a.a;
import d0.z.d.m;
import f0.e0.g.c;
import f0.v;
import f0.y;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Response$a {
    public Request a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public y f3816b;
    public int c;
    public String d;
    public v e;
    public Headers$a f;
    public ResponseBody g;
    public Response h;
    public Response i;
    public Response j;
    public long k;
    public long l;
    public c m;

    public Response$a() {
        this.c = -1;
        this.f = new Headers$a();
    }

    public Response a() {
        int i = this.c;
        if (!(i >= 0)) {
            StringBuilder sbU = a.U("code < 0: ");
            sbU.append(this.c);
            throw new IllegalStateException(sbU.toString().toString());
        }
        Request request = this.a;
        if (request == null) {
            throw new IllegalStateException("request == null".toString());
        }
        y yVar = this.f3816b;
        if (yVar == null) {
            throw new IllegalStateException("protocol == null".toString());
        }
        String str = this.d;
        if (str != null) {
            return new Response(request, yVar, str, i, this.e, this.f.c(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
        }
        throw new IllegalStateException("message == null".toString());
    }

    public Response$a b(Response response) {
        c("cacheResponse", response);
        this.i = response;
        return this;
    }

    public final void c(String str, Response response) {
        if (response != null) {
            if (!(response.body == null)) {
                throw new IllegalArgumentException(a.w(str, ".body != null").toString());
            }
            if (!(response.networkResponse == null)) {
                throw new IllegalArgumentException(a.w(str, ".networkResponse != null").toString());
            }
            if (!(response.cacheResponse == null)) {
                throw new IllegalArgumentException(a.w(str, ".cacheResponse != null").toString());
            }
            if (!(response.priorResponse == null)) {
                throw new IllegalArgumentException(a.w(str, ".priorResponse != null").toString());
            }
        }
    }

    public Response$a d(Headers headers) {
        m.checkParameterIsNotNull(headers, "headers");
        this.f = headers.e();
        return this;
    }

    public Response$a e(String str) {
        m.checkParameterIsNotNull(str, "message");
        this.d = str;
        return this;
    }

    public Response$a f(y yVar) {
        m.checkParameterIsNotNull(yVar, "protocol");
        this.f3816b = yVar;
        return this;
    }

    public Response$a g(Request request) {
        m.checkParameterIsNotNull(request, "request");
        this.a = request;
        return this;
    }

    public Response$a(Response response) {
        m.checkParameterIsNotNull(response, "response");
        this.c = -1;
        this.a = response.request;
        this.f3816b = response.protocol;
        this.c = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        this.d = response.message;
        this.e = response.handshake;
        this.f = response.headers.e();
        this.g = response.body;
        this.h = response.networkResponse;
        this.i = response.cacheResponse;
        this.j = response.priorResponse;
        this.k = response.sentRequestAtMillis;
        this.l = response.receivedResponseAtMillis;
        this.m = response.exchange;
    }
}
