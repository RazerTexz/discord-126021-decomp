package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import f0.CacheControl;
import f0.HttpUrl;
import f0.e0.Util7;
import f0.e0.h.HttpMethod;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Tuples2;
import okhttp3.Headers;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Request {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public CacheControl lazyCacheControl;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final HttpUrl url;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String method;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Headers headers;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final RequestBody body;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Map<Class<?>, Object> tags;

    public Request(HttpUrl httpUrl, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(str, "method");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        Intrinsics3.checkParameterIsNotNull(map, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        this.url = httpUrl;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    public final CacheControl a() {
        CacheControl cacheControl = this.lazyCacheControl;
        if (cacheControl != null) {
            return cacheControl;
        }
        CacheControl cacheControlB = CacheControl.a.b(this.headers);
        this.lazyCacheControl = cacheControlB;
        return cacheControlB;
    }

    public final String b(String name) {
        Intrinsics3.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.headers.c(name);
    }

    public String toString() {
        StringBuilder sbU = outline.U("Request{method=");
        sbU.append(this.method);
        sbU.append(", url=");
        sbU.append(this.url);
        if (this.headers.size() != 0) {
            sbU.append(", headers=[");
            int i = 0;
            for (Tuples2<? extends String, ? extends String> tuples2 : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                Tuples2<? extends String, ? extends String> tuples3 = tuples2;
                String strComponent1 = tuples3.component1();
                String strComponent2 = tuples3.component2();
                if (i > 0) {
                    sbU.append(", ");
                }
                sbU.append(strComponent1);
                sbU.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                sbU.append(strComponent2);
                i = i2;
            }
            sbU.append(']');
        }
        if (!this.tags.isEmpty()) {
            sbU.append(", tags=");
            sbU.append(this.tags);
        }
        sbU.append('}');
        String string = sbU.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: compiled from: Request.kt */
    public static class a {
        public HttpUrl a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f3813b;
        public Headers.a c;
        public RequestBody d;
        public Map<Class<?>, Object> e;

        public a() {
            this.e = new LinkedHashMap();
            this.f3813b = ShareTarget.METHOD_GET;
            this.c = new Headers.a();
        }

        public Request a() {
            HttpUrl httpUrl = this.a;
            if (httpUrl != null) {
                return new Request(httpUrl, this.f3813b, this.c.c(), this.d, Util7.A(this.e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a b(String str, String str2) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            Headers.a aVar = this.c;
            Objects.requireNonNull(aVar);
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(str2, "value");
            Headers.Companion bVar = Headers.INSTANCE;
            bVar.a(str);
            bVar.b(str2, str);
            aVar.d(str);
            aVar.b(str, str2);
            return this;
        }

        public a c(String str, RequestBody requestBody) {
            Intrinsics3.checkParameterIsNotNull(str, "method");
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (requestBody == null) {
                Intrinsics3.checkParameterIsNotNull(str, "method");
                if (!(!(Intrinsics3.areEqual(str, ShareTarget.METHOD_POST) || Intrinsics3.areEqual(str, "PUT") || Intrinsics3.areEqual(str, "PATCH") || Intrinsics3.areEqual(str, "PROPPATCH") || Intrinsics3.areEqual(str, "REPORT")))) {
                    throw new IllegalArgumentException(outline.y("method ", str, " must have a request body.").toString());
                }
            } else if (!HttpMethod.a(str)) {
                throw new IllegalArgumentException(outline.y("method ", str, " must not have a request body.").toString());
            }
            this.f3813b = str;
            this.d = requestBody;
            return this;
        }

        public a d(String str) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.c.d(str);
            return this;
        }

        public <T> a e(Class<? super T> cls, T t) {
            Intrinsics3.checkParameterIsNotNull(cls, "type");
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.e;
                T tCast = cls.cast(t);
                if (tCast == null) {
                    Intrinsics3.throwNpe();
                }
                map.put(cls, tCast);
            }
            return this;
        }

        public a f(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "url");
            if (StringsJVM.startsWith(str, "ws:", true)) {
                StringBuilder sbU = outline.U("http:");
                String strSubstring = str.substring(3);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sbU.append(strSubstring);
                str = sbU.toString();
            } else if (StringsJVM.startsWith(str, "wss:", true)) {
                StringBuilder sbU2 = outline.U("https:");
                String strSubstring2 = str.substring(4);
                Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                sbU2.append(strSubstring2);
                str = sbU2.toString();
            }
            Intrinsics3.checkParameterIsNotNull(str, "$this$toHttpUrl");
            HttpUrl.a aVar = new HttpUrl.a();
            aVar.e(null, str);
            g(aVar.b());
            return this;
        }

        public a g(HttpUrl httpUrl) {
            Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
            this.a = httpUrl;
            return this;
        }

        public a(Request request) {
            Map<Class<?>, Object> mutableMap;
            Intrinsics3.checkParameterIsNotNull(request, "request");
            this.e = new LinkedHashMap();
            this.a = request.url;
            this.f3813b = request.method;
            this.d = request.body;
            if (request.tags.isEmpty()) {
                mutableMap = new LinkedHashMap<>();
            } else {
                mutableMap = Maps6.toMutableMap(request.tags);
            }
            this.e = mutableMap;
            this.c = request.headers.e();
        }
    }
}
