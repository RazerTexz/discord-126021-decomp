package s.a;

import b.d.b.a.a;
import kotlin.Unit;

/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$b extends j {
    public final d<T>.d$a[] j;

    public d$b(d dVar, d<T>.d$a[] d_aArr) {
        this.j = d_aArr;
    }

    @Override // s.a.k
    public void a(Throwable th) {
        b();
    }

    public final void b() {
        for (d<T>.d$a d_a : this.j) {
            m0 m0Var = d_a.n;
            if (m0Var == null) {
                d0.z.d.m.throwUninitializedPropertyAccessException("handle");
            }
            m0Var.dispose();
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        b();
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = a.U("DisposeHandlersOnCancel[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
