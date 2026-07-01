package f0.e0.e;

import d0.g0.t;
import d0.z.d.m;
import f0.e0.g.c;
import f0.v;
import f0.y;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers$a;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: CacheInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a {
    public a$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static final Response a(a$a a_a, Response response) {
        if ((response != null ? response.body : null) == null) {
            return response;
        }
        m.checkParameterIsNotNull(response, "response");
        Request request = response.request;
        y yVar = response.protocol;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        String str = response.message;
        v vVar = response.handshake;
        Headers$a headers$aE = response.headers.e();
        Response response2 = response.networkResponse;
        Response response3 = response.cacheResponse;
        Response response4 = response.priorResponse;
        long j = response.sentRequestAtMillis;
        long j2 = response.receivedResponseAtMillis;
        c cVar = response.exchange;
        if (!(i >= 0)) {
            throw new IllegalStateException(b.d.b.a.a.q("code < 0: ", i).toString());
        }
        if (request == null) {
            throw new IllegalStateException("request == null".toString());
        }
        if (yVar == null) {
            throw new IllegalStateException("protocol == null".toString());
        }
        if (str != null) {
            return new Response(request, yVar, str, i, vVar, headers$aE.c(), null, response2, response3, response4, j, j2, cVar);
        }
        throw new IllegalStateException("message == null".toString());
    }

    public final boolean b(String str) {
        return t.equals("Content-Length", str, true) || t.equals("Content-Encoding", str, true) || t.equals("Content-Type", str, true);
    }

    public final boolean c(String str) {
        return (t.equals("Connection", str, true) || t.equals("Keep-Alive", str, true) || t.equals("Proxy-Authenticate", str, true) || t.equals("Proxy-Authorization", str, true) || t.equals("TE", str, true) || t.equals("Trailers", str, true) || t.equals("Transfer-Encoding", str, true) || t.equals("Upgrade", str, true)) ? false : true;
    }
}
