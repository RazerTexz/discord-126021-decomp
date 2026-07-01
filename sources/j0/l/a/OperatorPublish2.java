package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.outline;
import j0.l.a.NotificationLite;
import j0.l.e.RxRingBuffer;
import j0.l.e.n.SpscAtomicArrayQueue;
import j0.l.e.o.SpscArrayQueue;
import j0.l.e.o.UnsafeAccess;
import j0.m.ConnectableObservable;
import j0.r.BooleanSubscription;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action1;

/* JADX INFO: renamed from: j0.l.a.h1, reason: use source file name */
/* JADX INFO: compiled from: OperatorPublish.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorPublish2<T> extends ConnectableObservable<T> {
    public final Observable<? extends T> k;
    public final AtomicReference<b<T>> l;

    /* JADX INFO: renamed from: j0.l.a.h1$a */
    /* JADX INFO: compiled from: OperatorPublish.java */
    public static final class a<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -4453897557930727610L;
        public final Subscriber<? super T> child;
        public final b<T> parent;

        public a(b<T> bVar, Subscriber<? super T> subscriber) {
            this.parent = bVar;
            this.child = subscriber;
            lazySet(-4611686018427387904L);
        }

        public long a(long j) {
            long j2;
            long j3;
            if (j <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j2 = get();
                if (j2 == -4611686018427387904L) {
                    throw new IllegalStateException("Produced without request");
                }
                if (j2 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j3 = j2 - j;
                if (j3 < 0) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("More produced (");
                    sb.append(j);
                    sb.append(") than requested (");
                    throw new IllegalStateException(outline.C(sb, j2, ")"));
                }
            } while (!compareAndSet(j2, j3));
            return j3;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.Producer
        public void j(long j) throws Throwable {
            long j2;
            long j3;
            if (j < 0) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && j == 0) {
                    return;
                }
                if (j2 == -4611686018427387904L) {
                    j3 = j;
                } else {
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = RecyclerView.FOREVER_NS;
                    }
                }
            } while (!compareAndSet(j2, j3));
            this.parent.b();
        }

        @Override // rx.Subscription
        public void unsubscribe() throws Throwable {
            a[] aVarArr;
            a[] aVarArr2;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            b<T> bVar = this.parent;
            do {
                aVarArr = bVar.o.get();
                if (aVarArr != b.j && aVarArr != b.k) {
                    int length = aVarArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            i = -1;
                            break;
                        } else if (aVarArr[i].equals(this)) {
                            break;
                        } else {
                            i++;
                        }
                    }
                    if (i < 0) {
                        break;
                    }
                    if (length == 1) {
                        aVarArr2 = b.j;
                    } else {
                        a[] aVarArr3 = new a[length - 1];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i);
                        System.arraycopy(aVarArr, i + 1, aVarArr3, i, (length - i) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    break;
                }
            } while (!bVar.o.compareAndSet(aVarArr, aVarArr2));
            this.parent.b();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.h1$b */
    /* JADX INFO: compiled from: OperatorPublish.java */
    public static final class b<T> extends Subscriber<T> implements Subscription {
        public static final a[] j = new a[0];
        public static final a[] k = new a[0];
        public final Queue<Object> l;
        public final AtomicReference<b<T>> m;
        public volatile Object n;
        public final AtomicReference<a[]> o;
        public final AtomicBoolean p;
        public boolean q;
        public boolean r;

        public b(AtomicReference<b<T>> atomicReference) {
            this.l = UnsafeAccess.b() ? new SpscArrayQueue<>(RxRingBuffer.j) : new SpscAtomicArrayQueue<>(RxRingBuffer.j);
            this.o = new AtomicReference<>(j);
            this.m = atomicReference;
            this.p = new AtomicBoolean();
        }

        public boolean a(Object obj, boolean z2) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.c(obj)) {
                    Throwable th = ((NotificationLite.c) obj).e;
                    this.m.compareAndSet(this, null);
                    try {
                        a[] andSet = this.o.getAndSet(k);
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].child.onError(th);
                            i++;
                        }
                        unsubscribe();
                        return true;
                    } catch (Throwable th2) {
                        unsubscribe();
                        throw th2;
                    }
                }
                if (z2) {
                    this.m.compareAndSet(this, null);
                    try {
                        a[] andSet2 = this.o.getAndSet(k);
                        int length2 = andSet2.length;
                        while (i < length2) {
                            andSet2[i].child.onCompleted();
                            i++;
                        }
                        unsubscribe();
                        return true;
                    } catch (Throwable th3) {
                        unsubscribe();
                        throw th3;
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Bottom block not found for handler: all -> 0x00de */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b() throws Throwable {
            boolean z2;
            long j2;
            synchronized (this) {
                if (this.q) {
                    this.r = true;
                    return;
                }
                this.q = true;
                this.r = false;
                while (true) {
                    try {
                        Object obj = this.n;
                        boolean zIsEmpty = this.l.isEmpty();
                        if (a(obj, zIsEmpty)) {
                            return;
                        }
                        if (!zIsEmpty) {
                            a[] aVarArr = this.o.get();
                            int length = aVarArr.length;
                            long jMin = RecyclerView.FOREVER_NS;
                            int i = 0;
                            for (a aVar : aVarArr) {
                                long j3 = aVar.get();
                                if (j3 >= 0) {
                                    jMin = Math.min(jMin, j3);
                                } else if (j3 == Long.MIN_VALUE) {
                                    i++;
                                }
                            }
                            if (length != i) {
                                int i2 = 0;
                                while (true) {
                                    j2 = i2;
                                    if (j2 >= jMin) {
                                        break;
                                    }
                                    Object obj2 = this.n;
                                    Object objPoll = this.l.poll();
                                    boolean z3 = objPoll == null;
                                    if (a(obj2, z3)) {
                                        return;
                                    }
                                    if (z3) {
                                        zIsEmpty = z3;
                                        break;
                                    }
                                    Object objB = NotificationLite.b(objPoll);
                                    for (a aVar2 : aVarArr) {
                                        if (aVar2.get() > 0) {
                                            try {
                                                aVar2.child.onNext(objB);
                                                aVar2.a(1L);
                                            } catch (Throwable th) {
                                                aVar2.unsubscribe();
                                                b.i.a.f.e.o.f.p1(th, aVar2.child, objB);
                                            }
                                        }
                                    }
                                    i2++;
                                    zIsEmpty = z3;
                                }
                                if (i2 > 0) {
                                    request(j2);
                                }
                                if (jMin == 0 || zIsEmpty) {
                                }
                            } else if (a(this.n, this.l.poll() == null)) {
                                return;
                            } else {
                                request(1L);
                            }
                        }
                        synchronized (this) {
                            try {
                                if (this.r) {
                                    this.r = false;
                                } else {
                                    this.q = false;
                                    try {
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z2 = true;
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                z2 = false;
                            }
                            while (true) {
                            }
                        }
                        try {
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z2 = false;
                    }
                    if (!z2) {
                        synchronized (this) {
                            this.q = false;
                        }
                    }
                    throw th;
                }
            }
        }

        @Override // j0.Observer2
        public void onCompleted() throws Throwable {
            if (this.n == null) {
                this.n = NotificationLite.a;
                b();
            }
        }

        @Override // j0.Observer2
        public void onError(Throwable th) throws Throwable {
            if (this.n == null) {
                this.n = new NotificationLite.c(th);
                b();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j0.Observer2
        public void onNext(T t) throws Throwable {
            Queue<Object> queue = this.l;
            Object obj = t;
            if (t == null) {
                obj = NotificationLite.f3771b;
            }
            if (queue.offer(obj)) {
                b();
                return;
            }
            MissingBackpressureException missingBackpressureException = new MissingBackpressureException();
            if (this.n == null) {
                this.n = new NotificationLite.c(missingBackpressureException);
                b();
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(RxRingBuffer.j);
        }
    }

    public OperatorPublish2(Observable.a<T> aVar, Observable<? extends T> observable, AtomicReference<b<T>> atomicReference) {
        super(aVar);
        this.k = observable;
        this.l = atomicReference;
    }

    @Override // j0.m.ConnectableObservable
    public void k0(Action1<? super Subscription> action1) {
        b<T> bVar;
        while (true) {
            bVar = this.l.get();
            if (bVar != null && !bVar.isUnsubscribed()) {
                break;
            }
            b<T> bVar2 = new b<>(this.l);
            bVar2.add(new BooleanSubscription(new OperatorPublish3(bVar2)));
            if (this.l.compareAndSet(bVar, bVar2)) {
                bVar = bVar2;
                break;
            }
        }
        boolean z2 = !bVar.p.get() && bVar.p.compareAndSet(false, true);
        ((OnSubscribeRefCount4) action1).call(bVar);
        if (z2) {
            this.k.i0(bVar);
        }
    }
}
