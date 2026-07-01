package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import g0.Buffer3;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MediaType;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: MultipartBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MultipartBody extends RequestBody {
    public static final MediaType a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MediaType f3809b;
    public static final byte[] c;
    public static final byte[] d;
    public static final byte[] e;
    public static final b f = new b(null);
    public final MediaType g;
    public long h;
    public final ByteString i;
    public final MediaType j;
    public final List<Part> k;

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class Part {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final Headers headers;

        /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
        public final RequestBody body;

        public Part(Headers headers, RequestBody requestBody, DefaultConstructorMarker defaultConstructorMarker) {
            this.headers = headers;
            this.body = requestBody;
        }

        public static final Part a(Headers headers, RequestBody requestBody) {
            Intrinsics3.checkParameterIsNotNull(requestBody, "body");
            if (!(headers.c("Content-Type") == null)) {
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            }
            if (headers.c("Content-Length") == null) {
                return new Part(headers, requestBody, null);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }

        public static final Part b(String str, String str2, RequestBody requestBody) {
            Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(requestBody, "body");
            StringBuilder sb = new StringBuilder();
            sb.append("form-data; name=");
            b bVar = MultipartBody.f;
            bVar.a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                bVar.a(sb, str2);
            }
            String string = sb.toString();
            Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
            ArrayList arrayList = new ArrayList(20);
            Intrinsics3.checkParameterIsNotNull("Content-Disposition", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(string, "value");
            if (1 == 0) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            for (int i = 0; i < 19; i++) {
                char cCharAt = "Content-Disposition".charAt(i);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(Util7.j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), "Content-Disposition").toString());
                }
            }
            Intrinsics3.checkParameterIsNotNull("Content-Disposition", ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(string, "value");
            arrayList.add("Content-Disposition");
            arrayList.add(Strings4.trim(string).toString());
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return a(new Headers((String[]) array, null), requestBody);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class a {
        public final ByteString a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public MediaType f3811b;
        public final List<Part> c;

        public a() {
            String string = UUID.randomUUID().toString();
            Intrinsics3.checkExpressionValueIsNotNull(string, "UUID.randomUUID().toString()");
            Intrinsics3.checkParameterIsNotNull(string, "boundary");
            this.a = ByteString.INSTANCE.c(string);
            this.f3811b = MultipartBody.a;
            this.c = new ArrayList();
        }

        public final a a(Part part) {
            Intrinsics3.checkParameterIsNotNull(part, "part");
            this.c.add(part);
            return this;
        }

        public final MultipartBody b() {
            if (!this.c.isEmpty()) {
                return new MultipartBody(this.a, this.f3811b, Util7.z(this.c));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        public final a c(MediaType mediaType) {
            Intrinsics3.checkParameterIsNotNull(mediaType, "type");
            if (Intrinsics3.areEqual(mediaType.type, "multipart")) {
                this.f3811b = mediaType;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + mediaType).toString());
        }
    }

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final void a(StringBuilder sb, String str) {
            Intrinsics3.checkParameterIsNotNull(sb, "$this$appendQuotedString");
            Intrinsics3.checkParameterIsNotNull(str, "key");
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

    static {
        MediaType.Companion companion = MediaType.INSTANCE;
        a = MediaType.Companion.a("multipart/mixed");
        MediaType.Companion.a("multipart/alternative");
        MediaType.Companion.a("multipart/digest");
        MediaType.Companion.a("multipart/parallel");
        f3809b = MediaType.Companion.a(ShareTarget.ENCODING_TYPE_MULTIPART);
        c = new byte[]{(byte) 58, (byte) 32};
        d = new byte[]{(byte) 13, (byte) 10};
        byte b2 = (byte) 45;
        e = new byte[]{b2, b2};
    }

    public MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        Intrinsics3.checkParameterIsNotNull(byteString, "boundaryByteString");
        Intrinsics3.checkParameterIsNotNull(mediaType, "type");
        Intrinsics3.checkParameterIsNotNull(list, "parts");
        this.i = byteString;
        this.j = mediaType;
        this.k = list;
        MediaType.Companion companion = MediaType.INSTANCE;
        this.g = MediaType.Companion.a(mediaType + "; boundary=" + byteString.q());
        this.h = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a(BufferedSink bufferedSink, boolean z2) throws IOException {
        Buffer3 buffer3;
        if (z2) {
            bufferedSink = new Buffer3();
            buffer3 = bufferedSink;
        } else {
            buffer3 = 0;
        }
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = this.k.get(i);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            if (bufferedSink == null) {
                Intrinsics3.throwNpe();
            }
            bufferedSink.write(e);
            bufferedSink.e0(this.i);
            bufferedSink.write(d);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.K(headers.d(i2)).write(c).K(headers.g(i2)).write(d);
                }
            }
            MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                bufferedSink.K("Content-Type: ").K(mediaTypeContentType.mediaType).write(d);
            }
            long jContentLength = requestBody.contentLength();
            if (jContentLength != -1) {
                bufferedSink.K("Content-Length: ").q0(jContentLength).write(d);
            } else if (z2) {
                if (buffer3 == 0) {
                    Intrinsics3.throwNpe();
                }
                buffer3.skip(buffer3.k);
                return -1L;
            }
            byte[] bArr = d;
            bufferedSink.write(bArr);
            if (z2) {
                j += jContentLength;
            } else {
                requestBody.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        if (bufferedSink == null) {
            Intrinsics3.throwNpe();
        }
        byte[] bArr2 = e;
        bufferedSink.write(bArr2);
        bufferedSink.e0(this.i);
        bufferedSink.write(bArr2);
        bufferedSink.write(d);
        if (!z2) {
            return j;
        }
        if (buffer3 == 0) {
            Intrinsics3.throwNpe();
        }
        long j2 = buffer3.k;
        long j3 = j + j2;
        buffer3.skip(j2);
        return j3;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j = this.h;
        if (j != -1) {
            return j;
        }
        long jA = a(null, true);
        this.h = jA;
        return jA;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.g;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        a(bufferedSink, false);
    }
}
