package okhttp3;

import d0.z.d.m;
import f0.e0.c;
import g0.g;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ResponseBody$a extends Reader {
    public boolean j;
    public Reader k;
    public final g l;
    public final Charset m;

    public ResponseBody$a(g gVar, Charset charset) {
        m.checkParameterIsNotNull(gVar, "source");
        m.checkParameterIsNotNull(charset, "charset");
        this.l = gVar;
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
        m.checkParameterIsNotNull(cArr, "cbuf");
        if (this.j) {
            throw new IOException("Stream closed");
        }
        Reader inputStreamReader = this.k;
        if (inputStreamReader == null) {
            inputStreamReader = new InputStreamReader(this.l.u0(), c.s(this.l, this.m));
            this.k = inputStreamReader;
        }
        return inputStreamReader.read(cArr, i, i2);
    }
}
