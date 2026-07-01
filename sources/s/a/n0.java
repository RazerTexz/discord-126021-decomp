package s.a;

import b.d.b.a.a;
import kotlin.Unit;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends j {
    public final m0 j;

    public n0(m0 m0Var) {
        this.j = m0Var;
    }

    @Override // s.a.k
    public void a(Throwable th) {
        this.j.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.j.dispose();
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = a.U("DisposeOnCancel[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
