package j0.l.a;

import java.util.Iterator;
import java.util.Objects;
import rx.Observable$a;
import rx.Subscriber;

/* JADX INFO: compiled from: OnSubscribeFromIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q<T> implements Observable$a<T> {
    public final Iterable<? extends T> j;

    public q(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "iterable must not be null");
        this.j = iterable;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            Iterator<? extends T> it = this.j.iterator();
            boolean zHasNext = it.hasNext();
            if (subscriber.isUnsubscribed()) {
                return;
            }
            if (zHasNext) {
                subscriber.setProducer(new q$a(subscriber, it));
            } else {
                subscriber.onCompleted();
            }
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            subscriber.onError(th);
        }
    }
}
