package rx;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import j0.g;
import rx.internal.util.SubscriptionList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class Subscriber<T> implements g<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    public Subscriber() {
        this(null, false);
    }

    private void addToRequested(long j) {
        long j2 = this.requested;
        if (j2 == Long.MIN_VALUE) {
            this.requested = j;
            return;
        }
        long j3 = j2 + j;
        if (j3 < 0) {
            this.requested = RecyclerView.FOREVER_NS;
        } else {
            this.requested = j3;
        }
    }

    public final void add(Subscription subscription) {
        this.subscriptions.a(subscription);
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.subscriptions.k;
    }

    public void onStart() {
    }

    public final void request(long j) {
        if (j < 0) {
            throw new IllegalArgumentException(a.t("number requested cannot be negative: ", j));
        }
        synchronized (this) {
            Producer producer = this.producer;
            if (producer != null) {
                producer.j(j);
            } else {
                addToRequested(j);
            }
        }
    }

    public void setProducer(Producer producer) {
        long j;
        Subscriber<?> subscriber;
        boolean z2;
        synchronized (this) {
            j = this.requested;
            this.producer = producer;
            subscriber = this.subscriber;
            z2 = subscriber != null && j == Long.MIN_VALUE;
        }
        if (z2) {
            subscriber.setProducer(producer);
        } else if (j == Long.MIN_VALUE) {
            producer.j(RecyclerView.FOREVER_NS);
        } else {
            producer.j(j);
        }
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    public Subscriber(Subscriber<?> subscriber) {
        this(subscriber, true);
    }

    public Subscriber(Subscriber<?> subscriber, boolean z2) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = subscriber;
        this.subscriptions = (!z2 || subscriber == null) ? new SubscriptionList() : subscriber.subscriptions;
    }
}
