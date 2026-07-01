package i0;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: compiled from: RequestBuilder.java */
/* JADX INFO: loaded from: classes3.dex */
public class v$a extends RequestBody {
    public final RequestBody a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaType f3760b;

    public v$a(RequestBody requestBody, MediaType mediaType) {
        this.a = requestBody;
        this.f3760b = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        return this.a.contentLength();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f3760b;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        this.a.writeTo(bufferedSink);
    }
}
