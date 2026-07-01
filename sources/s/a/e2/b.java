package s.a.e2;

import kotlinx.coroutines.CoroutineDispatcher;
import s.a.a.u;

/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {
    public static final CoroutineDispatcher o;
    public static final b p;

    static {
        b bVar = new b();
        p = bVar;
        o = new e(bVar, b.i.a.f.e.o.f.l1("kotlinx.coroutines.io.parallelism", d0.d0.f.coerceAtLeast(64, u.a), 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    public b() {
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
