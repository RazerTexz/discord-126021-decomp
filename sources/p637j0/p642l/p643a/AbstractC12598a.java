package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p100d.p104b.p105a.C1643a;
import p658rx.Producer;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.a */
/* JADX INFO: compiled from: DeferredScalarSubscriber.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12598a<T, R> extends Subscriber<T> {

    /* JADX INFO: renamed from: j */
    public final Subscriber<? super R> f26719j;

    /* JADX INFO: renamed from: k */
    public boolean f26720k;

    /* JADX INFO: renamed from: l */
    public R f26721l;

    /* JADX INFO: renamed from: m */
    public final AtomicInteger f26722m = new AtomicInteger();

    /* JADX INFO: renamed from: j0.l.a.a$a */
    /* JADX INFO: compiled from: DeferredScalarSubscriber.java */
    public static final class a implements Producer {

        /* JADX INFO: renamed from: j */
        public final AbstractC12598a<?, ?> f26723j;

        public a(AbstractC12598a<?, ?> abstractC12598a) {
            this.f26723j = abstractC12598a;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            AbstractC12598a<?, ?> abstractC12598a = this.f26723j;
            Objects.requireNonNull(abstractC12598a);
            if (j < 0) {
                throw new IllegalArgumentException(C1643a.m877t("n >= 0 required but it was ", j));
            }
            if (j != 0) {
                Subscriber<? super Object> subscriber = abstractC12598a.f26719j;
                do {
                    int i = abstractC12598a.f26722m.get();
                    if (i == 1 || i == 3 || subscriber.isUnsubscribed()) {
                        return;
                    }
                    if (i == 2) {
                        if (abstractC12598a.f26722m.compareAndSet(2, 3)) {
                            subscriber.onNext(abstractC12598a.f26721l);
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            subscriber.onCompleted();
                            return;
                        }
                        return;
                    }
                } while (!abstractC12598a.f26722m.compareAndSet(0, 1));
            }
        }
    }

    public AbstractC12598a(Subscriber<? super R> subscriber) {
        this.f26719j = subscriber;
    }

    @Override // p658rx.Subscriber
    public final void setProducer(Producer producer) {
        producer.mo10704j(RecyclerView.FOREVER_NS);
    }
}
