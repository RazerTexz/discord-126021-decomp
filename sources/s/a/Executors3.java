package s.a;

import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: renamed from: s.a.s1, reason: use source file name */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Executors3 implements Runnable {
    public final CoroutineDispatcher j;
    public final CancellableContinuation<Unit> k;

    /* JADX WARN: Multi-variable type inference failed */
    public Executors3(CoroutineDispatcher coroutineDispatcher, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.j = coroutineDispatcher;
        this.k = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.k.i(this.j, Unit.a);
    }
}
