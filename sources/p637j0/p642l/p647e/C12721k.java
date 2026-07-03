package p637j0.p642l.p647e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p644b.C12695c;
import p637j0.p642l.p645c.C12697b;
import p637j0.p651n.C12762e;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.e.k */
/* JADX INFO: compiled from: ScalarSynchronousObservable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12721k<T> extends Observable<T> {

    /* JADX INFO: renamed from: k */
    public static final boolean f27287k = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* JADX INFO: renamed from: l */
    public final T f27288l;

    /* JADX INFO: renamed from: j0.l.e.k$a */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public class a implements InterfaceC12589b<Action0, Subscription> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ C12697b f27289j;

        public a(C12721k c12721k, C12697b c12697b) {
            this.f27289j = c12697b;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public Subscription call(Action0 action0) {
            return this.f27289j.f27191e.get().m10801a().m10805f(action0, -1L, TimeUnit.NANOSECONDS);
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$b */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public class b implements InterfaceC12589b<Action0, Subscription> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ Scheduler f27290j;

        public b(C12721k c12721k, Scheduler scheduler) {
            this.f27290j = scheduler;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public Subscription call(Action0 action0) {
            Scheduler.Worker workerMo10739a = this.f27290j.mo10739a();
            workerMo10739a.mo10740a(new C12722l(this, action0, workerMo10739a));
            return workerMo10739a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: j0.l.e.k$c */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public class c<R> implements Observable.InterfaceC13005a<R> {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ InterfaceC12589b f27291j;

        public c(InterfaceC12589b interfaceC12589b) {
            this.f27291j = interfaceC12589b;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            Observable observable = (Observable) this.f27291j.call(C12721k.this.f27288l);
            if (!(observable instanceof C12721k)) {
                observable.m11107i0(new C12762e(subscriber, subscriber));
            } else {
                T t = ((C12721k) observable).f27288l;
                subscriber.setProducer(C12721k.f27287k ? new C12695c(subscriber, t) : new g(subscriber, t));
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$d */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public static final class d<T> implements Observable.InterfaceC13005a<T> {

        /* JADX INFO: renamed from: j */
        public final T f27293j;

        public d(T t) {
            this.f27293j = t;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            T t = this.f27293j;
            subscriber.setProducer(C12721k.f27287k ? new C12695c(subscriber, t) : new g(subscriber, t));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$e */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public static final class e<T> implements Observable.InterfaceC13005a<T> {

        /* JADX INFO: renamed from: j */
        public final T f27294j;

        /* JADX INFO: renamed from: k */
        public final InterfaceC12589b<Action0, Subscription> f27295k;

        public e(T t, InterfaceC12589b<Action0, Subscription> interfaceC12589b) {
            this.f27294j = t;
            this.f27295k = interfaceC12589b;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            subscriber.setProducer(new f(subscriber, this.f27294j, this.f27295k));
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$f */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public static final class f<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;
        public final Subscriber<? super T> actual;
        public final InterfaceC12589b<Action0, Subscription> onSchedule;
        public final T value;

        public f(Subscriber<? super T> subscriber, T t, InterfaceC12589b<Action0, Subscription> interfaceC12589b) {
            this.actual = subscriber;
            this.value = t;
            this.onSchedule = interfaceC12589b;
        }

        @Override // p658rx.functions.Action0
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
                C3404f.m4329p1(th, subscriber, t);
            }
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(C1643a.m877t("n >= 0 required but it was ", j));
            }
            if (j == 0 || !compareAndSet(false, true)) {
                return;
            }
            this.actual.add(this.onSchedule.call(this));
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ScalarAsyncProducer[");
            sbM833U.append(this.value);
            sbM833U.append(", ");
            sbM833U.append(get());
            sbM833U.append("]");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: j0.l.e.k$g */
    /* JADX INFO: compiled from: ScalarSynchronousObservable.java */
    public static final class g<T> implements Producer {

        /* JADX INFO: renamed from: j */
        public final Subscriber<? super T> f27296j;

        /* JADX INFO: renamed from: k */
        public final T f27297k;

        /* JADX INFO: renamed from: l */
        public boolean f27298l;

        public g(Subscriber<? super T> subscriber, T t) {
            this.f27296j = subscriber;
            this.f27297k = t;
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public void mo10704j(long j) {
            if (this.f27298l) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException(C1643a.m877t("n >= required but it was ", j));
            }
            if (j == 0) {
                return;
            }
            this.f27298l = true;
            Subscriber<? super T> subscriber = this.f27296j;
            if (subscriber.isUnsubscribed()) {
                return;
            }
            T t = this.f27297k;
            try {
                subscriber.onNext(t);
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onCompleted();
            } catch (Throwable th) {
                C3404f.m4329p1(th, subscriber, t);
            }
        }
    }

    public C12721k(T t) {
        super(C12774l.m10862a(new d(t)));
        this.f27288l = t;
    }

    /* JADX INFO: renamed from: k0 */
    public <R> Observable<R> m10820k0(InterfaceC12589b<? super T, ? extends Observable<? extends R>> interfaceC12589b) {
        return Observable.m11074h0(new c(interfaceC12589b));
    }

    /* JADX INFO: renamed from: l0 */
    public Observable<T> m10821l0(Scheduler scheduler) {
        return Observable.m11074h0(new e(this.f27288l, scheduler instanceof C12697b ? new a(this, (C12697b) scheduler) : new b(this, scheduler)));
    }
}
