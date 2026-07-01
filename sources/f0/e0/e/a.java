package f0.e0.e;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import f0.e0.c;
import f0.e0.g.e;
import f0.e0.h.g;
import f0.y;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.TypeCastException;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor$Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response$a;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: CacheInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a$a f3607b = new a$a(null);

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor$Chain interceptor$Chain) throws IOException {
        Headers headers;
        int i;
        m.checkParameterIsNotNull(interceptor$Chain, "chain");
        g gVar = (g) interceptor$Chain;
        e eVar = gVar.f3628b;
        System.currentTimeMillis();
        Request request = gVar.f;
        m.checkParameterIsNotNull(request, "request");
        b bVar = new b(request, null);
        if (request != null && request.a().k) {
            bVar = new b(null, null);
        }
        Request request2 = bVar.a;
        Response response = bVar.f3608b;
        if (!(eVar instanceof e)) {
        }
        if (request2 == null && response == null) {
            Response$a response$a = new Response$a();
            response$a.g(gVar.f);
            response$a.f(y.HTTP_1_1);
            response$a.c = 504;
            response$a.e("Unsatisfiable Request (only-if-cached)");
            response$a.g = c.c;
            response$a.k = -1L;
            response$a.l = System.currentTimeMillis();
            Response responseA = response$a.a();
            m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            m.checkParameterIsNotNull(responseA, "response");
            return responseA;
        }
        if (request2 == null) {
            if (response == null) {
                m.throwNpe();
            }
            Response$a response$a2 = new Response$a(response);
            response$a2.b(a$a.a(f3607b, response));
            Response responseA2 = response$a2.a();
            m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            m.checkParameterIsNotNull(responseA2, "response");
            return responseA2;
        }
        if (response != null) {
            m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            m.checkParameterIsNotNull(response, "cachedResponse");
        }
        Response responseA3 = ((g) interceptor$Chain).a(request2);
        if (response != null) {
            if (responseA3.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 304) {
                Response$a response$a3 = new Response$a(response);
                a$a a_a = f3607b;
                Headers headers2 = response.headers;
                Headers headers3 = responseA3.headers;
                ArrayList arrayList = new ArrayList(20);
                int i2 = 0;
                for (int size = headers2.size(); i2 < size; size = i) {
                    String strD = headers2.d(i2);
                    String strG = headers2.g(i2);
                    if (t.equals("Warning", strD, true)) {
                        headers = headers2;
                        i = size;
                        if (t.startsWith$default(strG, "1", false, 2, null)) {
                        }
                        i2++;
                        headers2 = headers;
                    } else {
                        headers = headers2;
                        i = size;
                    }
                    if (a_a.b(strD) || !a_a.c(strD) || headers3.c(strD) == null) {
                        m.checkParameterIsNotNull(strD, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        m.checkParameterIsNotNull(strG, "value");
                        arrayList.add(strD);
                        arrayList.add(w.trim(strG).toString());
                    }
                    i2++;
                    headers2 = headers;
                }
                int size2 = headers3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String strD2 = headers3.d(i3);
                    if (!a_a.b(strD2) && a_a.c(strD2)) {
                        String strG2 = headers3.g(i3);
                        m.checkParameterIsNotNull(strD2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        m.checkParameterIsNotNull(strG2, "value");
                        arrayList.add(strD2);
                        arrayList.add(w.trim(strG2).toString());
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                response$a3.d(new Headers((String[]) array, null));
                response$a3.k = responseA3.sentRequestAtMillis;
                response$a3.l = responseA3.receivedResponseAtMillis;
                a$a a_a2 = f3607b;
                response$a3.b(a$a.a(a_a2, response));
                Response responseA4 = a$a.a(a_a2, responseA3);
                response$a3.c("networkResponse", responseA4);
                response$a3.h = responseA4;
                response$a3.a();
                ResponseBody responseBody = responseA3.body;
                if (responseBody == null) {
                    m.throwNpe();
                }
                responseBody.close();
                m.throwNpe();
                throw null;
            }
            ResponseBody responseBody2 = response.body;
            if (responseBody2 != null) {
                byte[] bArr = c.a;
                m.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
                try {
                    responseBody2.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
        }
        Response$a response$a4 = new Response$a(responseA3);
        a$a a_a3 = f3607b;
        response$a4.b(a$a.a(a_a3, response));
        Response responseA5 = a$a.a(a_a3, responseA3);
        response$a4.c("networkResponse", responseA5);
        response$a4.h = responseA5;
        return response$a4.a();
    }
}
