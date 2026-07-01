package s.a;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.TimeoutCancellationException;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x1<U, T extends U> extends s.a.a.r<T> implements Runnable {
    public final long n;

    public x1(long j, Continuation<? super U> continuation) {
        super(((d0.w.i.a.d) continuation).getContext(), continuation);
        this.n = j;
    }

    @Override // s.a.b, s.a.h1
    public String T() {
        return super.T() + "(timeMillis=" + this.n + ')';
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        w(new TimeoutCancellationException("Timed out waiting for " + this.n + " ms", this));
    }
}
