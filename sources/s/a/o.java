package s.a;

import b.d.b.a.a;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends e1<Job> {
    public final l<?> n;

    public o(Job job, l<?> lVar) {
        super(job);
        this.n = lVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        q(th);
        return Unit.a;
    }

    @Override // s.a.y
    public void q(Throwable th) {
        l<?> lVar = this.n;
        J j = this.m;
        Objects.requireNonNull(lVar);
        CancellationException cancellationExceptionQ = j.q();
        boolean z2 = true;
        boolean z3 = false;
        if (lVar.l == 2) {
            Continuation<?> continuation = lVar.p;
            if (!(continuation instanceof s.a.a.g)) {
                continuation = null;
            }
            s.a.a.g gVar = (s.a.a.g) continuation;
            if (gVar != null) {
                while (true) {
                    Object obj = gVar._reusableCancellableContinuation;
                    s.a.a.t tVar = s.a.a.h.f3827b;
                    if (!d0.z.d.m.areEqual(obj, tVar)) {
                        if (obj instanceof Throwable) {
                            break;
                        } else if (s.a.a.g.m.compareAndSet(gVar, obj, null)) {
                            z2 = false;
                            break;
                        }
                    } else if (s.a.a.g.m.compareAndSet(gVar, tVar, cancellationExceptionQ)) {
                        break;
                    }
                }
                z3 = z2;
            }
        }
        if (z3) {
            return;
        }
        lVar.k(cancellationExceptionQ);
        lVar.s();
    }

    @Override // s.a.a.k
    public String toString() {
        StringBuilder sbU = a.U("ChildContinuation[");
        sbU.append(this.n);
        sbU.append(']');
        return sbU.toString();
    }
}
