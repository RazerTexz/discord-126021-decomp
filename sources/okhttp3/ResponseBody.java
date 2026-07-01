package okhttp3;

import d0.y.b;
import f0.e0.c;
import g0.g;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ResponseBody implements Closeable {
    public static final ResponseBody$b j = new ResponseBody$b(null);

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Reader reader;

    public abstract long a();

    public abstract MediaType b();

    public abstract g c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        c.d(c());
    }

    public final String d() throws IOException {
        Charset charsetA;
        g gVarC = c();
        try {
            MediaType mediaTypeB = b();
            if (mediaTypeB == null || (charsetA = mediaTypeB.a(d0.g0.c.a)) == null) {
                charsetA = d0.g0.c.a;
            }
            String strM = gVarC.M(c.s(gVarC, charsetA));
            b.closeFinally(gVarC, null);
            return strM;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.closeFinally(gVarC, th);
                throw th2;
            }
        }
    }
}
