package p658rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.InterfaceC12581g;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.exceptions.MissingBackpressureException;

/* JADX INFO: loaded from: classes3.dex */
public final class PublishSubject<T> extends Subject<T, T> {

    /* JADX INFO: renamed from: k */
    public final C13016b<T> f27650k;

    /* JADX INFO: renamed from: rx.subjects.PublishSubject$a */
    public static final class C13015a<T> extends AtomicLong implements Producer, Subscription, InterfaceC12581g<T> {
        private static final long serialVersionUID = 6451806817170721536L;
        public final Subscriber<? super T> actual;
        public final C13016b<T> parent;
        public long produced;

        public C13015a(C13016b<T> c13016b, Subscriber<? super T> subscriber) {
            this.parent = c13016b;
            this.actual = subscriber;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            long j2;
            if (C3404f.m4191A1(j)) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j2, C3404f.m4287f(j2, j)));
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onCompleted();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th);
            }
        }

        @Override // p637j0.InterfaceC12581g
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

        @Override // p658rx.Subscription
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.m11134a(this);
            }
        }
    }

    /* JADX INFO: renamed from: rx.subjects.PublishSubject$b */
    public static final class C13016b<T> extends AtomicReference<C13015a<T>[]> implements Observable.InterfaceC13005a<T>, InterfaceC12581g<T> {

        /* JADX INFO: renamed from: j */
        public static final C13015a[] f27651j = new C13015a[0];

        /* JADX INFO: renamed from: k */
        public static final C13015a[] f27652k = new C13015a[0];
        private static final long serialVersionUID = -7568940796666027140L;
        public Throwable error;

        public C13016b() {
            lazySet(f27651j);
        }

        /* JADX INFO: renamed from: a */
        public void m11134a(C13015a<T> c13015a) {
            C13015a<T>[] c13015aArr;
            C13015a[] c13015aArr2;
            do {
                c13015aArr = get();
                if (c13015aArr == f27652k || c13015aArr == f27651j) {
                    return;
                }
                int length = c13015aArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (c13015aArr[i] == c13015a) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    c13015aArr2 = f27651j;
                } else {
                    C13015a[] c13015aArr3 = new C13015a[length - 1];
                    System.arraycopy(c13015aArr, 0, c13015aArr3, 0, i);
                    System.arraycopy(c13015aArr, i + 1, c13015aArr3, i, (length - i) - 1);
                    c13015aArr2 = c13015aArr3;
                }
            } while (!compareAndSet(c13015aArr, c13015aArr2));
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            boolean z2;
            Subscriber subscriber = (Subscriber) obj;
            C13015a<T> c13015a = new C13015a<>(this, subscriber);
            subscriber.add(c13015a);
            subscriber.setProducer(c13015a);
            while (true) {
                C13015a<T>[] c13015aArr = get();
                z2 = false;
                if (c13015aArr == f27652k) {
                    break;
                }
                int length = c13015aArr.length;
                C13015a[] c13015aArr2 = new C13015a[length + 1];
                System.arraycopy(c13015aArr, 0, c13015aArr2, 0, length);
                c13015aArr2[length] = c13015a;
                if (compareAndSet(c13015aArr, c13015aArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                if (c13015a.isUnsubscribed()) {
                    m11134a(c13015a);
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

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            for (C13015a<T> c13015a : getAndSet(f27652k)) {
                c13015a.onCompleted();
            }
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            this.error = th;
            ArrayList arrayList = null;
            for (C13015a<T> c13015a : getAndSet(f27652k)) {
                try {
                    c13015a.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th2);
                }
            }
            C3404f.m4321n1(arrayList);
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            for (C13015a<T> c13015a : get()) {
                c13015a.onNext(t);
            }
        }
    }

    public PublishSubject(C13016b<T> c13016b) {
        super(c13016b);
        this.f27650k = c13016b;
    }

    /* JADX INFO: renamed from: k0 */
    public static <T> PublishSubject<T> m11133k0() {
        return new PublishSubject<>(new C13016b());
    }

    @Override // p637j0.InterfaceC12581g
    public void onCompleted() {
        this.f27650k.onCompleted();
    }

    @Override // p637j0.InterfaceC12581g
    public void onError(Throwable th) {
        this.f27650k.onError(th);
    }

    @Override // p637j0.InterfaceC12581g
    public void onNext(T t) {
        this.f27650k.onNext(t);
    }
}
