package s.a.c2;

import d0.k$a;
import kotlinx.coroutines.CancellableContinuation;
import s.a.a.k$b;

/* JADX INFO: compiled from: AbstractChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a$b<E> extends n<E> {
    public final CancellableContinuation<Object> m;
    public final int n;

    public a$b(CancellableContinuation<Object> cancellableContinuation, int i) {
        this.m = cancellableContinuation;
        this.n = i;
    }

    @Override // s.a.c2.p
    public void c(E e) {
        this.m.r(s.a.m.a);
    }

    @Override // s.a.c2.p
    public s.a.a.t d(E e, k$b k_b) {
        if (this.m.h(this.n != 2 ? e : new v(e), null, q(e)) != null) {
            return s.a.m.a;
        }
        return null;
    }

    @Override // s.a.c2.n
    public void r(i<?> iVar) {
        int i = this.n;
        if (i == 1 && iVar.m == null) {
            CancellableContinuation<Object> cancellableContinuation = this.m;
            k$a k_a = d0.k.j;
            cancellableContinuation.resumeWith(d0.k.m97constructorimpl(null));
        } else {
            if (i == 2) {
                CancellableContinuation<Object> cancellableContinuation2 = this.m;
                v vVar = new v(new v$a(iVar.m));
                k$a k_a2 = d0.k.j;
                cancellableContinuation2.resumeWith(d0.k.m97constructorimpl(vVar));
                return;
            }
            CancellableContinuation<Object> cancellableContinuation3 = this.m;
            Throwable thV = iVar.v();
            k$a k_a3 = d0.k.j;
            cancellableContinuation3.resumeWith(d0.k.m97constructorimpl(d0.l.createFailure(thV)));
        }
    }

    @Override // s.a.a.k
    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ReceiveElement@");
        sbU.append(b.i.a.f.e.o.f.l0(this));
        sbU.append("[receiveMode=");
        return b.d.b.a.a.A(sbU, this.n, ']');
    }
}
