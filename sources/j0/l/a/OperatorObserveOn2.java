package j0.l.a;

import j0.l.c.TrampolineScheduler;
import j0.l.e.RxRingBuffer;
import j0.l.e.n.SpscAtomicArrayQueue;
import j0.l.e.o.SpscArrayQueue;
import j0.l.e.o.UnsafeAccess;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.z0, reason: use source file name */
/* JADX INFO: compiled from: OperatorObserveOn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OperatorObserveOn2<T> implements Observable.b<T, T> {
    public final Scheduler j;
    public final boolean k;
    public final int l;

    /* JADX INFO: renamed from: j0.l.a.z0$a */
    /* JADX INFO: compiled from: OperatorObserveOn.java */
    public static final class a<T> extends Subscriber<T> implements Action0 {
        public final Subscriber<? super T> j;
        public final Scheduler.Worker k;
        public final boolean l;
        public final Queue<Object> m;
        public final int n;
        public volatile boolean o;
        public final AtomicLong p = new AtomicLong();
        public final AtomicLong q = new AtomicLong();
        public Throwable r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public long f3784s;

        public a(Scheduler scheduler, Subscriber<? super T> subscriber, boolean z2, int i) {
            this.j = subscriber;
            this.k = scheduler.a();
            this.l = z2;
            i = i <= 0 ? RxRingBuffer.j : i;
            this.n = i - (i >> 2);
            if (UnsafeAccess.b()) {
                this.m = new SpscArrayQueue(i);
            } else {
                this.m = new SpscAtomicArrayQueue(i);
            }
            request(i);
        }

        public boolean a(boolean z2, boolean z3, Subscriber<? super T> subscriber, Queue<Object> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                return true;
            }
            if (!z2) {
                return false;
            }
            if (this.l) {
                if (!z3) {
                    return false;
                }
                Throwable th = this.r;
                try {
                    if (th != null) {
                        subscriber.onError(th);
                    } else {
                        subscriber.onCompleted();
                    }
                    this.k.unsubscribe();
                    return false;
                } catch (Throwable th2) {
                    this.k.unsubscribe();
                    throw th2;
                }
            }
            Throwable th3 = this.r;
            if (th3 != null) {
                queue.clear();
                try {
                    subscriber.onError(th3);
                    return true;
                } finally {
                    this.k.unsubscribe();
                }
            }
            if (!z3) {
                return false;
            }
            try {
                subscriber.onCompleted();
                return true;
            } finally {
                this.k.unsubscribe();
            }
        }

        public void b() {
            if (this.q.getAndIncrement() == 0) {
                this.k.a(this);
            }
        }

        @Override // rx.functions.Action0
        public void call() {
            long j = this.f3784s;
            Queue<Object> queue = this.m;
            Subscriber<? super T> subscriber = this.j;
            long jAddAndGet = 1;
            do {
                long jU0 = this.p.get();
                while (jU0 != j) {
                    boolean z2 = this.o;
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (a(z2, z3, subscriber, queue)) {
                        return;
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext((Object) NotificationLite.b(objPoll));
                    j++;
                    if (j == this.n) {
                        jU0 = b.i.a.f.e.o.f.U0(this.p, j);
                        request(j);
                        j = 0;
                    }
                }
                if (jU0 == j && a(this.o, queue.isEmpty(), subscriber, queue)) {
                    return;
                }
                this.f3784s = j;
                jAddAndGet = this.q.addAndGet(-jAddAndGet);
            } while (jAddAndGet != 0);
        }

        @Override // j0.Observer2
        public void onCompleted() {
            if (isUnsubscribed() || this.o) {
                return;
            }
            this.o = true;
            b();
        }

        @Override // j0.Observer2
        public void onError(Throwable th) {
            if (isUnsubscribed() || this.o) {
                j0.o.l.b(th);
                return;
            }
            this.r = th;
            this.o = true;
            b();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j0.Observer2
        public void onNext(T t) {
            Object obj;
            if (isUnsubscribed() || this.o) {
                return;
            }
            Queue<Object> queue = this.m;
            if (t == null) {
                obj = t;
                obj = NotificationLite.f3771b;
            }
            obj = t;
            if (queue.offer(obj)) {
                b();
            } else {
                onError(new MissingBackpressureException());
            }
        }
    }

    public OperatorObserveOn2(Scheduler scheduler, boolean z2, int i) {
        this.j = scheduler;
        this.k = z2;
        this.l = i <= 0 ? RxRingBuffer.j : i;
    }

    @Override // j0.k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        Scheduler scheduler = this.j;
        if (scheduler instanceof TrampolineScheduler) {
            return subscriber;
        }
        a aVar = new a(scheduler, subscriber, this.k, this.l);
        Subscriber<? super T> subscriber2 = aVar.j;
        subscriber2.setProducer(new OperatorObserveOn(aVar));
        subscriber2.add(aVar.k);
        subscriber2.add(aVar);
        return aVar;
    }
}
