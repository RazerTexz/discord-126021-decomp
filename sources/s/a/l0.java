package s.a;

import b.d.b.a.a;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: Executors.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l0 implements m0 {
    public final Future<?> j;

    public l0(Future<?> future) {
        this.j = future;
    }

    @Override // s.a.m0
    public void dispose() {
        this.j.cancel(false);
    }

    public String toString() {
        StringBuilder sbU = a.U("DisposableFutureHandle[");
        sbU.append(this.j);
        sbU.append(']');
        return sbU.toString();
    }
}
