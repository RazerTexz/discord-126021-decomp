package okhttp3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.BufferedSink;
import okio.ByteString;
import p507d0.p579g0.C12086c;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12262a0;
import p600f0.C12382z;
import p600f0.p601e0.C12272c;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RequestBody {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: RequestBody.kt */
    public static final class Companion {

        /* JADX INFO: renamed from: okhttp3.RequestBody$Companion$a */
        /* JADX INFO: compiled from: RequestBody.kt */
        public static final class C12936a extends RequestBody {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ byte[] f27548a;

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ MediaType f27549b;

            /* JADX INFO: renamed from: c */
            public final /* synthetic */ int f27550c;

            /* JADX INFO: renamed from: d */
            public final /* synthetic */ int f27551d;

            public C12936a(byte[] bArr, MediaType mediaType, int i, int i2) {
                this.f27548a = bArr;
                this.f27549b = mediaType;
                this.f27550c = i;
                this.f27551d = i2;
            }

            @Override // okhttp3.RequestBody
            public long contentLength() {
                return this.f27550c;
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return this.f27549b;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                C12238m.checkParameterIsNotNull(bufferedSink, "sink");
                bufferedSink.write(this.f27548a, this.f27551d, this.f27550c);
            }
        }

        public Companion() {
        }

        /* JADX INFO: renamed from: c */
        public static RequestBody m10985c(Companion companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            Objects.requireNonNull(companion);
            C12238m.checkParameterIsNotNull(bArr, "content");
            return companion.m10988b(bArr, mediaType, i, i2);
        }

        /* JADX INFO: renamed from: d */
        public static /* synthetic */ RequestBody m10986d(Companion companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.m10988b(bArr, mediaType, i, i2);
        }

        /* JADX INFO: renamed from: a */
        public final RequestBody m10987a(String str, MediaType mediaType) {
            C12238m.checkParameterIsNotNull(str, "$this$toRequestBody");
            Charset charset = C12086c.f25136a;
            if (mediaType != null) {
                Pattern pattern = MediaType.f27514a;
                Charset charsetM10966a = mediaType.m10966a(null);
                if (charsetM10966a == null) {
                    MediaType.Companion c12932a = MediaType.INSTANCE;
                    mediaType = MediaType.Companion.m10968b(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetM10966a;
                }
            }
            byte[] bytes = str.getBytes(charset);
            C12238m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            return m10988b(bytes, mediaType, 0, bytes.length);
        }

        /* JADX INFO: renamed from: b */
        public final RequestBody m10988b(byte[] bArr, MediaType mediaType, int i, int i2) {
            C12238m.checkParameterIsNotNull(bArr, "$this$toRequestBody");
            C12272c.m10122c(bArr.length, i, i2);
            return new C12936a(bArr, mediaType, i2, i);
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        Objects.requireNonNull(INSTANCE);
        C12238m.checkParameterIsNotNull(file, "$this$asRequestBody");
        return new C12382z(file, mediaType);
    }

    public static final RequestBody create(String str, MediaType mediaType) {
        return INSTANCE.m10987a(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.m10985c(INSTANCE, mediaType, bArr, 0, 0, 12);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i) {
        return Companion.m10985c(INSTANCE, mediaType, bArr, i, 0, 8);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.m10986d(INSTANCE, bArr, null, 0, 0, 7);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.m10986d(INSTANCE, bArr, mediaType, 0, 0, 6);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i) {
        return Companion.m10986d(INSTANCE, bArr, mediaType, i, 0, 4);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i, int i2) {
        return INSTANCE.m10988b(bArr, mediaType, i, i2);
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
        C12238m.checkParameterIsNotNull(file, "file");
        C12238m.checkParameterIsNotNull(file, "$this$asRequestBody");
        return new C12382z(file, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        Companion companion = INSTANCE;
        Objects.requireNonNull(companion);
        C12238m.checkParameterIsNotNull(str, "content");
        return companion.m10987a(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        Objects.requireNonNull(INSTANCE);
        C12238m.checkParameterIsNotNull(byteString, "content");
        C12238m.checkParameterIsNotNull(byteString, "$this$toRequestBody");
        return new C12262a0(byteString, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i, int i2) {
        Companion companion = INSTANCE;
        Objects.requireNonNull(companion);
        C12238m.checkParameterIsNotNull(bArr, "content");
        return companion.m10988b(bArr, mediaType, i, i2);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        Objects.requireNonNull(INSTANCE);
        C12238m.checkParameterIsNotNull(byteString, "$this$toRequestBody");
        return new C12262a0(byteString, mediaType);
    }
}
