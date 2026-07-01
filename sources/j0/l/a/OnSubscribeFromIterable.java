package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.q, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeFromIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeFromIterable<T> implements Observable.a<T> {
    public final Iterable<? extends T> j;

    /* JADX INFO: renamed from: j0.l.a.q$a */
    /* JADX INFO: compiled from: OnSubscribeFromIterable.java */
    public static final class a<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;
        private final Subscriber<? super T> o;

        public a(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.o = subscriber;
            this.it = it;
        }

        @Override // rx.Producer
        public void j(long j) {
            if (get() == RecyclerView.FOREVER_NS) {
                return;
            }
            if (j == RecyclerView.FOREVER_NS && compareAndSet(0L, RecyclerView.FOREVER_NS)) {
                Subscriber<? super T> subscriber = this.o;
                Iterator<? extends T> it = this.it;
                while (!subscriber.isUnsubscribed()) {
                    try {
                        subscriber.onNext(it.next());
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        try {
                            if (!it.hasNext()) {
                                if (subscriber.isUnsubscribed()) {
                                    return;
                                }
                                subscriber.onCompleted();
                                return;
                            }
                        } catch (Throwable th) {
                            b.i.a.f.e.o.f.o1(th);
                            subscriber.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        b.i.a.f.e.o.f.o1(th2);
                        subscriber.onError(th2);
                        return;
                    }
                }
                return;
            }
            if (j <= 0 || b.i.a.f.e.o.f.c0(this, j) != 0) {
                return;
            }
            Subscriber<? super T> subscriber2 = this.o;
            Iterator<? extends T> it2 = this.it;
            do {
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        j = get();
                        if (j2 == j) {
                            break;
                        }
                    } else {
                        if (subscriber2.isUnsubscribed()) {
                            return;
                        }
                        try {
                            subscriber2.onNext(it2.next());
                            if (subscriber2.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it2.hasNext()) {
                                    if (subscriber2.isUnsubscribed()) {
                                        return;
                                    }
                                    subscriber2.onCompleted();
                                    return;
                                }
                                j2++;
                            } catch (Throwable th3) {
                                b.i.a.f.e.o.f.o1(th3);
                                subscriber2.onError(th3);
                                return;
                            }
                        } catch (Throwable th4) {
                            b.i.a.f.e.o.f.o1(th4);
                            subscriber2.onError(th4);
                            return;
                        }
                    }
                }
                j = b.i.a.f.e.o.f.U0(this, j2);
            } while (j != 0);
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
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
                subscriber.setProducer(new a(subscriber, it));
            } else {
                subscriber.onCompleted();
            }
        } catch (Throwable th) {
            b.i.a.f.e.o.f.o1(th);
            subscriber.onError(th);
        }
    }
}
