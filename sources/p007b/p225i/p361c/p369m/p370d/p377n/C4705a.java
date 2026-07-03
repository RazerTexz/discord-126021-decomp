package p007b.p225i.p361c.p369m.p370d.p377n;

import com.discord.models.domain.ModelAuditLogEntry;
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
import p007b.p085c.p086a.p095y.C1563b;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12267d;
import p600f0.C12379w;
import p600f0.C12380x;
import p600f0.p601e0.C12272c;
import p600f0.p601e0.p605g.C12285e;

/* JADX INFO: renamed from: b.i.c.m.d.n.a */
/* JADX INFO: compiled from: HttpRequest.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4705a {

    /* JADX INFO: renamed from: a */
    public static final C12380x f12657a;

    /* JADX INFO: renamed from: b */
    public final int f12658b;

    /* JADX INFO: renamed from: c */
    public final String f12659c;

    /* JADX INFO: renamed from: d */
    public final Map<String, String> f12660d;

    /* JADX INFO: renamed from: f */
    public MultipartBody.C12933a f12662f = null;

    /* JADX INFO: renamed from: e */
    public final Map<String, String> f12661e = new HashMap();

    static {
        C12380x.a aVarM10418f = new C12380x().m10418f();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        C12238m.checkParameterIsNotNull(timeUnit, "unit");
        aVarM10418f.f26051w = C12272c.m10121b("timeout", 10000L, timeUnit);
        f12657a = new C12380x(aVarM10418f);
    }

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;)V */
    public C4705a(int i, String str, Map map) {
        this.f12658b = i;
        this.f12659c = str;
        this.f12660d = map;
    }

    /* JADX INFO: renamed from: a */
    public C4707c m6621a() throws IOException {
        C12379w c12379wM10409b;
        Request.C12935a c12935a = new Request.C12935a();
        C12267d c12267d = new C12267d(true, false, -1, -1, false, false, false, -1, -1, false, false, false, null, null);
        C12238m.checkParameterIsNotNull(c12267d, "cacheControl");
        String string = c12267d.toString();
        if (string.length() == 0) {
            c12935a.m10981d("Cache-Control");
        } else {
            c12935a.m10979b("Cache-Control", string);
        }
        String str = this.f12659c;
        C12238m.checkParameterIsNotNull(str, "$this$toHttpUrlOrNull");
        try {
            C12238m.checkParameterIsNotNull(str, "$this$toHttpUrl");
            C12379w.a aVar = new C12379w.a();
            aVar.m10412e(null, str);
            c12379wM10409b = aVar.m10409b();
        } catch (IllegalArgumentException unused) {
            c12379wM10409b = null;
        }
        C12379w.a aVarM10404f = c12379wM10409b.m10404f();
        for (Map.Entry<String, String> entry : this.f12660d.entrySet()) {
            aVarM10404f.m10408a(entry.getKey(), entry.getValue());
        }
        c12935a.m10984g(aVarM10404f.m10409b());
        for (Map.Entry<String, String> entry2 : this.f12661e.entrySet()) {
            c12935a.m10979b(entry2.getKey(), entry2.getValue());
        }
        MultipartBody.C12933a c12933a = this.f12662f;
        c12935a.m10980c(C1563b.m764n(this.f12658b), c12933a == null ? null : c12933a.m10973b());
        Response responseExecute = ((C12285e) f12657a.mo10114b(c12935a.m10978a())).execute();
        ResponseBody responseBody = responseExecute.body;
        return new C4707c(responseExecute.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String, responseBody != null ? responseBody.m10998d() : null, responseExecute.headers);
    }

    /* JADX INFO: renamed from: b */
    public C4705a m6622b(String str, String str2) {
        if (this.f12662f == null) {
            MultipartBody.C12933a c12933a = new MultipartBody.C12933a();
            c12933a.m10974c(MultipartBody.f27522b);
            this.f12662f = c12933a;
        }
        MultipartBody.C12933a c12933a2 = this.f12662f;
        Objects.requireNonNull(c12933a2);
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull(str2, "value");
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull(str2, "value");
        c12933a2.m10972a(MultipartBody.Part.m10971b(str, null, RequestBody.INSTANCE.m10987a(str2, null)));
        this.f12662f = c12933a2;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public C4705a m6623c(String str, String str2, String str3, File file) {
        MediaType.Companion c12932a = MediaType.INSTANCE;
        RequestBody requestBodyCreate = RequestBody.create(MediaType.Companion.m10968b(str3), file);
        if (this.f12662f == null) {
            MultipartBody.C12933a c12933a = new MultipartBody.C12933a();
            c12933a.m10974c(MultipartBody.f27522b);
            this.f12662f = c12933a;
        }
        MultipartBody.C12933a c12933a2 = this.f12662f;
        Objects.requireNonNull(c12933a2);
        C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkParameterIsNotNull(requestBodyCreate, "body");
        c12933a2.m10972a(MultipartBody.Part.m10971b(str, str2, requestBodyCreate));
        this.f12662f = c12933a2;
        return this;
    }
}
