package f0.e0.n;

import g0.Buffer3;
import g0.InflaterSource;
import g0.Source2;
import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;

/* JADX INFO: renamed from: f0.e0.n.c, reason: use source file name */
/* JADX INFO: compiled from: MessageInflater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MessageInflater implements Closeable {
    public final Buffer3 j;
    public final Inflater k;
    public final InflaterSource l;
    public final boolean m;

    public MessageInflater(boolean z2) {
        this.m = z2;
        Buffer3 buffer3 = new Buffer3();
        this.j = buffer3;
        Inflater inflater = new Inflater(true);
        this.k = inflater;
        this.l = new InflaterSource((Source2) buffer3, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.l.close();
    }
}
