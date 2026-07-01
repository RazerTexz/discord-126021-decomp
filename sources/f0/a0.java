package f0;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends RequestBody {
    public final /* synthetic */ ByteString a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaType f3602b;

    public a0(ByteString byteString, MediaType mediaType) {
        this.a = byteString;
        this.f3602b = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.a.j();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f3602b;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(bufferedSink, "sink");
        bufferedSink.e0(this.a);
    }
}
