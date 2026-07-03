package p659s.p660a;

import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: renamed from: s.a.s1 */
/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC13149s1 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final CoroutineDispatcher f27900j;

    /* JADX INFO: renamed from: k */
    public final CancellableContinuation<Unit> f27901k;

    /* JADX WARN: Multi-variable type inference failed */
    public RunnableC13149s1(CoroutineDispatcher coroutineDispatcher, CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f27900j = coroutineDispatcher;
        this.f27901k = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27901k.mo10905i(this.f27900j, Unit.f27425a);
    }
}
