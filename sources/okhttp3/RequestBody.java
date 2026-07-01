package okhttp3;

import d0.z.d.m;
import f0.a0;
import f0.z;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RequestBody {
    public static final RequestBody$Companion Companion = new RequestBody$Companion(null);

    public static final RequestBody create(File file, MediaType mediaType) {
        Objects.requireNonNull(Companion);
        m.checkParameterIsNotNull(file, "$this$asRequestBody");
        return new z(file, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.a(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return RequestBody$Companion.c(Companion, mediaType, bArr, 0, 0, 12);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i) {
        return RequestBody$Companion.c(Companion, mediaType, bArr, i, 0, 8);
    }

    public static final RequestBody create(byte[] bArr) {
        return RequestBody$Companion.d(Companion, bArr, null, 0, 0, 7);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return RequestBody$Companion.d(Companion, bArr, mediaType, 0, 0, 6);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i) {
        return RequestBody$Companion.d(Companion, bArr, mediaType, i, 0, 4);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i, int i2) {
        return Companion.b(bArr, mediaType, i, i2);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink sink) throws IOException;

    public static final RequestBody create(MediaType mediaType, File file) {
        Objects.requireNonNull(Companion);
        m.checkParameterIsNotNull(file, "file");
        m.checkParameterIsNotNull(file, "$this$asRequestBody");
        return new z(file, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        RequestBody$Companion requestBody$Companion = Companion;
        Objects.requireNonNull(requestBody$Companion);
        m.checkParameterIsNotNull(str, "content");
        return requestBody$Companion.a(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        Objects.requireNonNull(Companion);
        m.checkParameterIsNotNull(byteString, "content");
        m.checkParameterIsNotNull(byteString, "$this$toRequestBody");
        return new a0(byteString, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        RequestBody$Companion requestBody$Companion = Companion;
        Objects.requireNonNull(requestBody$Companion);
        m.checkParameterIsNotNull(bArr, "content");
        return requestBody$Companion.b(bArr, mediaType, i, i2);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        Objects.requireNonNull(Companion);
        m.checkParameterIsNotNull(byteString, "$this$toRequestBody");
        return new a0(byteString, mediaType);
    }
}
