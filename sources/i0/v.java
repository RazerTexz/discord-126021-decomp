package i0;

import com.discord.models.domain.ModelAuditLogEntry;
import f0.w$b;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import okhttp3.Headers;
import okhttp3.Headers$a;
import okhttp3.MediaType;
import okhttp3.MediaType$a;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody$Part;
import okhttp3.MultipartBody$a;
import okhttp3.Request$a;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3759b = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    public final String c;
    public final f0.w d;
    public String e;
    public f0.w$a f;
    public final Request$a g = new Request$a();
    public final Headers$a h;
    public MediaType i;
    public final boolean j;
    public MultipartBody$a k;
    public f0.u$a l;
    public RequestBody m;

    public v(String str, f0.w wVar, String str2, Headers headers, MediaType mediaType, boolean z2, boolean z3, boolean z4) {
        this.c = str;
        this.d = wVar;
        this.e = str2;
        this.i = mediaType;
        this.j = z2;
        if (headers != null) {
            this.h = headers.e();
        } else {
            this.h = new Headers$a();
        }
        if (z3) {
            this.l = new f0.u$a();
        } else if (z4) {
            MultipartBody$a multipartBody$a = new MultipartBody$a();
            this.k = multipartBody$a;
            multipartBody$a.c(MultipartBody.f3809b);
        }
    }

    public void a(String str, String str2, boolean z2) {
        if (z2) {
            f0.u$a u_a = this.l;
            Objects.requireNonNull(u_a);
            d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkParameterIsNotNull(str2, "value");
            List<String> list = u_a.a;
            w$b w_b = f0.w.f3681b;
            list.add(w$b.a(w_b, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, u_a.c, 83));
            u_a.f3679b.add(w$b.a(w_b, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, u_a.c, 83));
            return;
        }
        f0.u$a u_a2 = this.l;
        Objects.requireNonNull(u_a2);
        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkParameterIsNotNull(str2, "value");
        List<String> list2 = u_a2.a;
        w$b w_b2 = f0.w.f3681b;
        list2.add(w$b.a(w_b2, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, u_a2.c, 91));
        u_a2.f3679b.add(w$b.a(w_b2, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, u_a2.c, 91));
    }

    public void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.h.a(str, str2);
            return;
        }
        try {
            MediaType$a mediaType$a = MediaType.c;
            this.i = MediaType$a.a(str2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(b.d.b.a.a.w("Malformed content type: ", str2), e);
        }
    }

    public void c(Headers headers, RequestBody requestBody) {
        MultipartBody$a multipartBody$a = this.k;
        Objects.requireNonNull(multipartBody$a);
        d0.z.d.m.checkParameterIsNotNull(requestBody, "body");
        d0.z.d.m.checkParameterIsNotNull(requestBody, "body");
        if (!((headers != null ? headers.c("Content-Type") : null) == null)) {
            throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
        }
        if (!((headers != null ? headers.c("Content-Length") : null) == null)) {
            throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }
        multipartBody$a.a(new MultipartBody$Part(headers, requestBody, null));
    }

    public void d(String str, String str2, boolean z2) {
        String str3 = this.e;
        if (str3 != null) {
            f0.w$a w_aG = this.d.g(str3);
            this.f = w_aG;
            if (w_aG == null) {
                StringBuilder sbU = b.d.b.a.a.U("Malformed URL. Base: ");
                sbU.append(this.d);
                sbU.append(", Relative: ");
                sbU.append(this.e);
                throw new IllegalArgumentException(sbU.toString());
            }
            this.e = null;
        }
        if (z2) {
            this.f.a(str, str2);
            return;
        }
        f0.w$a w_a = this.f;
        Objects.requireNonNull(w_a);
        d0.z.d.m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (w_a.h == null) {
            w_a.h = new ArrayList();
        }
        List<String> list = w_a.h;
        if (list == null) {
            d0.z.d.m.throwNpe();
        }
        w$b w_b = f0.w.f3681b;
        list.add(w$b.a(w_b, str, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219));
        List<String> list2 = w_a.h;
        if (list2 == null) {
            d0.z.d.m.throwNpe();
        }
        list2.add(str2 != null ? w$b.a(w_b, str2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, null, 219) : null);
    }
}
