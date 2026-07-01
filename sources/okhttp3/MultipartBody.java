package okhttp3;

import androidx.browser.trusted.sharing.ShareTarget;
import d0.z.d.m;
import g0.e;
import java.io.IOException;
import java.util.List;
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
    public static final MultipartBody$b f = new MultipartBody$b(null);
    public final MediaType g;
    public long h;
    public final ByteString i;
    public final MediaType j;
    public final List<MultipartBody$Part> k;

    static {
        MediaType$a mediaType$a = MediaType.c;
        a = MediaType$a.a("multipart/mixed");
        MediaType$a.a("multipart/alternative");
        MediaType$a.a("multipart/digest");
        MediaType$a.a("multipart/parallel");
        f3809b = MediaType$a.a(ShareTarget.ENCODING_TYPE_MULTIPART);
        c = new byte[]{(byte) 58, (byte) 32};
        d = new byte[]{(byte) 13, (byte) 10};
        byte b2 = (byte) 45;
        e = new byte[]{b2, b2};
    }

    public MultipartBody(ByteString byteString, MediaType mediaType, List<MultipartBody$Part> list) {
        m.checkParameterIsNotNull(byteString, "boundaryByteString");
        m.checkParameterIsNotNull(mediaType, "type");
        m.checkParameterIsNotNull(list, "parts");
        this.i = byteString;
        this.j = mediaType;
        this.k = list;
        MediaType$a mediaType$a = MediaType.c;
        this.g = MediaType$a.a(mediaType + "; boundary=" + byteString.q());
        this.h = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long a(BufferedSink bufferedSink, boolean z2) throws IOException {
        e eVar;
        if (z2) {
            bufferedSink = new e();
            eVar = bufferedSink;
        } else {
            eVar = 0;
        }
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            MultipartBody$Part multipartBody$Part = this.k.get(i);
            Headers headers = multipartBody$Part.headers;
            RequestBody requestBody = multipartBody$Part.body;
            if (bufferedSink == null) {
                m.throwNpe();
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
            long jContentLength = requestBody.getSize();
            if (jContentLength != -1) {
                bufferedSink.K("Content-Length: ").q0(jContentLength).write(d);
            } else if (z2) {
                if (eVar == 0) {
                    m.throwNpe();
                }
                eVar.skip(eVar.k);
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
            m.throwNpe();
        }
        byte[] bArr2 = e;
        bufferedSink.write(bArr2);
        bufferedSink.e0(this.i);
        bufferedSink.write(bArr2);
        bufferedSink.write(d);
        if (!z2) {
            return j;
        }
        if (eVar == 0) {
            m.throwNpe();
        }
        long j2 = eVar.k;
        long j3 = j + j2;
        eVar.skip(j2);
        return j3;
    }

    @Override // okhttp3.RequestBody
    /* JADX INFO: renamed from: contentLength */
    public long getSize() throws IOException {
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
        m.checkParameterIsNotNull(bufferedSink, "sink");
        a(bufferedSink, false);
    }
}
