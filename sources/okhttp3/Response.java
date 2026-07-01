package okhttp3;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import f0.Handshake;
import f0.Protocol2;
import f0.e0.g.Exchange;
import java.io.Closeable;
import java.util.Objects;
import okhttp3.Headers;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Response implements Closeable {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Request request;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final Protocol2 protocol;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final String message;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final int code;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final Handshake handshake;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final Headers headers;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final ResponseBody body;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final Response networkResponse;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final Response cacheResponse;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public final Response priorResponse;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final long sentRequestAtMillis;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public final long receivedResponseAtMillis;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final Exchange exchange;

    public Response(Request request, Protocol2 protocol2, String str, int i, Handshake handshake, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j2, Exchange exchange) {
        Intrinsics3.checkParameterIsNotNull(request, "request");
        Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
        Intrinsics3.checkParameterIsNotNull(str, "message");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        this.request = request;
        this.protocol = protocol2;
        this.message = str;
        this.code = i;
        this.handshake = handshake;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = exchange;
    }

    public static String a(Response response, String str, String str2, int i) {
        int i2 = i & 2;
        Objects.requireNonNull(response);
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strC = response.headers.c(str);
        if (strC != null) {
            return strC;
        }
        return null;
    }

    public final boolean b() {
        int i = this.code;
        return 200 <= i && 299 >= i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ResponseBody responseBody = this.body;
        if (responseBody == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed".toString());
        }
        responseBody.close();
    }

    public String toString() {
        StringBuilder sbU = outline.U("Response{protocol=");
        sbU.append(this.protocol);
        sbU.append(", code=");
        sbU.append(this.code);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", url=");
        sbU.append(this.request.url);
        sbU.append('}');
        return sbU.toString();
    }

    /* JADX INFO: compiled from: Response.kt */
    public static class a {
        public Request a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Protocol2 f3816b;
        public int c;
        public String d;
        public Handshake e;
        public Headers.a f;
        public ResponseBody g;
        public Response h;
        public Response i;
        public Response j;
        public long k;
        public long l;
        public Exchange m;

        public a() {
            this.c = -1;
            this.f = new Headers.a();
        }

        public Response a() {
            int i = this.c;
            if (!(i >= 0)) {
                StringBuilder sbU = outline.U("code < 0: ");
                sbU.append(this.c);
                throw new IllegalStateException(sbU.toString().toString());
            }
            Request request = this.a;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            Protocol2 protocol2 = this.f3816b;
            if (protocol2 == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.d;
            if (str != null) {
                return new Response(request, protocol2, str, i, this.e, this.f.c(), this.g, this.h, this.i, this.j, this.k, this.l, this.m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public a b(Response response) {
            c("cacheResponse", response);
            this.i = response;
            return this;
        }

        public final void c(String str, Response response) {
            if (response != null) {
                if (!(response.body == null)) {
                    throw new IllegalArgumentException(outline.w(str, ".body != null").toString());
                }
                if (!(response.networkResponse == null)) {
                    throw new IllegalArgumentException(outline.w(str, ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse == null)) {
                    throw new IllegalArgumentException(outline.w(str, ".cacheResponse != null").toString());
                }
                if (!(response.priorResponse == null)) {
                    throw new IllegalArgumentException(outline.w(str, ".priorResponse != null").toString());
                }
            }
        }

        public a d(Headers headers) {
            Intrinsics3.checkParameterIsNotNull(headers, "headers");
            this.f = headers.e();
            return this;
        }

        public a e(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "message");
            this.d = str;
            return this;
        }

        public a f(Protocol2 protocol2) {
            Intrinsics3.checkParameterIsNotNull(protocol2, "protocol");
            this.f3816b = protocol2;
            return this;
        }

        public a g(Request request) {
            Intrinsics3.checkParameterIsNotNull(request, "request");
            this.a = request;
            return this;
        }

        public a(Response response) {
            Intrinsics3.checkParameterIsNotNull(response, "response");
            this.c = -1;
            this.a = response.request;
            this.f3816b = response.protocol;
            this.c = response.code;
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
}
