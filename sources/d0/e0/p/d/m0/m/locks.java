package d0.e0.p.d.m0.m;

import d0.z.d.Intrinsics3;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.c, reason: use source file name */
/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class locks extends locks2 {
    public final Runnable c;
    public final Function1<InterruptedException, Unit> d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public locks(Lock lock, Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        super(lock);
        Intrinsics3.checkNotNullParameter(lock, "lock");
        Intrinsics3.checkNotNullParameter(runnable, "checkCancelled");
        Intrinsics3.checkNotNullParameter(function1, "interruptedExceptionHandler");
        this.c = runnable;
        this.d = function1;
    }

    @Override // d0.e0.p.d.m0.m.locks2, d0.e0.p.d.m0.m.locks4
    public void lock() {
        while (!this.f3512b.tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.c.run();
            } catch (InterruptedException e) {
                this.d.invoke(e);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public locks(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        this(new ReentrantLock(), runnable, function1);
        Intrinsics3.checkNotNullParameter(runnable, "checkCancelled");
        Intrinsics3.checkNotNullParameter(function1, "interruptedExceptionHandler");
    }
}
