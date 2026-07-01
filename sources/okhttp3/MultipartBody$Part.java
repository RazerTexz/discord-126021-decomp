package okhttp3;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.w;
import d0.z.d.m;
import f0.e0.c;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MultipartBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MultipartBody$Part {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final Headers headers;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final RequestBody body;

    public MultipartBody$Part(Headers headers, RequestBody requestBody, DefaultConstructorMarker defaultConstructorMarker) {
        this.headers = headers;
        this.body = requestBody;
    }

    public static final MultipartBody$Part a(Headers headers, RequestBody requestBody) {
        m.checkParameterIsNotNull(requestBody, "body");
        if (!(headers.c("Content-Type") == null)) {
            throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
        }
        if (headers.c("Content-Length") == null) {
            return new MultipartBody$Part(headers, requestBody, null);
        }
        throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
    }

    public static final MultipartBody$Part b(String str, String str2, RequestBody requestBody) {
        m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(requestBody, "body");
        StringBuilder sb = new StringBuilder();
        sb.append("form-data; name=");
        MultipartBody$b multipartBody$b = MultipartBody.f;
        multipartBody$b.a(sb, str);
        if (str2 != null) {
            sb.append("; filename=");
            multipartBody$b.a(sb, str2);
        }
        String string = sb.toString();
        m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        ArrayList arrayList = new ArrayList(20);
        m.checkParameterIsNotNull("Content-Disposition", ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(string, "value");
        if (1 == 0) {
            throw new IllegalArgumentException("name is empty".toString());
        }
        for (int i = 0; i < 19; i++) {
            char cCharAt = "Content-Disposition".charAt(i);
            if (!('!' <= cCharAt && '~' >= cCharAt)) {
                throw new IllegalArgumentException(c.j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), "Content-Disposition").toString());
            }
        }
        m.checkParameterIsNotNull("Content-Disposition", ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkParameterIsNotNull(string, "value");
        arrayList.add("Content-Disposition");
        arrayList.add(w.trim(string).toString());
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return a(new Headers((String[]) array, null), requestBody);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
