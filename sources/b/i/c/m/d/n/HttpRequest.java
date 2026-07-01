package b.i.c.m.d.n;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import f0.CacheControl;
import f0.HttpUrl;
import f0.OkHttpClient;
import f0.e0.Util7;
import f0.e0.g.RealCall;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: renamed from: b.i.c.m.d.n.a, reason: use source file name */
/* JADX INFO: compiled from: HttpRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public class HttpRequest {
    public static final OkHttpClient a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1736b;
    public final String c;
    public final Map<String, String> d;
    public MultipartBody.a f = null;
    public final Map<String, String> e = new HashMap();

    static {
        OkHttpClient.a aVarF = new OkHttpClient().f();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
        aVarF.w = Util7.b("timeout", 10000L, timeUnit);
        a = new OkHttpClient(aVarF);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;)V */
    public HttpRequest(int i, String str, Map map) {
        this.f1736b = i;
        this.c = str;
        this.d = map;
    }

    public HttpResponse a() throws IOException {
        HttpUrl httpUrlB;
        Request.a aVar = new Request.a();
        CacheControl cacheControl = new CacheControl(true, false, -1, -1, false, false, false, -1, -1, false, false, false, null, null);
        Intrinsics3.checkParameterIsNotNull(cacheControl, "cacheControl");
        String string = cacheControl.toString();
        if (string.length() == 0) {
            aVar.d("Cache-Control");
        } else {
            aVar.b("Cache-Control", string);
        }
        String str = this.c;
        Intrinsics3.checkParameterIsNotNull(str, "$this$toHttpUrlOrNull");
        try {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toHttpUrl");
            HttpUrl.a aVar2 = new HttpUrl.a();
            aVar2.e(null, str);
            httpUrlB = aVar2.b();
        } catch (IllegalArgumentException unused) {
            httpUrlB = null;
        }
        HttpUrl.a aVarF = httpUrlB.f();
        for (Map.Entry<String, String> entry : this.d.entrySet()) {
            aVarF.a(entry.getKey(), entry.getValue());
        }
        aVar.g(aVarF.b());
        for (Map.Entry<String, String> entry2 : this.e.entrySet()) {
            aVar.b(entry2.getKey(), entry2.getValue());
        }
        MultipartBody.a aVar3 = this.f;
        aVar.c(b.c.a.y.b.n(this.f1736b), aVar3 == null ? null : aVar3.b());
        Response responseExecute = ((RealCall) a.b(aVar.a())).execute();
        ResponseBody responseBody = responseExecute.body;
        return new HttpResponse(responseExecute.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String, responseBody != null ? responseBody.d() : null, responseExecute.headers);
    }

    public HttpRequest b(String str, String str2) {
        if (this.f == null) {
            MultipartBody.a aVar = new MultipartBody.a();
            aVar.c(MultipartBody.f3809b);
            this.f = aVar;
        }
        MultipartBody.a aVar2 = this.f;
        Objects.requireNonNull(aVar2);
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(str2, "value");
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(str2, "value");
        aVar2.a(MultipartBody.Part.b(str, null, RequestBody.INSTANCE.a(str2, null)));
        this.f = aVar2;
        return this;
    }

    public HttpRequest c(String str, String str2, String str3, File file) {
        MediaType.Companion aVar = MediaType.INSTANCE;
        RequestBody requestBodyCreate = RequestBody.create(MediaType.Companion.b(str3), file);
        if (this.f == null) {
            MultipartBody.a aVar2 = new MultipartBody.a();
            aVar2.c(MultipartBody.f3809b);
            this.f = aVar2;
        }
        MultipartBody.a aVar3 = this.f;
        Objects.requireNonNull(aVar3);
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkParameterIsNotNull(requestBodyCreate, "body");
        aVar3.a(MultipartBody.Part.b(str, str2, requestBodyCreate));
        this.f = aVar3;
        return this;
    }
}
