package j0.l.a;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* JADX INFO: compiled from: OperatorZip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q2$b<R> extends AtomicLong implements Producer {
    private static final long serialVersionUID = -1216676403723546796L;
    public final q2$a<R> zipper;

    public q2$b(q2$a<R> q2_a) {
        this.zipper = q2_a;
    }

    @Override // rx.Producer
    public void j(long j) {
        b.i.a.f.e.o.f.c0(this, j);
        this.zipper.b();
    }
}
