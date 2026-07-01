package okhttp3;

import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import f0.RequestBody2;
import f0.RequestBody3;
import f0.e0.Util7;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MediaType;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RequestBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: RequestBody.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: RequestBody.kt */
        public static final class a extends RequestBody {
            public final /* synthetic */ byte[] a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ MediaType f3814b;
            public final /* synthetic */ int c;
            public final /* synthetic */ int d;

            public a(byte[] bArr, MediaType mediaType, int i, int i2) {
                this.a = bArr;
                this.f3814b = mediaType;
                this.c = i;
                this.d = i2;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return this.c;
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return this.f3814b;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
                bufferedSink.write(this.a, this.d, this.c);
            }
        }

        public Companion() {
        }

        public static RequestBody c(Companion companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            Objects.requireNonNull(companion);
            Intrinsics3.checkParameterIsNotNull(bArr, "content");
            return companion.b(bArr, mediaType, i, i2);
        }

        public static /* synthetic */ RequestBody d(Companion companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.b(bArr, mediaType, i, i2);
        }

        public final RequestBody a(String str, MediaType mediaType) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toRequestBody");
            Charset charset = Charsets2.a;
            if (mediaType != null) {
                Pattern pattern = MediaType.a;
                Charset charsetA = mediaType.a(null);
                if (charsetA == null) {
                    MediaType.Companion aVar = MediaType.INSTANCE;
                    mediaType = MediaType.Companion.b(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetA;
                }
            }
            byte[] bytes = str.getBytes(charset);
            Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return b(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody b(byte[] bArr, MediaType mediaType, int i, int i2) {
            Intrinsics3.checkParameterIsNotNull(bArr, "$this$toRequestBody");
            Util7.c(bArr.length, i, i2);
            return new a(bArr, mediaType, i2, i);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkParameterIsNotNull(file, "$this$asRequestBody");
        return new RequestBody3(file, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return INSTANCE.a(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.c(INSTANCE, mediaType, bArr, 0, 0, 12);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i) {
        return Companion.c(INSTANCE, mediaType, bArr, i, 0, 8);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.d(INSTANCE, bArr, null, 0, 0, 7);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.d(INSTANCE, bArr, mediaType, 0, 0, 6);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i) {
        return Companion.d(INSTANCE, bArr, mediaType, i, 0, 4);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i, int i2) {
        return INSTANCE.b(bArr, mediaType, i, i2);
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
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkParameterIsNotNull(file, "file");
        Intrinsics3.checkParameterIsNotNull(file, "$this$asRequestBody");
        return new RequestBody3(file, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        Companion companion = INSTANCE;
        Objects.requireNonNull(companion);
        Intrinsics3.checkParameterIsNotNull(str, "content");
        return companion.a(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkParameterIsNotNull(byteString, "content");
        Intrinsics3.checkParameterIsNotNull(byteString, "$this$toRequestBody");
        return new RequestBody2(byteString, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        Companion companion = INSTANCE;
        Objects.requireNonNull(companion);
        Intrinsics3.checkParameterIsNotNull(bArr, "content");
        return companion.b(bArr, mediaType, i, i2);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        Objects.requireNonNull(INSTANCE);
        Intrinsics3.checkParameterIsNotNull(byteString, "$this$toRequestBody");
        return new RequestBody2(byteString, mediaType);
    }
}
