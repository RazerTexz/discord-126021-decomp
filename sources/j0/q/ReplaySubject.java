package j0.q;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import j0.Observer2;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.subjects.Subject;

/* JADX INFO: renamed from: j0.q.a, reason: use source file name */
/* JADX INFO: compiled from: ReplaySubject.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ReplaySubject<T> extends Subject<T, T> {
    public static final Object[] k = new Object[0];
    public final d<T> l;

    /* JADX INFO: renamed from: j0.q.a$a */
    /* JADX INFO: compiled from: ReplaySubject.java */
    public interface a<T> {
    }

    /* JADX INFO: renamed from: j0.q.a$b */
    /* JADX INFO: compiled from: ReplaySubject.java */
    public static final class b<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        public final Subscriber<? super T> actual;
        public int index;
        public Object node;
        public final AtomicLong requested = new AtomicLong();
        public final d<T> state;
        public int tailIndex;

        public b(Subscriber<? super T> subscriber, d<T> dVar) {
            this.actual = subscriber;
            this.state = dVar;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        @Override // rx.Producer
        public void j(long j) {
            if (j > 0) {
                f.c0(this.requested, j);
                ((c) this.state.buffer).a(this);
            } else if (j < 0) {
                throw new IllegalArgumentException(outline.t("n >= required but it was ", j));
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.state.a(this);
        }
    }

    /* JADX INFO: renamed from: j0.q.a$c */
    /* JADX INFO: compiled from: ReplaySubject.java */
    public static final class c<T> implements a<T> {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile a<T> f3804b;
        public a<T> c;
        public int d;
        public volatile boolean e;
        public Throwable f;

        /* JADX INFO: renamed from: j0.q.a$c$a */
        /* JADX INFO: compiled from: ReplaySubject.java */
        public static final class a<T> extends AtomicReference<a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            public final T value;

            public a(T t) {
                this.value = t;
            }
        }

        public c(int i) {
            this.a = i;
            a<T> aVar = new a<>(null);
            this.c = aVar;
            this.f3804b = aVar;
        }

        public void a(b<T> bVar) {
            if (bVar.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = bVar.actual;
            int iAddAndGet = 1;
            do {
                long j = bVar.requested.get();
                a<T> aVar = (a) bVar.node;
                if (aVar == null) {
                    aVar = this.f3804b;
                }
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        bVar.node = null;
                        return;
                    }
                    boolean z2 = this.e;
                    a<T> aVar2 = aVar.get();
                    boolean z3 = aVar2 == null;
                    if (z2 && z3) {
                        bVar.node = null;
                        Throwable th = this.f;
                        if (th != null) {
                            subscriber.onError(th);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext(aVar2.value);
                    j2++;
                    aVar = aVar2;
                }
                if (j2 == j) {
                    if (subscriber.isUnsubscribed()) {
                        bVar.node = null;
                        return;
                    }
                    boolean z4 = this.e;
                    boolean z5 = aVar.get() == null;
                    if (z4 && z5) {
                        bVar.node = null;
                        Throwable th2 = this.f;
                        if (th2 != null) {
                            subscriber.onError(th2);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0 && j != RecyclerView.FOREVER_NS) {
                    f.U0(bVar.requested, j2);
                }
                bVar.node = aVar;
                iAddAndGet = bVar.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    /* JADX INFO: renamed from: j0.q.a$d */
    /* JADX INFO: compiled from: ReplaySubject.java */
    public static final class d<T> extends AtomicReference<b<T>[]> implements Observable.a<T>, Observer2<T> {
        public static final b[] j = new b[0];
        public static final b[] k = new b[0];
        private static final long serialVersionUID = 5952362471246910544L;
        public final a<T> buffer;

        public d(a<T> aVar) {
            this.buffer = aVar;
            lazySet(j);
        }

        public void a(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = get();
                if (bVarArr == k || bVarArr == j) {
                    return;
                }
                int length = bVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (bVarArr[i] == bVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = j;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i);
                    System.arraycopy(bVarArr, i + 1, bVarArr3, i, (length - i) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!compareAndSet(bVarArr, bVarArr2));
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            boolean z2;
            Subscriber subscriber = (Subscriber) obj;
            b<T> bVar = new b<>(subscriber, this);
            subscriber.add(bVar);
            subscriber.setProducer(bVar);
            while (true) {
                b<T>[] bVarArr = get();
                z2 = false;
                if (bVarArr == k) {
                    break;
                }
                int length = bVarArr.length;
                b[] bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
                if (compareAndSet(bVarArr, bVarArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2 && bVar.isUnsubscribed()) {
                a(bVar);
            } else {
                ((c) this.buffer).a(bVar);
            }
        }

        @Override // j0.Observer2
        public void onCompleted() {
            a<T> aVar = this.buffer;
            ((c) aVar).e = true;
            for (b<T> bVar : getAndSet(k)) {
                ((c) aVar).a(bVar);
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            a<T> aVar = this.buffer;
            c cVar = (c) aVar;
            cVar.f = th;
            cVar.e = true;
            ArrayList arrayList = null;
            for (b<T> bVar : getAndSet(k)) {
                try {
                    ((c) aVar).a(bVar);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            f.n1(arrayList);
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            a<T> aVar = this.buffer;
            c cVar = (c) aVar;
            Objects.requireNonNull(cVar);
            c.a<T> aVar2 = new c.a<>(t);
            cVar.c.set(aVar2);
            cVar.c = aVar2;
            int i = cVar.d;
            if (i == cVar.a) {
                cVar.f3804b = cVar.f3804b.get();
            } else {
                cVar.d = i + 1;
            }
            for (b<T> bVar : get()) {
                ((c) aVar).a(bVar);
            }
        }
    }

    public ReplaySubject(d<T> dVar) {
        super(dVar);
        this.l = dVar;
    }

    @Override // j0.Observer2
    public void onCompleted() {
        this.l.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable th) {
        this.l.onError(th);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        this.l.onNext(t);
    }
}
