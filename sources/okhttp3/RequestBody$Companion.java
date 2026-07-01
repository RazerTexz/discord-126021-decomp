package okhttp3;

import d0.g0.c;
import d0.z.d.m;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RequestBody$Companion {
    public RequestBody$Companion() {
    }

    public static RequestBody c(RequestBody$Companion requestBody$Companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        if ((i3 & 8) != 0) {
            i2 = bArr.length;
        }
        Objects.requireNonNull(requestBody$Companion);
        m.checkParameterIsNotNull(bArr, "content");
        return requestBody$Companion.b(bArr, mediaType, i, i2);
    }

    public static /* synthetic */ RequestBody d(RequestBody$Companion requestBody$Companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3) {
        if ((i3 & 1) != 0) {
            mediaType = null;
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = bArr.length;
        }
        return requestBody$Companion.b(bArr, mediaType, i, i2);
    }

    public final RequestBody a(String str, MediaType mediaType) {
        m.checkParameterIsNotNull(str, "$this$toRequestBody");
        Charset charset = c.a;
        if (mediaType != null) {
            Pattern pattern = MediaType.a;
            Charset charsetA = mediaType.a(null);
            if (charsetA == null) {
                MediaType$a mediaType$a = MediaType.c;
                mediaType = MediaType$a.b(mediaType + "; charset=utf-8");
            } else {
                charset = charsetA;
            }
        }
        byte[] bytes = str.getBytes(charset);
        m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return b(bytes, mediaType, 0, bytes.length);
    }

    public final RequestBody b(byte[] bArr, MediaType mediaType, int i, int i2) {
        m.checkParameterIsNotNull(bArr, "$this$toRequestBody");
        f0.e0.c.c(bArr.length, i, i2);
        return new RequestBody$Companion$a(bArr, mediaType, i2, i);
    }

    public RequestBody$Companion(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
