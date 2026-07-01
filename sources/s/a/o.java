package s.a;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import s.a.a.DispatchedContinuation;
import s.a.a.DispatchedContinuation2;
import s.a.a.Symbol3;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends e1<Job> {
    public final CancellableContinuationImpl5<?> n;

    public o(Job job, CancellableContinuationImpl5<?> cancellableContinuationImpl5) {
        super(job);
        this.n = cancellableContinuationImpl5;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        q(th);
        return Unit.a;
    }

    @Override // s.a.CompletionHandler2
    public void q(Throwable th) {
        CancellableContinuationImpl5<?> cancellableContinuationImpl5 = this.n;
        J j = this.m;
        Objects.requireNonNull(cancellableContinuationImpl5);
        CancellationException cancellationExceptionQ = j.q();
        boolean z2 = true;
        boolean z3 = false;
        if (cancellableContinuationImpl5.l == 2) {
            Continuation<?> continuation = cancellableContinuationImpl5.p;
            if (!(continuation instanceof DispatchedContinuation)) {
                continuation = null;
            }
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            if (dispatchedContinuation != null) {
                while (true) {
                    Object obj = dispatchedContinuation._reusableCancellableContinuation;
                    Symbol3 symbol3 = DispatchedContinuation2.f3827b;
                    if (!Intrinsics3.areEqual(obj, symbol3)) {
                        if (obj instanceof Throwable) {
                            break;
                        } else if (DispatchedContinuation.m.compareAndSet(dispatchedContinuation, obj, null)) {
                            z2 = false;
                            break;
                        }
                    } else if (DispatchedContinuation.m.compareAndSet(dispatchedContinuation, symbol3, cancellationExceptionQ)) {
                        break;
                    }
                }
                z3 = z2;
            }
        }
        if (z3) {
            return;
        }
        cancellableContinuationImpl5.k(cancellationExceptionQ);
        cancellableContinuationImpl5.s();
    }

    @Override // s.a.a.LockFreeLinkedList3
    public String toString() {
        StringBuilder sbU = outline.U("ChildContinuation[");
        sbU.append(this.n);
        sbU.append(']');
        return sbU.toString();
    }
}
