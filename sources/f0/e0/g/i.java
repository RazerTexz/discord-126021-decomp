package f0.e0.g;

import f0.e0.n.d$c;
import okio.BufferedSink;

/* JADX INFO: compiled from: RealConnection.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends d$c {
    public final /* synthetic */ c m;
    public final /* synthetic */ g0.g n;
    public final /* synthetic */ BufferedSink o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(c cVar, g0.g gVar, BufferedSink bufferedSink, boolean z2, g0.g gVar2, BufferedSink bufferedSink2) {
        super(z2, gVar2, bufferedSink2);
        this.m = cVar;
        this.n = gVar;
        this.o = bufferedSink;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.m.a(-1L, true, true, null);
    }
}
