package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.a, reason: use source file name */
/* JADX INFO: compiled from: DeferredScalarSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DeferredScalarSubscriber<T, R> extends Subscriber<T> {
    public final Subscriber<? super R> j;
    public boolean k;
    public R l;
    public final AtomicInteger m = new AtomicInteger();

    /* JADX INFO: renamed from: j0.l.a.a$a */
    /* JADX INFO: compiled from: DeferredScalarSubscriber.java */
    public static final class a implements Producer {
        public final DeferredScalarSubscriber<?, ?> j;

        public a(DeferredScalarSubscriber<?, ?> deferredScalarSubscriber) {
            this.j = deferredScalarSubscriber;
        }

        @Override // rx.Producer
        public void j(long j) {
            DeferredScalarSubscriber<?, ?> deferredScalarSubscriber = this.j;
            Objects.requireNonNull(deferredScalarSubscriber);
            if (j < 0) {
                throw new IllegalArgumentException(outline.t("n >= 0 required but it was ", j));
            }
            if (j != 0) {
                Subscriber<? super Object> subscriber = deferredScalarSubscriber.j;
                do {
                    int i = deferredScalarSubscriber.m.get();
                    if (i == 1 || i == 3 || subscriber.isUnsubscribed()) {
                        return;
                    }
                    if (i == 2) {
                        if (deferredScalarSubscriber.m.compareAndSet(2, 3)) {
                            subscriber.onNext(deferredScalarSubscriber.l);
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            subscriber.onCompleted();
                            return;
                        }
                        return;
                    }
                } while (!deferredScalarSubscriber.m.compareAndSet(0, 1));
            }
        }
    }

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        this.j = subscriber;
    }

    @Override // rx.Subscriber
    public final void setProducer(Producer producer) {
        producer.j(RecyclerView.FOREVER_NS);
    }
}
