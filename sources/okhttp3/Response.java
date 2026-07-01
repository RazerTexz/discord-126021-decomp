package okhttp3;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import f0.e0.g.c;
import f0.v;
import f0.y;
import java.io.Closeable;
import java.util.Objects;

/* JADX INFO: compiled from: Response.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Response implements Closeable {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final Request request;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final y protocol;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final String message;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final int code;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final v handshake;

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
    public final c exchange;

    public Response(Request request, y yVar, String str, int i, v vVar, Headers headers, ResponseBody responseBody, Response response, Response response2, Response response3, long j, long j2, c cVar) {
        m.checkParameterIsNotNull(request, "request");
        m.checkParameterIsNotNull(yVar, "protocol");
        m.checkParameterIsNotNull(str, "message");
        m.checkParameterIsNotNull(headers, "headers");
        this.request = request;
        this.protocol = yVar;
        this.message = str;
        this.code = i;
        this.handshake = vVar;
        this.headers = headers;
        this.body = responseBody;
        this.networkResponse = response;
        this.cacheResponse = response2;
        this.priorResponse = response3;
        this.sentRequestAtMillis = j;
        this.receivedResponseAtMillis = j2;
        this.exchange = cVar;
    }

    public static String a(Response response, String str, String str2, int i) {
        int i2 = i & 2;
        Objects.requireNonNull(response);
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
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
        StringBuilder sbU = a.U("Response{protocol=");
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
}
