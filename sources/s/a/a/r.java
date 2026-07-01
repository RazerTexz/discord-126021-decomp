package s.a.a;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;

/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes3.dex */
public class r<T> extends s.a.b<T> implements CoroutineStackFrame {
    public final Continuation<T> m;

    /* JADX WARN: Multi-variable type inference failed */
    public r(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true);
        this.m = continuation;
    }

    @Override // s.a.h1
    public final boolean Q() {
        return true;
    }

    @Override // s.a.b
    public void e0(Object obj) {
        Continuation<T> continuation = this.m;
        continuation.resumeWith(b.i.a.f.e.o.f.X0(obj, continuation));
    }

    @Override // s.a.h1
    public void v(Object obj) {
        h.b(d0.w.h.b.intercepted(this.m), b.i.a.f.e.o.f.X0(obj, this.m), null, 2);
    }
}
