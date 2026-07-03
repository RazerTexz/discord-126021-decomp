package p600f0.p601e0.p606h;

import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12370n;
import p600f0.InterfaceC12372p;
import p600f0.p601e0.C12272c;
import p615g0.C12395l;
import p615g0.C12401r;

/* JADX INFO: renamed from: f0.e0.h.a */
/* JADX INFO: compiled from: BridgeInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12295a implements Interceptor {

    /* JADX INFO: renamed from: b */
    public final InterfaceC12372p f25524b;

    public C12295a(InterfaceC12372p interfaceC12372p) {
        C12238m.checkParameterIsNotNull(interfaceC12372p, "cookieJar");
        this.f25524b = interfaceC12372p;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z2;
        ResponseBody responseBody;
        C12238m.checkParameterIsNotNull(chain, "chain");
        C12301g c12301g = (C12301g) chain;
        Request request = c12301g.f25536f;
        Request.C12935a c12935a = new Request.C12935a(request);
        RequestBody requestBody = request.body;
        if (requestBody != null) {
            MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                c12935a.m10979b("Content-Type", mediaTypeContentType.mediaType);
            }
            long jContentLength = requestBody.getSize();
            if (jContentLength != -1) {
                c12935a.m10979b("Content-Length", String.valueOf(jContentLength));
                c12935a.m10981d("Transfer-Encoding");
            } else {
                c12935a.m10979b("Transfer-Encoding", "chunked");
                c12935a.m10981d("Content-Length");
            }
        }
        int i = 0;
        if (request.m10977b("Host") == null) {
            c12935a.m10979b("Host", C12272c.m10144y(request.url, false));
        }
        if (request.m10977b("Connection") == null) {
            c12935a.m10979b("Connection", "Keep-Alive");
        }
        if (request.m10977b("Accept-Encoding") == null && request.m10977b("Range") == null) {
            c12935a.m10979b("Accept-Encoding", "gzip");
            z2 = true;
        } else {
            z2 = false;
        }
        List<C12370n> listMo8746b = this.f25524b.mo8746b(request.url);
        if (!listMo8746b.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : listMo8746b) {
                int i2 = i + 1;
                if (i < 0) {
                    C12147n.throwIndexOverflow();
                }
                C12370n c12370n = (C12370n) obj;
                if (i > 0) {
                    sb.append("; ");
                }
                sb.append(c12370n.f25947f);
                sb.append('=');
                sb.append(c12370n.f25948g);
                i = i2;
            }
            String string = sb.toString();
            C12238m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
            c12935a.m10979b("Cookie", string);
        }
        if (request.m10977b("User-Agent") == null) {
            c12935a.m10979b("User-Agent", "okhttp/4.8.0");
        }
        Response responseMo10228a = c12301g.mo10228a(c12935a.m10978a());
        C12299e.m10224d(this.f25524b, request.url, responseMo10228a.headers);
        Response.C12937a c12937a = new Response.C12937a(responseMo10228a);
        c12937a.m10997g(request);
        if (z2 && C12103t.equals("gzip", Response.m10989a(responseMo10228a, "Content-Encoding", null, 2), true) && C12299e.m10221a(responseMo10228a) && (responseBody = responseMo10228a.body) != null) {
            C12395l c12395l = new C12395l(responseBody.mo10105c());
            Headers.C12930a c12930aM10956e = responseMo10228a.headers.m10956e();
            c12930aM10956e.m10961d("Content-Encoding");
            c12930aM10956e.m10961d("Content-Length");
            c12937a.m10994d(c12930aM10956e.m10960c());
            String strM10989a = Response.m10989a(responseMo10228a, "Content-Type", null, 2);
            C12238m.checkParameterIsNotNull(c12395l, "$this$buffer");
            c12937a.f27571g = new C12302h(strM10989a, -1L, new C12401r(c12395l));
        }
        return c12937a.m10991a();
    }
}
