package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

/* JADX INFO: compiled from: OperatorMerge.java */
/* JADX INFO: loaded from: classes3.dex */
public final class x0$d<T> extends AtomicLong implements Producer {
    private static final long serialVersionUID = -1214379189873595503L;
    public final x0$e<T> subscriber;

    public x0$d(x0$e<T> x0_e) {
        this.subscriber = x0_e;
    }

    public long a(int i) {
        return addAndGet(-i);
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j <= 0) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        } else {
            if (get() == RecyclerView.FOREVER_NS) {
                return;
            }
            b.i.a.f.e.o.f.c0(this, j);
            this.subscriber.b();
        }
    }
}
