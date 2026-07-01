package s.a;

import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: EventLoop.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r0$a extends r0$c {
    public final CancellableContinuation<Unit> m;
    public final /* synthetic */ r0 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public r0$a(r0 r0Var, long j, CancellableContinuation<? super Unit> cancellableContinuation) {
        super(j);
        this.n = r0Var;
        this.m = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.m.i(this.n, Unit.a);
    }

    @Override // s.a.r0$c
    public String toString() {
        return super.toString() + this.m.toString();
    }
}
