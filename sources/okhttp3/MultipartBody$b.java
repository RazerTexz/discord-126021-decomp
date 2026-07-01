package okhttp3;

import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MultipartBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MultipartBody$b {
    public MultipartBody$b(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void a(StringBuilder sb, String str) {
        m.checkParameterIsNotNull(sb, "$this$appendQuotedString");
        m.checkParameterIsNotNull(str, "key");
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\"');
    }
}
