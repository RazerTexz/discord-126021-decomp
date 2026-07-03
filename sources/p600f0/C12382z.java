package p600f0;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import p507d0.p591y.C12201b;
import p507d0.p592z.p594d.C12238m;
import p615g0.C12397n;
import p615g0.C12408y;

/* JADX INFO: renamed from: f0.z */
/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12382z extends RequestBody {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ File f26063a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ MediaType f26064b;

    public C12382z(File file, MediaType mediaType) {
        this.f26063a = file;
        this.f26064b = mediaType;
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return this.f26063a.length();
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        return this.f26064b;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink bufferedSink) throws IOException {
        C12238m.checkParameterIsNotNull(bufferedSink, "sink");
        File file = this.f26063a;
        C12238m.checkParameterIsNotNull(file, "$this$source");
        FileInputStream fileInputStream = new FileInputStream(file);
        C12238m.checkParameterIsNotNull(fileInputStream, "$this$source");
        C12397n c12397n = new C12397n(fileInputStream, new C12408y());
        try {
            bufferedSink.mo10440P(c12397n);
            C12201b.closeFinally(c12397n, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                C12201b.closeFinally(c12397n, th);
                throw th2;
            }
        }
    }
}
