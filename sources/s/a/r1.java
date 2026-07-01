package s.a;

import b.d.b.a.a;
import kotlin.Unit;

/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r1 extends e {
    public final s.a.a.k j;

    public r1(s.a.a.k kVar) {
        this.j = kVar;
    }

    @Override // s.a.k
    public void a(Throwable th) {
        this.j.n();
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.j.n();
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = a.U("RemoveOnCancel[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
