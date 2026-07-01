package j0.l.a;

import j0.Observer2;
import j0.l.e.RxRingBuffer;
import j0.l.e.o.UnsafeAccess;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func2;
import rx.functions.FuncN;
import rx.subscriptions.CompositeSubscription;

/* JADX INFO: renamed from: j0.l.a.q2, reason: use source file name */
/* JADX INFO: compiled from: OperatorZip.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorZip<R> implements Observable.b<R, Observable<?>[]> {
    public final FuncN<? extends R> j;

    /* JADX INFO: renamed from: j0.l.a.q2$a */
    /* JADX INFO: compiled from: OperatorZip.java */
    public static final class a<R> extends AtomicLong {
        public static final int j = (int) (((double) RxRingBuffer.j) * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;
        public final Observer2<? super R> child;
        private final CompositeSubscription childSubscription;
        public int emitted;
        private AtomicLong requested;
        private volatile Object[] subscribers;
        private final FuncN<? extends R> zipFunction;

        /* JADX INFO: renamed from: j0.l.a.q2$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OperatorZip.java */
        public final class C0426a extends Subscriber {
            public final RxRingBuffer j;

            public C0426a() {
                int i = RxRingBuffer.j;
                this.j = UnsafeAccess.b() ? new RxRingBuffer(true, RxRingBuffer.j) : new RxRingBuffer();
            }

            @Override // j0.Observer2
            public void onCompleted() {
                RxRingBuffer rxRingBuffer = this.j;
                if (rxRingBuffer.l == null) {
                    rxRingBuffer.l = NotificationLite.a;
                }
                a.this.b();
            }

            @Override // j0.Observer2
            public void onError(Throwable th) {
                a.this.child.onError(th);
            }

            @Override // j0.Observer2
            public void onNext(Object obj) {
                try {
                    this.j.a(obj);
                } catch (MissingBackpressureException e) {
                    a.this.child.onError(e);
                }
                a.this.b();
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(RxRingBuffer.j);
            }
        }

        public a(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.childSubscription = compositeSubscription;
            this.child = subscriber;
            this.zipFunction = funcN;
            subscriber.add(compositeSubscription);
        }

        public void a(Observable[] observableArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[observableArr.length];
            for (int i = 0; i < observableArr.length; i++) {
                C0426a c0426a = new C0426a();
                objArr[i] = c0426a;
                this.childSubscription.a(c0426a);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i2 = 0; i2 < observableArr.length; i2++) {
                observableArr[i2].i0((C0426a) objArr[i2]);
            }
        }

        public void b() {
            Object[] objArr = this.subscribers;
            if (objArr == null || getAndIncrement() != 0) {
                return;
            }
            int length = objArr.length;
            Observer2<? super R> observer2 = this.child;
            AtomicLong atomicLong = this.requested;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z2 = true;
                for (int i = 0; i < length; i++) {
                    Object objB = ((C0426a) objArr[i]).j.b();
                    if (objB == null) {
                        z2 = false;
                    } else {
                        if (NotificationLite.c(objB)) {
                            observer2.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        }
                        objArr2[i] = NotificationLite.b(objB);
                    }
                }
                if (z2 && atomicLong.get() > 0) {
                    try {
                        observer2.onNext(this.zipFunction.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.emitted++;
                        for (Object obj : objArr) {
                            RxRingBuffer rxRingBuffer = ((C0426a) obj).j;
                            rxRingBuffer.c();
                            if (NotificationLite.c(rxRingBuffer.b())) {
                                observer2.onCompleted();
                                this.childSubscription.unsubscribe();
                                return;
                            }
                        }
                        if (this.emitted > j) {
                            for (Object obj2 : objArr) {
                                ((C0426a) obj2).request(this.emitted);
                            }
                            this.emitted = 0;
                        }
                    } catch (Throwable th) {
                        b.i.a.f.e.o.f.p1(th, observer2, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.q2$b */
    /* JADX INFO: compiled from: OperatorZip.java */
    public static final class b<R> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1216676403723546796L;
        public final a<R> zipper;

        public b(a<R> aVar) {
            this.zipper = aVar;
        }

        @Override // rx.Producer
        public void j(long j) {
            b.i.a.f.e.o.f.c0(this, j);
            this.zipper.b();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.q2$c */
    /* JADX INFO: compiled from: OperatorZip.java */
    public final class c extends Subscriber<Observable[]> {
        public final Subscriber<? super R> j;
        public final a<R> k;
        public final b<R> l;
        public boolean m;

        public c(OperatorZip operatorZip, Subscriber<? super R> subscriber, a<R> aVar, b<R> bVar) {
            this.j = subscriber;
            this.k = aVar;
            this.l = bVar;
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (this.m) {
                return;
            }
            this.j.onCompleted();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            this.j.onError(th);
        }

        @Override // j0.Observer2
        public void onNext(Object obj) {
            Observable[] observableArr = (Observable[]) obj;
            if (observableArr == null || observableArr.length == 0) {
                this.j.onCompleted();
            } else {
                this.m = true;
                this.k.a(observableArr, this.l);
            }
        }
    }

    public OperatorZip(Func2 func2) {
        this.j = new j0.k.d(func2);
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, this.j);
        b bVar = new b(aVar);
        c cVar = new c(this, subscriber, aVar, bVar);
        subscriber.add(cVar);
        subscriber.setProducer(bVar);
        return cVar;
    }
}
