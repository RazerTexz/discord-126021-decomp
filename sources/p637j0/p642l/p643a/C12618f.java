package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p647e.C12719i;
import p637j0.p642l.p647e.p648n.C12728e;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.exceptions.CompositeException;
import p658rx.functions.FuncN;

/* JADX INFO: renamed from: j0.l.a.f */
/* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12618f<T, R> implements Observable.InterfaceC13005a<R> {

    /* JADX INFO: renamed from: j */
    public final Iterable<? extends Observable<? extends T>> f26780j;

    /* JADX INFO: renamed from: k */
    public final FuncN<? extends R> f26781k;

    /* JADX INFO: renamed from: l */
    public final int f26782l;

    /* JADX INFO: renamed from: j0.l.a.f$a */
    /* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
    public static final class a<T, R> extends Subscriber<T> {

        /* JADX INFO: renamed from: j */
        public final b<T, R> f26783j;

        /* JADX INFO: renamed from: k */
        public final int f26784k;

        /* JADX INFO: renamed from: l */
        public boolean f26785l;

        public a(b<T, R> bVar, int i) {
            this.f26783j = bVar;
            this.f26784k = i;
            request(bVar.bufferSize);
        }

        @Override // p637j0.InterfaceC12581g
        public void onCompleted() {
            if (this.f26785l) {
                return;
            }
            this.f26785l = true;
            this.f26783j.m10749c(null, this.f26784k);
        }

        @Override // p637j0.InterfaceC12581g
        public void onError(Throwable th) {
            Throwable th2;
            Throwable compositeException;
            if (this.f26785l) {
                C12774l.m10863b(th);
                return;
            }
            AtomicReference<Throwable> atomicReference = this.f26783j.error;
            do {
                th2 = atomicReference.get();
                if (th2 == null) {
                    compositeException = th;
                } else if (th2 instanceof CompositeException) {
                    ArrayList arrayList = new ArrayList(((CompositeException) th2).m11122b());
                    arrayList.add(th);
                    compositeException = new CompositeException(arrayList);
                } else {
                    compositeException = new CompositeException(Arrays.asList(th2, th));
                }
            } while (!atomicReference.compareAndSet(th2, compositeException));
            this.f26785l = true;
            this.f26783j.m10749c(null, this.f26784k);
        }

        @Override // p637j0.InterfaceC12581g
        public void onNext(T t) {
            if (this.f26785l) {
                return;
            }
            b<T, R> bVar = this.f26783j;
            if (t == null) {
                t = (T) C12614e.f26769b;
            }
            bVar.m10749c(t, this.f26784k);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.f$b */
    /* JADX INFO: compiled from: OnSubscribeCombineLatest.java */
    public static final class b<T, R> extends AtomicInteger implements Producer, Subscription {

        /* JADX INFO: renamed from: j */
        public static final Object f26786j = new Object();
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
        public final C12728e<Object> queue;
        public final AtomicLong requested;
        public final a<T, R>[] subscribers;

        public b(Subscriber<? super R> subscriber, FuncN<? extends R> funcN, int i, int i2, boolean z2) {
            this.actual = subscriber;
            this.combiner = funcN;
            this.bufferSize = i2;
            this.delayError = z2;
            Object[] objArr = new Object[i];
            this.latest = objArr;
            Arrays.fill(objArr, f26786j);
            this.subscribers = new a[i];
            this.queue = new C12728e<>(i2);
            this.requested = new AtomicLong();
            this.error = new AtomicReference<>();
        }

        /* JADX INFO: renamed from: a */
        public void m10747a(Queue<?> queue) {
            queue.clear();
            for (a<T, R> aVar : this.subscribers) {
                aVar.unsubscribe();
            }
        }

        /* JADX INFO: renamed from: b */
        public boolean m10748b(boolean z2, boolean z3, Subscriber<?> subscriber, Queue<?> queue, boolean z4) {
            if (this.cancelled) {
                m10747a(queue);
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
                m10747a(queue);
                subscriber.onError(th2);
                return true;
            }
            if (!z3) {
                return false;
            }
            subscriber.onCompleted();
            return true;
        }

        /* JADX INFO: renamed from: c */
        public void m10749c(Object obj, int i) {
            boolean z2;
            a<T, R> aVar = this.subscribers[i];
            synchronized (this) {
                Object[] objArr = this.latest;
                int length = objArr.length;
                Object obj2 = objArr[i];
                int i2 = this.active;
                Object obj3 = f26786j;
                if (obj2 == obj3) {
                    i2++;
                    this.active = i2;
                }
                int i3 = this.complete;
                if (obj == null) {
                    i3++;
                    this.complete = i3;
                } else {
                    objArr[i] = C12614e.m10745b(obj);
                }
                boolean z3 = false;
                z2 = i2 == length;
                if (i3 == length || (obj == null && obj2 == obj3)) {
                    z3 = true;
                }
                if (z3) {
                    this.done = true;
                } else if (obj != null && z2) {
                    this.queue.m10830e(aVar, this.latest.clone());
                } else if (obj == null && this.error.get() != null && (obj2 == obj3 || !this.delayError)) {
                    this.done = true;
                }
            }
            if (z2 || obj == null) {
                m10750d();
            } else {
                aVar.request(1L);
            }
        }

        /* JADX INFO: renamed from: d */
        public void m10750d() {
            long j;
            if (getAndIncrement() != 0) {
                return;
            }
            C12728e<Object> c12728e = this.queue;
            Subscriber<? super R> subscriber = this.actual;
            boolean z2 = this.delayError;
            AtomicLong atomicLong = this.requested;
            int iAddAndGet = 1;
            while (!m10748b(this.done, c12728e.isEmpty(), subscriber, c12728e, z2)) {
                long j2 = atomicLong.get();
                long j3 = 0;
                while (true) {
                    if (j3 == j2) {
                        j = j3;
                        break;
                    }
                    boolean z3 = this.done;
                    a aVar = (a) c12728e.peek();
                    boolean z4 = aVar == null;
                    long j4 = j3;
                    if (m10748b(z3, z4, subscriber, c12728e, z2)) {
                        return;
                    }
                    if (z4) {
                        j = j4;
                        break;
                    }
                    c12728e.poll();
                    Object[] objArr = (Object[]) c12728e.poll();
                    if (objArr == null) {
                        this.cancelled = true;
                        m10747a(c12728e);
                        subscriber.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
                        return;
                    }
                    try {
                        subscriber.onNext(this.combiner.call(objArr));
                        aVar.request(1L);
                        j3 = j4 + 1;
                    } catch (Throwable th) {
                        this.cancelled = true;
                        m10747a(c12728e);
                        subscriber.onError(th);
                        return;
                    }
                }
                if (j != 0 && j2 != RecyclerView.FOREVER_NS) {
                    C3404f.m4250U0(atomicLong, j);
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancelled;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(C1643a.m877t("n >= required but it was ", j));
            }
            if (j != 0) {
                C3404f.m4276c0(this.requested, j);
                m10750d();
            }
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            if (getAndIncrement() == 0) {
                m10747a(this.queue);
            }
        }
    }

    public C12618f(Iterable<? extends Observable<? extends T>> iterable, FuncN<? extends R> funcN) {
        int i = C12719i.f27283j;
        this.f26780j = iterable;
        this.f26781k = funcN;
        this.f26782l = i;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Observable[] observableArr;
        int length;
        Subscriber subscriber = (Subscriber) obj;
        Iterable<? extends Observable<? extends T>> iterable = this.f26780j;
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
        b bVar = new b(subscriber, this.f26781k, length, this.f26782l, false);
        a<T, R>[] aVarArr = bVar.subscribers;
        int length2 = aVarArr.length;
        for (int i2 = 0; i2 < length2; i2++) {
            aVarArr[i2] = new a<>(bVar, i2);
        }
        bVar.lazySet(0);
        bVar.actual.add(bVar);
        bVar.actual.setProducer(bVar);
        for (int i3 = 0; i3 < length2 && !bVar.cancelled; i3++) {
            observableArr[i3].m11095U(aVarArr[i3]);
        }
    }
}
