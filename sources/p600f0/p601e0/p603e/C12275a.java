package p600f0.p601e0.p603e;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12378v;
import p600f0.EnumC12381y;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p605g.C12283c;
import p600f0.p601e0.p605g.C12285e;
import p600f0.p601e0.p606h.C12301g;

/* JADX INFO: renamed from: f0.e0.e.a */
/* JADX INFO: compiled from: CacheInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12275a implements Interceptor {

    /* JADX INFO: renamed from: b */
    public static final a f25406b = new a(null);

    /* JADX INFO: renamed from: f0.e0.e.a$a */
    /* JADX INFO: compiled from: CacheInterceptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public static final Response m10147a(a aVar, Response response) {
            if ((response != null ? response.body : null) == null) {
                return response;
            }
            C12238m.checkParameterIsNotNull(response, "response");
            Request request = response.request;
            EnumC12381y enumC12381y = response.protocol;
            int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            String str = response.message;
            C12378v c12378v = response.handshake;
            Headers.C12930a c12930aM10956e = response.headers.m10956e();
            Response response2 = response.networkResponse;
            Response response3 = response.cacheResponse;
            Response response4 = response.priorResponse;
            long j = response.sentRequestAtMillis;
            long j2 = response.receivedResponseAtMillis;
            C12283c c12283c = response.exchange;
            if (!(i >= 0)) {
                throw new IllegalStateException(C1643a.m871q("code < 0: ", i).toString());
            }
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            if (enumC12381y == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            if (str != null) {
                return new Response(request, enumC12381y, str, i, c12378v, c12930aM10956e.m10960c(), null, response2, response3, response4, j, j2, c12283c);
            }
            throw new IllegalStateException("message == null".toString());
        }

        /* JADX INFO: renamed from: b */
        public final boolean m10148b(String str) {
            return C12103t.equals("Content-Length", str, true) || C12103t.equals("Content-Encoding", str, true) || C12103t.equals("Content-Type", str, true);
        }

        /* JADX INFO: renamed from: c */
        public final boolean m10149c(String str) {
            return (C12103t.equals("Connection", str, true) || C12103t.equals("Keep-Alive", str, true) || C12103t.equals("Proxy-Authenticate", str, true) || C12103t.equals("Proxy-Authorization", str, true) || C12103t.equals("TE", str, true) || C12103t.equals("Trailers", str, true) || C12103t.equals("Transfer-Encoding", str, true) || C12103t.equals("Upgrade", str, true)) ? false : true;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Headers headers;
        int i;
        C12238m.checkParameterIsNotNull(chain, "chain");
        C12301g c12301g = (C12301g) chain;
        C12285e c12285e = c12301g.f25532b;
        System.currentTimeMillis();
        Request request = c12301g.f25536f;
        C12238m.checkParameterIsNotNull(request, "request");
        C12276b c12276b = new C12276b(request, null);
        if (request != null && request.m10976a().f25383k) {
            c12276b = new C12276b(null, null);
        }
        Request request2 = c12276b.f25407a;
        Response response = c12276b.f25408b;
        if (!(c12285e instanceof C12285e)) {
        }
        if (request2 == null && response == null) {
            Response.C12937a c12937a = new Response.C12937a();
            c12937a.m10997g(c12301g.f25536f);
            c12937a.m10996f(EnumC12381y.HTTP_1_1);
            c12937a.f27567c = 504;
            c12937a.m10995e("Unsatisfiable Request (only-if-cached)");
            c12937a.f27571g = C12272c.f25399c;
            c12937a.f27575k = -1L;
            c12937a.f27576l = System.currentTimeMillis();
            Response responseM10991a = c12937a.m10991a();
            C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(responseM10991a, "response");
            return responseM10991a;
        }
        if (request2 == null) {
            if (response == null) {
                C12238m.throwNpe();
            }
            Response.C12937a c12937a2 = new Response.C12937a(response);
            c12937a2.m10992b(a.m10147a(f25406b, response));
            Response responseM10991a2 = c12937a2.m10991a();
            C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(responseM10991a2, "response");
            return responseM10991a2;
        }
        if (response != null) {
            C12238m.checkParameterIsNotNull(c12285e, NotificationCompat.CATEGORY_CALL);
            C12238m.checkParameterIsNotNull(response, "cachedResponse");
        }
        Response responseMo10228a = ((C12301g) chain).mo10228a(request2);
        if (response != null) {
            if (responseMo10228a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 304) {
                Response.C12937a c12937a3 = new Response.C12937a(response);
                a aVar = f25406b;
                Headers headers2 = response.headers;
                Headers headers3 = responseMo10228a.headers;
                ArrayList arrayList = new ArrayList(20);
                int i2 = 0;
                for (int size = headers2.size(); i2 < size; size = i) {
                    String strM10955d = headers2.m10955d(i2);
                    String strM10957g = headers2.m10957g(i2);
                    if (C12103t.equals("Warning", strM10955d, true)) {
                        headers = headers2;
                        i = size;
                        if (C12103t.startsWith$default(strM10957g, "1", false, 2, null)) {
                        }
                        i2++;
                        headers2 = headers;
                    } else {
                        headers = headers2;
                        i = size;
                    }
                    if (aVar.m10148b(strM10955d) || !aVar.m10149c(strM10955d) || headers3.m10954c(strM10955d) == null) {
                        C12238m.checkParameterIsNotNull(strM10955d, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        C12238m.checkParameterIsNotNull(strM10957g, "value");
                        arrayList.add(strM10955d);
                        arrayList.add(C12106w.trim(strM10957g).toString());
                    }
                    i2++;
                    headers2 = headers;
                }
                int size2 = headers3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String strM10955d2 = headers3.m10955d(i3);
                    if (!aVar.m10148b(strM10955d2) && aVar.m10149c(strM10955d2)) {
                        String strM10957g2 = headers3.m10957g(i3);
                        C12238m.checkParameterIsNotNull(strM10955d2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        C12238m.checkParameterIsNotNull(strM10957g2, "value");
                        arrayList.add(strM10955d2);
                        arrayList.add(C12106w.trim(strM10957g2).toString());
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                c12937a3.m10994d(new Headers((String[]) array, null));
                c12937a3.f27575k = responseMo10228a.sentRequestAtMillis;
                c12937a3.f27576l = responseMo10228a.receivedResponseAtMillis;
                a aVar2 = f25406b;
                c12937a3.m10992b(a.m10147a(aVar2, response));
                Response responseM10147a = a.m10147a(aVar2, responseMo10228a);
                c12937a3.m10993c("networkResponse", responseM10147a);
                c12937a3.f27572h = responseM10147a;
                c12937a3.m10991a();
                ResponseBody responseBody = responseMo10228a.body;
                if (responseBody == null) {
                    C12238m.throwNpe();
                }
                responseBody.close();
                C12238m.throwNpe();
                throw null;
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
        }
        Response.C12937a c12937a4 = new Response.C12937a(responseMo10228a);
        a aVar3 = f25406b;
        c12937a4.m10992b(a.m10147a(aVar3, response));
        Response responseM10147a2 = a.m10147a(aVar3, responseMo10228a);
        c12937a4.m10993c("networkResponse", responseM10147a2);
        c12937a4.f27572h = responseM10147a2;
        return c12937a4.m10991a();
    }
}
