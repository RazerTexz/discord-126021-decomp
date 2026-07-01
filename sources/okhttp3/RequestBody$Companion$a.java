package okhttp3;

import d0.z.d.m;
import java.io.IOException;
import okio.BufferedSink;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RequestBody$Companion$a extends RequestBody {
    public final /* synthetic */ byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaType f3814b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;

    public RequestBody$Companion$a(byte[] bArr, MediaType mediaType, int i, int i2) {
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
        m.checkParameterIsNotNull(bufferedSink, "sink");
        bufferedSink.write(this.a, this.d, this.c);
    }
}
