package j0.q;

import b.i.a.f.e.o.f;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: compiled from: ReplaySubject.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a$b<T> extends AtomicInteger implements Producer, Subscription {
    private static final long serialVersionUID = -5006209596735204567L;
    public final Subscriber<? super T> actual;
    public int index;
    public Object node;
    public final AtomicLong requested = new AtomicLong();
    public final a$d<T> state;
    public int tailIndex;

    public a$b(Subscriber<? super T> subscriber, a$d<T> a_d) {
        this.actual = subscriber;
        this.state = a_d;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return this.actual.isUnsubscribed();
    }

    @Override // rx.Producer
    public void j(long j) {
        if (j > 0) {
            f.c0(this.requested, j);
            ((a$c) this.state.buffer).a(this);
        } else if (j < 0) {
            throw new IllegalArgumentException(b.d.b.a.a.t("n >= required but it was ", j));
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.state.a(this);
    }
}
