package p507d0.p513e0.p514p.p515d.p517m0.p566m;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.c */
/* JADX INFO: compiled from: locks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11893c extends C11894d {

    /* JADX INFO: renamed from: c */
    public final Runnable f24705c;

    /* JADX INFO: renamed from: d */
    public final Function1<InterruptedException, Unit> f24706d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public C11893c(Lock lock, Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        super(lock);
        C12238m.checkNotNullParameter(lock, "lock");
        C12238m.checkNotNullParameter(runnable, "checkCancelled");
        C12238m.checkNotNullParameter(function1, "interruptedExceptionHandler");
        this.f24705c = runnable;
        this.f24706d = function1;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p566m.C11894d, p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11902l
    public void lock() {
        while (!this.f24707b.tryLock(50L, TimeUnit.MILLISECONDS)) {
            try {
                this.f24705c.run();
            } catch (InterruptedException e) {
                this.f24706d.invoke(e);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C11893c(Runnable runnable, Function1<? super InterruptedException, Unit> function1) {
        this(new ReentrantLock(), runnable, function1);
        C12238m.checkNotNullParameter(runnable, "checkCancelled");
        C12238m.checkNotNullParameter(function1, "interruptedExceptionHandler");
    }
}
