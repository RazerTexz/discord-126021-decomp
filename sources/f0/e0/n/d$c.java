package f0.e0.n;

import d0.z.d.m;
import java.io.Closeable;
import okio.BufferedSink;

/* JADX INFO: compiled from: RealWebSocket.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d$c implements Closeable {
    public final boolean j;
    public final g0.g k;
    public final BufferedSink l;

    public d$c(boolean z2, g0.g gVar, BufferedSink bufferedSink) {
        m.checkParameterIsNotNull(gVar, "source");
        m.checkParameterIsNotNull(bufferedSink, "sink");
        this.j = z2;
        this.k = gVar;
        this.l = bufferedSink;
    }
}
