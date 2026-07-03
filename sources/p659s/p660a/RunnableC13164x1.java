package p659s.p660a;

import kotlin.coroutines.Continuation;
import kotlinx.coroutines.TimeoutCancellationException;
import p507d0.p584w.p586i.p587a.AbstractC12187d;
import p659s.p660a.p661a.C13035r;

/* JADX INFO: renamed from: s.a.x1 */
/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC13164x1<U, T extends U> extends C13035r<T> implements Runnable {

    /* JADX INFO: renamed from: n */
    public final long f27920n;

    public RunnableC13164x1(long j, Continuation<? super U> continuation) {
        super(((AbstractC12187d) continuation).getContext(), continuation);
        this.f27920n = j;
    }

    @Override // p659s.p660a.AbstractC13045b, p659s.p660a.C13116h1
    /* JADX INFO: renamed from: T */
    public String mo11184T() {
        return super.mo11184T() + "(timeMillis=" + this.f27920n + ')';
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        m11306w(new TimeoutCancellationException("Timed out waiting for " + this.f27920n + " ms", this));
    }
}
