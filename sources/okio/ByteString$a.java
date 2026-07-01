package okio;

import b.d.b.a.a;
import b.i.a.f.e.o.f;
import d0.g0.c;
import d0.t.j;
import d0.z.d.m;
import g0.z.b;
import java.nio.charset.Charset;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ByteString$a {
    public ByteString$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public static ByteString d(ByteString$a byteString$a, byte[] bArr, int i, int i2, int i3) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        m.checkParameterIsNotNull(bArr, "$this$toByteString");
        f.B(bArr.length, i, i2);
        return new ByteString(j.copyOfRange(bArr, i, i2 + i));
    }

    public final ByteString a(String str) {
        m.checkParameterIsNotNull(str, "$this$decodeHex");
        if (!(str.length() % 2 == 0)) {
            throw new IllegalArgumentException(a.w("Unexpected hex string: ", str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (b.a(str.charAt(i2 + 1)) + (b.a(str.charAt(i2)) << 4));
        }
        return new ByteString(bArr);
    }

    public final ByteString b(String str, Charset charset) {
        m.checkParameterIsNotNull(str, "$this$encode");
        m.checkParameterIsNotNull(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        return new ByteString(bytes);
    }

    public final ByteString c(String str) {
        m.checkParameterIsNotNull(str, "$this$encodeUtf8");
        m.checkParameterIsNotNull(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(c.a);
        m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
        ByteString byteString = new ByteString(bytes);
        byteString.utf8 = str;
        return byteString;
    }
}
