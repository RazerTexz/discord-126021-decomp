package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.t;
import d0.t.h0;
import d0.z.d.m;
import f0.e0.c;
import f0.e0.h.f;
import f0.w;
import f0.w$a;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Request$a {
    public w a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3813b;
    public Headers$a c;
    public RequestBody d;
    public Map<Class<?>, Object> e;

    public Request$a() {
        this.e = new LinkedHashMap();
        this.f3813b = ShareTarget.METHOD_GET;
        this.c = new Headers$a();
    }

    public Request a() {
        w wVar = this.a;
        if (wVar != null) {
            return new Request(wVar, this.f3813b, this.c.c(), this.d, c.A(this.e));
        }
        throw new IllegalStateException("url == null".toString());
    }

    public Request$a b(String str, String str2) {
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(str2, "value");
        Headers$a headers$a = this.c;
        Objects.requireNonNull(headers$a);
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(str2, "value");
        Headers$b headers$b = Headers.j;
        headers$b.a(str);
        headers$b.b(str2, str);
        headers$a.d(str);
        headers$a.b(str, str2);
        return this;
    }

    public Request$a c(String str, RequestBody requestBody) {
        m.checkParameterIsNotNull(str, "method");
        if (!(str.length() > 0)) {
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }
        if (requestBody == null) {
            m.checkParameterIsNotNull(str, "method");
            if (!(!(m.areEqual(str, ShareTarget.METHOD_POST) || m.areEqual(str, "PUT") || m.areEqual(str, "PATCH") || m.areEqual(str, "PROPPATCH") || m.areEqual(str, "REPORT")))) {
                throw new IllegalArgumentException(a.y("method ", str, " must have a request body.").toString());
            }
        } else if (!f.a(str)) {
            throw new IllegalArgumentException(a.y("method ", str, " must not have a request body.").toString());
        }
        this.f3813b = str;
        this.d = requestBody;
        return this;
    }

    public Request$a d(String str) {
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.c.d(str);
        return this;
    }

    public <T> Request$a e(Class<? super T> cls, T t) {
        m.checkParameterIsNotNull(cls, "type");
        if (t == null) {
            this.e.remove(cls);
        } else {
            if (this.e.isEmpty()) {
                this.e = new LinkedHashMap();
            }
            Map<Class<?>, Object> map = this.e;
            T tCast = cls.cast(t);
            if (tCast == null) {
                m.throwNpe();
            }
            map.put(cls, tCast);
        }
        return this;
    }

    public Request$a f(String str) {
        m.checkParameterIsNotNull(str, "url");
        if (t.startsWith(str, "ws:", true)) {
            StringBuilder sbU = a.U("http:");
            String strSubstring = str.substring(3);
            m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
            sbU.append(strSubstring);
            str = sbU.toString();
        } else if (t.startsWith(str, "wss:", true)) {
            StringBuilder sbU2 = a.U("https:");
            String strSubstring2 = str.substring(4);
            m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
            sbU2.append(strSubstring2);
            str = sbU2.toString();
        }
        m.checkParameterIsNotNull(str, "$this$toHttpUrl");
        w$a w_a = new w$a();
        w_a.e(null, str);
        g(w_a.b());
        return this;
    }

    public Request$a g(w wVar) {
        m.checkParameterIsNotNull(wVar, "url");
        this.a = wVar;
        return this;
    }

    public Request$a(Request request) {
        Map<Class<?>, Object> mutableMap;
        m.checkParameterIsNotNull(request, "request");
        this.e = new LinkedHashMap();
        this.a = request.url;
        this.f3813b = request.method;
        this.d = request.body;
        if (request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String.isEmpty()) {
            mutableMap = new LinkedHashMap<>();
        } else {
            mutableMap = h0.toMutableMap(request.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_TAGS java.lang.String);
        }
        this.e = mutableMap;
        this.c = request.headers.e();
    }
}
