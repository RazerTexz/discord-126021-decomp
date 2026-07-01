package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.TimeoutException;
import rx.functions.Action0;

/* JADX INFO: compiled from: OnSubscribeTimeoutTimedWithFallback.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g0$b$a implements Action0 {
    public final long j;
    public final /* synthetic */ g0$b k;

    public g0$b$a(g0$b g0_b, long j) {
        this.k = g0_b;
        this.j = j;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // rx.functions.Action0
    public void call() {
        g0$b g0_b = this.k;
        if (g0_b.p.compareAndSet(this.j, RecyclerView.FOREVER_NS)) {
            g0_b.unsubscribe();
            if (g0_b.n == 0) {
                g0_b.j.onError(new TimeoutException());
                return;
            }
            long j = g0_b.f3772s;
            if (j != 0) {
                g0_b.o.b(j);
            }
            g0$a g0_a = new g0$a(g0_b.j, g0_b.o);
            if (g0_b.r.a(g0_a)) {
                g0_b.n.U(g0_a);
            }
        }
    }
}
