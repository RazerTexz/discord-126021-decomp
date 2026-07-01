package s.a;

import b.d.b.a.outline;
import kotlin.Unit;

/* JADX INFO: renamed from: s.a.n0, reason: use source file name */
/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CancellableContinuation2 extends CancellableContinuationImpl4 {
    public final Job2 j;

    public CancellableContinuation2(Job2 job2) {
        this.j = job2;
    }

    @Override // s.a.CompletionHandler
    public void a(Throwable th) {
        this.j.dispose();
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.j.dispose();
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = outline.U("DisposeOnCancel[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
