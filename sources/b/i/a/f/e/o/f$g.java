package b.i.a.f.e.o;

import d0.k;
import d0.k$a;
import d0.l;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: KotlinExtensions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$g implements Runnable {
    public final /* synthetic */ Continuation j;
    public final /* synthetic */ Exception k;

    public f$g(Continuation continuation, Exception exc) {
        this.j = continuation;
        this.k = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Continuation continuationIntercepted = d0.w.h.b.intercepted(this.j);
        Exception exc = this.k;
        k$a k_a = k.j;
        continuationIntercepted.resumeWith(k.m97constructorimpl(l.createFailure(exc)));
    }
}
