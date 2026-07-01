package s.a.c2;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;
import s.a.a.k$b;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a$d<E> extends n<E> {
    public final a$a<E> m;
    public final CancellableContinuation<Boolean> n;

    /* JADX WARN: Multi-variable type inference failed */
    public a$d(a$a<E> a_a, CancellableContinuation<? super Boolean> cancellableContinuation) {
        this.m = a_a;
        this.n = cancellableContinuation;
    }

    @Override // s.a.c2.p
    public void c(E e) {
        this.m.a = e;
        this.n.r(s.a.m.a);
    }

    @Override // s.a.c2.p
    public s.a.a.t d(E e, k$b k_b) {
        if (this.n.h(Boolean.TRUE, null, q(e)) != null) {
            return s.a.m.a;
        }
        return null;
    }

    @Override // s.a.c2.n
    public Function1<Throwable, Unit> q(E e) {
        Function1<E, Unit> function1 = this.m.f3833b.l;
        if (function1 != null) {
            return new s.a.a.o(function1, e, this.n.getContext());
        }
        return null;
    }

    @Override // s.a.c2.n
    public void r(i<?> iVar) {
        Object objC = iVar.m == null ? this.n.c(Boolean.FALSE, null) : this.n.g(iVar.v());
        if (objC != null) {
            this.m.a = iVar;
            this.n.r(objC);
        }
    }

    @Override // s.a.a.k
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ReceiveHasNext@");
        sbU.append(b.i.a.f.e.o.f.l0(this));
        return sbU.toString();
    }
}
