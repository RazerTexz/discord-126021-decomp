package s.a.e2;

import d0.d0._Ranges;
import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.SystemProps;

/* JADX INFO: renamed from: s.a.e2.b, reason: use source file name */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Dispatcher3 extends Dispatcher4 {
    public static final CoroutineDispatcher o;
    public static final Dispatcher3 p;

    static {
        Dispatcher3 dispatcher3 = new Dispatcher3();
        p = dispatcher3;
        o = new Dispatcher5(dispatcher3, b.i.a.f.e.o.f.l1("kotlinx.coroutines.io.parallelism", _Ranges.coerceAtLeast(64, SystemProps.a), 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    public Dispatcher3() {
        super(0, 0, null, 7);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("Dispatchers.Default cannot be closed");
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        return "Dispatchers.Default";
    }
}
