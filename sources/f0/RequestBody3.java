package f0;

import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import g0.JvmOkio;
import g0.Timeout2;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;

/* JADX INFO: renamed from: f0.z, reason: use source file name */
/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RequestBody3 extends RequestBody {
    public final /* synthetic */ File a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MediaType f3692b;

    public RequestBody3(File file, MediaType mediaType) {
        this.a = file;
        this.f3692b = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f3692b;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSink, "sink");
        File file = this.a;
        Intrinsics3.checkParameterIsNotNull(file, "$this$source");
        FileInputStream fileInputStream = new FileInputStream(file);
        Intrinsics3.checkParameterIsNotNull(fileInputStream, "$this$source");
        JvmOkio jvmOkio = new JvmOkio(fileInputStream, new Timeout2());
        try {
            bufferedSink.P(jvmOkio);
            Closeable.closeFinally(jvmOkio, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                Closeable.closeFinally(jvmOkio, th);
                throw th2;
            }
        }
    }
}
