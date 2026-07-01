package s.a.b2;

import kotlin.Unit;
import kotlinx.coroutines.CancellableContinuation;

/* JADX INFO: compiled from: Runnable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b implements Runnable {
    public final /* synthetic */ a j;
    public final /* synthetic */ CancellableContinuation k;

    public a$b(a aVar, CancellableContinuation cancellableContinuation) {
        this.j = aVar;
        this.k = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.k.i(this.j, Unit.a);
    }
}
