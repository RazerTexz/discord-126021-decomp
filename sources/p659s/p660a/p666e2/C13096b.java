package p659s.p660a.p666e2;

import kotlinx.coroutines.CoroutineDispatcher;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p512d0.C11226f;
import p659s.p660a.p661a.C13038u;

/* JADX INFO: renamed from: s.a.e2.b */
/* JADX INFO: compiled from: Dispatcher.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13096b extends C13097c {

    /* JADX INFO: renamed from: o */
    public static final CoroutineDispatcher f27813o;

    /* JADX INFO: renamed from: p */
    public static final C13096b f27814p;

    static {
        C13096b c13096b = new C13096b();
        f27814p = c13096b;
        f27813o = new ExecutorC13099e(c13096b, C3404f.m4313l1("kotlinx.coroutines.io.parallelism", C11226f.coerceAtLeast(64, C13038u.f27706a), 0, 0, 12, null), "Dispatchers.IO", 1);
    }

    public C13096b() {
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
