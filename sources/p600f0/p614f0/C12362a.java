package p600f0.p614f0;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.analytics.utils.RegistrationSteps;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12148n0;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;
import p600f0.InterfaceC12367k;
import p600f0.p601e0.p605g.C12290j;
import p600f0.p601e0.p606h.C12299e;
import p600f0.p601e0.p606h.C12301g;
import p615g0.C12388e;
import p615g0.C12395l;
import p615g0.InterfaceC12390g;

/* JADX INFO: renamed from: f0.f0.a */
/* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12362a implements Interceptor {

    /* JADX INFO: renamed from: b */
    public volatile Set<String> f25895b;

    /* JADX INFO: renamed from: c */
    public volatile a f25896c;

    /* JADX INFO: renamed from: d */
    public final b f25897d;

    /* JADX INFO: renamed from: f0.f0.a$a */
    /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
    public enum a {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    /* JADX INFO: renamed from: f0.f0.a$b */
    /* JADX INFO: compiled from: HttpLoggingInterceptor.kt */
    public interface b {
        void log(String str);
    }

    public C12362a(b bVar) {
        C12238m.checkParameterIsNotNull(bVar, "logger");
        this.f25897d = bVar;
        this.f25895b = C12148n0.emptySet();
        this.f25896c = a.NONE;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m10366a(Headers headers) {
        String strM10954c = headers.m10954c("Content-Encoding");
        return (strM10954c == null || C12103t.equals(strM10954c, RegistrationSteps.IDENTITY, true) || C12103t.equals(strM10954c, "gzip", true)) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public final void m10367b(Headers headers, int i) {
        int i2 = i * 2;
        String str = this.f25895b.contains(headers.namesAndValues[i2]) ? "██" : headers.namesAndValues[i2 + 1];
        this.f25897d.log(headers.namesAndValues[i2] + ": " + str);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws Exception {
        String string;
        Charset charsetM10966a;
        Charset charsetM10966a2;
        C12238m.checkParameterIsNotNull(chain, "chain");
        a aVar = this.f25896c;
        C12301g c12301g = (C12301g) chain;
        Request request = c12301g.f25536f;
        if (aVar == a.NONE) {
            return c12301g.mo10228a(request);
        }
        boolean z2 = aVar == a.BODY;
        boolean z3 = z2 || aVar == a.HEADERS;
        RequestBody requestBody = request.body;
        InterfaceC12367k interfaceC12367kM10229b = c12301g.m10229b();
        StringBuilder sbM833U = C1643a.m833U("--> ");
        sbM833U.append(request.method);
        sbM833U.append(' ');
        sbM833U.append(request.url);
        if (interfaceC12367kM10229b != null) {
            StringBuilder sbM833U2 = C1643a.m833U(" ");
            sbM833U2.append(((C12290j) interfaceC12367kM10229b).m10204m());
            string = sbM833U2.toString();
        } else {
            string = "";
        }
        sbM833U.append(string);
        String string2 = sbM833U.toString();
        if (!z3 && requestBody != null) {
            StringBuilder sbM836X = C1643a.m836X(string2, " (");
            sbM836X.append(requestBody.getSize());
            sbM836X.append("-byte body)");
            string2 = sbM836X.toString();
        }
        this.f25897d.log(string2);
        if (z3) {
            Headers headers = request.headers;
            if (requestBody != null) {
                MediaType mediaTypeContentType = requestBody.contentType();
                if (mediaTypeContentType != null && headers.m10954c("Content-Type") == null) {
                    this.f25897d.log("Content-Type: " + mediaTypeContentType);
                }
                if (requestBody.getSize() != -1 && headers.m10954c("Content-Length") == null) {
                    b bVar = this.f25897d;
                    StringBuilder sbM833U3 = C1643a.m833U("Content-Length: ");
                    sbM833U3.append(requestBody.getSize());
                    bVar.log(sbM833U3.toString());
                }
            }
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                m10367b(headers, i);
            }
            if (!z2 || requestBody == null) {
                b bVar2 = this.f25897d;
                StringBuilder sbM833U4 = C1643a.m833U("--> END ");
                sbM833U4.append(request.method);
                bVar2.log(sbM833U4.toString());
            } else if (m10366a(request.headers)) {
                b bVar3 = this.f25897d;
                StringBuilder sbM833U5 = C1643a.m833U("--> END ");
                sbM833U5.append(request.method);
                sbM833U5.append(" (encoded body omitted)");
                bVar3.log(sbM833U5.toString());
            } else if (requestBody.isDuplex()) {
                b bVar4 = this.f25897d;
                StringBuilder sbM833U6 = C1643a.m833U("--> END ");
                sbM833U6.append(request.method);
                sbM833U6.append(" (duplex request body omitted)");
                bVar4.log(sbM833U6.toString());
            } else if (requestBody.isOneShot()) {
                b bVar5 = this.f25897d;
                StringBuilder sbM833U7 = C1643a.m833U("--> END ");
                sbM833U7.append(request.method);
                sbM833U7.append(" (one-shot body omitted)");
                bVar5.log(sbM833U7.toString());
            } else {
                C12388e c12388e = new C12388e();
                requestBody.writeTo(c12388e);
                MediaType mediaTypeContentType2 = requestBody.contentType();
                if (mediaTypeContentType2 == null || (charsetM10966a2 = mediaTypeContentType2.m10966a(StandardCharsets.UTF_8)) == null) {
                    charsetM10966a2 = StandardCharsets.UTF_8;
                    C12238m.checkExpressionValueIsNotNull(charsetM10966a2, "UTF_8");
                }
                this.f25897d.log("");
                if (C3404f.m4205F0(c12388e)) {
                    this.f25897d.log(c12388e.mo10437M(charsetM10966a2));
                    b bVar6 = this.f25897d;
                    StringBuilder sbM833U8 = C1643a.m833U("--> END ");
                    sbM833U8.append(request.method);
                    sbM833U8.append(" (");
                    sbM833U8.append(requestBody.getSize());
                    sbM833U8.append("-byte body)");
                    bVar6.log(sbM833U8.toString());
                } else {
                    b bVar7 = this.f25897d;
                    StringBuilder sbM833U9 = C1643a.m833U("--> END ");
                    sbM833U9.append(request.method);
                    sbM833U9.append(" (binary ");
                    sbM833U9.append(requestBody.getSize());
                    sbM833U9.append("-byte body omitted)");
                    bVar7.log(sbM833U9.toString());
                }
            }
        }
        long jNanoTime = System.nanoTime();
        try {
            Response responseMo10228a = c12301g.mo10228a(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - jNanoTime);
            ResponseBody responseBody = responseMo10228a.body;
            if (responseBody == null) {
                C12238m.throwNpe();
            }
            long jMo10103a = responseBody.mo10103a();
            String str = jMo10103a != -1 ? jMo10103a + "-byte" : "unknown-length";
            b bVar8 = this.f25897d;
            StringBuilder sbM833U10 = C1643a.m833U("<-- ");
            sbM833U10.append(responseMo10228a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String);
            sbM833U10.append(responseMo10228a.message.length() == 0 ? "" : String.valueOf(' ') + responseMo10228a.message);
            sbM833U10.append(' ');
            sbM833U10.append(responseMo10228a.request.url);
            sbM833U10.append(" (");
            sbM833U10.append(millis);
            sbM833U10.append("ms");
            sbM833U10.append(!z3 ? C1643a.m886y(", ", str, " body") : "");
            sbM833U10.append(')');
            bVar8.log(sbM833U10.toString());
            if (z3) {
                Headers headers2 = responseMo10228a.headers;
                int size2 = headers2.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    m10367b(headers2, i2);
                }
                if (!z2 || !C12299e.m10221a(responseMo10228a)) {
                    this.f25897d.log("<-- END HTTP");
                } else if (m10366a(responseMo10228a.headers)) {
                    this.f25897d.log("<-- END HTTP (encoded body omitted)");
                } else {
                    InterfaceC12390g interfaceC12390gMo10105c = responseBody.mo10105c();
                    interfaceC12390gMo10105c.mo10458j(RecyclerView.FOREVER_NS);
                    C12388e c12388eMo10457g = interfaceC12390gMo10105c.mo10457g();
                    Long l = null;
                    if (C12103t.equals("gzip", headers2.m10954c("Content-Encoding"), true)) {
                        Long lValueOf = Long.valueOf(c12388eMo10457g.f26080k);
                        C12395l c12395l = new C12395l(c12388eMo10457g.clone());
                        try {
                            c12388eMo10457g = new C12388e();
                            c12388eMo10457g.mo10440P(c12395l);
                            C12201b.closeFinally(c12395l, null);
                            l = lValueOf;
                        } catch (Throwable th) {
                            try {
                                throw th;
                            } catch (Throwable th2) {
                                C12201b.closeFinally(c12395l, th);
                                throw th2;
                            }
                        }
                    }
                    MediaType mediaTypeMo10104b = responseBody.mo10104b();
                    if (mediaTypeMo10104b == null || (charsetM10966a = mediaTypeMo10104b.m10966a(StandardCharsets.UTF_8)) == null) {
                        charsetM10966a = StandardCharsets.UTF_8;
                        C12238m.checkExpressionValueIsNotNull(charsetM10966a, "UTF_8");
                    }
                    if (!C3404f.m4205F0(c12388eMo10457g)) {
                        this.f25897d.log("");
                        b bVar9 = this.f25897d;
                        StringBuilder sbM833U11 = C1643a.m833U("<-- END HTTP (binary ");
                        sbM833U11.append(c12388eMo10457g.f26080k);
                        sbM833U11.append("-byte body omitted)");
                        bVar9.log(sbM833U11.toString());
                        return responseMo10228a;
                    }
                    if (jMo10103a != 0) {
                        this.f25897d.log("");
                        this.f25897d.log(c12388eMo10457g.clone().mo10437M(charsetM10966a));
                    }
                    if (l != null) {
                        b bVar10 = this.f25897d;
                        StringBuilder sbM833U12 = C1643a.m833U("<-- END HTTP (");
                        sbM833U12.append(c12388eMo10457g.f26080k);
                        sbM833U12.append("-byte, ");
                        sbM833U12.append(l);
                        sbM833U12.append("-gzipped-byte body)");
                        bVar10.log(sbM833U12.toString());
                    } else {
                        b bVar11 = this.f25897d;
                        StringBuilder sbM833U13 = C1643a.m833U("<-- END HTTP (");
                        sbM833U13.append(c12388eMo10457g.f26080k);
                        sbM833U13.append("-byte body)");
                        bVar11.log(sbM833U13.toString());
                    }
                }
            }
            return responseMo10228a;
        } catch (Exception e) {
            this.f25897d.log("<-- HTTP FAILED: " + e);
            throw e;
        }
    }
}
