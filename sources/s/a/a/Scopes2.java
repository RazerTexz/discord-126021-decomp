package s.a.a;

import d0.w.h.IntrinsicsJvm;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import s.a.AbstractCoroutine;

/* JADX INFO: renamed from: s.a.a.r, reason: use source file name */
/* JADX INFO: compiled from: Scopes.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Scopes2<T> extends AbstractCoroutine<T> implements CoroutineStackFrame {
    public final Continuation<T> m;

    /* JADX WARN: Multi-variable type inference failed */
    public Scopes2(CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        super(coroutineContext, true);
        this.m = continuation;
    }

    @Override // s.a.h1
    public final boolean Q() {
        return true;
    }

    @Override // s.a.AbstractCoroutine
    public void e0(Object obj) {
        Continuation<T> continuation = this.m;
        continuation.resumeWith(b.i.a.f.e.o.f.X0(obj, continuation));
    }

    @Override // s.a.h1
    public void v(Object obj) {
        DispatchedContinuation2.b(IntrinsicsJvm.intercepted(this.m), b.i.a.f.e.o.f.X0(obj, this.m), null, 2);
    }
}
