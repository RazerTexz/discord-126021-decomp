package s.a;

import b.d.b.a.outline;
import kotlin.Unit;

/* JADX INFO: renamed from: s.a.i, reason: use source file name */
/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Future extends CancellableContinuationImpl4 {
    public final java.util.concurrent.Future<?> j;

    public Future(java.util.concurrent.Future<?> future) {
        this.j = future;
    }

    @Override // s.a.CompletionHandler
    public void a(Throwable th) {
        this.j.cancel(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.j.cancel(false);
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = outline.U("CancelFutureOnCancel[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
