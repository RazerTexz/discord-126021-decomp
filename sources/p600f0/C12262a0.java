package p600f0;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.ByteString;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: f0.a0 */
/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12262a0 extends RequestBody {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ByteString f25364a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MediaType f25365b;

    public C12262a0(ByteString byteString, MediaType mediaType) {
        this.f25364a = byteString;
        this.f25365b = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f25364a.mo10502j();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f25365b;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        C12238m.checkParameterIsNotNull(bufferedSink, "sink");
        bufferedSink.mo10455e0(this.f25364a);
    }
}
