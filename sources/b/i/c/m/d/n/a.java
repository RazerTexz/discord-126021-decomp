package b.i.c.m.d.n;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;
import f0.d;
import f0.e0.g.e;
import f0.w;
import f0.w$a;
import f0.x;
import f0.x$a;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MediaType$a;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody$Part;
import okhttp3.MultipartBody$a;
import okhttp3.Request$a;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: compiled from: HttpRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public static final x a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1736b;
    public final String c;
    public final Map<String, String> d;
    public MultipartBody$a f = null;
    public final Map<String, String> e = new HashMap();

    static {
        x$a x_aF = new x().f();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        m.checkParameterIsNotNull(timeUnit, "unit");
        x_aF.w = f0.e0.c.b("timeout", 10000L, timeUnit);
        a = new x(x_aF);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;)V */
    public a(int i, String str, Map map) {
        this.f1736b = i;
        this.c = str;
        this.d = map;
    }

    public c a() throws IOException {
        w wVarB;
        Request$a request$a = new Request$a();
        d dVar = new d(true, false, -1, -1, false, false, false, -1, -1, false, false, false, null, null);
        m.checkParameterIsNotNull(dVar, "cacheControl");
        String string = dVar.toString();
        if (string.length() == 0) {
            request$a.d("Cache-Control");
        } else {
            request$a.b("Cache-Control", string);
        }
        String str = this.c;
        m.checkParameterIsNotNull(str, "$this$toHttpUrlOrNull");
        try {
            m.checkParameterIsNotNull(str, "$this$toHttpUrl");
            w$a w_a = new w$a();
            w_a.e(null, str);
            wVarB = w_a.b();
        } catch (IllegalArgumentException unused) {
            wVarB = null;
        }
        w$a w_aF = wVarB.f();
        for (Map$Entry<String, String> map$Entry : this.d.entrySet()) {
            w_aF.a(map$Entry.getKey(), map$Entry.getValue());
        }
        request$a.g(w_aF.b());
        for (Map$Entry<String, String> map$Entry2 : this.e.entrySet()) {
            request$a.b(map$Entry2.getKey(), map$Entry2.getValue());
        }
        MultipartBody$a multipartBody$a = this.f;
        request$a.c(b.c.a.y.b.n(this.f1736b), multipartBody$a == null ? null : multipartBody$a.b());
        Response responseExecute = ((e) a.b(request$a.a())).execute();
        ResponseBody responseBody = responseExecute.body;
        return new c(responseExecute.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String, responseBody != null ? responseBody.d() : null, responseExecute.headers);
    }

    public a b(String str, String str2) {
        if (this.f == null) {
            MultipartBody$a multipartBody$a = new MultipartBody$a();
            multipartBody$a.c(MultipartBody.f3809b);
            this.f = multipartBody$a;
        }
        MultipartBody$a multipartBody$a2 = this.f;
        Objects.requireNonNull(multipartBody$a2);
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(str2, "value");
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(str2, "value");
        multipartBody$a2.a(MultipartBody$Part.b(str, null, RequestBody.Companion.a(str2, null)));
        this.f = multipartBody$a2;
        return this;
    }

    public a c(String str, String str2, String str3, File file) {
        MediaType$a mediaType$a = MediaType.c;
        RequestBody requestBodyCreate = RequestBody.create(MediaType$a.b(str3), file);
        if (this.f == null) {
            MultipartBody$a multipartBody$a = new MultipartBody$a();
            multipartBody$a.c(MultipartBody.f3809b);
            this.f = multipartBody$a;
        }
        MultipartBody$a multipartBody$a2 = this.f;
        Objects.requireNonNull(multipartBody$a2);
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(requestBodyCreate, "body");
        multipartBody$a2.a(MultipartBody$Part.b(str, str2, requestBodyCreate));
        this.f = multipartBody$a2;
        return this;
    }
}
