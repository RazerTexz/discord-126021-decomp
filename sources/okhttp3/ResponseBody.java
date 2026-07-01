package okhttp3;

import d0.g0.Charsets2;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import g0.BufferedSource;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ResponseBody implements Closeable {

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public Reader reader;

    /* JADX INFO: compiled from: ResponseBody.kt */
    public static final class a extends Reader {
        public boolean j;
        public Reader k;
        public final BufferedSource l;
        public final Charset m;

        public a(BufferedSource bufferedSource, Charset charset) {
            Intrinsics3.checkParameterIsNotNull(bufferedSource, "source");
            Intrinsics3.checkParameterIsNotNull(charset, "charset");
            this.l = bufferedSource;
            this.m = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.j = true;
            Reader reader = this.k;
            if (reader != null) {
                reader.close();
            } else {
                this.l.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) throws IOException {
            Intrinsics3.checkParameterIsNotNull(cArr, "cbuf");
            if (this.j) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.k;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.l.u0(), Util7.s(this.l, this.m));
                this.k = inputStreamReader;
            }
            return inputStreamReader.read(cArr, i, i2);
        }
    }

    public abstract long a();

    public abstract MediaType b();

    public abstract BufferedSource c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util7.d(c());
    }

    public final String d() throws IOException {
        Charset charsetA;
        BufferedSource bufferedSourceC = c();
        try {
            MediaType mediaTypeB = b();
            if (mediaTypeB == null || (charsetA = mediaTypeB.a(Charsets2.a)) == null) {
                charsetA = Charsets2.a;
            }
            String strM = bufferedSourceC.M(Util7.s(bufferedSourceC, charsetA));
            d0.y.Closeable.closeFinally(bufferedSourceC, null);
            return strM;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                d0.y.Closeable.closeFinally(bufferedSourceC, th);
                throw th2;
            }
        }
    }
}
