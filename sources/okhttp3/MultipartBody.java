package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.MediaType;
import okio.BufferedSink;
import okio.ByteString;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;
import p615g0.C12388e;

/* JADX INFO: compiled from: MultipartBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MultipartBody extends RequestBody {

    /* JADX INFO: renamed from: a */
    public static final MediaType f27521a;

    /* JADX INFO: renamed from: b */
    public static final MediaType f27522b;

    /* JADX INFO: renamed from: c */
    public static final byte[] f27523c;

    /* JADX INFO: renamed from: d */
    public static final byte[] f27524d;

    /* JADX INFO: renamed from: e */
    public static final byte[] f27525e;

    /* JADX INFO: renamed from: f */
    public static final C12934b f27526f = new C12934b(null);

    /* JADX INFO: renamed from: g */
    public final MediaType f27527g;

    /* JADX INFO: renamed from: h */
    public long f27528h;

    /* JADX INFO: renamed from: i */
    public final ByteString f27529i;

    /* JADX INFO: renamed from: j */
    public final MediaType f27530j;

    /* JADX INFO: renamed from: k */
    public final List<Part> f27531k;

    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class Part {

        /* JADX INFO: renamed from: a, reason: from kotlin metadata */
        public final Headers headers;

        /* JADX INFO: renamed from: b, reason: from kotlin metadata */
        public final RequestBody body;

        public Part(Headers headers, RequestBody requestBody, DefaultConstructorMarker defaultConstructorMarker) {
            this.headers = headers;
            this.body = requestBody;
        }

        /* JADX INFO: renamed from: a */
        public static final Part m10970a(Headers headers, RequestBody requestBody) {
            C12238m.checkParameterIsNotNull(requestBody, "body");
            if (!(headers.m10954c("Content-Type") == null)) {
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            }
            if (headers.m10954c("Content-Length") == null) {
                return new Part(headers, requestBody, null);
            }
            throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
        }

        /* JADX INFO: renamed from: b */
        public static final Part m10971b(String str, String str2, RequestBody requestBody) {
            C12238m.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(requestBody, "body");
            StringBuilder sb = new StringBuilder();
            sb.append("form-data; name=");
            C12934b c12934b = MultipartBody.f27526f;
            c12934b.m10975a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                c12934b.m10975a(sb, str2);
            }
            String string = sb.toString();
            C12238m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
            ArrayList arrayList = new ArrayList(20);
            C12238m.checkParameterIsNotNull("Content-Disposition", ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(string, "value");
            if (1 == 0) {
                throw new IllegalArgumentException("name is empty".toString());
            }
            for (int i = 0; i < 19; i++) {
                char cCharAt = "Content-Disposition".charAt(i);
                if (!('!' <= cCharAt && '~' >= cCharAt)) {
                    throw new IllegalArgumentException(C12272c.m10129j("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), "Content-Disposition").toString());
                }
            }
            C12238m.checkParameterIsNotNull("Content-Disposition", ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkParameterIsNotNull(string, "value");
            arrayList.add("Content-Disposition");
            arrayList.add(C12106w.trim(string).toString());
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return m10970a(new Headers((String[]) array, null), requestBody);
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
    }

    /* JADX INFO: renamed from: okhttp3.MultipartBody$a */
    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class C12933a {

        /* JADX INFO: renamed from: a */
        public final ByteString f27534a;

        /* JADX INFO: renamed from: b */
        public MediaType f27535b;

        /* JADX INFO: renamed from: c */
        public final List<Part> f27536c;

        public C12933a() {
            String string = UUID.randomUUID().toString();
            C12238m.checkExpressionValueIsNotNull(string, "UUID.randomUUID().toString()");
            C12238m.checkParameterIsNotNull(string, "boundary");
            this.f27534a = ByteString.INSTANCE.m11012c(string);
            this.f27535b = MultipartBody.f27521a;
            this.f27536c = new ArrayList();
        }

        /* JADX INFO: renamed from: a */
        public final C12933a m10972a(Part part) {
            C12238m.checkParameterIsNotNull(part, "part");
            this.f27536c.add(part);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final MultipartBody m10973b() {
            if (!this.f27536c.isEmpty()) {
                return new MultipartBody(this.f27534a, this.f27535b, C12272c.m10145z(this.f27536c));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        /* JADX INFO: renamed from: c */
        public final C12933a m10974c(MediaType mediaType) {
            C12238m.checkParameterIsNotNull(mediaType, "type");
            if (C12238m.areEqual(mediaType.type, "multipart")) {
                this.f27535b = mediaType;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + mediaType).toString());
        }
    }

    /* JADX INFO: renamed from: okhttp3.MultipartBody$b */
    /* JADX INFO: compiled from: MultipartBody.kt */
    public static final class C12934b {
        public C12934b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final void m10975a(StringBuilder sb, String str) {
            C12238m.checkParameterIsNotNull(sb, "$this$appendQuotedString");
            C12238m.checkParameterIsNotNull(str, "key");
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
        f27521a = MediaType.Companion.m10967a("multipart/mixed");
        MediaType.Companion.m10967a("multipart/alternative");
        MediaType.Companion.m10967a("multipart/digest");
        MediaType.Companion.m10967a("multipart/parallel");
        f27522b = MediaType.Companion.m10967a(ShareTarget.ENCODING_TYPE_MULTIPART);
        f27523c = new byte[]{(byte) 58, (byte) 32};
        f27524d = new byte[]{(byte) 13, (byte) 10};
        byte b2 = (byte) 45;
        f27525e = new byte[]{b2, b2};
    }

    public MultipartBody(ByteString byteString, MediaType mediaType, List<Part> list) {
        C12238m.checkParameterIsNotNull(byteString, "boundaryByteString");
        C12238m.checkParameterIsNotNull(mediaType, "type");
        C12238m.checkParameterIsNotNull(list, "parts");
        this.f27529i = byteString;
        this.f27530j = mediaType;
        this.f27531k = list;
        MediaType.Companion companion = MediaType.INSTANCE;
        this.f27527g = MediaType.Companion.m10967a(mediaType + "; boundary=" + byteString.m11008q());
        this.f27528h = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    public final long m10969a(BufferedSink bufferedSink, boolean z2) throws IOException {
        C12388e c12388e;
        if (z2) {
            bufferedSink = new C12388e();
            c12388e = bufferedSink;
        } else {
            c12388e = 0;
        }
        int size = this.f27531k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            Part part = this.f27531k.get(i);
            Headers headers = part.headers;
            RequestBody requestBody = part.body;
            if (bufferedSink == null) {
                C12238m.throwNpe();
            }
            bufferedSink.write(f27525e);
            bufferedSink.mo10455e0(this.f27529i);
            bufferedSink.write(f27524d);
            if (headers != null) {
                int size2 = headers.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    bufferedSink.mo10436K(headers.m10955d(i2)).write(f27523c).mo10436K(headers.m10957g(i2)).write(f27524d);
                }
            }
            MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                bufferedSink.mo10436K("Content-Type: ").mo10436K(mediaTypeContentType.mediaType).write(f27524d);
            }
            long jContentLength = requestBody.contentLength();
            if (jContentLength != -1) {
                bufferedSink.mo10436K("Content-Length: ").mo10465q0(jContentLength).write(f27524d);
            } else if (z2) {
                if (c12388e == 0) {
                    C12238m.throwNpe();
                }
                c12388e.skip(c12388e.f26080k);
                return -1L;
            }
            byte[] bArr = f27524d;
            bufferedSink.write(bArr);
            if (z2) {
                j += jContentLength;
            } else {
                requestBody.writeTo(bufferedSink);
            }
            bufferedSink.write(bArr);
        }
        if (bufferedSink == null) {
            C12238m.throwNpe();
        }
        byte[] bArr2 = f27525e;
        bufferedSink.write(bArr2);
        bufferedSink.mo10455e0(this.f27529i);
        bufferedSink.write(bArr2);
        bufferedSink.write(f27524d);
        if (!z2) {
            return j;
        }
        if (c12388e == 0) {
            C12238m.throwNpe();
        }
        long j2 = c12388e.f26080k;
        long j3 = j + j2;
        c12388e.skip(j2);
        return j3;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j = this.f27528h;
        if (j != -1) {
            return j;
        }
        long jM10969a = m10969a(null, true);
        this.f27528h = jM10969a;
        return jM10969a;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f27527g;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        C12238m.checkParameterIsNotNull(bufferedSink, "sink");
        m10969a(bufferedSink, false);
    }
}
