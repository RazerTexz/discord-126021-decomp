package s.a.c2;

import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.internal.UndeliveredElementException;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u<E> extends t<E> {
    public final Function1<E, Unit> o;

    /* JADX WARN: Multi-variable type inference failed */
    public u(E e, CancellableContinuation<? super Unit> cancellableContinuation, Function1<? super E, Unit> function1) {
        super(e, cancellableContinuation);
        this.o = function1;
    }

    @Override // s.a.a.k
    public boolean n() {
        if (!super.n()) {
            return false;
        }
        u();
        return true;
    }

    @Override // s.a.c2.r
    public void u() {
        Function1<E, Unit> function1 = this.o;
        E e = this.m;
        CoroutineContext context = this.n.getContext();
        UndeliveredElementException undeliveredElementExceptionP = b.i.a.f.e.o.f.p(function1, e, null);
        if (undeliveredElementExceptionP != null) {
            b.i.a.f.e.o.f.u0(context, undeliveredElementExceptionP);
        }
    }
}
