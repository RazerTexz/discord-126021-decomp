package s.a;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: compiled from: Builders.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i0<T> extends s.a.a.r<T> {
    public static final AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(i0.class, "_decision");
    public volatile int _decision;

    public i0(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, continuation);
        this._decision = 0;
    }

    @Override // s.a.a.r, s.a.b
    public void e0(Object obj) {
        boolean z2;
        while (true) {
            int i = this._decision;
            z2 = false;
            if (i != 0) {
                if (i == 1) {
                    break;
                } else {
                    throw new IllegalStateException("Already resumed".toString());
                }
            } else if (n.compareAndSet(this, 0, 2)) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return;
        }
        s.a.a.h.b(d0.w.h.b.intercepted(this.m), b.i.a.f.e.o.f.X0(obj, this.m), null, 2);
    }

    @Override // s.a.a.r, s.a.h1
    public void v(Object obj) {
        e0(obj);
    }
}
