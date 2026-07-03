package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;

/* JADX INFO: renamed from: j0.l.a.q */
/* JADX INFO: compiled from: OnSubscribeFromIterable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12662q<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Iterable<? extends T> f26990j;

    /* JADX INFO: renamed from: j0.l.a.q$a */
    /* JADX INFO: compiled from: OnSubscribeFromIterable.java */
    public static final class a<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;

        /* JADX INFO: renamed from: it */
        private final Iterator<? extends T> f26991it;

        /* JADX INFO: renamed from: o */
        private final Subscriber<? super T> f26992o;

        public a(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.f26992o = subscriber;
            this.f26991it = it;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            if (get() == RecyclerView.FOREVER_NS) {
                return;
            }
            if (j == RecyclerView.FOREVER_NS && compareAndSet(0L, RecyclerView.FOREVER_NS)) {
                Subscriber<? super T> subscriber = this.f26992o;
                Iterator<? extends T> it = this.f26991it;
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
                            C3404f.m4325o1(th);
                            subscriber.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        C3404f.m4325o1(th2);
                        subscriber.onError(th2);
                        return;
                    }
                }
                return;
            }
            if (j <= 0 || C3404f.m4276c0(this, j) != 0) {
                return;
            }
            Subscriber<? super T> subscriber2 = this.f26992o;
            Iterator<? extends T> it2 = this.f26991it;
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
                                C3404f.m4325o1(th3);
                                subscriber2.onError(th3);
                                return;
                            }
                        } catch (Throwable th4) {
                            C3404f.m4325o1(th4);
                            subscriber2.onError(th4);
                            return;
                        }
                    }
                }
                j = C3404f.m4250U0(this, j2);
            } while (j != 0);
        }
    }

    public C12662q(Iterable<? extends T> iterable) {
        Objects.requireNonNull(iterable, "iterable must not be null");
        this.f26990j = iterable;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        try {
            Iterator<? extends T> it = this.f26990j.iterator();
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
            C3404f.m4325o1(th);
            subscriber.onError(th);
        }
    }
}
