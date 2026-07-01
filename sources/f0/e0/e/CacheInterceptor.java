package f0.e0.e;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import f0.Handshake;
import f0.Protocol2;
import f0.e0.Util7;
import f0.e0.g.Exchange;
import f0.e0.g.RealCall;
import f0.e0.h.RealInterceptorChain;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: f0.e0.e.a, reason: use source file name */
/* JADX INFO: compiled from: CacheInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CacheInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f3607b = new a(null);

    /* JADX INFO: renamed from: f0.e0.e.a$a */
    /* JADX INFO: compiled from: CacheInterceptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final Response a(a aVar, Response response) {
            if ((response != null ? response.body : null) == null) {
                return response;
            }
            Intrinsics3.checkParameterIsNotNull(response, "response");
            Request request = response.request;
            Protocol2 protocol2 = response.protocol;
            int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            String str = response.message;
            Handshake handshake = response.handshake;
            Headers.a aVarE = response.headers.e();
            Response response2 = response.networkResponse;
            Response response3 = response.cacheResponse;
            Response response4 = response.priorResponse;
            long j = response.sentRequestAtMillis;
            long j2 = response.receivedResponseAtMillis;
            Exchange exchange = response.exchange;
            if (!(i >= 0)) {
                throw new IllegalStateException(outline.q("code < 0: ", i).toString());
            }
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            if (protocol2 == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            if (str != null) {
                return new Response(request, protocol2, str, i, handshake, aVarE.c(), null, response2, response3, response4, j, j2, exchange);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public final boolean b(String str) {
            return StringsJVM.equals("Content-Length", str, true) || StringsJVM.equals("Content-Encoding", str, true) || StringsJVM.equals("Content-Type", str, true);
        }

        public final boolean c(String str) {
            return (StringsJVM.equals("Connection", str, true) || StringsJVM.equals("Keep-Alive", str, true) || StringsJVM.equals("Proxy-Authenticate", str, true) || StringsJVM.equals("Proxy-Authorization", str, true) || StringsJVM.equals("TE", str, true) || StringsJVM.equals("Trailers", str, true) || StringsJVM.equals("Transfer-Encoding", str, true) || StringsJVM.equals("Upgrade", str, true)) ? false : true;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Headers headers;
        int i;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        RealCall realCall = realInterceptorChain.f3628b;
        System.currentTimeMillis();
        Request request = realInterceptorChain.f;
        Intrinsics3.checkParameterIsNotNull(request, "request");
        CacheStrategy cacheStrategy = new CacheStrategy(request, null);
        if (request != null && request.a().k) {
            cacheStrategy = new CacheStrategy(null, null);
        }
        Request request2 = cacheStrategy.a;
        Response response = cacheStrategy.f3608b;
        if (!(realCall instanceof RealCall)) {
        }
        if (request2 == null && response == null) {
            Response.a aVar = new Response.a();
            aVar.g(realInterceptorChain.f);
            aVar.f(Protocol2.HTTP_1_1);
            aVar.c = 504;
            aVar.e("Unsatisfiable Request (only-if-cached)");
            aVar.g = Util7.c;
            aVar.k = -1L;
            aVar.l = System.currentTimeMillis();
            Response responseA = aVar.a();
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(responseA, "response");
            return responseA;
        }
        if (request2 == null) {
            if (response == null) {
                Intrinsics3.throwNpe();
            }
            Response.a aVar2 = new Response.a(response);
            aVar2.b(a.a(f3607b, response));
            Response responseA2 = aVar2.a();
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(responseA2, "response");
            return responseA2;
        }
        if (response != null) {
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(response, "cachedResponse");
        }
        Response responseA3 = ((RealInterceptorChain) chain).a(request2);
        if (response != null) {
            if (responseA3.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 304) {
                Response.a aVar3 = new Response.a(response);
                a aVar4 = f3607b;
                Headers headers2 = response.headers;
                Headers headers3 = responseA3.headers;
                ArrayList arrayList = new ArrayList(20);
                int i2 = 0;
                for (int size = headers2.size(); i2 < size; size = i) {
                    String strD = headers2.d(i2);
                    String strG = headers2.g(i2);
                    if (StringsJVM.equals("Warning", strD, true)) {
                        headers = headers2;
                        i = size;
                        if (StringsJVM.startsWith$default(strG, "1", false, 2, null)) {
                        }
                        i2++;
                        headers2 = headers;
                    } else {
                        headers = headers2;
                        i = size;
                    }
                    if (aVar4.b(strD) || !aVar4.c(strD) || headers3.c(strD) == null) {
                        Intrinsics3.checkParameterIsNotNull(strD, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        Intrinsics3.checkParameterIsNotNull(strG, "value");
                        arrayList.add(strD);
                        arrayList.add(Strings4.trim(strG).toString());
                    }
                    i2++;
                    headers2 = headers;
                }
                int size2 = headers3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String strD2 = headers3.d(i3);
                    if (!aVar4.b(strD2) && aVar4.c(strD2)) {
                        String strG2 = headers3.g(i3);
                        Intrinsics3.checkParameterIsNotNull(strD2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        Intrinsics3.checkParameterIsNotNull(strG2, "value");
                        arrayList.add(strD2);
                        arrayList.add(Strings4.trim(strG2).toString());
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                aVar3.d(new Headers((String[]) array, null));
                aVar3.k = responseA3.sentRequestAtMillis;
                aVar3.l = responseA3.receivedResponseAtMillis;
                a aVar5 = f3607b;
                aVar3.b(a.a(aVar5, response));
                Response responseA4 = a.a(aVar5, responseA3);
                aVar3.c("networkResponse", responseA4);
                aVar3.h = responseA4;
                aVar3.a();
                ResponseBody responseBody = responseA3.body;
                if (responseBody == null) {
                    Intrinsics3.throwNpe();
                }
                responseBody.close();
                Intrinsics3.throwNpe();
                throw null;
            }
            ResponseBody responseBody2 = response.body;
            if (responseBody2 != null) {
                byte[] bArr = Util7.a;
                Intrinsics3.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
                try {
                    responseBody2.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
        }
        Response.a aVar6 = new Response.a(responseA3);
        a aVar7 = f3607b;
        aVar6.b(a.a(aVar7, response));
        Response responseA5 = a.a(aVar7, responseA3);
        aVar6.c("networkResponse", responseA5);
        aVar6.h = responseA5;
        return aVar6.a();
    }
}
