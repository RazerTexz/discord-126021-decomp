package f0.e0.n;

import g0.Buffer3;
import g0.DeflaterSink;
import java.io.Closeable;
import java.util.zip.Deflater;

/* JADX INFO: renamed from: f0.e0.n.a, reason: use source file name */
/* JADX INFO: compiled from: MessageDeflater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MessageDeflater implements Closeable {
    public final Buffer3 j;
    public final Deflater k;
    public final DeflaterSink l;
    public final boolean m;

    public MessageDeflater(boolean z2) {
        this.m = z2;
        Buffer3 buffer3 = new Buffer3();
        this.j = buffer3;
        Deflater deflater = new Deflater(-1, true);
        this.k = deflater;
        this.l = new DeflaterSink(buffer3, deflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.l.close();
    }
}
