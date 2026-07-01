package f0.e0.h;

import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import f0.Cookie;
import f0.CookieJar2;
import f0.e0.Util7;
import g0.GzipSource;
import g0.RealBufferedSource;
import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: f0.e0.h.a, reason: use source file name */
/* JADX INFO: compiled from: BridgeInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BridgeInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CookieJar2 f3624b;

    public BridgeInterceptor(CookieJar2 cookieJar2) {
        Intrinsics3.checkParameterIsNotNull(cookieJar2, "cookieJar");
        this.f3624b = cookieJar2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z2;
        ResponseBody responseBody;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.f;
        Request.a aVar = new Request.a(request);
        RequestBody requestBody = request.body;
        if (requestBody != null) {
            MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                aVar.b("Content-Type", mediaTypeContentType.mediaType);
            }
            long jContentLength = requestBody.getSize();
            if (jContentLength != -1) {
                aVar.b("Content-Length", String.valueOf(jContentLength));
                aVar.d("Transfer-Encoding");
            } else {
                aVar.b("Transfer-Encoding", "chunked");
                aVar.d("Content-Length");
            }
        }
        int i = 0;
        if (request.b("Host") == null) {
            aVar.b("Host", Util7.y(request.url, false));
        }
        if (request.b("Connection") == null) {
            aVar.b("Connection", "Keep-Alive");
        }
        if (request.b("Accept-Encoding") == null && request.b("Range") == null) {
            aVar.b("Accept-Encoding", "gzip");
            z2 = true;
        } else {
            z2 = false;
        }
        List<Cookie> listB = this.f3624b.b(request.url);
        if (!listB.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : listB) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                Cookie cookie = (Cookie) obj;
                if (i > 0) {
                    sb.append("; ");
                }
                sb.append(cookie.f);
                sb.append('=');
                sb.append(cookie.g);
                i = i2;
            }
            String string = sb.toString();
            Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
            aVar.b("Cookie", string);
        }
        if (request.b("User-Agent") == null) {
            aVar.b("User-Agent", "okhttp/4.8.0");
        }
        Response responseA = realInterceptorChain.a(aVar.a());
        HttpHeaders.d(this.f3624b, request.url, responseA.headers);
        Response.a aVar2 = new Response.a(responseA);
        aVar2.g(request);
        if (z2 && StringsJVM.equals("gzip", Response.a(responseA, "Content-Encoding", null, 2), true) && HttpHeaders.a(responseA) && (responseBody = responseA.body) != null) {
            GzipSource gzipSource = new GzipSource(responseBody.c());
            Headers.a aVarE = responseA.headers.e();
            aVarE.d("Content-Encoding");
            aVarE.d("Content-Length");
            aVar2.d(aVarE.c());
            String strA = Response.a(responseA, "Content-Type", null, 2);
            Intrinsics3.checkParameterIsNotNull(gzipSource, "$this$buffer");
            aVar2.g = new RealResponseBody(strA, -1L, new RealBufferedSource(gzipSource));
        }
        return aVar2.a();
    }
}
