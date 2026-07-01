package s.a;

import d0.z.d.Intrinsics3;
import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: renamed from: s.a.f, reason: use source file name */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Builders4<T> extends AbstractCoroutine<T> {
    public final Thread m;
    public final q0 n;

    public Builders4(CoroutineContext coroutineContext, Thread thread, q0 q0Var) {
        super(coroutineContext, true);
        this.m = thread;
        this.n = q0Var;
    }

    @Override // s.a.h1
    public void v(Object obj) {
        if (!Intrinsics3.areEqual(Thread.currentThread(), this.m)) {
            LockSupport.unpark(this.m);
        }
    }
}
