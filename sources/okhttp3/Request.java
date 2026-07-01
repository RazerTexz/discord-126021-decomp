package okhttp3;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.t.n;
import d0.z.d.m;
import f0.d;
import f0.w;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Request {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public d lazyCacheControl;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final w url;

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public final String method;

    /* JADX INFO: renamed from: d, reason: from kotlin metadata */
    public final Headers headers;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public final RequestBody body;

    /* JADX INFO: renamed from: f, reason: from kotlin metadata */
    public final Map<Class<?>, Object> tags;

    public Request(w wVar, String str, Headers headers, RequestBody requestBody, Map<Class<?>, ? extends Object> map) {
        m.checkParameterIsNotNull(wVar, "url");
        m.checkParameterIsNotNull(str, "method");
        m.checkParameterIsNotNull(headers, "headers");
        m.checkParameterIsNotNull(map, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        this.url = wVar;
        this.method = str;
        this.headers = headers;
        this.body = requestBody;
        this.tags = map;
    }

    public final d a() {
        d dVar = this.lazyCacheControl;
        if (dVar != null) {
            return dVar;
        }
        d dVarB = d.a.b(this.headers);
        this.lazyCacheControl = dVarB;
        return dVarB;
    }

    public final String b(String name) {
        m.checkParameterIsNotNull(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return this.headers.c(name);
    }

    public String toString() {
        StringBuilder sbU = a.U("Request{method=");
        sbU.append(this.method);
        sbU.append(", url=");
        sbU.append(this.url);
        if (this.headers.size() != 0) {
            sbU.append(", headers=[");
            int i = 0;
            for (Pair<? extends String, ? extends String> pair : this.headers) {
                int i2 = i + 1;
                if (i < 0) {
                    n.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair2 = pair;
                String strComponent1 = pair2.component1();
                String strComponent2 = pair2.component2();
                if (i > 0) {
                    sbU.append(", ");
                }
                sbU.append(strComponent1);
                sbU.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
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
        m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
