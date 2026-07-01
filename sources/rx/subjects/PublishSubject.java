package rx.subjects;

import b.i.a.f.e.o.f;
import j0.Observer2;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;

/* JADX INFO: loaded from: classes3.dex */
public final class PublishSubject<T> extends Subject<T, T> {
    public final b<T> k;

    public static final class a<T> extends AtomicLong implements Producer, Subscription, Observer2<T> {
        private static final long serialVersionUID = 6451806817170721536L;
        public final Subscriber<? super T> actual;
        public final b<T> parent;
        public long produced;

        public a(b<T> bVar, Subscriber<? super T> subscriber) {
            this.parent = bVar;
            this.actual = subscriber;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.Producer
        public void j(long j) {
            long j2;
            if (f.A1(j)) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j2, f.f(j2, j)));
            }
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onCompleted();
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            }
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            long j = get();
            if (j != Long.MIN_VALUE) {
                long j2 = this.produced;
                if (j != j2) {
                    this.produced = j2 + 1;
                    this.actual.onNext(t);
                } else {
                    unsubscribe();
                    this.actual.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
                }
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.a(this);
            }
        }
    }

    public static final class b<T> extends AtomicReference<a<T>[]> implements Observable.a<T>, Observer2<T> {
        public static final a[] j = new a[0];
        public static final a[] k = new a[0];
        private static final long serialVersionUID = -7568940796666027140L;
        public Throwable error;

        public b() {
            lazySet(j);
        }

        public void a(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == k || aVarArr == j) {
                    return;
                }
                int length = aVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (aVarArr[i] == aVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = j;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                    System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            boolean z2;
            Subscriber subscriber = (Subscriber) obj;
            a<T> aVar = new a<>(this, subscriber);
            subscriber.add(aVar);
            subscriber.setProducer(aVar);
            while (true) {
                a<T>[] aVarArr = get();
                z2 = false;
                if (aVarArr == k) {
                    break;
                }
                int length = aVarArr.length;
                a[] aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
                if (compareAndSet(aVarArr, aVarArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                if (aVar.isUnsubscribed()) {
                    a(aVar);
                }
            } else {
                Throwable th = this.error;
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
            }
        }

        @Override // j0.Observer2
        public void onCompleted() {
            for (a<T> aVar : getAndSet(k)) {
                aVar.onCompleted();
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            this.error = th;
            ArrayList arrayList = null;
            for (a<T> aVar : getAndSet(k)) {
                try {
                    aVar.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th2);
                }
            }
            f.n1(arrayList);
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            for (a<T> aVar : get()) {
                aVar.onNext(t);
            }
        }
    }

    public PublishSubject(b<T> bVar) {
        super(bVar);
        this.k = bVar;
    }

    public static <T> PublishSubject<T> k0() {
        return new PublishSubject<>(new b());
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.k.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.k.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        this.k.onNext(t);
    }
}
