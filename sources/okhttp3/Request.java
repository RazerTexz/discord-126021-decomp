package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Pair;
import okhttp3.Headers;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12267d;
import p600f0.C12379w;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p606h.C12300f;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Request {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public C12267d lazyCacheControl;

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public final C12379w url;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String method;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Headers headers;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final RequestBody body;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Map<Class<?>, Object> tags;

    public Request(C12379w c12379w, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        C12238m.checkParameterIsNotNull(c12379w, "url");
        C12238m.checkParameterIsNotNull(str, "method");
        C12238m.checkParameterIsNotNull(headers, "headers");
        C12238m.checkParameterIsNotNull(map, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        this.url = c12379w;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    /* JADX INFO: renamed from: a */
    public final C12267d m10976a() {
        C12267d c12267d = this.lazyCacheControl;
        if (c12267d != null) {
            return c12267d;
        }
        C12267d c12267dM10108b = C12267d.f25373a.m10108b(this.headers);
        this.lazyCacheControl = c12267dM10108b;
        return c12267dM10108b;
    }

    /* JADX INFO: renamed from: b */
    public final String m10977b(String name) {
        C12238m.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.headers.m10954c(name);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Request{method=");
        sbM833U.append(this.method);
        sbM833U.append(", url=");
        sbM833U.append(this.url);
        if (this.headers.size() != 0) {
            sbM833U.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    C12147n.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strComponent1 = pair2.component1();
                String strComponent2 = pair2.component2();
                if (i > 0) {
                    sbM833U.append(", ");
                }
                sbM833U.append(strComponent1);
                sbM833U.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                sbM833U.append(strComponent2);
                i = i2;
            }
            sbM833U.append(']');
        }
        if (!this.tags.isEmpty()) {
            sbM833U.append(", tags=");
            sbM833U.append(this.tags);
        }
        sbM833U.append('}');
        String string = sbM833U.toString();
        C12238m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    /* JADX INFO: renamed from: okhttp3.Request$a */
    /* JADX INFO: compiled from: Request.kt */
    public static class C12935a {

        /* JADX INFO: renamed from: a */
        public C12379w f27543a;

        /* JADX INFO: renamed from: b */
        public String f27544b;

        /* JADX INFO: renamed from: c */
        public Headers.C12930a f27545c;

        /* JADX INFO: renamed from: d */
        public RequestBody f27546d;

        /* JADX INFO: renamed from: e */
        public Map<Class<?>, Object> f27547e;

        public C12935a() {
            this.f27547e = new LinkedHashMap();
            this.f27544b = ShareTarget.METHOD_GET;
            this.f27545c = new Headers.C12930a();
        }

        /* JADX INFO: renamed from: a */
        public Request m10978a() {
            C12379w c12379w = this.f27543a;
            if (c12379w != null) {
                return new Request(c12379w, this.f27544b, this.f27545c.m10960c(), this.f27546d, C12272c.m10116A(this.f27547e));
            }
            throw new IllegalStateException("url == null".toString());
        }

        /* JADX INFO: renamed from: b */
        public C12935a m10979b(String str, String str2) {
            C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(str2, "value");
            Headers.C12930a c12930a = this.f27545c;
            Objects.requireNonNull(c12930a);
            C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(str2, "value");
            Headers.Companion c12931b = Headers.INSTANCE;
            c12931b.m10962a(str);
            c12931b.m10963b(str2, str);
            c12930a.m10961d(str);
            c12930a.m10959b(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: c */
        public C12935a m10980c(String str, RequestBody requestBody) {
            C12238m.checkParameterIsNotNull(str, "method");
            if (!(str.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (requestBody == null) {
                C12238m.checkParameterIsNotNull(str, "method");
                if (!(!(C12238m.areEqual(str, ShareTarget.METHOD_POST) || C12238m.areEqual(str, "PUT") || C12238m.areEqual(str, "PATCH") || C12238m.areEqual(str, "PROPPATCH") || C12238m.areEqual(str, "REPORT")))) {
                    throw new IllegalArgumentException(C1643a.m886y("method ", str, " must have a request body.").toString());
                }
            } else if (!C12300f.m10226a(str)) {
                throw new IllegalArgumentException(C1643a.m886y("method ", str, " must not have a request body.").toString());
            }
            this.f27544b = str;
            this.f27546d = requestBody;
            return this;
        }

        /* JADX INFO: renamed from: d */
        public C12935a m10981d(String str) {
            C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            this.f27545c.m10961d(str);
            return this;
        }

        /* JADX INFO: renamed from: e */
        public <T> C12935a m10982e(Class<? super T> cls, T t) {
            C12238m.checkParameterIsNotNull(cls, "type");
            if (t == null) {
                this.f27547e.remove(cls);
            } else {
                if (this.f27547e.isEmpty()) {
                    this.f27547e = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.f27547e;
                T tCast = cls.cast(t);
                if (tCast == null) {
                    C12238m.throwNpe();
                }
                map.put(cls, tCast);
            }
            return this;
        }

        /* JADX INFO: renamed from: f */
        public C12935a m10983f(String str) {
            C12238m.checkParameterIsNotNull(str, "url");
            if (C12103t.startsWith(str, "ws:", true)) {
                StringBuilder sbM833U = C1643a.m833U("http:");
                String strSubstring = str.substring(3);
                C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
                sbM833U.append(strSubstring);
                str = sbM833U.toString();
            } else if (C12103t.startsWith(str, "wss:", true)) {
                StringBuilder sbM833U2 = C1643a.m833U("https:");
                String strSubstring2 = str.substring(4);
                C12238m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.String).substring(startIndex)");
                sbM833U2.append(strSubstring2);
                str = sbM833U2.toString();
            }
            C12238m.checkParameterIsNotNull(str, "$this$toHttpUrl");
            C12379w.a aVar = new C12379w.a();
            aVar.m10412e(null, str);
            m10984g(aVar.m10409b());
            return this;
        }

        /* JADX INFO: renamed from: g */
        public C12935a m10984g(C12379w c12379w) {
            C12238m.checkParameterIsNotNull(c12379w, "url");
            this.f27543a = c12379w;
            return this;
        }

        public C12935a(Request request) {
            Map<Class<?>, Object> mutableMap;
            C12238m.checkParameterIsNotNull(request, "request");
            this.f27547e = new LinkedHashMap();
            this.f27543a = request.url;
            this.f27544b = request.method;
            this.f27546d = request.body;
            if (request.tags.isEmpty()) {
                mutableMap = new LinkedHashMap<>();
            } else {
                mutableMap = C12136h0.toMutableMap(request.tags);
            }
            this.f27547e = mutableMap;
            this.f27545c = request.headers.m10956e();
        }
    }
}
