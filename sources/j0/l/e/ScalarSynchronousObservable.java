package j0.l.e;

import b.d.b.a.outline;
import j0.k.Func1;
import j0.l.b.SingleProducer;
import j0.l.c.EventLoopsScheduler;
import j0.n.Subscribers2;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.e.k, reason: use source file name */
/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ScalarSynchronousObservable<T> extends Observable<T> {
    public static final boolean k = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();
    public final T l;

    /* JADX INFO: renamed from: j0.l.e.k$a */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public class a implements Func1<Action0, Subscription> {
        public final /* synthetic */ EventLoopsScheduler j;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, EventLoopsScheduler eventLoopsScheduler) {
            this.j = eventLoopsScheduler;
        }

        @Override // j0.k.Func1
        public Subscription call(Action0 action0) {
            return this.j.e.get().a().f(action0, -1L, TimeUnit.NANOSECONDS);
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$b */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public class b implements Func1<Action0, Subscription> {
        public final /* synthetic */ Scheduler j;

        public b(ScalarSynchronousObservable scalarSynchronousObservable, Scheduler scheduler) {
            this.j = scheduler;
        }

        @Override // j0.k.Func1
        public Subscription call(Action0 action0) {
            Scheduler.Worker workerA = this.j.a();
            workerA.a(new ScalarSynchronousObservable2(this, action0, workerA));
            return workerA;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: j0.l.e.k$c */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public class c<R> implements Observable.a<R> {
        public final /* synthetic */ Func1 j;

        public c(Func1 func1) {
            this.j = func1;
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            Observable observable = (Observable) this.j.call(ScalarSynchronousObservable.this.l);
            if (!(observable instanceof ScalarSynchronousObservable)) {
                observable.i0(new Subscribers2(subscriber, subscriber));
            } else {
                T t = ((ScalarSynchronousObservable) observable).l;
                subscriber.setProducer(ScalarSynchronousObservable.k ? new SingleProducer(subscriber, t) : new g(subscriber, t));
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$d */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public static final class d<T> implements Observable.a<T> {
        public final T j;

        public d(T t) {
            this.j = t;
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            T t = this.j;
            subscriber.setProducer(ScalarSynchronousObservable.k ? new SingleProducer(subscriber, t) : new g(subscriber, t));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$e */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public static final class e<T> implements Observable.a<T> {
        public final T j;
        public final Func1<Action0, Subscription> k;

        public e(T t, Func1<Action0, Subscription> func1) {
            this.j = t;
            this.k = func1;
        }

        @Override // rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            subscriber.setProducer(new f(subscriber, this.j, this.k));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$f */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public static final class f<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;
        public final Subscriber<? super T> actual;
        public final Func1<Action0, Subscription> onSchedule;
        public final T value;

        public f(Subscriber<? super T> subscriber, T t, Func1<Action0, Subscription> func1) {
            this.actual = subscriber;
            this.value = t;
            this.onSchedule = func1;
        }

        @Override // rx.functions.Action0
        public void call() {
            Subscriber<? super T> subscriber = this.actual;
            if (subscriber.isUnsubscribed()) {
                return;
            }
            T t = this.value;
            try {
                subscriber.onNext(t);
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onCompleted();
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, subscriber, t);
            }
        }

        @Override // rx.Producer
        public void j(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(outline.t("n >= 0 required but it was ", j));
            }
            if (j == 0 || !compareAndSet(false, true)) {
                return;
            }
            this.actual.add(this.onSchedule.call(this));
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            StringBuilder sbU = outline.U("ScalarAsyncProducer[");
            sbU.append(this.value);
            sbU.append(", ");
            sbU.append(get());
            sbU.append("]");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$g */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public static final class g<T> implements Producer {
        public final Subscriber<? super T> j;
        public final T k;
        public boolean l;

        public g(Subscriber<? super T> subscriber, T t) {
            this.j = subscriber;
            this.k = t;
        }

        @Override // rx.Producer
        public void j(long j) {
            if (this.l) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException(outline.t("n >= required but it was ", j));
            }
            if (j == 0) {
                return;
            }
            this.l = true;
            Subscriber<? super T> subscriber = this.j;
            if (subscriber.isUnsubscribed()) {
                return;
            }
            T t = this.k;
            try {
                subscriber.onNext(t);
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onCompleted();
            } catch (Throwable th) {
                b.i.a.f.e.o.f.p1(th, subscriber, t);
            }
        }
    }

    public ScalarSynchronousObservable(T t) {
        super(j0.o.l.a(new d(t)));
        this.l = t;
    }

    public <R> Observable<R> k0(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return Observable.h0(new c(func1));
    }

    public Observable<T> l0(Scheduler scheduler) {
        return Observable.h0(new e(this.l, scheduler instanceof EventLoopsScheduler ? new a(this, (EventLoopsScheduler) scheduler) : new b(this, scheduler)));
    }
}
