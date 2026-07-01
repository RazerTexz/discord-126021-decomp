package s.a;

import d0.w.i.a.ContinuationImpl3;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Timeout3;
import s.a.a.Scopes2;

/* JADX INFO: renamed from: s.a.x1, reason: use source file name */
/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Timeout4<U, T extends U> extends Scopes2<T> implements Runnable {
    public final long n;

    public Timeout4(long j, Continuation<? super U> continuation) {
        super(((ContinuationImpl3) continuation).getContext(), continuation);
        this.n = j;
    }

    @Override // s.a.AbstractCoroutine, s.a.h1
    public String T() {
        return super.T() + "(timeMillis=" + this.n + ')';
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        w(new Timeout3("Timed out waiting for " + this.n + " ms", this));
    }
}
