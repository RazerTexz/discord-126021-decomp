package p659s.p660a;

import java.util.concurrent.locks.LockSupport;
import kotlin.coroutines.CoroutineContext;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: s.a.f */
/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13108f<T> extends AbstractC13045b<T> {

    /* JADX INFO: renamed from: m */
    public final Thread f27841m;

    /* JADX INFO: renamed from: n */
    public final AbstractC13142q0 f27842n;

    public C13108f(CoroutineContext coroutineContext, Thread thread, AbstractC13142q0 abstractC13142q0) {
        super(coroutineContext, true);
        this.f27841m = thread;
        this.f27842n = abstractC13142q0;
    }

    @Override // p659s.p660a.C13116h1
    /* JADX INFO: renamed from: v */
    public void mo11173v(Object obj) {
        if (!C12238m.areEqual(Thread.currentThread(), this.f27841m)) {
            LockSupport.unpark(this.f27841m);
        }
    }
}
