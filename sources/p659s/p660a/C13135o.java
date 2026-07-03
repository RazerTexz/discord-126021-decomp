package p659s.p660a;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p659s.p660a.p661a.C13024g;
import p659s.p660a.p661a.C13025h;
import p659s.p660a.p661a.C13037t;

/* JADX INFO: renamed from: s.a.o */
/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13135o extends AbstractC13094e1<Job> {

    /* JADX INFO: renamed from: n */
    public final C13126l<?> f27878n;

    public C13135o(Job job, C13126l<?> c13126l) {
        super(job);
        this.f27878n = c13126l;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        mo11198q(th);
        return Unit.f27425a;
    }

    @Override // p659s.p660a.AbstractC13165y
    /* JADX INFO: renamed from: q */
    public void mo11198q(Throwable th) {
        C13126l<?> c13126l = this.f27878n;
        J j = this.f27845m;
        Objects.requireNonNull(c13126l);
        CancellationException cancellationExceptionMo10914q = j.mo10914q();
        boolean z2 = true;
        boolean z3 = false;
        if (c13126l.f27864l == 2) {
            Continuation<?> continuation = c13126l.f27872p;
            if (!(continuation instanceof C13024g)) {
                continuation = null;
            }
            C13024g c13024g = (C13024g) continuation;
            if (c13024g != null) {
                while (true) {
                    Object obj = c13024g._reusableCancellableContinuation;
                    C13037t c13037t = C13025h.f27682b;
                    if (!C12238m.areEqual(obj, c13037t)) {
                        if (obj instanceof Throwable) {
                            break;
                        } else if (C13024g.f27675m.compareAndSet(c13024g, obj, null)) {
                            z2 = false;
                            break;
                        }
                    } else if (C13024g.f27675m.compareAndSet(c13024g, c13037t, cancellationExceptionMo10914q)) {
                        break;
                    }
                }
                z3 = z2;
            }
        }
        if (z3) {
            return;
        }
        c13126l.mo10906k(cancellationExceptionMo10914q);
        c13126l.m11324s();
    }

    @Override // p659s.p660a.p661a.C13028k
    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ChildContinuation[");
        sbM833U.append(this.f27878n);
        sbM833U.append(']');
        return sbM833U.toString();
    }
}
