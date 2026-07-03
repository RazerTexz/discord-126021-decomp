package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Closeable;
import java.util.Objects;
import okhttp3.Headers;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12378v;
import p600f0.EnumC12381y;
import p600f0.p601e0.p605g.C12283c;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Response implements Closeable {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Request request;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final EnumC12381y protocol;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final String message;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final int code;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final C12378v handshake;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public final Headers headers;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public final ResponseBody body;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public final Response networkResponse;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public final Response cacheResponse;

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public final Response priorResponse;

    /* JADX INFO: renamed from: t, reason: from kotlin metadata */
    public final long sentRequestAtMillis;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public final long receivedResponseAtMillis;

    /* JADX INFO: renamed from: v, reason: from kotlin metadata */
    public final C12283c exchange;

    public Response(Request request, EnumC12381y enumC12381y, String str, int i, C12378v c12378v, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j2, C12283c c12283c) {
        C12238m.checkParameterIsNotNull(request, "request");
        C12238m.checkParameterIsNotNull(enumC12381y, "protocol");
        C12238m.checkParameterIsNotNull(str, "message");
        C12238m.checkParameterIsNotNull(headers, "headers");
        this.request = request;
        this.protocol = enumC12381y;
        this.message = str;
        this.code = i;
        this.handshake = c12378v;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = c12283c;
    }

    /* JADX INFO: renamed from: a */
    public static String m10989a(Response response, String str, String str2, int i) {
        int i2 = i & 2;
        Objects.requireNonNull(response);
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        String strM10954c = response.headers.m10954c(str);
        if (strM10954c != null) {
            return strM10954c;
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public final boolean m10990b() {
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
        StringBuilder sbM833U = C1643a.m833U("Response{protocol=");
        sbM833U.append(this.protocol);
        sbM833U.append(", code=");
        sbM833U.append(this.code);
        sbM833U.append(", message=");
        sbM833U.append(this.message);
        sbM833U.append(", url=");
        sbM833U.append(this.request.url);
        sbM833U.append('}');
        return sbM833U.toString();
    }

    /* JADX INFO: renamed from: okhttp3.Response$a */
    /* JADX INFO: compiled from: Response.kt */
    public static class C12937a {

        /* JADX INFO: renamed from: a */
        public Request f27565a;

        /* JADX INFO: renamed from: b */
        public EnumC12381y f27566b;

        /* JADX INFO: renamed from: c */
        public int f27567c;

        /* JADX INFO: renamed from: d */
        public String f27568d;

        /* JADX INFO: renamed from: e */
        public C12378v f27569e;

        /* JADX INFO: renamed from: f */
        public Headers.C12930a f27570f;

        /* JADX INFO: renamed from: g */
        public ResponseBody f27571g;

        /* JADX INFO: renamed from: h */
        public Response f27572h;

        /* JADX INFO: renamed from: i */
        public Response f27573i;

        /* JADX INFO: renamed from: j */
        public Response f27574j;

        /* JADX INFO: renamed from: k */
        public long f27575k;

        /* JADX INFO: renamed from: l */
        public long f27576l;

        /* JADX INFO: renamed from: m */
        public C12283c f27577m;

        public C12937a() {
            this.f27567c = -1;
            this.f27570f = new Headers.C12930a();
        }

        /* JADX INFO: renamed from: a */
        public Response m10991a() {
            int i = this.f27567c;
            if (!(i >= 0)) {
                StringBuilder sbM833U = C1643a.m833U("code < 0: ");
                sbM833U.append(this.f27567c);
                throw new IllegalStateException(sbM833U.toString().toString());
            }
            Request request = this.f27565a;
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            EnumC12381y enumC12381y = this.f27566b;
            if (enumC12381y == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            String str = this.f27568d;
            if (str != null) {
                return new Response(request, enumC12381y, str, i, this.f27569e, this.f27570f.m10960c(), this.f27571g, this.f27572h, this.f27573i, this.f27574j, this.f27575k, this.f27576l, this.f27577m);
            }
            throw new IllegalStateException("message == null".toString());
        }

        /* JADX INFO: renamed from: b */
        public C12937a m10992b(Response response) {
            m10993c("cacheResponse", response);
            this.f27573i = response;
            return this;
        }

        /* JADX INFO: renamed from: c */
        public final void m10993c(String str, Response response) {
            if (response != null) {
                if (!(response.body == null)) {
                    throw new IllegalArgumentException(C1643a.m883w(str, ".body != null").toString());
                }
                if (!(response.networkResponse == null)) {
                    throw new IllegalArgumentException(C1643a.m883w(str, ".networkResponse != null").toString());
                }
                if (!(response.cacheResponse == null)) {
                    throw new IllegalArgumentException(C1643a.m883w(str, ".cacheResponse != null").toString());
                }
                if (!(response.priorResponse == null)) {
                    throw new IllegalArgumentException(C1643a.m883w(str, ".priorResponse != null").toString());
                }
            }
        }

        /* JADX INFO: renamed from: d */
        public C12937a m10994d(Headers headers) {
            C12238m.checkParameterIsNotNull(headers, "headers");
            this.f27570f = headers.m10956e();
            return this;
        }

        /* JADX INFO: renamed from: e */
        public C12937a m10995e(String str) {
            C12238m.checkParameterIsNotNull(str, "message");
            this.f27568d = str;
            return this;
        }

        /* JADX INFO: renamed from: f */
        public C12937a m10996f(EnumC12381y enumC12381y) {
            C12238m.checkParameterIsNotNull(enumC12381y, "protocol");
            this.f27566b = enumC12381y;
            return this;
        }

        /* JADX INFO: renamed from: g */
        public C12937a m10997g(Request request) {
            C12238m.checkParameterIsNotNull(request, "request");
            this.f27565a = request;
            return this;
        }

        public C12937a(Response response) {
            C12238m.checkParameterIsNotNull(response, "response");
            this.f27567c = -1;
            this.f27565a = response.request;
            this.f27566b = response.protocol;
            this.f27567c = response.code;
            this.f27568d = response.message;
            this.f27569e = response.handshake;
            this.f27570f = response.headers.m10956e();
            this.f27571g = response.body;
            this.f27572h = response.networkResponse;
            this.f27573i = response.cacheResponse;
            this.f27574j = response.priorResponse;
            this.f27575k = response.sentRequestAtMillis;
            this.f27576l = response.receivedResponseAtMillis;
            this.f27577m = response.exchange;
        }
    }
}
