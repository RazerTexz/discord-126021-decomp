package s.a;

import b.d.b.a.a;
import java.util.concurrent.Future;
import kotlin.Unit;

/* JADX INFO: compiled from: Future.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends j {
    public final Future<?> j;

    public i(Future<?> future) {
        this.j = future;
    }

    @Override // s.a.k
    public void a(Throwable th) {
        this.j.cancel(false);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Throwable th) {
        this.j.cancel(false);
        return Unit.a;
    }

    public String toString() {
        StringBuilder sbU = a.U("CancelFutureOnCancel[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
