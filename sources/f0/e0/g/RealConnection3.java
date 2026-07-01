package f0.e0.g;

import f0.e0.n.RealWebSocket;
import g0.BufferedSource;
import okio.BufferedSink;

/* JADX INFO: renamed from: f0.e0.g.i, reason: use source file name */
/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RealConnection3 extends RealWebSocket.c {
    public final /* synthetic */ Exchange m;
    public final /* synthetic */ BufferedSource n;
    public final /* synthetic */ BufferedSink o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection3(Exchange exchange, BufferedSource bufferedSource, BufferedSink bufferedSink, boolean z2, BufferedSource bufferedSource2, BufferedSink bufferedSink2) {
        super(z2, bufferedSource2, bufferedSink2);
        this.m = exchange;
        this.n = bufferedSource;
        this.o = bufferedSink;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.m.a(-1L, true, true, null);
    }
}
