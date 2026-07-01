package s.a;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f<T> extends b<T> {
    public final Thread m;
    public final q0 n;

    public f(CoroutineContext coroutineContext, Thread thread, q0 q0Var) {
        super(coroutineContext, true);
        this.m = thread;
        this.n = q0Var;
    }

    @Override // s.a.h1
    public void v(Object obj) {
        if (!d0.z.d.m.areEqual(Thread.currentThread(), this.m)) {
            LockSupport.unpark(this.m);
        }
    }
}
