package j0.l.a;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* JADX INFO: compiled from: OperatorTake.java */
/* JADX INFO: loaded from: classes3.dex */
public class b2$a implements Producer {
    public final AtomicLong j = new AtomicLong(0);
    public final /* synthetic */ Producer k;
    public final /* synthetic */ b2 l;

    public b2$a(b2 b2Var, Producer producer) {
        this.l = b2Var;
        this.k = producer;
    }

    @Override // rx.Producer
    public void j(long j) {
        long j2;
        long jMin;
        if (j <= 0 || this.l.k) {
            return;
        }
        do {
            j2 = this.j.get();
            jMin = Math.min(j, ((long) this.l.m.j) - j2);
            if (jMin == 0) {
                return;
            }
        } while (!this.j.compareAndSet(j2, j2 + jMin));
        this.k.j(jMin);
    }
}
