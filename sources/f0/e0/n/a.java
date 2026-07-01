package f0.e0.n;

import java.io.Closeable;
import java.util.zip.Deflater;

/* JADX INFO: compiled from: MessageDeflater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Closeable {
    public final g0.e j;
    public final Deflater k;
    public final g0.h l;
    public final boolean m;

    public a(boolean z2) {
        this.m = z2;
        g0.e eVar = new g0.e();
        this.j = eVar;
        Deflater deflater = new Deflater(-1, true);
        this.k = deflater;
        this.l = new g0.h(eVar, deflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.l.close();
    }
}
