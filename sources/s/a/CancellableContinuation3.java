package s.a;

import b.d.b.a.outline;
import kotlin.Unit;
import s.a.a.LockFreeLinkedList3;

/* JADX INFO: renamed from: s.a.r1, reason: use source file name */
/* JADX INFO: compiled from: CancellableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CancellableContinuation3 extends CancellableContinuationImpl3 {
    public final LockFreeLinkedList3 j;

    public CancellableContinuation3(LockFreeLinkedList3 lockFreeLinkedList3) {
        this.j = lockFreeLinkedList3;
    }

    @Override // s.a.CompletionHandler
    public void a(Throwable th) {
        this.j.n();
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.j.n();
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = outline.U("RemoveOnCancel[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
