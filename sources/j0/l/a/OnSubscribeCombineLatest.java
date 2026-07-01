package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import j0.l.e.RxRingBuffer;
import j0.l.e.n.SpscLinkedArrayQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;

/* JADX INFO: renamed from: j0.l.a.f, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeCombineLatest<T, R> implements Observable.a<R> {
    public final Iterable<? extends Observable<? extends T>> j;
    public final FuncN<? extends R> k;
    public final int l;

    /* JADX INFO: renamed from: j0.l.a.f$a */
    /* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
    public static final class a<T, R> extends Subscriber<T> {
        public final b<T, R> j;
        public final int k;
        public boolean l;

        public a(b<T, R> bVar, int i) {
            this.j = bVar;
            this.k = i;
            request(bVar.bufferSize);
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.l) {
                return;
            }
            this.l = true;
            this.j.c(null, this.k);
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            Throwable th2;
            Throwable compositeException;
            if (this.l) {
                j0.o.l.b(th);
                return;
            }
            AtomicReference<Throwable> atomicReference = this.j.error;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    compositeException = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).b());
                    arrayList.add(th);
                    compositeException = new CompositeException(arrayList);
                } else {
                    compositeException = new CompositeException(Arrays.asList(th2, th));
                }
            } while (!atomicReference.compareAndSet(th2, compositeException));
            this.l = true;
            this.j.c(null, this.k);
        }

        @Override // j0.Observer2
        public void onNext(T t) {
            if (this.l) {
                return;
            }
            b<T, R> bVar = this.j;
            if (t == null) {
                t = (T) NotificationLite.f3771b;
            }
            bVar.c(t, this.k);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.f$b */
    /* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
    public static final class b<T, R> extends AtomicInteger implements Producer, Subscription {
        public static final Object j = new Object();
        private static final long serialVersionUID = 8567835998786448817L;
        public int active;
        public final Subscriber<? super R> actual;
        public final int bufferSize;
        public volatile boolean cancelled;
        public final FuncN<? extends R> combiner;
        public int complete;
        public final boolean delayError;
        public volatile boolean done;
        public final AtomicReference<Throwable> error;
        public final Object[] latest;
        public final SpscLinkedArrayQueue<Object> queue;
        public final AtomicLong requested;
        public final a<T, R>[] subscribers;

        public b(Subscriber<? super R> subscriber, FuncN<? extends R> funcN, int i, int i2, boolean z2) {
            this.actual = subscriber;
            this.combiner = funcN;
            this.bufferSize = i2;
            this.delayError = z2;
            Object[] objArr = new Object[i];
            this.latest = objArr;
            Arrays.fill(objArr, j);
            this.subscribers = new a[i];
            this.queue = new SpscLinkedArrayQueue<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        public void a(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.subscribers) {
                aVar.unsubscribe();
            }
        }

        public boolean b(boolean z2, boolean z3, Subscriber<?> subscriber, Queue<?> queue, boolean z4) {
            if (this.cancelled) {
                a(queue);
                return true;
            }
            if (!z2) {
                return false;
            }
            if (z4) {
                if (!z3) {
                    return false;
                }
                Throwable th = this.error.get();
                if (th != null) {
                    subscriber.onError(th);
                } else {
                    subscriber.onCompleted();
                }
                return true;
            }
            Throwable th2 = this.error.get();
            if (th2 != null) {
                a(queue);
                subscriber.onError(th2);
                return true;
            }
            if (!z3) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        public void c(Object obj, int i) {
            boolean z2;
            a<T, R> aVar = this.subscribers[i];
            synchronized (this) {
                Object[] objArr = this.latest;
                int length = objArr.length;
                Object obj2 = objArr[i];
                int i2 = this.active;
                Object obj3 = j;
                if (obj2 == obj3) {
                    i2++;
                    this.active = i2;
                }
                int i3 = this.complete;
                if (obj == null) {
                    i3++;
                    this.complete = i3;
                } else {
                    objArr[i] = NotificationLite.b(obj);
                }
                boolean z3 = false;
                z2 = i2 == length;
                if (i3 == length || (obj == null && obj2 == obj3)) {
                    z3 = true;
                }
                if (z3) {
                    this.done = true;
                } else if (obj != null && z2) {
                    this.queue.e(aVar, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == obj3 || !this.delayError)) {
                    this.done = true;
                }
            }
            if (z2 || obj == null) {
                d();
            } else {
                aVar.request(1L);
            }
        }

        public void d() {
            long j2;
            if (getAndIncrement() != 0) {
                return;
            }
            SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.queue;
            Subscriber<? super R> subscriber = this.actual;
            boolean z2 = this.delayError;
            AtomicLong atomicLong = this.requested;
            int iAddAndGet = 1;
            while (!b(this.done, spscLinkedArrayQueue.isEmpty(), subscriber, spscLinkedArrayQueue, z2)) {
                long j3 = atomicLong.get();
                long j4 = 0;
                while (true) {
                    if (j4 == j3) {
                        j2 = j4;
                        break;
                    }
                    boolean z3 = this.done;
                    a aVar = (a) spscLinkedArrayQueue.peek();
                    boolean z4 = aVar == null;
                    long j5 = j4;
                    if (b(z3, z4, subscriber, spscLinkedArrayQueue, z2)) {
                        return;
                    }
                    if (z4) {
                        j2 = j5;
                        break;
                    }
                    spscLinkedArrayQueue.poll();
                    Object[] objArr = (Object[]) spscLinkedArrayQueue.poll();
                    if (objArr == null) {
                        this.cancelled = true;
                        a(spscLinkedArrayQueue);
                        subscriber.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        subscriber.onNext(this.combiner.call(objArr));
                        aVar.request(1L);
                        j4 = j5 + 1;
                    } catch (Throwable th) {
                        this.cancelled = true;
                        a(spscLinkedArrayQueue);
                        subscriber.onError(th);
                        return;
                    }
                }
                if (j2 != 0 && j3 != RecyclerView.FOREVER_NS) {
                    b.i.a.f.e.o.f.U0(atomicLong, j2);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        @Override // rx.Producer
        public void j(long j2) {
            if (j2 < 0) {
                throw new IllegalArgumentException(outline.t("n >= required but it was ", j2));
            }
            if (j2 != 0) {
                b.i.a.f.e.o.f.c0(this.requested, j2);
                d();
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                a(this.queue);
            }
        }
    }

    public OnSubscribeCombineLatest(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        int i = RxRingBuffer.j;
        this.j = iterable;
        this.k = funcN;
        this.l = i;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        Observable[] observableArr;
        int length;
        Subscriber subscriber = (Subscriber) obj;
        Iterable<? extends Observable<? extends T>> iterable = this.j;
        if (iterable instanceof List) {
            List list = (List) iterable;
            observableArr = (Observable[]) list.toArray(new Observable[list.size()]);
            length = observableArr.length;
        } else {
            Observable[] observableArr2 = new Observable[8];
            int i = 0;
            for (Observable<? extends T> observable : iterable) {
                if (i == observableArr2.length) {
                    Observable[] observableArr3 = new Observable[(i >> 2) + i];
                    System.arraycopy(observableArr2, 0, observableArr3, 0, i);
                    observableArr2 = observableArr3;
                }
                observableArr2[i] = observable;
                i++;
            }
            observableArr = observableArr2;
            length = i;
        }
        if (length == 0) {
            subscriber.onCompleted();
            return;
        }
        b bVar = new b(subscriber, this.k, length, this.l, false);
        a<T, R>[] aVarArr = bVar.subscribers;
        int length2 = aVarArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            aVarArr[i2] = new a<>(bVar, i2);
        }
        bVar.lazySet(0);
        bVar.actual.add(bVar);
        bVar.actual.setProducer(bVar);
        for (int i3 = 0; i3 < length2 && !bVar.cancelled; i3++) {
            observableArr[i3].U(aVarArr[i3]);
        }
    }
}
