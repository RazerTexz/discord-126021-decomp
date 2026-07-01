package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: compiled from: DeferredScalarSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<T, R> extends Subscriber<T> {
    public final Subscriber<? super R> j;
    public boolean k;
    public R l;
    public final AtomicInteger m = new AtomicInteger();

    public a(Subscriber<? super R> subscriber) {
        this.j = subscriber;
    }

    @Override // rx.Subscriber
    public final void setProducer(Producer producer) {
        producer.j(RecyclerView.FOREVER_NS);
    }
}
