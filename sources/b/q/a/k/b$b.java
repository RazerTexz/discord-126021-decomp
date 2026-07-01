package b.q.a.k;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ImageHeaderParser.java */
/* JADX INFO: loaded from: classes3.dex */
public class b$b implements b$a {
    public final InputStream a;

    public b$b(InputStream inputStream) {
        this.a = inputStream;
    }

    public int a() throws IOException {
        return ((this.a.read() << 8) & 65280) | (this.a.read() & 255);
    }
}
